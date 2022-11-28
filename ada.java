import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

public class ada {
   public static void a(CommandDispatcher<dr> $$0) {
      final LiteralArgumentBuilder<dr> $$1 = (LiteralArgumentBuilder)ds.a("gamerule").requires(($$0x) -> {
         return $$0x.c(2);
      });
      cgt.a(new cgt.c() {
         public <T extends cgt.g<T>> void a(cgt.e<T> $$0, cgt.f<T> $$1x) {
            $$1.then(((LiteralArgumentBuilder)ds.a($$0.a()).executes(($$1xx) -> {
               return ada.a((dr)$$1xx.getSource(), $$0);
            })).then($$1x.a("value").executes(($$1xx) -> {
               return ada.a($$1xx, $$0);
            })));
         }
      });
      $$0.register($$1);
   }

   static <T extends cgt.g<T>> int a(CommandContext<dr> $$0, cgt.e<T> $$1) {
      dr $$2 = (dr)$$0.getSource();
      T $$3 = $$2.m().aK().a($$1);
      $$3.b($$0, "value");
      $$2.a(rq.a("commands.gamerule.set", $$1.a(), $$3.toString()), true);
      return $$3.c();
   }

   static <T extends cgt.g<T>> int a(dr $$0, cgt.e<T> $$1) {
      T $$2 = $$0.m().aK().a($$1);
      $$0.a(rq.a("commands.gamerule.query", $$1.a(), $$2.toString()), false);
      return $$2.c();
   }
}
