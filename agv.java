import java.util.Objects;
import javax.annotation.Nullable;

public record agv(String b, rt c) {
   public static final agv a = a("");

   public agv(String $$0, rt $$1) {
      this.b = $$0;
      this.c = $$1;
   }

   public static agv a(String $$0) {
      return new agv($$0, rt.b);
   }

   public static agv b(String $$0) {
      return new agv($$0, rt.a);
   }

   @Nullable
   public String a() {
      return this.c.a(this.b);
   }

   public String b() {
      return (String)Objects.requireNonNullElse(this.a(), "");
   }

   public boolean c() {
      return !this.c.a();
   }

   public String d() {
      return this.b;
   }

   public rt e() {
      return this.c;
   }
}
