import java.util.Comparator;

public class agl<T> {
   private final String i;
   private final Comparator<T> j;
   private final long k;
   public static final agl<anf> a = a("start", ($$0, $$1) -> {
      return 0;
   });
   public static final agl<anf> b = a("dragon", ($$0, $$1) -> {
      return 0;
   });
   public static final agl<cge> c = a("player", Comparator.comparingLong(cge::a));
   public static final agl<cge> d = a("forced", Comparator.comparingLong(cge::a));
   public static final agl<cge> e = a("light", Comparator.comparingLong(cge::a));
   public static final agl<gt> f = a("portal", hs::i, 300);
   public static final agl<Integer> g = a("post_teleport", Integer::compareTo, 5);
   public static final agl<cge> h = a("unknown", Comparator.comparingLong(cge::a), 1);

   public static <T> agl<T> a(String $$0, Comparator<T> $$1) {
      return new agl($$0, $$1, 0L);
   }

   public static <T> agl<T> a(String $$0, Comparator<T> $$1, int $$2) {
      return new agl($$0, $$1, (long)$$2);
   }

   protected agl(String $$0, Comparator<T> $$1, long $$2) {
      this.i = $$0;
      this.j = $$1;
      this.k = $$2;
   }

   public String toString() {
      return this.i;
   }

   public Comparator<T> a() {
      return this.j;
   }

   public long b() {
      return this.k;
   }
}
