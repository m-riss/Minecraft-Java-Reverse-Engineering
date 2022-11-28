import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.regex.Matcher;

public class adn {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.pardonip.invalid"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.pardonip.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("pardon-ip").requires(($$0x) -> {
         return $$0x.c(3);
      })).then(ds.a((String)"target", (ArgumentType)StringArgumentType.word()).suggests(($$0x, $$1) -> {
         return dt.a(((dr)$$0x.getSource()).m().ac().g().a(), $$1);
      }).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), StringArgumentType.getString($$0x, "target"));
      })));
   }

   private static int a(dr $$0, String $$1) throws CommandSyntaxException {
      Matcher $$2 = acd.a.matcher($$1);
      if (!$$2.matches()) {
         throw a.create();
      } else {
         aiw $$3 = $$0.m().ac().g();
         if (!$$3.a($$1)) {
            throw b.create();
         } else {
            $$3.c($$1);
            $$0.a(rq.a("commands.pardonip.success", $$1), true);
            return 1;
         }
      }
   }
}
