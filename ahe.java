import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ahe {
   ahe a = new ahe() {
      public void a() {
      }

      public void b() {
      }

      public CompletableFuture<agv> a(String $$0) {
         return CompletableFuture.completedFuture(agv.a($$0));
      }

      public CompletableFuture<List<agv>> a(List<String> $$0) {
         return CompletableFuture.completedFuture((List)$$0.stream().map(agv::a).collect(ImmutableList.toImmutableList()));
      }
   };

   void a();

   void b();

   CompletableFuture<agv> a(String var1);

   CompletableFuture<List<agv>> a(List<String> var1);
}
