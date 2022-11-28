import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.io.IOException;
import javax.annotation.Nullable;

public class ach {
   private static final String b = "localhost";
   private static final String c = "0.0.0.0";
   private static final int d = 10000;
   private static final int e = 100;
   public static BiMap<String, aba<cgx>> a;
   @Nullable
   private static abz f;
   @Nullable
   private static aby g;

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("chase").then(((LiteralArgumentBuilder)ds.a("follow").then(((RequiredArgumentBuilder)ds.a((String)"host", (ArgumentType)StringArgumentType.string()).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), StringArgumentType.getString($$0x, "host"), 10000);
      })).then(ds.a((String)"port", (ArgumentType)IntegerArgumentType.integer(1, 65535)).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), StringArgumentType.getString($$0x, "host"), IntegerArgumentType.getInteger($$0x, "port"));
      })))).executes(($$0x) -> {
         return b((dr)$$0x.getSource(), "localhost", 10000);
      }))).then(((LiteralArgumentBuilder)ds.a("lead").then(((RequiredArgumentBuilder)ds.a((String)"bind_address", (ArgumentType)StringArgumentType.string()).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), StringArgumentType.getString($$0x, "bind_address"), 10000);
      })).then(ds.a((String)"port", (ArgumentType)IntegerArgumentType.integer(1024, 65535)).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), StringArgumentType.getString($$0x, "bind_address"), IntegerArgumentType.getInteger($$0x, "port"));
      })))).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), "0.0.0.0", 10000);
      }))).then(ds.a("stop").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      })));
   }

   private static int a(dr $$0) {
      if (g != null) {
         g.b();
         $$0.a(rq.b("You have now stopped chasing"), false);
         g = null;
      }

      if (f != null) {
         f.b();
         $$0.a(rq.b("You are no longer being chased"), false);
         f = null;
      }

      return 0;
   }

   private static boolean b(dr $$0) {
      if (f != null) {
         $$0.b((rq)rq.b("Chase server is already running. Stop it using /chase stop"));
         return true;
      } else if (g != null) {
         $$0.b((rq)rq.b("You are already chasing someone. Stop it using /chase stop"));
         return true;
      } else {
         return false;
      }
   }

   private static int a(dr $$0, String $$1, int $$2) {
      if (b($$0)) {
         return 0;
      } else {
         f = new abz($$1, $$2, $$0.m().ac(), 100);

         try {
            f.a();
            $$0.a(rq.b("Chase server is now running on port " + $$2 + ". Clients can follow you using /chase follow <ip> <port>"), false);
         } catch (IOException var4) {
            var4.printStackTrace();
            $$0.b((rq)rq.b("Failed to start chase server on port " + $$2));
            f = null;
         }

         return 0;
      }
   }

   private static int b(dr $$0, String $$1, int $$2) {
      if (b($$0)) {
         return 0;
      } else {
         g = new aby($$1, $$2, $$0.m());
         g.a();
         $$0.a(rq.b("You are now chasing " + $$1 + ":" + $$2 + ". If that server does '/chase lead' then you will automatically go to the same position. Use '/chase stop' to stop chasing."), false);
         return 0;
      }
   }

   static {
      a = ImmutableBiMap.of("o", cgx.e, "n", cgx.f, "e", cgx.g);
   }
}
