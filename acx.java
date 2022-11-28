import com.google.common.base.Joiner;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import it.unimi.dsi.fastutil.longs.LongSet;

public class acx {
   private static final int a = 256;
   private static final Dynamic2CommandExceptionType b = new Dynamic2CommandExceptionType(($$0, $$1) -> {
      return rq.a("commands.forceload.toobig", $$0, $$1);
   });
   private static final Dynamic2CommandExceptionType c = new Dynamic2CommandExceptionType(($$0, $$1) -> {
      return rq.a("commands.forceload.query.failure", $$0, $$1);
   });
   private static final SimpleCommandExceptionType d = new SimpleCommandExceptionType(rq.c("commands.forceload.added.failure"));
   private static final SimpleCommandExceptionType e = new SimpleCommandExceptionType(rq.c("commands.forceload.removed.failure"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("forceload").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("add").then(((RequiredArgumentBuilder)ds.a((String)"from", (ArgumentType)fi.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fi.a($$0x, "from"), fi.a($$0x, "from"), true);
      })).then(ds.a((String)"to", (ArgumentType)fi.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fi.a($$0x, "from"), fi.a($$0x, "to"), true);
      }))))).then(((LiteralArgumentBuilder)ds.a("remove").then(((RequiredArgumentBuilder)ds.a((String)"from", (ArgumentType)fi.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fi.a($$0x, "from"), fi.a($$0x, "from"), false);
      })).then(ds.a((String)"to", (ArgumentType)fi.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fi.a($$0x, "from"), fi.a($$0x, "to"), false);
      })))).then(ds.a("all").executes(($$0x) -> {
         return b((dr)$$0x.getSource());
      })))).then(((LiteralArgumentBuilder)ds.a("query").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      })).then(ds.a((String)"pos", (ArgumentType)fi.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fi.a($$0x, "pos"));
      }))));
   }

   private static int a(dr $$0, afx $$1) throws CommandSyntaxException {
      cge $$2 = $$1.a();
      agg $$3 = $$0.f();
      aba<cgx> $$4 = $$3.ab();
      boolean $$5 = $$3.v().contains($$2.a());
      if ($$5) {
         $$0.a(rq.a("commands.forceload.query.success", $$2, $$4.a()), false);
         return 1;
      } else {
         throw c.create($$2, $$4.a());
      }
   }

   private static int a(dr $$0) {
      agg $$1 = $$0.f();
      aba<cgx> $$2 = $$1.ab();
      LongSet $$3 = $$1.v();
      int $$4 = $$3.size();
      if ($$4 > 0) {
         String $$5 = Joiner.on(", ").join($$3.stream().sorted().map(cge::new).map(cge::toString).iterator());
         if ($$4 == 1) {
            $$0.a(rq.a("commands.forceload.list.single", $$2.a(), $$5), false);
         } else {
            $$0.a(rq.a("commands.forceload.list.multiple", $$4, $$2.a(), $$5), false);
         }
      } else {
         $$0.b((rq)rq.a("commands.forceload.added.none", $$2.a()));
      }

      return $$4;
   }

   private static int b(dr $$0) {
      agg $$1 = $$0.f();
      aba<cgx> $$2 = $$1.ab();
      LongSet $$3 = $$1.v();
      $$3.forEach(($$1x) -> {
         $$1.a(cge.a($$1x), cge.b($$1x), false);
      });
      $$0.a(rq.a("commands.forceload.removed.all", $$2.a()), true);
      return 0;
   }

   private static int a(dr $$0, afx $$1, afx $$2, boolean $$3) throws CommandSyntaxException {
      int $$4 = Math.min($$1.c(), $$2.c());
      int $$5 = Math.min($$1.d(), $$2.d());
      int $$6 = Math.max($$1.c(), $$2.c());
      int $$7 = Math.max($$1.d(), $$2.d());
      if ($$4 >= -30000000 && $$5 >= -30000000 && $$6 < 30000000 && $$7 < 30000000) {
         int $$8 = hq.a($$4);
         int $$9 = hq.a($$5);
         int $$10 = hq.a($$6);
         int $$11 = hq.a($$7);
         long $$12 = ((long)($$10 - $$8) + 1L) * ((long)($$11 - $$9) + 1L);
         if ($$12 > 256L) {
            throw b.create(256, $$12);
         } else {
            agg $$13 = $$0.f();
            aba<cgx> $$14 = $$13.ab();
            cge $$15 = null;
            int $$16 = 0;

            for(int $$17 = $$8; $$17 <= $$10; ++$$17) {
               for(int $$18 = $$9; $$18 <= $$11; ++$$18) {
                  boolean $$19 = $$13.a($$17, $$18, $$3);
                  if ($$19) {
                     ++$$16;
                     if ($$15 == null) {
                        $$15 = new cge($$17, $$18);
                     }
                  }
               }
            }

            if ($$16 == 0) {
               throw ($$3 ? d : e).create();
            } else {
               if ($$16 == 1) {
                  $$0.a(rq.a("commands.forceload." + ($$3 ? "added" : "removed") + ".single", $$15, $$14.a()), true);
               } else {
                  cge $$20 = new cge($$8, $$9);
                  cge $$21 = new cge($$10, $$11);
                  $$0.a(rq.a("commands.forceload." + ($$3 ? "added" : "removed") + ".multiple", $$16, $$14.a(), $$20, $$21), true);
               }

               return $$16;
            }
         }
      } else {
         throw fh.b.create();
      }
   }
}
