import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class acz {
   public static final int a = 2;

   public static void a(CommandDispatcher<dr> $$0) {
      LiteralArgumentBuilder<dr> $$1 = (LiteralArgumentBuilder)ds.a("gamemode").requires(($$0x) -> {
         return $$0x.c(2);
      });
      cgu[] var2 = cgu.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         cgu $$2 = var2[var4];
         $$1.then(((LiteralArgumentBuilder)ds.a($$2.b()).executes(($$1x) -> {
            return a((CommandContext)$$1x, (Collection)Collections.singleton(((dr)$$1x.getSource()).i()), $$2);
         })).then(ds.a((String)"target", (ArgumentType)eb.d()).executes(($$1x) -> {
            return a($$1x, eb.f($$1x, "target"), $$2);
         })));
      }

      $$0.register($$1);
   }

   private static void a(dr $$0, agh $$1, cgu $$2) {
      rq $$3 = rq.c("gameMode." + $$2.b());
      if ($$0.g() == $$1) {
         $$0.a(rq.a("commands.gamemode.success.self", $$3), true);
      } else {
         if ($$0.f().W().b(cgt.o)) {
            $$1.a((rq)rq.a("gameMode.changed", $$3));
         }

         $$0.a(rq.a("commands.gamemode.success.other", $$1.C_(), $$3), true);
      }

   }

   private static int a(CommandContext<dr> $$0, Collection<agh> $$1, cgu $$2) {
      int $$3 = 0;
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         agh $$4 = (agh)var4.next();
         if ($$4.a($$2)) {
            a((dr)$$0.getSource(), $$4, $$2);
            ++$$3;
         }
      }

      return $$3;
   }
}
