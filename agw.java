import com.mojang.logging.LogUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class agw extends ChannelInboundHandlerAdapter {
   private static final Logger b = LogUtils.getLogger();
   public static final int a = 127;
   private final agy c;

   public agw(agy $$0) {
      this.c = $$0;
   }

   public void channelRead(ChannelHandlerContext $$0, Object $$1) {
      ByteBuf $$2 = (ByteBuf)$$1;
      $$2.markReaderIndex();
      boolean $$3 = true;

      try {
         try {
            if ($$2.readUnsignedByte() != 254) {
               return;
            }

            InetSocketAddress $$4 = (InetSocketAddress)$$0.channel().remoteAddress();
            MinecraftServer $$5 = this.c.d();
            int $$6 = $$2.readableBytes();
            String $$8;
            switch($$6) {
            case 0:
               b.debug("Ping: (<1.3.x) from {}:{}", $$4.getAddress(), $$4.getPort());
               $$8 = String.format(Locale.ROOT, "%s§%d§%d", $$5.Z(), $$5.G(), $$5.H());
               this.a($$0, this.a($$8));
               break;
            case 1:
               if ($$2.readUnsignedByte() != 1) {
                  return;
               }

               b.debug("Ping: (1.4-1.5.x) from {}:{}", $$4.getAddress(), $$4.getPort());
               $$8 = String.format(Locale.ROOT, "§1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, $$5.F(), $$5.Z(), $$5.G(), $$5.H());
               this.a($$0, this.a($$8));
               break;
            default:
               boolean $$9 = $$2.readUnsignedByte() == 1;
               $$9 &= $$2.readUnsignedByte() == 250;
               $$9 &= "MC|PingHost".equals(new String($$2.readBytes($$2.readShort() * 2).array(), StandardCharsets.UTF_16BE));
               int $$10 = $$2.readUnsignedShort();
               $$9 &= $$2.readUnsignedByte() >= 73;
               $$9 &= 3 + $$2.readBytes($$2.readShort() * 2).array().length + 4 == $$10;
               $$9 &= $$2.readInt() <= 65535;
               $$9 &= $$2.readableBytes() == 0;
               if (!$$9) {
                  return;
               }

               b.debug("Ping: (1.6) from {}:{}", $$4.getAddress(), $$4.getPort());
               String $$11 = String.format(Locale.ROOT, "§1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, $$5.F(), $$5.Z(), $$5.G(), $$5.H());
               ByteBuf $$12 = this.a($$11);

               try {
                  this.a($$0, $$12);
               } finally {
                  $$12.release();
               }
            }

            $$2.release();
            $$3 = false;
         } catch (RuntimeException var21) {
         }

      } finally {
         if ($$3) {
            $$2.resetReaderIndex();
            $$0.channel().pipeline().remove("legacy_query");
            $$0.fireChannelRead($$1);
         }

      }
   }

   private void a(ChannelHandlerContext $$0, ByteBuf $$1) {
      $$0.pipeline().firstContext().writeAndFlush($$1).addListener(ChannelFutureListener.CLOSE);
   }

   private ByteBuf a(String $$0) {
      ByteBuf $$1 = Unpooled.buffer();
      $$1.writeByte(255);
      char[] $$2 = $$0.toCharArray();
      $$1.writeShort($$2.length);
      char[] var4 = $$2;
      int var5 = $$2.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         char $$3 = var4[var6];
         $$1.writeChar($$3);
      }

      return $$1;
   }
}
