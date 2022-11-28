import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Either;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Nullable;

public class afu<T> {
   public static final int a;
   private final List<Long2ObjectLinkedOpenHashMap<List<Optional<T>>>> b;
   private volatile int c;
   private final String d;
   private final LongSet e;
   private final int f;

   public afu(String $$0, int $$1) {
      this.b = (List)IntStream.range(0, a).mapToObj(($$0x) -> {
         return new Long2ObjectLinkedOpenHashMap();
      }).collect(Collectors.toList());
      this.c = a;
      this.e = new LongOpenHashSet();
      this.d = $$0;
      this.f = $$1;
   }

   protected void a(int $$0, cge $$1, int $$2) {
      if ($$0 < a) {
         Long2ObjectLinkedOpenHashMap<List<Optional<T>>> $$3 = (Long2ObjectLinkedOpenHashMap)this.b.get($$0);
         List<Optional<T>> $$4 = (List)$$3.remove($$1.a());
         if ($$0 == this.c) {
            while(this.b() && ((Long2ObjectLinkedOpenHashMap)this.b.get(this.c)).isEmpty()) {
               ++this.c;
            }
         }

         if ($$4 != null && !$$4.isEmpty()) {
            ((List)((Long2ObjectLinkedOpenHashMap)this.b.get($$2)).computeIfAbsent($$1.a(), ($$0x) -> {
               return Lists.newArrayList();
            })).addAll($$4);
            this.c = Math.min(this.c, $$2);
         }

      }
   }

   protected void a(Optional<T> $$0, long $$1, int $$2) {
      ((List)((Long2ObjectLinkedOpenHashMap)this.b.get($$2)).computeIfAbsent($$1, ($$0x) -> {
         return Lists.newArrayList();
      })).add($$0);
      this.c = Math.min(this.c, $$2);
   }

   protected void a(long $$0, boolean $$1) {
      Iterator var4 = this.b.iterator();

      while(var4.hasNext()) {
         Long2ObjectLinkedOpenHashMap<List<Optional<T>>> $$2 = (Long2ObjectLinkedOpenHashMap)var4.next();
         List<Optional<T>> $$3 = (List)$$2.get($$0);
         if ($$3 != null) {
            if ($$1) {
               $$3.clear();
            } else {
               $$3.removeIf(($$0x) -> {
                  return !$$0x.isPresent();
               });
            }

            if ($$3.isEmpty()) {
               $$2.remove($$0);
            }
         }
      }

      while(this.b() && ((Long2ObjectLinkedOpenHashMap)this.b.get(this.c)).isEmpty()) {
         ++this.c;
      }

      this.e.remove($$0);
   }

   private Runnable a(long $$0) {
      return () -> {
         this.e.add($$0);
      };
   }

   @Nullable
   public Stream<Either<T, Runnable>> a() {
      if (this.e.size() >= this.f) {
         return null;
      } else if (!this.b()) {
         return null;
      } else {
         int $$0 = this.c;
         Long2ObjectLinkedOpenHashMap<List<Optional<T>>> $$1 = (Long2ObjectLinkedOpenHashMap)this.b.get($$0);
         long $$2 = $$1.firstLongKey();

         List $$3;
         for($$3 = (List)$$1.removeFirst(); this.b() && ((Long2ObjectLinkedOpenHashMap)this.b.get(this.c)).isEmpty(); ++this.c) {
         }

         return $$3.stream().map(($$1x) -> {
            return (Either)$$1x.map(Either::left).orElseGet(() -> {
               return Either.right(this.a($$2));
            });
         });
      }
   }

   public boolean b() {
      return this.c < a;
   }

   public String toString() {
      return this.d + " " + this.c + "...";
   }

   @VisibleForTesting
   LongSet c() {
      return new LongOpenHashSet(this.e);
   }

   static {
      a = aft.b + 2;
   }
}
