import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class agd extends azz {
   private final Set<agh> h = Sets.newHashSet();
   private final Set<agh> i;
   private boolean j;

   public agd(rq $$0, azz.a $$1, azz.b $$2) {
      super(ami.a(), $$0, $$1, $$2);
      this.i = Collections.unmodifiableSet(this.h);
      this.j = true;
   }

   public void a(float $$0) {
      if ($$0 != this.b) {
         super.a($$0);
         this.a(tq::b);
      }

   }

   public void a(azz.a $$0) {
      if ($$0 != this.c) {
         super.a($$0);
         this.a(tq::d);
      }

   }

   public void a(azz.b $$0) {
      if ($$0 != this.d) {
         super.a($$0);
         this.a(tq::d);
      }

   }

   public azz a(boolean $$0) {
      if ($$0 != this.e) {
         super.a($$0);
         this.a(tq::e);
      }

      return this;
   }

   public azz b(boolean $$0) {
      if ($$0 != this.f) {
         super.b($$0);
         this.a(tq::e);
      }

      return this;
   }

   public azz c(boolean $$0) {
      if ($$0 != this.g) {
         super.c($$0);
         this.a(tq::e);
      }

      return this;
   }

   public void a(rq $$0) {
      if (!Objects.equal($$0, this.a)) {
         super.a($$0);
         this.a(tq::c);
      }

   }

   private void a(Function<azz, tq> $$0) {
      if (this.j) {
         tq $$1 = (tq)$$0.apply(this);
         Iterator var3 = this.h.iterator();

         while(var3.hasNext()) {
            agh $$2 = (agh)var3.next();
            $$2.b.a((tc)$$1);
         }
      }

   }

   public void a(agh $$0) {
      if (this.h.add($$0) && this.j) {
         $$0.b.a((tc)tq.a((azz)this));
      }

   }

   public void b(agh $$0) {
      if (this.h.remove($$0) && this.j) {
         $$0.b.a((tc)tq.a(this.i()));
      }

   }

   public void b() {
      if (!this.h.isEmpty()) {
         Iterator var1 = Lists.newArrayList(this.h).iterator();

         while(var1.hasNext()) {
            agh $$0 = (agh)var1.next();
            this.b($$0);
         }
      }

   }

   public boolean g() {
      return this.j;
   }

   public void d(boolean $$0) {
      if ($$0 != this.j) {
         this.j = $$0;
         Iterator var2 = this.h.iterator();

         while(var2.hasNext()) {
            agh $$1 = (agh)var2.next();
            $$1.b.a((tc)($$0 ? tq.a((azz)this) : tq.a(this.i())));
         }
      }

   }

   public Collection<agh> h() {
      return this.i;
   }
}
