import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.List;
import java.util.function.Function;

public class adh {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("list").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      })).then(ds.a("uuids").executes(($$0x) -> {
         return b((dr)$$0x.getSource());
      })));
   }

   private static int a(dr $$0) {
      return a($$0, buc::C_);
   }

   private static int b(dr $$0) {
      return a($$0, ($$0x) -> {
         return rq.a("commands.list.nameAndId", $$0x.X(), $$0x.fy().getId());
      });
   }

   private static int a(dr $$0, Function<agh, rq> $$1) {
      aiz $$2 = $$0.m().ac();
      List<agh> $$3 = $$2.t();
      rq $$4 = rs.b($$3, $$1);
      $$0.a(rq.a("commands.list.players", $$3.size(), $$2.n(), $$4), false);
      return $$3.size();
   }
}
