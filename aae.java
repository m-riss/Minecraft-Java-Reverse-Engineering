import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.GameProfile;
import java.lang.reflect.Type;
import java.util.UUID;
import javax.annotation.Nullable;

public class aae {
   public static final int a = 64;
   public static final int b = 64;
   @Nullable
   private rq c;
   @Nullable
   private aae.a d;
   @Nullable
   private aae.c e;
   @Nullable
   private String f;
   private boolean g;
   private boolean h;

   @Nullable
   public rq a() {
      return this.c;
   }

   public void a(rq $$0) {
      this.c = $$0;
   }

   @Nullable
   public aae.a b() {
      return this.d;
   }

   public void a(aae.a $$0) {
      this.d = $$0;
   }

   @Nullable
   public aae.c c() {
      return this.e;
   }

   public void a(aae.c $$0) {
      this.e = $$0;
   }

   public void a(String $$0) {
      this.f = $$0;
   }

   @Nullable
   public String d() {
      return this.f;
   }

   public void a(boolean $$0) {
      this.g = $$0;
   }

   public boolean e() {
      return this.g;
   }

   public void b(boolean $$0) {
      this.h = $$0;
   }

   public boolean f() {
      return this.h;
   }

   public static class a {
      private final int a;
      private final int b;
      @Nullable
      private GameProfile[] c;

      public a(int $$0, int $$1) {
         this.a = $$0;
         this.b = $$1;
      }

      public int a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      @Nullable
      public GameProfile[] c() {
         return this.c;
      }

      public void a(GameProfile[] $$0) {
         this.c = $$0;
      }

      public static class a implements JsonDeserializer<aae.a>, JsonSerializer<aae.a> {
         public aae.a a(JsonElement $$0, Type $$1, JsonDeserializationContext $$2) throws JsonParseException {
            JsonObject $$3 = alz.m($$0, "players");
            aae.a $$4 = new aae.a(alz.n($$3, "max"), alz.n($$3, "online"));
            if (alz.d($$3, "sample")) {
               JsonArray $$5 = alz.u($$3, "sample");
               if ($$5.size() > 0) {
                  GameProfile[] $$6 = new GameProfile[$$5.size()];

                  for(int $$7 = 0; $$7 < $$6.length; ++$$7) {
                     JsonObject $$8 = alz.m($$5.get($$7), "player[" + $$7 + "]");
                     String $$9 = alz.h($$8, "id");
                     $$6[$$7] = new GameProfile(UUID.fromString($$9), alz.h($$8, "name"));
                  }

                  $$4.a($$6);
               }
            }

            return $$4;
         }

         public JsonElement a(aae.a $$0, Type $$1, JsonSerializationContext $$2) {
            JsonObject $$3 = new JsonObject();
            $$3.addProperty("max", $$0.a());
            $$3.addProperty("online", $$0.b());
            GameProfile[] $$4 = $$0.c();
            if ($$4 != null && $$4.length > 0) {
               JsonArray $$5 = new JsonArray();

               for(int $$6 = 0; $$6 < $$4.length; ++$$6) {
                  JsonObject $$7 = new JsonObject();
                  UUID $$8 = $$4[$$6].getId();
                  $$7.addProperty("id", $$8 == null ? "" : $$8.toString());
                  $$7.addProperty("name", $$4[$$6].getName());
                  $$5.add($$7);
               }

               $$3.add("sample", $$5);
            }

            return $$3;
         }

         // $FF: synthetic method
         public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
            return this.a((aae.a)var1, var2, var3);
         }

         // $FF: synthetic method
         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }
      }
   }

   public static class c {
      private final String a;
      private final int b;

      public c(String $$0, int $$1) {
         this.a = $$0;
         this.b = $$1;
      }

      public String a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      public static class a implements JsonDeserializer<aae.c>, JsonSerializer<aae.c> {
         public aae.c a(JsonElement $$0, Type $$1, JsonDeserializationContext $$2) throws JsonParseException {
            JsonObject $$3 = alz.m($$0, "version");
            return new aae.c(alz.h($$3, "name"), alz.n($$3, "protocol"));
         }

         public JsonElement a(aae.c $$0, Type $$1, JsonSerializationContext $$2) {
            JsonObject $$3 = new JsonObject();
            $$3.addProperty("name", $$0.a());
            $$3.addProperty("protocol", $$0.b());
            return $$3;
         }

         // $FF: synthetic method
         public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
            return this.a((aae.c)var1, var2, var3);
         }

         // $FF: synthetic method
         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }
      }
   }

   public static class b implements JsonDeserializer<aae>, JsonSerializer<aae> {
      public aae a(JsonElement $$0, Type $$1, JsonDeserializationContext $$2) throws JsonParseException {
         JsonObject $$3 = alz.m($$0, "status");
         aae $$4 = new aae();
         if ($$3.has("description")) {
            $$4.a((rq)$$2.deserialize($$3.get("description"), rq.class));
         }

         if ($$3.has("players")) {
            $$4.a((aae.a)$$2.deserialize($$3.get("players"), aae.a.class));
         }

         if ($$3.has("version")) {
            $$4.a((aae.c)$$2.deserialize($$3.get("version"), aae.c.class));
         }

         if ($$3.has("favicon")) {
            $$4.a(alz.h($$3, "favicon"));
         }

         if ($$3.has("previewsChat")) {
            $$4.a(alz.j($$3, "previewsChat"));
         }

         if ($$3.has("enforcesSecureChat")) {
            $$4.b(alz.j($$3, "enforcesSecureChat"));
         }

         return $$4;
      }

      public JsonElement a(aae $$0, Type $$1, JsonSerializationContext $$2) {
         JsonObject $$3 = new JsonObject();
         $$3.addProperty("previewsChat", $$0.e());
         $$3.addProperty("enforcesSecureChat", $$0.f());
         if ($$0.a() != null) {
            $$3.add("description", $$2.serialize($$0.a()));
         }

         if ($$0.b() != null) {
            $$3.add("players", $$2.serialize($$0.b()));
         }

         if ($$0.c() != null) {
            $$3.add("version", $$2.serialize($$0.c()));
         }

         if ($$0.d() != null) {
            $$3.addProperty("favicon", $$0.d());
         }

         return $$3;
      }

      // $FF: synthetic method
      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((aae)var1, var2, var3);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }
   }
}
