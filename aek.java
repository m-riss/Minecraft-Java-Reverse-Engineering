import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class aek {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("stop").requires(($$0x) -> {
         return $$0x.c(4);
      })).executes(($$0x) -> {
         ((dr)$$0x.getSource()).a(rq.c("commands.stop.stopping"), true);
         ((dr)$$0x.getSource()).m().a(false);
         return 1;
      }));
   }
}
