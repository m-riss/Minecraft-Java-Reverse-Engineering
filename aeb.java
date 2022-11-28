import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import java.util.Collection;
import net.minecraft.server.MinecraftServer;

public class aeb {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.schedule.same_tick"));
   private static final DynamicCommandExceptionType b = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.schedule.cleared.failure", $$0);
   });
   private static final SuggestionProvider<dr> c = ($$0, $$1) -> {
      return dt.b((Iterable)((dr)$$0.getSource()).m().aW().H().u().a(), (SuggestionsBuilder)$$1);
   };

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("schedule").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("function").then(ds.a((String)"function", (ArgumentType)fs.a()).suggests(acy.a).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"time", (ArgumentType)fa.a()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fs.b($$0x, "function"), IntegerArgumentType.getInteger($$0x, "time"), true);
      })).then(ds.a("append").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fs.b($$0x, "function"), IntegerArgumentType.getInteger($$0x, "time"), false);
      }))).then(ds.a("replace").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fs.b($$0x, "function"), IntegerArgumentType.getInteger($$0x, "time"), true);
      })))))).then(ds.a("clear").then(ds.a((String)"function", (ArgumentType)StringArgumentType.greedyString()).suggests(c).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), StringArgumentType.getString($$0x, "function"));
      }))));
   }

   private static int a(dr $$0, Pair<abb, Either<dm, Collection<dm>>> $$1, int $$2, boolean $$3) throws CommandSyntaxException {
      if ($$2 == 0) {
         throw a.create();
      } else {
         long $$4 = $$0.f().U() + (long)$$2;
         abb $$5 = (abb)$$1.getFirst();
         dwi<MinecraftServer> $$6 = $$0.m().aW().H().u();
         ((Either)$$1.getSecond()).ifLeft(($$6x) -> {
            String $$7 = $$5.toString();
            if ($$3) {
               $$6.a($$7);
            }

            $$6.a($$7, $$4, new dwe($$5));
            $$0.a(rq.a("commands.schedule.created.function", $$5, $$2, $$4), true);
         }).ifRight(($$6x) -> {
            String $$7 = "#" + $$5;
            if ($$3) {
               $$6.a($$7);
            }

            $$6.a($$7, $$4, new dwf($$5));
            $$0.a(rq.a("commands.schedule.created.tag", $$5, $$2, $$4), true);
         });
         return Math.floorMod($$4, Integer.MAX_VALUE);
      }
   }

   private static int a(dr $$0, String $$1) throws CommandSyntaxException {
      int $$2 = $$0.m().aW().H().u().a($$1);
      if ($$2 == 0) {
         throw b.create($$1);
      } else {
         $$0.a(rq.a("commands.schedule.cleared.success", $$2, $$1), true);
         return $$2;
      }
   }
}
