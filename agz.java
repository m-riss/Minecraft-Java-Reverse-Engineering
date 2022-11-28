import com.google.common.collect.Lists;
import com.google.common.primitives.Floats;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.time.Instant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

public class agz implements ahc, re, xm {
   static final Logger d = LogUtils.getLogger();
   private static final int e = 15000;
   public static final double a = ami.m(6.0D);
   private static final int f = -1;
   private static final int g = 4096;
   public final qv b;
   private final MinecraftServer h;
   public agh c;
   private int i;
   private int j = -1;
   private long k;
   private boolean l;
   private long m;
   private int n;
   private int o;
   private double p;
   private double q;
   private double r;
   private double s;
   private double t;
   private double u;
   @Nullable
   private bbn v;
   private double w;
   private double x;
   private double y;
   private double z;
   private double A;
   private double B;
   @Nullable
   private dwq C;
   private int D;
   private int E;
   private boolean F;
   private int G;
   private boolean H;
   private int I;
   private int J;
   private int K;
   private final rj L = new rj();
   private final rk M = new rk();
   private final AtomicReference<Instant> N;
   private final sg.a O;
   private final ry P;
   private final alx Q;

   public agz(MinecraftServer $$0, qv $$1, agh $$2) {
      this.N = new AtomicReference(Instant.EPOCH);
      this.P = new ry();
      this.h = $$0;
      this.b = $$1;
      $$1.a((ra)this);
      this.c = $$2;
      $$2.b = this;
      this.k = ad.b();
      $$2.T().a();
      buf $$3 = $$2.fz();
      if ($$3 != null) {
         this.O = (new sg()).a();
      } else {
         this.O = sg.a.a;
      }

      this.Q = new alx($$0);
   }

   public void c() {
      if (this.j > -1) {
         this.a((tc)(new tl(this.j)));
         this.j = -1;
      }

      this.d();
      this.c.t = this.c.df();
      this.c.u = this.c.dh();
      this.c.v = this.c.dl();
      this.c.l();
      this.c.a(this.p, this.q, this.r, this.c.dq(), this.c.ds());
      ++this.i;
      this.K = this.J;
      if (this.F && !this.c.fj() && !this.c.bI()) {
         if (++this.G > 80) {
            d.warn("{} was kicked for floating too long!", this.c.X().getString());
            this.b((rq)rq.c("multiplayer.disconnect.flying"));
            return;
         }
      } else {
         this.F = false;
         this.G = 0;
      }

      this.v = this.c.cO();
      if (this.v != this.c && this.v.cG() == this.c) {
         this.w = this.v.df();
         this.x = this.v.dh();
         this.y = this.v.dl();
         this.z = this.v.df();
         this.A = this.v.dh();
         this.B = this.v.dl();
         if (this.H && this.c.cO().cG() == this.c) {
            if (++this.I > 80) {
               d.warn("{} was kicked for floating a vehicle too long!", this.c.X().getString());
               this.b((rq)rq.c("multiplayer.disconnect.flying"));
               return;
            }
         } else {
            this.H = false;
            this.I = 0;
         }
      } else {
         this.v = null;
         this.H = false;
         this.I = 0;
      }

      this.h.aP().a("keepAlive");
      long $$0 = ad.b();
      if ($$0 - this.k >= 15000L) {
         if (this.l) {
            this.b((rq)rq.c("disconnect.timeout"));
         } else {
            this.l = true;
            this.k = $$0;
            this.m = $$0;
            this.a((tc)(new um(this.m)));
         }
      }

      this.h.aP().c();
      if (this.n > 0) {
         --this.n;
      }

      if (this.o > 0) {
         --this.o;
      }

      if (this.c.I() > 0L && this.h.al() > 0 && ad.b() - this.c.I() > (long)(this.h.al() * 1000 * 60)) {
         this.b((rq)rq.c("multiplayer.disconnect.idling"));
      }

      this.M.a();
   }

   public void d() {
      this.p = this.c.df();
      this.q = this.c.dh();
      this.r = this.c.dl();
      this.s = this.c.df();
      this.t = this.c.dh();
      this.u = this.c.dl();
   }

   public qv a() {
      return this.b;
   }

   private boolean g() {
      return this.h.a(this.c.fy());
   }

   public void b(rq $$0) {
      this.b.a((tc)(new uf($$0)), (rb)rb.a(() -> {
         this.b.a($$0);
      }));
      this.b.l();
      MinecraftServer var10000 = this.h;
      qv var10001 = this.b;
      Objects.requireNonNull(var10001);
      var10000.h(var10001::m);
   }

   private <T, R> CompletableFuture<R> a(T $$0, BiFunction<ahe, T, CompletableFuture<R>> $$1) {
      return ((CompletableFuture)$$1.apply(this.c.T(), $$0)).thenApply(($$0x) -> {
         if (!this.a().h()) {
            d.debug("Ignoring packet due to disconnection");
            throw new CancellationException("disconnected");
         } else {
            return $$0x;
         }
      });
   }

   private CompletableFuture<agv> a(String $$0) {
      return this.a((Object)$$0, (BiFunction)(ahe::a));
   }

   private CompletableFuture<List<agv>> a(List<String> $$0) {
      return this.a((Object)$$0, (BiFunction)(ahe::a));
   }

   public void a(yq $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.a($$0.b(), $$0.c(), $$0.d(), $$0.e());
   }

   private static boolean c(double $$0, double $$1, double $$2, float $$3, float $$4) {
      return Double.isNaN($$0) || Double.isNaN($$1) || Double.isNaN($$2) || !Floats.isFinite($$4) || !Floats.isFinite($$3);
   }

   private static double a(double $$0) {
      return ami.a($$0, -3.0E7D, 3.0E7D);
   }

   private static double b(double $$0) {
      return ami.a($$0, -2.0E7D, 2.0E7D);
   }

   public void a(yj $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (c($$0.b(), $$0.c(), $$0.d(), $$0.e(), $$0.f())) {
         this.b((rq)rq.c("multiplayer.disconnect.invalid_vehicle_movement"));
      } else {
         bbn $$1 = this.c.cO();
         if ($$1 != this.c && $$1.cG() == this.c && $$1 == this.v) {
            agg $$2 = this.c.x();
            double $$3 = $$1.df();
            double $$4 = $$1.dh();
            double $$5 = $$1.dl();
            double $$6 = a($$0.b());
            double $$7 = b($$0.c());
            double $$8 = a($$0.d());
            float $$9 = ami.g($$0.e());
            float $$10 = ami.g($$0.f());
            double $$11 = $$6 - this.w;
            double $$12 = $$7 - this.x;
            double $$13 = $$8 - this.y;
            double $$14 = $$1.dd().g();
            double $$15 = $$11 * $$11 + $$12 * $$12 + $$13 * $$13;
            if ($$15 - $$14 > 100.0D && !this.g()) {
               d.warn("{} (vehicle of {}) moved too quickly! {},{},{}", new Object[]{$$1.X().getString(), this.c.X().getString(), $$11, $$12, $$13});
               this.b.a((tc)(new ux($$1)));
               return;
            }

            boolean $$16 = $$2.a((bbn)$$1, (dwl)$$1.cy().h(0.0625D));
            $$11 = $$6 - this.z;
            $$12 = $$7 - this.A - 1.0E-6D;
            $$13 = $$8 - this.B;
            boolean $$17 = $$1.B;
            $$1.a(bci.b, new dwq($$11, $$12, $$13));
            double $$18 = $$12;
            $$11 = $$6 - $$1.df();
            $$12 = $$7 - $$1.dh();
            if ($$12 > -0.5D || $$12 < 0.5D) {
               $$12 = 0.0D;
            }

            $$13 = $$8 - $$1.dl();
            $$15 = $$11 * $$11 + $$12 * $$12 + $$13 * $$13;
            boolean $$19 = false;
            if ($$15 > 0.0625D) {
               $$19 = true;
               d.warn("{} (vehicle of {}) moved wrongly! {}", new Object[]{$$1.X().getString(), this.c.X().getString(), Math.sqrt($$15)});
            }

            $$1.a($$6, $$7, $$8, $$9, $$10);
            boolean $$20 = $$2.a((bbn)$$1, (dwl)$$1.cy().h(0.0625D));
            if ($$16 && ($$19 || !$$20)) {
               $$1.a($$3, $$4, $$5, $$9, $$10);
               this.b.a((tc)(new ux($$1)));
               return;
            }

            this.c.x().k().a(this.c);
            this.c.q(this.c.df() - $$3, this.c.dh() - $$4, this.c.dl() - $$5);
            this.H = $$18 >= -0.03125D && !$$17 && !this.h.Y() && !$$1.aN() && this.a($$1);
            this.z = $$1.df();
            this.A = $$1.dh();
            this.B = $$1.dl();
         }

      }
   }

   private boolean a(bbn $$0) {
      return $$0.s.a((dwl)$$0.cy().g(0.0625D).b(0.0D, -0.55D, 0.0D)).allMatch(cvn.a::h);
   }

   public void a(xo $$0) {
      te.a($$0, this, (agg)this.c.x());
      if ($$0.b() == this.D) {
         if (this.C == null) {
            this.b((rq)rq.c("multiplayer.disconnect.invalid_player_movement"));
            return;
         }

         this.c.a(this.C.c, this.C.d, this.C.e, this.c.dq(), this.c.ds());
         this.s = this.C.c;
         this.t = this.C.d;
         this.u = this.C.e;
         if (this.c.K()) {
            this.c.L();
         }

         this.C = null;
      }

   }

   public void a(yt $$0) {
      te.a($$0, this, (agg)this.c.x());
      Optional var10000 = this.h.aE().a($$0.b());
      akb var10001 = this.c.E();
      Objects.requireNonNull(var10001);
      var10000.ifPresent(var10001::e);
   }

   public void a(ys $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.E().a($$0.b(), $$0.c(), $$0.d());
   }

   public void a(yw $$0) {
      te.a($$0, this, (agg)this.c.x());
      if ($$0.c() == yw.a.a) {
         abb $$1 = $$0.d();
         af $$2 = this.h.az().a($$1);
         if ($$2 != null) {
            this.c.M().a($$2);
         }
      }

   }

   public void a(xx $$0) {
      te.a($$0, this, (agg)this.c.x());
      StringReader $$1 = new StringReader($$0.c());
      if ($$1.canRead() && $$1.peek() == '/') {
         $$1.skip();
      }

      ParseResults<dr> $$2 = this.h.aC().a().parse($$1, this.c.cT());
      this.h.aC().a().getCompletionSuggestions($$2).thenAccept(($$1x) -> {
         this.b.a((tc)(new tu($$0.b(), $$1x)));
      });
   }

   public void a(za $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (!this.h.n()) {
         this.c.a((rq)rq.c("advMode.notEnabled"));
      } else if (!this.c.fY()) {
         this.c.a((rq)rq.c("advMode.notAllowed"));
      } else {
         cfy $$1 = null;
         ctp $$2 = null;
         gt $$3 = $$0.b();
         cti $$4 = this.c.s.c_($$3);
         if ($$4 instanceof ctp) {
            $$2 = (ctp)$$4;
            $$1 = $$2.c();
         }

         String $$5 = $$0.c();
         boolean $$6 = $$0.d();
         if ($$1 != null) {
            ctp.a $$7 = $$2.t();
            cvo $$8 = this.c.s.a_($$3);
            gy $$9 = (gy)$$8.c(ckv.a);
            cvo $$12;
            switch($$0.g()) {
            case a:
               $$12 = cju.jt.m();
               break;
            case b:
               $$12 = cju.js.m();
               break;
            case c:
            default:
               $$12 = cju.eU.m();
            }

            cvo $$13 = (cvo)((cvo)$$12.a(ckv.a, $$9)).a(ckv.b, $$0.e());
            if ($$13 != $$8) {
               this.c.s.a($$3, $$13, 2);
               $$4.b($$13);
               this.c.s.l($$3).a($$4);
            }

            $$1.a($$5);
            $$1.a($$6);
            if (!$$6) {
               $$1.c((rq)null);
            }

            $$2.b($$0.f());
            if ($$7 != $$0.g()) {
               $$2.g();
            }

            $$1.f();
            if (!amx.b($$5)) {
               this.c.a((rq)rq.a("advMode.setCommand.success", $$5));
            }
         }

      }
   }

   public void a(zb $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (!this.h.n()) {
         this.c.a((rq)rq.c("advMode.notEnabled"));
      } else if (!this.c.fY()) {
         this.c.a((rq)rq.c("advMode.notAllowed"));
      } else {
         cfy $$1 = $$0.a(this.c.s);
         if ($$1 != null) {
            $$1.a($$0.b());
            $$1.a($$0.c());
            if (!$$0.c()) {
               $$1.c((rq)null);
            }

            $$1.f();
            this.c.a((rq)rq.a("advMode.setCommand.success", $$0.b()));
         }

      }
   }

   public void a(yl $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.fA().c($$0.b());
      this.c.b.a((tc)(new tz(-2, 0, this.c.fA().k, this.c.fA().a(this.c.fA().k))));
      this.c.b.a((tc)(new tz(-2, 0, $$0.b(), this.c.fA().a($$0.b()))));
      this.c.b.a((tc)(new wc(this.c.fA().k)));
   }

   public void a(yu $$0) {
      te.a($$0, this, (agg)this.c.x());
      bwm var3 = this.c.bU;
      if (var3 instanceof bwo) {
         bwo $$1 = (bwo)var3;
         if (!$$1.a((buc)this.c)) {
            d.debug("Player {} interacted with invalid menu {}", this.c, $$1);
            return;
         }

         String $$2 = ab.a($$0.b());
         if ($$2.length() <= 50) {
            $$1.a($$2);
         }
      }

   }

   public void a(yy $$0) {
      te.a($$0, this, (agg)this.c.x());
      bwm var3 = this.c.bU;
      if (var3 instanceof bwp) {
         bwp $$1 = (bwp)var3;
         if (!this.c.bU.a((buc)this.c)) {
            d.debug("Player {} interacted with invalid menu {}", this.c, this.c.bU);
            return;
         }

         $$1.a($$0.b(), $$0.c());
      }

   }

   public void a(ze $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.fY()) {
         gt $$1 = $$0.b();
         cvo $$2 = this.c.s.a_($$1);
         cti $$3 = this.c.s.c_($$1);
         if ($$3 instanceof cuo) {
            cuo $$4 = (cuo)$$3;
            $$4.a($$0.d());
            $$4.a($$0.e());
            $$4.a($$0.f());
            $$4.a($$0.g());
            $$4.a($$0.h());
            $$4.a($$0.i());
            $$4.b($$0.j());
            $$4.a($$0.k());
            $$4.d($$0.l());
            $$4.e($$0.m());
            $$4.a($$0.n());
            $$4.a($$0.o());
            if ($$4.g()) {
               String $$5 = $$4.d();
               if ($$0.c() == cuo.a.b) {
                  if ($$4.D()) {
                     this.c.a((rq)rq.a("structure_block.save_success", $$5), false);
                  } else {
                     this.c.a((rq)rq.a("structure_block.save_failure", $$5), false);
                  }
               } else if ($$0.c() == cuo.a.c) {
                  if (!$$4.F()) {
                     this.c.a((rq)rq.a("structure_block.load_not_found", $$5), false);
                  } else if ($$4.a(this.c.x())) {
                     this.c.a((rq)rq.a("structure_block.load_success", $$5), false);
                  } else {
                     this.c.a((rq)rq.a("structure_block.load_prepare", $$5), false);
                  }
               } else if ($$0.c() == cuo.a.d) {
                  if ($$4.C()) {
                     this.c.a((rq)rq.a("structure_block.size_success", $$5), false);
                  } else {
                     this.c.a((rq)rq.c("structure_block.size_failure"), false);
                  }
               }
            } else {
               this.c.a((rq)rq.a("structure_block.invalid_structure_name", $$0.e()), false);
            }

            $$4.e();
            this.c.s.a($$1, $$2, $$2, 3);
         }

      }
   }

   public void a(zd $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.fY()) {
         gt $$1 = $$0.b();
         cvo $$2 = this.c.s.a_($$1);
         cti $$3 = this.c.s.c_($$1);
         if ($$3 instanceof cub) {
            cub $$4 = (cub)$$3;
            $$4.a($$0.c());
            $$4.b($$0.d());
            $$4.a(aba.a(hm.aQ, $$0.e()));
            $$4.a($$0.f());
            $$4.a($$0.g());
            $$4.e();
            this.c.s.a($$1, $$2, $$2, 3);
         }

      }
   }

   public void a(yf $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.fY()) {
         gt $$1 = $$0.b();
         cti $$2 = this.c.s.c_($$1);
         if ($$2 instanceof cub) {
            cub $$3 = (cub)$$2;
            $$3.a(this.c.x(), $$0.c(), $$0.d());
         }

      }
   }

   public void a(yx $$0) {
      te.a($$0, this, (agg)this.c.x());
      int $$1 = $$0.b();
      bwm var4 = this.c.bU;
      if (var4 instanceof bxs) {
         bxs $$2 = (bxs)var4;
         if (!$$2.a((buc)this.c)) {
            d.debug("Player {} interacted with invalid menu {}", this.c, $$2);
            return;
         }

         $$2.e($$1);
         $$2.h($$1);
      }

   }

   public void a(yc $$0) {
      int $$1 = $$0.d();
      if (bub.d($$1) || $$1 == 40) {
         List<String> $$2 = Lists.newArrayList();
         Optional<String> $$3 = $$0.c();
         Objects.requireNonNull($$2);
         $$3.ifPresent($$2::add);
         Stream var10000 = $$0.b().stream().limit(100L);
         Objects.requireNonNull($$2);
         var10000.forEach($$2::add);
         Consumer<List<agv>> $$4 = $$3.isPresent() ? ($$1x) -> {
            this.a((agv)$$1x.get(0), $$1x.subList(1, $$1x.size()), $$1);
         } : ($$1x) -> {
            this.a($$1x, $$1);
         };
         this.a((List)$$2).thenAcceptAsync($$4, this.h);
      }
   }

   private void a(List<agv> $$0, int $$1) {
      cax $$2 = this.c.fA().a($$1);
      if ($$2.a(caz.rX)) {
         this.a($$0, UnaryOperator.identity(), $$2);
      }
   }

   private void a(agv $$0, List<agv> $$1, int $$2) {
      cax $$3 = this.c.fA().a($$2);
      if ($$3.a(caz.rX)) {
         cax $$4 = new cax(caz.rY);
         pj $$5 = $$3.u();
         if ($$5 != null) {
            $$4.c($$5.g());
         }

         $$4.a((String)"author", (qc)qa.a(this.c.X().getString()));
         if (this.c.U()) {
            $$4.a((String)"title", (qc)qa.a($$0.b()));
         } else {
            $$4.a((String)"filtered_title", (qc)qa.a($$0.b()));
            $$4.a((String)"title", (qc)qa.a($$0.d()));
         }

         this.a($$1, ($$0x) -> {
            return rq.a.a((rq)rq.b($$0x));
         }, $$4);
         this.c.fA().a($$2, $$4);
      }
   }

   private void a(List<agv> $$0, UnaryOperator<String> $$1, cax $$2) {
      pp $$3 = new pp();
      if (this.c.U()) {
         Stream var10000 = $$0.stream().map(($$1x) -> {
            return qa.a((String)$$1.apply($$1x.b()));
         });
         Objects.requireNonNull($$3);
         var10000.forEach($$3::add);
      } else {
         pj $$4 = new pj();
         int $$5 = 0;

         for(int $$6 = $$0.size(); $$5 < $$6; ++$$5) {
            agv $$7 = (agv)$$0.get($$5);
            String $$8 = $$7.d();
            $$3.add(qa.a((String)$$1.apply($$8)));
            if ($$7.c()) {
               $$4.a(String.valueOf($$5), (String)$$1.apply($$7.b()));
            }
         }

         if (!$$4.f()) {
            $$2.a((String)"filtered_pages", (qc)$$4);
         }
      }

      $$2.a((String)"pages", (qc)$$3);
   }

   public void a(yd $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.l(2)) {
         bbn $$1 = this.c.x().a($$0.c());
         if ($$1 != null) {
            pj $$2 = $$1.f(new pj());
            this.c.b.a((tc)(new xc($$0.b(), $$2)));
         }

      }
   }

   public void a(xp $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.l(2)) {
         cti $$1 = this.c.x().c_($$0.c());
         pj $$2 = $$1 != null ? $$1.o() : null;
         this.c.b.a((tc)(new xc($$0.b(), $$2)));
      }
   }

   public void a(yi $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (c($$0.a(0.0D), $$0.b(0.0D), $$0.c(0.0D), $$0.a(0.0F), $$0.b(0.0F))) {
         this.b((rq)rq.c("multiplayer.disconnect.invalid_player_movement"));
      } else {
         agg $$1 = this.c.x();
         if (!this.c.f) {
            if (this.i == 0) {
               this.d();
            }

            if (this.C != null) {
               if (this.i - this.E > 20) {
                  this.E = this.i;
                  this.b(this.C.c, this.C.d, this.C.e, this.c.dq(), this.c.ds());
               }

            } else {
               this.E = this.i;
               double $$2 = a($$0.a(this.c.df()));
               double $$3 = b($$0.b(this.c.dh()));
               double $$4 = a($$0.c(this.c.dl()));
               float $$5 = ami.g($$0.a(this.c.dq()));
               float $$6 = ami.g($$0.b(this.c.ds()));
               if (this.c.bI()) {
                  this.c.a(this.c.df(), this.c.dh(), this.c.dl(), $$5, $$6);
                  this.c.x().k().a(this.c);
               } else {
                  double $$7 = this.c.df();
                  double $$8 = this.c.dh();
                  double $$9 = this.c.dl();
                  double $$10 = this.c.dh();
                  double $$11 = $$2 - this.p;
                  double $$12 = $$3 - this.q;
                  double $$13 = $$4 - this.r;
                  double $$14 = this.c.dd().g();
                  double $$15 = $$11 * $$11 + $$12 * $$12 + $$13 * $$13;
                  if (this.c.fj()) {
                     if ($$15 > 1.0D) {
                        this.b(this.c.df(), this.c.dh(), this.c.dl(), $$5, $$6);
                     }

                  } else {
                     ++this.J;
                     int $$16 = this.J - this.K;
                     if ($$16 > 5) {
                        d.debug("{} is sending move packets too frequently ({} packets since last tick)", this.c.X().getString(), $$16);
                        $$16 = 1;
                     }

                     if (!this.c.K() && (!this.c.x().W().b(cgt.s) || !this.c.fc())) {
                        float $$17 = this.c.fc() ? 300.0F : 100.0F;
                        if ($$15 - $$14 > (double)($$17 * (float)$$16) && !this.g()) {
                           d.warn("{} moved too quickly! {},{},{}", new Object[]{this.c.X().getString(), $$11, $$12, $$13});
                           this.b(this.c.df(), this.c.dh(), this.c.dl(), this.c.dq(), this.c.ds());
                           return;
                        }
                     }

                     dwl $$18 = this.c.cy();
                     $$11 = $$2 - this.s;
                     $$12 = $$3 - this.t;
                     $$13 = $$4 - this.u;
                     boolean $$19 = $$12 > 0.0D;
                     if (this.c.aw() && !$$0.b() && $$19) {
                        this.c.eH();
                     }

                     boolean $$20 = this.c.B;
                     this.c.a((bci)bci.b, (dwq)(new dwq($$11, $$12, $$13)));
                     double $$21 = $$12;
                     $$11 = $$2 - this.c.df();
                     $$12 = $$3 - this.c.dh();
                     if ($$12 > -0.5D || $$12 < 0.5D) {
                        $$12 = 0.0D;
                     }

                     $$13 = $$4 - this.c.dl();
                     $$15 = $$11 * $$11 + $$12 * $$12 + $$13 * $$13;
                     boolean $$22 = false;
                     if (!this.c.K() && $$15 > 0.0625D && !this.c.fj() && !this.c.d.e() && this.c.d.b() != cgu.d) {
                        $$22 = true;
                        d.warn("{} moved wrongly!", this.c.X().getString());
                     }

                     this.c.a($$2, $$3, $$4, $$5, $$6);
                     if (this.c.Q || this.c.fj() || (!$$22 || !$$1.a((bbn)this.c, (dwl)$$18)) && !this.a((cha)$$1, (dwl)$$18)) {
                        this.F = $$21 >= -0.03125D && !$$20 && this.c.d.b() != cgu.d && !this.h.Y() && !this.c.fB().c && !this.c.a((bbe)bbi.y) && !this.c.fc() && !this.c.eO() && this.a((bbn)this.c);
                        this.c.x().k().a(this.c);
                        this.c.a(this.c.dh() - $$10, $$0.b());
                        this.c.c($$0.b());
                        if ($$19) {
                           this.c.m();
                        }

                        this.c.q(this.c.df() - $$7, this.c.dh() - $$8, this.c.dl() - $$9);
                        this.s = this.c.df();
                        this.t = this.c.dh();
                        this.u = this.c.dl();
                     } else {
                        this.b($$7, $$8, $$9, $$5, $$6);
                     }
                  }
               }
            }
         }
      }
   }

   private boolean a(cha $$0, dwl $$1) {
      Iterable<dxj> $$2 = $$0.c(this.c, this.c.cy().h(9.999999747378752E-6D));
      dxj $$3 = dxg.a($$1.h(9.999999747378752E-6D));
      Iterator var5 = $$2.iterator();

      dxj $$4;
      do {
         if (!var5.hasNext()) {
            return false;
         }

         $$4 = (dxj)var5.next();
      } while(dxg.c($$4, $$3, dwu.i));

      return true;
   }

   public void a(double $$0, double $$1, double $$2, float $$3, float $$4) {
      this.a($$0, $$1, $$2, $$3, $$4, Collections.emptySet(), true);
   }

   public void b(double $$0, double $$1, double $$2, float $$3, float $$4) {
      this.a($$0, $$1, $$2, $$3, $$4, Collections.emptySet(), false);
   }

   public void a(double $$0, double $$1, double $$2, float $$3, float $$4, Set<vl.a> $$5) {
      this.a($$0, $$1, $$2, $$3, $$4, $$5, false);
   }

   public void a(double $$0, double $$1, double $$2, float $$3, float $$4, Set<vl.a> $$5, boolean $$6) {
      double $$7 = $$5.contains(vl.a.a) ? this.c.df() : 0.0D;
      double $$8 = $$5.contains(vl.a.b) ? this.c.dh() : 0.0D;
      double $$9 = $$5.contains(vl.a.c) ? this.c.dl() : 0.0D;
      float $$10 = $$5.contains(vl.a.d) ? this.c.dq() : 0.0F;
      float $$11 = $$5.contains(vl.a.e) ? this.c.ds() : 0.0F;
      this.C = new dwq($$0, $$1, $$2);
      if (++this.D == Integer.MAX_VALUE) {
         this.D = 0;
      }

      this.E = this.i;
      this.c.a($$0, $$1, $$2, $$3, $$4);
      this.c.b.a((tc)(new vl($$0 - $$7, $$1 - $$8, $$2 - $$9, $$3 - $$10, $$4 - $$11, $$5, this.D, $$6)));
   }

   public void a(yo $$0) {
      te.a($$0, this, (agg)this.c.x());
      gt $$1 = $$0.b();
      this.c.C();
      yo.a $$2 = $$0.d();
      switch($$2) {
      case g:
         if (!this.c.B_()) {
            cax $$3 = this.c.b((bai)bai.b);
            this.c.a((bai)bai.b, (cax)this.c.b((bai)bai.a));
            this.c.a((bai)bai.a, (cax)$$3);
            this.c.eZ();
         }

         return;
      case e:
         if (!this.c.B_()) {
            this.c.a(false);
         }

         return;
      case d:
         if (!this.c.B_()) {
            this.c.a(true);
         }

         return;
      case f:
         this.c.eY();
         return;
      case a:
      case b:
      case c:
         this.c.d.a($$1, $$2, $$0.c(), this.c.s.ah(), $$0.e());
         this.c.b.a($$0.e());
         return;
      default:
         throw new IllegalArgumentException("Invalid player action");
      }
   }

   private static boolean a(agh $$0, cax $$1) {
      if ($$1.b()) {
         return false;
      } else {
         cat $$2 = $$1.c();
         return ($$2 instanceof byx || $$2 instanceof bze) && !$$0.fW().a($$2);
      }
   }

   public void a(zi $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.b.a($$0.d());
      agg $$1 = this.c.x();
      bai $$2 = $$0.b();
      cax $$3 = this.c.b((bai)$$2);
      dwm $$4 = $$0.c();
      dwq $$5 = $$4.e();
      gt $$6 = $$4.a();
      dwq $$7 = dwq.a((hs)$$6);
      if (!(this.c.bj().g($$7) > a)) {
         dwq $$8 = $$5.d($$7);
         double $$9 = 1.0000001D;
         if (Math.abs($$8.a()) < 1.0000001D && Math.abs($$8.b()) < 1.0000001D && Math.abs($$8.c()) < 1.0000001D) {
            gy $$10 = $$4.b();
            this.c.C();
            int $$11 = this.c.s.ah();
            if ($$6.v() < $$11) {
               if (this.C == null && this.c.h((double)$$6.u() + 0.5D, (double)$$6.v() + 0.5D, (double)$$6.w() + 0.5D) < 64.0D && $$1.a((buc)this.c, (gt)$$6)) {
                  baj $$12 = this.c.d.a(this.c, $$1, $$3, $$2, $$4);
                  if ($$10 == gy.b && !$$12.a() && $$6.v() >= $$11 - 1 && a(this.c, $$3)) {
                     rq $$13 = rq.a("build.tooHigh", $$11 - 1).a(p.m);
                     this.c.b($$13, true);
                  } else if ($$12.b()) {
                     this.c.a((bai)$$2, true);
                  }
               }
            } else {
               rq $$14 = rq.a("build.tooHigh", $$11 - 1).a(p.m);
               this.c.b($$14, true);
            }

            this.c.b.a((tc)(new tp($$1, $$6)));
            this.c.b.a((tc)(new tp($$1, $$6.a($$10))));
         } else {
            d.warn("Rejecting UseItemOnPacket from {}: Location {} too far away from hit block {}.", new Object[]{this.c.fy().getName(), $$5, $$6});
         }
      }
   }

   public void a(zj $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.a($$0.c());
      agg $$1 = this.c.x();
      bai $$2 = $$0.b();
      cax $$3 = this.c.b((bai)$$2);
      this.c.C();
      if (!$$3.b()) {
         baj $$4 = this.c.d.a(this.c, $$1, $$3, $$2);
         if ($$4.b()) {
            this.c.a((bai)$$2, true);
         }

      }
   }

   public void a(zh $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.B_()) {
         Iterator var2 = this.h.E().iterator();

         while(var2.hasNext()) {
            agg $$1 = (agg)var2.next();
            bbn $$2 = $$0.a($$1);
            if ($$2 != null) {
               this.c.a($$1, $$2.df(), $$2.dh(), $$2.dl(), $$2.dq(), $$2.ds());
               return;
            }
         }
      }

   }

   public void a(yv $$0) {
      te.a($$0, this, (agg)this.c.x());
      if ($$0.b() == yv.a.b && this.h.S()) {
         d.info("Disconnecting {} due to resource pack rejection", this.c.X());
         this.b((rq)rq.c("multiplayer.requiredTexturePrompt.disconnect"));
      }

   }

   public void a(yk $$0) {
      te.a($$0, this, (agg)this.c.x());
      bbn $$1 = this.c.cQ();
      if ($$1 instanceof bvv) {
         ((bvv)$$1).a($$0.b(), $$0.c());
      }

   }

   public void a(yr $$0) {
   }

   public void a(rq $$0) {
      d.info("{} lost connection: {}", this.c.X().getString(), $$0.getString());
      this.h.ar();
      this.h.ac().a((rq)rq.a("multiplayer.player.left", this.c.C_()).a(p.o), false);
      this.c.s();
      this.h.ac().c(this.c);
      this.c.T().b();
      if (this.g()) {
         d.info("Stopping singleplayer server as player logged out");
         this.h.a(false);
      }

   }

   public void a(int $$0) {
      if ($$0 < 0) {
         throw new IllegalArgumentException("Expected packet sequence nr >= 0");
      } else {
         this.j = Math.max($$0, this.j);
      }
   }

   public void a(tc<?> $$0) {
      this.a((tc)$$0, (rb)null);
   }

   public void a(tc<?> $$0, @Nullable rb $$1) {
      try {
         this.b.a($$0, $$1);
      } catch (Throwable var6) {
         q $$3 = q.a(var6, "Sending packet");
         r $$4 = $$3.a("Packet being sent");
         $$4.a("Packet class", () -> {
            return $$0.getClass().getCanonicalName();
         });
         throw new z($$3);
      }
   }

   public void a(yz $$0) {
      te.a($$0, this, (agg)this.c.x());
      if ($$0.b() >= 0 && $$0.b() < bub.g()) {
         if (this.c.fA().k != $$0.b() && this.c.eU() == bai.a) {
            this.c.eZ();
         }

         this.c.fA().k = $$0.b();
         this.c.C();
      } else {
         d.warn("{} tried to set an invalid carried item", this.c.X().getString());
      }
   }

   public void a(xt $$0) {
      if (c($$0.b())) {
         this.b((rq)rq.c("multiplayer.disconnect.illegal_characters"));
      } else {
         if (this.a($$0.b(), $$0.c(), $$0.g())) {
            this.h.g(() -> {
               sd $$1 = this.b($$0);
               if (this.c($$1)) {
                  this.Q.append(() -> {
                     CompletableFuture<agv> $$1x = this.a($$1.b().b());
                     CompletableFuture<sd> $$2 = this.h.bf().decorate(this.c, $$1);
                     return CompletableFuture.allOf($$1x, $$2).thenAcceptAsync(($$2x) -> {
                        rt $$3 = ((agv)$$1x.join()).e();
                        sd $$4 = ((sd)$$2.join()).a($$3);
                        this.b($$4);
                     }, this.h);
                  });
               }
            });
         }

      }
   }

   public void a(xs $$0) {
      if (c($$0.b())) {
         this.b((rq)rq.c("multiplayer.disconnect.illegal_characters"));
      } else {
         if (this.a($$0.b(), $$0.c(), $$0.g())) {
            this.h.g(() -> {
               this.b($$0);
               this.h();
            });
         }

      }
   }

   private void b(xs $$0) {
      ParseResults<dr> $$1 = this.b($$0.b());
      Map<String, sd> $$2 = this.a($$0, se.a($$1));
      Iterator var4 = $$2.values().iterator();

      sd $$3;
      do {
         if (!var4.hasNext()) {
            dp $$4 = new dp.a($$2);
            $$1 = ds.a($$1, ($$1x) -> {
               return $$1x.a($$4);
            });
            this.h.aC().a($$1, $$0.b());
            return;
         }

         $$3 = (sd)var4.next();
      } while(this.c($$3));

   }

   private Map<String, sd> a(xs $$0, se<?> $$1) {
      rq $$2 = this.L.a($$0.b());
      sa $$3 = new sa(this.c.co(), $$0.c(), $$0.d());
      rw $$4 = $$0.g().a();
      Map<String, sd> $$5 = new Object2ObjectOpenHashMap();
      sg.a $$6 = this.c.b.e();
      Iterator var8 = dv.b($$1).iterator();

      while(var8.hasNext()) {
         Pair<String, String> $$7 = (Pair)var8.next();
         String $$8 = (String)$$7.getFirst();
         String $$9 = (String)$$7.getSecond();
         rz $$10 = $$0.e().a($$8);
         ri $$12;
         if ($$0.f() && $$2 != null) {
            $$12 = new ri($$9, $$2);
         } else {
            $$12 = new ri($$9);
         }

         sg.c $$13 = new sg.c($$10);
         $$5.put($$8, $$6.unpack($$13, $$3, $$12, $$4));
      }

      return $$5;
   }

   private ParseResults<dr> b(String $$0) {
      CommandDispatcher<dr> $$1 = this.h.aC().a();
      return $$1.parse($$0, this.c.cT());
   }

   private boolean a(String $$0, Instant $$1, rw.b $$2) {
      if (!this.a($$1)) {
         d.warn("{} sent out-of-order chat: '{}'", this.c.X().getString(), $$0);
         this.b((rq)rq.c("multiplayer.disconnect.out_of_order_chat"));
         return false;
      } else if (this.c.A() == bua.c) {
         this.a((tc)(new xa(rq.c("chat.disabled.options").a(p.m), false)));
         return false;
      } else {
         Set $$4;
         synchronized(this.P) {
            $$4 = this.P.a($$2);
         }

         if (!$$4.isEmpty()) {
            this.a($$4);
            return false;
         } else {
            this.c.C();
            return true;
         }
      }
   }

   private boolean a(Instant $$0) {
      Instant $$1;
      do {
         $$1 = (Instant)this.N.get();
         if ($$0.isBefore($$1)) {
            return false;
         }
      } while(!this.N.compareAndSet($$1, $$0));

      return true;
   }

   private static boolean c(String $$0) {
      for(int $$1 = 0; $$1 < $$0.length(); ++$$1) {
         if (!ab.a($$0.charAt($$1))) {
            return true;
         }
      }

      return false;
   }

   private sd b(xt $$0) {
      sa $$1 = $$0.a(this.c);
      sg.c $$2 = new sg.c($$0.e());
      rw $$3 = $$0.g().a();
      ri $$4 = this.c($$0);
      return this.O.unpack($$2, $$1, $$4, $$3);
   }

   private ri c(xt $$0) {
      rq $$1 = this.L.a($$0.b());
      return $$0.f() && $$1 != null ? new ri($$0.b(), $$1) : new ri($$0.b());
   }

   private void b(sd $$0) {
      this.h.ac().a($$0, this.c, rm.a(rm.c, (bbn)this.c));
      this.h();
   }

   private boolean c(sd $$0) {
      rl $$1 = this.c.aW();
      buf $$2 = $$1.c();
      if ($$2 != null) {
         if ($$2.b().a()) {
            this.c.a((rq)rq.c("chat.disabled.expiredProfileKey").a(p.m));
            return false;
         }

         if (!$$0.a($$1)) {
            this.b((rq)rq.c("multiplayer.disconnect.unsigned_chat"));
            return false;
         }
      }

      if ($$0.a(Instant.now())) {
         d.warn("{} sent expired chat: '{}'. Is the client/server system time unsynchronized?", this.c.X().getString(), $$0.b().b());
      }

      return true;
   }

   private void h() {
      this.n += 20;
      if (this.n > 200 && !this.h.ac().e(this.c.fy())) {
         this.b((rq)rq.c("disconnect.spam"));
      }

   }

   public void a(xu $$0) {
      if (this.i()) {
         this.M.a(() -> {
            int $$1 = $$0.b();
            String $$2 = $$0.c();
            return this.d($$2).thenAccept(($$1x) -> {
               this.a($$1, $$1x);
            });
         });
      }

   }

   private boolean i() {
      return this.h.aa() || this.b.d();
   }

   private void a(int $$0, rq $$1) {
      this.a((tc)(new ts($$0, $$1)), (rb)rb.a(() -> {
         return new ts($$0, (rq)null);
      }));
   }

   private CompletableFuture<rq> d(String $$0) {
      String $$1 = StringUtils.normalizeSpace($$0);
      return $$1.startsWith("/") ? this.f($$1.substring(1)) : this.e($$0);
   }

   private CompletableFuture<rq> e(String $$0) {
      rq $$1 = rq.b($$0);
      CompletableFuture<rq> $$2 = this.h.bf().decorate(this.c, (rq)$$1).thenApply(($$1x) -> {
         return !$$1.equals($$1x) ? $$1x : null;
      });
      $$2.thenAcceptAsync(($$1x) -> {
         this.L.a($$0, $$1x);
      }, this.h);
      return $$2;
   }

   private CompletableFuture<rq> f(String $$0) {
      dr $$1 = this.c.cT();
      ParseResults<dr> $$2 = this.h.aC().a().parse($$0, $$1);
      CompletableFuture<rq> $$3 = this.a($$1, se.a($$2));
      $$3.thenAcceptAsync(($$1x) -> {
         this.L.a($$0, $$1x);
      }, this.h);
      return $$3;
   }

   private CompletableFuture<rq> a(dr $$0, se<dr> $$1) {
      List<se.a<dr>> $$2 = $$1.a();
      if ($$2.isEmpty()) {
         return CompletableFuture.completedFuture((Object)null);
      } else {
         for(int $$3 = $$2.size() - 1; $$3 >= 0; --$$3) {
            se.a $$4 = (se.a)$$2.get($$3);

            try {
               CompletableFuture<rq> $$5 = $$4.d().a($$0, $$4.c());
               if ($$5 != null) {
                  return $$5;
               }
            } catch (CommandSyntaxException var7) {
               return CompletableFuture.completedFuture((Object)null);
            }
         }

         return CompletableFuture.completedFuture((Object)null);
      }
   }

   public void a(xr $$0) {
      Set $$2;
      synchronized(this.P) {
         $$2 = this.P.a($$0.b());
      }

      if (!$$2.isEmpty()) {
         this.a($$2);
      }

   }

   private void a(Set<ry.a> $$0) {
      d.warn("Failed to validate message from {}, reasons: {}", this.c.X().getString(), $$0.stream().map(ry.a::a).collect(Collectors.joining(",")));
      this.b((rq)rq.c("multiplayer.disconnect.chat_validation_failed"));
   }

   public void a(zg $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.C();
      this.c.a($$0.b());
   }

   public void a(yp $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.C();
      bcn $$1;
      switch($$0.c()) {
      case a:
         this.c.f(true);
         break;
      case b:
         this.c.f(false);
         break;
      case d:
         this.c.g(true);
         break;
      case e:
         this.c.g(false);
         break;
      case c:
         if (this.c.fj()) {
            this.c.a(false, true);
            this.C = this.c.cY();
         }
         break;
      case f:
         if (this.c.cQ() instanceof bcn) {
            $$1 = (bcn)this.c.cQ();
            int $$2 = $$0.d();
            if ($$1.a() && $$2 > 0) {
               $$1.b($$2);
            }
         }
         break;
      case g:
         if (this.c.cQ() instanceof bcn) {
            $$1 = (bcn)this.c.cQ();
            $$1.b();
         }
         break;
      case h:
         bbn var3 = this.c.cQ();
         if (var3 instanceof bbw) {
            bbw $$4 = (bbw)var3;
            $$4.b(this.c);
         }
         break;
      case i:
         if (!this.c.fF()) {
            this.c.fH();
         }
         break;
      default:
         throw new IllegalArgumentException("Invalid client command!");
      }

   }

   public sg.a e() {
      return this.O;
   }

   public void a(sd $$0) {
      rw.a $$1 = $$0.g();
      if ($$1 != null) {
         int $$3;
         synchronized(this.P) {
            this.P.a($$1);
            $$3 = this.P.a();
         }

         if ($$3 > 4096) {
            this.b((rq)rq.c("multiplayer.disconnect.too_many_pending_chats"));
         }

      }
   }

   public void a(ye $$0) {
      te.a($$0, this, (agg)this.c.x());
      agg $$1 = this.c.x();
      final bbn $$2 = $$0.a($$1);
      this.c.C();
      this.c.f($$0.b());
      if ($$2 != null) {
         if (!$$1.p_().a($$2.da())) {
            return;
         }

         if ($$2.e(this.c.bj()) < a) {
            $$0.a(new ye.c() {
               private void a(bai $$0, agz.a $$1) {
                  cax $$2x = agz.this.c.b((bai)$$0).o();
                  baj $$3 = $$1.run(agz.this.c, $$2, $$0);
                  if ($$3.a()) {
                     aj.Q.a(agz.this.c, $$2x, $$2);
                     if ($$3.b()) {
                        agz.this.c.a((bai)$$0, true);
                     }
                  }

               }

               public void a(bai $$0) {
                  this.a($$0, buc::a);
               }

               public void a(bai $$0, dwq $$1) {
                  this.a($$0, ($$1x, $$2x, $$3) -> {
                     return $$2x.a((buc)$$1x, (dwq)$$1, (bai)$$3);
                  });
               }

               public void a() {
                  if (!($$2 instanceof bqv) && !($$2 instanceof bbt) && !($$2 instanceof bui) && $$2 != agz.this.c) {
                     agz.this.c.d($$2);
                  } else {
                     agz.this.b((rq)rq.c("multiplayer.disconnect.invalid_entity_attacked"));
                     agz.d.warn("Player {} tried to attack an invalid entity", agz.this.c.X().getString());
                  }
               }
            });
         }
      }

   }

   public void a(xv $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.C();
      xv.a $$1 = $$0.b();
      switch($$1) {
      case a:
         if (this.c.f) {
            this.c.f = false;
            this.c = this.h.ac().a(this.c, true);
            aj.v.a(this.c, cgx.g, cgx.e);
         } else {
            if (this.c.ef() > 0.0F) {
               return;
            }

            this.c = this.h.ac().a(this.c, false);
            if (this.h.g()) {
               this.c.a(cgu.d);
               ((cgt.a)this.c.x().W().a(cgt.q)).a(false, this.h);
            }
         }
         break;
      case b:
         this.c.D().a(this.c);
      }

   }

   public void a(ya $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.r();
   }

   public void a(xz $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.C();
      if (this.c.bU.j == $$0.b()) {
         if (this.c.B_()) {
            this.c.bU.b();
         } else if (!this.c.bU.a((buc)this.c)) {
            d.debug("Player {} interacted with invalid menu {}", this.c, this.c.bU);
         } else {
            int $$1 = $$0.c();
            if (!this.c.bU.a($$1)) {
               d.debug("Player {} clicked invalid slot index: {}, available slots: {}", new Object[]{this.c.X(), $$1, this.c.bU.i.size()});
            } else {
               boolean $$2 = $$0.h() != this.c.bU.j();
               this.c.bU.h();
               this.c.bU.a($$1, $$0.d(), $$0.g(), this.c);
               ObjectIterator var4 = Int2ObjectMaps.fastIterable($$0.f()).iterator();

               while(var4.hasNext()) {
                  Entry<cax> $$3 = (Entry)var4.next();
                  this.c.bU.b($$3.getIntKey(), (cax)$$3.getValue());
               }

               this.c.bU.a($$0.e());
               this.c.bU.i();
               if ($$2) {
                  this.c.bU.e();
               } else {
                  this.c.bU.d();
               }

            }
         }
      }
   }

   public void a(ym $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.C();
      if (!this.c.B_() && this.c.bU.j == $$0.b() && this.c.bU instanceof bxv) {
         if (!this.c.bU.a((buc)this.c)) {
            d.debug("Player {} interacted with invalid menu {}", this.c, this.c.bU);
         } else {
            this.h.aE().a($$0.c()).ifPresent(($$1) -> {
               ((bxv)this.c.bU).a($$0.d(), $$1, this.c);
            });
         }
      }
   }

   public void a(xy $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.C();
      if (this.c.bU.j == $$0.b() && !this.c.B_()) {
         if (!this.c.bU.a((buc)this.c)) {
            d.debug("Player {} interacted with invalid menu {}", this.c, this.c.bU);
         } else {
            boolean $$1 = this.c.bU.b((buc)this.c, $$0.c());
            if ($$1) {
               this.c.bU.d();
            }

         }
      }
   }

   public void a(zc $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.d.e()) {
         boolean $$1 = $$0.b() < 0;
         cax $$2 = $$0.c();
         pj $$3 = byx.a($$2);
         if (!$$2.b() && $$3 != null && $$3.e("x") && $$3.e("y") && $$3.e("z")) {
            gt $$4 = cti.c($$3);
            if (this.c.s.o($$4)) {
               cti $$5 = this.c.s.c_($$4);
               if ($$5 != null) {
                  $$5.e($$2);
               }
            }
         }

         boolean $$6 = $$0.b() >= 1 && $$0.b() <= 45;
         boolean $$7 = $$2.b() || $$2.j() >= 0 && $$2.K() <= 64 && !$$2.b();
         if ($$6 && $$7) {
            this.c.bT.b($$0.b()).d($$2);
            this.c.bT.d();
         } else if ($$1 && $$7 && this.o < 200) {
            this.o += 20;
            this.c.a((cax)$$2, true);
         }
      }

   }

   public void a(zf $$0) {
      List<String> $$1 = (List)Stream.of($$0.c()).map(p::a).collect(Collectors.toList());
      this.a($$1).thenAcceptAsync(($$1x) -> {
         this.a($$0, $$1x);
      }, this.h);
   }

   private void a(zf $$0, List<agv> $$1) {
      this.c.C();
      agg $$2 = this.c.x();
      gt $$3 = $$0.b();
      if ($$2.E($$3)) {
         cvo $$4 = $$2.a_($$3);
         cti $$5 = $$2.c_($$3);
         if (!($$5 instanceof cuk)) {
            return;
         }

         cuk $$6 = (cuk)$$5;
         if (!$$6.d() || !this.c.co().equals($$6.f())) {
            d.warn("Player {} just tried to change non-editable sign", this.c.X().getString());
            return;
         }

         for(int $$7 = 0; $$7 < $$1.size(); ++$$7) {
            agv $$8 = (agv)$$1.get($$7);
            if (this.c.U()) {
               $$6.a($$7, rq.b($$8.b()));
            } else {
               $$6.a($$7, rq.b($$8.d()), rq.b($$8.b()));
            }
         }

         $$6.e();
         $$2.a($$3, $$4, $$4, 3);
      }

   }

   public void a(yg $$0) {
      if (this.l && $$0.b() == this.m) {
         int $$1 = (int)(ad.b() - this.k);
         this.c.e = (this.c.e * 3 + $$1) / 4;
         this.l = false;
      } else if (!this.g()) {
         this.b((rq)rq.c("disconnect.timeout"));
      }

   }

   public void a(yn $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.fB().b = $$0.b() && this.c.fB().c;
   }

   public void a(xw $$0) {
      te.a($$0, this, (agg)this.c.x());
      this.c.a($$0);
   }

   public void a(yb $$0) {
   }

   public void a(xq $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.l(2) || this.g()) {
         this.h.a($$0.b(), false);
      }
   }

   public void a(yh $$0) {
      te.a($$0, this, (agg)this.c.x());
      if (this.c.l(2) || this.g()) {
         this.h.b($$0.b());
      }
   }

   public agh f() {
      return this.c;
   }

   @FunctionalInterface
   private interface a {
      baj run(agh var1, bbn var2, bai var3);
   }
}
