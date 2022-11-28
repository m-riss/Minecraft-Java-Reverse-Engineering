import com.google.common.collect.Lists;
import com.mojang.logging.LogUtils;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;

public class aam {
   private static final Logger a = LogUtils.getLogger();
   private static final Object2IntMap<Class<? extends bbn>> b = new Object2IntOpenHashMap();
   private static final int c = 255;
   private static final int d = 254;
   private final bbn e;
   private final Int2ObjectMap<aam.a<?>> f = new Int2ObjectOpenHashMap();
   private final ReadWriteLock g = new ReentrantReadWriteLock();
   private boolean h = true;
   private boolean i;

   public aam(bbn $$0) {
      this.e = $$0;
   }

   public static <T> aaj<T> a(Class<? extends bbn> $$0, aak<T> $$1) {
      if (a.isDebugEnabled()) {
         try {
            Class<?> $$2 = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
            if (!$$2.equals($$0)) {
               a.debug("defineId called for: {} from {}", new Object[]{$$0, $$2, new RuntimeException()});
            }
         } catch (ClassNotFoundException var5) {
         }
      }

      int $$6;
      if (b.containsKey($$0)) {
         $$6 = b.getInt($$0) + 1;
      } else {
         int $$4 = 0;
         Class $$5 = $$0;

         while($$5 != bbn.class) {
            $$5 = $$5.getSuperclass();
            if (b.containsKey($$5)) {
               $$4 = b.getInt($$5) + 1;
               break;
            }
         }

         $$6 = $$4;
      }

      if ($$6 > 254) {
         throw new IllegalArgumentException("Data value id is too big with " + $$6 + "! (Max is 254)");
      } else {
         b.put($$0, $$6);
         return $$1.a($$6);
      }
   }

   public <T> void a(aaj<T> $$0, T $$1) {
      int $$2 = $$0.a();
      if ($$2 > 254) {
         throw new IllegalArgumentException("Data value id is too big with " + $$2 + "! (Max is 254)");
      } else if (this.f.containsKey($$2)) {
         throw new IllegalArgumentException("Duplicate id value for " + $$2 + "!");
      } else if (aal.b($$0.b()) < 0) {
         aak var10002 = $$0.b();
         throw new IllegalArgumentException("Unregistered serializer " + var10002 + " for " + $$2 + "!");
      } else {
         this.c($$0, $$1);
      }
   }

   private <T> void c(aaj<T> $$0, T $$1) {
      aam.a<T> $$2 = new aam.a($$0, $$1);
      this.g.writeLock().lock();
      this.f.put($$0.a(), $$2);
      this.h = false;
      this.g.writeLock().unlock();
   }

   private <T> aam.a<T> b(aaj<T> $$0) {
      this.g.readLock().lock();

      aam.a $$1;
      try {
         $$1 = (aam.a)this.f.get($$0.a());
      } catch (Throwable var9) {
         q $$3 = q.a(var9, "Getting synched entity data");
         r $$4 = $$3.a("Synched entity data");
         $$4.a((String)"Data ID", (Object)$$0);
         throw new z($$3);
      } finally {
         this.g.readLock().unlock();
      }

      return $$1;
   }

   public <T> T a(aaj<T> $$0) {
      return this.b($$0).b();
   }

   public <T> void b(aaj<T> $$0, T $$1) {
      aam.a<T> $$2 = this.b($$0);
      if (ObjectUtils.notEqual($$1, $$2.b())) {
         $$2.a($$1);
         this.e.a($$0);
         $$2.a(true);
         this.i = true;
      }

   }

   public boolean a() {
      return this.i;
   }

   public static void a(@Nullable List<aam.a<?>> $$0, qx $$1) {
      if ($$0 != null) {
         Iterator var2 = $$0.iterator();

         while(var2.hasNext()) {
            aam.a<?> $$2 = (aam.a)var2.next();
            a($$1, $$2);
         }
      }

      $$1.writeByte(255);
   }

   @Nullable
   public List<aam.a<?>> b() {
      List<aam.a<?>> $$0 = null;
      if (this.i) {
         this.g.readLock().lock();
         ObjectIterator var2 = this.f.values().iterator();

         while(var2.hasNext()) {
            aam.a<?> $$1 = (aam.a)var2.next();
            if ($$1.c()) {
               $$1.a(false);
               if ($$0 == null) {
                  $$0 = Lists.newArrayList();
               }

               $$0.add($$1.d());
            }
         }

         this.g.readLock().unlock();
      }

      this.i = false;
      return $$0;
   }

   @Nullable
   public List<aam.a<?>> c() {
      List<aam.a<?>> $$0 = null;
      this.g.readLock().lock();

      aam.a $$1;
      for(ObjectIterator var2 = this.f.values().iterator(); var2.hasNext(); $$0.add($$1.d())) {
         $$1 = (aam.a)var2.next();
         if ($$0 == null) {
            $$0 = Lists.newArrayList();
         }
      }

      this.g.readLock().unlock();
      return $$0;
   }

   private static <T> void a(qx $$0, aam.a<T> $$1) {
      aaj<T> $$2 = $$1.a();
      int $$3 = aal.b($$2.b());
      if ($$3 < 0) {
         throw new EncoderException("Unknown serializer type " + $$2.b());
      } else {
         $$0.writeByte($$2.a());
         $$0.d($$3);
         $$2.b().a($$0, $$1.b());
      }
   }

   @Nullable
   public static List<aam.a<?>> a(qx $$0) {
      ArrayList $$1 = null;

      short $$2;
      while(($$2 = $$0.readUnsignedByte()) != 255) {
         if ($$1 == null) {
            $$1 = Lists.newArrayList();
         }

         int $$3 = $$0.k();
         aak<?> $$4 = aal.a($$3);
         if ($$4 == null) {
            throw new DecoderException("Unknown serializer type " + $$3);
         }

         $$1.add(a($$0, $$2, $$4));
      }

      return $$1;
   }

   private static <T> aam.a<T> a(qx $$0, int $$1, aak<T> $$2) {
      return new aam.a($$2.a($$1), $$2.a($$0));
   }

   public void a(List<aam.a<?>> $$0) {
      this.g.writeLock().lock();

      try {
         Iterator var2 = $$0.iterator();

         while(var2.hasNext()) {
            aam.a<?> $$1 = (aam.a)var2.next();
            aam.a<?> $$2 = (aam.a)this.f.get($$1.a().a());
            if ($$2 != null) {
               this.a($$2, $$1);
               this.e.a($$1.a());
            }
         }
      } finally {
         this.g.writeLock().unlock();
      }

      this.i = true;
   }

   private <T> void a(aam.a<T> $$0, aam.a<?> $$1) {
      if (!Objects.equals($$1.a.b(), $$0.a.b())) {
         throw new IllegalStateException(String.format(Locale.ROOT, "Invalid entity data item type for field %d on entity %s: old=%s(%s), new=%s(%s)", $$0.a.a(), this.e, $$0.b, $$0.b.getClass(), $$1.b, $$1.b.getClass()));
      } else {
         $$0.a($$1.b());
      }
   }

   public boolean d() {
      return this.h;
   }

   public void e() {
      this.i = false;
      this.g.readLock().lock();
      ObjectIterator var1 = this.f.values().iterator();

      while(var1.hasNext()) {
         aam.a<?> $$0 = (aam.a)var1.next();
         $$0.a(false);
      }

      this.g.readLock().unlock();
   }

   public static class a<T> {
      final aaj<T> a;
      T b;
      private boolean c;

      public a(aaj<T> $$0, T $$1) {
         this.a = $$0;
         this.b = $$1;
         this.c = true;
      }

      public aaj<T> a() {
         return this.a;
      }

      public void a(T $$0) {
         this.b = $$0;
      }

      public T b() {
         return this.b;
      }

      public boolean c() {
         return this.c;
      }

      public void a(boolean $$0) {
         this.c = $$0;
      }

      public aam.a<T> d() {
         return new aam.a(this.a, this.a.b().a(this.b));
      }
   }
}
