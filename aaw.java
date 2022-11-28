import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Lifecycle;
import java.util.Optional;

public final class aaw<E> implements Codec<hc<E>> {
   private final aba<? extends hm<E>> a;

   public static <E> aaw<E> a(aba<? extends hm<E>> $$0) {
      return new aaw($$0);
   }

   private aaw(aba<? extends hm<E>> $$0) {
      this.a = $$0;
   }

   public <T> DataResult<T> a(hc<E> $$0, DynamicOps<T> $$1, T $$2) {
      if ($$1 instanceof aay) {
         aay<?> $$3 = (aay)$$1;
         Optional<? extends hm<E>> $$4 = $$3.a(this.a);
         if ($$4.isPresent()) {
            if (!$$0.a((hm)$$4.get())) {
               return DataResult.error("Element " + $$0 + " is not valid in current registry set");
            }

            return (DataResult)$$0.d().map(($$2x) -> {
               return abb.a.encode($$2x.a(), $$1, $$2);
            }, ($$0x) -> {
               return DataResult.error("Elements from registry " + this.a + " can't be serialized to a value");
            });
         }
      }

      return DataResult.error("Can't access registry " + this.a);
   }

   public <T> DataResult<Pair<hc<E>, T>> decode(DynamicOps<T> $$0, T $$1) {
      if ($$0 instanceof aay) {
         aay<?> $$2 = (aay)$$0;
         Optional<? extends hm<E>> $$3 = $$2.a(this.a);
         if ($$3.isPresent()) {
            return abb.a.decode($$0, $$1).flatMap(($$1x) -> {
               abb $$2 = (abb)$$1x.getFirst();
               DataResult<hc<E>> $$3x = ((hm)$$3.get()).d(aba.a(this.a, $$2));
               return $$3x.map(($$1) -> {
                  return Pair.of($$1, $$1x.getSecond());
               }).setLifecycle(Lifecycle.stable());
            });
         }
      }

      return DataResult.error("Can't access registry " + this.a);
   }

   public String toString() {
      return "RegistryFixedCodec[" + this.a + "]";
   }

   // $FF: synthetic method
   public DataResult encode(Object var1, DynamicOps var2, Object var3) {
      return this.a((hc)var1, var2, var3);
   }
}
