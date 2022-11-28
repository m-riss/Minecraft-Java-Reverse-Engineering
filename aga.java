import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import java.util.Set;

public final class aga {
   private final Object2BooleanMap<agh> a = new Object2BooleanOpenHashMap();

   public Set<agh> a(long $$0) {
      return this.a.keySet();
   }

   public void a(long $$0, agh $$1, boolean $$2) {
      this.a.put($$1, $$2);
   }

   public void a(long $$0, agh $$1) {
      this.a.removeBoolean($$1);
   }

   public void a(agh $$0) {
      this.a.replace($$0, true);
   }

   public void b(agh $$0) {
      this.a.replace($$0, false);
   }

   public boolean c(agh $$0) {
      return this.a.getOrDefault($$0, true);
   }

   public boolean d(agh $$0) {
      return this.a.getBoolean($$0);
   }

   public void a(long $$0, long $$1, agh $$2) {
   }
}
