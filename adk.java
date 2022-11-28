import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import java.util.Collection;
import java.util.Iterator;

public class adk {
   public static void a(CommandDispatcher<dr> $$0) {
      LiteralCommandNode<dr> $$1 = $$0.register((LiteralArgumentBuilder)ds.a("msg").then(ds.a((String)"targets", (ArgumentType)eb.d()).then(ds.a((String)"message", (ArgumentType)ef.a()).executes(($$0x) -> {
         ef.a $$1 = ef.b($$0x, "message");

         try {
            return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), $$1);
         } catch (Exception var3) {
            $$1.a((dr)$$0x.getSource());
            throw var3;
         }
      }))));
      $$0.register((LiteralArgumentBuilder)ds.a("tell").redirect($$1));
      $$0.register((LiteralArgumentBuilder)ds.a("w").redirect($$1));
   }

   private static int a(dr $$0, Collection<agh> $$1, ef.a $$2) {
      rm.a $$3 = rm.a(rm.e, $$0);
      $$2.a($$0, ($$3x) -> {
         sc $$4 = sc.a($$3x);
         boolean $$5 = $$3x.h();
         bbn $$6 = $$0.g();
         boolean $$7 = false;

         agh $$8;
         boolean $$10;
         for(Iterator var8 = $$1.iterator(); var8.hasNext(); $$7 |= $$5 && $$10 && $$8 != $$6) {
            $$8 = (agh)var8.next();
            rm.a $$9 = rm.a(rm.f, $$0).c($$8.C_());
            $$0.a($$4, false, $$9);
            $$10 = $$0.a($$8);
            $$8.a($$4, $$10, $$3);
         }

         if ($$7) {
            $$0.a(aiz.f);
         }

         $$4.a($$0.m().ac());
      });
      return $$1.size();
   }
}
