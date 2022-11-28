import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Either;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.longs.Long2ByteMap;
import it.unimi.dsi.fastutil.longs.Long2ByteOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2IntMap;
import it.unimi.dsi.fastutil.longs.Long2IntMaps;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public abstract class afz {
   static final Logger a = LogUtils.getLogger();
   private static final int b = 2;
   static final int c;
   private static final int d = 4;
   private static final int e = 32;
   private static final int f = 33;
   final Long2ObjectMap<ObjectSet<agh>> g = new Long2ObjectOpenHashMap();
   final Long2ObjectOpenHashMap<amt<agk<?>>> h = new Long2ObjectOpenHashMap();
   private final afz.a i = new afz.a();
   private final afz.b j = new afz.b(8);
   private final agm k = new agm();
   private final afz.c l = new afz.c(33);
   final Set<afs> m = Sets.newHashSet();
   final afv n;
   final azb<afv.a<Runnable>> o;
   final azb<afv.b> p;
   final LongSet q = new LongOpenHashSet();
   final Executor r;
   private long s;
   private int t = 10;

   protected afz(Executor $$0, Executor $$1) {
      Objects.requireNonNull($$1);
      azb<Runnable> $$2 = azb.a("player ticket throttler", $$1::execute);
      afv $$3 = new afv(ImmutableList.of($$2), $$0, 4);
      this.n = $$3;
      this.o = $$3.a($$2, true);
      this.p = $$3.a($$2);
      this.r = $$1;
   }

   protected void a() {
      ++this.s;
      ObjectIterator $$0 = this.h.long2ObjectEntrySet().fastIterator();

      while($$0.hasNext()) {
         Entry<amt<agk<?>>> $$1 = (Entry)$$0.next();
         Iterator<agk<?>> $$2 = ((amt)$$1.getValue()).iterator();
         boolean $$3 = false;

         while($$2.hasNext()) {
            agk<?> $$4 = (agk)$$2.next();
            if ($$4.b(this.s)) {
               $$2.remove();
               $$3 = true;
               this.k.b($$1.getLongKey(), $$4);
            }
         }

         if ($$3) {
            this.i.b($$1.getLongKey(), a((amt)$$1.getValue()), false);
         }

         if (((amt)$$1.getValue()).isEmpty()) {
            $$0.remove();
         }
      }

   }

   private static int a(amt<agk<?>> $$0) {
      return !$$0.isEmpty() ? ((agk)$$0.b()).b() : aft.b + 1;
   }

   protected abstract boolean a(long var1);

   @Nullable
   protected abstract afs b(long var1);

   @Nullable
   protected abstract afs a(long var1, int var3, @Nullable afs var4, int var5);

   public boolean a(aft $$0) {
      this.j.a();
      this.k.a();
      this.l.a();
      int $$1 = Integer.MAX_VALUE - this.i.a(Integer.MAX_VALUE);
      boolean $$2 = $$1 != 0;
      if ($$2) {
      }

      if (!this.m.isEmpty()) {
         this.m.forEach(($$1x) -> {
            $$1x.a($$0, this.r);
         });
         this.m.clear();
         return true;
      } else {
         if (!this.q.isEmpty()) {
            LongIterator $$3 = this.q.iterator();

            while($$3.hasNext()) {
               long $$4 = $$3.nextLong();
               if (this.g($$4).stream().anyMatch(($$0x) -> {
                  return $$0x.a() == agl.c;
               })) {
                  afs $$5 = $$0.a($$4);
                  if ($$5 == null) {
                     throw new IllegalStateException();
                  }

                  CompletableFuture<Either<cxt, afs.a>> $$6 = $$5.b();
                  $$6.thenAccept(($$1x) -> {
                     this.r.execute(() -> {
                        this.p.a(afv.a(() -> {
                        }, $$4, false));
                     });
                  });
               }
            }

            this.q.clear();
         }

         return $$2;
      }
   }

   void a(long $$0, agk<?> $$1) {
      amt<agk<?>> $$2 = this.g($$0);
      int $$3 = a($$2);
      agk<?> $$4 = (agk)$$2.a((Object)$$1);
      $$4.a(this.s);
      if ($$1.b() < $$3) {
         this.i.b($$0, $$1.b(), true);
      }

   }

   void b(long $$0, agk<?> $$1) {
      amt<agk<?>> $$2 = this.g($$0);
      if ($$2.remove($$1)) {
      }

      if ($$2.isEmpty()) {
         this.h.remove($$0);
      }

      this.i.b($$0, a($$2), false);
   }

   public <T> void a(agl<T> $$0, cge $$1, int $$2, T $$3) {
      this.a($$1.a(), new agk($$0, $$2, $$3));
   }

   public <T> void b(agl<T> $$0, cge $$1, int $$2, T $$3) {
      agk<T> $$4 = new agk($$0, $$2, $$3);
      this.b($$1.a(), $$4);
   }

   public <T> void c(agl<T> $$0, cge $$1, int $$2, T $$3) {
      agk<T> $$4 = new agk($$0, 33 - $$2, $$3);
      long $$5 = $$1.a();
      this.a($$5, $$4);
      this.k.a($$5, $$4);
   }

   public <T> void d(agl<T> $$0, cge $$1, int $$2, T $$3) {
      agk<T> $$4 = new agk($$0, 33 - $$2, $$3);
      long $$5 = $$1.a();
      this.b($$5, $$4);
      this.k.b($$5, $$4);
   }

   private amt<agk<?>> g(long $$0) {
      return (amt)this.h.computeIfAbsent($$0, ($$0x) -> {
         return amt.a(4);
      });
   }

   protected void a(cge $$0, boolean $$1) {
      agk<cge> $$2 = new agk(agl.d, 31, $$0);
      long $$3 = $$0.a();
      if ($$1) {
         this.a($$3, $$2);
         this.k.a($$3, $$2);
      } else {
         this.b($$3, $$2);
         this.k.b($$3, $$2);
      }

   }

   public void a(hq $$0, agh $$1) {
      cge $$2 = $$0.r();
      long $$3 = $$2.a();
      ((ObjectSet)this.g.computeIfAbsent($$3, ($$0x) -> {
         return new ObjectOpenHashSet();
      })).add($$1);
      this.j.b($$3, 0, true);
      this.l.b($$3, 0, true);
      this.k.a(agl.c, $$2, this.g(), $$2);
   }

   public void b(hq $$0, agh $$1) {
      cge $$2 = $$0.r();
      long $$3 = $$2.a();
      ObjectSet<agh> $$4 = (ObjectSet)this.g.get($$3);
      $$4.remove($$1);
      if ($$4.isEmpty()) {
         this.g.remove($$3);
         this.j.b($$3, Integer.MAX_VALUE, false);
         this.l.b($$3, Integer.MAX_VALUE, false);
         this.k.b(agl.c, $$2, this.g(), $$2);
      }

   }

   private int g() {
      return Math.max(0, 31 - this.t);
   }

   public boolean c(long $$0) {
      return this.k.c($$0) < 32;
   }

   public boolean d(long $$0) {
      return this.k.c($$0) < 33;
   }

   protected String e(long $$0) {
      amt<agk<?>> $$1 = (amt)this.h.get($$0);
      return $$1 != null && !$$1.isEmpty() ? ((agk)$$1.b()).toString() : "no_ticket";
   }

   protected void a(int $$0) {
      this.l.a($$0);
   }

   public void b(int $$0) {
      if ($$0 != this.t) {
         this.t = $$0;
         this.k.a(this.g());
      }

   }

   public int b() {
      this.j.a();
      return this.j.a.size();
   }

   public boolean f(long $$0) {
      this.j.a();
      return this.j.a.containsKey($$0);
   }

   public String c() {
      return this.n.b();
   }

   private void a(String $$0) {
      try {
         FileOutputStream $$1 = new FileOutputStream(new File($$0));

         try {
            ObjectIterator var3 = this.h.long2ObjectEntrySet().iterator();

            while(var3.hasNext()) {
               Entry<amt<agk<?>>> $$2 = (Entry)var3.next();
               cge $$3 = new cge($$2.getLongKey());
               Iterator var6 = ((amt)$$2.getValue()).iterator();

               while(var6.hasNext()) {
                  agk<?> $$4 = (agk)var6.next();
                  int var10001 = $$3.e;
                  $$1.write((var10001 + "\t" + $$3.f + "\t" + $$4.a() + "\t" + $$4.b() + "\t\n").getBytes(StandardCharsets.UTF_8));
               }
            }
         } catch (Throwable var9) {
            try {
               $$1.close();
            } catch (Throwable var8) {
               var9.addSuppressed(var8);
            }

            throw var9;
         }

         $$1.close();
      } catch (IOException var10) {
         a.error("Failed to dump tickets to {}", $$0, var10);
      }

   }

   @VisibleForTesting
   agm d() {
      return this.k;
   }

   public void e() {
      ImmutableSet<agl<?>> $$0 = ImmutableSet.of(agl.h, agl.g, agl.e);
      ObjectIterator $$1 = this.h.long2ObjectEntrySet().fastIterator();

      while($$1.hasNext()) {
         Entry<amt<agk<?>>> $$2 = (Entry)$$1.next();
         Iterator<agk<?>> $$3 = ((amt)$$2.getValue()).iterator();
         boolean $$4 = false;

         while($$3.hasNext()) {
            agk<?> $$5 = (agk)$$3.next();
            if (!$$0.contains($$5.a())) {
               $$3.remove();
               $$4 = true;
               this.k.b($$2.getLongKey(), $$5);
            }
         }

         if ($$4) {
            this.i.b($$2.getLongKey(), a((amt)$$2.getValue()), false);
         }

         if (((amt)$$2.getValue()).isEmpty()) {
            $$1.remove();
         }
      }

   }

   public boolean f() {
      return !this.h.isEmpty();
   }

   static {
      c = 33 + cxn.a(cxn.o) - 2;
   }

   class a extends afw {
      public a() {
         super(aft.b + 2, 16, 256);
      }

      protected int b(long $$0) {
         amt<agk<?>> $$1 = (amt)afz.this.h.get($$0);
         if ($$1 == null) {
            return Integer.MAX_VALUE;
         } else {
            return $$1.isEmpty() ? Integer.MAX_VALUE : ((agk)$$1.b()).b();
         }
      }

      protected int c(long $$0) {
         if (!afz.this.a($$0)) {
            afs $$1 = afz.this.b($$0);
            if ($$1 != null) {
               return $$1.k();
            }
         }

         return aft.b + 1;
      }

      protected void a(long $$0, int $$1) {
         afs $$2 = afz.this.b($$0);
         int $$3 = $$2 == null ? aft.b + 1 : $$2.k();
         if ($$3 != $$1) {
            $$2 = afz.this.a($$0, $$1, $$2, $$3);
            if ($$2 != null) {
               afz.this.m.add($$2);
            }

         }
      }

      public int a(int $$0) {
         return this.b($$0);
      }
   }

   private class b extends afw {
      protected final Long2ByteMap a = new Long2ByteOpenHashMap();
      protected final int b;

      protected b(int $$0) {
         super($$0 + 2, 16, 256);
         this.b = $$0;
         this.a.defaultReturnValue((byte)($$0 + 2));
      }

      protected int c(long $$0) {
         return this.a.get($$0);
      }

      protected void a(long $$0, int $$1) {
         byte $$3;
         if ($$1 > this.b) {
            $$3 = this.a.remove($$0);
         } else {
            $$3 = this.a.put($$0, (byte)$$1);
         }

         this.a($$0, $$3, $$1);
      }

      protected void a(long $$0, int $$1, int $$2) {
      }

      protected int b(long $$0) {
         return this.d($$0) ? 0 : Integer.MAX_VALUE;
      }

      private boolean d(long $$0) {
         ObjectSet<agh> $$1 = (ObjectSet)afz.this.g.get($$0);
         return $$1 != null && !$$1.isEmpty();
      }

      public void a() {
         this.b(Integer.MAX_VALUE);
      }

      private void a(String $$0) {
         try {
            FileOutputStream $$1 = new FileOutputStream(new File($$0));

            try {
               ObjectIterator var3 = this.a.long2ByteEntrySet().iterator();

               while(var3.hasNext()) {
                  it.unimi.dsi.fastutil.longs.Long2ByteMap.Entry $$2 = (it.unimi.dsi.fastutil.longs.Long2ByteMap.Entry)var3.next();
                  cge $$3 = new cge($$2.getLongKey());
                  String $$4 = Byte.toString($$2.getByteValue());
                  $$1.write(($$3.e + "\t" + $$3.f + "\t" + $$4 + "\n").getBytes(StandardCharsets.UTF_8));
               }
            } catch (Throwable var8) {
               try {
                  $$1.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
               }

               throw var8;
            }

            $$1.close();
         } catch (IOException var9) {
            afz.a.error("Failed to dump chunks to {}", $$0, var9);
         }

      }
   }

   class c extends afz.b {
      private int e = 0;
      private final Long2IntMap f = Long2IntMaps.synchronize(new Long2IntOpenHashMap());
      private final LongSet g = new LongOpenHashSet();

      protected c(int $$0) {
         super($$0);
         this.f.defaultReturnValue($$0 + 2);
      }

      protected void a(long $$0, int $$1, int $$2) {
         this.g.add($$0);
      }

      public void a(int $$0) {
         ObjectIterator var2 = this.a.long2ByteEntrySet().iterator();

         while(var2.hasNext()) {
            it.unimi.dsi.fastutil.longs.Long2ByteMap.Entry $$1 = (it.unimi.dsi.fastutil.longs.Long2ByteMap.Entry)var2.next();
            byte $$2 = $$1.getByteValue();
            long $$3 = $$1.getLongKey();
            this.a($$3, $$2, this.c($$2), $$2 <= $$0 - 2);
         }

         this.e = $$0;
      }

      private void a(long $$0, int $$1, boolean $$2, boolean $$3) {
         if ($$2 != $$3) {
            agk<?> $$4 = new agk(agl.c, afz.c, new cge($$0));
            if ($$3) {
               afz.this.o.a(afv.a(() -> {
                  afz.this.r.execute(() -> {
                     if (this.c(this.c($$0))) {
                        afz.this.a($$0, $$4);
                        afz.this.q.add($$0);
                     } else {
                        afz.this.p.a(afv.a(() -> {
                        }, $$0, false));
                     }

                  });
               }, $$0, () -> {
                  return $$1;
               }));
            } else {
               afz.this.p.a(afv.a(() -> {
                  afz.this.r.execute(() -> {
                     afz.this.b($$0, $$4);
                  });
               }, $$0, true));
            }
         }

      }

      public void a() {
         super.a();
         if (!this.g.isEmpty()) {
            LongIterator $$0 = this.g.iterator();

            while($$0.hasNext()) {
               long $$1 = $$0.nextLong();
               int $$2 = this.f.get($$1);
               int $$3 = this.c($$1);
               if ($$2 != $$3) {
                  afz.this.n.onLevelChange(new cge($$1), () -> {
                     return this.f.get($$1);
                  }, $$3, ($$1x) -> {
                     if ($$1x >= this.f.defaultReturnValue()) {
                        this.f.remove($$1);
                     } else {
                        this.f.put($$1, $$1x);
                     }

                  });
                  this.a($$1, $$3, this.c($$2), this.c($$3));
               }
            }

            this.g.clear();
         }

      }

      private boolean c(int $$0) {
         return $$0 <= this.e - 2;
      }
   }
}
