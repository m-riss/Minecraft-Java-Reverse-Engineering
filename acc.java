import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.Dynamic3CommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import java.util.UUID;

public class acc {
   private static final DynamicCommandExceptionType a = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.attribute.failed.entity", $$0);
   });
   private static final Dynamic2CommandExceptionType b = new Dynamic2CommandExceptionType(($$0, $$1) -> {
      return rq.a("commands.attribute.failed.no_attribute", $$0, $$1);
   });
   private static final Dynamic3CommandExceptionType c = new Dynamic3CommandExceptionType(($$0, $$1, $$2) -> {
      return rq.a("commands.attribute.failed.no_modifier", $$1, $$0, $$2);
   });
   private static final Dynamic3CommandExceptionType d = new Dynamic3CommandExceptionType(($$0, $$1, $$2) -> {
      return rq.a("commands.attribute.failed.modifier_already_present", $$2, $$1, $$0);
   });

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("attribute").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a((String)"target", (ArgumentType)eb.a()).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"attribute", (ArgumentType)ep.a(hm.w)).then(((LiteralArgumentBuilder)ds.a("get").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), 1.0D);
      })).then(ds.a((String)"scale", (ArgumentType)DoubleArgumentType.doubleArg()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), DoubleArgumentType.getDouble($$0x, "scale"));
      })))).then(((LiteralArgumentBuilder)ds.a("base").then(ds.a("set").then(ds.a((String)"value", (ArgumentType)DoubleArgumentType.doubleArg()).executes(($$0x) -> {
         return c((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), DoubleArgumentType.getDouble($$0x, "value"));
      })))).then(((LiteralArgumentBuilder)ds.a("get").executes(($$0x) -> {
         return b((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), 1.0D);
      })).then(ds.a((String)"scale", (ArgumentType)DoubleArgumentType.doubleArg()).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), DoubleArgumentType.getDouble($$0x, "scale"));
      }))))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("modifier").then(ds.a("add").then(ds.a((String)"uuid", (ArgumentType)fb.a()).then(ds.a((String)"name", (ArgumentType)StringArgumentType.string()).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"value", (ArgumentType)DoubleArgumentType.doubleArg()).then(ds.a("add").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), fb.a($$0x, "uuid"), StringArgumentType.getString($$0x, "name"), DoubleArgumentType.getDouble($$0x, "value"), bdb.a.a);
      }))).then(ds.a("multiply").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), fb.a($$0x, "uuid"), StringArgumentType.getString($$0x, "name"), DoubleArgumentType.getDouble($$0x, "value"), bdb.a.c);
      }))).then(ds.a("multiply_base").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), fb.a($$0x, "uuid"), StringArgumentType.getString($$0x, "name"), DoubleArgumentType.getDouble($$0x, "value"), bdb.a.b);
      }))))))).then(ds.a("remove").then(ds.a((String)"uuid", (ArgumentType)fb.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), fb.a($$0x, "uuid"));
      })))).then(ds.a("value").then(ds.a("get").then(((RequiredArgumentBuilder)ds.a((String)"uuid", (ArgumentType)fb.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), fb.a($$0x, "uuid"), 1.0D);
      })).then(ds.a((String)"scale", (ArgumentType)DoubleArgumentType.doubleArg()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "target"), ep.a($$0x, "attribute"), fb.a($$0x, "uuid"), DoubleArgumentType.getDouble($$0x, "scale"));
      })))))))));
   }

   private static bcz a(bbn $$0, bcy $$1) throws CommandSyntaxException {
      bcz $$2 = a($$0).ex().a($$1);
      if ($$2 == null) {
         throw b.create($$0.X(), rq.c($$1.c()));
      } else {
         return $$2;
      }
   }

   private static bcc a(bbn $$0) throws CommandSyntaxException {
      if (!($$0 instanceof bcc)) {
         throw a.create($$0.X());
      } else {
         return (bcc)$$0;
      }
   }

   private static bcc b(bbn $$0, bcy $$1) throws CommandSyntaxException {
      bcc $$2 = a($$0);
      if (!$$2.ex().b($$1)) {
         throw b.create($$0.X(), rq.c($$1.c()));
      } else {
         return $$2;
      }
   }

   private static int a(dr $$0, bbn $$1, bcy $$2, double $$3) throws CommandSyntaxException {
      bcc $$4 = b($$1, $$2);
      double $$5 = $$4.b($$2);
      $$0.a(rq.a("commands.attribute.value.get.success", rq.c($$2.c()), $$1.X(), $$5), false);
      return (int)($$5 * $$3);
   }

   private static int b(dr $$0, bbn $$1, bcy $$2, double $$3) throws CommandSyntaxException {
      bcc $$4 = b($$1, $$2);
      double $$5 = $$4.c($$2);
      $$0.a(rq.a("commands.attribute.base_value.get.success", rq.c($$2.c()), $$1.X(), $$5), false);
      return (int)($$5 * $$3);
   }

   private static int a(dr $$0, bbn $$1, bcy $$2, UUID $$3, double $$4) throws CommandSyntaxException {
      bcc $$5 = b($$1, $$2);
      bda $$6 = $$5.ex();
      if (!$$6.a($$2, $$3)) {
         throw c.create($$1.X(), rq.c($$2.c()), $$3);
      } else {
         double $$7 = $$6.b($$2, $$3);
         $$0.a(rq.a("commands.attribute.modifier.value.get.success", $$3, rq.c($$2.c()), $$1.X(), $$7), false);
         return (int)($$7 * $$4);
      }
   }

   private static int c(dr $$0, bbn $$1, bcy $$2, double $$3) throws CommandSyntaxException {
      a($$1, $$2).a($$3);
      $$0.a(rq.a("commands.attribute.base_value.set.success", rq.c($$2.c()), $$1.X(), $$3), false);
      return 1;
   }

   private static int a(dr $$0, bbn $$1, bcy $$2, UUID $$3, String $$4, double $$5, bdb.a $$6) throws CommandSyntaxException {
      bcz $$7 = a($$1, $$2);
      bdb $$8 = new bdb($$3, $$4, $$5, $$6);
      if ($$7.a($$8)) {
         throw d.create($$1.X(), rq.c($$2.c()), $$3);
      } else {
         $$7.c($$8);
         $$0.a(rq.a("commands.attribute.modifier.add.success", $$3, rq.c($$2.c()), $$1.X()), false);
         return 1;
      }
   }

   private static int a(dr $$0, bbn $$1, bcy $$2, UUID $$3) throws CommandSyntaxException {
      bcz $$4 = a($$1, $$2);
      if ($$4.c($$3)) {
         $$0.a(rq.a("commands.attribute.modifier.remove.success", $$3, rq.c($$2.c()), $$1.X()), false);
         return 1;
      } else {
         throw c.create($$1.X(), rq.c($$2.c()), $$3);
      }
   }
}
