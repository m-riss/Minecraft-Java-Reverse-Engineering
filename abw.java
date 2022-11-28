import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

public class abw {
   private final Map<abb, abv> a = Maps.newHashMap();

   @Nullable
   public abv a(abb $$0) {
      return (abv)this.a.get($$0);
   }

   public abv a(abb $$0, rq $$1) {
      abv $$2 = new abv($$0, $$1);
      this.a.put($$0, $$2);
      return $$2;
   }

   public void a(abv $$0) {
      this.a.remove($$0.a());
   }

   public Collection<abb> a() {
      return this.a.keySet();
   }

   public Collection<abv> b() {
      return this.a.values();
   }

   public pj c() {
      pj $$0 = new pj();
      Iterator var2 = this.a.values().iterator();

      while(var2.hasNext()) {
         abv $$1 = (abv)var2.next();
         $$0.a((String)$$1.a().toString(), (qc)$$1.f());
      }

      return $$0;
   }

   public void a(pj $$0) {
      Iterator var2 = $$0.d().iterator();

      while(var2.hasNext()) {
         String $$1 = (String)var2.next();
         abb $$2 = new abb($$1);
         this.a.put($$2, abv.a($$0.p($$1), $$2));
      }

   }

   public void a(agh $$0) {
      Iterator var2 = this.a.values().iterator();

      while(var2.hasNext()) {
         abv $$1 = (abv)var2.next();
         $$1.c($$0);
      }

   }

   public void b(agh $$0) {
      Iterator var2 = this.a.values().iterator();

      while(var2.hasNext()) {
         abv $$1 = (abv)var2.next();
         $$1.d($$0);
      }

   }
}
