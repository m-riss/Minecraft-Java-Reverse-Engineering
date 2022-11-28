import com.google.common.collect.Iterables;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.ParsedCommandNode;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.CommandNode;
import java.util.Iterator;
import java.util.Map;

public class adc {
   private static final SimpleCommandExceptionType a = new SimpleCommandExceptionType(rq.c("commands.help.failed"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("help").executes(($$1) -> {
         Map<CommandNode<dr>, String> $$2 = $$0.getSmartUsage($$0.getRoot(), (dr)$$1.getSource());
         Iterator var3 = $$2.values().iterator();

         while(var3.hasNext()) {
            String $$3 = (String)var3.next();
            ((dr)$$1.getSource()).a(rq.b("/" + $$3), false);
         }

         return $$2.size();
      })).then(ds.a((String)"command", (ArgumentType)StringArgumentType.greedyString()).executes(($$1) -> {
         ParseResults<dr> $$2 = $$0.parse(StringArgumentType.getString($$1, "command"), (dr)$$1.getSource());
         if ($$2.getContext().getNodes().isEmpty()) {
            throw a.create();
         } else {
            Map<CommandNode<dr>, String> $$3 = $$0.getSmartUsage(((ParsedCommandNode)Iterables.getLast($$2.getContext().getNodes())).getNode(), (dr)$$1.getSource());
            Iterator var4 = $$3.values().iterator();

            while(var4.hasNext()) {
               String $$4 = (String)var4.next();
               dr var10000 = (dr)$$1.getSource();
               String var10001 = $$2.getReader().getString();
               var10000.a(rq.b("/" + var10001 + " " + $$4), false);
            }

            return $$3.size();
         }
      })));
   }
}
