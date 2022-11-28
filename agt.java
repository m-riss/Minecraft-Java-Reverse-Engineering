import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import javax.annotation.Nullable;

public class agt implements agp {
   private final agr a;
   private final Long2ObjectOpenHashMap<cxn> b;
   private cge c = new cge(0, 0);
   private final int d;
   private final int e;
   private final int f;
   private boolean g;

   public agt(int $$0) {
      this.a = new agr($$0);
      this.d = $$0 * 2 + 1;
      this.e = $$0 + cxn.b();
      this.f = this.e * 2 + 1;
      this.b = new Long2ObjectOpenHashMap();
   }

   public void a(cge $$0) {
      if (this.g) {
         this.a.a($$0);
         this.c = $$0;
      }
   }

   public void a(cge $$0, @Nullable cxn $$1) {
      if (this.g) {
         this.a.a($$0, $$1);
         if ($$1 == null) {
            this.b.remove($$0.a());
         } else {
            this.b.put($$0.a(), $$1);
         }

      }
   }

   public void a() {
      this.g = true;
      this.b.clear();
      this.a.a();
   }

   public void b() {
      this.g = false;
      this.a.b();
   }

   public int c() {
      return this.d;
   }

   public int d() {
      return this.f;
   }

   public int e() {
      return this.a.c();
   }

   @Nullable
   public cxn a(int $$0, int $$1) {
      return (cxn)this.b.get(cge.c($$0 + this.c.e - this.e, $$1 + this.c.f - this.e));
   }
}
