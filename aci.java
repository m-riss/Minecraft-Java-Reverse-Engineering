import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;

public class aci {
   private static final DynamicCommandExceptionType a = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("clear.failed.single", $$0);
   });
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("clear.failed.multiple", $$0);
   });

   public static void a(CommandDispatcher<dr> $$0, dl $$1) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("clear").requires(($$0x) -> {
         return $$0x.c(2);
      })).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), Collections.singleton(((dr)$$0x.getSource()).i()), ($$0) -> {
            return true;
         }, -1);
      })).then(((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.d()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), ($$0) -> {
            return true;
         }, -1);
      })).then(((RequiredArgumentBuilder)ds.a((String)"item", (ArgumentType)fw.a($$1)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), fw.a($$0x, "item"), -1);
      })).then(ds.a((String)"maxCount", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), fw.a($$0x, "item"), IntegerArgumentType.getInteger($$0x, "maxCount"));
      })))));
   }

   private static int a(dr $$0, Collection<agh> $$1, Predicate<cax> $$2, int $$3) throws CommandSyntaxException {
      int $$4 = 0;
      Iterator var5 = $$1.iterator();

      while(var5.hasNext()) {
         agh $$5 = (agh)var5.next();
         $$4 += $$5.fA().a($$2, $$3, $$5.bT.q());
         $$5.bU.d();
         $$5.bT.a((bac)$$5.fA());
      }

      if ($$4 == 0) {
         if ($$1.size() == 1) {
            throw a.create(((agh)$$1.iterator().next()).X());
         } else {
            throw b.create($$1.size());
         }
      } else {
         if ($$3 == 0) {
            if ($$1.size() == 1) {
               $$0.a(rq.a("commands.clear.test.single", $$4, ((agh)$$1.iterator().next()).C_()), true);
            } else {
               $$0.a(rq.a("commands.clear.test.multiple", $$4, $$1.size()), true);
            }
         } else if ($$1.size() == 1) {
            $$0.a(rq.a("commands.clear.success.single", $$4, ((agh)$$1.iterator().next()).C_()), true);
         } else {
            $$0.a(rq.a("commands.clear.success.multiple", $$4, $$1.size()), true);
         }

         return $$4;
      }
   }
}
