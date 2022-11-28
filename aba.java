import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class aba<T> {
   private static final Map<String, aba<?>> a = Collections.synchronizedMap(Maps.newIdentityHashMap());
   private final abb b;
   private final abb c;

   public static <T> Codec<aba<T>> a(aba<? extends hm<T>> $$0) {
      return abb.a.xmap(($$1) -> {
         return a($$0, $$1);
      }, aba::a);
   }

   public static <T> aba<T> a(aba<? extends hm<T>> $$0, abb $$1) {
      return a($$0.c, $$1);
   }

   public static <T> aba<hm<T>> a(abb $$0) {
      return a(hm.b, $$0);
   }

   private static <T> aba<T> a(abb $$0, abb $$1) {
      String $$2 = ($$0 + ":" + $$1).intern();
      return (aba)a.computeIfAbsent($$2, ($$2x) -> {
         return new aba($$0, $$1);
      });
   }

   private aba(abb $$0, abb $$1) {
      this.b = $$0;
      this.c = $$1;
   }

   public String toString() {
      return "ResourceKey[" + this.b + " / " + this.c + "]";
   }

   public boolean b(aba<? extends hm<?>> $$0) {
      return this.b.equals($$0.a());
   }

   public <E> Optional<aba<E>> c(aba<? extends hm<E>> $$0) {
      return this.b($$0) ? Optional.of(this) : Optional.empty();
   }

   public abb a() {
      return this.c;
   }

   public abb b() {
      return this.b;
   }
}
