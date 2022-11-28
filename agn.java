import com.mojang.logging.LogUtils;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class agn implements chp {
   private static final Logger a = LogUtils.getLogger();
   private final List<cxj> b;
   private final cxj c;
   private final int d;
   private final agg e;
   private final long f;
   private final drn g;
   private final amn h;
   private final cyu i;
   private final dyf<cjt> j = new dyf(($$0x) -> {
      return this.B($$0x).o();
   });
   private final dyf<dpu> k = new dyf(($$0x) -> {
      return this.B($$0x).p();
   });
   private final chv l;
   private final cge m;
   private final cge n;
   private final cho o;
   private final cxn p;
   private final int q;
   @Nullable
   private Supplier<String> r;
   private final AtomicLong s = new AtomicLong();
   private static final abb t = new abb("worldgen_region_random");

   public agn(agg $$0, List<cxj> $$1, cxn $$2, int $$3) {
      this.p = $$2;
      this.q = $$3;
      int $$4 = ami.b(Math.sqrt((double)$$1.size()));
      if ($$4 * $$4 != $$1.size()) {
         throw (IllegalStateException)ad.c((Throwable)(new IllegalStateException("Cache size is not a square.")));
      } else {
         this.b = $$1;
         this.c = (cxj)$$1.get($$1.size() / 2);
         this.d = $$4;
         this.e = $$0;
         this.f = $$0.B();
         this.g = $$0.n_();
         this.h = $$0.k().h().a(t).a(this.c.f().l());
         this.i = $$0.q_();
         this.l = new chv(this, chv.a(this.f));
         this.m = ((cxj)$$1.get(0)).f();
         this.n = ((cxj)$$1.get($$1.size() - 1)).f();
         this.o = $$0.a().a(this);
      }
   }

   public boolean a(cge $$0, int $$1) {
      return this.e.k().a.a($$0, $$1);
   }

   public cge a() {
      return this.c.f();
   }

   public void a(@Nullable Supplier<String> $$0) {
      this.r = $$0;
   }

   public cxj a(int $$0, int $$1) {
      return this.a($$0, $$1, cxn.c);
   }

   @Nullable
   public cxj a(int $$0, int $$1, cxn $$2, boolean $$3) {
      cxj $$7;
      if (this.b($$0, $$1)) {
         int $$4 = $$0 - this.m.e;
         int $$5 = $$1 - this.m.f;
         $$7 = (cxj)this.b.get($$4 + $$5 * this.d);
         if ($$7.j().b($$2)) {
            return $$7;
         }
      } else {
         $$7 = null;
      }

      if (!$$3) {
         return null;
      } else {
         a.error("Requested chunk : {} {}", $$0, $$1);
         a.error("Region bounds : {} {} | {} {}", new Object[]{this.m.e, this.m.f, this.n.e, this.n.f});
         if ($$7 != null) {
            throw (RuntimeException)ad.c((Throwable)(new RuntimeException(String.format(Locale.ROOT, "Chunk is not of correct status. Expecting %s, got %s | %s %s", $$2, $$7.j(), $$0, $$1))));
         } else {
            throw (RuntimeException)ad.c((Throwable)(new RuntimeException(String.format(Locale.ROOT, "We are asking a region for a chunk out of bound | %s %s", $$0, $$1))));
         }
      }
   }

   public boolean b(int $$0, int $$1) {
      return $$0 >= this.m.e && $$0 <= this.n.e && $$1 >= this.m.f && $$1 <= this.n.f;
   }

   public cvo a_(gt $$0) {
      return this.a(hq.a($$0.u()), hq.a($$0.w())).a_($$0);
   }

   public dpv b_(gt $$0) {
      return this.B($$0).b_($$0);
   }

   @Nullable
   public buc a(double $$0, double $$1, double $$2, double $$3, Predicate<bbn> $$4) {
      return null;
   }

   public int o_() {
      return 0;
   }

   public chv s_() {
      return this.l;
   }

   public hc<cht> a(int $$0, int $$1, int $$2) {
      return this.e.a($$0, $$1, $$2);
   }

   public float a(gy $$0, boolean $$1) {
      return 1.0F;
   }

   public dpm l_() {
      return this.e.l_();
   }

   public boolean a(gt $$0, boolean $$1, @Nullable bbn $$2, int $$3) {
      cvo $$4 = this.a_($$0);
      if ($$4.h()) {
         return false;
      } else {
         if ($$1) {
            cti $$5 = $$4.o() ? this.c_($$0) : null;
            cjt.a((cvo)$$4, (cgx)this.e, $$0, (cti)$$5, (bbn)$$2, cax.b);
         }

         return this.a($$0, cju.a.m(), 3, $$3);
      }
   }

   @Nullable
   public cti c_(gt $$0) {
      cxj $$1 = this.B($$0);
      cti $$2 = $$1.c_($$0);
      if ($$2 != null) {
         return $$2;
      } else {
         pj $$3 = $$1.f($$0);
         cvo $$4 = $$1.a_($$0);
         if ($$3 != null) {
            if ("DUMMY".equals($$3.l("id"))) {
               if (!$$4.o()) {
                  return null;
               }

               $$2 = ((cmb)$$4.b()).a($$0, $$4);
            } else {
               $$2 = cti.a($$0, $$4, $$3);
            }

            if ($$2 != null) {
               $$1.a($$2);
               return $$2;
            }
         }

         if ($$4.o()) {
            a.warn("Tried to access a block entity before it was created. {}", $$0);
         }

         return null;
      }
   }

   public boolean e_(gt $$0) {
      int $$1 = hq.a($$0.u());
      int $$2 = hq.a($$0.w());
      cge $$3 = this.a();
      int $$4 = Math.abs($$3.e - $$1);
      int $$5 = Math.abs($$3.f - $$2);
      if ($$4 <= this.q && $$5 <= this.q) {
         if (this.c.y()) {
            cgz $$6 = this.c.z();
            if ($$0.v() < $$6.u_() || $$0.v() >= $$6.ah()) {
               return false;
            }
         }

         return true;
      } else {
         ad.a("Detected setBlock in a far chunk [" + $$1 + ", " + $$2 + "], pos: " + $$0 + ", status: " + this.p + (this.r == null ? "" : ", currently generating: " + (String)this.r.get()));
         return false;
      }
   }

   public boolean a(gt $$0, cvo $$1, int $$2, int $$3) {
      if (!this.e_($$0)) {
         return false;
      } else {
         cxj $$4 = this.B($$0);
         cvo $$5 = $$4.a($$0, $$1, false);
         if ($$5 != null) {
            this.e.a($$0, $$5, $$1);
         }

         if ($$1.o()) {
            if ($$4.j().g() == cxn.a.b) {
               cti $$6 = ((cmb)$$1.b()).a($$0, $$1);
               if ($$6 != null) {
                  $$4.a($$6);
               } else {
                  $$4.d($$0);
               }
            } else {
               pj $$7 = new pj();
               $$7.a("x", $$0.u());
               $$7.a("y", $$0.v());
               $$7.a("z", $$0.w());
               $$7.a("id", "DUMMY");
               $$4.a($$7);
            }
         } else if ($$5 != null && $$5.o()) {
            $$4.d($$0);
         }

         if ($$1.q(this, $$0)) {
            this.f($$0);
         }

         return true;
      }
   }

   private void f(gt $$0) {
      this.B($$0).e($$0);
   }

   public boolean b(bbn $$0) {
      int $$1 = hq.a($$0.de());
      int $$2 = hq.a($$0.dk());
      this.a($$1, $$2).a($$0);
      return true;
   }

   public boolean a(gt $$0, boolean $$1) {
      return this.a($$0, cju.a.m(), 3);
   }

   public cxe p_() {
      return this.e.p_();
   }

   public boolean k_() {
      return false;
   }

   /** @deprecated */
   @Deprecated
   public agg D() {
      return this.e;
   }

   public hn s() {
      return this.e.s();
   }

   public drn n_() {
      return this.g;
   }

   public bah d_(gt $$0) {
      if (!this.b(hq.a($$0.u()), hq.a($$0.w()))) {
         throw new RuntimeException("We are asking a region for a chunk out of bound");
      } else {
         return new bah(this.e.ag(), this.e.V(), 0L, this.e.al());
      }
   }

   @Nullable
   public MinecraftServer n() {
      return this.e.n();
   }

   public cxm I() {
      return this.e.k();
   }

   public long B() {
      return this.f;
   }

   public dxw<cjt> K() {
      return this.j;
   }

   public dxw<dpu> J() {
      return this.k;
   }

   public int m_() {
      return this.e.m_();
   }

   public amn r_() {
      return this.h;
   }

   public int a(dar.a $$0, int $$1, int $$2) {
      return this.a(hq.a($$1), hq.a($$2)).a($$0, $$1 & 15, $$2 & 15) + 1;
   }

   public void a(@Nullable buc $$0, gt $$1, ajv $$2, ajx $$3, float $$4, float $$5) {
   }

   public void a(im $$0, double $$1, double $$2, double $$3, double $$4, double $$5, double $$6) {
   }

   public void a(@Nullable buc $$0, int $$1, gt $$2, int $$3) {
   }

   public void a(czv $$0, dwq $$1, czv.a $$2) {
   }

   public cyu q_() {
      return this.i;
   }

   public boolean a(gt $$0, Predicate<cvo> $$1) {
      return $$1.test(this.a_($$0));
   }

   public boolean b(gt $$0, Predicate<dpv> $$1) {
      return $$1.test(this.b_($$0));
   }

   public <T extends bbn> List<T> a(czj<bbn, T> $$0, dwl $$1, Predicate<? super T> $$2) {
      return Collections.emptyList();
   }

   public List<bbn> a(@Nullable bbn $$0, dwl $$1, @Nullable Predicate<? super bbn> $$2) {
      return Collections.emptyList();
   }

   public List<buc> w() {
      return Collections.emptyList();
   }

   public int u_() {
      return this.e.u_();
   }

   public int v_() {
      return this.e.v_();
   }

   public long t_() {
      return this.s.getAndIncrement();
   }
}
