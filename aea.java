import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class aea {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("say").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"message", (ArgumentType)ef.a()).executes(($$0x) -> {
         ef.a $$1 = ef.b($$0x, "message");
         dr $$2 = (dr)$$0x.getSource();
         aiz $$3 = $$2.m().ac();
         $$1.a($$2, ($$2x) -> {
            $$3.a($$2x, $$2, rm.a(rm.d, $$2));
         });
         return 1;
      })));
   }
}
