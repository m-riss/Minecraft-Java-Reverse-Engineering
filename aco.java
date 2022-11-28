import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

public class aco {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.b("Source is not a mob"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.b("Path not found"));
   private static final SimpleCommandExceptionType c = new SimpleCommandExceptionType(rq.b("Target not reached"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("debugpath").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"to", (ArgumentType)fh.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "to"));
      })));
   }

   private static int a(dr $$0, gt $$1) throws CommandSyntaxException {
      bbn $$2 = $$0.g();
      if (!($$2 instanceof bce)) {
         throw a.create();
      } else {
         bce $$3 = (bce)$$2;
         blc $$4 = new blb($$3, $$0.f());
         dql $$5 = $$4.a((gt)$$1, 0);
         xl.a($$0.f(), $$3, $$5, $$4.r());
         if ($$5 == null) {
            throw b.create();
         } else if (!$$5.j()) {
            throw c.create();
         } else {
            $$0.a(rq.b("Made path"), true);
            return 1;
         }
      }
   }
}
