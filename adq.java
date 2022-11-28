import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import java.util.Optional;

public class adq {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.place.feature.failed"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.place.jigsaw.failed"));
   private static final SimpleCommandExceptionType c = new SimpleCommandExceptionType(rq.c("commands.place.structure.failed"));
   private static final DynamicCommandExceptionType d = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.place.template.invalid", $$0);
   });
   private static final SimpleCommandExceptionType e = new SimpleCommandExceptionType(rq.c("commands.place.template.failed"));
   private static final SuggestionProvider<dr> f = ($$0, $$1) -> {
      dou $$2 = ((dr)$$0.getSource()).f().p();
      return dt.a($$2.a(), $$1);
   };

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("place").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("feature").then(((RequiredArgumentBuilder)ds.a((String)"feature", (ArgumentType)ep.a(hm.aL)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ep.b($$0x, "feature"), new gt(((dr)$$0x.getSource()).e()));
      })).then(ds.a((String)"pos", (ArgumentType)fh.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ep.b($$0x, "feature"), fh.a($$0x, "pos"));
      }))))).then(ds.a("jigsaw").then(ds.a((String)"pool", (ArgumentType)ep.a(hm.aQ)).then(ds.a((String)"target", (ArgumentType)eq.a()).then(((RequiredArgumentBuilder)ds.a((String)"max_depth", (ArgumentType)IntegerArgumentType.integer(1, 7)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ep.d($$0x, "pool"), eq.e($$0x, "target"), IntegerArgumentType.getInteger($$0x, "max_depth"), new gt(((dr)$$0x.getSource()).e()));
      })).then(ds.a((String)"position", (ArgumentType)fh.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ep.d($$0x, "pool"), eq.e($$0x, "target"), IntegerArgumentType.getInteger($$0x, "max_depth"), fh.a($$0x, "position"));
      }))))))).then(ds.a("structure").then(((RequiredArgumentBuilder)ds.a((String)"structure", (ArgumentType)ep.a(hm.aN)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ep.c($$0x, "structure"), new gt(((dr)$$0x.getSource()).e()));
      })).then(ds.a((String)"pos", (ArgumentType)fh.a()).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ep.c($$0x, "structure"), fh.a($$0x, "pos"));
      }))))).then(ds.a("template").then(((RequiredArgumentBuilder)ds.a((String)"template", (ArgumentType)eq.a()).suggests(f).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eq.e($$0x, "template"), new gt(((dr)$$0x.getSource()).e()), cpw.a, coh.a, 1.0F, 0);
      })).then(((RequiredArgumentBuilder)ds.a((String)"pos", (ArgumentType)fh.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eq.e($$0x, "template"), fh.a($$0x, "pos"), cpw.a, coh.a, 1.0F, 0);
      })).then(((RequiredArgumentBuilder)ds.a((String)"rotation", (ArgumentType)ez.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eq.e($$0x, "template"), fh.a($$0x, "pos"), ez.a($$0x, "rotation"), coh.a, 1.0F, 0);
      })).then(((RequiredArgumentBuilder)ds.a((String)"mirror", (ArgumentType)ey.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eq.e($$0x, "template"), fh.a($$0x, "pos"), ez.a($$0x, "rotation"), ey.a($$0x, "mirror"), 1.0F, 0);
      })).then(((RequiredArgumentBuilder)ds.a((String)"integrity", (ArgumentType)FloatArgumentType.floatArg(0.0F, 1.0F)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eq.e($$0x, "template"), fh.a($$0x, "pos"), ez.a($$0x, "rotation"), ey.a($$0x, "mirror"), FloatArgumentType.getFloat($$0x, "integrity"), 0);
      })).then(ds.a((String)"seed", (ArgumentType)IntegerArgumentType.integer()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eq.e($$0x, "template"), fh.a($$0x, "pos"), ez.a($$0x, "rotation"), ey.a($$0x, "mirror"), FloatArgumentType.getFloat($$0x, "integrity"), IntegerArgumentType.getInteger($$0x, "seed"));
      })))))))));
   }

   public static int a(dr $$0, hc<ddg<?, ?>> $$1, gt $$2) throws CommandSyntaxException {
      agg $$3 = $$0.f();
      ddg<?, ?> $$4 = (ddg)$$1.a();
      cge $$5 = new cge($$2);
      a($$3, new cge($$5.e - 1, $$5.f - 1), new cge($$5.e + 1, $$5.f + 1));
      if (!$$4.a($$3, $$3.k().g(), $$3.r_(), $$2)) {
         throw a.create();
      } else {
         String $$6 = (String)$$1.e().map(($$0x) -> {
            return $$0x.a().toString();
         }).orElse("[unregistered]");
         $$0.a(rq.a("commands.place.feature.success", $$6, $$2.u(), $$2.v(), $$2.w()), true);
         return 1;
      }
   }

   public static int a(dr $$0, hc<dmk> $$1, abb $$2, int $$3, gt $$4) throws CommandSyntaxException {
      agg $$5 = $$0.f();
      if (!dme.a($$5, $$1, $$2, $$3, $$4, false)) {
         throw b.create();
      } else {
         $$0.a(rq.a("commands.place.jigsaw.success", $$4.u(), $$4.v(), $$4.w()), true);
         return 1;
      }
   }

   public static int b(dr $$0, hc<dlb> $$1, gt $$2) throws CommandSyntaxException {
      agg $$3 = $$0.f();
      dlb $$4 = (dlb)$$1.a();
      cxk $$5 = $$3.k().g();
      dlj $$6 = $$4.a($$0.v(), $$5, $$5.d(), $$3.k().h(), $$3.p(), $$3.B(), new cge($$2), 0, $$3, ($$0x) -> {
         return true;
      });
      if (!$$6.b()) {
         throw c.create();
      } else {
         dkt $$7 = $$6.a();
         cge $$8 = new cge(hq.a($$7.g()), hq.a($$7.i()));
         cge $$9 = new cge(hq.a($$7.j()), hq.a($$7.l()));
         a($$3, $$8, $$9);
         cge.a($$8, $$9).forEach(($$3x) -> {
            $$6.a($$3, $$3.a(), $$5, $$3.r_(), new dkt($$3x.d(), $$3.u_(), $$3x.e(), $$3x.f(), $$3.ah(), $$3x.g()), $$3x);
         });
         String $$10 = (String)$$1.e().map(($$0x) -> {
            return $$0x.a().toString();
         }).orElse("[unregistered]");
         $$0.a(rq.a("commands.place.structure.success", $$10, $$2.u(), $$2.v(), $$2.w()), true);
         return 1;
      }
   }

   public static int a(dr $$0, abb $$1, gt $$2, cpw $$3, coh $$4, float $$5, int $$6) throws CommandSyntaxException {
      agg $$7 = $$0.f();
      dou $$8 = $$7.p();

      Optional $$11;
      try {
         $$11 = $$8.b($$1);
      } catch (aa var13) {
         throw d.create($$1);
      }

      if ($$11.isEmpty()) {
         throw d.create($$1);
      } else {
         dot $$12 = (dot)$$11.get();
         a($$7, new cge($$2), new cge($$2.a($$12.a())));
         dop $$13 = (new dop()).a($$4).a($$3);
         if ($$5 < 1.0F) {
            $$13.b().a((doq)(new dny($$5))).a(cuo.b((long)$$6));
         }

         boolean $$14 = $$12.a($$7, $$2, $$2, $$13, cuo.b((long)$$6), 2);
         if (!$$14) {
            throw e.create();
         } else {
            $$0.a(rq.a("commands.place.template.success", $$1, $$2.u(), $$2.v(), $$2.w()), true);
            return 1;
         }
      }
   }

   private static void a(agg $$0, cge $$1, cge $$2) throws CommandSyntaxException {
      if (cge.a($$1, $$2).filter(($$1x) -> {
         return !$$0.o($$1x.l());
      }).findAny().isPresent()) {
         throw fh.a.create();
      }
   }
}
