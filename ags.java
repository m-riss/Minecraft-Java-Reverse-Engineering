import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ags implements agp {
   private final agp a;
   private final azc<Runnable> b;

   private ags(agp $$0, Executor $$1) {
      this.a = $$0;
      this.b = azc.a($$1, "progressListener");
   }

   public static ags a(agp $$0, Executor $$1) {
      ags $$2 = new ags($$0, $$1);
      $$2.a();
      return $$2;
   }

   public void a(cge $$0) {
      this.b.a((Object)(() -> {
         this.a.a($$0);
      }));
   }

   public void a(cge $$0, @Nullable cxn $$1) {
      this.b.a((Object)(() -> {
         this.a.a($$0, $$1);
      }));
   }

   public void a() {
      azc var10000 = this.b;
      agp var10001 = this.a;
      Objects.requireNonNull(var10001);
      var10000.a((Object)(var10001::a));
   }

   public void b() {
      azc var10000 = this.b;
      agp var10001 = this.a;
      Objects.requireNonNull(var10001);
      var10000.a((Object)(var10001::b));
   }
}
