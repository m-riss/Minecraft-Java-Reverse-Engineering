import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class aad implements tc<aab> {
   private static final Gson a = (new GsonBuilder()).registerTypeAdapter(aae.c.class, new aae.c.a()).registerTypeAdapter(aae.a.class, new aae.a.a()).registerTypeAdapter(aae.class, new aae.b()).registerTypeHierarchyAdapter(rq.class, new rq.a()).registerTypeHierarchyAdapter(sj.class, new sj.b()).registerTypeAdapterFactory(new amf()).create();
   private final aae b;

   public aad(aae $$0) {
      this.b = $$0;
   }

   public aad(qx $$0) {
      this.b = (aae)alz.a(a, $$0.e(32767), aae.class);
   }

   public void a(qx $$0) {
      $$0.a(a.toJson(this.b));
   }

   public void a(aab $$0) {
      $$0.a(this);
   }

   public aae b() {
      return this.b;
   }
}
