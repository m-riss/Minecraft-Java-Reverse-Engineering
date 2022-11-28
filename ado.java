import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;
import java.util.Iterator;

public class ado {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.particle.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("particle").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(((RequiredArgumentBuilder)ds.a((String)"name", (ArgumentType)em.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), em.a($$0x, "name"), ((dr)$$0x.getSource()).e(), dwq.b, 0.0F, 0, false, ((dr)$$0x.getSource()).m().ac().t());
      })).then(((RequiredArgumentBuilder)ds.a((String)"pos", (ArgumentType)fo.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), em.a($$0x, "name"), fo.a($$0x, "pos"), dwq.b, 0.0F, 0, false, ((dr)$$0x.getSource()).m().ac().t());
      })).then(ds.a((String)"delta", (ArgumentType)fo.a(false)).then(ds.a((String)"speed", (ArgumentType)FloatArgumentType.floatArg(0.0F)).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"count", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), em.a($$0x, "name"), fo.a($$0x, "pos"), fo.a($$0x, "delta"), FloatArgumentType.getFloat($$0x, "speed"), IntegerArgumentType.getInteger($$0x, "count"), false, ((dr)$$0x.getSource()).m().ac().t());
      })).then(((LiteralArgumentBuilder)ds.a("force").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), em.a($$0x, "name"), fo.a($$0x, "pos"), fo.a($$0x, "delta"), FloatArgumentType.getFloat($$0x, "speed"), IntegerArgumentType.getInteger($$0x, "count"), true, ((dr)$$0x.getSource()).m().ac().t());
      })).then(ds.a((String)"viewers", (ArgumentType)eb.d()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), em.a($$0x, "name"), fo.a($$0x, "pos"), fo.a($$0x, "delta"), FloatArgumentType.getFloat($$0x, "speed"), IntegerArgumentType.getInteger($$0x, "count"), true, eb.f($$0x, "viewers"));
      })))).then(((LiteralArgumentBuilder)ds.a("normal").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), em.a($$0x, "name"), fo.a($$0x, "pos"), fo.a($$0x, "delta"), FloatArgumentType.getFloat($$0x, "speed"), IntegerArgumentType.getInteger($$0x, "count"), false, ((dr)$$0x.getSource()).m().ac().t());
      })).then(ds.a((String)"viewers", (ArgumentType)eb.d()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), em.a($$0x, "name"), fo.a($$0x, "pos"), fo.a($$0x, "delta"), FloatArgumentType.getFloat($$0x, "speed"), IntegerArgumentType.getInteger($$0x, "count"), false, eb.f($$0x, "viewers"));
      })))))))));
   }

   private static int a(dr $$0, im $$1, dwq $$2, dwq $$3, float $$4, int $$5, boolean $$6, Collection<agh> $$7) throws CommandSyntaxException {
      int $$8 = 0;
      Iterator var9 = $$7.iterator();

      while(var9.hasNext()) {
         agh $$9 = (agh)var9.next();
         if ($$0.f().a($$9, $$1, $$6, $$2.c, $$2.d, $$2.e, $$5, $$3.c, $$3.d, $$3.e, (double)$$4)) {
            ++$$8;
         }
      }

      if ($$8 == 0) {
         throw a.create();
      } else {
         $$0.a(rq.a("commands.particle.success", hm.aa.b((Object)$$1.b()).toString()), true);
         return $$8;
      }
   }
}
