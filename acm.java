import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.logging.LogUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class acm {
   private static final Logger a = LogUtils.getLogger();
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.debug.notRunning"));
   private static final SimpleCommandExceptionType c = new SimpleCommandExceptionType(rq.c("commands.debug.alreadyRunning"));

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("debug").requires(($$0x) -> {
         return $$0x.c(3);
      })).then(ds.a("start").executes(($$0x) -> {
         return a((dr)$$0x.getSource());
      }))).then(ds.a("stop").executes(($$0x) -> {
         return b((dr)$$0x.getSource());
      }))).then(((LiteralArgumentBuilder)ds.a("function").requires(($$0x) -> {
         return $$0x.c(3);
      })).then(ds.a((String)"name", (ArgumentType)fs.a()).suggests(acy.a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), fs.a($$0x, "name"));
      }))));
   }

   private static int a(dr $$0) throws CommandSyntaxException {
      MinecraftServer $$1 = $$0.m();
      if ($$1.bb()) {
         throw c.create();
      } else {
         $$1.bc();
         $$0.a(rq.c("commands.debug.started"), true);
         return 0;
      }
   }

   private static int b(dr $$0) throws CommandSyntaxException {
      MinecraftServer $$1 = $$0.m();
      if (!$$1.bb()) {
         throw b.create();
      } else {
         awy $$2 = $$1.bd();
         double $$3 = (double)$$2.g() / (double)anc.a;
         double $$4 = (double)$$2.f() / $$3;
         $$0.a(rq.a("commands.debug.stopped", String.format(Locale.ROOT, "%.2f", $$3), $$2.f(), String.format(Locale.ROOT, "%.2f", $$4)), true);
         return (int)$$4;
      }
   }

   private static int a(dr $$0, Collection<dm> $$1) {
      int $$2 = 0;
      MinecraftServer $$3 = $$0.m();
      String $$4 = "debug-trace-" + ad.e() + ".txt";

      try {
         Path $$5 = $$3.c("debug").toPath();
         Files.createDirectories($$5);
         BufferedWriter $$6 = Files.newBufferedWriter($$5.resolve($$4), StandardCharsets.UTF_8);

         try {
            PrintWriter $$7 = new PrintWriter($$6);

            dm $$8;
            acm.a $$9;
            for(Iterator var8 = $$1.iterator(); var8.hasNext(); $$2 += $$0.m().aA().a($$8, $$0.a((dq)$$9).b(2), $$9)) {
               $$8 = (dm)var8.next();
               $$7.println($$8.a());
               $$9 = new acm.a($$7);
            }
         } catch (Throwable var12) {
            if ($$6 != null) {
               try {
                  $$6.close();
               } catch (Throwable var11) {
                  var12.addSuppressed(var11);
               }
            }

            throw var12;
         }

         if ($$6 != null) {
            $$6.close();
         }
      } catch (IOException | UncheckedIOException var13) {
         a.warn("Tracing failed", var13);
         $$0.b((rq)rq.c("commands.debug.function.traceFailed"));
      }

      if ($$1.size() == 1) {
         $$0.a(rq.a("commands.debug.function.success.single", $$2, ((dm)$$1.iterator().next()).a(), $$4), true);
      } else {
         $$0.a(rq.a("commands.debug.function.success.multiple", $$2, $$1.size(), $$4), true);
      }

      return $$2;
   }

   static class a implements abo.c, dq {
      public static final int b = 1;
      private final PrintWriter c;
      private int d;
      private boolean e;

      a(PrintWriter $$0) {
         this.c = $$0;
      }

      private void a(int $$0) {
         this.b($$0);
         this.d = $$0;
      }

      private void b(int $$0) {
         for(int $$1 = 0; $$1 < $$0 + 1; ++$$1) {
            this.c.write("    ");
         }

      }

      private void e() {
         if (this.e) {
            this.c.println();
            this.e = false;
         }

      }

      public void a(int $$0, String $$1) {
         this.e();
         this.a($$0);
         this.c.print("[C] ");
         this.c.print($$1);
         this.e = true;
      }

      public void a(int $$0, String $$1, int $$2) {
         if (this.e) {
            this.c.print(" -> ");
            this.c.println($$2);
            this.e = false;
         } else {
            this.a($$0);
            this.c.print("[R = ");
            this.c.print($$2);
            this.c.print("] ");
            this.c.println($$1);
         }

      }

      public void a(int $$0, abb $$1, int $$2) {
         this.e();
         this.a($$0);
         this.c.print("[F] ");
         this.c.print($$1);
         this.c.print(" size=");
         this.c.println($$2);
      }

      public void b(int $$0, String $$1) {
         this.e();
         this.a($$0 + 1);
         this.c.print("[E] ");
         this.c.print($$1);
      }

      public void a(rq $$0) {
         this.e();
         this.b(this.d + 1);
         this.c.print("[M] ");
         this.c.println($$0.getString());
      }

      public boolean i_() {
         return true;
      }

      public boolean j_() {
         return true;
      }

      public boolean G_() {
         return false;
      }

      public boolean d_() {
         return true;
      }
   }
}
