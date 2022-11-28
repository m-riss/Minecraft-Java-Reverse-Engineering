import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.Dynamic3CommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class add {
   static final Dynamic3CommandExceptionType a = new Dynamic3CommandExceptionType(($$0, $$1, $$2) -> {
      return rq.a("commands.item.target.not_a_container", $$0, $$1, $$2);
   });
   private static final Dynamic3CommandExceptionType c = new Dynamic3CommandExceptionType(($$0, $$1, $$2) -> {
      return rq.a("commands.item.source.not_a_container", $$0, $$1, $$2);
   });
   static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.item.target.no_such_slot", $$0);
   });
   private static final DynamicCommandExceptionType d = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.item.source.no_such_slot", $$0);
   });
   private static final DynamicCommandExceptionType e = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.item.target.no_changes", $$0);
   });
   private static final Dynamic2CommandExceptionType f = new Dynamic2CommandExceptionType(($$0, $$1) -> {
      return rq.a("commands.item.target.no_changed.known_item", $$0, $$1);
   });
   private static final SuggestionProvider<dr> g = ($$0, $$1) -> {
      dsc $$2 = ((dr)$$0.getSource()).m().aJ();
      return dt.a((Iterable)$$2.a(), (SuggestionsBuilder)$$1);
   };

   public static void a(CommandDispatcher<dr> $$0, dl $$1) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("item").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(((LiteralArgumentBuilder)ds.a("replace").then(ds.a("block").then(ds.a((String)"pos", (ArgumentType)fh.a()).then(((RequiredArgumentBuilder)ds.a((String)"slot", (ArgumentType)ev.a()).then(ds.a("with").then(((RequiredArgumentBuilder)ds.a((String)"item", (ArgumentType)ft.a($$1)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "pos"), ev.a($$0x, "slot"), ft.a($$0x, "item").a(1, false));
      })).then(ds.a((String)"count", (ArgumentType)IntegerArgumentType.integer(1, 64)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "pos"), ev.a($$0x, "slot"), ft.a($$0x, "item").a(IntegerArgumentType.getInteger($$0x, "count"), true));
      }))))).then(((LiteralArgumentBuilder)ds.a("from").then(ds.a("block").then(ds.a((String)"source", (ArgumentType)fh.a()).then(((RequiredArgumentBuilder)ds.a((String)"sourceSlot", (ArgumentType)ev.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "source"), ev.a($$0x, "sourceSlot"), fh.a($$0x, "pos"), ev.a($$0x, "slot"));
      })).then(ds.a((String)"modifier", (ArgumentType)eq.a()).suggests(g).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "source"), ev.a($$0x, "sourceSlot"), fh.a($$0x, "pos"), ev.a($$0x, "slot"), eq.d($$0x, "modifier"));
      })))))).then(ds.a("entity").then(ds.a((String)"source", (ArgumentType)eb.a()).then(((RequiredArgumentBuilder)ds.a((String)"sourceSlot", (ArgumentType)ev.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "source"), ev.a($$0x, "sourceSlot"), fh.a($$0x, "pos"), ev.a($$0x, "slot"));
      })).then(ds.a((String)"modifier", (ArgumentType)eq.a()).suggests(g).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "source"), ev.a($$0x, "sourceSlot"), fh.a($$0x, "pos"), ev.a($$0x, "slot"), eq.d($$0x, "modifier"));
      })))))))))).then(ds.a("entity").then(ds.a((String)"targets", (ArgumentType)eb.b()).then(((RequiredArgumentBuilder)ds.a((String)"slot", (ArgumentType)ev.a()).then(ds.a("with").then(((RequiredArgumentBuilder)ds.a((String)"item", (ArgumentType)ft.a($$1)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ev.a($$0x, "slot"), ft.a($$0x, "item").a(1, false));
      })).then(ds.a((String)"count", (ArgumentType)IntegerArgumentType.integer(1, 64)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ev.a($$0x, "slot"), ft.a($$0x, "item").a(IntegerArgumentType.getInteger($$0x, "count"), true));
      }))))).then(((LiteralArgumentBuilder)ds.a("from").then(ds.a("block").then(ds.a((String)"source", (ArgumentType)fh.a()).then(((RequiredArgumentBuilder)ds.a((String)"sourceSlot", (ArgumentType)ev.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "source"), ev.a($$0x, "sourceSlot"), eb.b($$0x, "targets"), ev.a($$0x, "slot"));
      })).then(ds.a((String)"modifier", (ArgumentType)eq.a()).suggests(g).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "source"), ev.a($$0x, "sourceSlot"), eb.b($$0x, "targets"), ev.a($$0x, "slot"), eq.d($$0x, "modifier"));
      })))))).then(ds.a("entity").then(ds.a((String)"source", (ArgumentType)eb.a()).then(((RequiredArgumentBuilder)ds.a((String)"sourceSlot", (ArgumentType)ev.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "source"), ev.a($$0x, "sourceSlot"), eb.b($$0x, "targets"), ev.a($$0x, "slot"));
      })).then(ds.a((String)"modifier", (ArgumentType)eq.a()).suggests(g).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.a($$0x, "source"), ev.a($$0x, "sourceSlot"), eb.b($$0x, "targets"), ev.a($$0x, "slot"), eq.d($$0x, "modifier"));
      }))))))))))).then(((LiteralArgumentBuilder)ds.a("modify").then(ds.a("block").then(ds.a((String)"pos", (ArgumentType)fh.a()).then(ds.a((String)"slot", (ArgumentType)ev.a()).then(ds.a((String)"modifier", (ArgumentType)eq.a()).suggests(g).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fh.a($$0x, "pos"), ev.a($$0x, "slot"), eq.d($$0x, "modifier"));
      })))))).then(ds.a("entity").then(ds.a((String)"targets", (ArgumentType)eb.b()).then(ds.a((String)"slot", (ArgumentType)ev.a()).then(ds.a((String)"modifier", (ArgumentType)eq.a()).suggests(g).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.b($$0x, "targets"), ev.a($$0x, "slot"), eq.d($$0x, "modifier"));
      })))))));
   }

   private static int a(dr $$0, gt $$1, int $$2, dto $$3) throws CommandSyntaxException {
      bac $$4 = a($$0, $$1, a);
      if ($$2 >= 0 && $$2 < $$4.b()) {
         cax $$5 = a($$0, $$3, $$4.a($$2));
         $$4.a($$2, $$5);
         $$0.a(rq.a("commands.item.block.set.success", $$1.u(), $$1.v(), $$1.w(), $$5.I()), true);
         return 1;
      } else {
         throw b.create($$2);
      }
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1, int $$2, dto $$3) throws CommandSyntaxException {
      Map<bbn, cax> $$4 = Maps.newHashMapWithExpectedSize($$1.size());
      Iterator var5 = $$1.iterator();

      while(var5.hasNext()) {
         bbn $$5 = (bbn)var5.next();
         bct $$6 = $$5.k($$2);
         if ($$6 != bct.a) {
            cax $$7 = a($$0, $$3, $$6.a().o());
            if ($$6.a($$7)) {
               $$4.put($$5, $$7);
               if ($$5 instanceof agh) {
                  ((agh)$$5).bU.d();
               }
            }
         }
      }

      if ($$4.isEmpty()) {
         throw e.create($$2);
      } else {
         if ($$4.size() == 1) {
            Entry<bbn, cax> $$8 = (Entry)$$4.entrySet().iterator().next();
            $$0.a(rq.a("commands.item.entity.set.success.single", ((bbn)$$8.getKey()).C_(), ((cax)$$8.getValue()).I()), true);
         } else {
            $$0.a(rq.a("commands.item.entity.set.success.multiple", $$4.size()), true);
         }

         return $$4.size();
      }
   }

   private static int a(dr $$0, gt $$1, int $$2, cax $$3) throws CommandSyntaxException {
      bac $$4 = a($$0, $$1, a);
      if ($$2 >= 0 && $$2 < $$4.b()) {
         $$4.a($$2, $$3);
         $$0.a(rq.a("commands.item.block.set.success", $$1.u(), $$1.v(), $$1.w(), $$3.I()), true);
         return 1;
      } else {
         throw b.create($$2);
      }
   }

   private static bac a(dr $$0, gt $$1, Dynamic3CommandExceptionType $$2) throws CommandSyntaxException {
      cti $$3 = $$0.f().c_($$1);
      if (!($$3 instanceof bac)) {
         throw $$2.create($$1.u(), $$1.v(), $$1.w());
      } else {
         return (bac)$$3;
      }
   }

   private static int a(dr $$0, Collection<? extends bbn> $$1, int $$2, cax $$3) throws CommandSyntaxException {
      List<bbn> $$4 = Lists.newArrayListWithCapacity($$1.size());
      Iterator var5 = $$1.iterator();

      while(var5.hasNext()) {
         bbn $$5 = (bbn)var5.next();
         bct $$6 = $$5.k($$2);
         if ($$6 != bct.a && $$6.a($$3.o())) {
            $$4.add($$5);
            if ($$5 instanceof agh) {
               ((agh)$$5).bU.d();
            }
         }
      }

      if ($$4.isEmpty()) {
         throw f.create($$3.I(), $$2);
      } else {
         if ($$4.size() == 1) {
            $$0.a(rq.a("commands.item.entity.set.success.single", ((bbn)$$4.iterator().next()).C_(), $$3.I()), true);
         } else {
            $$0.a(rq.a("commands.item.entity.set.success.multiple", $$4.size(), $$3.I()), true);
         }

         return $$4.size();
      }
   }

   private static int a(dr $$0, gt $$1, int $$2, Collection<? extends bbn> $$3, int $$4) throws CommandSyntaxException {
      return a($$0, $$3, $$4, a($$0, $$1, $$2));
   }

   private static int a(dr $$0, gt $$1, int $$2, Collection<? extends bbn> $$3, int $$4, dto $$5) throws CommandSyntaxException {
      return a($$0, $$3, $$4, a($$0, $$5, a($$0, $$1, $$2)));
   }

   private static int a(dr $$0, gt $$1, int $$2, gt $$3, int $$4) throws CommandSyntaxException {
      return a($$0, $$3, $$4, a($$0, $$1, $$2));
   }

   private static int a(dr $$0, gt $$1, int $$2, gt $$3, int $$4, dto $$5) throws CommandSyntaxException {
      return a($$0, $$3, $$4, a($$0, $$5, a($$0, $$1, $$2)));
   }

   private static int a(dr $$0, bbn $$1, int $$2, gt $$3, int $$4) throws CommandSyntaxException {
      return a($$0, $$3, $$4, a($$1, $$2));
   }

   private static int a(dr $$0, bbn $$1, int $$2, gt $$3, int $$4, dto $$5) throws CommandSyntaxException {
      return a($$0, $$3, $$4, a($$0, $$5, a($$1, $$2)));
   }

   private static int a(dr $$0, bbn $$1, int $$2, Collection<? extends bbn> $$3, int $$4) throws CommandSyntaxException {
      return a($$0, $$3, $$4, a($$1, $$2));
   }

   private static int a(dr $$0, bbn $$1, int $$2, Collection<? extends bbn> $$3, int $$4, dto $$5) throws CommandSyntaxException {
      return a($$0, $$3, $$4, a($$0, $$5, a($$1, $$2)));
   }

   private static cax a(dr $$0, dto $$1, cax $$2) {
      agg $$3 = $$0.f();
      dsd.a $$4 = (new dsd.a($$3)).a((dui)dul.f, (Object)$$0.e()).b(dul.a, $$0.g());
      return (cax)$$1.apply($$2, $$4.a(duk.c));
   }

   private static cax a(bbn $$0, int $$1) throws CommandSyntaxException {
      bct $$2 = $$0.k($$1);
      if ($$2 == bct.a) {
         throw d.create($$1);
      } else {
         return $$2.a().o();
      }
   }

   private static cax a(dr $$0, gt $$1, int $$2) throws CommandSyntaxException {
      bac $$3 = a($$0, $$1, c);
      if ($$2 >= 0 && $$2 < $$3.b()) {
         return $$3.a($$2).o();
      } else {
         throw d.create($$2);
      }
   }
}
