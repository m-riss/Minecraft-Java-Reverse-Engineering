import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ack {
   private static final DynamicCommandExceptionType a = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.datapack.unknown", $$0);
   });
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.datapack.enable.failed", $$0);
   });
   private static final DynamicCommandExceptionType c = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.datapack.disable.failed", $$0);
   });
   private static final SuggestionProvider<dr> d = ($$0, $$1) -> {
      return dt.b(((dr)$$0.getSource()).m().aB().d().stream().map(StringArgumentType::escapeIfRequired), $$1);
   };
   private static final SuggestionProvider<dr> e = ($$0, $$1) -> {
      ahy $$2 = ((dr)$$0.getSource()).m().aB();
      Collection<String> $$3 = $$2.d();
      return dt.b($$2.b().stream().filter(($$1x) -> {
         return !$$3.contains($$1x);
      }).map(StringArgumentType::escapeIfRequired), $$1);
   };

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("datapack").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("enable").then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"name", (ArgumentType)StringArgumentType.string()).suggests(e).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x, "name", true), ($$0, $$1) -> {
            $$1.h().a($$0, $$1, ($$0x) -> {
               return $$0x;
            }, false);
         });
      })).then(ds.a("after").then(ds.a((String)"existing", (ArgumentType)StringArgumentType.string()).suggests(d).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x, "name", true), ($$1, $$2) -> {
            $$1.add($$1.indexOf(a($$0x, "existing", false)) + 1, $$2);
         });
      })))).then(ds.a("before").then(ds.a((String)"existing", (ArgumentType)StringArgumentType.string()).suggests(d).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x, "name", true), ($$1, $$2) -> {
            $$1.add($$1.indexOf(a($$0x, "existing", false)), $$2);
         });
      })))).then(ds.a("last").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x, "name", true), List::add);
      }))).then(ds.a("first").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x, "name", true), ($$0, $$1) -> {
            $$0.add(0, $$1);
         });
      }))))).then(ds.a("disable").then(ds.a((String)"name", (ArgumentType)StringArgumentType.string()).suggests(d).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), a($$0x, "name", false));
      })))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("list").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      })).then(ds.a("available").executes(($$0x) -> {
         return b((dr)$$0x.getSource());
      }))).then(ds.a("enabled").executes(($$0x) -> {
         return c((dr)$$0x.getSource());
      }))));
   }

   private static int a(dr $$0, ahw $$1, ack.a $$2) throws CommandSyntaxException {
      ahy $$3 = $$0.m().aB();
      List<ahw> $$4 = Lists.newArrayList($$3.e());
      $$2.apply($$4, $$1);
      $$0.a(rq.a("commands.datapack.modify.enable", $$1.a(true)), true);
      adv.a((Collection)$$4.stream().map(ahw::e).collect(Collectors.toList()), $$0);
      return $$4.size();
   }

   private static int a(dr $$0, ahw $$1) {
      ahy $$2 = $$0.m().aB();
      List<ahw> $$3 = Lists.newArrayList($$2.e());
      $$3.remove($$1);
      $$0.a(rq.a("commands.datapack.modify.disable", $$1.a(true)), true);
      adv.a((Collection)$$3.stream().map(ahw::e).collect(Collectors.toList()), $$0);
      return $$3.size();
   }

   private static int a(dr $$0) {
      return c($$0) + b($$0);
   }

   private static int b(dr $$0) {
      ahy $$1 = $$0.m().aB();
      $$1.a();
      Collection<? extends ahw> $$2 = $$1.e();
      Collection<? extends ahw> $$3 = $$1.c();
      List<ahw> $$4 = (List)$$3.stream().filter(($$1x) -> {
         return !$$2.contains($$1x);
      }).collect(Collectors.toList());
      if ($$4.isEmpty()) {
         $$0.a(rq.c("commands.datapack.list.available.none"), false);
      } else {
         $$0.a(rq.a("commands.datapack.list.available.success", $$4.size(), rs.b($$4, ($$0x) -> {
            return $$0x.a(false);
         })), false);
      }

      return $$4.size();
   }

   private static int c(dr $$0) {
      ahy $$1 = $$0.m().aB();
      $$1.a();
      Collection<? extends ahw> $$2 = $$1.e();
      if ($$2.isEmpty()) {
         $$0.a(rq.c("commands.datapack.list.enabled.none"), false);
      } else {
         $$0.a(rq.a("commands.datapack.list.enabled.success", $$2.size(), rs.b($$2, ($$0x) -> {
            return $$0x.a(true);
         })), false);
      }

      return $$2.size();
   }

   private static ahw a(CommandContext<dr> $$0, String $$1, boolean $$2) throws CommandSyntaxException {
      String $$3 = StringArgumentType.getString($$0, $$1);
      ahy $$4 = ((dr)$$0.getSource()).m().aB();
      ahw $$5 = $$4.a($$3);
      if ($$5 == null) {
         throw a.create($$3);
      } else {
         boolean $$6 = $$4.e().contains($$5);
         if ($$2 && $$6) {
            throw b.create($$3);
         } else if (!$$2 && !$$6) {
            throw c.create($$3);
         } else {
            return $$5;
         }
      }
   }

   private interface a {
      void apply(List<ahw> var1, ahw var2) throws CommandSyntaxException;
   }
}
