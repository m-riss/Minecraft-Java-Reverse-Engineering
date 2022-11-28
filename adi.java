import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class adi {
   private static final DynamicCommandExceptionType a = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.locate.structure.not_found", $$0);
   });
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.locate.structure.invalid", $$0);
   });
   private static final DynamicCommandExceptionType c = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.locate.biome.not_found", $$0);
   });
   private static final DynamicCommandExceptionType d = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.locate.biome.invalid", $$0);
   });
   private static final DynamicCommandExceptionType e = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.locate.poi.not_found", $$0);
   });
   private static final DynamicCommandExceptionType f = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.locate.poi.invalid", $$0);
   });
   private static final int g = 100;
   private static final int h = 6400;
   private static final int i = 32;
   private static final int j = 64;
   private static final int k = 256;

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("locate").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("structure").then(ds.a((String)"structure", (ArgumentType)er.a(hm.aN)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), er.a($$0x, "structure", hm.aN, b));
      })))).then(ds.a("biome").then(ds.a((String)"biome", (ArgumentType)er.a(hm.aR)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), er.a($$0x, "biome", hm.aR, d));
      })))).then(ds.a("poi").then(ds.a((String)"poi", (ArgumentType)er.a(hm.C)).executes(($$0x) -> {
         return c((dr)$$0x.getSource(), er.a($$0x, "poi", hm.C, f));
      }))));
   }

   private static Optional<? extends he.b<dlb>> a(er.c<dlb> $$0, hm<dlb> $$1) {
      Either var10000 = $$0.a();
      Function var10001 = ($$1x) -> {
         return $$1.b($$1x).map(($$0) -> {
            return he.a($$0);
         });
      };
      Objects.requireNonNull($$1);
      return (Optional)var10000.map(var10001, $$1::c);
   }

   private static int a(dr $$0, er.c<dlb> $$1) throws CommandSyntaxException {
      hm<dlb> $$2 = $$0.f().s().d(hm.aN);
      he<dlb> $$3 = (he)a($$1, $$2).orElseThrow(() -> {
         return b.create($$1.b());
      });
      gt $$4 = new gt($$0.e());
      agg $$5 = $$0.f();
      Pair<gt, hc<dlb>> $$6 = $$5.k().g().a($$5, $$3, $$4, 100, false);
      if ($$6 == null) {
         throw a.create($$1.b());
      } else {
         return a($$0, $$1, $$4, $$6, "commands.locate.structure.success", false);
      }
   }

   private static int b(dr $$0, er.c<cht> $$1) throws CommandSyntaxException {
      gt $$2 = new gt($$0.e());
      Pair<gt, hc<cht>> $$3 = $$0.f().a($$1, $$2, 6400, 32, 64);
      if ($$3 == null) {
         throw c.create($$1.b());
      } else {
         return a($$0, $$1, $$2, $$3, "commands.locate.biome.success", true);
      }
   }

   private static int c(dr $$0, er.c<bmv> $$1) throws CommandSyntaxException {
      gt $$2 = new gt($$0.e());
      agg $$3 = $$0.f();
      Optional<Pair<hc<bmv>, gt>> $$4 = $$3.x().e($$1, $$2, 256, bms.b.c);
      if ($$4.isEmpty()) {
         throw e.create($$1.b());
      } else {
         return a($$0, $$1, $$2, ((Pair)$$4.get()).swap(), "commands.locate.poi.success", false);
      }
   }

   public static int a(dr $$0, er.c<?> $$1, gt $$2, Pair<gt, ? extends hc<?>> $$3, String $$4, boolean $$5) {
      gt $$6 = (gt)$$3.getFirst();
      String $$7 = (String)$$1.a().map(($$0x) -> {
         return $$0x.a().toString();
      }, ($$1x) -> {
         abb var10000 = $$1x.b();
         return "#" + var10000 + " (" + (String)((hc)$$3.getSecond()).e().map(($$0) -> {
            return $$0.a().toString();
         }).orElse("[unregistered]") + ")";
      });
      int $$8 = $$5 ? ami.d(ami.c((float)$$2.j($$6))) : ami.d(a($$2.u(), $$2.w(), $$6.u(), $$6.w()));
      String $$9 = $$5 ? String.valueOf($$6.v()) : "~";
      rq $$10 = rs.a((rq)rq.a("chat.coordinates", $$6.u(), $$9, $$6.w())).a(($$2x) -> {
         return $$2x.a(p.k).a(new ro(ro.a.d, "/tp @s " + $$6.u() + " " + $$9 + " " + $$6.w())).a(new rv(rv.a.a, rq.c("chat.coordinates.tooltip")));
      });
      $$0.a(rq.a($$4, $$7, $$10, $$8), false);
      return $$8;
   }

   private static float a(int $$0, int $$1, int $$2, int $$3) {
      int $$4 = $$2 - $$0;
      int $$5 = $$3 - $$1;
      return ami.c((float)($$4 * $$4 + $$5 * $$5));
   }
}
