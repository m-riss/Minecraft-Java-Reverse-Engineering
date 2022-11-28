import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nullable;

public class aeq {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.teleport.invalidPosition"));

   public static void a(CommandDispatcher<dr> $$0) {
      LiteralCommandNode<dr> $$1 = $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("teleport").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"location", (ArgumentType)fo.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), Collections.singleton(((dr)$$0x.getSource()).h()), ((dr)$$0x.getSource()).f(), fo.b($$0x, "location"), fq.d(), (aeq.a)null);
      }))).then(ds.a((String)"destination", (ArgumentType)eb.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), Collections.singleton(((dr)$$0x.getSource()).h()), eb.a($$0x, "destination"));
      }))).then(((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.b()).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"location", (ArgumentType)fo.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ((dr)$$0x.getSource()).f(), fo.b($$0x, "location"), (fj)null, (aeq.a)null);
      })).then(ds.a((String)"rotation", (ArgumentType)fl.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ((dr)$$0x.getSource()).f(), fo.b($$0x, "location"), fl.a($$0x, "rotation"), (aeq.a)null);
      }))).then(((LiteralArgumentBuilder)ds.a("facing").then(ds.a("entity").then(((RequiredArgumentBuilder)ds.a((String)"facingEntity", (ArgumentType)eb.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ((dr)$$0x.getSource()).f(), fo.b($$0x, "location"), (fj)null, new aeq.a(eb.a($$0x, "facingEntity"), ea.a.a));
      })).then(ds.a((String)"facingAnchor", (ArgumentType)ea.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ((dr)$$0x.getSource()).f(), fo.b($$0x, "location"), (fj)null, new aeq.a(eb.a($$0x, "facingEntity"), ea.a($$0x, "facingAnchor")));
      }))))).then(ds.a((String)"facingLocation", (ArgumentType)fo.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ((dr)$$0x.getSource()).f(), fo.b($$0x, "location"), (fj)null, new aeq.a(fo.a($$0x, "facingLocation")));
      }))))).then(ds.a((String)"destination", (ArgumentType)eb.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), eb.a($$0x, "destination"));
      }))));
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("tp").requires(($$0x) -> {
         return $$0x.c(2);
      })).redirect($$1));
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1, bbn $$2) throws CommandSyntaxException {
      Iterator var3 = $$1.iterator();

      while(var3.hasNext()) {
         bbn $$3 = (bbn)var3.next();
         a($$0, $$3, (agg)$$2.s, $$2.df(), $$2.dh(), $$2.dl(), EnumSet.noneOf(vl.a.class), $$2.dq(), $$2.ds(), (aeq.a)null);
      }

      if ($$1.size() == 1) {
         $$0.a(rq.a("commands.teleport.success.entity.single", ((bbn)$$1.iterator().next()).C_(), $$2.C_()), true);
      } else {
         $$0.a(rq.a("commands.teleport.success.entity.multiple", $$1.size(), $$2.C_()), true);
      }

      return $$1.size();
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1, agg $$2, fj $$3, @Nullable fj $$4, @Nullable aeq.a $$5) throws CommandSyntaxException {
      dwq $$6 = $$3.a($$0);
      dwp $$7 = $$4 == null ? null : $$4.b($$0);
      Set<vl.a> $$8 = EnumSet.noneOf(vl.a.class);
      if ($$3.a()) {
         $$8.add(vl.a.a);
      }

      if ($$3.b()) {
         $$8.add(vl.a.b);
      }

      if ($$3.c()) {
         $$8.add(vl.a.c);
      }

      if ($$4 == null) {
         $$8.add(vl.a.e);
         $$8.add(vl.a.d);
      } else {
         if ($$4.a()) {
            $$8.add(vl.a.e);
         }

         if ($$4.b()) {
            $$8.add(vl.a.d);
         }
      }

      Iterator var9 = $$1.iterator();

      while(var9.hasNext()) {
         bbn $$9 = (bbn)var9.next();
         if ($$4 == null) {
            a($$0, $$9, $$2, $$6.c, $$6.d, $$6.e, $$8, $$9.dq(), $$9.ds(), $$5);
         } else {
            a($$0, $$9, $$2, $$6.c, $$6.d, $$6.e, $$8, $$7.j, $$7.i, $$5);
         }
      }

      if ($$1.size() == 1) {
         $$0.a(rq.a("commands.teleport.success.location.single", ((bbn)$$1.iterator().next()).C_(), a($$6.c), a($$6.d), a($$6.e)), true);
      } else {
         $$0.a(rq.a("commands.teleport.success.location.multiple", $$1.size(), a($$6.c), a($$6.d), a($$6.e)), true);
      }

      return $$1.size();
   }

   private static String a(double $$0) {
      return String.format(Locale.ROOT, "%f", $$0);
   }

   private static void a(dr $$0, bbn $$1, agg $$2, double $$3, double $$4, double $$5, Set<vl.a> $$6, float $$7, float $$8, @Nullable aeq.a $$9) throws CommandSyntaxException {
      gt $$10 = new gt($$3, $$4, $$5);
      if (!cgx.k($$10)) {
         throw a.create();
      } else {
         float $$11 = ami.g($$7);
         float $$12 = ami.g($$8);
         if ($$1 instanceof agh) {
            cge $$13 = new cge(new gt($$3, $$4, $$5));
            $$2.k().a(agl.g, $$13, 1, $$1.ae());
            $$1.p();
            if (((agh)$$1).fj()) {
               ((agh)$$1).a(true, true);
            }

            if ($$2 == $$1.s) {
               ((agh)$$1).b.a($$3, $$4, $$5, $$11, $$12, $$6);
            } else {
               ((agh)$$1).a($$2, $$3, $$4, $$5, $$11, $$12);
            }

            $$1.l($$11);
         } else {
            float $$14 = ami.a($$12, -90.0F, 90.0F);
            if ($$2 == $$1.s) {
               $$1.b($$3, $$4, $$5, $$11, $$14);
               $$1.l($$11);
            } else {
               $$1.ab();
               bbn $$15 = $$1;
               $$1 = $$1.ad().a((cgx)$$2);
               if ($$1 == null) {
                  return;
               }

               $$1.t($$15);
               $$1.b($$3, $$4, $$5, $$11, $$14);
               $$1.l($$11);
               $$15.b(bbn.c.e);
               $$2.d($$1);
            }
         }

         if ($$9 != null) {
            $$9.a($$0, $$1);
         }

         if (!($$1 instanceof bcc) || !((bcc)$$1).fc()) {
            $$1.f($$1.dd().d(1.0D, 0.0D, 1.0D));
            $$1.c(true);
         }

         if ($$1 instanceof bcl) {
            ((bcl)$$1).D().n();
         }

      }
   }

   private static class a {
      private final dwq a;
      private final bbn b;
      private final ea.a c;

      public a(bbn $$0, ea.a $$1) {
         this.b = $$0;
         this.c = $$1;
         this.a = $$1.a($$0);
      }

      public a(dwq $$0) {
         this.b = null;
         this.a = $$0;
         this.c = null;
      }

      public void a(dr $$0, bbn $$1) {
         if (this.b != null) {
            if ($$1 instanceof agh) {
               ((agh)$$1).a($$0.n(), this.b, this.c);
            } else {
               $$1.a($$0.n(), this.a);
            }
         } else {
            $$1.a($$0.n(), this.a);
         }

      }
   }
}
