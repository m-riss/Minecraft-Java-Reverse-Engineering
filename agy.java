import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mojang.logging.LogUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class agy {
   private static final Logger d = LogUtils.getLogger();
   public static final amd<NioEventLoopGroup> a = new amd(() -> {
      return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
   });
   public static final amd<EpollEventLoopGroup> b = new amd(() -> {
      return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Server IO #%d").setDaemon(true).build());
   });
   final MinecraftServer e;
   public volatile boolean c;
   private final List<ChannelFuture> f = Collections.synchronizedList(Lists.newArrayList());
   final List<qv> g = Collections.synchronizedList(Lists.newArrayList());

   public agy(MinecraftServer $$0) {
      this.e = $$0;
      this.c = true;
   }

   public void a(@Nullable InetAddress $$0, int $$1) throws IOException {
      synchronized(this.f) {
         Class $$4;
         amd $$5;
         if (Epoll.isAvailable() && this.e.m()) {
            $$4 = EpollServerSocketChannel.class;
            $$5 = b;
            d.info("Using epoll channel type");
         } else {
            $$4 = NioServerSocketChannel.class;
            $$5 = a;
            d.info("Using default channel type");
         }

         this.f.add(((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel($$4)).childHandler(new ChannelInitializer<Channel>() {
            protected void initChannel(Channel $$0) {
               try {
                  $$0.config().setOption(ChannelOption.TCP_NODELAY, true);
               } catch (ChannelException var4) {
               }

               $$0.pipeline().addLast("timeout", new ReadTimeoutHandler(30)).addLast("legacy_query", new agw(agy.this)).addLast("splitter", new rf()).addLast("decoder", new qy(td.a)).addLast("prepender", new rg()).addLast("encoder", new qz(td.b));
               int $$1 = agy.this.e.l();
               qv $$2 = $$1 > 0 ? new rc($$1) : new qv(td.a);
               agy.this.g.add($$2);
               $$0.pipeline().addLast("packet_handler", (ChannelHandler)$$2);
               ((qv)$$2).a((ra)(new aha(agy.this.e, (qv)$$2)));
            }
         }).group((EventLoopGroup)$$5.a()).localAddress($$0, $$1)).bind().syncUninterruptibly());
      }
   }

   public SocketAddress a() {
      ChannelFuture $$1;
      synchronized(this.f) {
         $$1 = ((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(LocalServerChannel.class)).childHandler(new ChannelInitializer<Channel>() {
            protected void initChannel(Channel $$0) {
               qv $$1 = new qv(td.a);
               $$1.a((ra)(new agx(agy.this.e, $$1)));
               agy.this.g.add($$1);
               $$0.pipeline().addLast("packet_handler", $$1);
            }
         }).group((EventLoopGroup)a.a()).localAddress(LocalAddress.ANY)).bind().syncUninterruptibly();
         this.f.add($$1);
      }

      return $$1.channel().localAddress();
   }

   public void b() {
      this.c = false;
      Iterator var1 = this.f.iterator();

      while(var1.hasNext()) {
         ChannelFuture $$0 = (ChannelFuture)var1.next();

         try {
            $$0.channel().close().sync();
         } catch (InterruptedException var4) {
            d.error("Interrupted whilst closing channel");
         }
      }

   }

   public void c() {
      synchronized(this.g) {
         Iterator $$0 = this.g.iterator();

         while(true) {
            while(true) {
               qv $$1;
               do {
                  if (!$$0.hasNext()) {
                     return;
                  }

                  $$1 = (qv)$$0.next();
               } while($$1.i());

               if ($$1.h()) {
                  try {
                     $$1.a();
                  } catch (Exception var7) {
                     if ($$1.d()) {
                        throw new z(q.a(var7, "Ticking memory connection"));
                     }

                     d.warn("Failed to handle packet for {}", $$1.c(), var7);
                     rq $$3 = rq.b("Internal server error");
                     $$1.a((tc)(new uf($$3)), (rb)rb.a(() -> {
                        $$1.a($$3);
                     }));
                     $$1.l();
                  }
               } else {
                  $$0.remove();
                  $$1.m();
               }
            }
         }
      }
   }

   public MinecraftServer d() {
      return this.e;
   }

   public List<qv> e() {
      return this.g;
   }

   static class a extends ChannelInboundHandlerAdapter {
      private static final Timer a = new HashedWheelTimer();
      private final int b;
      private final int c;
      private final List<agy.a.a> d = Lists.newArrayList();

      public a(int $$0, int $$1) {
         this.b = $$0;
         this.c = $$1;
      }

      public void channelRead(ChannelHandlerContext $$0, Object $$1) {
         this.a($$0, $$1);
      }

      private void a(ChannelHandlerContext $$0, Object $$1) {
         int $$2 = this.b + (int)(Math.random() * (double)this.c);
         this.d.add(new agy.a.a($$0, $$1));
         a.newTimeout(this::a, (long)$$2, TimeUnit.MILLISECONDS);
      }

      private void a(Timeout $$0) {
         agy.a.a $$1 = (agy.a.a)this.d.remove(0);
         $$1.a.fireChannelRead($$1.b);
      }

      private static class a {
         public final ChannelHandlerContext a;
         public final Object b;

         public a(ChannelHandlerContext $$0, Object $$1) {
            this.a = $$0;
            this.b = $$1;
         }
      }
   }
}
