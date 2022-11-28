import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mojang.datafixers.DataFixer;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public class abj {
   private static final Logger a = LogUtils.getLogger();
   private static final int b = 2;
   private static final Gson c = (new GsonBuilder()).registerTypeAdapter(ah.class, new ah.a()).registerTypeAdapter(abb.class, new abb.a()).setPrettyPrinting().create();
   private static final TypeToken<Map<abb, ah>> d = new TypeToken<Map<abb, ah>>() {
   };
   private final DataFixer e;
   private final aiz f;
   private final File g;
   private final Map<af, ah> h = Maps.newLinkedHashMap();
   private final Set<af> i = Sets.newLinkedHashSet();
   private final Set<af> j = Sets.newLinkedHashSet();
   private final Set<af> k = Sets.newLinkedHashSet();
   private agh l;
   @Nullable
   private af m;
   private boolean n = true;

   public abj(DataFixer $$0, aiz $$1, abm $$2, File $$3, agh $$4) {
      this.e = $$0;
      this.f = $$1;
      this.g = $$3;
      this.l = $$4;
      this.d($$2);
   }

   public void a(agh $$0) {
      this.l = $$0;
   }

   public void a() {
      Iterator var1 = aj.a().iterator();

      while(var1.hasNext()) {
         am<?> $$0 = (am)var1.next();
         $$0.a(this);
      }

   }

   public void a(abm $$0) {
      this.a();
      this.h.clear();
      this.i.clear();
      this.j.clear();
      this.k.clear();
      this.n = true;
      this.m = null;
      this.d($$0);
   }

   private void b(abm $$0) {
      Iterator var2 = $$0.a().iterator();

      while(var2.hasNext()) {
         af $$1 = (af)var2.next();
         this.c($$1);
      }

   }

   private void c() {
      List<af> $$0 = Lists.newArrayList();
      Iterator var2 = this.h.entrySet().iterator();

      while(var2.hasNext()) {
         Entry<af, ah> $$1 = (Entry)var2.next();
         if (((ah)$$1.getValue()).a()) {
            $$0.add((af)$$1.getKey());
            this.k.add((af)$$1.getKey());
         }
      }

      var2 = $$0.iterator();

      while(var2.hasNext()) {
         af $$2 = (af)var2.next();
         this.e($$2);
      }

   }

   private void c(abm $$0) {
      Iterator var2 = $$0.a().iterator();

      while(var2.hasNext()) {
         af $$1 = (af)var2.next();
         if ($$1.f().isEmpty()) {
            this.a($$1, "");
            $$1.d().a(this.l);
         }
      }

   }

   private void d(abm $$0) {
      if (this.g.isFile()) {
         try {
            JsonReader $$1 = new JsonReader(new StringReader(Files.toString(this.g, StandardCharsets.UTF_8)));

            try {
               $$1.setLenient(false);
               Dynamic<JsonElement> $$2 = new Dynamic(JsonOps.INSTANCE, Streams.parse($$1));
               if (!$$2.get("DataVersion").asNumber().result().isPresent()) {
                  $$2 = $$2.set("DataVersion", $$2.createInt(1343));
               }

               $$2 = this.e.update(ani.i.a(), $$2, $$2.get("DataVersion").asInt(0), ab.b().getWorldVersion());
               $$2 = $$2.remove("DataVersion");
               Map<abb, ah> $$3 = (Map)c.getAdapter(d).fromJsonTree((JsonElement)$$2.getValue());
               if ($$3 == null) {
                  throw new JsonParseException("Found null for advancements");
               }

               Stream<Entry<abb, ah>> $$4 = $$3.entrySet().stream().sorted(Comparator.comparing(Entry::getValue));
               Iterator var6 = ((List)$$4.collect(Collectors.toList())).iterator();

               while(var6.hasNext()) {
                  Entry<abb, ah> $$5 = (Entry)var6.next();
                  af $$6 = $$0.a((abb)$$5.getKey());
                  if ($$6 == null) {
                     a.warn("Ignored advancement '{}' in progress file {} - it doesn't exist anymore?", $$5.getKey(), this.g);
                  } else {
                     this.a($$6, (ah)$$5.getValue());
                  }
               }
            } catch (Throwable var10) {
               try {
                  $$1.close();
               } catch (Throwable var9) {
                  var10.addSuppressed(var9);
               }

               throw var10;
            }

            $$1.close();
         } catch (JsonParseException var11) {
            a.error("Couldn't parse player advancements in {}", this.g, var11);
         } catch (IOException var12) {
            a.error("Couldn't access player advancements in {}", this.g, var12);
         }
      }

      this.c($$0);
      this.c();
      this.b($$0);
   }

   public void b() {
      Map<abb, ah> $$0 = Maps.newHashMap();
      Iterator var2 = this.h.entrySet().iterator();

      while(var2.hasNext()) {
         Entry<af, ah> $$1 = (Entry)var2.next();
         ah $$2 = (ah)$$1.getValue();
         if ($$2.b()) {
            $$0.put(((af)$$1.getKey()).h(), $$2);
         }
      }

      if (this.g.getParentFile() != null) {
         this.g.getParentFile().mkdirs();
      }

      JsonElement $$3 = c.toJsonTree($$0);
      $$3.getAsJsonObject().addProperty("DataVersion", ab.b().getWorldVersion());

      try {
         FileOutputStream $$4 = new FileOutputStream(this.g);

         try {
            OutputStreamWriter $$5 = new OutputStreamWriter($$4, Charsets.UTF_8.newEncoder());

            try {
               c.toJson($$3, $$5);
            } catch (Throwable var9) {
               try {
                  $$5.close();
               } catch (Throwable var8) {
                  var9.addSuppressed(var8);
               }

               throw var9;
            }

            $$5.close();
         } catch (Throwable var10) {
            try {
               $$4.close();
            } catch (Throwable var7) {
               var10.addSuppressed(var7);
            }

            throw var10;
         }

         $$4.close();
      } catch (IOException var11) {
         a.error("Couldn't save player advancements to {}", this.g, var11);
      }

   }

   public boolean a(af $$0, String $$1) {
      boolean $$2 = false;
      ah $$3 = this.b($$0);
      boolean $$4 = $$3.a();
      if ($$3.a($$1)) {
         this.d($$0);
         this.k.add($$0);
         $$2 = true;
         if (!$$4 && $$3.a()) {
            $$0.d().a(this.l);
            if ($$0.c() != null && $$0.c().i() && this.l.s.W().b(cgt.x)) {
               this.f.a((rq)rq.a("chat.type.advancement." + $$0.c().e().a(), this.l.C_(), $$0.j()), false);
            }
         }
      }

      if ($$3.a()) {
         this.e($$0);
      }

      return $$2;
   }

   public boolean b(af $$0, String $$1) {
      boolean $$2 = false;
      ah $$3 = this.b($$0);
      if ($$3.b($$1)) {
         this.c($$0);
         this.k.add($$0);
         $$2 = true;
      }

      if (!$$3.b()) {
         this.e($$0);
      }

      return $$2;
   }

   private void c(af $$0) {
      ah $$1 = this.b($$0);
      if (!$$1.a()) {
         Iterator var3 = $$0.f().entrySet().iterator();

         while(var3.hasNext()) {
            Entry<String, ak> $$2 = (Entry)var3.next();
            al $$3 = $$1.c((String)$$2.getKey());
            if ($$3 != null && !$$3.a()) {
               an $$4 = ((ak)$$2.getValue()).a();
               if ($$4 != null) {
                  am<an> $$5 = aj.a($$4.a());
                  if ($$5 != null) {
                     $$5.a(this, new am.a($$4, $$0, (String)$$2.getKey()));
                  }
               }
            }
         }

      }
   }

   private void d(af $$0) {
      ah $$1 = this.b($$0);
      Iterator var3 = $$0.f().entrySet().iterator();

      while(true) {
         Entry $$2;
         al $$3;
         do {
            do {
               if (!var3.hasNext()) {
                  return;
               }

               $$2 = (Entry)var3.next();
               $$3 = $$1.c((String)$$2.getKey());
            } while($$3 == null);
         } while(!$$3.a() && !$$1.a());

         an $$4 = ((ak)$$2.getValue()).a();
         if ($$4 != null) {
            am<an> $$5 = aj.a($$4.a());
            if ($$5 != null) {
               $$5.b(this, new am.a($$4, $$0, (String)$$2.getKey()));
            }
         }
      }
   }

   public void b(agh $$0) {
      if (this.n || !this.j.isEmpty() || !this.k.isEmpty()) {
         Map<abb, ah> $$1 = Maps.newHashMap();
         Set<af> $$2 = Sets.newLinkedHashSet();
         Set<abb> $$3 = Sets.newLinkedHashSet();
         Iterator var5 = this.k.iterator();

         af $$5;
         while(var5.hasNext()) {
            $$5 = (af)var5.next();
            if (this.i.contains($$5)) {
               $$1.put($$5.h(), (ah)this.h.get($$5));
            }
         }

         var5 = this.j.iterator();

         while(var5.hasNext()) {
            $$5 = (af)var5.next();
            if (this.i.contains($$5)) {
               $$2.add($$5);
            } else {
               $$3.add($$5.h());
            }
         }

         if (this.n || !$$1.isEmpty() || !$$2.isEmpty() || !$$3.isEmpty()) {
            $$0.b.a((tc)(new xf(this.n, $$2, $$3, $$1)));
            this.j.clear();
            this.k.clear();
         }
      }

      this.n = false;
   }

   public void a(@Nullable af $$0) {
      af $$1 = this.m;
      if ($$0 != null && $$0.b() == null && $$0.c() != null) {
         this.m = $$0;
      } else {
         this.m = null;
      }

      if ($$1 != this.m) {
         this.l.b.a((tc)(new vt(this.m == null ? null : this.m.h())));
      }

   }

   public ah b(af $$0) {
      ah $$1 = (ah)this.h.get($$0);
      if ($$1 == null) {
         $$1 = new ah();
         this.a($$0, $$1);
      }

      return $$1;
   }

   private void a(af $$0, ah $$1) {
      $$1.a($$0.f(), $$0.i());
      this.h.put($$0, $$1);
   }

   private void e(af $$0) {
      boolean $$1 = this.f($$0);
      boolean $$2 = this.i.contains($$0);
      if ($$1 && !$$2) {
         this.i.add($$0);
         this.j.add($$0);
         if (this.h.containsKey($$0)) {
            this.k.add($$0);
         }
      } else if (!$$1 && $$2) {
         this.i.remove($$0);
         this.j.add($$0);
      }

      if ($$1 != $$2 && $$0.b() != null) {
         this.e($$0.b());
      }

      Iterator var4 = $$0.e().iterator();

      while(var4.hasNext()) {
         af $$3 = (af)var4.next();
         this.e($$3);
      }

   }

   private boolean f(af $$0) {
      for(int $$1 = 0; $$0 != null && $$1 <= 2; ++$$1) {
         if ($$1 == 0 && this.g($$0)) {
            return true;
         }

         if ($$0.c() == null) {
            return false;
         }

         ah $$2 = this.b($$0);
         if ($$2.a()) {
            return true;
         }

         if ($$0.c().j()) {
            return false;
         }

         $$0 = $$0.b();
      }

      return false;
   }

   private boolean g(af $$0) {
      ah $$1 = this.b($$0);
      if ($$1.a()) {
         return true;
      } else {
         Iterator var3 = $$0.e().iterator();

         af $$2;
         do {
            if (!var3.hasNext()) {
               return false;
            }

            $$2 = (af)var3.next();
         } while(!this.g($$2));

         return true;
      }
   }
}
