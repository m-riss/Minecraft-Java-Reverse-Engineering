import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.Collections;

public class acg {
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.bossbar.create.failed", $$0);
   });
   private static final DynamicCommandExceptionType c = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.bossbar.unknown", $$0);
   });
   private static final SimpleCommandExceptionType d = new SimpleCommandExceptionType(rq.c("commands.bossbar.set.players.unchanged"));
   private static final SimpleCommandExceptionType e = new SimpleCommandExceptionType(rq.c("commands.bossbar.set.name.unchanged"));
   private static final SimpleCommandExceptionType f = new SimpleCommandExceptionType(rq.c("commands.bossbar.set.color.unchanged"));
   private static final SimpleCommandExceptionType g = new SimpleCommandExceptionType(rq.c("commands.bossbar.set.style.unchanged"));
   private static final SimpleCommandExceptionType h = new SimpleCommandExceptionType(rq.c("commands.bossbar.set.value.unchanged"));
   private static final SimpleCommandExceptionType i = new SimpleCommandExceptionType(rq.c("commands.bossbar.set.max.unchanged"));
   private static final SimpleCommandExceptionType j = new SimpleCommandExceptionType(rq.c("commands.bossbar.set.visibility.unchanged.hidden"));
   private static final SimpleCommandExceptionType k = new SimpleCommandExceptionType(rq.c("commands.bossbar.set.visibility.unchanged.visible"));
   public static final SuggestionProvider<dr> a = ($$0, $$1) -> {
      return dt.a((Iterable)((dr)$$0.getSource()).m().aL().a(), (SuggestionsBuilder)$$1);
   };

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("bossbar").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("add").then(ds.a((String)"id", (ArgumentType)eq.a()).then(ds.a((String)"name", (ArgumentType)dx.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eq.e($$0x, "id"), dx.a($$0x, "name"));
      }))))).then(ds.a("remove").then(ds.a((String)"id", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return e((dr)$$0x.getSource(), a($$0x));
      })))).then(ds.a("list").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      }))).then(ds.a("set").then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"id", (ArgumentType)eq.a()).suggests(a).then(ds.a("name").then(ds.a((String)"name", (ArgumentType)dx.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), dx.a($$0x, "name"));
      })))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("color").then(ds.a("pink").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.a.a);
      }))).then(ds.a("blue").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.a.b);
      }))).then(ds.a("red").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.a.c);
      }))).then(ds.a("green").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.a.d);
      }))).then(ds.a("yellow").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.a.e);
      }))).then(ds.a("purple").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.a.f);
      }))).then(ds.a("white").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.a.g);
      })))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("style").then(ds.a("progress").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.b.a);
      }))).then(ds.a("notched_6").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.b.b);
      }))).then(ds.a("notched_10").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.b.c);
      }))).then(ds.a("notched_12").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.b.d);
      }))).then(ds.a("notched_20").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), azz.b.e);
      })))).then(ds.a("value").then(ds.a((String)"value", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), IntegerArgumentType.getInteger($$0x, "value"));
      })))).then(ds.a("max").then(ds.a((String)"max", (ArgumentType)IntegerArgumentType.integer(1)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), a($$0x), IntegerArgumentType.getInteger($$0x, "max"));
      })))).then(ds.a("visible").then(ds.a((String)"visible", (ArgumentType)BoolArgumentType.bool()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), BoolArgumentType.getBool($$0x, "visible"));
      })))).then(((LiteralArgumentBuilder)ds.a("players").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), (abv)a($$0x), (Collection)Collections.emptyList());
      })).then(ds.a((String)"targets", (ArgumentType)eb.d()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x), eb.d($$0x, "targets"));
      })))))).then(ds.a("get").then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"id", (ArgumentType)eq.a()).suggests(a).then(ds.a("value").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x));
      }))).then(ds.a("max").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), a($$0x));
      }))).then(ds.a("visible").executes(($$0x) -> {
         return c((dr)$$0x.getSource(), a($$0x));
      }))).then(ds.a("players").executes(($$0x) -> {
         return d((dr)$$0x.getSource(), a($$0x));
      })))));
   }

   private static int a(dr $$0, abv $$1) {
      $$0.a(rq.a("commands.bossbar.get.value", $$1.e(), $$1.c()), true);
      return $$1.c();
   }

   private static int b(dr $$0, abv $$1) {
      $$0.a(rq.a("commands.bossbar.get.max", $$1.e(), $$1.d()), true);
      return $$1.d();
   }

   private static int c(dr $$0, abv $$1) {
      if ($$1.g()) {
         $$0.a(rq.a("commands.bossbar.get.visible.visible", $$1.e()), true);
         return 1;
      } else {
         $$0.a(rq.a("commands.bossbar.get.visible.hidden", $$1.e()), true);
         return 0;
      }
   }

   private static int d(dr $$0, abv $$1) {
      if ($$1.h().isEmpty()) {
         $$0.a(rq.a("commands.bossbar.get.players.none", $$1.e()), true);
      } else {
         $$0.a(rq.a("commands.bossbar.get.players.some", $$1.e(), $$1.h().size(), rs.b($$1.h(), buc::C_)), true);
      }

      return $$1.h().size();
   }

   private static int a(dr $$0, abv $$1, boolean $$2) throws CommandSyntaxException {
      if ($$1.g() == $$2) {
         if ($$2) {
            throw k.create();
         } else {
            throw j.create();
         }
      } else {
         $$1.d($$2);
         if ($$2) {
            $$0.a(rq.a("commands.bossbar.set.visible.success.visible", $$1.e()), true);
         } else {
            $$0.a(rq.a("commands.bossbar.set.visible.success.hidden", $$1.e()), true);
         }

         return 0;
      }
   }

   private static int a(dr $$0, abv $$1, int $$2) throws CommandSyntaxException {
      if ($$1.c() == $$2) {
         throw h.create();
      } else {
         $$1.a($$2);
         $$0.a(rq.a("commands.bossbar.set.value.success", $$1.e(), $$2), true);
         return $$2;
      }
   }

   private static int b(dr $$0, abv $$1, int $$2) throws CommandSyntaxException {
      if ($$1.d() == $$2) {
         throw i.create();
      } else {
         $$1.b($$2);
         $$0.a(rq.a("commands.bossbar.set.max.success", $$1.e(), $$2), true);
         return $$2;
      }
   }

   private static int a(dr $$0, abv $$1, azz.a $$2) throws CommandSyntaxException {
      if ($$1.l().equals($$2)) {
         throw f.create();
      } else {
         $$1.a((azz.a)$$2);
         $$0.a(rq.a("commands.bossbar.set.color.success", $$1.e()), true);
         return 0;
      }
   }

   private static int a(dr $$0, abv $$1, azz.b $$2) throws CommandSyntaxException {
      if ($$1.m().equals($$2)) {
         throw g.create();
      } else {
         $$1.a((azz.b)$$2);
         $$0.a(rq.a("commands.bossbar.set.style.success", $$1.e()), true);
         return 0;
      }
   }

   private static int a(dr $$0, abv $$1, rq $$2) throws CommandSyntaxException {
      rq $$3 = rs.a($$0, (rq)$$2, (bbn)null, 0);
      if ($$1.j().equals($$3)) {
         throw e.create();
      } else {
         $$1.a((rq)$$3);
         $$0.a(rq.a("commands.bossbar.set.name.success", $$1.e()), true);
         return 0;
      }
   }

   private static int a(dr $$0, abv $$1, Collection<agh> $$2) throws CommandSyntaxException {
      boolean $$3 = $$1.a($$2);
      if (!$$3) {
         throw d.create();
      } else {
         if ($$1.h().isEmpty()) {
            $$0.a(rq.a("commands.bossbar.set.players.success.none", $$1.e()), true);
         } else {
            $$0.a(rq.a("commands.bossbar.set.players.success.some", $$1.e(), $$2.size(), rs.b($$2, buc::C_)), true);
         }

         return $$1.h().size();
      }
   }

   private static int a(dr $$0) {
      Collection<abv> $$1 = $$0.m().aL().b();
      if ($$1.isEmpty()) {
         $$0.a(rq.c("commands.bossbar.list.bars.none"), false);
      } else {
         $$0.a(rq.a("commands.bossbar.list.bars.some", $$1.size(), rs.b($$1, abv::e)), false);
      }

      return $$1.size();
   }

   private static int a(dr $$0, abb $$1, rq $$2) throws CommandSyntaxException {
      abw $$3 = $$0.m().aL();
      if ($$3.a($$1) != null) {
         throw b.create($$1.toString());
      } else {
         abv $$4 = $$3.a($$1, rs.a($$0, (rq)$$2, (bbn)null, 0));
         $$0.a(rq.a("commands.bossbar.create.success", $$4.e()), true);
         return $$3.b().size();
      }
   }

   private static int e(dr $$0, abv $$1) {
      abw $$2 = $$0.m().aL();
      $$1.b();
      $$2.a($$1);
      $$0.a(rq.a("commands.bossbar.remove.success", $$1.e()), true);
      return $$2.b().size();
   }

   public static abv a(CommandContext<dr> $$0) throws CommandSyntaxException {
      abb $$1 = eq.e($$0, "id");
      abv $$2 = ((dr)$$0.getSource()).m().aL().a($$1);
      if ($$2 == null) {
         throw c.create($$1.toString());
      } else {
         return $$2;
      }
   }
}
