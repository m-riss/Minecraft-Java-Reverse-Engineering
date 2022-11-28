import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Lifecycle;
import java.util.Optional;

public final class aav<E> implements Codec<hc<E>> {
   private final aba<? extends hm<E>> a;
   private final Codec<E> b;
   private final boolean c;

   public static <E> aav<E> a(aba<? extends hm<E>> $$0, Codec<E> $$1) {
      return a($$0, $$1, true);
   }

   public static <E> aav<E> a(aba<? extends hm<E>> $$0, Codec<E> $$1, boolean $$2) {
      return new aav($$0, $$1, $$2);
   }

   private aav(aba<? extends hm<E>> $$0, Codec<E> $$1, boolean $$2) {
      this.a = $$0;
      this.b = $$1;
      this.c = $$2;
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
            }, ($$2x) -> {
               return this.b.encode($$2x, $$1, $$2);
            });
         }
      }

      return this.b.encode($$0.a(), $$1, $$2);
   }

   public <T> DataResult<Pair<hc<E>, T>> decode(DynamicOps<T> $$0, T $$1) {
      if ($$0 instanceof aay) {
         aay<?> $$2 = (aay)$$0;
         Optional<? extends hm<E>> $$3 = $$2.a(this.a);
         if ($$3.isEmpty()) {
            return DataResult.error("Registry does not exist: " + this.a);
         } else {
            hm<E> $$4 = (hm)$$3.get();
            DataResult<Pair<abb, T>> $$5 = abb.a.decode($$0, $$1);
            if ($$5.result().isEmpty()) {
               return !this.c ? DataResult.error("Inline definitions not allowed here") : this.b.decode($$0, $$1).map(($$0x) -> {
                  return $$0x.mapFirst(hc::a);
               });
            } else {
               Pair<abb, T> $$6 = (Pair)$$5.result().get();
               aba<E> $$7 = aba.a(this.a, (abb)$$6.getFirst());
               Optional<aax.a> $$8 = $$2.a();
               if ($$8.isPresent()) {
                  return ((aax.a)$$8.get()).a(this.a, this.b, $$7, $$2.b()).map(($$1x) -> {
                     return Pair.of($$1x, $$6.getSecond());
                  });
               } else {
                  DataResult<hc<E>> $$9 = $$4.d($$7);
                  return $$9.map(($$1x) -> {
                     return Pair.of($$1x, $$6.getSecond());
                  }).setLifecycle(Lifecycle.stable());
               }
            }
         }
      } else {
         return this.b.decode($$0, $$1).map(($$0x) -> {
            return $$0x.mapFirst(hc::a);
         });
      }
   }

   public String toString() {
      return "RegistryFileCodec[" + this.a + " " + this.b + "]";
   }

   // $FF: synthetic method
   public DataResult encode(Object var1, DynamicOps var2, Object var3) {
      return this.a((hc)var1, var2, var3);
   }
}
