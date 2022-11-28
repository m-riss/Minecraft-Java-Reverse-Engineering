import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.server.MinecraftServer;

public class abt {
   public static <D, R> CompletableFuture<R> a(abt.a $$0, abt.d<D> $$1, abt.c<D, R> $$2, Executor $$3, Executor $$4) {
      try {
         Pair<cgl, aid> $$5 = $$0.a.a();
         aid $$6 = (aid)$$5.getSecond();
         Pair<D, hn.a> $$7 = $$1.get($$6, (cgl)$$5.getFirst());
         D $$8 = $$7.getFirst();
         hn.a $$9 = (hn.a)$$7.getSecond();
         return abk.a($$6, $$9, $$0.b(), $$0.c(), $$3, $$4).whenComplete(($$1x, $$2x) -> {
            if ($$2x != null) {
               $$6.close();
            }

         }).thenApplyAsync(($$4x) -> {
            $$4x.a((hn)$$9);
            return $$2.create($$6, $$4x, $$9, $$8);
         }, $$4);
      } catch (Exception var10) {
         return CompletableFuture.failedFuture(var10);
      }
   }

   public static record a(abt.b a, ds.a b, int c) {
      final abt.b a;

      public a(abt.b $$0, ds.a $$1, int $$2) {
         this.a = $$0;
         this.b = $$1;
         this.c = $$2;
      }

      public abt.b a() {
         return this.a;
      }

      public ds.a b() {
         return this.b;
      }

      public int c() {
         return this.c;
      }
   }

   public static record b(ahy a, cgl b, boolean c) {
      public b(ahy $$0, cgl $$1, boolean $$2) {
         this.a = $$0;
         this.b = $$1;
         this.c = $$2;
      }

      public Pair<cgl, aid> a() {
         cgl $$0 = MinecraftServer.a(this.a, this.b, this.c);
         List<ahl> $$1 = this.a.f();
         aid $$2 = new aif(ahm.b, $$1);
         return Pair.of($$0, $$2);
      }

      public ahy b() {
         return this.a;
      }

      public cgl c() {
         return this.b;
      }

      public boolean d() {
         return this.c;
      }
   }

   @FunctionalInterface
   public interface d<D> {
      Pair<D, hn.a> get(aim var1, cgl var2);
   }

   @FunctionalInterface
   public interface c<D, R> {
      R create(aid var1, abk var2, hn.a var3, D var4);
   }
}
