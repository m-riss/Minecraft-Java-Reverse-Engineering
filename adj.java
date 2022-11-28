import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class adj {
   public static final SuggestionProvider<dr> a = ($$0, $$1) -> {
      dsh $$2 = ((dr)$$0.getSource()).m().aH();
      return dt.a((Iterable)$$2.a(), (SuggestionsBuilder)$$1);
   };
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.drop.no_held_items", $$0);
   });
   private static final DynamicCommandExceptionType c = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.drop.no_loot_table", $$0);
   });

   public static void a(CommandDispatcher<dr> $$0, dl $$1) {
      $$0.register((LiteralArgumentBuilder)a((ArgumentBuilder)((LiteralArgumentBuilder)ds.a("loot").requires(($$0x) -> {
         return $$0x.c(2);
      })), (adj.c)(($$1x, $$2) -> {
         return $$1x.then(ds.a("fish").then(ds.a((String)"loot_table", (ArgumentType)eq.a()).suggests(a).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"pos", (ArgumentType)fh.a()).executes(($$1xx) -> {
            return a($$1xx, eq.e($$1xx, "loot_table"), fh.a($$1xx, "pos"), cax.b, $$2);
         })).then(ds.a((String)"tool", (ArgumentType)ft.a($$1)).executes(($$1xx) -> {
            return a($$1xx, eq.e($$1xx, "loot_table"), fh.a($$1xx, "pos"), ft.a($$1xx, "tool").a(1, false), $$2);
         }))).then(ds.a("mainhand").executes(($$1xx) -> {
            return a($$1xx, eq.e($$1xx, "loot_table"), fh.a($$1xx, "pos"), a((dr)$$1xx.getSource(), bbs.a), $$2);
         }))).then(ds.a("offhand").executes(($$1xx) -> {
            return a($$1xx, eq.e($$1xx, "loot_table"), fh.a($$1xx, "pos"), a((dr)$$1xx.getSource(), bbs.b), $$2);
         }))))).then(ds.a("loot").then(ds.a((String)"loot_table", (ArgumentType)eq.a()).suggests(a).executes(($$1xx) -> {
            return a($$1xx, eq.e($$1xx, "loot_table"), $$2);
         }))).then(ds.a("kill").then(ds.a((String)"target", (ArgumentType)eb.a()).executes(($$1xx) -> {
            return a($$1xx, eb.a($$1xx, "target"), $$2);
         }))).then(ds.a("mine").then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"pos", (ArgumentType)fh.a()).executes(($$1xx) -> {
            return a($$1xx, fh.a($$1xx, "pos"), cax.b, $$2);
         })).then(ds.a((String)"tool", (ArgumentType)ft.a($$1)).executes(($$1xx) -> {
            return a($$1xx, fh.a($$1xx, "pos"), ft.a($$1xx, "tool").a(1, false), $$2);
         }))).then(ds.a("mainhand").executes(($$1xx) -> {
            return a($$1xx, fh.a($$1xx, "pos"), a((dr)$$1xx.getSource(), bbs.a), $$2);
         }))).then(ds.a("offhand").executes(($$1xx) -> {
            return a($$1xx, fh.a($$1xx, "pos"), a((dr)$$1xx.getSource(), bbs.b), $$2);
         }))));
      })));
   }

   private static <T extends ArgumentBuilder<dr, T>> T a(T $$0, adj.c $$1) {
      return $$0.then(((LiteralArgumentBuilder)ds.a("replace").then(ds.a("entity").then(ds.a((String)"entities", (ArgumentType)eb.b()).then($$1.construct(ds.a((String)"slot", (ArgumentType)ev.a()), ($$0x, $$1x, $$2) -> {
         return a(eb.b($$0x, "entities"), ev.a($$0x, "slot"), $$1x.size(), $$1x, $$2);
      }).then($$1.construct(ds.a((String)"count", (ArgumentType)IntegerArgumentType.integer(0)), ($$0x, $$1x, $$2) -> {
         return a(eb.b($$0x, "entities"), ev.a($$0x, "slot"), IntegerArgumentType.getInteger($$0x, "count"), $$1x, $$2);
      })))))).then(ds.a("block").then(ds.a((String)"targetPos", (ArgumentType)fh.a()).then($$1.construct(ds.a((String)"slot", (ArgumentType)ev.a()), ($$0x, $$1x, $$2) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "targetPos"), ev.a($$0x, "slot"), $$1x.size(), $$1x, $$2);
      }).then($$1.construct(ds.a((String)"count", (ArgumentType)IntegerArgumentType.integer(0)), ($$0x, $$1x, $$2) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "targetPos"), IntegerArgumentType.getInteger($$0x, "slot"), IntegerArgumentType.getInteger($$0x, "count"), $$1x, $$2);
      })))))).then(ds.a("insert").then($$1.construct(ds.a((String)"targetPos", (ArgumentType)fh.a()), ($$0x, $$1x, $$2) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "targetPos"), $$1x, $$2);
      }))).then(ds.a("give").then($$1.construct(ds.a((String)"players", (ArgumentType)eb.d()), ($$0x, $$1x, $$2) -> {
         return a(eb.f($$0x, "players"), $$1x, $$2);
      }))).then(ds.a("spawn").then($$1.construct(ds.a((String)"targetPos", (ArgumentType)fo.a()), ($$0x, $$1x, $$2) -> {
         return a((dr)$$0x.getSource(), fo.a($$0x, "targetPos"), $$1x, $$2);
      })));
   }

   private static bac a(dr $$0, gt $$1) throws CommandSyntaxException {
      cti $$2 = $$0.f().c_($$1);
      if (!($$2 instanceof bac)) {
         throw add.a.create($$1.u(), $$1.v(), $$1.w());
      } else {
         return (bac)$$2;
      }
   }

   private static int a(dr $$0, gt $$1, List<cax> $$2, adj.a $$3) throws CommandSyntaxException {
      bac $$4 = a($$0, $$1);
      List<cax> $$5 = Lists.newArrayListWithCapacity($$2.size());
      Iterator var6 = $$2.iterator();

      while(var6.hasNext()) {
         cax $$6 = (cax)var6.next();
         if (a($$4, $$6.o())) {
            $$4.e();
            $$5.add($$6);
         }
      }

      $$3.accept($$5);
      return $$5.size();
   }

   private static boolean a(bac $$0, cax $$1) {
      boolean $$2 = false;

      for(int $$3 = 0; $$3 < $$0.b() && !$$1.b(); ++$$3) {
         cax $$4 = $$0.a($$3);
         if ($$0.b($$3, $$1)) {
            if ($$4.b()) {
               $$0.a($$3, $$1);
               $$2 = true;
               break;
            }

            if (a($$4, $$1)) {
               int $$5 = $$1.f() - $$4.K();
               int $$6 = Math.min($$1.K(), $$5);
               $$1.g($$6);
               $$4.f($$6);
               $$2 = true;
            }
         }
      }

      return $$2;
   }

   private static int a(dr $$0, gt $$1, int $$2, int $$3, List<cax> $$4, adj.a $$5) throws CommandSyntaxException {
      bac $$6 = a($$0, $$1);
      int $$7 = $$6.b();
      if ($$2 >= 0 && $$2 < $$7) {
         List<cax> $$8 = Lists.newArrayListWithCapacity($$4.size());

         for(int $$9 = 0; $$9 < $$3; ++$$9) {
            int $$10 = $$2 + $$9;
            cax $$11 = $$9 < $$4.size() ? (cax)$$4.get($$9) : cax.b;
            if ($$6.b($$10, $$11)) {
               $$6.a($$10, $$11);
               $$8.add($$11);
            }
         }

         $$5.accept($$8);
         return $$8.size();
      } else {
         throw add.b.create($$2);
      }
   }

   private static boolean a(cax $$0, cax $$1) {
      return $$0.a($$1.c()) && $$0.j() == $$1.j() && $$0.K() <= $$0.f() && Objects.equals($$0.u(), $$1.u());
   }

   private static int a(Collection<agh> $$0, List<cax> $$1, adj.a $$2) throws CommandSyntaxException {
      List<cax> $$3 = Lists.newArrayListWithCapacity($$1.size());
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         cax $$4 = (cax)var4.next();
         Iterator var6 = $$0.iterator();

         while(var6.hasNext()) {
            agh $$5 = (agh)var6.next();
            if ($$5.fA().e($$4.o())) {
               $$3.add($$4);
            }
         }
      }

      $$2.accept($$3);
      return $$3.size();
   }

   private static void a(bbn $$0, List<cax> $$1, int $$2, int $$3, List<cax> $$4) {
      for(int $$5 = 0; $$5 < $$3; ++$$5) {
         cax $$6 = $$5 < $$1.size() ? (cax)$$1.get($$5) : cax.b;
         bct $$7 = $$0.k($$2 + $$5);
         if ($$7 != bct.a && $$7.a($$6.o())) {
            $$4.add($$6);
         }
      }

   }

   private static int a(Collection<? extends bbn> $$0, int $$1, int $$2, List<cax> $$3, adj.a $$4) throws CommandSyntaxException {
      List<cax> $$5 = Lists.newArrayListWithCapacity($$3.size());
      Iterator var6 = $$0.iterator();

      while(var6.hasNext()) {
         bbn $$6 = (bbn)var6.next();
         if ($$6 instanceof agh) {
            agh $$7 = (agh)$$6;
            a($$6, $$3, $$1, $$2, $$5);
            $$7.bU.d();
         } else {
            a($$6, $$3, $$1, $$2, $$5);
         }
      }

      $$4.accept($$5);
      return $$5.size();
   }

   private static int a(dr $$0, dwq $$1, List<cax> $$2, adj.a $$3) throws CommandSyntaxException {
      agg $$4 = $$0.f();
      $$2.forEach(($$2x) -> {
         bqv $$3 = new bqv($$4, $$1.c, $$1.d, $$1.e, $$2x.o());
         $$3.o();
         $$4.b((bbn)$$3);
      });
      $$3.accept($$2);
      return $$2.size();
   }

   private static void a(dr $$0, List<cax> $$1) {
      if ($$1.size() == 1) {
         cax $$2 = (cax)$$1.get(0);
         $$0.a(rq.a("commands.drop.success.single", $$2.K(), $$2.I()), false);
      } else {
         $$0.a(rq.a("commands.drop.success.multiple", $$1.size()), false);
      }

   }

   private static void a(dr $$0, List<cax> $$1, abb $$2) {
      if ($$1.size() == 1) {
         cax $$3 = (cax)$$1.get(0);
         $$0.a(rq.a("commands.drop.success.single_with_table", $$3.K(), $$3.I(), $$2), false);
      } else {
         $$0.a(rq.a("commands.drop.success.multiple_with_table", $$1.size(), $$2), false);
      }

   }

   private static cax a(dr $$0, bbs $$1) throws CommandSyntaxException {
      bbn $$2 = $$0.h();
      if ($$2 instanceof bcc) {
         return ((bcc)$$2).c($$1);
      } else {
         throw b.create($$2.C_());
      }
   }

   private static int a(CommandContext<dr> $$0, gt $$1, cax $$2, adj.b $$3) throws CommandSyntaxException {
      dr $$4 = (dr)$$0.getSource();
      agg $$5 = $$4.f();
      cvo $$6 = $$5.a_($$1);
      cti $$7 = $$5.c_($$1);
      dsd.a $$8 = (new dsd.a($$5)).a((dui)dul.f, (Object)dwq.a((hs)$$1)).a((dui)dul.g, (Object)$$6).b(dul.h, $$7).b(dul.a, $$4.g()).a((dui)dul.i, (Object)$$2);
      List<cax> $$9 = $$6.a($$8);
      return $$3.accept($$0, $$9, ($$2x) -> {
         a($$4, $$2x, $$6.b().r());
      });
   }

   private static int a(CommandContext<dr> $$0, bbn $$1, adj.b $$2) throws CommandSyntaxException {
      if (!($$1 instanceof bcc)) {
         throw c.create($$1.C_());
      } else {
         abb $$3 = ((bcc)$$1).ek();
         dr $$4 = (dr)$$0.getSource();
         dsd.a $$5 = new dsd.a($$4.f());
         bbn $$6 = $$4.g();
         if ($$6 instanceof buc) {
            $$5.a((dui)dul.b, (Object)((buc)$$6));
         }

         $$5.a((dui)dul.c, (Object)baw.o);
         $$5.b(dul.e, $$6);
         $$5.b(dul.d, $$6);
         $$5.a((dui)dul.a, (Object)$$1);
         $$5.a((dui)dul.f, (Object)$$4.e());
         dsg $$7 = $$4.m().aH().a($$3);
         List<cax> $$8 = $$7.a($$5.a(duk.f));
         return $$2.accept($$0, $$8, ($$2x) -> {
            a($$4, $$2x, $$3);
         });
      }
   }

   private static int a(CommandContext<dr> $$0, abb $$1, adj.b $$2) throws CommandSyntaxException {
      dr $$3 = (dr)$$0.getSource();
      dsd.a $$4 = (new dsd.a($$3.f())).b(dul.a, $$3.g()).a((dui)dul.f, (Object)$$3.e());
      return a($$0, $$1, $$4.a(duk.b), $$2);
   }

   private static int a(CommandContext<dr> $$0, abb $$1, gt $$2, cax $$3, adj.b $$4) throws CommandSyntaxException {
      dr $$5 = (dr)$$0.getSource();
      dsd $$6 = (new dsd.a($$5.f())).a((dui)dul.f, (Object)dwq.a((hs)$$2)).a((dui)dul.i, (Object)$$3).b(dul.a, $$5.g()).a(duk.e);
      return a($$0, $$1, $$6, $$4);
   }

   private static int a(CommandContext<dr> $$0, abb $$1, dsd $$2, adj.b $$3) throws CommandSyntaxException {
      dr $$4 = (dr)$$0.getSource();
      dsg $$5 = $$4.m().aH().a($$1);
      List<cax> $$6 = $$5.a($$2);
      return $$3.accept($$0, $$6, ($$1x) -> {
         a($$4, $$1x);
      });
   }

   @FunctionalInterface
   interface c {
      ArgumentBuilder<dr, ?> construct(ArgumentBuilder<dr, ?> var1, adj.b var2);
   }

   @FunctionalInterface
   interface b {
      int accept(CommandContext<dr> var1, List<cax> var2, adj.a var3) throws CommandSyntaxException;
   }

   @FunctionalInterface
   private interface a {
      void accept(List<cax> var1) throws CommandSyntaxException;
   }
}
