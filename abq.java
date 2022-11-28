import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;

public class abq extends dxo {
   private final MinecraftServer g;
   private final Set<dxl> h = Sets.newHashSet();
   private final List<Runnable> i = Lists.newArrayList();

   public abq(MinecraftServer $$0) {
      this.g = $$0;
   }

   public void a(dxn $$0) {
      super.a($$0);
      if (this.h.contains($$0.d())) {
         this.g.ac().a((tc)(new wr(abq.a.a, $$0.d().b(), $$0.e(), $$0.b())));
      }

      this.a();
   }

   public void a(String $$0) {
      super.a($$0);
      this.g.ac().a((tc)(new wr(abq.a.b, (String)null, $$0, 0)));
      this.a();
   }

   public void a(String $$0, dxl $$1) {
      super.a($$0, $$1);
      if (this.h.contains($$1)) {
         this.g.ac().a((tc)(new wr(abq.a.b, $$1.b(), $$0, 0)));
      }

      this.a();
   }

   public void a(int $$0, @Nullable dxl $$1) {
      dxl $$2 = this.a($$0);
      super.a($$0, $$1);
      if ($$2 != $$1 && $$2 != null) {
         if (this.h($$2) > 0) {
            this.g.ac().a((tc)(new wh($$0, $$1)));
         } else {
            this.g($$2);
         }
      }

      if ($$1 != null) {
         if (this.h.contains($$1)) {
            this.g.ac().a((tc)(new wh($$0, $$1)));
         } else {
            this.e($$1);
         }
      }

      this.a();
   }

   public boolean a(String $$0, dxm $$1) {
      if (super.a($$0, $$1)) {
         this.g.ac().a((tc)wq.a($$1, $$0, wq.a.a));
         this.a();
         return true;
      } else {
         return false;
      }
   }

   public void b(String $$0, dxm $$1) {
      super.b($$0, $$1);
      this.g.ac().a((tc)wq.a($$1, $$0, wq.a.b));
      this.a();
   }

   public void a(dxl $$0) {
      super.a($$0);
      this.a();
   }

   public void b(dxl $$0) {
      super.b($$0);
      if (this.h.contains($$0)) {
         this.g.ac().a((tc)(new wo($$0, 2)));
      }

      this.a();
   }

   public void c(dxl $$0) {
      super.c($$0);
      if (this.h.contains($$0)) {
         this.g($$0);
      }

      this.a();
   }

   public void a(dxm $$0) {
      super.a($$0);
      this.g.ac().a((tc)wq.a($$0, true));
      this.a();
   }

   public void b(dxm $$0) {
      super.b($$0);
      this.g.ac().a((tc)wq.a($$0, false));
      this.a();
   }

   public void c(dxm $$0) {
      super.c($$0);
      this.g.ac().a((tc)wq.a($$0));
      this.a();
   }

   public void a(Runnable $$0) {
      this.i.add($$0);
   }

   protected void a() {
      Iterator var1 = this.i.iterator();

      while(var1.hasNext()) {
         Runnable $$0 = (Runnable)var1.next();
         $$0.run();
      }

   }

   public List<tc<?>> d(dxl $$0) {
      List<tc<?>> $$1 = Lists.newArrayList();
      $$1.add(new wo($$0, 0));

      for(int $$2 = 0; $$2 < 19; ++$$2) {
         if (this.a($$2) == $$0) {
            $$1.add(new wh($$2, $$0));
         }
      }

      Iterator var5 = this.i($$0).iterator();

      while(var5.hasNext()) {
         dxn $$3 = (dxn)var5.next();
         $$1.add(new wr(abq.a.a, $$3.d().b(), $$3.e(), $$3.b()));
      }

      return $$1;
   }

   public void e(dxl $$0) {
      List<tc<?>> $$1 = this.d($$0);
      Iterator var3 = this.g.ac().t().iterator();

      while(var3.hasNext()) {
         agh $$2 = (agh)var3.next();
         Iterator var5 = $$1.iterator();

         while(var5.hasNext()) {
            tc<?> $$3 = (tc)var5.next();
            $$2.b.a($$3);
         }
      }

      this.h.add($$0);
   }

   public List<tc<?>> f(dxl $$0) {
      List<tc<?>> $$1 = Lists.newArrayList();
      $$1.add(new wo($$0, 1));

      for(int $$2 = 0; $$2 < 19; ++$$2) {
         if (this.a($$2) == $$0) {
            $$1.add(new wh($$2, $$0));
         }
      }

      return $$1;
   }

   public void g(dxl $$0) {
      List<tc<?>> $$1 = this.f($$0);
      Iterator var3 = this.g.ac().t().iterator();

      while(var3.hasNext()) {
         agh $$2 = (agh)var3.next();
         Iterator var5 = $$1.iterator();

         while(var5.hasNext()) {
            tc<?> $$3 = (tc)var5.next();
            $$2.b.a($$3);
         }
      }

      this.h.remove($$0);
   }

   public int h(dxl $$0) {
      int $$1 = 0;

      for(int $$2 = 0; $$2 < 19; ++$$2) {
         if (this.a($$2) == $$0) {
            ++$$1;
         }
      }

      return $$1;
   }

   public dxp b() {
      dxp $$0 = new dxp(this);
      Objects.requireNonNull($$0);
      this.a($$0::b);
      return $$0;
   }

   public dxp a(pj $$0) {
      return this.b().b($$0);
   }

   public static enum a {
      a,
      b;

      // $FF: synthetic method
      private static abq.a[] a() {
         return new abq.a[]{a, b};
      }
   }
}
