import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.util.Collection;
import java.util.Iterator;

public class adb {
   public static final int a = 100;

   public static void a(CommandDispatcher<dr> $$0, dl $$1) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("give").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"targets", (ArgumentType)eb.d()).then(((RequiredArgumentBuilder)ds.a((String)"item", (ArgumentType)ft.a($$1)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ft.a($$0x, "item"), eb.f($$0x, "targets"), 1);
      })).then(ds.a((String)"count", (ArgumentType)IntegerArgumentType.integer(1)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ft.a($$0x, "item"), eb.f($$0x, "targets"), IntegerArgumentType.getInteger($$0x, "count"));
      })))));
   }

   private static int a(dr $$0, fu $$1, Collection<agh> $$2, int $$3) throws CommandSyntaxException {
      int $$4 = $$1.a().m();
      int $$5 = $$4 * 100;
      if ($$3 > $$5) {
         $$0.b((rq)rq.a("commands.give.failed.toomanyitems", $$5, $$1.a($$3, false).I()));
         return 0;
      } else {
         Iterator var6 = $$2.iterator();

         label44:
         while(var6.hasNext()) {
            agh $$6 = (agh)var6.next();
            int $$7 = $$3;

            while(true) {
               while(true) {
                  if ($$7 <= 0) {
                     continue label44;
                  }

                  int $$8 = Math.min($$4, $$7);
                  $$7 -= $$8;
                  cax $$9 = $$1.a($$8, false);
                  boolean $$10 = $$6.fA().e($$9);
                  bqv $$11;
                  if ($$10 && $$9.b()) {
                     $$9.e(1);
                     $$11 = $$6.a((cax)$$9, false);
                     if ($$11 != null) {
                        $$11.w();
                     }

                     $$6.s.a((buc)null, $$6.df(), $$6.dh(), $$6.dl(), ajw.kc, ajx.h, 0.2F, (($$6.dQ().i() - $$6.dQ().i()) * 0.7F + 1.0F) * 2.0F);
                     $$6.bU.d();
                  } else {
                     $$11 = $$6.a((cax)$$9, false);
                     if ($$11 != null) {
                        $$11.q();
                        $$11.b($$6.co());
                     }
                  }
               }
            }
         }

         if ($$2.size() == 1) {
            $$0.a(rq.a("commands.give.success.single", $$3, $$1.a($$3, false).I(), ((agh)$$2.iterator().next()).C_()), true);
         } else {
            $$0.a(rq.a("commands.give.success.single", $$3, $$1.a($$3, false).I(), $$2.size()), true);
         }

         return $$2.size();
      }
   }
}
