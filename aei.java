import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import javax.annotation.Nullable;

public class aei {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.spectate.self"));
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.spectate.not_spectator", $$0);
   });

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("spectate").requires(($$0x) -> {
         return $$0x.c(2);
      })).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), (bbn)null, ((dr)$$0x.getSource()).i());
      })).then(((RequiredArgumentBuilder)ds.a((String)"target", (ArgumentType)eb.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ((dr)$$0x.getSource()).i());
      })).then(ds.a((String)"player", (ArgumentType)eb.c()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), eb.e($$0x, "player"));
      }))));
   }

   private static int a(dr $$0, @Nullable bbn $$1, agh $$2) throws CommandSyntaxException {
      if ($$2 == $$1) {
         throw a.create();
      } else if ($$2.d.b() != cgu.d) {
         throw b.create($$2.C_());
      } else {
         $$2.c($$1);
         if ($$1 != null) {
            $$0.a(rq.a("commands.spectate.success.started", $$1.C_()), false);
         } else {
            $$0.a(rq.c("commands.spectate.success.stopped"), false);
         }

         return 1;
      }
   }
}
