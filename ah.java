import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

public class ah implements Comparable<ah> {
   final Map<String, al> a;
   private String[][] b = new String[0][];

   private ah(Map<String, al> $$0) {
      this.a = $$0;
   }

   public ah() {
      this.a = Maps.newHashMap();
   }

   public void a(Map<String, ak> $$0, String[][] $$1) {
      Set<String> $$2 = $$0.keySet();
      this.a.entrySet().removeIf(($$1x) -> {
         return !$$2.contains($$1x.getKey());
      });
      Iterator var4 = $$2.iterator();

      while(var4.hasNext()) {
         String $$3 = (String)var4.next();
         if (!this.a.containsKey($$3)) {
            this.a.put($$3, new al());
         }
      }

      this.b = $$1;
   }

   public boolean a() {
      if (this.b.length == 0) {
         return false;
      } else {
         String[][] var1 = this.b;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            String[] $$0 = var1[var3];
            boolean $$1 = false;
            String[] var6 = $$0;
            int var7 = $$0.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               String $$2 = var6[var8];
               al $$3 = this.c($$2);
               if ($$3 != null && $$3.a()) {
                  $$1 = true;
                  break;
               }
            }

            if (!$$1) {
               return false;
            }
         }

         return true;
      }
   }

   public boolean b() {
      Iterator var1 = this.a.values().iterator();

      al $$0;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         $$0 = (al)var1.next();
      } while(!$$0.a());

      return true;
   }

   public boolean a(String $$0) {
      al $$1 = (al)this.a.get($$0);
      if ($$1 != null && !$$1.a()) {
         $$1.b();
         return true;
      } else {
         return false;
      }
   }

   public boolean b(String $$0) {
      al $$1 = (al)this.a.get($$0);
      if ($$1 != null && $$1.a()) {
         $$1.c();
         return true;
      } else {
         return false;
      }
   }

   public String toString() {
      Map var10000 = this.a;
      return "AdvancementProgress{criteria=" + var10000 + ", requirements=" + Arrays.deepToString(this.b) + "}";
   }

   public void a(qx $$0) {
      $$0.a(this.a, qx::a, ($$0x, $$1) -> {
         $$1.a($$0x);
      });
   }

   public static ah b(qx $$0) {
      Map<String, al> $$1 = $$0.a(qx::q, al::b);
      return new ah($$1);
   }

   @Nullable
   public al c(String $$0) {
      return (al)this.a.get($$0);
   }

   public float c() {
      if (this.a.isEmpty()) {
         return 0.0F;
      } else {
         float $$0 = (float)this.b.length;
         float $$1 = (float)this.h();
         return $$1 / $$0;
      }
   }

   @Nullable
   public String d() {
      if (this.a.isEmpty()) {
         return null;
      } else {
         int $$0 = this.b.length;
         if ($$0 <= 1) {
            return null;
         } else {
            int $$1 = this.h();
            return $$1 + "/" + $$0;
         }
      }
   }

   private int h() {
      int $$0 = 0;
      String[][] var2 = this.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String[] $$1 = var2[var4];
         boolean $$2 = false;
         String[] var7 = $$1;
         int var8 = $$1.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            String $$3 = var7[var9];
            al $$4 = this.c($$3);
            if ($$4 != null && $$4.a()) {
               $$2 = true;
               break;
            }
         }

         if ($$2) {
            ++$$0;
         }
      }

      return $$0;
   }

   public Iterable<String> e() {
      List<String> $$0 = Lists.newArrayList();
      Iterator var2 = this.a.entrySet().iterator();

      while(var2.hasNext()) {
         Entry<String, al> $$1 = (Entry)var2.next();
         if (!((al)$$1.getValue()).a()) {
            $$0.add((String)$$1.getKey());
         }
      }

      return $$0;
   }

   public Iterable<String> f() {
      List<String> $$0 = Lists.newArrayList();
      Iterator var2 = this.a.entrySet().iterator();

      while(var2.hasNext()) {
         Entry<String, al> $$1 = (Entry)var2.next();
         if (((al)$$1.getValue()).a()) {
            $$0.add((String)$$1.getKey());
         }
      }

      return $$0;
   }

   @Nullable
   public Date g() {
      Date $$0 = null;
      Iterator var2 = this.a.values().iterator();

      while(true) {
         al $$1;
         do {
            do {
               if (!var2.hasNext()) {
                  return $$0;
               }

               $$1 = (al)var2.next();
            } while(!$$1.a());
         } while($$0 != null && !$$1.d().before($$0));

         $$0 = $$1.d();
      }
   }

   public int a(ah $$0) {
      Date $$1 = this.g();
      Date $$2 = $$0.g();
      if ($$1 == null && $$2 != null) {
         return 1;
      } else if ($$1 != null && $$2 == null) {
         return -1;
      } else {
         return $$1 == null && $$2 == null ? 0 : $$1.compareTo($$2);
      }
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((ah)var1);
   }

   public static class a implements JsonDeserializer<ah>, JsonSerializer<ah> {
      public JsonElement a(ah $$0, Type $$1, JsonSerializationContext $$2) {
         JsonObject $$3 = new JsonObject();
         JsonObject $$4 = new JsonObject();
         Iterator var6 = $$0.a.entrySet().iterator();

         while(var6.hasNext()) {
            Entry<String, al> $$5 = (Entry)var6.next();
            al $$6 = (al)$$5.getValue();
            if ($$6.a()) {
               $$4.add((String)$$5.getKey(), $$6.e());
            }
         }

         if (!$$4.entrySet().isEmpty()) {
            $$3.add("criteria", $$4);
         }

         $$3.addProperty("done", $$0.a());
         return $$3;
      }

      public ah a(JsonElement $$0, Type $$1, JsonDeserializationContext $$2) throws JsonParseException {
         JsonObject $$3 = alz.m($$0, "advancement");
         JsonObject $$4 = alz.a($$3, "criteria", new JsonObject());
         ah $$5 = new ah();
         Iterator var7 = $$4.entrySet().iterator();

         while(var7.hasNext()) {
            Entry<String, JsonElement> $$6 = (Entry)var7.next();
            String $$7 = (String)$$6.getKey();
            $$5.a.put($$7, al.a(alz.a((JsonElement)$$6.getValue(), $$7)));
         }

         return $$5;
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      // $FF: synthetic method
      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((ah)var1, var2, var3);
      }
   }
}
