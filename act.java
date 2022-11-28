import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;
import java.util.Iterator;

public class act {
   private static final DynamicCommandExceptionType a = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.enchant.failed.entity", $$0);
   });
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.enchant.failed.itemless", $$0);
   });
   private static final DynamicCommandExceptionType c = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.enchant.failed.incompatible", $$0);
   });
   private static final Dynamic2CommandExceptionType d = new Dynamic2CommandExceptionType(($$0, $$1) -> {
      return rq.a("commands.enchant.failed.level", $$0, $$1);
   });
   private static final SimpleCommandExceptionType e = new SimpleCommandExceptionType(rq.c("commands.enchant.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("enchant").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"targets", (ArgumentType)eb.b()).then(((RequiredArgumentBuilder)ds.a((String)"enchantment", (ArgumentType)ee.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ee.a($$0x, "enchantment"), 1);
      })).then(ds.a((String)"level", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ee.a($$0x, "enchantment"), IntegerArgumentType.getInteger($$0x, "level"));
      })))));
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1, cer $$2, int $$3) throws CommandSyntaxException {
      if ($$3 > $$2.a()) {
         throw d.create($$3, $$2.a());
      } else {
         int $$4 = 0;
         Iterator var5 = $$1.iterator();

         while(true) {
            while(true) {
               while(true) {
                  while(var5.hasNext()) {
                     bbn $$5 = (bbn)var5.next();
                     if ($$5 instanceof bcc) {
                        bcc $$6 = (bcc)$$5;
                        cax $$7 = $$6.ez();
                        if (!$$7.b()) {
                           if ($$2.a($$7) && cet.a((Collection)cet.a($$7).keySet(), (cer)$$2)) {
                              $$7.a($$2, $$3);
                              ++$$4;
                           } else if ($$1.size() == 1) {
                              throw c.create($$7.c().m($$7).getString());
                           }
                        } else if ($$1.size() == 1) {
                           throw b.create($$6.X().getString());
                        }
                     } else if ($$1.size() == 1) {
                        throw a.create($$5.X().getString());
                     }
                  }

                  if ($$4 == 0) {
                     throw e.create();
                  }

                  if ($$1.size() == 1) {
                     $$0.a(rq.a("commands.enchant.success.single", $$2.d($$3), ((bbn)$$1.iterator().next()).C_()), true);
                  } else {
                     $$0.a(rq.a("commands.enchant.success.multiple", $$2.d($$3), $$1.size()), true);
                  }

                  return $$4;
               }
            }
         }
      }
   }
}
