import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.MapCodec;
import java.util.Optional;

public class aay<T> extends aat<T> {
   private final Optional<aax.a> b;
   private final hn c;
   private final DynamicOps<JsonElement> d;

   public static <T> aay<T> a(DynamicOps<T> $$0, hn $$1) {
      return new aay($$0, $$1, Optional.empty());
   }

   public static <T> aay<T> a(DynamicOps<T> $$0, hn.e $$1, aim $$2) {
      return a($$0, $$1, aaz.a($$2));
   }

   public static <T> aay<T> a(DynamicOps<T> $$0, hn.e $$1, aaz $$2) {
      aax $$3 = new aax($$2);
      aay<T> $$4 = new aay($$0, $$1, Optional.of($$3.a($$1)));
      hn.a($$1, $$4.b(), $$3);
      return $$4;
   }

   private aay(DynamicOps<T> $$0, hn $$1, Optional<aax.a> $$2) {
      super($$0);
      this.b = $$2;
      this.c = $$1;
      this.d = $$0 == JsonOps.INSTANCE ? this : new aay(JsonOps.INSTANCE, $$1, $$2);
   }

   public <E> Optional<? extends hm<E>> a(aba<? extends hm<? extends E>> $$0) {
      return this.c.c($$0);
   }

   public Optional<aax.a> a() {
      return this.b;
   }

   public DynamicOps<JsonElement> b() {
      return this.d;
   }

   public static <E> MapCodec<hm<E>> b(aba<? extends hm<? extends E>> $$0) {
      return alq.a(($$1) -> {
         if ($$1 instanceof aay) {
            aay<?> $$2 = (aay)$$1;
            return (DataResult)$$2.a($$0).map(($$0x) -> {
               return DataResult.success($$0x, $$0x.c());
            }).orElseGet(() -> {
               return DataResult.error("Unknown registry: " + $$0);
            });
         } else {
            return DataResult.error("Not a registry ops");
         }
      });
   }
}
