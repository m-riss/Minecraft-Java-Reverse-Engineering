import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.Collection;
import java.util.Iterator;

public class ace {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("banlist").requires(($$0x) -> {
         return $$0x.c(3);
      })).executes(($$0x) -> {
         aiz $$1 = ((dr)$$0x.getSource()).m().ac();
         return a((dr)$$0x.getSource(), Lists.newArrayList(Iterables.concat($$1.f().d(), $$1.g().d())));
      })).then(ds.a("ips").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ((dr)$$0x.getSource()).m().ac().g().d());
      }))).then(ds.a("players").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ((dr)$$0x.getSource()).m().ac().f().d());
      })));
   }

   private static int a(dr $$0, Collection<? extends aiu<?>> $$1) {
      if ($$1.isEmpty()) {
         $$0.a(rq.c("commands.banlist.none"), false);
      } else {
         $$0.a(rq.a("commands.banlist.list", $$1.size()), false);
         Iterator var2 = $$1.iterator();

         while(var2.hasNext()) {
            aiu<?> $$2 = (aiu)var2.next();
            $$0.a(rq.a("commands.banlist.entry", $$2.e(), $$2.b(), $$2.d()), false);
         }
      }

      return $$1.size();
   }
}
