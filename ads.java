import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

public class ads {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.publish.failed"));
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.publish.alreadyPublished", $$0);
   });

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("publish").requires(($$0x) -> {
         return $$0x.c(4);
      })).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ama.a());
      })).then(ds.a((String)"port", (ArgumentType)IntegerArgumentType.integer(0, 65535)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "port"));
      })));
   }

   private static int a(dr $$0, int $$1) throws CommandSyntaxException {
      if ($$0.m().o()) {
         throw b.create($$0.m().L());
      } else if (!$$0.m().a((cgu)null, false, $$1)) {
         throw a.create();
      } else {
         $$0.a(rq.a("commands.publish.success", $$1), true);
         return $$1;
      }
   }
}
