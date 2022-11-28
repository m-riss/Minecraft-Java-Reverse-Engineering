import com.google.common.base.Charsets;
import com.mojang.logging.LogUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.Socket;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;

public class aby {
   private static final Logger a = LogUtils.getLogger();
   private static final int b = 5;
   private final String c;
   private final int d;
   private final MinecraftServer e;
   private volatile boolean f;
   @Nullable
   private Socket g;
   @Nullable
   private Thread h;

   public aby(String $$0, int $$1, MinecraftServer $$2) {
      this.c = $$0;
      this.d = $$1;
      this.e = $$2;
   }

   public void a() {
      if (this.h != null && this.h.isAlive()) {
         a.warn("Remote control client was asked to start, but it is already running. Will ignore.");
      }

      this.f = true;
      this.h = new Thread(this::c, "chase-client");
      this.h.setDaemon(true);
      this.h.start();
   }

   public void b() {
      this.f = false;
      IOUtils.closeQuietly(this.g);
      this.g = null;
      this.h = null;
   }

   public void c() {
      String $$0 = this.c + ":" + this.d;

      while(this.f) {
         try {
            a.info("Connecting to remote control server {}", $$0);
            this.g = new Socket(this.c, this.d);
            a.info("Connected to remote control server! Will continuously execute the command broadcasted by that server.");

            try {
               BufferedReader $$1 = new BufferedReader(new InputStreamReader(this.g.getInputStream(), Charsets.US_ASCII));

               try {
                  while(this.f) {
                     String $$2 = $$1.readLine();
                     if ($$2 == null) {
                        a.warn("Lost connection to remote control server {}. Will retry in {}s.", $$0, 5);
                        break;
                     }

                     this.a($$2);
                  }
               } catch (Throwable var7) {
                  try {
                     $$1.close();
                  } catch (Throwable var6) {
                     var7.addSuppressed(var6);
                  }

                  throw var7;
               }

               $$1.close();
            } catch (IOException var8) {
               a.warn("Lost connection to remote control server {}. Will retry in {}s.", $$0, 5);
            }
         } catch (IOException var9) {
            a.warn("Failed to connect to remote control server {}. Will retry in {}s.", $$0, 5);
         }

         if (this.f) {
            try {
               Thread.sleep(5000L);
            } catch (InterruptedException var5) {
            }
         }
      }

   }

   private void a(String $$0) {
      try {
         Scanner $$1 = new Scanner(new StringReader($$0));

         try {
            $$1.useLocale(Locale.ROOT);
            String $$2 = $$1.next();
            if ("t".equals($$2)) {
               this.a($$1);
            } else {
               a.warn("Unknown message type '{}'", $$2);
            }
         } catch (Throwable var6) {
            try {
               $$1.close();
            } catch (Throwable var5) {
               var6.addSuppressed(var5);
            }

            throw var6;
         }

         $$1.close();
      } catch (NoSuchElementException var7) {
         a.warn("Could not parse message '{}', ignoring", $$0);
      }

   }

   private void a(Scanner $$0) {
      this.b($$0).ifPresent(($$0x) -> {
         this.b(String.format(Locale.ROOT, "execute in %s run tp @s %.3f %.3f %.3f %.3f %.3f", $$0x.a.a(), $$0x.b.c, $$0x.b.d, $$0x.b.e, $$0x.c.j, $$0x.c.i));
      });
   }

   private Optional<aby.a> b(Scanner $$0) {
      aba<cgx> $$1 = (aba)ach.a.get($$0.next());
      if ($$1 == null) {
         return Optional.empty();
      } else {
         float $$2 = $$0.nextFloat();
         float $$3 = $$0.nextFloat();
         float $$4 = $$0.nextFloat();
         float $$5 = $$0.nextFloat();
         float $$6 = $$0.nextFloat();
         return Optional.of(new aby.a($$1, new dwq((double)$$2, (double)$$3, (double)$$4), new dwp($$6, $$5)));
      }
   }

   private void b(String $$0) {
      this.e.execute(() -> {
         List<agh> $$1 = this.e.ac().t();
         if (!$$1.isEmpty()) {
            agh $$2 = (agh)$$1.get(0);
            agg $$3 = this.e.C();
            dr $$4 = new dr($$2, dwq.b((hs)$$3.Q()), dwp.a, $$3, 4, "", rp.a, this.e, $$2);
            ds $$5 = this.e.aC();
            $$5.a($$4, $$0);
         }
      });
   }

   static record a(aba<cgx> a, dwq b, dwp c) {
      final aba<cgx> a;
      final dwq b;
      final dwp c;

      a(aba<cgx> $$0, dwq $$1, dwp $$2) {
         this.a = $$0;
         this.b = $$1;
         this.c = $$2;
      }

      public aba<cgx> a() {
         return this.a;
      }

      public dwq b() {
         return this.b;
      }

      public dwp c() {
         return this.c;
      }
   }
}
