import com.mojang.logging.LogUtils;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public class agr implements agp {
   private static final Logger a = LogUtils.getLogger();
   private final int b;
   private int c;
   private long d;
   private long e = Long.MAX_VALUE;

   public agr(int $$0) {
      int $$1 = $$0 * 2 + 1;
      this.b = $$1 * $$1;
   }

   public void a(cge $$0) {
      this.e = ad.b();
      this.d = this.e;
   }

   public void a(cge $$0, @Nullable cxn $$1) {
      if ($$1 == cxn.o) {
         ++this.c;
      }

      int $$2 = this.c();
      if (ad.b() > this.e) {
         this.e += 500L;
         a.info(rq.a("menu.preparingSpawn", ami.a((int)$$2, (int)0, (int)100)).getString());
      }

   }

   public void a() {
   }

   public void b() {
      a.info("Time elapsed: {} ms", ad.b() - this.d);
      this.e = Long.MAX_VALUE;
   }

   public int c() {
      return ami.d((float)this.c * 100.0F / (float)this.b);
   }
}
