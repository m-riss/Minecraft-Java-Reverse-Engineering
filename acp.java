import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public class acp {
   public static void a(CommandDispatcher<dr> $$0) {
      LiteralArgumentBuilder<dr> $$1 = (LiteralArgumentBuilder)ds.a("defaultgamemode").requires(($$0x) -> {
         return $$0x.c(2);
      });
      cgu[] var2 = cgu.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         cgu $$2 = var2[var4];
         $$1.then(ds.a($$2.b()).executes(($$1x) -> {
            return a((dr)$$1x.getSource(), $$2);
         }));
      }

      $$0.register($$1);
   }

   private static int a(dr $$0, cgu $$1) {
      int $$2 = 0;
      MinecraftServer $$3 = $$0.m();
      $$3.a($$1);
      cgu $$4 = $$3.aY();
      if ($$4 != null) {
         Iterator var5 = $$3.ac().t().iterator();

         while(var5.hasNext()) {
            agh $$5 = (agh)var5.next();
            if ($$5.a($$4)) {
               ++$$2;
            }
         }
      }

      $$0.a(rq.a("commands.defaultgamemode.success", $$1.c()), true);
      return $$2;
   }
}
