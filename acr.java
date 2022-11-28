import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

public class acr {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.effect.give.failed"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.effect.clear.everything.failed"));
   private static final SimpleCommandExceptionType c = new SimpleCommandExceptionType(rq.c("commands.effect.clear.specific.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("effect").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(((LiteralArgumentBuilder)ds.a("clear").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ImmutableList.of(((dr)$$0x.getSource()).h()));
      })).then(((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.b()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"));
      })).then(ds.a((String)"effect", (ArgumentType)eg.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), eg.a($$0x, "effect"));
      }))))).then(ds.a("give").then(ds.a((String)"targets", (ArgumentType)eb.b()).then(((RequiredArgumentBuilder)ds.a((String)"effect", (ArgumentType)eg.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), eg.a($$0x, "effect"), (Integer)null, 0, true);
      })).then(((RequiredArgumentBuilder)ds.a((String)"seconds", (ArgumentType)IntegerArgumentType.integer(1, 1000000)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), eg.a($$0x, "effect"), IntegerArgumentType.getInteger($$0x, "seconds"), 0, true);
      })).then(((RequiredArgumentBuilder)ds.a((String)"amplifier", (ArgumentType)IntegerArgumentType.integer(0, 255)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), eg.a($$0x, "effect"), IntegerArgumentType.getInteger($$0x, "seconds"), IntegerArgumentType.getInteger($$0x, "amplifier"), true);
      })).then(ds.a((String)"hideParticles", (ArgumentType)BoolArgumentType.bool()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), eg.a($$0x, "effect"), IntegerArgumentType.getInteger($$0x, "seconds"), IntegerArgumentType.getInteger($$0x, "amplifier"), !BoolArgumentType.getBool($$0x, "hideParticles"));
      }))))))));
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1, bbe $$2, @Nullable Integer $$3, int $$4, boolean $$5) throws CommandSyntaxException {
      int $$6 = 0;
      int $$10;
      if ($$3 != null) {
         if ($$2.a()) {
            $$10 = $$3;
         } else {
            $$10 = $$3 * 20;
         }
      } else if ($$2.a()) {
         $$10 = 1;
      } else {
         $$10 = 600;
      }

      Iterator var8 = $$1.iterator();

      while(var8.hasNext()) {
         bbn $$11 = (bbn)var8.next();
         if ($$11 instanceof bcc) {
            bbg $$12 = new bbg($$2, $$10, $$4, false, $$5);
            if (((bcc)$$11).b($$12, $$0.g())) {
               ++$$6;
            }
         }
      }

      if ($$6 == 0) {
         throw a.create();
      } else {
         if ($$1.size() == 1) {
            $$0.a(rq.a("commands.effect.give.success.single", $$2.e(), ((bbn)$$1.iterator().next()).C_(), $$10 / 20), true);
         } else {
            $$0.a(rq.a("commands.effect.give.success.multiple", $$2.e(), $$1.size(), $$10 / 20), true);
         }

         return $$6;
      }
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1) throws CommandSyntaxException {
      int $$2 = 0;
      Iterator var3 = $$1.iterator();

      while(var3.hasNext()) {
         bbn $$3 = (bbn)var3.next();
         if ($$3 instanceof bcc && ((bcc)$$3).eb()) {
            ++$$2;
         }
      }

      if ($$2 == 0) {
         throw b.create();
      } else {
         if ($$1.size() == 1) {
            $$0.a(rq.a("commands.effect.clear.everything.success.single", ((bbn)$$1.iterator().next()).C_()), true);
         } else {
            $$0.a(rq.a("commands.effect.clear.everything.success.multiple", $$1.size()), true);
         }

         return $$2;
      }
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1, bbe $$2) throws CommandSyntaxException {
      int $$3 = 0;
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         bbn $$4 = (bbn)var4.next();
         if ($$4 instanceof bcc && ((bcc)$$4).d($$2)) {
            ++$$3;
         }
      }

      if ($$3 == 0) {
         throw c.create();
      } else {
         if ($$1.size() == 1) {
            $$0.a(rq.a("commands.effect.clear.specific.success.single", $$2.e(), ((bbn)$$1.iterator().next()).C_()), true);
         } else {
            $$0.a(rq.a("commands.effect.clear.specific.success.multiple", $$2.e(), $$1.size()), true);
         }

         return $$3;
      }
   }
}
