public class aaj<T> {
   private final int a;
   private final aak<T> b;

   public aaj(int $$0, aak<T> $$1) {
      this.a = $$0;
      this.b = $$1;
   }

   public int a() {
      return this.a;
   }

   public aak<T> b() {
      return this.b;
   }

   public boolean equals(Object $$0) {
      if (this == $$0) {
         return true;
      } else if ($$0 != null && this.getClass() == $$0.getClass()) {
         aaj<?> $$1 = (aaj)$$0;
         return this.a == $$1.a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.a;
   }

   public String toString() {
      return "<entity data: " + this.a + ">";
   }
}
