import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

public class ael {
   public static void a(CommandDispatcher<dr> $$0) {
      RequiredArgumentBuilder<dr, fz> $$1 = (RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.d()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), (ajx)null, (abb)null);
      })).then(ds.a("*").then(ds.a((String)"sound", (ArgumentType)eq.a()).suggests(gj.c).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), (ajx)null, eq.e($$0x, "sound"));
      })));
      ajx[] var2 = ajx.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ajx $$2 = var2[var4];
         $$1.then(((LiteralArgumentBuilder)ds.a($$2.a()).executes(($$1x) -> {
            return a((dr)$$1x.getSource(), eb.f($$1x, "targets"), $$2, (abb)null);
         })).then(ds.a((String)"sound", (ArgumentType)eq.a()).suggests(gj.c).executes(($$1x) -> {
            return a((dr)$$1x.getSource(), eb.f($$1x, "targets"), $$2, eq.e($$1x, "sound"));
         })));
      }

      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("stopsound").requires(($$0x) -> {
         return $$0x.c(2);
      })).then($$1));
   }

   private static int a(dr $$0, Collection<agh> $$1, @Nullable ajx $$2, @Nullable abb $$3) {
      wz $$4 = new wz($$3, $$2);
      Iterator var5 = $$1.iterator();

      while(var5.hasNext()) {
         agh $$5 = (agh)var5.next();
         $$5.b.a((tc)$$4);
      }

      if ($$2 != null) {
         if ($$3 != null) {
            $$0.a(rq.a("commands.stopsound.success.source.sound", $$3, $$2.a()), true);
         } else {
            $$0.a(rq.a("commands.stopsound.success.source.any", $$2.a()), true);
         }
      } else if ($$3 != null) {
         $$0.a(rq.a("commands.stopsound.success.sourceless.sound", $$3), true);
      } else {
         $$0.a(rq.c("commands.stopsound.success.sourceless.any"), true);
      }

      return $$1.size();
   }
}
