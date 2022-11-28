import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class aew {
   private static final int a = 6000;

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("weather").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(((LiteralArgumentBuilder)ds.a("clear").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), 6000);
      })).then(ds.a((String)"duration", (ArgumentType)IntegerArgumentType.integer(0, 1000000)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "duration") * 20);
      })))).then(((LiteralArgumentBuilder)ds.a("rain").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), 6000);
      })).then(ds.a((String)"duration", (ArgumentType)IntegerArgumentType.integer(0, 1000000)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "duration") * 20);
      })))).then(((LiteralArgumentBuilder)ds.a("thunder").executes(($$0x) -> {
         return c((dr)$$0x.getSource(), 6000);
      })).then(ds.a((String)"duration", (ArgumentType)IntegerArgumentType.integer(0, 1000000)).executes(($$0x) -> {
         return c((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "duration") * 20);
      }))));
   }

   private static int a(dr $$0, int $$1) {
      $$0.f().a($$1, 0, false, false);
      $$0.a(rq.c("commands.weather.set.clear"), true);
      return $$1;
   }

   private static int b(dr $$0, int $$1) {
      $$0.f().a(0, $$1, true, false);
      $$0.a(rq.c("commands.weather.set.rain"), true);
      return $$1;
   }

   private static int c(dr $$0, int $$1) {
      $$0.f().a(0, $$1, true, true);
      $$0.a(rq.c("commands.weather.set.thunder"), true);
      return $$1;
   }
}
