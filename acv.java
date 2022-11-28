import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class acv {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.experience.set.points.invalid"));

   public static void a(CommandDispatcher<dr> $$0) {
      LiteralCommandNode<dr> $$1 = $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("experience").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("add").then(ds.a((String)"targets", (ArgumentType)eb.d()).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"amount", (ArgumentType)IntegerArgumentType.integer()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), IntegerArgumentType.getInteger($$0x, "amount"), acv.a.a);
      })).then(ds.a("points").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), IntegerArgumentType.getInteger($$0x, "amount"), acv.a.a);
      }))).then(ds.a("levels").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), IntegerArgumentType.getInteger($$0x, "amount"), acv.a.b);
      })))))).then(ds.a("set").then(ds.a((String)"targets", (ArgumentType)eb.d()).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"amount", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), eb.f($$0x, "targets"), IntegerArgumentType.getInteger($$0x, "amount"), acv.a.a);
      })).then(ds.a("points").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), eb.f($$0x, "targets"), IntegerArgumentType.getInteger($$0x, "amount"), acv.a.a);
      }))).then(ds.a("levels").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), eb.f($$0x, "targets"), IntegerArgumentType.getInteger($$0x, "amount"), acv.a.b);
      })))))).then(ds.a("query").then(((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.c()).then(ds.a("points").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.e($$0x, "targets"), acv.a.a);
      }))).then(ds.a("levels").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.e($$0x, "targets"), acv.a.b);
      })))));
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("xp").requires(($$0x) -> {
         return $$0x.c(2);
      })).redirect($$1));
   }

   private static int a(dr $$0, agh $$1, acv.a $$2) {
      int $$3 = $$2.f.applyAsInt($$1);
      $$0.a(rq.a("commands.experience.query." + $$2.e, $$1.C_(), $$3), false);
      return $$3;
   }

   private static int a(dr $$0, Collection<? extends agh> $$1, int $$2, acv.a $$3) {
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         agh $$4 = (agh)var4.next();
         $$3.c.accept($$4, $$2);
      }

      if ($$1.size() == 1) {
         $$0.a(rq.a("commands.experience.add." + $$3.e + ".success.single", $$2, ((agh)$$1.iterator().next()).C_()), true);
      } else {
         $$0.a(rq.a("commands.experience.add." + $$3.e + ".success.multiple", $$2, $$1.size()), true);
      }

      return $$1.size();
   }

   private static int b(dr $$0, Collection<? extends agh> $$1, int $$2, acv.a $$3) throws CommandSyntaxException {
      int $$4 = 0;
      Iterator var5 = $$1.iterator();

      while(var5.hasNext()) {
         agh $$5 = (agh)var5.next();
         if ($$3.d.test($$5, $$2)) {
            ++$$4;
         }
      }

      if ($$4 == 0) {
         throw a.create();
      } else {
         if ($$1.size() == 1) {
            $$0.a(rq.a("commands.experience.set." + $$3.e + ".success.single", $$2, ((agh)$$1.iterator().next()).C_()), true);
         } else {
            $$0.a(rq.a("commands.experience.set." + $$3.e + ".success.multiple", $$2, $$1.size()), true);
         }

         return $$1.size();
      }
   }

   static enum a {
      a("points", buc::d, ($$0, $$1) -> {
         if ($$1 >= $$0.fJ()) {
            return false;
         } else {
            $$0.a($$1);
            return true;
         }
      }, ($$0) -> {
         return ami.d($$0.ck * (float)$$0.fJ());
      }),
      b("levels", agh::c, ($$0, $$1) -> {
         $$0.b($$1);
         return true;
      }, ($$0) -> {
         return $$0.ci;
      });

      public final BiConsumer<agh, Integer> c;
      public final BiPredicate<agh, Integer> d;
      public final String e;
      final ToIntFunction<agh> f;

      private a(String $$0, BiConsumer<agh, Integer> $$1, BiPredicate<agh, Integer> $$2, ToIntFunction<agh> $$3) {
         this.c = $$1;
         this.e = $$0;
         this.d = $$2;
         this.f = $$3;
      }

      // $FF: synthetic method
      private static acv.a[] a() {
         return new acv.a[]{a, b};
      }
   }
}
