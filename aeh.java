import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;

public class aeh {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("setworldspawn").requires(($$0x) -> {
         return $$0x.c(2);
      })).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), new gt(((dr)$$0x.getSource()).e()), 0.0F);
      })).then(((RequiredArgumentBuilder)ds.a((String)"pos", (ArgumentType)fh.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.b($$0x, "pos"), 0.0F);
      })).then(ds.a((String)"angle", (ArgumentType)du.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.b($$0x, "pos"), du.a($$0x, "angle"));
      }))));
   }

   private static int a(dr $$0, gt $$1, float $$2) {
      $$0.f().a($$1, $$2);
      $$0.a(rq.a("commands.setworldspawn.success", $$1.u(), $$1.v(), $$1.w(), $$2), true);
      return 1;
   }
}
