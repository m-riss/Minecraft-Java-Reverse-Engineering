import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ade {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.jfr.start.failed"));
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.jfr.dump.failed", $$0);
   });

   private ade() {
   }

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("jfr").requires(($$0x) -> {
         return $$0x.c(4);
      })).then(ds.a("start").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      }))).then(ds.a("stop").executes(($$0x) -> {
         return b((dr)$$0x.getSource());
      })));
   }

   private static int a(dr $$0) throws CommandSyntaxException {
      axd $$1 = axd.a($$0.m());
      if (!axf.e.a($$1)) {
         throw a.create();
      } else {
         $$0.a(rq.c("commands.jfr.started"), false);
         return 1;
      }
   }

   private static int b(dr $$0) throws CommandSyntaxException {
      try {
         Path $$1 = Paths.get(".").relativize(axf.e.b().normalize());
         Path $$2 = $$0.m().o() && !ab.aL ? $$1 : $$1.toAbsolutePath();
         rq $$3 = rq.b($$1.toString()).a(p.t).a(($$1x) -> {
            return $$1x.a(new ro(ro.a.f, $$2.toString())).a(new rv(rv.a.a, rq.c("chat.copy.click")));
         });
         $$0.a(rq.a("commands.jfr.stopped", $$3), false);
         return 1;
      } catch (Throwable var4) {
         throw b.create(var4.getMessage());
      }
   }
}
