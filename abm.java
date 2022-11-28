import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public class abm extends aiq {
   private static final Logger a = LogUtils.getLogger();
   private static final Gson b = (new GsonBuilder()).create();
   private ag c = new ag();
   private final dsi d;

   public abm(dsi $$0) {
      super(b, "advancements");
      this.d = $$0;
   }

   protected void a(Map<abb, JsonElement> $$0, aim $$1, awz $$2) {
      Map<abb, af.a> $$3 = Maps.newHashMap();
      $$0.forEach(($$1x, $$2x) -> {
         try {
            JsonObject $$3x = alz.m($$2x, "advancement");
            af.a $$4 = af.a.a($$3x, new be($$1x, this.d));
            $$3.put($$1x, $$4);
         } catch (Exception var6) {
            a.error("Parsing error loading custom advancement {}: {}", $$1x, var6.getMessage());
         }

      });
      ag $$4 = new ag();
      $$4.a((Map)$$3);
      Iterator var6 = $$4.b().iterator();

      while(var6.hasNext()) {
         af $$5 = (af)var6.next();
         if ($$5.c() != null) {
            ar.a($$5);
         }
      }

      this.c = $$4;
   }

   @Nullable
   public af a(abb $$0) {
      return this.c.a($$0);
   }

   public Collection<af> a() {
      return this.c.c();
   }
}
