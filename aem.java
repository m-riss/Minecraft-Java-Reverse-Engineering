import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

public class aem {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.summon.failed"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.summon.failed.uuid"));
   private static final SimpleCommandExceptionType c = new SimpleCommandExceptionType(rq.c("commands.summon.invalidPosition"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("summon").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(((RequiredArgumentBuilder)ds.a((String)"entity", (ArgumentType)ec.a()).suggests(gj.d).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ec.a($$0x, "entity"), ((dr)$$0x.getSource()).e(), new pj(), true);
      })).then(((RequiredArgumentBuilder)ds.a((String)"pos", (ArgumentType)fo.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ec.a($$0x, "entity"), fo.a($$0x, "pos"), new pj(), true);
      })).then(ds.a((String)"nbt", (ArgumentType)dy.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ec.a($$0x, "entity"), fo.a($$0x, "pos"), dy.a($$0x, "nbt"), false);
      })))));
   }

   private static int a(dr $$0, abb $$1, dwq $$2, pj $$3, boolean $$4) throws CommandSyntaxException {
      gt $$5 = new gt($$2);
      if (!cgx.k($$5)) {
         throw c.create();
      } else {
         pj $$6 = $$3.g();
         $$6.a("id", $$1.toString());
         agg $$7 = $$0.f();
         bbn $$8 = bbr.a($$6, $$7, ($$1x) -> {
            $$1x.b($$2.c, $$2.d, $$2.e, $$1x.dq(), $$1x.ds());
            return $$1x;
         });
         if ($$8 == null) {
            throw a.create();
         } else {
            if ($$4 && $$8 instanceof bce) {
               ((bce)$$8).a((chm)$$0.f(), (bah)$$0.f().d_($$8.da()), bcg.n, (bcu)null, (pj)null);
            }

            if (!$$7.e($$8)) {
               throw b.create();
            } else {
               $$0.a(rq.a("commands.summon.success", $$8.C_()), true);
               return 1;
            }
         }
      }
   }
}
