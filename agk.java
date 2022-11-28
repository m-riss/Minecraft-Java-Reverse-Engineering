import java.util.Objects;

public final class agk<T> implements Comparable<agk<?>> {
   private final agl<T> a;
   private final int b;
   private final T c;
   private long d;

   protected agk(agl<T> $$0, int $$1, T $$2) {
      this.a = $$0;
      this.b = $$1;
      this.c = $$2;
   }

   public int a(agk<?> $$0) {
      int $$1 = Integer.compare(this.b, $$0.b);
      if ($$1 != 0) {
         return $$1;
      } else {
         int $$2 = Integer.compare(System.identityHashCode(this.a), System.identityHashCode($$0.a));
         return $$2 != 0 ? $$2 : this.a.a().compare(this.c, $$0.c);
      }
   }

   public boolean equals(Object $$0) {
      if (this == $$0) {
         return true;
      } else if (!($$0 instanceof agk)) {
         return false;
      } else {
         agk<?> $$1 = (agk)$$0;
         return this.b == $$1.b && Objects.equals(this.a, $$1.a) && Objects.equals(this.c, $$1.c);
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.a, this.b, this.c});
   }

   public String toString() {
      return "Ticket[" + this.a + " " + this.b + " (" + this.c + ")] at " + this.d;
   }

   public agl<T> a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   protected void a(long $$0) {
      this.d = $$0;
   }

   protected boolean b(long $$0) {
      long $$1 = this.a.b();
      return $$1 != 0L && $$0 - this.d > $$1;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((agk)var1);
   }
}
