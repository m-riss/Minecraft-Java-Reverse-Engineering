import com.google.common.collect.Lists;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

public class abe extends IOException {
   private final List<abe.a> a = Lists.newArrayList();
   private final String b;

   public abe(String $$0) {
      this.a.add(new abe.a());
      this.b = $$0;
   }

   public abe(String $$0, Throwable $$1) {
      super($$1);
      this.a.add(new abe.a());
      this.b = $$0;
   }

   public void a(String $$0) {
      ((abe.a)this.a.get(0)).a($$0);
   }

   public void b(String $$0) {
      ((abe.a)this.a.get(0)).a = $$0;
      this.a.add(0, new abe.a());
   }

   public String getMessage() {
      Object var10000 = this.a.get(this.a.size() - 1);
      return "Invalid " + var10000 + ": " + this.b;
   }

   public static abe a(Exception $$0) {
      if ($$0 instanceof abe) {
         return (abe)$$0;
      } else {
         String $$1 = $$0.getMessage();
         if ($$0 instanceof FileNotFoundException) {
            $$1 = "File not found";
         }

         return new abe($$1, $$0);
      }
   }

   public static class a {
      @Nullable
      String a;
      private final List<String> b = Lists.newArrayList();

      a() {
      }

      void a(String $$0) {
         this.b.add(0, $$0);
      }

      @Nullable
      public String a() {
         return this.a;
      }

      public String b() {
         return StringUtils.join(this.b, "->");
      }

      public String toString() {
         if (this.a != null) {
            if (this.b.isEmpty()) {
               return this.a;
            } else {
               String var10000 = this.a;
               return var10000 + " " + this.b();
            }
         } else {
            return this.b.isEmpty() ? "(Unknown file)" : "(Unknown file) " + this.b();
         }
      }
   }
}
