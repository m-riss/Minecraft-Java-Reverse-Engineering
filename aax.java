import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Lifecycle;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

public class aax {
   private final aaz a;
   private final Map<aba<? extends hm<?>>, aax.b<?>> b = new IdentityHashMap();

   aax(aaz $$0) {
      this.a = $$0;
   }

   public <E> DataResult<? extends hm<E>> a(ht<E> $$0, aba<? extends hm<E>> $$1, Codec<E> $$2, DynamicOps<JsonElement> $$3) {
      Map<aba<E>, aaz.a<E>> $$4 = this.a.a($$1);
      DataResult<ht<E>> $$5 = DataResult.success($$0, Lifecycle.stable());

      Entry $$6;
      for(Iterator var7 = $$4.entrySet().iterator(); var7.hasNext(); $$5 = $$5.flatMap(($$4x) -> {
         return this.a($$4x, $$1, $$2, (aba)$$6.getKey(), Optional.of((aaz.a)$$6.getValue()), $$3).map(($$1x) -> {
            return $$4x;
         });
      })) {
         $$6 = (Entry)var7.next();
      }

      return $$5.setPartial($$0);
   }

   <E> DataResult<hc<E>> a(ht<E> $$0, aba<? extends hm<E>> $$1, Codec<E> $$2, aba<E> $$3, DynamicOps<JsonElement> $$4) {
      Optional<aaz.a<E>> $$5 = this.a.b($$3);
      return this.a($$0, $$1, $$2, $$3, $$5, $$4);
   }

   private <E> DataResult<hc<E>> a(ht<E> $$0, aba<? extends hm<E>> $$1, Codec<E> $$2, aba<E> $$3, Optional<aaz.a<E>> $$4, DynamicOps<JsonElement> $$5) {
      aax.b<E> $$6 = this.a($$1);
      DataResult<hc<E>> $$7 = (DataResult)$$6.a.get($$3);
      if ($$7 != null) {
         return $$7;
      } else {
         hc<E> $$8 = $$0.c($$3);
         $$6.a.put($$3, DataResult.success($$8));
         DataResult $$14;
         if ($$4.isEmpty()) {
            if ($$0.e($$3)) {
               $$14 = DataResult.success($$8, Lifecycle.stable());
            } else {
               $$14 = DataResult.error("Missing referenced custom/removed registry entry for registry " + $$1 + " named " + $$3.a());
            }
         } else {
            DataResult<aaz.c<E>> $$11 = ((aaz.a)$$4.get()).parseElement($$5, $$2);
            Optional<aaz.c<E>> $$12 = $$11.result();
            if ($$12.isPresent()) {
               aaz.c<E> $$13 = (aaz.c)$$12.get();
               $$0.a($$13.b(), $$3, $$13.a(), $$11.lifecycle());
            }

            $$14 = $$11.map(($$1x) -> {
               return $$8;
            });
         }

         $$6.a.put($$3, $$14);
         return $$14;
      }
   }

   private <E> aax.b<E> a(aba<? extends hm<E>> $$0) {
      return (aax.b)this.b.computeIfAbsent($$0, ($$0x) -> {
         return new aax.b();
      });
   }

   public aax.a a(hn.e $$0) {
      return new aax.a($$0, this);
   }

   static final class b<E> {
      final Map<aba<E>, DataResult<hc<E>>> a = Maps.newIdentityHashMap();
   }

   public static record a(hn.e a, aax b) {
      public a(hn.e $$0, aax $$1) {
         this.a = $$0;
         this.b = $$1;
      }

      public <E> DataResult<? extends hm<E>> a(aba<? extends hm<E>> $$0, Codec<E> $$1, DynamicOps<JsonElement> $$2) {
         ht<E> $$3 = this.a.g($$0);
         return this.b.a($$3, $$0, $$1, $$2);
      }

      public <E> DataResult<hc<E>> a(aba<? extends hm<E>> $$0, Codec<E> $$1, aba<E> $$2, DynamicOps<JsonElement> $$3) {
         ht<E> $$4 = this.a.g($$0);
         return this.b.a($$4, $$0, $$1, $$2, $$3);
      }

      public hn.e a() {
         return this.a;
      }

      public aax b() {
         return this.b;
      }
   }
}
