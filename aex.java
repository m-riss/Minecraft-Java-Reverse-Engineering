import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;
import java.util.Iterator;

public class aex {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.whitelist.alreadyOn"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.whitelist.alreadyOff"));
   private static final SimpleCommandExceptionType c = new SimpleCommandExceptionType(rq.c("commands.whitelist.add.failed"));
   private static final SimpleCommandExceptionType d = new SimpleCommandExceptionType(rq.c("commands.whitelist.remove.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("whitelist").requires(($$0x) -> {
         return $$0x.c(3);
      })).then(ds.a("on").executes(($$0x) -> {
         return b((dr)$$0x.getSource());
      }))).then(ds.a("off").executes(($$0x) -> {
         return c((dr)$$0x.getSource());
      }))).then(ds.a("list").executes(($$0x) -> {
         return d((dr)$$0x.getSource());
      }))).then(ds.a("add").then(ds.a((String)"targets", (ArgumentType)ed.a()).suggests(($$0x, $$1) -> {
         aiz $$2 = ((dr)$$0x.getSource()).m().ac();
         return dt.b($$2.t().stream().filter(($$1x) -> {
            return !$$2.i().a($$1x.fy());
         }).map(($$0) -> {
            return $$0.fy().getName();
         }), $$1);
      }).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ed.a($$0x, "targets"));
      })))).then(ds.a("remove").then(ds.a((String)"targets", (ArgumentType)ed.a()).suggests(($$0x, $$1) -> {
         return dt.a(((dr)$$0x.getSource()).m().ac().j(), $$1);
      }).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ed.a($$0x, "targets"));
      })))).then(ds.a("reload").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      })));
   }

   private static int a(dr $$0) {
      $$0.m().ac().a();
      $$0.a(rq.c("commands.whitelist.reloaded"), true);
      $$0.m().a($$0);
      return 1;
   }

   private static int a(dr $$0, Collection<GameProfile> $$1) throws CommandSyntaxException {
      ajh $$2 = $$0.m().ac().i();
      int $$3 = 0;
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         GameProfile $$4 = (GameProfile)var4.next();
         if (!$$2.a($$4)) {
            aji $$5 = new aji($$4);
            $$2.a((ajd)$$5);
            $$0.a(rq.a("commands.whitelist.add.success", rs.a($$4)), true);
            ++$$3;
         }
      }

      if ($$3 == 0) {
         throw c.create();
      } else {
         return $$3;
      }
   }

   private static int b(dr $$0, Collection<GameProfile> $$1) throws CommandSyntaxException {
      ajh $$2 = $$0.m().ac().i();
      int $$3 = 0;
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         GameProfile $$4 = (GameProfile)var4.next();
         if ($$2.a($$4)) {
            aji $$5 = new aji($$4);
            $$2.b($$5);
            $$0.a(rq.a("commands.whitelist.remove.success", rs.a($$4)), true);
            ++$$3;
         }
      }

      if ($$3 == 0) {
         throw d.create();
      } else {
         $$0.m().a($$0);
         return $$3;
      }
   }

   private static int b(dr $$0) throws CommandSyntaxException {
      aiz $$1 = $$0.m().ac();
      if ($$1.o()) {
         throw a.create();
      } else {
         $$1.a(true);
         $$0.a(rq.c("commands.whitelist.enabled"), true);
         $$0.m().a($$0);
         return 1;
      }
   }

   private static int c(dr $$0) throws CommandSyntaxException {
      aiz $$1 = $$0.m().ac();
      if (!$$1.o()) {
         throw b.create();
      } else {
         $$1.a(false);
         $$0.a(rq.c("commands.whitelist.disabled"), true);
         return 1;
      }
   }

   private static int d(dr $$0) {
      String[] $$1 = $$0.m().ac().j();
      if ($$1.length == 0) {
         $$0.a(rq.c("commands.whitelist.none"), false);
      } else {
         $$0.a(rq.a("commands.whitelist.list", $$1.length, String.join(", ", $$1)), false);
      }

      return $$1.length;
   }
}
