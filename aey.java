import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Locale;

public class aey {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.worldborder.center.failed"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.worldborder.set.failed.nochange"));
   private static final SimpleCommandExceptionType c = new SimpleCommandExceptionType(rq.c("commands.worldborder.set.failed.small"));
   private static final SimpleCommandExceptionType d = new SimpleCommandExceptionType(rq.a("commands.worldborder.set.failed.big", 5.9999968E7D));
   private static final SimpleCommandExceptionType e = new SimpleCommandExceptionType(rq.a("commands.worldborder.set.failed.far", 2.9999984E7D));
   private static final SimpleCommandExceptionType f = new SimpleCommandExceptionType(rq.c("commands.worldborder.warning.time.failed"));
   private static final SimpleCommandExceptionType g = new SimpleCommandExceptionType(rq.c("commands.worldborder.warning.distance.failed"));
   private static final SimpleCommandExceptionType h = new SimpleCommandExceptionType(rq.c("commands.worldborder.damage.buffer.failed"));
   private static final SimpleCommandExceptionType i = new SimpleCommandExceptionType(rq.c("commands.worldborder.damage.amount.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("worldborder").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("add").then(((RequiredArgumentBuilder)ds.a((String)"distance", (ArgumentType)DoubleArgumentType.doubleArg(-5.9999968E7D, 5.9999968E7D)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ((dr)$$0x.getSource()).f().p_().i() + DoubleArgumentType.getDouble($$0x, "distance"), 0L);
      })).then(ds.a((String)"time", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ((dr)$$0x.getSource()).f().p_().i() + DoubleArgumentType.getDouble($$0x, "distance"), ((dr)$$0x.getSource()).f().p_().j() + (long)IntegerArgumentType.getInteger($$0x, "time") * 1000L);
      }))))).then(ds.a("set").then(((RequiredArgumentBuilder)ds.a((String)"distance", (ArgumentType)DoubleArgumentType.doubleArg(-5.9999968E7D, 5.9999968E7D)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), DoubleArgumentType.getDouble($$0x, "distance"), 0L);
      })).then(ds.a((String)"time", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), DoubleArgumentType.getDouble($$0x, "distance"), (long)IntegerArgumentType.getInteger($$0x, "time") * 1000L);
      }))))).then(ds.a("center").then(ds.a((String)"pos", (ArgumentType)fn.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fn.a($$0x, "pos"));
      })))).then(((LiteralArgumentBuilder)ds.a("damage").then(ds.a("amount").then(ds.a((String)"damagePerBlock", (ArgumentType)FloatArgumentType.floatArg(0.0F)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), FloatArgumentType.getFloat($$0x, "damagePerBlock"));
      })))).then(ds.a("buffer").then(ds.a((String)"distance", (ArgumentType)FloatArgumentType.floatArg(0.0F)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), FloatArgumentType.getFloat($$0x, "distance"));
      }))))).then(ds.a("get").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      }))).then(((LiteralArgumentBuilder)ds.a("warning").then(ds.a("distance").then(ds.a((String)"distance", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "distance"));
      })))).then(ds.a("time").then(ds.a((String)"time", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "time"));
      })))));
   }

   private static int a(dr $$0, float $$1) throws CommandSyntaxException {
      cxe $$2 = $$0.m().C().p_();
      if ($$2.n() == (double)$$1) {
         throw h.create();
      } else {
         $$2.b((double)$$1);
         $$0.a(rq.a("commands.worldborder.damage.buffer.success", String.format(Locale.ROOT, "%.2f", $$1)), true);
         return (int)$$1;
      }
   }

   private static int b(dr $$0, float $$1) throws CommandSyntaxException {
      cxe $$2 = $$0.m().C().p_();
      if ($$2.o() == (double)$$1) {
         throw i.create();
      } else {
         $$2.c((double)$$1);
         $$0.a(rq.a("commands.worldborder.damage.amount.success", String.format(Locale.ROOT, "%.2f", $$1)), true);
         return (int)$$1;
      }
   }

   private static int a(dr $$0, int $$1) throws CommandSyntaxException {
      cxe $$2 = $$0.m().C().p_();
      if ($$2.q() == $$1) {
         throw f.create();
      } else {
         $$2.b($$1);
         $$0.a(rq.a("commands.worldborder.warning.time.success", $$1), true);
         return $$1;
      }
   }

   private static int b(dr $$0, int $$1) throws CommandSyntaxException {
      cxe $$2 = $$0.m().C().p_();
      if ($$2.r() == $$1) {
         throw g.create();
      } else {
         $$2.c($$1);
         $$0.a(rq.a("commands.worldborder.warning.distance.success", $$1), true);
         return $$1;
      }
   }

   private static int a(dr $$0) {
      double $$1 = $$0.m().C().p_().i();
      $$0.a(rq.a("commands.worldborder.get", String.format(Locale.ROOT, "%.0f", $$1)), false);
      return ami.b($$1 + 0.5D);
   }

   private static int a(dr $$0, dwp $$1) throws CommandSyntaxException {
      cxe $$2 = $$0.m().C().p_();
      if ($$2.a() == (double)$$1.i && $$2.b() == (double)$$1.j) {
         throw a.create();
      } else if (!((double)Math.abs($$1.i) > 2.9999984E7D) && !((double)Math.abs($$1.j) > 2.9999984E7D)) {
         $$2.c((double)$$1.i, (double)$$1.j);
         $$0.a(rq.a("commands.worldborder.center.success", String.format(Locale.ROOT, "%.2f", $$1.i), String.format(Locale.ROOT, "%.2f", $$1.j)), true);
         return 0;
      } else {
         throw e.create();
      }
   }

   private static int a(dr $$0, double $$1, long $$2) throws CommandSyntaxException {
      cxe $$3 = $$0.m().C().p_();
      double $$4 = $$3.i();
      if ($$4 == $$1) {
         throw b.create();
      } else if ($$1 < 1.0D) {
         throw c.create();
      } else if ($$1 > 5.9999968E7D) {
         throw d.create();
      } else {
         if ($$2 > 0L) {
            $$3.a($$4, $$1, $$2);
            if ($$1 > $$4) {
               $$0.a(rq.a("commands.worldborder.set.grow", String.format(Locale.ROOT, "%.1f", $$1), Long.toString($$2 / 1000L)), true);
            } else {
               $$0.a(rq.a("commands.worldborder.set.shrink", String.format(Locale.ROOT, "%.1f", $$1), Long.toString($$2 / 1000L)), true);
            }
         } else {
            $$3.a($$1);
            $$0.a(rq.a("commands.worldborder.set.immediate", String.format(Locale.ROOT, "%.1f", $$1)), true);
         }

         return (int)($$1 - $$4);
      }
   }
}
