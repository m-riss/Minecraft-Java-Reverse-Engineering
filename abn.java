import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.ImmutableMap.Builder;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class abn implements aig {
   private static final Logger a = LogUtils.getLogger();
   private static final String b = ".mcfunction";
   private static final int c = "functions/".length();
   private static final int d = ".mcfunction".length();
   private volatile Map<abb, dm> e = ImmutableMap.of();
   private final ala<dm> f = new ala(this::a, "tags/functions");
   private volatile Map<abb, Collection<dm>> g = Map.of();
   private final int h;
   private final CommandDispatcher<dr> i;

   public Optional<dm> a(abb $$0) {
      return Optional.ofNullable((dm)this.e.get($$0));
   }

   public Map<abb, dm> a() {
      return this.e;
   }

   public Collection<dm> b(abb $$0) {
      return (Collection)this.g.getOrDefault($$0, List.of());
   }

   public Iterable<abb> b() {
      return this.g.keySet();
   }

   public abn(int $$0, CommandDispatcher<dr> $$1) {
      this.h = $$0;
      this.i = $$1;
   }

   public CompletableFuture<Void> a(aig.a $$0, aim $$1, awz $$2, awz $$3, Executor $$4, Executor $$5) {
      CompletableFuture<Map<abb, List<ala.a>>> $$6 = CompletableFuture.supplyAsync(() -> {
         return this.f.a($$1);
      }, $$4);
      CompletableFuture<Map<abb, CompletableFuture<dm>>> $$7 = CompletableFuture.supplyAsync(() -> {
         return $$1.b("functions", ($$0) -> {
            return $$0.a().endsWith(".mcfunction");
         });
      }, $$4).thenCompose(($$1x) -> {
         Map<abb, CompletableFuture<dm>> $$2 = Maps.newHashMap();
         dr $$3 = new dr(dq.a, dwq.b, dwp.a, (agg)null, this.h, "", rp.a, (MinecraftServer)null, (bbn)null);
         Iterator var5 = $$1x.entrySet().iterator();

         while(var5.hasNext()) {
            Entry<abb, aik> $$4x = (Entry)var5.next();
            abb $$5 = (abb)$$4x.getKey();
            String $$6 = $$5.a();
            abb $$7 = new abb($$5.b(), $$6.substring(c, $$6.length() - d));
            $$2.put($$7, CompletableFuture.supplyAsync(() -> {
               List<String> $$3x = a((aik)$$4x.getValue());
               return dm.a($$7, this.i, $$3, $$3x);
            }, $$4));
         }

         CompletableFuture<?>[] $$8 = (CompletableFuture[])$$2.values().toArray(new CompletableFuture[0]);
         return CompletableFuture.allOf($$8).handle(($$1, $$2x) -> {
            return $$2;
         });
      });
      CompletableFuture var10000 = $$6.thenCombine($$7, Pair::of);
      Objects.requireNonNull($$0);
      return var10000.thenCompose($$0::a).thenAcceptAsync(($$0x) -> {
         Map<abb, CompletableFuture<dm>> $$1 = (Map)$$0x.getSecond();
         Builder<abb, dm> $$2 = ImmutableMap.builder();
         $$1.forEach(($$1x, $$2x) -> {
            $$2x.handle(($$2xx, $$3) -> {
               if ($$3 != null) {
                  a.error("Failed to load function {}", $$1x, $$3);
               } else {
                  $$2.put($$1x, $$2xx);
               }

               return null;
            }).join();
         });
         this.e = $$2.build();
         this.g = this.f.a((Map)$$0x.getFirst());
      }, $$5);
   }

   private static List<String> a(aik $$0) {
      try {
         BufferedReader $$1 = $$0.c();

         List var2;
         try {
            var2 = $$1.lines().toList();
         } catch (Throwable var5) {
            if ($$1 != null) {
               try {
                  $$1.close();
               } catch (Throwable var4) {
                  var5.addSuppressed(var4);
               }
            }

            throw var5;
         }

         if ($$1 != null) {
            $$1.close();
         }

         return var2;
      } catch (IOException var6) {
         throw new CompletionException(var6);
      }
   }
}
