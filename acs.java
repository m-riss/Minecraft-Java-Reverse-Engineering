import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class acs {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)ds.a("me").then(ds.a((String)"action", (ArgumentType)ef.a()).executes(($$0x) -> {
         ef.a $$1 = ef.b($$0x, "action");
         dr $$2 = (dr)$$0x.getSource();
         aiz $$3 = $$2.m().ac();
         $$1.a($$2, ($$2x) -> {
            $$3.a($$2x, $$2, rm.a(rm.i, $$2));
         });
         return 1;
      })));
   }
}
