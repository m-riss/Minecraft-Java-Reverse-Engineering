import java.util.Optional;

public interface aak<T> {
   void a(qx var1, T var2);

   T a(qx var1);

   default aaj<T> a(int $$0) {
      return new aaj($$0, this);
   }

   T a(T var1);

   static <T> aak<T> a(final qx.b<T> $$0, final qx.a<T> $$1) {
      return new aak.a<T>() {
         public void a(qx $$0x, T $$1x) {
            $$0.accept($$0x, $$1x);
         }

         public T a(qx $$0x) {
            return $$1.apply($$0x);
         }
      };
   }

   static <T> aak<Optional<T>> b(qx.b<T> $$0, qx.a<T> $$1) {
      return a($$0.asOptional(), $$1.asOptional());
   }

   static <T extends Enum<T>> aak<T> a(Class<T> $$0) {
      return a(qx::a, ($$1) -> {
         return $$1.a($$0);
      });
   }

   static <T> aak<T> a(hf<T> $$0) {
      return a(($$1, $$2) -> {
         $$1.a($$0, $$2);
      }, ($$1) -> {
         return $$1.a($$0);
      });
   }

   public interface a<T> extends aak<T> {
      default T a(T $$0) {
         return $$0;
      }
   }
}
