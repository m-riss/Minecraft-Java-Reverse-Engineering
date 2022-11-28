import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Collection;
import java.util.Iterator;

public class adf {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("kick").requires(($$0x) -> {
         return $$0x.c(3);
      })).then(((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.d()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), rq.c("multiplayer.disconnect.kicked"));
      })).then(ds.a((String)"reason", (ArgumentType)ef.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), ef.a($$0x, "reason"));
      }))));
   }

   private static int a(dr $$0, Collection<agh> $$1, rq $$2) {
      Iterator var3 = $$1.iterator();

      while(var3.hasNext()) {
         agh $$3 = (agh)var3.next();
         $$3.b.b($$2);
         $$0.a(rq.a("commands.kick.success", $$3.C_(), $$2), true);
      }

      return $$1.size();
   }
}
