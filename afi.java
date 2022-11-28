import com.google.common.base.Strings;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class afi extends afl<afi> {
   static final Logger Y = LogUtils.getLogger();
   private static final Pattern Z = Pattern.compile("^[a-fA-F0-9]{40}$");
   public final boolean a = this.a("online-mode", true);
   public final boolean b = this.a("prevent-proxy-connections", false);
   public final String c = this.a("server-ip", "");
   public final boolean d = this.a("spawn-animals", true);
   public final boolean e = this.a("spawn-npcs", true);
   public final boolean f = this.a("pvp", true);
   public final boolean g = this.a("allow-flight", false);
   public final String h = this.a("motd", "A Minecraft Server");
   public final boolean i = this.a("force-gamemode", false);
   public final boolean j = this.a("enforce-whitelist", false);
   public final bag k;
   public final cgu l;
   public final String m;
   public final int n;
   @Nullable
   public final Boolean o;
   public final boolean p;
   public final int q;
   public final boolean r;
   public final int s;
   public final String t;
   public final boolean u;
   public final boolean v;
   public final boolean w;
   public final boolean x;
   public final boolean y;
   public final int z;
   public final int A;
   public final int B;
   public final long C;
   public final int D;
   public final int E;
   public final int F;
   public final int G;
   public final int H;
   public final int I;
   public final boolean J;
   public final boolean K;
   public final int L;
   public final boolean M;
   public final boolean N;
   public final boolean O;
   public final boolean P;
   public final int Q;
   public final String R;
   public Optional<MinecraftServer.b> S;
   public final boolean T;
   public final afl<afi>.a<Integer> U;
   public final afl<afi>.a<Boolean> V;
   public final boolean W;
   private final afi.a aa;
   @Nullable
   private dbm ab;

   public afi(Properties $$0) {
      super($$0);
      this.k = (bag)this.a("difficulty", a(bag::a, bag::a), bag::c, bag.b);
      this.l = (cgu)this.a("gamemode", a(cgu::a, cgu::a), cgu::b, cgu.a);
      this.m = this.a("level-name", "world");
      this.n = this.a("server-port", 25565);
      this.o = this.b("announce-player-achievements");
      this.p = this.a("enable-query", false);
      this.q = this.a("query.port", 25565);
      this.r = this.a("enable-rcon", false);
      this.s = this.a("rcon.port", 25575);
      this.t = this.a("rcon.password", "");
      this.u = this.a("hardcore", false);
      this.v = this.a("allow-nether", true);
      this.w = this.a("spawn-monsters", true);
      this.x = this.a("use-native-transport", true);
      this.y = this.a("enable-command-block", false);
      this.z = this.a("spawn-protection", 16);
      this.A = this.a("op-permission-level", 4);
      this.B = this.a("function-permission-level", 2);
      this.C = this.a("max-tick-time", TimeUnit.MINUTES.toMillis(1L));
      this.D = this.a("max-chained-neighbor-updates", 1000000);
      this.E = this.a("rate-limit", 0);
      this.F = this.a("view-distance", 10);
      this.G = this.a("simulation-distance", 10);
      this.H = this.a("max-players", 20);
      this.I = this.a("network-compression-threshold", 256);
      this.J = this.a("broadcast-rcon-to-ops", true);
      this.K = this.a("broadcast-console-to-ops", true);
      this.L = this.a("max-world-size", ($$0x) -> {
         return ami.a((int)$$0x, (int)1, (int)29999984);
      }, 29999984);
      this.M = this.a("sync-chunk-writes", true);
      this.N = this.a("enable-jmx-monitoring", false);
      this.O = this.a("enable-status", true);
      this.P = this.a("hide-online-players", false);
      this.Q = this.a("entity-broadcast-range-percentage", ($$0x) -> {
         return ami.a((int)$$0x, (int)10, (int)1000);
      }, 100);
      this.R = this.a("text-filtering-config", "");
      this.T = this.a("previews-chat", false);
      this.U = this.b("player-idle-timeout", 0);
      this.V = this.b("white-list", false);
      this.W = this.a("enforce-secure-profile", true);
      this.aa = new afi.a(this.a("level-seed", ""), (JsonObject)this.a("generator-settings", ($$0x) -> {
         return alz.a(!$$0x.isEmpty() ? $$0x : "{}");
      }, new JsonObject()), this.a("generate-structures", true), (String)this.a("level-type", ($$0x) -> {
         return $$0x.toLowerCase(Locale.ROOT);
      }, dks.a.a().toString()));
      this.S = a(this.a("resource-pack", ""), this.a("resource-pack-sha1", ""), this.a((String)"resource-pack-hash"), this.a("require-resource-pack", false), this.a("resource-pack-prompt", ""));
   }

   public static afi a(Path $$0) {
      return new afi(b($$0));
   }

   protected afi a(hn $$0, Properties $$1) {
      afi $$2 = new afi($$1);
      $$2.a($$0);
      return $$2;
   }

   @Nullable
   private static rq c(String $$0) {
      if (!Strings.isNullOrEmpty($$0)) {
         try {
            return rq.a.a($$0);
         } catch (Exception var2) {
            Y.warn("Failed to parse resource pack prompt '{}'", $$0, var2);
         }
      }

      return null;
   }

   private static Optional<MinecraftServer.b> a(String $$0, String $$1, @Nullable String $$2, boolean $$3, String $$4) {
      if ($$0.isEmpty()) {
         return Optional.empty();
      } else {
         String $$7;
         if (!$$1.isEmpty()) {
            $$7 = $$1;
            if (!Strings.isNullOrEmpty($$2)) {
               Y.warn("resource-pack-hash is deprecated and found along side resource-pack-sha1. resource-pack-hash will be ignored.");
            }
         } else if (!Strings.isNullOrEmpty($$2)) {
            Y.warn("resource-pack-hash is deprecated. Please use resource-pack-sha1 instead.");
            $$7 = $$2;
         } else {
            $$7 = "";
         }

         if ($$7.isEmpty()) {
            Y.warn("You specified a resource pack without providing a sha1 hash. Pack will be updated on the client only if you change the name of the pack.");
         } else if (!Z.matcher($$7).matches()) {
            Y.warn("Invalid sha1 for resource-pack-sha1");
         }

         rq $$8 = c($$4);
         return Optional.of(new MinecraftServer.b($$0, $$7, $$3, $$8));
      }
   }

   public dbm a(hn $$0) {
      if (this.ab == null) {
         this.ab = this.aa.a($$0);
      }

      return this.ab;
   }

   // $FF: synthetic method
   protected afl b(hn var1, Properties var2) {
      return this.a(var1, var2);
   }

   public static record a(String a, JsonObject b, boolean c, String d) {
      private static final Map<String, aba<dkr>> e;

      public a(String $$0, JsonObject $$1, boolean $$2, String $$3) {
         this.a = $$0;
         this.b = $$1;
         this.c = $$2;
         this.d = $$3;
      }

      public dbm a(hn $$0) {
         long $$1 = dbm.a(this.a()).orElse(amn.a().g());
         hm<dkr> $$2 = $$0.d(hm.aU);
         hc<dkr> $$3 = (hc)$$2.b(dks.a).or(() -> {
            return $$2.g().findAny();
         }).orElseThrow(() -> {
            return new IllegalStateException("Invalid datapack contents: can't find default preset");
         });
         Optional var10000 = Optional.ofNullable(abb.a(this.d)).map(($$0x) -> {
            return aba.a(hm.aU, $$0x);
         }).or(() -> {
            return Optional.ofNullable((aba)e.get(this.d));
         });
         Objects.requireNonNull($$2);
         hc<dkr> $$4 = (hc)var10000.flatMap($$2::b).orElseGet(() -> {
            afi.Y.warn("Failed to parse level-type {}, defaulting to {}", this.d, $$3.e().map(($$0) -> {
               return $$0.a().toString();
            }).orElse("[unnamed]"));
            return $$3;
         });
         dbm $$5 = ((dkr)$$4.a()).a($$1, this.c, false);
         if ($$4.a(dks.b)) {
            aay<JsonElement> $$6 = aay.a((DynamicOps)JsonOps.INSTANCE, (hn)$$0);
            DataResult var11 = djf.a.parse(new Dynamic($$6, this.b()));
            Logger var10001 = afi.Y;
            Objects.requireNonNull(var10001);
            Optional<djf> $$7 = var11.resultOrPartial(var10001::error);
            if ($$7.isPresent()) {
               hm<dlh> $$8 = $$0.d(hm.aO);
               return dbm.a((hn)$$0, (dbm)$$5, new dam($$8, (djf)$$7.get()));
            }
         }

         return $$5;
      }

      public String a() {
         return this.a;
      }

      public JsonObject b() {
         return this.b;
      }

      public boolean c() {
         return this.c;
      }

      public String d() {
         return this.d;
      }

      static {
         e = Map.of("default", dks.a, "largebiomes", dks.c);
      }
   }
}
