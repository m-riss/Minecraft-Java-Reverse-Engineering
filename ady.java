import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Iterator;

public class ady {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.save.alreadyOff"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("save-off").requires(($$0x) -> {
         return $$0x.c(4);
      })).executes(($$0x) -> {
         dr $$1 = (dr)$$0x.getSource();
         boolean $$2 = false;
         Iterator var3 = $$1.m().E().iterator();

         while(var3.hasNext()) {
            agg $$3 = (agg)var3.next();
            if ($$3 != null && !$$3.b) {
               $$3.b = true;
               $$2 = true;
            }
         }

         if (!$$2) {
            throw a.create();
         } else {
            $$1.a(rq.c("commands.save.disabled"), true);
            return 1;
         }
      }));
   }
}
