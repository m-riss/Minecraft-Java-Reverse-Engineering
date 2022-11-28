import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

public class abb implements Comparable<abb> {
   public static final Codec<abb> a;
   private static final SimpleCommandExceptionType g;
   public static final char b = ':';
   public static final String c = "minecraft";
   public static final String d = "realms";
   protected final String e;
   protected final String f;

   protected abb(String[] $$0) {
      this.e = StringUtils.isEmpty($$0[0]) ? "minecraft" : $$0[0];
      this.f = $$0[1];
      if (!f(this.e)) {
         throw new aa("Non [a-z0-9_.-] character in namespace of location: " + this.e + ":" + this.f);
      } else if (!e(this.f)) {
         throw new aa("Non [a-z0-9/._-] character in path of location: " + this.e + ":" + this.f);
      }
   }

   public abb(String $$0) {
      this(b($$0, ':'));
   }

   public abb(String $$0, String $$1) {
      this(new String[]{$$0, $$1});
   }

   public static abb a(String $$0, char $$1) {
      return new abb(b($$0, $$1));
   }

   @Nullable
   public static abb a(String $$0) {
      try {
         return new abb($$0);
      } catch (aa var2) {
         return null;
      }
   }

   @Nullable
   public static abb a(String $$0, String $$1) {
      try {
         return new abb($$0, $$1);
      } catch (aa var3) {
         return null;
      }
   }

   protected static String[] b(String $$0, char $$1) {
      String[] $$2 = new String[]{"minecraft", $$0};
      int $$3 = $$0.indexOf($$1);
      if ($$3 >= 0) {
         $$2[1] = $$0.substring($$3 + 1, $$0.length());
         if ($$3 >= 1) {
            $$2[0] = $$0.substring(0, $$3);
         }
      }

      return $$2;
   }

   public static DataResult<abb> b(String $$0) {
      try {
         return DataResult.success(new abb($$0));
      } catch (aa var2) {
         return DataResult.error("Not a valid resource location: " + $$0 + " " + var2.getMessage());
      }
   }

   public String a() {
      return this.f;
   }

   public String b() {
      return this.e;
   }

   public String toString() {
      return this.e + ":" + this.f;
   }

   public boolean equals(Object $$0) {
      if (this == $$0) {
         return true;
      } else if (!($$0 instanceof abb)) {
         return false;
      } else {
         abb $$1 = (abb)$$0;
         return this.e.equals($$1.e) && this.f.equals($$1.f);
      }
   }

   public int hashCode() {
      return 31 * this.e.hashCode() + this.f.hashCode();
   }

   public int a(abb $$0) {
      int $$1 = this.f.compareTo($$0.f);
      if ($$1 == 0) {
         $$1 = this.e.compareTo($$0.e);
      }

      return $$1;
   }

   public String c() {
      return this.toString().replace('/', '_').replace(':', '_');
   }

   public String d() {
      return this.e + "." + this.f;
   }

   public String e() {
      return this.e.equals("minecraft") ? this.f : this.d();
   }

   public String c(String $$0) {
      return $$0 + "." + this.d();
   }

   public static abb a(StringReader $$0) throws CommandSyntaxException {
      int $$1 = $$0.getCursor();

      while($$0.canRead() && a($$0.peek())) {
         $$0.skip();
      }

      String $$2 = $$0.getString().substring($$1, $$0.getCursor());

      try {
         return new abb($$2);
      } catch (aa var4) {
         $$0.setCursor($$1);
         throw g.createWithContext($$0);
      }
   }

   public static boolean a(char $$0) {
      return $$0 >= '0' && $$0 <= '9' || $$0 >= 'a' && $$0 <= 'z' || $$0 == '_' || $$0 == ':' || $$0 == '/' || $$0 == '.' || $$0 == '-';
   }

   private static boolean e(String $$0) {
      for(int $$1 = 0; $$1 < $$0.length(); ++$$1) {
         if (!b($$0.charAt($$1))) {
            return false;
         }
      }

      return true;
   }

   private static boolean f(String $$0) {
      for(int $$1 = 0; $$1 < $$0.length(); ++$$1) {
         if (!c($$0.charAt($$1))) {
            return false;
         }
      }

      return true;
   }

   public static boolean b(char $$0) {
      return $$0 == '_' || $$0 == '-' || $$0 >= 'a' && $$0 <= 'z' || $$0 >= '0' && $$0 <= '9' || $$0 == '/' || $$0 == '.';
   }

   private static boolean c(char $$0) {
      return $$0 == '_' || $$0 == '-' || $$0 >= 'a' && $$0 <= 'z' || $$0 >= '0' && $$0 <= '9' || $$0 == '.';
   }

   public static boolean d(String $$0) {
      String[] $$1 = b($$0, ':');
      return f(StringUtils.isEmpty($$1[0]) ? "minecraft" : $$1[0]) && e($$1[1]);
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((abb)var1);
   }

   static {
      a = Codec.STRING.comapFlatMap(abb::b, abb::toString).stable();
      g = new SimpleCommandExceptionType(rq.c("argument.id.invalid"));
   }

   public static class a implements JsonDeserializer<abb>, JsonSerializer<abb> {
      public abb a(JsonElement $$0, Type $$1, JsonDeserializationContext $$2) throws JsonParseException {
         return new abb(alz.a($$0, "location"));
      }

      public JsonElement a(abb $$0, Type $$1, JsonSerializationContext $$2) {
         return new JsonPrimitive($$0.toString());
      }

      // $FF: synthetic method
      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((abb)var1, var2, var3);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }
   }
}
