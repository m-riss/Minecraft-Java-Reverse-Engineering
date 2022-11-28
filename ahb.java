import com.google.common.primitives.Ints;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.logging.LogUtils;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.PrivateKey;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;

public class ahb implements re, zv {
   private static final AtomicInteger b = new AtomicInteger(0);
   static final Logger c = LogUtils.getLogger();
   private static final int d = 600;
   private static final amn e = amn.a();
   private final byte[] f;
   final MinecraftServer g;
   public final qv a;
   ahb.a h;
   private int i;
   @Nullable
   GameProfile j;
   private final String k;
   @Nullable
   private agh l;
   @Nullable
   private buf.a m;

   public ahb(MinecraftServer $$0, qv $$1) {
      this.h = ahb.a.a;
      this.k = "";
      this.g = $$0;
      this.a = $$1;
      this.f = Ints.toByteArray(e.f());
   }

   public void c() {
      if (this.h == ahb.a.e) {
         this.d();
      } else if (this.h == ahb.a.f) {
         agh $$0 = this.g.ac().a(this.j.getId());
         if ($$0 == null) {
            this.h = ahb.a.e;
            this.a(this.l);
            this.l = null;
         }
      }

      if (this.i++ == 600) {
         this.b(rq.c("multiplayer.disconnect.slow_login"));
      }

   }

   public qv a() {
      return this.a;
   }

   public void b(rq $$0) {
      try {
         c.info("Disconnecting {}: {}", this.e(), $$0.getString());
         this.a.a((tc)(new zu($$0)));
         this.a.a($$0);
      } catch (Exception var3) {
         c.error("Error whilst disconnecting player", var3);
      }

   }

   public void d() {
      buf $$0 = null;
      if (!this.j.isComplete()) {
         this.j = this.a(this.j);
      } else {
         try {
            amp $$1 = this.g.an();
            $$0 = a(this.m, this.j.getId(), $$1, this.g.aw());
         } catch (buf.b var7) {
            c.error("Failed to validate profile key: {}", var7.getMessage());
            if (!this.a.d()) {
               this.b(var7.a());
               return;
            }
         }
      }

      rq $$3 = this.g.ac().a(this.a.c(), this.j);
      if ($$3 != null) {
         this.b($$3);
      } else {
         this.h = ahb.a.g;
         if (this.g.av() >= 0 && !this.a.d()) {
            this.a.a((tc)(new zt(this.g.av())), (rb)rb.a(() -> {
               this.a.a(this.g.av(), true);
            }));
         }

         this.a.a((tc)(new zr(this.j)));
         agh $$4 = this.g.ac().a(this.j.getId());

         try {
            agh $$5 = this.g.ac().a(this.j, $$0);
            if ($$4 != null) {
               this.h = ahb.a.f;
               this.l = $$5;
            } else {
               this.a($$5);
            }
         } catch (Exception var6) {
            c.error("Couldn't place player in world", var6);
            rq $$7 = rq.c("multiplayer.disconnect.invalid_player_data");
            this.a.a((tc)(new uf($$7)));
            this.a.a((rq)$$7);
         }
      }

   }

   private void a(agh $$0) {
      this.g.ac().a(this.a, $$0);
   }

   public void a(rq $$0) {
      c.info("{} lost connection: {}", this.e(), $$0.getString());
   }

   public String e() {
      if (this.j != null) {
         GameProfile var10000 = this.j;
         return var10000 + " (" + this.a.c() + ")";
      } else {
         return String.valueOf(this.a.c());
      }
   }

   @Nullable
   private static buf a(@Nullable buf.a $$0, UUID $$1, amp $$2, boolean $$3) throws buf.b {
      if ($$0 == null) {
         if ($$3) {
            throw new buf.b(buf.a);
         } else {
            return null;
         }
      } else {
         return buf.a($$2, $$1, $$0, Duration.ZERO);
      }
   }

   public void a(zx $$0) {
      Validate.validState(this.h == ahb.a.a, "Unexpected hello packet", new Object[0]);
      Validate.validState(a($$0.b()), "Invalid characters in username", new Object[0]);
      this.m = (buf.a)$$0.c().orElse((Object)null);
      GameProfile $$1 = this.g.M();
      if ($$1 != null && $$0.b().equalsIgnoreCase($$1.getName())) {
         this.j = $$1;
         this.h = ahb.a.e;
      } else {
         this.j = new GameProfile((UUID)null, $$0.b());
         if (this.g.T() && !this.a.d()) {
            this.h = ahb.a.b;
            this.a.a((tc)(new zs("", this.g.K().getPublic().getEncoded(), this.f)));
         } else {
            this.h = ahb.a.e;
         }

      }
   }

   public static boolean a(String $$0) {
      return $$0.chars().filter(($$0x) -> {
         return $$0x <= 32 || $$0x >= 127;
      }).findAny().isEmpty();
   }

   public void a(zy $$0) {
      Validate.validState(this.h == ahb.a.b, "Unexpected key packet", new Object[0]);

      final String $$8;
      try {
         PrivateKey $$1 = this.g.K().getPrivate();
         if (this.m != null) {
            buf $$2 = new buf(this.m);
            if (!$$0.a(this.f, $$2)) {
               throw new IllegalStateException("Protocol error");
            }
         } else if (!$$0.a(this.f, $$1)) {
            throw new IllegalStateException("Protocol error");
         }

         SecretKey $$3 = $$0.a($$1);
         Cipher $$4 = ali.a(2, $$3);
         Cipher $$5 = ali.a(1, $$3);
         $$8 = (new BigInteger(ali.a("", this.g.K().getPublic(), $$3))).toString(16);
         this.h = ahb.a.c;
         this.a.a($$4, $$5);
      } catch (alj var7) {
         throw new IllegalStateException("Protocol error", var7);
      }

      Thread $$9 = new Thread("User Authenticator #" + b.incrementAndGet()) {
         public void run() {
            GameProfile $$0 = ahb.this.j;

            try {
               ahb.this.j = ahb.this.g.am().hasJoinedServer(new GameProfile((UUID)null, $$0.getName()), $$8, this.a());
               if (ahb.this.j != null) {
                  ahb.c.info("UUID of player {} is {}", ahb.this.j.getName(), ahb.this.j.getId());
                  ahb.this.h = ahb.a.e;
               } else if (ahb.this.g.N()) {
                  ahb.c.warn("Failed to verify username but will let them in anyway!");
                  ahb.this.j = $$0;
                  ahb.this.h = ahb.a.e;
               } else {
                  ahb.this.b(rq.c("multiplayer.disconnect.unverified_username"));
                  ahb.c.error("Username '{}' tried to join with an invalid session", $$0.getName());
               }
            } catch (AuthenticationUnavailableException var3) {
               if (ahb.this.g.N()) {
                  ahb.c.warn("Authentication servers are down but will let them in anyway!");
                  ahb.this.j = $$0;
                  ahb.this.h = ahb.a.e;
               } else {
                  ahb.this.b(rq.c("multiplayer.disconnect.authservers_down"));
                  ahb.c.error("Couldn't verify username because servers are unavailable");
               }
            }

         }

         @Nullable
         private InetAddress a() {
            SocketAddress $$0 = ahb.this.a.c();
            return ahb.this.g.U() && $$0 instanceof InetSocketAddress ? ((InetSocketAddress)$$0).getAddress() : null;
         }
      };
      $$9.setUncaughtExceptionHandler(new t(c));
      $$9.start();
   }

   public void a(zw $$0) {
      this.b(rq.c("multiplayer.disconnect.unexpected_query_response"));
   }

   protected GameProfile a(GameProfile $$0) {
      UUID $$1 = hr.a($$0.getName());
      return new GameProfile($$1, $$0.getName());
   }

   static enum a {
      a,
      b,
      c,
      d,
      e,
      f,
      g;

      // $FF: synthetic method
      private static ahb.a[] a() {
         return new ahb.a[]{a, b, c, d, e, f, g};
      }
   }
}
