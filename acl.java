import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;
import java.util.Iterator;

public class acl {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.deop.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("deop").requires(($$0x) -> {
         return $$0x.c(3);
      })).then(ds.a((String)"targets", (ArgumentType)ed.a()).suggests(($$0x, $$1) -> {
         return dt.a(((dr)$$0x.getSource()).m().ac().l(), $$1);
      }).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ed.a($$0x, "targets"));
      })));
   }

   private static int a(dr $$0, Collection<GameProfile> $$1) throws CommandSyntaxException {
      aiz $$2 = $$0.m().ac();
      int $$3 = 0;
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         GameProfile $$4 = (GameProfile)var4.next();
         if ($$2.e($$4)) {
            $$2.b($$4);
            ++$$3;
            $$0.a(rq.a("commands.deop.success", ((GameProfile)$$1.iterator().next()).getName()), true);
         }
      }

      if ($$3 == 0) {
         throw a.create();
      } else {
         $$0.m().a($$0);
         return $$3;
      }
   }
}
