import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.shorts.ShortOpenHashSet;
import it.unimi.dsi.fastutil.shorts.ShortSet;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import javax.annotation.Nullable;

public class afs {
   public static final Either<cxj, afs.a> a;
   public static final CompletableFuture<Either<cxj, afs.a>> b;
   public static final Either<cxt, afs.a> c;
   private static final Either<cxj, afs.a> d;
   private static final CompletableFuture<Either<cxt, afs.a>> e;
   private static final List<cxn> f;
   private static final afs.c[] g;
   private static final int h = 64;
   private final AtomicReferenceArray<CompletableFuture<Either<cxj, afs.a>>> i;
   private final cgz j;
   private volatile CompletableFuture<Either<cxt, afs.a>> k;
   private volatile CompletableFuture<Either<cxt, afs.a>> l;
   private volatile CompletableFuture<Either<cxt, afs.a>> m;
   private CompletableFuture<cxj> n;
   @Nullable
   private final aln<afs.b> o;
   private int p;
   private int q;
   private int r;
   final cge s;
   private boolean t;
   private final ShortSet[] u;
   private final BitSet v;
   private final BitSet w;
   private final dpm x;
   private final afs.d y;
   private final afs.e z;
   private boolean A;
   private boolean B;
   private CompletableFuture<Void> C;

   public afs(cge $$0, int $$1, cgz $$2, dpm $$3, afs.d $$4, afs.e $$5) {
      this.i = new AtomicReferenceArray(f.size());
      this.k = e;
      this.l = e;
      this.m = e;
      this.n = CompletableFuture.completedFuture((Object)null);
      this.o = null;
      this.v = new BitSet();
      this.w = new BitSet();
      this.C = CompletableFuture.completedFuture((Object)null);
      this.s = $$0;
      this.j = $$2;
      this.x = $$3;
      this.y = $$4;
      this.z = $$5;
      this.p = aft.b + 1;
      this.q = this.p;
      this.r = this.p;
      this.a($$1);
      this.u = new ShortSet[$$2.ai()];
   }

   public CompletableFuture<Either<cxj, afs.a>> a(cxn $$0) {
      CompletableFuture<Either<cxj, afs.a>> $$1 = (CompletableFuture)this.i.get($$0.c());
      return $$1 == null ? b : $$1;
   }

   public CompletableFuture<Either<cxj, afs.a>> b(cxn $$0) {
      return b(this.q).b($$0) ? this.a($$0) : b;
   }

   public CompletableFuture<Either<cxt, afs.a>> a() {
      return this.l;
   }

   public CompletableFuture<Either<cxt, afs.a>> b() {
      return this.m;
   }

   public CompletableFuture<Either<cxt, afs.a>> c() {
      return this.k;
   }

   @Nullable
   public cxt d() {
      CompletableFuture<Either<cxt, afs.a>> $$0 = this.a();
      Either<cxt, afs.a> $$1 = (Either)$$0.getNow((Object)null);
      return $$1 == null ? null : (cxt)$$1.left().orElse((Object)null);
   }

   @Nullable
   public cxt e() {
      CompletableFuture<Either<cxt, afs.a>> $$0 = this.c();
      Either<cxt, afs.a> $$1 = (Either)$$0.getNow((Object)null);
      return $$1 == null ? null : (cxt)$$1.left().orElse((Object)null);
   }

   @Nullable
   public cxn f() {
      for(int $$0 = f.size() - 1; $$0 >= 0; --$$0) {
         cxn $$1 = (cxn)f.get($$0);
         CompletableFuture<Either<cxj, afs.a>> $$2 = this.a($$1);
         if (((Either)$$2.getNow(a)).left().isPresent()) {
            return $$1;
         }
      }

      return null;
   }

   @Nullable
   public cxj g() {
      for(int $$0 = f.size() - 1; $$0 >= 0; --$$0) {
         cxn $$1 = (cxn)f.get($$0);
         CompletableFuture<Either<cxj, afs.a>> $$2 = this.a($$1);
         if (!$$2.isCompletedExceptionally()) {
            Optional<cxj> $$3 = ((Either)$$2.getNow(a)).left();
            if ($$3.isPresent()) {
               return (cxj)$$3.get();
            }
         }
      }

      return null;
   }

   public CompletableFuture<cxj> h() {
      return this.n;
   }

   public void a(gt $$0) {
      cxt $$1 = this.d();
      if ($$1 != null) {
         int $$2 = this.j.e($$0.v());
         if (this.u[$$2] == null) {
            this.t = true;
            this.u[$$2] = new ShortOpenHashSet();
         }

         this.u[$$2].add(hq.b($$0));
      }
   }

   public void a(chg $$0, int $$1) {
      Either<cxj, afs.a> $$2 = (Either)this.b(cxn.k).getNow((Object)null);
      if ($$2 != null) {
         cxj $$3 = (cxj)$$2.left().orElse((Object)null);
         if ($$3 != null) {
            $$3.a(true);
            cxt $$4 = this.d();
            if ($$4 != null) {
               int $$5 = this.x.c();
               int $$6 = this.x.d();
               if ($$1 >= $$5 && $$1 <= $$6) {
                  int $$7 = $$1 - $$5;
                  if ($$0 == chg.a) {
                     this.w.set($$7);
                  } else {
                     this.v.set($$7);
                  }

               }
            }
         }
      }
   }

   public void a(cxt $$0) {
      if (this.t || !this.w.isEmpty() || !this.v.isEmpty()) {
         cgx $$1 = $$0.D();
         int $$2 = 0;

         int $$4;
         for($$4 = 0; $$4 < this.u.length; ++$$4) {
            $$2 += this.u[$$4] != null ? this.u[$$4].size() : 0;
         }

         this.B |= $$2 >= 64;
         if (!this.w.isEmpty() || !this.v.isEmpty()) {
            this.a(new ur($$0.f(), this.x, this.w, this.v, true), !this.B);
            this.w.clear();
            this.v.clear();
         }

         for($$4 = 0; $$4 < this.u.length; ++$$4) {
            ShortSet $$5 = this.u[$$4];
            if ($$5 != null) {
               int $$6 = this.j.g($$4);
               hq $$7 = hq.a($$0.f(), $$6);
               if ($$5.size() == 1) {
                  gt $$8 = $$7.g($$5.iterator().nextShort());
                  cvo $$9 = $$1.a_($$8);
                  this.a(new tp($$8, $$9), false);
                  this.a($$1, $$8, $$9);
               } else {
                  cxu $$10 = $$0.b($$4);
                  vs $$11 = new vs($$7, $$5, $$10, this.B);
                  this.a($$11, false);
                  $$11.a(($$1x, $$2x) -> {
                     this.a($$1, $$1x, $$2x);
                  });
               }

               this.u[$$4] = null;
            }
         }

         this.t = false;
      }
   }

   private void a(cgx $$0, gt $$1, cvo $$2) {
      if ($$2.o()) {
         this.a($$0, $$1);
      }

   }

   private void a(cgx $$0, gt $$1) {
      cti $$2 = $$0.c_($$1);
      if ($$2 != null) {
         tc<?> $$3 = $$2.h();
         if ($$3 != null) {
            this.a($$3, false);
         }
      }

   }

   private void a(tc<?> $$0, boolean $$1) {
      this.z.a(this.s, $$1).forEach(($$1x) -> {
         $$1x.b.a($$0);
      });
   }

   public CompletableFuture<Either<cxj, afs.a>> a(cxn $$0, aft $$1) {
      int $$2 = $$0.c();
      CompletableFuture<Either<cxj, afs.a>> $$3 = (CompletableFuture)this.i.get($$2);
      if ($$3 != null) {
         Either<cxj, afs.a> $$4 = (Either)$$3.getNow(d);
         if ($$4 == null) {
            String $$5 = "value in future for status: " + $$0 + " was incorrectly set to null at chunk: " + this.s;
            throw $$1.a(new IllegalStateException("null value previously set for chunk status"), $$5);
         }

         if ($$4 == d || $$4.right().isEmpty()) {
            return $$3;
         }
      }

      if (b(this.q).b($$0)) {
         CompletableFuture<Either<cxj, afs.a>> $$6 = $$1.a(this, $$0);
         this.a($$6, "schedule " + $$0);
         this.i.set($$2, $$6);
         return $$6;
      } else {
         return $$3 == null ? b : $$3;
      }
   }

   protected void a(String $$0, CompletableFuture<?> $$1) {
      if (this.o != null) {
         this.o.a(new afs.b(Thread.currentThread(), $$1, $$0));
      }

      this.n = this.n.thenCombine($$1, ($$0x, $$1x) -> {
         return $$0x;
      });
   }

   private void a(CompletableFuture<? extends Either<? extends cxj, afs.a>> $$0, String $$1) {
      if (this.o != null) {
         this.o.a(new afs.b(Thread.currentThread(), $$0, $$1));
      }

      this.n = this.n.thenCombine($$0, ($$0x, $$1x) -> {
         return (cxj)$$1x.map(($$0) -> {
            return $$0;
         }, ($$1) -> {
            return $$0x;
         });
      });
   }

   public afs.c i() {
      return c(this.q);
   }

   public cge j() {
      return this.s;
   }

   public int k() {
      return this.q;
   }

   public int l() {
      return this.r;
   }

   private void d(int $$0) {
      this.r = $$0;
   }

   public void a(int $$0) {
      this.q = $$0;
   }

   private void a(aft $$0, CompletableFuture<Either<cxt, afs.a>> $$1, Executor $$2, afs.c $$3) {
      this.C.cancel(false);
      CompletableFuture<Void> $$4 = new CompletableFuture();
      $$4.thenRunAsync(() -> {
         $$0.a(this.s, $$3);
      }, $$2);
      this.C = $$4;
      $$1.thenAccept(($$1x) -> {
         $$1x.ifLeft(($$1) -> {
            $$4.complete((Object)null);
         });
      });
   }

   private void a(aft $$0, afs.c $$1) {
      this.C.cancel(false);
      $$0.a(this.s, $$1);
   }

   protected void a(aft $$0, Executor $$1) {
      cxn $$2 = b(this.p);
      cxn $$3 = b(this.q);
      boolean $$4 = this.p <= aft.b;
      boolean $$5 = this.q <= aft.b;
      afs.c $$6 = c(this.p);
      afs.c $$7 = c(this.q);
      if ($$4) {
         Either<cxj, afs.a> $$8 = Either.right(new afs.a() {
            public String toString() {
               return "Unloaded ticket level " + afs.this.s;
            }
         });

         for(int $$9 = $$5 ? $$3.c() + 1 : 0; $$9 <= $$2.c(); ++$$9) {
            CompletableFuture<Either<cxj, afs.a>> $$10 = (CompletableFuture)this.i.get($$9);
            if ($$10 == null) {
               this.i.set($$9, CompletableFuture.completedFuture($$8));
            }
         }
      }

      boolean $$11 = $$6.a(afs.c.b);
      boolean $$12 = $$7.a(afs.c.b);
      this.A |= $$12;
      if (!$$11 && $$12) {
         this.k = $$0.b(this);
         this.a($$0, this.k, $$1, afs.c.b);
         this.a(this.k, "full");
      }

      if ($$11 && !$$12) {
         this.k.complete(c);
         this.k = e;
      }

      boolean $$13 = $$6.a(afs.c.c);
      boolean $$14 = $$7.a(afs.c.c);
      if (!$$13 && $$14) {
         this.l = $$0.a(this);
         this.a($$0, this.l, $$1, afs.c.c);
         this.a(this.l, "ticking");
      }

      if ($$13 && !$$14) {
         this.l.complete(c);
         this.l = e;
      }

      boolean $$15 = $$6.a(afs.c.d);
      boolean $$16 = $$7.a(afs.c.d);
      if (!$$15 && $$16) {
         if (this.m != e) {
            throw (IllegalStateException)ad.c((Throwable)(new IllegalStateException()));
         }

         this.m = $$0.b(this.s);
         this.a($$0, this.m, $$1, afs.c.d);
         this.a(this.m, "entity ticking");
      }

      if ($$15 && !$$16) {
         this.m.complete(c);
         this.m = e;
      }

      if (!$$7.a($$6)) {
         this.a($$0, $$7);
      }

      this.y.onLevelChange(this.s, this::l, this.q, this::d);
      this.p = this.q;
   }

   public static cxn b(int $$0) {
      return $$0 < 33 ? cxn.o : cxn.a($$0 - 33);
   }

   public static afs.c c(int $$0) {
      return g[ami.a((int)(33 - $$0 + 1), (int)0, (int)(g.length - 1))];
   }

   public boolean m() {
      return this.A;
   }

   public void n() {
      this.A = c(this.q).a(afs.c.b);
   }

   public void a(cxs $$0) {
      for(int $$1 = 0; $$1 < this.i.length(); ++$$1) {
         CompletableFuture<Either<cxj, afs.a>> $$2 = (CompletableFuture)this.i.get($$1);
         if ($$2 != null) {
            Optional<cxj> $$3 = ((Either)$$2.getNow(a)).left();
            if (!$$3.isEmpty() && $$3.get() instanceof cyc) {
               this.i.set($$1, CompletableFuture.completedFuture(Either.left($$0)));
            }
         }
      }

      this.a(CompletableFuture.completedFuture(Either.left($$0.A())), "replaceProto");
   }

   public List<Pair<cxn, CompletableFuture<Either<cxj, afs.a>>>> o() {
      List<Pair<cxn, CompletableFuture<Either<cxj, afs.a>>>> $$0 = new ArrayList();

      for(int $$1 = 0; $$1 < f.size(); ++$$1) {
         $$0.add(Pair.of((cxn)f.get($$1), (CompletableFuture)this.i.get($$1)));
      }

      return $$0;
   }

   static {
      a = Either.right(afs.a.b);
      b = CompletableFuture.completedFuture(a);
      c = Either.right(afs.a.b);
      d = Either.right(afs.a.b);
      e = CompletableFuture.completedFuture(c);
      f = cxn.a();
      g = afs.c.values();
   }

   @FunctionalInterface
   public interface d {
      void onLevelChange(cge var1, IntSupplier var2, int var3, IntConsumer var4);
   }

   public interface e {
      List<agh> a(cge var1, boolean var2);
   }

   private static final class b {
      private final Thread a;
      private final CompletableFuture<?> b;
      private final String c;

      b(Thread $$0, CompletableFuture<?> $$1, String $$2) {
         this.a = $$0;
         this.b = $$1;
         this.c = $$2;
      }
   }

   public static enum c {
      a,
      b,
      c,
      d;

      public boolean a(afs.c $$0) {
         return this.ordinal() >= $$0.ordinal();
      }

      // $FF: synthetic method
      private static afs.c[] a() {
         return new afs.c[]{a, b, c, d};
      }
   }

   public interface a {
      afs.a b = new afs.a() {
         public String toString() {
            return "UNLOADED";
         }
      };
   }
}
