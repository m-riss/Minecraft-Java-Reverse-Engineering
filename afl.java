import com.google.common.base.MoreObjects;
import com.mojang.logging.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public abstract class afl<T extends afl<T>> {
   private static final Logger a = LogUtils.getLogger();
   protected final Properties X;

   public afl(Properties $$0) {
      this.X = $$0;
   }

   public static Properties b(Path $$0) {
      Properties $$1 = new Properties();

      try {
         InputStream $$2 = Files.newInputStream($$0);

         try {
            $$1.load($$2);
         } catch (Throwable var6) {
            if ($$2 != null) {
               try {
                  $$2.close();
               } catch (Throwable var5) {
                  var6.addSuppressed(var5);
               }
            }

            throw var6;
         }

         if ($$2 != null) {
            $$2.close();
         }
      } catch (IOException var7) {
         a.error("Failed to load properties from file: {}", $$0);
      }

      return $$1;
   }

   public void c(Path $$0) {
      try {
         OutputStream $$1 = Files.newOutputStream($$0);

         try {
            this.X.store($$1, "Minecraft server properties");
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
      } catch (IOException var7) {
         a.error("Failed to store properties to file: {}", $$0);
      }

   }

   private static <V extends Number> Function<String, V> a(Function<String, V> $$0) {
      return ($$1) -> {
         try {
            return (Number)$$0.apply($$1);
         } catch (NumberFormatException var3) {
            return null;
         }
      };
   }

   protected static <V> Function<String, V> a(IntFunction<V> $$0, Function<String, V> $$1) {
      return ($$2) -> {
         try {
            return $$0.apply(Integer.parseInt($$2));
         } catch (NumberFormatException var4) {
            return $$1.apply($$2);
         }
      };
   }

   @Nullable
   private String c(String $$0) {
      return (String)this.X.get($$0);
   }

   @Nullable
   protected <V> V a(String $$0, Function<String, V> $$1) {
      String $$2 = this.c($$0);
      if ($$2 == null) {
         return null;
      } else {
         this.X.remove($$0);
         return $$1.apply($$2);
      }
   }

   protected <V> V a(String $$0, Function<String, V> $$1, Function<V, String> $$2, V $$3) {
      String $$4 = this.c($$0);
      V $$5 = MoreObjects.firstNonNull($$4 != null ? $$1.apply($$4) : null, $$3);
      this.X.put($$0, $$2.apply($$5));
      return $$5;
   }

   protected <V> afl<T>.a<V> b(String $$0, Function<String, V> $$1, Function<V, String> $$2, V $$3) {
      String $$4 = this.c($$0);
      V $$5 = MoreObjects.firstNonNull($$4 != null ? $$1.apply($$4) : null, $$3);
      this.X.put($$0, $$2.apply($$5));
      return new afl.a($$0, $$5, $$2);
   }

   protected <V> V a(String $$0, Function<String, V> $$1, UnaryOperator<V> $$2, Function<V, String> $$3, V $$4) {
      return this.a($$0, ($$2x) -> {
         V $$3 = $$1.apply($$2x);
         return $$3 != null ? $$2.apply($$3) : null;
      }, $$3, $$4);
   }

   protected <V> V a(String $$0, Function<String, V> $$1, V $$2) {
      return this.a($$0, $$1, Objects::toString, $$2);
   }

   protected <V> afl<T>.a<V> b(String $$0, Function<String, V> $$1, V $$2) {
      return this.b($$0, $$1, Objects::toString, $$2);
   }

   protected String a(String $$0, String $$1) {
      return (String)this.a($$0, Function.identity(), Function.identity(), $$1);
   }

   @Nullable
   protected String a(String $$0) {
      return (String)this.a($$0, Function.identity());
   }

   protected int a(String $$0, int $$1) {
      return (Integer)this.a((String)$$0, (Function)a(Integer::parseInt), (Object)$$1);
   }

   protected afl<T>.a<Integer> b(String $$0, int $$1) {
      return this.b($$0, a(Integer::parseInt), $$1);
   }

   protected int a(String $$0, UnaryOperator<Integer> $$1, int $$2) {
      return (Integer)this.a($$0, a(Integer::parseInt), $$1, Objects::toString, $$2);
   }

   protected long a(String $$0, long $$1) {
      return (Long)this.a((String)$$0, (Function)a(Long::parseLong), (Object)$$1);
   }

   protected boolean a(String $$0, boolean $$1) {
      return (Boolean)this.a((String)$$0, (Function)(Boolean::valueOf), (Object)$$1);
   }

   protected afl<T>.a<Boolean> b(String $$0, boolean $$1) {
      return this.b($$0, Boolean::valueOf, $$1);
   }

   @Nullable
   protected Boolean b(String $$0) {
      return (Boolean)this.a($$0, Boolean::valueOf);
   }

   protected Properties a() {
      Properties $$0 = new Properties();
      $$0.putAll(this.X);
      return $$0;
   }

   protected abstract T b(hn var1, Properties var2);

   public class a<V> implements Supplier<V> {
      private final String b;
      private final V c;
      private final Function<V, String> d;

      a(String $$1, V $$2, Function<V, String> $$3) {
         this.b = $$1;
         this.c = $$2;
         this.d = $$3;
      }

      public V get() {
         return this.c;
      }

      public T a(hn $$0, V $$1) {
         Properties $$2 = afl.this.a();
         $$2.put(this.b, this.d.apply($$1));
         return afl.this.b($$0, $$2);
      }
   }
}
