import com.mojang.logging.LogUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ClosedByInterruptException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;

public class abz {
   private static final Logger a = LogUtils.getLogger();
   private final String b;
   private final int c;
   private final aiz d;
   private final int e;
   private volatile boolean f;
   @Nullable
   private ServerSocket g;
   private final CopyOnWriteArrayList<Socket> h = new CopyOnWriteArrayList();

   public abz(String $$0, int $$1, aiz $$2, int $$3) {
      this.b = $$0;
      this.c = $$1;
      this.d = $$2;
      this.e = $$3;
   }

   public void a() throws IOException {
      if (this.g != null && !this.g.isClosed()) {
         a.warn("Remote control server was asked to start, but it is already running. Will ignore.");
      } else {
         this.f = true;
         this.g = new ServerSocket(this.c, 50, InetAddress.getByName(this.b));
         Thread $$0 = new Thread(this::d, "chase-server-acceptor");
         $$0.setDaemon(true);
         $$0.start();
         Thread $$1 = new Thread(this::c, "chase-server-sender");
         $$1.setDaemon(true);
         $$1.start();
      }
   }

   private void c() {
      abz.a $$0 = null;

      while(this.f) {
         if (!this.h.isEmpty()) {
            abz.a $$1 = this.e();
            if ($$1 != null && !$$1.equals($$0)) {
               $$0 = $$1;
               byte[] $$2 = $$1.g().getBytes(StandardCharsets.US_ASCII);
               Iterator var4 = this.h.iterator();

               while(var4.hasNext()) {
                  Socket $$3 = (Socket)var4.next();
                  if (!$$3.isClosed()) {
                     ad.h().submit(() -> {
                        try {
                           OutputStream $$2x = $$3.getOutputStream();
                           $$2x.write($$2);
                           $$2x.flush();
                        } catch (IOException var3) {
                           a.info("Remote control client socket got an IO exception and will be closed", var3);
                           IOUtils.closeQuietly($$3);
                        }

                     });
                  }
               }
            }

            List<Socket> $$4 = (List)this.h.stream().filter(Socket::isClosed).collect(Collectors.toList());
            this.h.removeAll($$4);
         }

         if (this.f) {
            try {
               Thread.sleep((long)this.e);
            } catch (InterruptedException var6) {
            }
         }
      }

   }

   public void b() {
      this.f = false;
      IOUtils.closeQuietly(this.g);
      this.g = null;
   }

   private void d() {
      while(true) {
         try {
            if (this.f) {
               if (this.g != null) {
                  a.info("Remote control server is listening for connections on port {}", this.c);
                  Socket $$0 = this.g.accept();
                  a.info("Remote control server received client connection on port {}", $$0.getPort());
                  this.h.add($$0);
               }
               continue;
            }
         } catch (ClosedByInterruptException var6) {
            if (this.f) {
               a.info("Remote control server closed by interrupt");
            }
         } catch (IOException var7) {
            if (this.f) {
               a.error("Remote control server closed because of an IO exception", var7);
            }
         } finally {
            IOUtils.closeQuietly(this.g);
         }

         a.info("Remote control server is now stopped");
         this.f = false;
         return;
      }
   }

   @Nullable
   private abz.a e() {
      List<agh> $$0 = this.d.t();
      if ($$0.isEmpty()) {
         return null;
      } else {
         agh $$1 = (agh)$$0.get(0);
         String $$2 = (String)ach.a.inverse().get($$1.x().ab());
         return $$2 == null ? null : new abz.a($$2, $$1.df(), $$1.dh(), $$1.dl(), $$1.dq(), $$1.ds());
      }
   }

   static record a(String a, double b, double c, double d, float e, float f) {
      a(String $$0, double $$1, double $$2, double $$3, float $$4, float $$5) {
         this.a = $$0;
         this.b = $$1;
         this.c = $$2;
         this.d = $$3;
         this.e = $$4;
         this.f = $$5;
      }

      String g() {
         return String.format(Locale.ROOT, "t %s %.2f %.2f %.2f %.2f %.2f\n", this.a, this.b, this.c, this.d, this.e, this.f);
      }

      public String a() {
         return this.a;
      }

      public double b() {
         return this.b;
      }

      public double c() {
         return this.c;
      }

      public double d() {
         return this.d;
      }

      public float e() {
         return this.e;
      }

      public float f() {
         return this.f;
      }
   }
}
