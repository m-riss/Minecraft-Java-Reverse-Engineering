import com.mojang.logging.LogUtils;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import org.slf4j.Logger;

public class abd {
   public static final PrintStream a;
   private static volatile boolean b;
   private static final Logger c;

   public static void a() {
      if (!b) {
         b = true;
         if (hm.d.d().isEmpty()) {
            throw new IllegalStateException("Unable to load registries");
         } else {
            cmi.b();
            ckx.b();
            if (bbr.a(bbr.bn) == null) {
               throw new IllegalStateException("Failed loading EntityTypes");
            } else {
               cct.a();
               gb.a();
               hz.c();
               hu.b();
               hm.m();
               e();
            }
         }
      }
   }

   private static <T> void a(Iterable<T> $$0, Function<T, String> $$1, Set<String> $$2) {
      pe $$3 = pe.a();
      $$0.forEach(($$3x) -> {
         String $$4 = (String)$$1.apply($$3x);
         if (!$$3.b($$4)) {
            $$2.add($$4);
         }

      });
   }

   private static void a(final Set<String> $$0) {
      final pe $$1 = pe.a();
      cgt.a(new cgt.c() {
         public <T extends cgt.g<T>> void a(cgt.e<T> $$0x, cgt.f<T> $$1x) {
            if (!$$1.b($$0x.b())) {
               $$0.add($$0x.a());
            }

         }
      });
   }

   public static Set<String> b() {
      Set<String> $$0 = new TreeSet();
      a(hm.ak, bcy::c, $$0);
      a(hm.X, bbr::g, $$0);
      a(hm.U, bbe::d, $$0);
      a(hm.Y, cat::a, $$0);
      a(hm.W, cer::g, $$0);
      a(hm.V, cjt::g, $$0);
      a(hm.ad, ($$0x) -> {
         String var10000 = $$0x.toString();
         return "stat." + var10000.replace(':', '.');
      }, $$0);
      a((Set)$$0);
      return $$0;
   }

   public static void a(Supplier<String> $$0) {
      if (!b) {
         throw b($$0);
      }
   }

   private static RuntimeException b(Supplier<String> $$0) {
      try {
         String $$1 = (String)$$0.get();
         return new IllegalArgumentException("Not bootstrapped (called from " + $$1 + ")");
      } catch (Exception var3) {
         RuntimeException $$3 = new IllegalArgumentException("Not bootstrapped (failed to resolve location)");
         $$3.addSuppressed(var3);
         return $$3;
      }
   }

   public static void c() {
      a(() -> {
         return "validate";
      });
      if (ab.aL) {
         b().forEach(($$0) -> {
            c.error("Missing translations: {}", $$0);
         });
         ds.b();
         d();
      }

      bde.a();
   }

   private static void d() {
      iw.j.r().forEach(($$0) -> {
         List<he<dkg>> $$1 = $$0.e().b();
         $$1.stream().flatMap(he::a).forEach(($$0x) -> {
            if (!((dkg)$$0x.a()).c().contains(dju.a())) {
               hm var10000 = iw.e;
               ad.a("Placed feature " + var10000.c((Object)((dkg)$$0x.a())) + " is missing BiomeFilter.biome()");
            }

         });
      });
   }

   private static void e() {
      if (c.isDebugEnabled()) {
         System.setErr(new abg("STDERR", System.err));
         System.setOut(new abg("STDOUT", a));
      } else {
         System.setErr(new abi("STDERR", System.err));
         System.setOut(new abi("STDOUT", a));
      }

   }

   public static void a(String $$0) {
      a.println($$0);
   }

   static {
      a = System.out;
      c = LogUtils.getLogger();
   }
}
