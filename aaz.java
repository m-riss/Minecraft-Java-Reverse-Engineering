import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.DataResult.PartialResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import org.slf4j.Logger;

public interface aaz {
   <E> Map<aba<E>, aaz.a<E>> a(aba<? extends hm<E>> var1);

   <E> Optional<aaz.a<E>> b(aba<E> var1);

   static aaz a(final aim $$0) {
      return new aaz() {
         private static final String b = ".json";

         public <E> Map<aba<E>, aaz.a<E>> a(aba<? extends hm<E>> $$0x) {
            String $$1 = a($$0x.a());
            Map<aba<E>, aaz.a<E>> $$2 = Maps.newHashMap();
            $$0.b($$1, ($$0xx) -> {
               return $$0xx.a().endsWith(".json");
            }).forEach(($$3, $$4) -> {
               String $$5 = $$3.a();
               String $$6 = $$5.substring($$1.length() + 1, $$5.length() - ".json".length());
               aba<E> $$7 = aba.a($$0x, new abb($$3.b(), $$6));
               $$2.put($$7, ($$2x, $$3x) -> {
                  try {
                     BufferedReader $$4x = $$4.c();

                     DataResult var6;
                     try {
                        var6 = this.a($$2x, $$3x, $$4x);
                     } catch (Throwable var9) {
                        if ($$4x != null) {
                           try {
                              $$4x.close();
                           } catch (Throwable var8) {
                              var9.addSuppressed(var8);
                           }
                        }

                        throw var9;
                     }

                     if ($$4x != null) {
                        $$4x.close();
                     }

                     return var6;
                  } catch (JsonIOException | JsonSyntaxException | IOException var10) {
                     return DataResult.error("Failed to parse " + $$3 + " file: " + var10.getMessage());
                  }
               });
            });
            return $$2;
         }

         public <E> Optional<aaz.a<E>> b(aba<E> $$0x) {
            abb $$1 = c($$0x);
            return $$0.getResource($$1).map(($$1x) -> {
               return ($$2, $$3) -> {
                  try {
                     BufferedReader $$4 = $$1x.c();

                     DataResult var6;
                     try {
                        var6 = this.a($$2, $$3, $$4);
                     } catch (Throwable var9) {
                        if ($$4 != null) {
                           try {
                              $$4.close();
                           } catch (Throwable var8) {
                              var9.addSuppressed(var8);
                           }
                        }

                        throw var9;
                     }

                     if ($$4 != null) {
                        $$4.close();
                     }

                     return var6;
                  } catch (JsonIOException | JsonSyntaxException | IOException var10) {
                     return DataResult.error("Failed to parse " + $$1 + " file: " + var10.getMessage());
                  }
               };
            });
         }

         private <E> DataResult<aaz.c<E>> a(DynamicOps<JsonElement> $$0x, Decoder<E> $$1, Reader $$2) throws IOException {
            JsonElement $$3 = JsonParser.parseReader($$2);
            return $$1.parse($$0x, $$3).map(aaz.c::a);
         }

         private static String a(abb $$0x) {
            return $$0x.a();
         }

         private static <E> abb c(aba<E> $$0x) {
            String var10002 = $$0x.a().b();
            String var10003 = a($$0x.b());
            return new abb(var10002, var10003 + "/" + $$0x.a().a() + ".json");
         }

         public String toString() {
            return "ResourceAccess[" + $$0 + "]";
         }
      };
   }

   public static final class b implements aaz {
      private static final Logger a = LogUtils.getLogger();
      private final Map<aba<?>, aaz.b.a> b = Maps.newIdentityHashMap();

      public <E> void a(hn $$0, aba<E> $$1, Encoder<E> $$2, int $$3, E $$4, Lifecycle $$5) {
         DataResult<JsonElement> $$6 = $$2.encodeStart(aay.a((DynamicOps)JsonOps.INSTANCE, (hn)$$0), $$4);
         Optional<PartialResult<JsonElement>> $$7 = $$6.error();
         if ($$7.isPresent()) {
            a.error("Error adding element: {}", ((PartialResult)$$7.get()).message());
         } else {
            this.b.put($$1, new aaz.b.a((JsonElement)$$6.result().get(), $$3, $$5));
         }

      }

      public <E> Map<aba<E>, aaz.a<E>> a(aba<? extends hm<E>> $$0) {
         return (Map)this.b.entrySet().stream().filter(($$1) -> {
            return ((aba)$$1.getKey()).b($$0);
         }).collect(Collectors.toMap(($$0x) -> {
            return (aba)$$0x.getKey();
         }, ($$0x) -> {
            aaz.b.a var10000 = (aaz.b.a)$$0x.getValue();
            Objects.requireNonNull(var10000);
            return var10000::a;
         }));
      }

      public <E> Optional<aaz.a<E>> b(aba<E> $$0) {
         aaz.b.a $$1 = (aaz.b.a)this.b.get($$0);
         if ($$1 == null) {
            DataResult<aaz.c<E>> $$2 = DataResult.error("Unknown element: " + $$0);
            return Optional.of(($$1x, $$2x) -> {
               return $$2;
            });
         } else {
            Objects.requireNonNull($$1);
            return Optional.of($$1::a);
         }
      }

      private static record a(JsonElement a, int b, Lifecycle c) {
         a(JsonElement $$0, int $$1, Lifecycle $$2) {
            this.a = $$0;
            this.b = $$1;
            this.c = $$2;
         }

         public <E> DataResult<aaz.c<E>> a(DynamicOps<JsonElement> $$0, Decoder<E> $$1) {
            return $$1.parse($$0, this.a).setLifecycle(this.c).map(($$0x) -> {
               return aaz.c.a($$0x, this.b);
            });
         }

         public JsonElement a() {
            return this.a;
         }

         public int b() {
            return this.b;
         }

         public Lifecycle c() {
            return this.c;
         }
      }
   }

   @FunctionalInterface
   public interface a<E> {
      DataResult<aaz.c<E>> parseElement(DynamicOps<JsonElement> var1, Decoder<E> var2);
   }

   public static record c<E>(E a, OptionalInt b) {
      public c(E $$0, OptionalInt $$1) {
         this.a = $$0;
         this.b = $$1;
      }

      public static <E> aaz.c<E> a(E $$0) {
         return new aaz.c($$0, OptionalInt.empty());
      }

      public static <E> aaz.c<E> a(E $$0, int $$1) {
         return new aaz.c($$0, OptionalInt.of($$1));
      }

      public E a() {
         return this.a;
      }

      public OptionalInt b() {
         return this.b;
      }
   }
}
