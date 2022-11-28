import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetector.Level;
import java.time.Duration;
import javax.annotation.Nullable;

public class ab {
   /** @deprecated */
   @Deprecated
   public static final boolean a = false;
   /** @deprecated */
   @Deprecated
   public static final int b = 3120;
   /** @deprecated */
   @Deprecated
   public static final String c = "main";
   /** @deprecated */
   @Deprecated
   public static final String d = "1.19.2";
   /** @deprecated */
   @Deprecated
   public static final String e = "1.19.2";
   /** @deprecated */
   @Deprecated
   public static final int f = 760;
   /** @deprecated */
   @Deprecated
   public static final int g = 103;
   public static final int h = 3075;
   private static final int aZ = 30;
   public static final boolean i = false;
   /** @deprecated */
   @Deprecated
   public static final int j = 9;
   /** @deprecated */
   @Deprecated
   public static final int k = 10;
   public static final String l = "DataVersion";
   public static final boolean m = false;
   public static final boolean n = false;
   public static final boolean o = false;
   public static final boolean p = false;
   public static final boolean q = false;
   public static final boolean r = false;
   public static final boolean s = false;
   public static final boolean t = false;
   public static final boolean u = false;
   public static final boolean v = false;
   public static final boolean w = false;
   public static final boolean x = false;
   public static final boolean y = false;
   public static final boolean z = false;
   public static final boolean A = false;
   public static final boolean B = false;
   public static final boolean C = false;
   public static final boolean D = false;
   public static final boolean E = false;
   public static final boolean F = false;
   public static final boolean G = false;
   public static final boolean H = false;
   public static final boolean I = false;
   public static final boolean J = false;
   public static final boolean K = false;
   public static final boolean L = false;
   public static final boolean M = false;
   public static final boolean N = false;
   public static final boolean O = false;
   public static final boolean P = false;
   public static final boolean Q = false;
   public static final boolean R = false;
   public static final boolean S = false;
   public static final boolean T = false;
   public static final boolean U = false;
   public static final boolean V = false;
   public static final boolean W = false;
   public static final boolean X = false;
   public static final boolean Y = false;
   public static final boolean Z = false;
   public static final boolean aa = false;
   public static final boolean ab = false;
   public static final boolean ac = false;
   public static final boolean ad = false;
   public static final boolean ae = false;
   public static final boolean af = false;
   public static final boolean ag = false;
   public static final boolean ah = false;
   public static final boolean ai = false;
   public static final boolean aj = false;
   public static final boolean ak = false;
   public static final boolean al = false;
   public static boolean am = false;
   public static boolean an = false;
   public static final boolean ao = false;
   public static final boolean ap = false;
   public static final boolean aq = false;
   public static final boolean ar = false;
   public static final boolean as = false;
   public static final boolean at = false;
   public static final boolean au = false;
   public static final boolean av = false;
   public static final boolean aw = false;
   public static final boolean ax = false;
   public static final int ay = 25565;
   public static final boolean az = false;
   public static final boolean aA = false;
   public static final int aB = 0;
   public static final int aC = 0;
   public static final Level aD;
   public static final boolean aE = false;
   public static final boolean aF = false;
   public static final boolean aG = false;
   public static final boolean aH = false;
   public static final boolean aI = false;
   public static final long aJ;
   public static boolean aK;
   public static boolean aL;
   public static anj aM;
   public static final int aN = 16;
   public static final int aO = 256;
   public static final int aP = 32500;
   public static final int aQ = 1000000;
   public static final int aR = 32;
   public static final char[] aS;
   public static final int aT = 20;
   public static final int aU = 1200;
   public static final int aV = 24000;
   public static final float aW = 1365.3334F;
   public static final float aX = 0.87890625F;
   public static final float aY = 17.578125F;
   @Nullable
   private static ae ba;

   public static boolean a(char $$0) {
      return $$0 != 167 && $$0 >= ' ' && $$0 != 127;
   }

   public static String a(String $$0) {
      return a($$0, false);
   }

   public static String a(String $$0, boolean $$1) {
      StringBuilder $$2 = new StringBuilder();
      char[] var3 = $$0.toCharArray();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         char $$3 = var3[var5];
         if (a($$3)) {
            $$2.append($$3);
         } else if ($$1 && $$3 == '\n') {
            $$2.append($$3);
         }
      }

      return $$2.toString();
   }

   public static void a(ae $$0) {
      if (ba == null) {
         ba = $$0;
      } else if ($$0 != ba) {
         throw new IllegalStateException("Cannot override the current game version!");
      }

   }

   public static void a() {
      if (ba == null) {
         ba = v.a();
      }

   }

   public static ae b() {
      if (ba == null) {
         throw new IllegalStateException("Game version not set");
      } else {
         return ba;
      }
   }

   public static int c() {
      return 760;
   }

   public static boolean a(cge $$0) {
      int $$1 = $$0.d();
      int $$2 = $$0.e();
      if (!am) {
         return false;
      } else {
         return $$1 > 8192 || $$1 < 0 || $$2 > 1024 || $$2 < 0;
      }
   }

   public static void d() {
      anj var10000;
      switch(aM) {
      case c:
         throw new IllegalStateException("Tried to enable datafixer optimization after unoptimized initialization");
      case d:
         var10000 = anj.d;
         break;
      default:
         var10000 = anj.b;
      }

      aM = var10000;
   }

   static {
      aD = Level.DISABLED;
      aJ = Duration.ofMillis(300L).toNanos();
      aK = true;
      aM = anj.a;
      aS = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '"', ':'};
      ResourceLeakDetector.setLevel(aD);
      CommandSyntaxException.ENABLE_COMMAND_STACK_TRACES = false;
      CommandSyntaxException.BUILT_IN_EXCEPTIONS = new dk();
   }
}
