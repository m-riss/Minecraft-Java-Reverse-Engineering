public class afr implements Comparable<afr> {
   private final int a;
   private final gt b;
   private int c;
   private int d;

   public afr(int $$0, gt $$1) {
      this.a = $$0;
      this.b = $$1;
   }

   public int a() {
      return this.a;
   }

   public gt b() {
      return this.b;
   }

   public void a(int $$0) {
      if ($$0 > 10) {
         $$0 = 10;
      }

      this.c = $$0;
   }

   public int c() {
      return this.c;
   }

   public void b(int $$0) {
      this.d = $$0;
   }

   public int d() {
      return this.d;
   }

   public boolean equals(Object $$0) {
      if (this == $$0) {
         return true;
      } else if ($$0 != null && this.getClass() == $$0.getClass()) {
         afr $$1 = (afr)$$0;
         return this.a == $$1.a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Integer.hashCode(this.a);
   }

   public int a(afr $$0) {
      return this.c != $$0.c ? Integer.compare(this.c, $$0.c) : Integer.compare(this.a, $$0.a);
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((afr)var1);
   }
}
