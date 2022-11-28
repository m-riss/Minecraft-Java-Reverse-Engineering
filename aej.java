import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.Dynamic4CommandExceptionType;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class aej {
   private static final int a = 10000;
   private static final Dynamic4CommandExceptionType b = new Dynamic4CommandExceptionType(($$0, $$1, $$2, $$3) -> {
      return rq.a("commands.spreadplayers.failed.teams", $$0, $$1, $$2, $$3);
   });
   private static final Dynamic4CommandExceptionType c = new Dynamic4CommandExceptionType(($$0, $$1, $$2, $$3) -> {
      return rq.a("commands.spreadplayers.failed.entities", $$0, $$1, $$2, $$3);
   });
   private static final Dynamic2CommandExceptionType d = new Dynamic2CommandExceptionType(($$0, $$1) -> {
      return rq.a("commands.spreadplayers.failed.invalid.height", $$0, $$1);
   });

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("spreadplayers").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"center", (ArgumentType)fn.a()).then(ds.a((String)"spreadDistance", (ArgumentType)FloatArgumentType.floatArg(0.0F)).then(((RequiredArgumentBuilder)ds.a((String)"maxRange", (ArgumentType)FloatArgumentType.floatArg(1.0F)).then(ds.a((String)"respectTeams", (ArgumentType)BoolArgumentType.bool()).then(ds.a((String)"targets", (ArgumentType)eb.b()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fn.a($$0x, "center"), FloatArgumentType.getFloat($$0x, "spreadDistance"), FloatArgumentType.getFloat($$0x, "maxRange"), ((dr)$$0x.getSource()).f().ah(), BoolArgumentType.getBool($$0x, "respectTeams"), eb.b($$0x, "targets"));
      })))).then(ds.a("under").then(ds.a((String)"maxHeight", (ArgumentType)IntegerArgumentType.integer()).then(ds.a((String)"respectTeams", (ArgumentType)BoolArgumentType.bool()).then(ds.a((String)"targets", (ArgumentType)eb.b()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fn.a($$0x, "center"), FloatArgumentType.getFloat($$0x, "spreadDistance"), FloatArgumentType.getFloat($$0x, "maxRange"), IntegerArgumentType.getInteger($$0x, "maxHeight"), BoolArgumentType.getBool($$0x, "respectTeams"), eb.b($$0x, "targets"));
      })))))))));
   }

   private static int a(dr $$0, dwp $$1, float $$2, float $$3, int $$4, boolean $$5, Collection<? extends bbn> $$6) throws CommandSyntaxException {
      agg $$7 = $$0.f();
      int $$8 = $$7.u_();
      if ($$4 < $$8) {
         throw d.create($$4, $$8);
      } else {
         amn $$9 = amn.a();
         double $$10 = (double)($$1.i - $$3);
         double $$11 = (double)($$1.j - $$3);
         double $$12 = (double)($$1.i + $$3);
         double $$13 = (double)($$1.j + $$3);
         aej.a[] $$14 = a($$9, $$5 ? a($$6) : $$6.size(), $$10, $$11, $$12, $$13);
         a($$1, (double)$$2, $$7, $$9, $$10, $$11, $$12, $$13, $$4, $$14, $$5);
         double $$15 = a($$6, $$7, $$14, $$4, $$5);
         $$0.a(rq.a("commands.spreadplayers.success." + ($$5 ? "teams" : "entities"), $$14.length, $$1.i, $$1.j, String.format(Locale.ROOT, "%.2f", $$15)), true);
         return $$14.length;
      }
   }

   private static int a(Collection<? extends bbn> $$0) {
      Set<dxq> $$1 = Sets.newHashSet();
      Iterator var2 = $$0.iterator();

      while(var2.hasNext()) {
         bbn $$2 = (bbn)var2.next();
         if ($$2 instanceof buc) {
            $$1.add($$2.bY());
         } else {
            $$1.add((Object)null);
         }
      }

      return $$1.size();
   }

   private static void a(dwp $$0, double $$1, agg $$2, amn $$3, double $$4, double $$5, double $$6, double $$7, int $$8, aej.a[] $$9, boolean $$10) throws CommandSyntaxException {
      boolean $$11 = true;
      double $$12 = 3.4028234663852886E38D;

      int $$13;
      for($$13 = 0; $$13 < 10000 && $$11; ++$$13) {
         $$11 = false;
         $$12 = 3.4028234663852886E38D;

         int $$16;
         aej.a $$22;
         for(int $$14 = 0; $$14 < $$9.length; ++$$14) {
            aej.a $$15 = $$9[$$14];
            $$16 = 0;
            $$22 = new aej.a();

            for(int $$18 = 0; $$18 < $$9.length; ++$$18) {
               if ($$14 != $$18) {
                  aej.a $$19 = $$9[$$18];
                  double $$20 = $$15.a($$19);
                  $$12 = Math.min($$20, $$12);
                  if ($$20 < $$1) {
                     ++$$16;
                     $$22.a += $$19.a - $$15.a;
                     $$22.b += $$19.b - $$15.b;
                  }
               }
            }

            if ($$16 > 0) {
               $$22.a /= (double)$$16;
               $$22.b /= (double)$$16;
               double $$21 = $$22.b();
               if ($$21 > 0.0D) {
                  $$22.a();
                  $$15.b($$22);
               } else {
                  $$15.a($$3, $$4, $$5, $$6, $$7);
               }

               $$11 = true;
            }

            if ($$15.a($$4, $$5, $$6, $$7)) {
               $$11 = true;
            }
         }

         if (!$$11) {
            aej.a[] var28 = $$9;
            int var29 = $$9.length;

            for($$16 = 0; $$16 < var29; ++$$16) {
               $$22 = var28[$$16];
               if (!$$22.b($$2, $$8)) {
                  $$22.a($$3, $$4, $$5, $$6, $$7);
                  $$11 = true;
               }
            }
         }
      }

      if ($$12 == 3.4028234663852886E38D) {
         $$12 = 0.0D;
      }

      if ($$13 >= 10000) {
         if ($$10) {
            throw b.create($$9.length, $$0.i, $$0.j, String.format(Locale.ROOT, "%.2f", $$12));
         } else {
            throw c.create($$9.length, $$0.i, $$0.j, String.format(Locale.ROOT, "%.2f", $$12));
         }
      }
   }

   private static double a(Collection<? extends bbn> $$0, agg $$1, aej.a[] $$2, int $$3, boolean $$4) {
      double $$5 = 0.0D;
      int $$6 = 0;
      Map<dxq, aej.a> $$7 = Maps.newHashMap();

      double $$12;
      for(Iterator var9 = $$0.iterator(); var9.hasNext(); $$5 += $$12) {
         bbn $$8 = (bbn)var9.next();
         aej.a $$11;
         if ($$4) {
            dxq $$9 = $$8 instanceof buc ? $$8.bY() : null;
            if (!$$7.containsKey($$9)) {
               $$7.put($$9, $$2[$$6++]);
            }

            $$11 = (aej.a)$$7.get($$9);
         } else {
            $$11 = $$2[$$6++];
         }

         $$8.m((double)ami.b($$11.a) + 0.5D, (double)$$11.a($$1, $$3), (double)ami.b($$11.b) + 0.5D);
         $$12 = Double.MAX_VALUE;
         aej.a[] var14 = $$2;
         int var15 = $$2.length;

         for(int var16 = 0; var16 < var15; ++var16) {
            aej.a $$13 = var14[var16];
            if ($$11 != $$13) {
               double $$14 = $$11.a($$13);
               $$12 = Math.min($$14, $$12);
            }
         }
      }

      if ($$0.size() < 2) {
         return 0.0D;
      } else {
         $$5 /= (double)$$0.size();
         return $$5;
      }
   }

   private static aej.a[] a(amn $$0, int $$1, double $$2, double $$3, double $$4, double $$5) {
      aej.a[] $$6 = new aej.a[$$1];

      for(int $$7 = 0; $$7 < $$6.length; ++$$7) {
         aej.a $$8 = new aej.a();
         $$8.a($$0, $$2, $$3, $$4, $$5);
         $$6[$$7] = $$8;
      }

      return $$6;
   }

   static class a {
      double a;
      double b;

      double a(aej.a $$0) {
         double $$1 = this.a - $$0.a;
         double $$2 = this.b - $$0.b;
         return Math.sqrt($$1 * $$1 + $$2 * $$2);
      }

      void a() {
         double $$0 = this.b();
         this.a /= $$0;
         this.b /= $$0;
      }

      double b() {
         return Math.sqrt(this.a * this.a + this.b * this.b);
      }

      public void b(aej.a $$0) {
         this.a -= $$0.a;
         this.b -= $$0.b;
      }

      public boolean a(double $$0, double $$1, double $$2, double $$3) {
         boolean $$4 = false;
         if (this.a < $$0) {
            this.a = $$0;
            $$4 = true;
         } else if (this.a > $$2) {
            this.a = $$2;
            $$4 = true;
         }

         if (this.b < $$1) {
            this.b = $$1;
            $$4 = true;
         } else if (this.b > $$3) {
            this.b = $$3;
            $$4 = true;
         }

         return $$4;
      }

      public int a(cgd $$0, int $$1) {
         gt.a $$2 = new gt.a(this.a, (double)($$1 + 1), this.b);
         boolean $$3 = $$0.a_($$2).h();
         $$2.c(gy.a);

         boolean $$5;
         for(boolean $$4 = $$0.a_($$2).h(); $$2.v() > $$0.u_(); $$4 = $$5) {
            $$2.c(gy.a);
            $$5 = $$0.a_($$2).h();
            if (!$$5 && $$4 && $$3) {
               return $$2.v() + 1;
            }

            $$3 = $$4;
         }

         return $$1 + 1;
      }

      public boolean b(cgd $$0, int $$1) {
         gt $$2 = new gt(this.a, (double)(this.a($$0, $$1) - 1), this.b);
         cvo $$3 = $$0.a_($$2);
         dpz $$4 = $$3.d();
         return $$2.v() < $$1 && !$$4.a() && $$4 != dpz.n;
      }

      public void a(amn $$0, double $$1, double $$2, double $$3, double $$4) {
         this.a = ami.a($$0, $$1, $$3);
         this.b = ami.a($$0, $$2, $$4);
      }
   }
}
