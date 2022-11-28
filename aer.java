import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.Iterator;

public class aer {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("tellraw").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"targets", (ArgumentType)eb.d()).then(ds.a((String)"message", (ArgumentType)dx.a()).executes(($$0x) -> {
         int $$1 = 0;

         for(Iterator var2 = eb.f($$0x, "targets").iterator(); var2.hasNext(); ++$$1) {
            agh $$2 = (agh)var2.next();
            $$2.b(rs.a((dr)$$0x.getSource(), (rq)dx.a($$0x, "message"), $$2, 0), false);
         }

         return $$1;
      }))));
   }
}
