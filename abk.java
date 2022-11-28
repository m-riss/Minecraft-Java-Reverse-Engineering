import com.mojang.logging.LogUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import org.slf4j.Logger;

public class abk {
   private static final Logger a = LogUtils.getLogger();
   private static final CompletableFuture<anf> b;
   private final dl c;
   private final ds d;
   private final cdq e = new cdq();
   private final alb f;
   private final dsi g = new dsi();
   private final dsh h;
   private final dsc i;
   private final abm j;
   private final abn k;

   public abk(hn.a $$0, ds.a $$1, int $$2) {
      this.h = new dsh(this.g);
      this.i = new dsc(this.g, this.h);
      this.j = new abm(this.g);
      this.f = new alb($$0);
      this.c = new dl($$0);
      this.d = new ds($$1, this.c);
      this.c.a(dl.a.a);
      this.k = new abn($$2, this.d.a());
   }

   public abn a() {
      return this.k;
   }

   public dsi b() {
      return this.g;
   }

   public dsh c() {
      return this.h;
   }

   public dsc d() {
      return this.i;
   }

   public cdq e() {
      return this.e;
   }

   public ds f() {
      return this.d;
   }

   public abm g() {
      return this.j;
   }

   public List<aig> h() {
      return List.of(this.f, this.g, this.e, this.h, this.i, this.k, this.j);
   }

   public static CompletableFuture<abk> a(aim $$0, hn.a $$1, ds.a $$2, int $$3, Executor $$4, Executor $$5) {
      abk $$6 = new abk($$1, $$2, $$3);
      return ais.a($$0, $$6.h(), $$4, $$5, b, a.isDebugEnabled()).a().whenComplete(($$1x, $$2x) -> {
         $$6.c.a(dl.a.c);
      }).thenApply(($$1x) -> {
         return $$6;
      });
   }

   public void a(hn $$0) {
      this.f.a().forEach(($$1) -> {
         a($$0, $$1);
      });
      cju.a();
   }

   private static <T> void a(hn $$0, alb.a<T> $$1) {
      aba<? extends hm<T>> $$2 = $$1.a();
      Map<akz<T>, List<hc<T>>> $$3 = (Map)$$1.b().entrySet().stream().collect(Collectors.toUnmodifiableMap(($$1x) -> {
         return akz.a($$2, (abb)$$1x.getKey());
      }, ($$0x) -> {
         return List.copyOf((Collection)$$0x.getValue());
      }));
      $$0.d($$2).a($$3);
   }

   static {
      b = CompletableFuture.completedFuture(anf.a);
   }
}
