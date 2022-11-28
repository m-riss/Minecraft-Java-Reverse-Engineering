import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.longs.Long2ByteMap;
import it.unimi.dsi.fastutil.longs.Long2ByteOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agm extends afw {
   private static final int b = 4;
   protected final Long2ByteMap a = new Long2ByteOpenHashMap();
   private final Long2ObjectOpenHashMap<amt<agk<?>>> c = new Long2ObjectOpenHashMap();

   public agm() {
      super(34, 16, 256);
      this.a.defaultReturnValue((byte)33);
   }

   private amt<agk<?>> g(long $$0) {
      return (amt)this.c.computeIfAbsent($$0, ($$0x) -> {
         return amt.a(4);
      });
   }

   private int a(amt<agk<?>> $$0) {
      return $$0.isEmpty() ? 34 : ((agk)$$0.b()).b();
   }

   public void a(long $$0, agk<?> $$1) {
      amt<agk<?>> $$2 = this.g($$0);
      int $$3 = this.a($$2);
      $$2.add($$1);
      if ($$1.b() < $$3) {
         this.b($$0, $$1.b(), true);
      }

   }

   public void b(long $$0, agk<?> $$1) {
      amt<agk<?>> $$2 = this.g($$0);
      $$2.remove($$1);
      if ($$2.isEmpty()) {
         this.c.remove($$0);
      }

      this.b($$0, this.a($$2), false);
   }

   public <T> void a(agl<T> $$0, cge $$1, int $$2, T $$3) {
      this.a($$1.a(), new agk($$0, $$2, $$3));
   }

   public <T> void b(agl<T> $$0, cge $$1, int $$2, T $$3) {
      agk<T> $$4 = new agk($$0, $$2, $$3);
      this.b($$1.a(), $$4);
   }

   public void a(int $$0) {
      List<Pair<agk<cge>, Long>> $$1 = new ArrayList();
      ObjectIterator var3 = this.c.long2ObjectEntrySet().iterator();

      agk $$3;
      while(var3.hasNext()) {
         Entry<amt<agk<?>>> $$2 = (Entry)var3.next();
         Iterator var5 = ((amt)$$2.getValue()).iterator();

         while(var5.hasNext()) {
            $$3 = (agk)var5.next();
            if ($$3.a() == agl.c) {
               $$1.add(Pair.of($$3, $$2.getLongKey()));
            }
         }
      }

      Iterator var9 = $$1.iterator();

      while(var9.hasNext()) {
         Pair<agk<cge>, Long> $$4 = (Pair)var9.next();
         Long $$5 = (Long)$$4.getSecond();
         $$3 = (agk)$$4.getFirst();
         this.b($$5, $$3);
         cge $$7 = new cge($$5);
         agl<cge> $$8 = $$3.a();
         this.a($$8, $$7, $$0, $$7);
      }

   }

   protected int b(long $$0) {
      amt<agk<?>> $$1 = (amt)this.c.get($$0);
      return $$1 != null && !$$1.isEmpty() ? ((agk)$$1.b()).b() : Integer.MAX_VALUE;
   }

   public int a(cge $$0) {
      return this.c($$0.a());
   }

   protected int c(long $$0) {
      return this.a.get($$0);
   }

   protected void a(long $$0, int $$1) {
      if ($$1 > 33) {
         this.a.remove($$0);
      } else {
         this.a.put($$0, (byte)$$1);
      }

   }

   public void a() {
      this.b(Integer.MAX_VALUE);
   }

   public String d(long $$0) {
      amt<agk<?>> $$1 = (amt)this.c.get($$0);
      return $$1 != null && !$$1.isEmpty() ? ((agk)$$1.b()).toString() : "no_ticket";
   }
}
