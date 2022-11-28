import java.nio.file.Path;
import java.util.function.UnaryOperator;

public class afj {
   private final Path a;
   private afi b;

   public afj(Path $$0) {
      this.a = $$0;
      this.b = afi.a($$0);
   }

   public afi a() {
      return this.b;
   }

   public void b() {
      this.b.c(this.a);
   }

   public afj a(UnaryOperator<afi> $$0) {
      (this.b = (afi)$$0.apply(this.b)).c(this.a);
      return this;
   }
}
