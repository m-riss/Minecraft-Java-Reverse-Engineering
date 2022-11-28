import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntSupplier;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public class agj extends dpm implements AutoCloseable {
   private static final Logger d = LogUtils.getLogger();
   private final azc<Runnable> e;
   private final ObjectList<Pair<agj.a, Runnable>> f = new ObjectArrayList();
   private final aft g;
   private final azb<afv.a<Runnable>> h;
   private volatile int i = 5;
   private final AtomicBoolean j = new AtomicBoolean();

   public agj(cxv $$0, aft $$1, boolean $$2, azc<Runnable> $$3, azb<afv.a<Runnable>> $$4) {
      super($$0, true, $$2);
      this.g = $$1;
      this.h = $$4;
      this.e = $$3;
   }

   public void close() {
   }

   public int a(int $$0, boolean $$1, boolean $$2) {
      throw (UnsupportedOperationException)ad.c((Throwable)(new UnsupportedOperationException("Ran automatically on a different thread!")));
   }

   public void a(gt $$0, int $$1) {
      throw (UnsupportedOperationException)ad.c((Throwable)(new UnsupportedOperationException("Ran automatically on a different thread!")));
   }

   public void a(gt $$0) {
      gt $$1 = $$0.h();
      this.a(hq.a($$0.u()), hq.a($$0.w()), agj.a.b, ad.a(() -> {
         super.a($$1);
      }, () -> {
         return "checkBlock " + $$1;
      }));
   }

   protected void a(cge $$0) {
      this.a($$0.e, $$0.f, () -> {
         return 0;
      }, agj.a.a, ad.a(() -> {
         super.b($$0, false);
         super.a($$0, false);

         int $$2;
         for($$2 = this.c(); $$2 < this.d(); ++$$2) {
            super.a(chg.b, hq.a($$0, $$2), (cxo)null, true);
            super.a(chg.a, hq.a($$0, $$2), (cxo)null, true);
         }

         for($$2 = this.c.aj(); $$2 < this.c.ak(); ++$$2) {
            super.a(hq.a($$0, $$2), true);
         }

      }, () -> {
         return "updateChunkStatus " + $$0 + " true";
      }));
   }

   public void a(hq $$0, boolean $$1) {
      this.a($$0.a(), $$0.c(), () -> {
         return 0;
      }, agj.a.a, ad.a(() -> {
         super.a($$0, $$1);
      }, () -> {
         return "updateSectionStatus " + $$0 + " " + $$1;
      }));
   }

   public void a(cge $$0, boolean $$1) {
      this.a($$0.e, $$0.f, agj.a.a, ad.a(() -> {
         super.a($$0, $$1);
      }, () -> {
         return "enableLight " + $$0 + " " + $$1;
      }));
   }

   public void a(chg $$0, hq $$1, @Nullable cxo $$2, boolean $$3) {
      this.a($$1.a(), $$1.c(), () -> {
         return 0;
      }, agj.a.a, ad.a(() -> {
         super.a($$0, $$1, $$2, $$3);
      }, () -> {
         return "queueData " + $$1;
      }));
   }

   private void a(int $$0, int $$1, agj.a $$2, Runnable $$3) {
      this.a($$0, $$1, this.g.c(cge.c($$0, $$1)), $$2, $$3);
   }

   private void a(int $$0, int $$1, IntSupplier $$2, agj.a $$3, Runnable $$4) {
      this.h.a(afv.a(() -> {
         this.f.add(Pair.of($$3, $$4));
         if (this.f.size() >= this.i) {
            this.e();
         }

      }, cge.c($$0, $$1), $$2));
   }

   public void b(cge $$0, boolean $$1) {
      this.a($$0.e, $$0.f, () -> {
         return 0;
      }, agj.a.a, ad.a(() -> {
         super.b($$0, $$1);
      }, () -> {
         return "retainData " + $$0;
      }));
   }

   public CompletableFuture<cxj> a(cxj $$0) {
      cge $$1 = $$0.f();
      return CompletableFuture.supplyAsync(ad.a(() -> {
         super.b($$1, true);
         return $$0;
      }, () -> {
         return "retainData: " + $$1;
      }), ($$1x) -> {
         this.a($$1.e, $$1.f, agj.a.a, $$1x);
      });
   }

   public CompletableFuture<cxj> a(cxj $$0, boolean $$1) {
      cge $$2 = $$0.f();
      $$0.b(false);
      this.a($$2.e, $$2.f, agj.a.a, ad.a(() -> {
         cxu[] $$3 = $$0.d();

         for(int $$4 = 0; $$4 < $$0.ai(); ++$$4) {
            cxu $$5 = $$3[$$4];
            if (!$$5.c()) {
               int $$6 = this.c.g($$4);
               super.a(hq.a($$2, $$6), false);
            }
         }

         super.a($$2, true);
         if (!$$1) {
            $$0.n().forEach(($$1x) -> {
               super.a($$1x, $$0.h($$1x));
            });
         }

      }, () -> {
         return "lightChunk " + $$2 + " " + $$1;
      }));
      return CompletableFuture.supplyAsync(() -> {
         $$0.b(true);
         super.b($$2, false);
         this.g.c($$2);
         return $$0;
      }, ($$1x) -> {
         this.a($$2.e, $$2.f, agj.a.b, $$1x);
      });
   }

   public void a() {
      if ((!this.f.isEmpty() || super.A_()) && this.j.compareAndSet(false, true)) {
         this.e.a((Object)(() -> {
            this.e();
            this.j.set(false);
         }));
      }

   }

   private void e() {
      int $$0 = Math.min(this.f.size(), this.i);
      ObjectListIterator<Pair<agj.a, Runnable>> $$1 = this.f.iterator();

      int $$2;
      Pair $$4;
      for($$2 = 0; $$1.hasNext() && $$2 < $$0; ++$$2) {
         $$4 = (Pair)$$1.next();
         if ($$4.getFirst() == agj.a.a) {
            ((Runnable)$$4.getSecond()).run();
         }
      }

      $$1.back($$2);
      super.a(Integer.MAX_VALUE, true, true);

      for($$2 = 0; $$1.hasNext() && $$2 < $$0; ++$$2) {
         $$4 = (Pair)$$1.next();
         if ($$4.getFirst() == agj.a.b) {
            ((Runnable)$$4.getSecond()).run();
         }

         $$1.remove();
      }

   }

   public void a(int $$0) {
      this.i = $$0;
   }

   static enum a {
      a,
      b;

      // $FF: synthetic method
      private static agj.a[] a() {
         return new agj.a[]{a, b};
      }
   }
}
