import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

public class adt {
   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("raid").requires(($$0x) -> {
         return $$0x.c(3);
      })).then(ds.a("start").then(ds.a((String)"omenlvl", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "omenlvl"));
      })))).then(ds.a("stop").executes(($$0x) -> {
         return c((dr)$$0x.getSource());
      }))).then(ds.a("check").executes(($$0x) -> {
         return d((dr)$$0x.getSource());
      }))).then(ds.a("sound").then(ds.a((String)"type", (ArgumentType)dx.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), dx.a($$0x, "type"));
      })))).then(ds.a("spawnleader").executes(($$0x) -> {
         return b((dr)$$0x.getSource());
      }))).then(ds.a("setomen").then(ds.a((String)"level", (ArgumentType)IntegerArgumentType.integer(0)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), IntegerArgumentType.getInteger($$0x, "level"));
      })))).then(ds.a("glow").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      })));
   }

   private static int a(dr $$0) throws CommandSyntaxException {
      bvj $$1 = a($$0.i());
      if ($$1 != null) {
         Set<bvk> $$2 = $$1.h();
         Iterator var3 = $$2.iterator();

         while(var3.hasNext()) {
            bvk $$3 = (bvk)var3.next();
            $$3.b((bbg)(new bbg(bbi.x, 1000, 1)));
         }
      }

      return 1;
   }

   private static int a(dr $$0, int $$1) throws CommandSyntaxException {
      bvj $$2 = a($$0.i());
      if ($$2 != null) {
         int $$3 = $$2.l();
         if ($$1 > $$3) {
            $$0.b((rq)rq.b("Sorry, the max bad omen level you can set is " + $$3));
         } else {
            int $$4 = $$2.m();
            $$2.a($$1);
            $$0.a(rq.b("Changed village's bad omen level from " + $$4 + " to " + $$1), false);
         }
      } else {
         $$0.b((rq)rq.b("No raid found here"));
      }

      return 1;
   }

   private static int b(dr $$0) {
      $$0.a(rq.b("Spawned a raid captain"), false);
      bvk $$1 = (bvk)bbr.at.a((cgx)$$0.f());
      $$1.v(true);
      $$1.a(bbs.f, bvj.s());
      $$1.e($$0.e().c, $$0.e().d, $$0.e().e);
      $$1.a($$0.f(), $$0.f().d_(new gt($$0.e())), bcg.n, (bcu)null, (pj)null);
      $$0.f().a_($$1);
      return 1;
   }

   private static int a(dr $$0, rq $$1) {
      if ($$1 != null && $$1.getString().equals("local")) {
         $$0.f().a((buc)null, new gt($$0.e().b(5.0D, 0.0D, 0.0D)), ajw.qI, ajx.g, 2.0F, 1.0F);
      }

      return 1;
   }

   private static int b(dr $$0, int $$1) throws CommandSyntaxException {
      agh $$2 = $$0.i();
      gt $$3 = $$2.da();
      if ($$2.x().d($$3)) {
         $$0.b((rq)rq.b("Raid already started close by"));
         return -1;
      } else {
         bvl $$4 = $$2.x().y();
         bvj $$5 = $$4.a($$2);
         if ($$5 != null) {
            $$5.a($$1);
            $$4.b();
            $$0.a(rq.b("Created a raid in your local village"), false);
         } else {
            $$0.b((rq)rq.b("Failed to create a raid in your local village"));
         }

         return 1;
      }
   }

   private static int c(dr $$0) throws CommandSyntaxException {
      agh $$1 = $$0.i();
      gt $$2 = $$1.da();
      bvj $$3 = $$1.x().c($$2);
      if ($$3 != null) {
         $$3.n();
         $$0.a(rq.b("Stopped raid"), false);
         return 1;
      } else {
         $$0.b((rq)rq.b("No raid here"));
         return -1;
      }
   }

   private static int d(dr $$0) throws CommandSyntaxException {
      bvj $$1 = a($$0.i());
      if ($$1 != null) {
         StringBuilder $$2 = new StringBuilder();
         $$2.append("Found a started raid! ");
         $$0.a(rq.b($$2.toString()), false);
         $$2 = new StringBuilder();
         $$2.append("Num groups spawned: ");
         $$2.append($$1.k());
         $$2.append(" Bad omen level: ");
         $$2.append($$1.m());
         $$2.append(" Num mobs: ");
         $$2.append($$1.r());
         $$2.append(" Raid health: ");
         $$2.append($$1.q());
         $$2.append(" / ");
         $$2.append($$1.g());
         $$0.a(rq.b($$2.toString()), false);
         return 1;
      } else {
         $$0.b((rq)rq.b("Found no started raids"));
         return 0;
      }
   }

   @Nullable
   private static bvj a(agh $$0) {
      return $$0.x().c($$0.da());
   }
}
