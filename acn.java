import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class acn {
   public static void a(CommandDispatcher<dr> $$0) {
      LiteralArgumentBuilder<dr> $$1 = (LiteralArgumentBuilder)ds.a("debugmobspawning").requires(($$0x) -> {
         return $$0x.c(2);
      });
      bcf[] var2 = bcf.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         bcf $$2 = var2[var4];
         $$1.then(ds.a($$2.a()).then(ds.a((String)"at", (ArgumentType)fh.a()).executes(($$1x) -> {
            return a((dr)$$1x.getSource(), $$2, fh.a($$1x, "at"));
         })));
      }

      $$0.register($$1);
   }

   private static int a(dr $$0, bcf $$1, gt $$2) {
      chi.a($$1, $$0.f(), $$2);
      return 1;
   }
}
