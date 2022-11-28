import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Either;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class agh extends buc {
   private static final Logger co = LogUtils.getLogger();
   private static final int cp = 32;
   private static final int cq = 10;
   public agz b;
   public final MinecraftServer c;
   public final agi d;
   private final abj cr;
   private final akc cs;
   private float ct = Float.MIN_VALUE;
   private int cu = Integer.MIN_VALUE;
   private int cv = Integer.MIN_VALUE;
   private int cw = Integer.MIN_VALUE;
   private int cx = Integer.MIN_VALUE;
   private int cy = Integer.MIN_VALUE;
   private float cz = -1.0E8F;
   private int cA = -99999999;
   private boolean cB = true;
   private int cC = -99999999;
   private int cD = 60;
   private bua cE;
   private boolean cF;
   private long cG;
   @Nullable
   private bbn cH;
   private boolean cI;
   private boolean cJ;
   private final akb cK;
   @Nullable
   private dwq cL;
   private int cM;
   private boolean cN;
   @Nullable
   private dwq cO;
   @Nullable
   private dwq cP;
   @Nullable
   private dwq cQ;
   private hq cR;
   private aba<cgx> cS;
   @Nullable
   private gt cT;
   private boolean cU;
   private float cV;
   private final ahe cW;
   private boolean cX;
   private boolean cY;
   private final bwz cZ;
   private final bwy da;
   private int db;
   public int e;
   public boolean f;

   public agh(MinecraftServer $$0, agg $$1, GameProfile $$2, @Nullable buf $$3) {
      super($$1, $$1.Q(), $$1.R(), $$2, $$3);
      this.cE = bua.a;
      this.cF = true;
      this.cG = ad.b();
      this.cK = new akb();
      this.cR = hq.a(0, 0, 0);
      this.cS = cgx.e;
      this.cY = true;
      this.cZ = new bwz() {
         public void a(bwm $$0, hi<cax> $$1, cax $$2, int[] $$3) {
            agh.this.b.a((tc)(new tx($$0.j, $$0.k(), $$1, $$2)));

            for(int $$4 = 0; $$4 < $$3.length; ++$$4) {
               this.b($$0, $$4, $$3[$$4]);
            }

         }

         public void a(bwm $$0, int $$1, cax $$2) {
            agh.this.b.a((tc)(new tz($$0.j, $$0.k(), $$1, $$2)));
         }

         public void a(bwm $$0, cax $$1) {
            agh.this.b.a((tc)(new tz(-1, $$0.k(), -1, $$1)));
         }

         public void a(bwm $$0, int $$1, int $$2) {
            this.b($$0, $$1, $$2);
         }

         private void b(bwm $$0, int $$1, int $$2) {
            agh.this.b.a((tc)(new ty($$0.j, $$1, $$2)));
         }
      };
      this.da = new bwy() {
         public void a(bwm $$0, int $$1, cax $$2) {
            byd $$3 = $$0.b($$1);
            if (!($$3 instanceof bxz)) {
               if ($$3.d == agh.this.fA()) {
                  aj.e.a(agh.this, agh.this.fA(), $$2);
               }

            }
         }

         public void a(bwm $$0, int $$1, int $$2) {
         }
      };
      this.cW = $$0.a(this);
      this.d = $$0.b(this);
      this.c = $$0;
      this.cs = $$0.ac().a((buc)this);
      this.cr = $$0.ac().f(this);
      this.P = 1.0F;
      this.d($$1);
   }

   private void d(agg $$0) {
      gt $$1 = $$0.Q();
      if ($$0.q_().g() && $$0.n().aW().m() != cgu.c) {
         int $$2 = Math.max(0, this.c.a($$0));
         int $$3 = ami.b($$0.p_().b((double)$$1.u(), (double)$$1.w()));
         if ($$3 < $$2) {
            $$2 = $$3;
         }

         if ($$3 <= 1) {
            $$2 = 1;
         }

         long $$4 = (long)($$2 * 2 + 1);
         long $$5 = $$4 * $$4;
         int $$6 = $$5 > 2147483647L ? Integer.MAX_VALUE : (int)$$5;
         int $$7 = this.u($$6);
         int $$8 = amn.a().a($$6);

         for(int $$9 = 0; $$9 < $$6; ++$$9) {
            int $$10 = ($$8 + $$7 * $$9) % $$6;
            int $$11 = $$10 % ($$2 * 2 + 1);
            int $$12 = $$10 / ($$2 * 2 + 1);
            gt $$13 = agb.a($$0, $$1.u() + $$11 - $$2, $$1.w() + $$12 - $$2);
            if ($$13 != null) {
               this.a($$13, 0.0F, 0.0F);
               if ($$0.g(this)) {
                  break;
               }
            }
         }
      } else {
         this.a($$1, 0.0F, 0.0F);

         while(!$$0.g(this) && this.dh() < (double)($$0.ah() - 1)) {
            this.e(this.df(), this.dh() + 1.0D, this.dl());
         }
      }

   }

   private int u(int $$0) {
      return $$0 <= 16 ? $$0 - 1 : 17;
   }

   public void a(pj $$0) {
      super.a($$0);
      if ($$0.b("enteredNetherPosition", 10)) {
         pj $$1 = $$0.p("enteredNetherPosition");
         this.cP = new dwq($$1.k("x"), $$1.k("y"), $$1.k("z"));
      }

      this.cJ = $$0.q("seenCredits");
      if ($$0.b("recipeBook", 10)) {
         this.cK.a($$0.p("recipeBook"), this.c.aE());
      }

      if (this.fj()) {
         this.fk();
      }

      if ($$0.b("SpawnX", 99) && $$0.b("SpawnY", 99) && $$0.b("SpawnZ", 99)) {
         this.cT = new gt($$0.h("SpawnX"), $$0.h("SpawnY"), $$0.h("SpawnZ"));
         this.cU = $$0.q("SpawnForced");
         this.cV = $$0.j("SpawnAngle");
         if ($$0.e("SpawnDimension")) {
            DataResult var10001 = cgx.d.parse(pu.a, $$0.c("SpawnDimension"));
            Logger var10002 = co;
            Objects.requireNonNull(var10002);
            this.cS = (aba)var10001.resultOrPartial(var10002::error).orElse(cgx.e);
         }
      }

   }

   public void b(pj $$0) {
      super.b($$0);
      this.k($$0);
      $$0.a("seenCredits", this.cJ);
      if (this.cP != null) {
         pj $$1 = new pj();
         $$1.a("x", this.cP.c);
         $$1.a("y", this.cP.d);
         $$1.a("z", this.cP.e);
         $$0.a((String)"enteredNetherPosition", (qc)$$1);
      }

      bbn $$2 = this.cO();
      bbn $$3 = this.cQ();
      if ($$3 != null && $$2 != this && $$2.cN()) {
         pj $$4 = new pj();
         pj $$5 = new pj();
         $$2.e($$5);
         $$4.a("Attach", $$3.co());
         $$4.a((String)"Entity", (qc)$$5);
         $$0.a((String)"RootVehicle", (qc)$$4);
      }

      $$0.a((String)"recipeBook", (qc)this.cK.b());
      $$0.a("Dimension", this.s.ab().a().toString());
      if (this.cT != null) {
         $$0.a("SpawnX", this.cT.u());
         $$0.a("SpawnY", this.cT.v());
         $$0.a("SpawnZ", this.cT.w());
         $$0.a("SpawnForced", this.cU);
         $$0.a("SpawnAngle", this.cV);
         DataResult var10000 = abb.a.encodeStart(pu.a, this.cS.a());
         Logger var10001 = co;
         Objects.requireNonNull(var10001);
         var10000.resultOrPartial(var10001::error).ifPresent(($$1x) -> {
            $$0.a("SpawnDimension", $$1x);
         });
      }

   }

   public void a(int $$0) {
      float $$1 = (float)this.fJ();
      float $$2 = ($$1 - 1.0F) / $$1;
      this.ck = ami.a((float)$$0 / $$1, 0.0F, $$2);
      this.cC = -1;
   }

   public void b(int $$0) {
      this.ci = $$0;
      this.cC = -1;
   }

   public void c(int $$0) {
      super.c($$0);
      this.cC = -1;
   }

   public void a(cax $$0, int $$1) {
      super.a($$0, $$1);
      this.cC = -1;
   }

   private void a(bwm $$0) {
      $$0.a(this.da);
      $$0.a(this.cZ);
   }

   public void g() {
      this.a((bwm)this.bT);
   }

   public void h() {
      super.h();
      this.b.a((tc)(new vh()));
   }

   public void i() {
      super.i();
      this.b.a((tc)(new vg(this.er())));
   }

   protected void a(cvo $$0) {
      aj.d.a(this, $$0);
   }

   protected cau j() {
      return new cbr(this);
   }

   public void k() {
      this.d.a();
      --this.cD;
      if (this.W > 0) {
         --this.W;
      }

      this.bU.d();
      if (!this.s.y && !this.bU.a((buc)this)) {
         this.q();
         this.bU = this.bT;
      }

      bbn $$0 = this.G();
      if ($$0 != this) {
         if ($$0.bo()) {
            this.a($$0.df(), $$0.dh(), $$0.dl(), $$0.dq(), $$0.ds());
            this.x().k().a(this);
            if (this.fp()) {
               this.c((bbn)this);
            }
         } else {
            this.c((bbn)this);
         }
      }

      aj.w.a(this);
      if (this.cL != null) {
         aj.u.a(this, this.cL, this.S - this.cM);
      }

      this.n();
      this.o();
      this.cr.b(this);
   }

   public void l() {
      try {
         if (!this.B_() || !this.cU()) {
            super.k();
         }

         for(int $$0 = 0; $$0 < this.fA().b(); ++$$0) {
            cax $$1 = this.fA().a($$0);
            if ($$1.c().P_()) {
               tc<?> $$2 = ((bzi)$$1.c()).a($$1, this.s, this);
               if ($$2 != null) {
                  this.b.a($$2);
               }
            }
         }

         if (this.ef() != this.cz || this.cA != this.bV.a() || this.bV.e() == 0.0F != this.cB) {
            this.b.a((tc)(new wn(this.ef(), this.bV.a(), this.bV.e())));
            this.cz = this.ef();
            this.cA = this.bV.a();
            this.cB = this.bV.e() == 0.0F;
         }

         if (this.ef() + this.eQ() != this.ct) {
            this.ct = this.ef() + this.eQ();
            this.a(dxr.f, ami.f(this.ct));
         }

         if (this.bV.a() != this.cu) {
            this.cu = this.bV.a();
            this.a(dxr.g, ami.f((float)this.cu));
         }

         if (this.ca() != this.cv) {
            this.cv = this.ca();
            this.a(dxr.h, ami.f((float)this.cv));
         }

         if (this.eq() != this.cw) {
            this.cw = this.eq();
            this.a(dxr.i, ami.f((float)this.cw));
         }

         if (this.cj != this.cy) {
            this.cy = this.cj;
            this.a(dxr.j, ami.f((float)this.cy));
         }

         if (this.ci != this.cx) {
            this.cx = this.ci;
            this.a(dxr.k, ami.f((float)this.cx));
         }

         if (this.cj != this.cC) {
            this.cC = this.cj;
            this.b.a((tc)(new wm(this.ck, this.cj, this.ci)));
         }

         if (this.S % 20 == 0) {
            aj.p.a(this);
         }

      } catch (Throwable var4) {
         q $$4 = q.a(var4, "Ticking player");
         r $$5 = $$4.a("Player being ticked");
         this.a((r)$$5);
         throw new z($$4);
      }
   }

   public void m() {
      if (this.ef() > 0.0F && this.cO != null) {
         aj.U.a(this, this.cO);
      }

      this.cO = null;
      super.m();
   }

   public void n() {
      if (this.L > 0.0F && this.cO == null) {
         this.cO = this.cY();
      }

   }

   public void o() {
      if (this.cQ() != null && this.cQ().bf()) {
         if (this.cQ == null) {
            this.cQ = this.cY();
         } else {
            aj.V.a(this, this.cQ);
         }
      }

      if (this.cQ != null && (this.cQ() == null || !this.cQ().bf())) {
         this.cQ = null;
      }

   }

   private void a(dxr $$0, int $$1) {
      this.fQ().a($$0, this.cq(), ($$1x) -> {
         $$1x.b($$1);
      });
   }

   public void a(baw $$0) {
      this.a((czv)czv.q);
      boolean $$1 = this.s.W().b(cgt.m);
      if ($$1) {
         rq $$2 = this.er().b();
         this.b.a((tc)(new vi(this.er(), $$2)), (rb)rb.a(() -> {
            int $$1 = true;
            String $$2x = $$2.a(256);
            rq $$3 = rq.a("death.attack.message_too_long", rq.b($$2x).a(p.o));
            rq $$4 = rq.a("death.attack.even_more_magic", this.C_()).a(($$1x) -> {
               return $$1x.a(new rv(rv.a.a, $$3));
            });
            return new vi(this.er(), $$4);
         }));
         dxq $$3 = this.bY();
         if ($$3 != null && $$3.k() != dxq.b.a) {
            if ($$3.k() == dxq.b.c) {
               this.c.ac().a((buc)this, (rq)$$2);
            } else if ($$3.k() == dxq.b.d) {
               this.c.ac().b(this, $$2);
            }
         } else {
            this.c.ac().a($$2, false);
         }
      } else {
         this.b.a((tc)(new vi(this.er(), rp.a)));
      }

      this.fP();
      if (this.s.W().b(cgt.I)) {
         this.gb();
      }

      if (!this.B_()) {
         this.f($$0);
      }

      this.fQ().a(dxr.c, this.cq(), dxn::a);
      bcc $$4 = this.es();
      if ($$4 != null) {
         this.b((akd)akg.h.b($$4.ad()));
         $$4.a(this, this.bl, $$0);
         this.f($$4);
      }

      this.s.a(this, (byte)3);
      this.a((abb)akg.N);
      this.a(akg.i.b(akg.m));
      this.a(akg.i.b(akg.n));
      this.au();
      this.j(0);
      this.a_(false);
      this.er().g();
      this.a((Optional)Optional.of(hb.a(this.s.ab(), this.da())));
   }

   private void gb() {
      dwl $$0 = (new dwl(this.da())).c(32.0D, 10.0D, 32.0D);
      this.s.a((Class)bce.class, (dwl)$$0, (Predicate)bbq.f).stream().filter(($$0x) -> {
         return $$0x instanceof bcj;
      }).forEach(($$0x) -> {
         ((bcj)$$0x).a_((buc)this);
      });
   }

   public void a(bbn $$0, int $$1, baw $$2) {
      if ($$0 != this) {
         super.a($$0, $$1, $$2);
         this.s($$1);
         String $$3 = this.cq();
         String $$4 = $$0.cq();
         this.fQ().a(dxr.e, $$3, dxn::a);
         if ($$0 instanceof buc) {
            this.a((abb)akg.Q);
            this.fQ().a(dxr.d, $$3, dxn::a);
         } else {
            this.a((abb)akg.O);
         }

         this.a($$3, $$4, dxr.l);
         this.a($$4, $$3, dxr.m);
         aj.b.a(this, $$0, $$2);
      }
   }

   private void a(String $$0, String $$1, dxr[] $$2) {
      dxm $$3 = this.fQ().i($$1);
      if ($$3 != null) {
         int $$4 = $$3.n().b();
         if ($$4 >= 0 && $$4 < $$2.length) {
            this.fQ().a($$2[$$4], $$0, dxn::a);
         }
      }

   }

   public boolean a(baw $$0, float $$1) {
      if (this.b($$0)) {
         return false;
      } else {
         boolean $$2 = this.c.k() && this.gc() && "fall".equals($$0.y);
         if (!$$2 && this.cD > 0 && $$0 != baw.m) {
            return false;
         } else {
            if ($$0 instanceof bax) {
               bbn $$3 = $$0.m();
               if ($$3 instanceof buc && !this.a((buc)$$3)) {
                  return false;
               }

               if ($$3 instanceof bui) {
                  bui $$4 = (bui)$$3;
                  bbn $$5 = $$4.x();
                  if ($$5 instanceof buc && !this.a((buc)$$5)) {
                     return false;
                  }
               }
            }

            return super.a($$0, $$1);
         }
      }
   }

   public boolean a(buc $$0) {
      return !this.gc() ? false : super.a($$0);
   }

   private boolean gc() {
      return this.c.X();
   }

   @Nullable
   protected dqt a(agg $$0) {
      dqt $$1 = super.a((agg)$$0);
      if ($$1 != null && this.s.ab() == cgx.e && $$0.ab() == cgx.g) {
         dwq $$2 = $$1.a.b(0.0D, -1.0D, 0.0D);
         return new dqt($$2, dwq.b, 90.0F, 0.0F);
      } else {
         return $$1;
      }
   }

   @Nullable
   public bbn b(agg $$0) {
      this.cI = true;
      agg $$1 = this.x();
      aba<cgx> $$2 = $$1.ab();
      if ($$2 == cgx.g && $$0.ab() == cgx.e) {
         this.ab();
         this.x().a(this, bbn.c.e);
         if (!this.f) {
            this.f = true;
            this.b.a((tc)(new uj(uj.e, this.cJ ? 0.0F : 1.0F)));
            this.cJ = true;
         }

         return this;
      } else {
         drn $$3 = $$0.n_();
         this.b.a((tc)(new vq($$0.Z(), $$0.ab(), chv.a($$0.B()), this.d.b(), this.d.c(), $$0.ae(), $$0.A(), true, this.ga())));
         this.b.a((tc)(new tr($$3.s(), $$3.t())));
         aiz $$4 = this.c.ac();
         $$4.d(this);
         $$1.a(this, bbn.c.e);
         this.dv();
         dqt $$5 = this.a($$0);
         if ($$5 != null) {
            $$1.ac().a("moving");
            if ($$2 == cgx.e && $$0.ab() == cgx.f) {
               this.cP = this.cY();
            } else if ($$0.ab() == cgx.g) {
               this.a($$0, new gt($$5.a));
            }

            $$1.ac().c();
            $$1.ac().a("placing");
            this.c($$0);
            $$0.b(this);
            this.a($$5.c, $$5.d);
            this.c($$5.a.c, $$5.a.d, $$5.a.e);
            $$1.ac().c();
            this.e($$1);
            this.b.a((tc)(new vd(this.fB())));
            $$4.a(this, $$0);
            $$4.e(this);
            Iterator var7 = this.ec().iterator();

            while(var7.hasNext()) {
               bbg $$6 = (bbg)var7.next();
               this.b.a((tc)(new xh(this.ae(), $$6)));
            }

            this.b.a((tc)(new up(1032, gt.b, 0, false)));
            this.cC = -1;
            this.cz = -1.0F;
            this.cA = -1;
         }

         return this;
      }
   }

   private void a(agg $$0, gt $$1) {
      gt.a $$2 = $$1.i();

      for(int $$3 = -2; $$3 <= 2; ++$$3) {
         for(int $$4 = -2; $$4 <= 2; ++$$4) {
            for(int $$5 = -1; $$5 < 3; ++$$5) {
               cvo $$6 = $$5 == -1 ? cju.bZ.m() : cju.a.m();
               $$0.b((gt)$$2.g($$1).e($$4, $$5, $$3), (cvo)$$6);
            }
         }
      }

   }

   protected Optional<n.a> a(agg $$0, gt $$1, boolean $$2, cxe $$3) {
      Optional<n.a> $$4 = super.a($$0, $$1, $$2, $$3);
      if ($$4.isPresent()) {
         return $$4;
      } else {
         gy.a $$5 = (gy.a)this.s.a_(this.ai).d(cop.a).orElse(gy.a.a);
         Optional<n.a> $$6 = $$0.o().a($$1, $$5);
         if (!$$6.isPresent()) {
            co.error("Unable to create a portal, likely target out of worldborder");
         }

         return $$6;
      }
   }

   private void e(agg $$0) {
      aba<cgx> $$1 = $$0.ab();
      aba<cgx> $$2 = this.s.ab();
      aj.v.a(this, $$1, $$2);
      if ($$1 == cgx.f && $$2 == cgx.e && this.cP != null) {
         aj.C.a(this, this.cP);
      }

      if ($$2 != cgx.f) {
         this.cP = null;
      }

   }

   public boolean a(agh $$0) {
      if ($$0.B_()) {
         return this.G() == this;
      } else {
         return this.B_() ? false : super.a((agh)$$0);
      }
   }

   public void a(bbn $$0, int $$1) {
      super.a((bbn)$$0, $$1);
      this.bU.d();
   }

   public Either<buc.a, anf> a(gt $$0) {
      gy $$1 = (gy)this.s.a_($$0).c(cnf.aD);
      if (!this.fj() && this.bo()) {
         if (!this.s.q_().j()) {
            return Either.left(buc.a.a);
         } else if (!this.a($$0, $$1)) {
            return Either.left(buc.a.c);
         } else if (this.b($$0, $$1)) {
            return Either.left(buc.a.d);
         } else {
            this.a(this.s.ab(), $$0, this.dq(), false, true);
            if (this.s.M()) {
               return Either.left(buc.a.b);
            } else {
               if (!this.f()) {
                  double $$2 = 8.0D;
                  double $$3 = 5.0D;
                  dwq $$4 = dwq.c((hs)$$0);
                  List<brq> $$5 = this.s.a((Class)brq.class, (dwl)(new dwl($$4.a() - 8.0D, $$4.b() - 5.0D, $$4.c() - 8.0D, $$4.a() + 8.0D, $$4.b() + 5.0D, $$4.c() + 8.0D)), (Predicate)(($$0x) -> {
                     return $$0x.e(this);
                  }));
                  if (!$$5.isEmpty()) {
                     return Either.left(buc.a.f);
                  }
               }

               Either<buc.a, anf> $$6 = super.a($$0).ifRight(($$0x) -> {
                  this.a((abb)akg.ap);
                  aj.q.a(this);
               });
               if (!this.x().d()) {
                  this.a((rq)rq.c("sleep.not_possible"), true);
               }

               ((agg)this.s).e();
               return $$6;
            }
         }
      } else {
         return Either.left(buc.a.e);
      }
   }

   public void b(gt $$0) {
      this.a(akg.i.b(akg.n));
      super.b((gt)$$0);
   }

   private boolean a(gt $$0, gy $$1) {
      return this.g($$0) || this.g($$0.a($$1.g()));
   }

   private boolean g(gt $$0) {
      dwq $$1 = dwq.c((hs)$$0);
      return Math.abs(this.df() - $$1.a()) <= 3.0D && Math.abs(this.dh() - $$1.b()) <= 2.0D && Math.abs(this.dl() - $$1.c()) <= 3.0D;
   }

   private boolean b(gt $$0, gy $$1) {
      gt $$2 = $$0.b();
      return !this.f($$2) || !this.f($$2.a($$1.g()));
   }

   public void a(boolean $$0, boolean $$1) {
      if (this.fj()) {
         this.x().k().a((bbn)this, (tc)(new tj(this, 2)));
      }

      super.a($$0, $$1);
      if (this.b != null) {
         this.b.b(this.df(), this.dh(), this.dl(), this.dq(), this.ds());
      }

   }

   public boolean a(bbn $$0, boolean $$1) {
      bbn $$2 = this.cQ();
      if (!super.a((bbn)$$0, $$1)) {
         return false;
      } else {
         bbn $$3 = this.cQ();
         if ($$3 != $$2 && this.b != null) {
            this.b.b(this.df(), this.dh(), this.dl(), this.dq(), this.ds());
         }

         return true;
      }
   }

   public void p() {
      bbn $$0 = this.cQ();
      super.p();
      bbn $$1 = this.cQ();
      if ($$1 != $$0 && this.b != null) {
         this.b.a(this.df(), this.dh(), this.dl(), this.dq(), this.ds());
      }

   }

   public void a(double $$0, double $$1, double $$2) {
      this.bw();
      if (this.b != null) {
         this.b.a($$0, $$1, $$2, this.dq(), this.ds());
      }

   }

   public boolean b(baw $$0) {
      return super.b($$0) || this.K() || this.fB().a && $$0 == baw.p;
   }

   protected void a(double $$0, boolean $$1, cvo $$2, gt $$3) {
   }

   protected void c(gt $$0) {
      if (!this.B_()) {
         super.c((gt)$$0);
      }

   }

   public void a(double $$0, boolean $$1) {
      if (!this.cU()) {
         gt $$2 = this.aA();
         super.a($$0, $$1, this.s.a_($$2), $$2);
      }
   }

   public void a(cuk $$0) {
      $$0.a(this.co());
      this.b.a((tc)(new tp(this.s, $$0.p())));
      this.b.a((tc)(new va($$0.p())));
   }

   private void gd() {
      this.db = this.db % 100 + 1;
   }

   public OptionalInt a(@Nullable bam $$0) {
      if ($$0 == null) {
         return OptionalInt.empty();
      } else {
         if (this.bU != this.bT) {
            this.q();
         }

         this.gd();
         bwm $$1 = $$0.createMenu(this.db, this.fA(), this);
         if ($$1 == null) {
            if (this.B_()) {
               this.a((rq)rq.c("container.spectatorCantOpen").a(p.m), true);
            }

            return OptionalInt.empty();
         } else {
            this.b.a((tc)(new uz($$1.j, $$1.a(), $$0.C_())));
            this.a($$1);
            this.bU = $$1;
            return OptionalInt.of(this.db);
         }
      }
   }

   public void a(int $$0, cfw $$1, int $$2, int $$3, boolean $$4, boolean $$5) {
      this.b.a((tc)(new uv($$0, $$1, $$2, $$3, $$4, $$5)));
   }

   public void a(bpa $$0, bac $$1) {
      if (this.bU != this.bT) {
         this.q();
      }

      this.gd();
      this.b.a((tc)(new uk(this.db, $$1.b(), $$0.ae())));
      this.bU = new bxk(this.db, this.fA(), $$1, $$0);
      this.a(this.bU);
   }

   public void a(cax $$0, bai $$1) {
      if ($$0.a(caz.rY)) {
         if (ccr.a((cax)$$0, (dr)this.cT(), (buc)this)) {
            this.bU.d();
         }

         this.b.a((tc)(new uy($$1)));
      }

   }

   public void a(ctp $$0) {
      this.b.a((tc)tn.a($$0, cti::o));
   }

   public void q() {
      this.b.a((tc)(new tw(this.bU.j)));
      this.r();
   }

   public void r() {
      this.bU.b((buc)this);
      this.bT.a((bwm)this.bU);
      this.bU = this.bT;
   }

   public void a(float $$0, float $$1, boolean $$2, boolean $$3) {
      if (this.bI()) {
         if ($$0 >= -1.0F && $$0 <= 1.0F) {
            this.bo = $$0;
         }

         if ($$1 >= -1.0F && $$1 <= 1.0F) {
            this.bq = $$1;
         }

         this.bn = $$2;
         this.f($$3);
      }

   }

   public void a(akd<?> $$0, int $$1) {
      this.cs.b(this, $$0, $$1);
      this.fQ().a((dxr)$$0, this.cq(), (Consumer)(($$1x) -> {
         $$1x.a($$1);
      }));
   }

   public void a(akd<?> $$0) {
      this.cs.a(this, $$0, 0);
      this.fQ().a((dxr)$$0, this.cq(), (Consumer)(dxn::c));
   }

   public int a(Collection<cdp<?>> $$0) {
      return this.cK.a($$0, this);
   }

   public void a(abb[] $$0) {
      List<cdp<?>> $$1 = Lists.newArrayList();
      abb[] var3 = $$0;
      int var4 = $$0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         abb $$2 = var3[var5];
         Optional var10000 = this.c.aE().a($$2);
         Objects.requireNonNull($$1);
         var10000.ifPresent($$1::add);
      }

      this.a((Collection)$$1);
   }

   public int b(Collection<cdp<?>> $$0) {
      return this.cK.b($$0, this);
   }

   public void d(int $$0) {
      super.d($$0);
      this.cC = -1;
   }

   public void s() {
      this.cN = true;
      this.bv();
      if (this.fj()) {
         this.a(true, false);
      }

   }

   public boolean t() {
      return this.cN;
   }

   public void u() {
      this.cz = -1.0E8F;
   }

   public void a(rq $$0, boolean $$1) {
      this.b($$0, $$1);
   }

   protected void v() {
      if (!this.bz.b() && this.eT()) {
         this.b.a((tc)(new ug(this, (byte)9)));
         super.v();
      }

   }

   public void a(ea.a $$0, dwq $$1) {
      super.a((ea.a)$$0, (dwq)$$1);
      this.b.a((tc)(new vk($$0, $$1.c, $$1.d, $$1.e)));
   }

   public void a(ea.a $$0, bbn $$1, ea.a $$2) {
      dwq $$3 = $$2.a($$1);
      super.a((ea.a)$$0, (dwq)$$3);
      this.b.a((tc)(new vk($$0, $$1, $$2)));
   }

   public void a(agh $$0, boolean $$1) {
      this.cX = $$0.cX;
      this.d.a($$0.d.b(), $$0.d.c());
      if ($$1) {
         this.fA().a($$0.fA());
         this.c($$0.ef());
         this.bV = $$0.bV;
         this.ci = $$0.ci;
         this.cj = $$0.cj;
         this.ck = $$0.ck;
         this.r($$0.ft());
         this.ai = $$0.ai;
      } else if (this.s.W().b(cgt.d) || $$0.B_()) {
         this.fA().a($$0.fA());
         this.ci = $$0.ci;
         this.cj = $$0.cj;
         this.ck = $$0.ck;
         this.r($$0.ft());
      }

      this.cl = $$0.cl;
      this.bS = $$0.bS;
      this.ai().b(bO, (Byte)$$0.ai().a(bO));
      this.cC = -1;
      this.cz = -1.0F;
      this.cA = -1;
      this.cK.a($$0.cK);
      this.cJ = $$0.cJ;
      this.cP = $$0.cP;
      this.i($$0.fS());
      this.j($$0.fT());
      this.a((Optional)$$0.ga());
   }

   protected void a(bbg $$0, @Nullable bbn $$1) {
      super.a((bbg)$$0, (bbn)$$1);
      this.b.a((tc)(new xh(this.ae(), $$0)));
      if ($$0.b() == bbi.y) {
         this.cM = this.S;
         this.cL = this.cY();
      }

      aj.A.a(this, $$1);
   }

   protected void a(bbg $$0, boolean $$1, @Nullable bbn $$2) {
      super.a($$0, $$1, $$2);
      this.b.a((tc)(new xh(this.ae(), $$0)));
      aj.A.a(this, $$2);
   }

   protected void a(bbg $$0) {
      super.a((bbg)$$0);
      this.b.a((tc)(new vo(this.ae(), $$0.b())));
      if ($$0.b() == bbi.y) {
         this.cL = null;
      }

      aj.A.a(this, (bbn)null);
   }

   public void b(double $$0, double $$1, double $$2) {
      this.b.b($$0, $$1, $$2, this.dq(), this.ds());
   }

   public void c(double $$0, double $$1, double $$2) {
      this.b($$0, $$1, $$2);
      this.b.d();
   }

   public void a(bbn $$0) {
      this.x().k().a((bbn)this, (tc)(new tj($$0, 4)));
   }

   public void b(bbn $$0) {
      this.x().k().a((bbn)this, (tc)(new tj($$0, 5)));
   }

   public void w() {
      if (this.b != null) {
         this.b.a((tc)(new vd(this.fB())));
         this.F();
      }
   }

   public agg x() {
      return (agg)this.s;
   }

   public boolean a(cgu $$0) {
      if (!this.d.a($$0)) {
         return false;
      } else {
         this.b.a((tc)(new uj(uj.d, (float)$$0.a())));
         if ($$0 == cgu.d) {
            this.fP();
            this.p();
         } else {
            this.c((bbn)this);
         }

         this.w();
         this.eR();
         return true;
      }
   }

   public boolean B_() {
      return this.d.b() == cgu.d;
   }

   public boolean f() {
      return this.d.b() == cgu.b;
   }

   public void a(rq $$0) {
      this.b($$0, false);
   }

   public void b(rq $$0, boolean $$1) {
      if (this.u($$1)) {
         this.b.a((tc)(new xa($$0, $$1)), (rb)rb.a(() -> {
            if (this.u(false)) {
               int $$1 = true;
               String $$2 = $$0.a(256);
               rq $$3 = rq.b($$2).a(p.o);
               return new xa(rq.a("multiplayer.message_not_delivered", $$3).a(p.m), false);
            } else {
               return null;
            }
         }));
      }
   }

   public void a(sc $$0, boolean $$1, rm.a $$2) {
      if (this.ge()) {
         $$0.a(this, $$1, $$2);
      }

   }

   public void a(sh $$0, rz $$1, byte[] $$2) {
      if (this.ge()) {
         this.b.a((tc)(new ve($$0, $$1, $$2)));
      }

   }

   public String y() {
      String $$0 = this.b.b.c().toString();
      $$0 = $$0.substring($$0.indexOf("/") + 1);
      $$0 = $$0.substring(0, $$0.indexOf(":"));
      return $$0;
   }

   public void a(xw $$0) {
      this.cE = $$0.d();
      this.cF = $$0.e();
      this.cX = $$0.h();
      this.cY = $$0.i();
      this.ai().b(bO, (byte)$$0.f());
      this.ai().b(bP, (byte)($$0.g() == bbx.a ? 0 : 1));
   }

   public boolean z() {
      return this.cF;
   }

   public bua A() {
      return this.cE;
   }

   private boolean u(boolean $$0) {
      return this.cE == bua.c ? $$0 : true;
   }

   private boolean ge() {
      return this.cE == bua.a;
   }

   public void a(String $$0, String $$1, boolean $$2, @Nullable rq $$3) {
      this.b.a((tc)(new vp($$0, $$1, $$2, $$3)));
   }

   public void a(aae $$0) {
      this.b.a((tc)(new vu($$0.a(), $$0.d(), $$0.e(), $$0.f())));
   }

   protected int B() {
      return this.c.c(this.fy());
   }

   public void C() {
      this.cG = ad.b();
   }

   public akc D() {
      return this.cs;
   }

   public akb E() {
      return this.cK;
   }

   protected void F() {
      if (this.B_()) {
         this.ea();
         this.j(true);
      } else {
         super.F();
      }

   }

   public bbn G() {
      return (bbn)(this.cH == null ? this : this.cH);
   }

   public void c(@Nullable bbn $$0) {
      bbn $$1 = this.G();
      this.cH = (bbn)($$0 == null ? this : $$0);
      if ($$1 != this.cH) {
         this.b.a((tc)(new wb(this.cH)));
         this.b(this.cH.df(), this.cH.dh(), this.cH.dl());
      }

   }

   protected void H() {
      if (!this.cI) {
         super.H();
      }

   }

   public void d(bbn $$0) {
      if (this.d.b() == cgu.d) {
         this.c($$0);
      } else {
         super.d($$0);
      }

   }

   public long I() {
      return this.cG;
   }

   @Nullable
   public rq J() {
      return null;
   }

   public void a(bai $$0) {
      super.a((bai)$$0);
      this.fV();
   }

   public boolean K() {
      return this.cI;
   }

   public void L() {
      this.cI = false;
   }

   public abj M() {
      return this.cr;
   }

   public void a(agg $$0, double $$1, double $$2, double $$3, float $$4, float $$5) {
      this.c((bbn)this);
      this.p();
      if ($$0 == this.s) {
         this.b.b($$1, $$2, $$3, $$4, $$5);
      } else {
         agg $$6 = this.x();
         drn $$7 = $$0.n_();
         this.b.a((tc)(new vq($$0.Z(), $$0.ab(), chv.a($$0.B()), this.d.b(), this.d.c(), $$0.ae(), $$0.A(), true, this.ga())));
         this.b.a((tc)(new tr($$7.s(), $$7.t())));
         this.c.ac().d(this);
         $$6.a(this, bbn.c.e);
         this.dv();
         this.b($$1, $$2, $$3, $$4, $$5);
         this.c($$0);
         $$0.a(this);
         this.e($$6);
         this.b.b($$1, $$2, $$3, $$4, $$5);
         this.c.ac().a(this, $$0);
         this.c.ac().e(this);
      }

   }

   @Nullable
   public gt N() {
      return this.cT;
   }

   public float O() {
      return this.cV;
   }

   public aba<cgx> P() {
      return this.cS;
   }

   public boolean Q() {
      return this.cU;
   }

   public void a(aba<cgx> $$0, @Nullable gt $$1, float $$2, boolean $$3, boolean $$4) {
      if ($$1 != null) {
         boolean $$5 = $$1.equals(this.cT) && $$0.equals(this.cS);
         if ($$4 && !$$5) {
            this.a((rq)rq.c("block.minecraft.set_spawn"));
         }

         this.cT = $$1;
         this.cS = $$0;
         this.cV = $$2;
         this.cU = $$3;
      } else {
         this.cT = null;
         this.cS = cgx.e;
         this.cV = 0.0F;
         this.cU = false;
      }

   }

   public void a(cge $$0, tc<?> $$1) {
      this.b.a($$1);
   }

   public void a(cge $$0) {
      if (this.bo()) {
         this.b.a((tc)(new ui($$0.e, $$0.f)));
      }

   }

   public hq R() {
      return this.cR;
   }

   public void a(hq $$0) {
      this.cR = $$0;
   }

   public void a(ajv $$0, ajx $$1, float $$2, float $$3) {
      this.b.a((tc)(new wy($$0, $$1, this.df(), this.dh(), this.dl(), $$2, $$3, this.R.g())));
   }

   public tc<?> S() {
      return new ti(this);
   }

   public bqv a(cax $$0, boolean $$1, boolean $$2) {
      bqv $$3 = super.a($$0, $$1, $$2);
      if ($$3 == null) {
         return null;
      } else {
         this.s.b($$3);
         cax $$4 = $$3.i();
         if ($$2) {
            if (!$$4.b()) {
               this.a(akg.f.b($$4.c()), $$0.K());
            }

            this.a((abb)akg.F);
         }

         return $$3;
      }
   }

   public ahe T() {
      return this.cW;
   }

   public void c(agg $$0) {
      this.s = $$0;
      this.d.a($$0);
   }

   @Nullable
   private static cgu a(@Nullable pj $$0, String $$1) {
      return $$0 != null && $$0.b($$1, 99) ? cgu.a($$0.h($$1)) : null;
   }

   private cgu b(@Nullable cgu $$0) {
      cgu $$1 = this.c.aY();
      if ($$1 != null) {
         return $$1;
      } else {
         return $$0 != null ? $$0 : this.c.g_();
      }
   }

   public void c(@Nullable pj $$0) {
      this.d.a(this.b(a($$0, "playerGameType")), a($$0, "previousPlayerGameType"));
   }

   private void k(pj $$0) {
      $$0.a("playerGameType", this.d.b().a());
      cgu $$1 = this.d.c();
      if ($$1 != null) {
         $$0.a("previousPlayerGameType", $$1.a());
      }

   }

   public boolean U() {
      return this.cX;
   }

   public boolean b(agh $$0) {
      if ($$0 == this) {
         return false;
      } else {
         return this.cX || $$0.cX;
      }
   }

   public boolean a(cgx $$0, gt $$1) {
      return super.a((cgx)$$0, (gt)$$1) && $$0.a((buc)this, (gt)$$1);
   }

   protected void a(cax $$0) {
      aj.T.a(this, $$0);
      super.a((cax)$$0);
   }

   public boolean a(boolean $$0) {
      bub $$1 = this.fA();
      cax $$2 = $$1.a($$0);
      this.bU.b((bac)$$1, $$1.k).ifPresent(($$1x) -> {
         this.bU.a($$1x, $$1.f());
      });
      return this.a($$2, false, true) != null;
   }

   public boolean V() {
      return this.cY;
   }

   public void a(bqv $$0) {
      super.a((bqv)$$0);
      bbn $$1 = $$0.l() != null ? this.x().a($$0.l()) : null;
      if ($$1 != null) {
         aj.P.a(this, $$0.i(), $$1);
      }

   }

   // $FF: synthetic method
   public cgx W() {
      return this.x();
   }
}
