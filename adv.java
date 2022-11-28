import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.logging.LogUtils;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class adv {
   private static final Logger a = LogUtils.getLogger();

   public static void a(Collection<String> $$0, dr $$1) {
      $$1.m().a($$0).exceptionally(($$1x) -> {
         a.warn("Failed to execute reload", $$1x);
         $$1.b((rq)rq.c("commands.reload.failure"));
         return null;
      });
   }

   private static Collection<String> a(ahy $$0, drw $$1, Collection<String> $$2) {
      $$0.a();
      Collection<String> $$3 = Lists.newArrayList($$2);
      Collection<String> $$4 = $$1.D().b();
      Iterator var5 = $$0.b().iterator();

      while(var5.hasNext()) {
         String $$5 = (String)var5.next();
         if (!$$4.contains($$5) && !$$3.contains($$5)) {
            $$3.add($$5);
         }
      }

      return $$3;
   }

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("reload").requires(($$0x) -> {
         return $$0x.c(2);
      })).executes(($$0x) -> {
         dr $$1 = (dr)$$0x.getSource();
         MinecraftServer $$2 = $$1.m();
         ahy $$3 = $$2.aB();
         drw $$4 = $$2.aW();
         Collection<String> $$5 = $$3.d();
         Collection<String> $$6 = a($$3, $$4, $$5);
         $$1.a(rq.c("commands.reload.success"), true);
         a($$6, $$1);
         return 0;
      }));
   }
}
