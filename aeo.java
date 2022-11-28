import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class aeo {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.team.add.duplicate"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.team.empty.unchanged"));
   private static final SimpleCommandExceptionType c = new SimpleCommandExceptionType(rq.c("commands.team.option.name.unchanged"));
   private static final SimpleCommandExceptionType d = new SimpleCommandExceptionType(rq.c("commands.team.option.color.unchanged"));
   private static final SimpleCommandExceptionType e = new SimpleCommandExceptionType(rq.c("commands.team.option.friendlyfire.alreadyEnabled"));
   private static final SimpleCommandExceptionType f = new SimpleCommandExceptionType(rq.c("commands.team.option.friendlyfire.alreadyDisabled"));
   private static final SimpleCommandExceptionType g = new SimpleCommandExceptionType(rq.c("commands.team.option.seeFriendlyInvisibles.alreadyEnabled"));
   private static final SimpleCommandExceptionType h = new SimpleCommandExceptionType(rq.c("commands.team.option.seeFriendlyInvisibles.alreadyDisabled"));
   private static final SimpleCommandExceptionType i = new SimpleCommandExceptionType(rq.c("commands.team.option.nametagVisibility.unchanged"));
   private static final SimpleCommandExceptionType j = new SimpleCommandExceptionType(rq.c("commands.team.option.deathMessageVisibility.unchanged"));
   private static final SimpleCommandExceptionType k = new SimpleCommandExceptionType(rq.c("commands.team.option.collisionRule.unchanged"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("team").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(((LiteralArgumentBuilder)ds.a("list").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      })).then(ds.a((String)"team", (ArgumentType)ex.a()).executes(($$0x) -> {
         return c((dr)$$0x.getSource(), ex.a($$0x, "team"));
      })))).then(ds.a("add").then(((RequiredArgumentBuilder)ds.a((String)"team", (ArgumentType)StringArgumentType.word()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), StringArgumentType.getString($$0x, "team"));
      })).then(ds.a((String)"displayName", (ArgumentType)dx.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), StringArgumentType.getString($$0x, "team"), dx.a($$0x, "displayName"));
      }))))).then(ds.a("remove").then(ds.a((String)"team", (ArgumentType)ex.a()).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ex.a($$0x, "team"));
      })))).then(ds.a("empty").then(ds.a((String)"team", (ArgumentType)ex.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"));
      })))).then(ds.a("join").then(((RequiredArgumentBuilder)ds.a((String)"team", (ArgumentType)ex.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), (dxm)ex.a($$0x, "team"), (Collection)Collections.singleton(((dr)$$0x.getSource()).h().cq()));
      })).then(ds.a((String)"members", (ArgumentType)es.b()).suggests(es.a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), es.c($$0x, "members"));
      }))))).then(ds.a("leave").then(ds.a((String)"members", (ArgumentType)es.b()).suggests(es.a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), es.c($$0x, "members"));
      })))).then(ds.a("modify").then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"team", (ArgumentType)ex.a()).then(ds.a("displayName").then(ds.a((String)"displayName", (ArgumentType)dx.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dx.a($$0x, "displayName"));
      })))).then(ds.a("color").then(ds.a((String)"value", (ArgumentType)dw.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dw.a($$0x, "value"));
      })))).then(ds.a("friendlyFire").then(ds.a((String)"allowed", (ArgumentType)BoolArgumentType.bool()).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ex.a($$0x, "team"), BoolArgumentType.getBool($$0x, "allowed"));
      })))).then(ds.a("seeFriendlyInvisibles").then(ds.a((String)"allowed", (ArgumentType)BoolArgumentType.bool()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), BoolArgumentType.getBool($$0x, "allowed"));
      })))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("nametagVisibility").then(ds.a("never").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.b.b);
      }))).then(ds.a("hideForOtherTeams").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.b.c);
      }))).then(ds.a("hideForOwnTeam").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.b.d);
      }))).then(ds.a("always").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.b.a);
      })))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("deathMessageVisibility").then(ds.a("never").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.b.b);
      }))).then(ds.a("hideForOtherTeams").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.b.c);
      }))).then(ds.a("hideForOwnTeam").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.b.d);
      }))).then(ds.a("always").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.b.a);
      })))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("collisionRule").then(ds.a("never").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.a.b);
      }))).then(ds.a("pushOwnTeam").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.a.d);
      }))).then(ds.a("pushOtherTeams").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.a.c);
      }))).then(ds.a("always").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), ex.a($$0x, "team"), dxq.a.a);
      })))).then(ds.a("prefix").then(ds.a((String)"prefix", (ArgumentType)dx.a()).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), ex.a($$0x, "team"), dx.a($$0x, "prefix"));
      })))).then(ds.a("suffix").then(ds.a((String)"suffix", (ArgumentType)dx.a()).executes(($$0x) -> {
         return c((dr)$$0x.getSource(), ex.a($$0x, "team"), dx.a($$0x, "suffix"));
      }))))));
   }

   private static int a(dr $$0, Collection<String> $$1) {
      dxo $$2 = $$0.m().aF();
      Iterator var3 = $$1.iterator();

      while(var3.hasNext()) {
         String $$3 = (String)var3.next();
         $$2.h($$3);
      }

      if ($$1.size() == 1) {
         $$0.a(rq.a("commands.team.leave.success.single", $$1.iterator().next()), true);
      } else {
         $$0.a(rq.a("commands.team.leave.success.multiple", $$1.size()), true);
      }

      return $$1.size();
   }

   private static int a(dr $$0, dxm $$1, Collection<String> $$2) {
      dxo $$3 = $$0.m().aF();
      Iterator var4 = $$2.iterator();

      while(var4.hasNext()) {
         String $$4 = (String)var4.next();
         $$3.a($$4, $$1);
      }

      if ($$2.size() == 1) {
         $$0.a(rq.a("commands.team.join.success.single", $$2.iterator().next(), $$1.d()), true);
      } else {
         $$0.a(rq.a("commands.team.join.success.multiple", $$2.size(), $$1.d()), true);
      }

      return $$2.size();
   }

   private static int a(dr $$0, dxm $$1, dxq.b $$2) throws CommandSyntaxException {
      if ($$1.j() == $$2) {
         throw i.create();
      } else {
         $$1.a($$2);
         $$0.a(rq.a("commands.team.option.nametagVisibility.success", $$1.d(), $$2.b()), true);
         return 0;
      }
   }

   private static int b(dr $$0, dxm $$1, dxq.b $$2) throws CommandSyntaxException {
      if ($$1.k() == $$2) {
         throw j.create();
      } else {
         $$1.b($$2);
         $$0.a(rq.a("commands.team.option.deathMessageVisibility.success", $$1.d(), $$2.b()), true);
         return 0;
      }
   }

   private static int a(dr $$0, dxm $$1, dxq.a $$2) throws CommandSyntaxException {
      if ($$1.l() == $$2) {
         throw k.create();
      } else {
         $$1.a($$2);
         $$0.a(rq.a("commands.team.option.collisionRule.success", $$1.d(), $$2.a()), true);
         return 0;
      }
   }

   private static int a(dr $$0, dxm $$1, boolean $$2) throws CommandSyntaxException {
      if ($$1.i() == $$2) {
         if ($$2) {
            throw g.create();
         } else {
            throw h.create();
         }
      } else {
         $$1.b($$2);
         $$0.a(rq.a("commands.team.option.seeFriendlyInvisibles." + ($$2 ? "enabled" : "disabled"), $$1.d()), true);
         return 0;
      }
   }

   private static int b(dr $$0, dxm $$1, boolean $$2) throws CommandSyntaxException {
      if ($$1.h() == $$2) {
         if ($$2) {
            throw e.create();
         } else {
            throw f.create();
         }
      } else {
         $$1.a($$2);
         $$0.a(rq.a("commands.team.option.friendlyfire." + ($$2 ? "enabled" : "disabled"), $$1.d()), true);
         return 0;
      }
   }

   private static int a(dr $$0, dxm $$1, rq $$2) throws CommandSyntaxException {
      if ($$1.c().equals($$2)) {
         throw c.create();
      } else {
         $$1.a($$2);
         $$0.a(rq.a("commands.team.option.name.success", $$1.d()), true);
         return 0;
      }
   }

   private static int a(dr $$0, dxm $$1, p $$2) throws CommandSyntaxException {
      if ($$1.n() == $$2) {
         throw d.create();
      } else {
         $$1.a($$2);
         $$0.a(rq.a("commands.team.option.color.success", $$1.d(), $$2.g()), true);
         return 0;
      }
   }

   private static int a(dr $$0, dxm $$1) throws CommandSyntaxException {
      dxo $$2 = $$0.m().aF();
      Collection<String> $$3 = Lists.newArrayList($$1.g());
      if ($$3.isEmpty()) {
         throw b.create();
      } else {
         Iterator var4 = $$3.iterator();

         while(var4.hasNext()) {
            String $$4 = (String)var4.next();
            $$2.b($$4, $$1);
         }

         $$0.a(rq.a("commands.team.empty.success", $$3.size(), $$1.d()), true);
         return $$3.size();
      }
   }

   private static int b(dr $$0, dxm $$1) {
      dxo $$2 = $$0.m().aF();
      $$2.d($$1);
      $$0.a(rq.a("commands.team.remove.success", $$1.d()), true);
      return $$2.g().size();
   }

   private static int a(dr $$0, String $$1) throws CommandSyntaxException {
      return a($$0, (String)$$1, (rq)rq.b($$1));
   }

   private static int a(dr $$0, String $$1, rq $$2) throws CommandSyntaxException {
      dxo $$3 = $$0.m().aF();
      if ($$3.f($$1) != null) {
         throw a.create();
      } else {
         dxm $$4 = $$3.g($$1);
         $$4.a($$2);
         $$0.a(rq.a("commands.team.add.success", $$4.d()), true);
         return $$3.g().size();
      }
   }

   private static int c(dr $$0, dxm $$1) {
      Collection<String> $$2 = $$1.g();
      if ($$2.isEmpty()) {
         $$0.a(rq.a("commands.team.list.members.empty", $$1.d()), false);
      } else {
         $$0.a(rq.a("commands.team.list.members.success", $$1.d(), $$2.size(), rs.a($$2)), false);
      }

      return $$2.size();
   }

   private static int a(dr $$0) {
      Collection<dxm> $$1 = $$0.m().aF().g();
      if ($$1.isEmpty()) {
         $$0.a(rq.c("commands.team.list.teams.empty"), false);
      } else {
         $$0.a(rq.a("commands.team.list.teams.success", $$1.size(), rs.b($$1, dxm::d)), false);
      }

      return $$1.size();
   }

   private static int b(dr $$0, dxm $$1, rq $$2) {
      $$1.b($$2);
      $$0.a(rq.a("commands.team.option.prefix.success", $$2), false);
      return 1;
   }

   private static int c(dr $$0, dxm $$1, rq $$2) {
      $$1.c($$2);
      $$0.a(rq.a("commands.team.option.suffix.success", $$2), false);
      return 1;
   }
}
