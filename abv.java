import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class abv extends agd {
   private final abb h;
   private final Set<UUID> i = Sets.newHashSet();
   private int j;
   private int k = 100;

   public abv(abb $$0, rq $$1) {
      super($$1, azz.a.g, azz.b.a);
      this.h = $$0;
      this.a(0.0F);
   }

   public abb a() {
      return this.h;
   }

   public void a(agh $$0) {
      super.a($$0);
      this.i.add($$0.co());
   }

   public void a(UUID $$0) {
      this.i.add($$0);
   }

   public void b(agh $$0) {
      super.b($$0);
      this.i.remove($$0.co());
   }

   public void b() {
      super.b();
      this.i.clear();
   }

   public int c() {
      return this.j;
   }

   public int d() {
      return this.k;
   }

   public void a(int $$0) {
      this.j = $$0;
      this.a(ami.a((float)$$0 / (float)this.k, 0.0F, 1.0F));
   }

   public void b(int $$0) {
      this.k = $$0;
      this.a(ami.a((float)this.j / (float)$$0, 0.0F, 1.0F));
   }

   public final rq e() {
      return rs.a(this.j()).a(($$0) -> {
         return $$0.a(this.l().a()).a(new rv(rv.a.a, rq.b(this.a().toString()))).a(this.a().toString());
      });
   }

   public boolean a(Collection<agh> $$0) {
      Set<UUID> $$1 = Sets.newHashSet();
      Set<agh> $$2 = Sets.newHashSet();
      Iterator var4 = this.i.iterator();

      UUID $$9;
      boolean $$7;
      Iterator var7;
      while(var4.hasNext()) {
         $$9 = (UUID)var4.next();
         $$7 = false;
         var7 = $$0.iterator();

         while(var7.hasNext()) {
            agh $$5 = (agh)var7.next();
            if ($$5.co().equals($$9)) {
               $$7 = true;
               break;
            }
         }

         if (!$$7) {
            $$1.add($$9);
         }
      }

      var4 = $$0.iterator();

      agh $$11;
      while(var4.hasNext()) {
         $$11 = (agh)var4.next();
         $$7 = false;
         var7 = this.i.iterator();

         while(var7.hasNext()) {
            UUID $$8 = (UUID)var7.next();
            if ($$11.co().equals($$8)) {
               $$7 = true;
               break;
            }
         }

         if (!$$7) {
            $$2.add($$11);
         }
      }

      for(var4 = $$1.iterator(); var4.hasNext(); this.i.remove($$9)) {
         $$9 = (UUID)var4.next();
         Iterator var11 = this.h().iterator();

         while(var11.hasNext()) {
            agh $$10 = (agh)var11.next();
            if ($$10.co().equals($$9)) {
               this.b($$10);
               break;
            }
         }
      }

      var4 = $$2.iterator();

      while(var4.hasNext()) {
         $$11 = (agh)var4.next();
         this.a($$11);
      }

      return !$$1.isEmpty() || !$$2.isEmpty();
   }

   public pj f() {
      pj $$0 = new pj();
      $$0.a("Name", rq.a.a(this.a));
      $$0.a("Visible", this.g());
      $$0.a("Value", this.j);
      $$0.a("Max", this.k);
      $$0.a("Color", this.l().b());
      $$0.a("Overlay", this.m().a());
      $$0.a("DarkenScreen", this.n());
      $$0.a("PlayBossMusic", this.o());
      $$0.a("CreateWorldFog", this.p());
      pp $$1 = new pp();
      Iterator var3 = this.i.iterator();

      while(var3.hasNext()) {
         UUID $$2 = (UUID)var3.next();
         $$1.add(pv.a($$2));
      }

      $$0.a((String)"Players", (qc)$$1);
      return $$0;
   }

   public static abv a(pj $$0, abb $$1) {
      abv $$2 = new abv($$1, rq.a.a($$0.l("Name")));
      $$2.d($$0.q("Visible"));
      $$2.a($$0.h("Value"));
      $$2.b($$0.h("Max"));
      $$2.a((azz.a)azz.a.a($$0.l("Color")));
      $$2.a((azz.b)azz.b.a($$0.l("Overlay")));
      $$2.a($$0.q("DarkenScreen"));
      $$2.b($$0.q("PlayBossMusic"));
      $$2.c($$0.q("CreateWorldFog"));
      pp $$3 = $$0.c("Players", 11);

      for(int $$4 = 0; $$4 < $$3.size(); ++$$4) {
         $$2.a(pv.a($$3.k($$4)));
      }

      return $$2;
   }

   public void c(agh $$0) {
      if (this.i.contains($$0.co())) {
         this.a($$0);
      }

   }

   public void d(agh $$0) {
      super.b($$0);
   }
}
