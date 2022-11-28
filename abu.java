import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public record abu(aid a, abk b, hn.a c, drw d) implements AutoCloseable {
   public abu(aid $$0, abk $$1, hn.a $$2, drw $$3) {
      this.a = $$0;
      this.b = $$1;
      this.c = $$2;
      this.d = $$3;
   }

   public static CompletableFuture<abu> a(abt.a $$0, abt.d<drw> $$1, Executor $$2, Executor $$3) {
      return abt.a($$0, $$1, abu::new, $$2, $$3);
   }

   public void close() {
      this.a.close();
   }

   public aid a() {
      return this.a;
   }

   public abk b() {
      return this.b;
   }

   public hn.a c() {
      return this.c;
   }

   public drw d() {
      return this.d;
   }
}
