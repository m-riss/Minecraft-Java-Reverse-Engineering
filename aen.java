import com.google.common.collect.Sets;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class aen {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.tag.add.failed"));
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.tag.remove.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("tag").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.b()).then(ds.a("add").then(ds.a((String)"name", (ArgumentType)StringArgumentType.word()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), StringArgumentType.getString($$0x, "name"));
      })))).then(ds.a("remove").then(ds.a((String)"name", (ArgumentType)StringArgumentType.word()).suggests(($$0x, $$1) -> {
         return dt.b((Iterable)a(eb.b($$0x, "targets")), (SuggestionsBuilder)$$1);
      }).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), eb.b($$0x, "targets"), StringArgumentType.getString($$0x, "name"));
      })))).then(ds.a("list").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"));
      }))));
   }

   private static Collection<String> a(Collection<? extends bbn> $$0) {
      Set<String> $$1 = Sets.newHashSet();
      Iterator var2 = $$0.iterator();

      while(var2.hasNext()) {
         bbn $$2 = (bbn)var2.next();
         $$1.addAll($$2.af());
      }

      return $$1;
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1, String $$2) throws CommandSyntaxException {
      int $$3 = 0;
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         bbn $$4 = (bbn)var4.next();
         if ($$4.a($$2)) {
            ++$$3;
         }
      }

      if ($$3 == 0) {
         throw a.create();
      } else {
         if ($$1.size() == 1) {
            $$0.a(rq.a("commands.tag.add.success.single", $$2, ((bbn)$$1.iterator().next()).C_()), true);
         } else {
            $$0.a(rq.a("commands.tag.add.success.multiple", $$2, $$1.size()), true);
         }

         return $$3;
      }
   }

   private static int b(dr $$0, Collection<? extends bbn> $$1, String $$2) throws CommandSyntaxException {
      int $$3 = 0;
      Iterator var4 = $$1.iterator();

      while(var4.hasNext()) {
         bbn $$4 = (bbn)var4.next();
         if ($$4.b($$2)) {
            ++$$3;
         }
      }

      if ($$3 == 0) {
         throw b.create();
      } else {
         if ($$1.size() == 1) {
            $$0.a(rq.a("commands.tag.remove.success.single", $$2, ((bbn)$$1.iterator().next()).C_()), true);
         } else {
            $$0.a(rq.a("commands.tag.remove.success.multiple", $$2, $$1.size()), true);
         }

         return $$3;
      }
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1) {
      Set<String> $$2 = Sets.newHashSet();
      Iterator var3 = $$1.iterator();

      while(var3.hasNext()) {
         bbn $$3 = (bbn)var3.next();
         $$2.addAll($$3.af());
      }

      if ($$1.size() == 1) {
         bbn $$4 = (bbn)$$1.iterator().next();
         if ($$2.isEmpty()) {
            $$0.a(rq.a("commands.tag.list.single.empty", $$4.C_()), false);
         } else {
            $$0.a(rq.a("commands.tag.list.single.success", $$4.C_(), $$2.size(), rs.a((Collection)$$2)), false);
         }
      } else if ($$2.isEmpty()) {
         $$0.a(rq.a("commands.tag.list.multiple.empty", $$1.size()), false);
      } else {
         $$0.a(rq.a("commands.tag.list.multiple.success", $$1.size(), $$2.size(), rs.a((Collection)$$2)), false);
      }

      return $$2.size();
   }
}
