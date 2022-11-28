import com.mojang.logging.LogUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import org.slf4j.Logger;

public class abh {
   private static final Logger a = LogUtils.getLogger();
   private final Path b;
   private final boolean c;

   public abh(Path $$0) {
      this.b = $$0;
      this.c = ab.aL || this.b();
   }

   private boolean b() {
      try {
         InputStream $$0 = Files.newInputStream(this.b);

         boolean var3;
         try {
            Properties $$1 = new Properties();
            $$1.load($$0);
            var3 = Boolean.parseBoolean($$1.getProperty("eula", "false"));
         } catch (Throwable var5) {
            if ($$0 != null) {
               try {
                  $$0.close();
               } catch (Throwable var4) {
                  var5.addSuppressed(var4);
               }
            }

            throw var5;
         }

         if ($$0 != null) {
            $$0.close();
         }

         return var3;
      } catch (Exception var6) {
         a.warn("Failed to load {}", this.b);
         this.c();
         return false;
      }
   }

   public boolean a() {
      return this.c;
   }

   private void c() {
      if (!ab.aL) {
         try {
            OutputStream $$0 = Files.newOutputStream(this.b);

            try {
               Properties $$1 = new Properties();
               $$1.setProperty("eula", "false");
               $$1.store($$0, "By changing the setting below to TRUE you are indicating your agreement to our EULA (https://aka.ms/MinecraftEULA).");
            } catch (Throwable var5) {
               if ($$0 != null) {
                  try {
                     $$0.close();
                  } catch (Throwable var4) {
                     var5.addSuppressed(var4);
                  }
               }

               throw var5;
            }

            if ($$0 != null) {
               $$0.close();
            }
         } catch (Exception var6) {
            a.warn("Failed to save {}", this.b, var6);
         }

      }
   }
}
