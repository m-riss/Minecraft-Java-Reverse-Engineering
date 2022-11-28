import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public abstract class ahi implements ahl {
   private static final Logger b = LogUtils.getLogger();
   protected final File a;

   public ahi(File $$0) {
      this.a = $$0;
   }

   private static String c(ahm $$0, abb $$1) {
      return String.format(Locale.ROOT, "%s/%s/%s", $$0.a(), $$1.b(), $$1.a());
   }

   protected static String a(File $$0, File $$1) {
      return $$0.toURI().relativize($$1.toURI()).getPath();
   }

   public InputStream a(ahm $$0, abb $$1) throws IOException {
      return this.a(c($$0, $$1));
   }

   public boolean b(ahm $$0, abb $$1) {
      return this.c(c($$0, $$1));
   }

   protected abstract InputStream a(String var1) throws IOException;

   public InputStream b(String $$0) throws IOException {
      if (!$$0.contains("/") && !$$0.contains("\\")) {
         return this.a($$0);
      } else {
         throw new IllegalArgumentException("Root resources can only be filenames, not paths (no / allowed!)");
      }
   }

   protected abstract boolean c(String var1);

   protected void d(String $$0) {
      b.warn("ResourcePack: ignored non-lowercase namespace: {} in {}", $$0, this.a);
   }

   @Nullable
   public <T> T a(ahp<T> $$0) throws IOException {
      InputStream $$1 = this.a("pack.mcmeta");

      Object var3;
      try {
         var3 = a($$0, $$1);
      } catch (Throwable var6) {
         if ($$1 != null) {
            try {
               $$1.close();
            } catch (Throwable var5) {
               var6.addSuppressed(var5);
            }
         }

         throw var6;
      }

      if ($$1 != null) {
         $$1.close();
      }

      return var3;
   }

   @Nullable
   public static <T> T a(ahp<T> $$0, InputStream $$1) {
      JsonObject $$6;
      try {
         BufferedReader $$2 = new BufferedReader(new InputStreamReader($$1, StandardCharsets.UTF_8));

         try {
            $$6 = alz.a((Reader)$$2);
         } catch (Throwable var8) {
            try {
               $$2.close();
            } catch (Throwable var6) {
               var8.addSuppressed(var6);
            }

            throw var8;
         }

         $$2.close();
      } catch (Exception var9) {
         b.error("Couldn't load {} metadata", $$0.a(), var9);
         return null;
      }

      if (!$$6.has($$0.a())) {
         return null;
      } else {
         try {
            return $$0.a(alz.t($$6, $$0.a()));
         } catch (Exception var7) {
            b.error("Couldn't load {} metadata", $$0.a(), var7);
            return null;
         }
      }
   }

   public String a() {
      return this.a.getName();
   }
}
