import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class aef {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("setidletimeout").requires(($$0x) -> {
         return $$0x.c(3);
      })).then(ds.a((String)"minutes", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "minutes"));
      })));
   }

   private static int a(dr $$0, int $$1) {
      $$0.m().c($$1);
      $$0.a(rq.a("commands.setidletimeout.success", $$1), true);
      return $$1;
   }
}
