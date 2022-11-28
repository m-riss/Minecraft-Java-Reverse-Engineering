import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.Iterator;

public class aes {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("time").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("set").then(ds.a("day").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), 1000);
      }))).then(ds.a("noon").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), 6000);
      }))).then(ds.a("night").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), 13000);
      }))).then(ds.a("midnight").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), 18000);
      }))).then(ds.a((String)"time", (ArgumentType)fa.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "time"));
      })))).then(ds.a("add").then(ds.a((String)"time", (ArgumentType)fa.a()).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "time"));
      })))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("query").then(ds.a("daytime").executes(($$0x) -> {
         return c((dr)$$0x.getSource(), a(((dr)$$0x.getSource()).f()));
      }))).then(ds.a("gametime").executes(($$0x) -> {
         return c((dr)$$0x.getSource(), (int)(((dr)$$0x.getSource()).f().U() % 2147483647L));
      }))).then(ds.a("day").executes(($$0x) -> {
         return c((dr)$$0x.getSource(), (int)(((dr)$$0x.getSource()).f().V() / 24000L % 2147483647L));
      }))));
   }

   private static int a(agg $$0) {
      return (int)($$0.V() % 24000L);
   }

   private static int c(dr $$0, int $$1) {
      $$0.a(rq.a("commands.time.query", $$1), false);
      return $$1;
   }

   public static int a(dr $$0, int $$1) {
      Iterator var2 = $$0.m().E().iterator();

      while(var2.hasNext()) {
         agg $$2 = (agg)var2.next();
         $$2.b((long)$$1);
      }

      $$0.a(rq.a("commands.time.set", $$1), true);
      return a($$0.f());
   }

   public static int b(dr $$0, int $$1) {
      Iterator var2 = $$0.m().E().iterator();

      while(var2.hasNext()) {
         agg $$2 = (agg)var2.next();
         $$2.b($$2.V() + (long)$$1);
      }

      int $$3 = a($$0.f());
      $$0.a(rq.a("commands.time.set", $$3), true);
      return $$3;
   }
}
