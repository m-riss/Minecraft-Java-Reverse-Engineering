import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import java.util.Collection;
import java.util.Iterator;

public class acy {
   public static final SuggestionProvider<dr> a = ($$0, $$1) -> {
      abo $$2 = ((dr)$$0.getSource()).m().aA();
      dt.a($$2.f(), $$1, "#");
      return dt.a($$2.e(), $$1);
   };

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("function").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"name", (ArgumentType)fs.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fs.a($$0x, "name"));
      })));
   }

   private static int a(dr $$0, Collection<dm> $$1) {
      int $$2 = 0;

      dm $$3;
      for(Iterator var3 = $$1.iterator(); var3.hasNext(); $$2 += $$0.m().aA().a($$3, $$0.a().b(2))) {
         $$3 = (dm)var3.next();
      }

      if ($$1.size() == 1) {
         $$0.a(rq.a("commands.function.success.single", $$2, ((dm)$$1.iterator().next()).a()), true);
      } else {
         $$0.a(rq.a("commands.function.success.multiple", $$2, $$1.size()), true);
      }

      return $$2;
   }
}
