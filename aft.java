import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.collect.ImmutableList.Builder;
import com.google.gson.JsonElement;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.util.Either;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ByteMap;
import it.unimi.dsi.fastutil.longs.Long2ByteOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2LongMap;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.commons.lang3.mutable.MutableObject;
import org.slf4j.Logger;

public class aft extends cyj implements afs.e {
   private static final byte f = -1;
   private static final byte g = 0;
   private static final byte h = 1;
   private static final Logger i = LogUtils.getLogger();
   private static final int j = 200;
   private static final int k = 20;
   private static final int l = 10000;
   private static final int m = 3;
   public static final int a = 33;
   public static final int b = 33 + cxn.b();
   public static final int c = 31;
   private final Long2ObjectLinkedOpenHashMap<afs> n = new Long2ObjectLinkedOpenHashMap();
   private volatile Long2ObjectLinkedOpenHashMap<afs> o;
   private final Long2ObjectLinkedOpenHashMap<afs> p;
   private final LongSet q;
   final agg r;
   private final agj s;
   private final ayz<Runnable> t;
   private cxk u;
   private dbf v;
   private final Supplier<drm> w;
   private final bms x;
   final LongSet y;
   private boolean z;
   private final afv A;
   private final azb<afv.a<Runnable>> B;
   private final azb<afv.a<Runnable>> C;
   private final agp D;
   private final czb E;
   private final aft.a F;
   private final AtomicInteger G;
   private final dou H;
   private final String I;
   private final aga J;
   private final Int2ObjectMap<aft.b> K;
   private final Long2ByteMap L;
   private final Long2LongMap M;
   private final Queue<Runnable> N;
   int O;

   public aft(agg $$0, drq.c $$1, DataFixer $$2, dou $$3, Executor $$4, ayz<Runnable> $$5, cxv $$6, cxk $$7, agp $$8, czb $$9, Supplier<drm> $$10, int $$11, boolean $$12) {
      super($$1.a($$0.ab()).resolve("region"), $$2, $$12);
      this.o = this.n.clone();
      this.p = new Long2ObjectLinkedOpenHashMap();
      this.q = new LongOpenHashSet();
      this.y = new LongOpenHashSet();
      this.G = new AtomicInteger();
      this.J = new aga();
      this.K = new Int2ObjectOpenHashMap();
      this.L = new Long2ByteOpenHashMap();
      this.M = new Long2LongOpenHashMap();
      this.N = Queues.newConcurrentLinkedQueue();
      this.H = $$3;
      Path $$13 = $$1.a($$0.ab());
      this.I = $$13.getFileName().toString();
      this.r = $$0;
      this.u = $$7;
      if ($$7 instanceof dau) {
         dau $$14 = (dau)$$7;
         this.v = dbf.a((daw)$$14.h().a(), $$0.s().d(hm.aS), $$0.B());
      } else {
         this.v = dbf.a(daw.e(), $$0.s().d(hm.aS), $$0.B());
      }

      this.t = $$5;
      azc<Runnable> $$15 = azc.a($$4, "worldgen");
      Objects.requireNonNull($$5);
      azb<Runnable> $$16 = azb.a("main", $$5::i);
      this.D = $$8;
      this.E = $$9;
      azc<Runnable> $$17 = azc.a($$4, "light");
      this.A = new afv(ImmutableList.of($$15, $$16, $$17), $$4, Integer.MAX_VALUE);
      this.B = this.A.a($$15, false);
      this.C = this.A.a($$16, false);
      this.s = new agj($$6, this, this.r.q_().g(), $$17, this.A.a($$17, false));
      this.F = new aft.a($$4, $$5);
      this.w = $$10;
      this.x = new bms($$13.resolve("poi"), $$2, $$12, $$0.s(), $$0);
      this.a($$11);
   }

   protected cxk a() {
      return this.u;
   }

   protected dbf b() {
      return this.v;
   }

   public void c() {
      DataResult<JsonElement> $$0 = cxk.a.encodeStart(JsonOps.INSTANCE, this.u);
      DataResult<cxk> $$1 = $$0.flatMap(($$0x) -> {
         return cxk.a.parse(JsonOps.INSTANCE, $$0x);
      });
      $$1.result().ifPresent(($$0x) -> {
         this.u = $$0x;
      });
   }

   private static double a(cge $$0, bbn $$1) {
      double $$2 = (double)hq.a($$0.e, 8);
      double $$3 = (double)hq.a($$0.f, 8);
      double $$4 = $$2 - $$1.df();
      double $$5 = $$3 - $$1.dl();
      return $$4 * $$4 + $$5 * $$5;
   }

   public static boolean a(int $$0, int $$1, int $$2, int $$3, int $$4) {
      int $$5 = Math.max(0, Math.abs($$0 - $$2) - 1);
      int $$6 = Math.max(0, Math.abs($$1 - $$3) - 1);
      long $$7 = (long)Math.max(0, Math.max($$5, $$6) - 1);
      long $$8 = (long)Math.min($$5, $$6);
      long $$9 = $$8 * $$8 + $$7 * $$7;
      int $$10 = $$4 - 1;
      int $$11 = $$10 * $$10;
      return $$9 <= (long)$$11;
   }

   private static boolean b(int $$0, int $$1, int $$2, int $$3, int $$4) {
      if (!a($$0, $$1, $$2, $$3, $$4)) {
         return false;
      } else if (!a($$0 + 1, $$1, $$2, $$3, $$4)) {
         return true;
      } else if (!a($$0, $$1 + 1, $$2, $$3, $$4)) {
         return true;
      } else if (!a($$0 - 1, $$1, $$2, $$3, $$4)) {
         return true;
      } else {
         return !a($$0, $$1 - 1, $$2, $$3, $$4);
      }
   }

   protected agj d() {
      return this.s;
   }

   @Nullable
   protected afs a(long $$0) {
      return (afs)this.n.get($$0);
   }

   @Nullable
   protected afs b(long $$0) {
      return (afs)this.o.get($$0);
   }

   protected IntSupplier c(long $$0) {
      return () -> {
         afs $$1 = this.b($$0);
         return $$1 == null ? afu.a - 1 : Math.min($$1.l(), afu.a - 1);
      };
   }

   public String a(cge $$0) {
      afs $$1 = this.b($$0.a());
      if ($$1 == null) {
         return "null";
      } else {
         String $$2 = $$1.k() + "\n";
         cxn $$3 = $$1.f();
         cxj $$4 = $$1.g();
         if ($$3 != null) {
            $$2 = $$2 + "St: §" + $$3.c() + $$3 + "§r\n";
         }

         if ($$4 != null) {
            $$2 = $$2 + "Ch: §" + $$4.j().c() + $$4.j() + "§r\n";
         }

         afs.c $$5 = $$1.i();
         $$2 = $$2 + "§" + $$5.ordinal() + $$5;
         return $$2 + "§r";
      }
   }

   private CompletableFuture<Either<List<cxj>, afs.a>> a(cge $$0, int $$1, IntFunction<cxn> $$2) {
      List<CompletableFuture<Either<cxj, afs.a>>> $$3 = new ArrayList();
      List<afs> $$4 = new ArrayList();
      int $$5 = $$0.e;
      int $$6 = $$0.f;

      for(int $$7 = -$$1; $$7 <= $$1; ++$$7) {
         for(int $$8 = -$$1; $$8 <= $$1; ++$$8) {
            int $$9 = Math.max(Math.abs($$8), Math.abs($$7));
            final cge $$10 = new cge($$5 + $$8, $$6 + $$7);
            long $$11 = $$10.a();
            afs $$12 = this.a($$11);
            if ($$12 == null) {
               return CompletableFuture.completedFuture(Either.right(new afs.a() {
                  public String toString() {
                     return "Unloaded " + $$10;
                  }
               }));
            }

            cxn $$13 = (cxn)$$2.apply($$9);
            CompletableFuture<Either<cxj, afs.a>> $$14 = $$12.a($$13, this);
            $$4.add($$12);
            $$3.add($$14);
         }
      }

      CompletableFuture<List<Either<cxj, afs.a>>> $$15 = ad.b((List)$$3);
      CompletableFuture<Either<List<cxj>, afs.a>> $$16 = $$15.thenApply(($$3x) -> {
         List<cxj> $$4 = Lists.newArrayList();
         final int $$5x = 0;

         for(Iterator var7 = $$3x.iterator(); var7.hasNext(); ++$$5x) {
            final Either<cxj, afs.a> $$6x = (Either)var7.next();
            if ($$6x == null) {
               throw this.a(new IllegalStateException("At least one of the chunk futures were null"), "n/a");
            }

            Optional<cxj> $$7 = $$6x.left();
            if (!$$7.isPresent()) {
               return Either.right(new afs.a() {
                  public String toString() {
                     cge var10000 = new cge($$0 + $$5 % ($$1 * 2 + 1), $$2 + $$5 / ($$1 * 2 + 1));
                     return "Unloaded " + var10000 + " " + $$6.right().get();
                  }
               });
            }

            $$4.add((cxj)$$7.get());
         }

         return Either.left($$4);
      });
      Iterator var17 = $$4.iterator();

      while(var17.hasNext()) {
         afs $$17 = (afs)var17.next();
         $$17.a("getChunkRangeFuture " + $$0 + " " + $$1, $$16);
      }

      return $$16;
   }

   public z a(IllegalStateException $$0, String $$1) {
      StringBuilder $$2 = new StringBuilder();
      Consumer<afs> $$3 = ($$1x) -> {
         $$1x.o().forEach(($$2x) -> {
            cxn $$3 = (cxn)$$2x.getFirst();
            CompletableFuture<Either<cxj, afs.a>> $$4 = (CompletableFuture)$$2x.getSecond();
            if ($$4 != null && $$4.isDone() && $$4.join() == null) {
               $$2.append($$1x.j()).append(" - status: ").append($$3).append(" future: ").append($$4).append(System.lineSeparator());
            }

         });
      };
      $$2.append("Updating:").append(System.lineSeparator());
      this.n.values().forEach($$3);
      $$2.append("Visible:").append(System.lineSeparator());
      this.o.values().forEach($$3);
      q $$4 = q.a($$0, "Chunk loading");
      r $$5 = $$4.a("Chunk loading");
      $$5.a((String)"Details", (Object)$$1);
      $$5.a((String)"Futures", (Object)$$2);
      return new z($$4);
   }

   public CompletableFuture<Either<cxt, afs.a>> b(cge $$0) {
      return this.a($$0, 2, ($$0x) -> {
         return cxn.o;
      }).thenApplyAsync(($$0x) -> {
         return $$0x.mapLeft(($$0) -> {
            return (cxt)$$0.get($$0.size() / 2);
         });
      }, this.t);
   }

   @Nullable
   afs a(long $$0, int $$1, @Nullable afs $$2, int $$3) {
      if ($$3 > b && $$1 > b) {
         return $$2;
      } else {
         if ($$2 != null) {
            $$2.a($$1);
         }

         if ($$2 != null) {
            if ($$1 > b) {
               this.y.add($$0);
            } else {
               this.y.remove($$0);
            }
         }

         if ($$1 <= b && $$2 == null) {
            $$2 = (afs)this.p.remove($$0);
            if ($$2 != null) {
               $$2.a($$1);
            } else {
               $$2 = new afs(new cge($$0), $$1, this.r, this.s, this.A, this);
            }

            this.n.put($$0, $$2);
            this.z = true;
         }

         return $$2;
      }
   }

   public void close() throws IOException {
      try {
         this.A.close();
         this.x.close();
      } finally {
         super.close();
      }

   }

   protected void a(boolean $$0) {
      if ($$0) {
         List<afs> $$1 = (List)this.o.values().stream().filter(afs::m).peek(afs::n).collect(Collectors.toList());
         MutableBoolean $$2 = new MutableBoolean();

         do {
            $$2.setFalse();
            $$1.stream().map(($$0x) -> {
               CompletableFuture $$1;
               do {
                  $$1 = $$0x.h();
                  ayz var10000 = this.t;
                  Objects.requireNonNull($$1);
                  var10000.c($$1::isDone);
               } while($$1 != $$0x.h());

               return (cxj)$$1.join();
            }).filter(($$0x) -> {
               return $$0x instanceof cxs || $$0x instanceof cxt;
            }).filter(this::a).forEach(($$1x) -> {
               $$2.setTrue();
            });
         } while($$2.isTrue());

         this.b(() -> {
            return true;
         });
         this.n();
      } else {
         this.o.values().forEach(this::d);
      }

   }

   protected void a(BooleanSupplier $$0) {
      awz $$1 = this.r.ac();
      $$1.a("poi");
      this.x.a($$0);
      $$1.b("chunk_unload");
      if (!this.r.r()) {
         this.b($$0);
      }

      $$1.c();
   }

   public boolean e() {
      return this.s.A_() || !this.p.isEmpty() || !this.n.isEmpty() || this.x.a() || !this.y.isEmpty() || !this.N.isEmpty() || this.A.a() || this.F.f();
   }

   private void b(BooleanSupplier $$0) {
      LongIterator $$1 = this.y.iterator();

      for(int $$2 = 0; $$1.hasNext() && ($$0.getAsBoolean() || $$2 < 200 || this.y.size() > 2000); $$1.remove()) {
         long $$3 = $$1.nextLong();
         afs $$4 = (afs)this.n.remove($$3);
         if ($$4 != null) {
            this.p.put($$3, $$4);
            this.z = true;
            ++$$2;
            this.a($$3, $$4);
         }
      }

      int $$5 = Math.max(0, this.N.size() - 2000);

      Runnable $$6;
      while(($$0.getAsBoolean() || $$5 > 0) && ($$6 = (Runnable)this.N.poll()) != null) {
         --$$5;
         $$6.run();
      }

      int $$7 = 0;
      ObjectIterator $$8 = this.o.values().iterator();

      while($$7 < 20 && $$0.getAsBoolean() && $$8.hasNext()) {
         if (this.d((afs)$$8.next())) {
            ++$$7;
         }
      }

   }

   private void a(long $$0, afs $$1) {
      CompletableFuture<cxj> $$2 = $$1.h();
      Consumer var10001 = ($$3) -> {
         CompletableFuture<cxj> $$4 = $$1.h();
         if ($$4 != $$2) {
            this.a($$0, $$1);
         } else {
            if (this.p.remove($$0, $$1) && $$3 != null) {
               if ($$3 instanceof cxt) {
                  ((cxt)$$3).c(false);
               }

               this.a($$3);
               if (this.q.remove($$0) && $$3 instanceof cxt) {
                  cxt $$5 = (cxt)$$3;
                  this.r.a($$5);
               }

               this.s.a($$3.f());
               this.s.a();
               this.D.a($$3.f(), (cxn)null);
               this.M.remove($$3.f().a());
            }

         }
      };
      Queue var10002 = this.N;
      Objects.requireNonNull(var10002);
      $$2.thenAcceptAsync(var10001, var10002::add).whenComplete(($$1x, $$2x) -> {
         if ($$2x != null) {
            i.error("Failed to save chunk {}", $$1.j(), $$2x);
         }

      });
   }

   protected boolean f() {
      if (!this.z) {
         return false;
      } else {
         this.o = this.n.clone();
         this.z = false;
         return true;
      }
   }

   public CompletableFuture<Either<cxj, afs.a>> a(afs $$0, cxn $$1) {
      cge $$2 = $$0.j();
      if ($$1 == cxn.c) {
         return this.g($$2);
      } else {
         if ($$1 == cxn.l) {
            this.F.a(agl.e, $$2, 33 + cxn.a(cxn.l), $$2);
         }

         Optional<cxj> $$3 = ((Either)$$0.a($$1.e(), this).getNow(afs.a)).left();
         if ($$3.isPresent() && ((cxj)$$3.get()).j().b($$1)) {
            CompletableFuture<Either<cxj, afs.a>> $$4 = $$1.a(this.r, this.H, this.s, ($$1x) -> {
               return this.c($$0);
            }, (cxj)$$3.get());
            this.D.a($$2, $$1);
            return $$4;
         } else {
            return this.b($$0, $$1);
         }
      }
   }

   private CompletableFuture<Either<cxj, afs.a>> g(cge $$0) {
      return this.k($$0).thenApply(($$1) -> {
         return $$1.filter(($$1x) -> {
            boolean $$2 = b($$1x);
            if (!$$2) {
               i.error("Chunk file at {} is missing level data, skipping", $$0);
            }

            return $$2;
         });
      }).thenApplyAsync(($$1) -> {
         this.r.ac().d("chunkLoad");
         if ($$1.isPresent()) {
            cxj $$2 = cyi.a(this.r, this.x, $$0, (pj)$$1.get());
            this.a($$0, $$2.j().g());
            return Either.left($$2);
         } else {
            return Either.left(this.h($$0));
         }
      }, this.t).exceptionallyAsync(($$1) -> {
         return this.a($$1, $$0);
      }, this.t);
   }

   private static boolean b(pj $$0) {
      return $$0.b("Status", 8);
   }

   private Either<cxj, afs.a> a(Throwable $$0, cge $$1) {
      if ($$0 instanceof z) {
         z $$2 = (z)$$0;
         Throwable $$3 = $$2.getCause();
         if (!($$3 instanceof IOException)) {
            this.i($$1);
            throw $$2;
         }

         i.error("Couldn't load chunk {}", $$1, $$3);
      } else if ($$0 instanceof IOException) {
         i.error("Couldn't load chunk {}", $$1, $$0);
      }

      return Either.left(this.h($$1));
   }

   private cxj h(cge $$0) {
      this.i($$0);
      return new cyc($$0, cyf.a, this.r, this.r.s().d(hm.aR), (dbs)null);
   }

   private void i(cge $$0) {
      this.L.put($$0.a(), (byte)-1);
   }

   private byte a(cge $$0, cxn.a $$1) {
      return this.L.put($$0.a(), (byte)($$1 == cxn.a.a ? -1 : 1));
   }

   private CompletableFuture<Either<cxj, afs.a>> b(afs $$0, cxn $$1) {
      cge $$2 = $$0.j();
      CompletableFuture<Either<List<cxj>, afs.a>> $$3 = this.a($$2, $$1.f(), ($$1x) -> {
         return this.a($$1, $$1x);
      });
      this.r.ac().c(() -> {
         return "chunkGenerate " + $$1.d();
      });
      Executor $$4 = ($$1x) -> {
         this.B.a(afv.a($$0, $$1x));
      };
      return $$3.thenComposeAsync(($$4x) -> {
         return (CompletionStage)$$4x.map(($$4xx) -> {
            try {
               CompletableFuture<Either<cxj, afs.a>> $$5 = $$1.a($$4, this.r, this.u, this.H, this.s, ($$1x) -> {
                  return this.c($$0);
               }, $$4xx, false);
               this.D.a($$2, $$1);
               return $$5;
            } catch (Exception var9) {
               var9.getStackTrace();
               q $$7 = q.a(var9, "Exception generating new chunk");
               r $$8 = $$7.a("Chunk to be generated");
               $$8.a((String)"Location", (Object)String.format(Locale.ROOT, "%d,%d", $$2.e, $$2.f));
               $$8.a((String)"Position hash", (Object)cge.c($$2.e, $$2.f));
               $$8.a((String)"Generator", (Object)this.u);
               this.t.execute(() -> {
                  throw new z($$7);
               });
               throw new z($$7);
            }
         }, ($$1x) -> {
            this.c($$2);
            return CompletableFuture.completedFuture(Either.right($$1x));
         });
      }, $$4);
   }

   protected void c(cge $$0) {
      this.t.i(ad.a(() -> {
         this.F.b(agl.e, $$0, 33 + cxn.a(cxn.l), $$0);
      }, () -> {
         return "release light ticket " + $$0;
      }));
   }

   private cxn a(cxn $$0, int $$1) {
      cxn $$3;
      if ($$1 == 0) {
         $$3 = $$0.e();
      } else {
         $$3 = cxn.a(cxn.a($$0) + $$1);
      }

      return $$3;
   }

   private static void a(agg $$0, List<pj> $$1) {
      if (!$$1.isEmpty()) {
         $$0.b(bbr.a((List)$$1, (cgx)$$0));
      }

   }

   private CompletableFuture<Either<cxj, afs.a>> c(afs $$0) {
      CompletableFuture<Either<cxj, afs.a>> $$1 = $$0.a(cxn.o.e());
      return $$1.thenApplyAsync(($$1x) -> {
         cxn $$2 = afs.b($$0.k());
         return !$$2.b(cxn.o) ? afs.a : $$1x.mapLeft(($$1) -> {
            cge $$2 = $$0.j();
            cyc $$3 = (cyc)$$1;
            cxt $$5;
            if ($$3 instanceof cxs) {
               $$5 = ((cxs)$$3).A();
            } else {
               $$5 = new cxt(this.r, $$3, ($$1x) -> {
                  a(this.r, $$3.D());
               });
               $$0.a(new cxs($$5, false));
            }

            $$5.b(() -> {
               return afs.c($$0.k());
            });
            $$5.C();
            if (this.q.add($$2.a())) {
               $$5.c(true);
               $$5.H();
               $$5.a(this.r);
            }

            return $$5;
         });
      }, ($$1x) -> {
         azb var10000 = this.C;
         long var10002 = $$0.j().a();
         Objects.requireNonNull($$0);
         var10000.a(afv.a($$1x, var10002, $$0::k));
      });
   }

   public CompletableFuture<Either<cxt, afs.a>> a(afs $$0) {
      cge $$1 = $$0.j();
      CompletableFuture<Either<List<cxj>, afs.a>> $$2 = this.a($$1, 1, ($$0x) -> {
         return cxn.o;
      });
      CompletableFuture<Either<cxt, afs.a>> $$3 = $$2.thenApplyAsync(($$0x) -> {
         return $$0x.mapLeft(($$0) -> {
            return (cxt)$$0.get($$0.size() / 2);
         });
      }, ($$1x) -> {
         this.C.a(afv.a($$0, $$1x));
      }).thenApplyAsync(($$0x) -> {
         return $$0x.ifLeft(($$0) -> {
            $$0.F();
            this.r.b($$0);
         });
      }, this.t);
      $$3.thenAcceptAsync(($$1x) -> {
         $$1x.ifLeft(($$1xx) -> {
            this.G.getAndIncrement();
            MutableObject<uo> $$2 = new MutableObject();
            this.a($$1, false).forEach(($$2x) -> {
               this.a($$2x, $$2, $$1xx);
            });
         });
      }, ($$1x) -> {
         this.C.a(afv.a($$0, $$1x));
      });
      return $$3;
   }

   public CompletableFuture<Either<cxt, afs.a>> b(afs $$0) {
      return this.a($$0.j(), 1, cxn::a).thenApplyAsync(($$0x) -> {
         return $$0x.mapLeft(($$0) -> {
            cxt $$1 = (cxt)$$0.get($$0.size() / 2);
            return $$1;
         });
      }, ($$1) -> {
         this.C.a(afv.a($$0, $$1));
      });
   }

   public int g() {
      return this.G.get();
   }

   private boolean d(afs $$0) {
      if (!$$0.m()) {
         return false;
      } else {
         cxj $$1 = (cxj)$$0.h().getNow((Object)null);
         if (!($$1 instanceof cxs) && !($$1 instanceof cxt)) {
            return false;
         } else {
            long $$2 = $$1.f().a();
            long $$3 = this.M.getOrDefault($$2, -1L);
            long $$4 = System.currentTimeMillis();
            if ($$4 < $$3) {
               return false;
            } else {
               boolean $$5 = this.a($$1);
               $$0.n();
               if ($$5) {
                  this.M.put($$2, $$4 + 10000L);
               }

               return $$5;
            }
         }
      }
   }

   private boolean a(cxj $$0) {
      this.x.a((cge)$$0.f());
      if (!$$0.i()) {
         return false;
      } else {
         $$0.a(false);
         cge $$1 = $$0.f();

         try {
            cxn $$2 = $$0.j();
            if ($$2.g() != cxn.a.b) {
               if (this.j($$1)) {
                  return false;
               }

               if ($$2 == cxn.c && $$0.g().values().stream().noneMatch(dlj::b)) {
                  return false;
               }
            }

            this.r.ac().d("chunkSave");
            pj $$3 = cyi.a(this.r, $$0);
            this.a((cge)$$1, (pj)$$3);
            this.a($$1, $$2.g());
            return true;
         } catch (Exception var5) {
            i.error("Failed to save chunk {},{}", new Object[]{$$1.e, $$1.f, var5});
            return false;
         }
      }
   }

   private boolean j(cge $$0) {
      byte $$1 = this.L.get($$0.a());
      if ($$1 != 0) {
         return $$1 == 1;
      } else {
         pj $$4;
         try {
            $$4 = (pj)((Optional)this.k($$0).join()).orElse((Object)null);
            if ($$4 == null) {
               this.i($$0);
               return false;
            }
         } catch (Exception var5) {
            i.error("Failed to read chunk {}", $$0, var5);
            this.i($$0);
            return false;
         }

         cxn.a $$5 = cyi.a($$4);
         return this.a($$0, $$5) == 1;
      }
   }

   protected void a(int $$0) {
      int $$1 = ami.a((int)($$0 + 1), (int)3, (int)33);
      if ($$1 != this.O) {
         int $$2 = this.O;
         this.O = $$1;
         this.F.a(this.O + 1);
         ObjectIterator var4 = this.n.values().iterator();

         while(var4.hasNext()) {
            afs $$3 = (afs)var4.next();
            cge $$4 = $$3.j();
            MutableObject<uo> $$5 = new MutableObject();
            this.a($$4, false).forEach(($$3x) -> {
               hq $$4x = $$3x.R();
               boolean $$5x = a($$4.e, $$4.f, $$4x.a(), $$4x.c(), $$2);
               boolean $$6 = a($$4.e, $$4.f, $$4x.a(), $$4x.c(), this.O);
               this.a($$3x, $$4, $$5, $$5x, $$6);
            });
         }
      }

   }

   protected void a(agh $$0, cge $$1, MutableObject<uo> $$2, boolean $$3, boolean $$4) {
      if ($$0.s == this.r) {
         if ($$4 && !$$3) {
            afs $$5 = this.b($$1.a());
            if ($$5 != null) {
               cxt $$6 = $$5.d();
               if ($$6 != null) {
                  this.a($$0, $$2, $$6);
               }

               xl.a(this.r, $$1);
            }
         }

         if (!$$4 && $$3) {
            $$0.a($$1);
         }

      }
   }

   public int h() {
      return this.o.size();
   }

   public afz i() {
      return this.F;
   }

   protected Iterable<afs> j() {
      return Iterables.unmodifiableIterable(this.o.values());
   }

   void a(Writer $$0) throws IOException {
      alk $$1 = alk.a().a("x").a("z").a("level").a("in_memory").a("status").a("full_status").a("accessible_ready").a("ticking_ready").a("entity_ticking_ready").a("ticket").a("spawning").a("block_entity_count").a("ticking_ticket").a("ticking_level").a("block_ticks").a("fluid_ticks").a($$0);
      agm $$2 = this.F.d();
      ObjectBidirectionalIterator var4 = this.o.long2ObjectEntrySet().iterator();

      while(var4.hasNext()) {
         Entry<afs> $$3 = (Entry)var4.next();
         long $$4 = $$3.getLongKey();
         cge $$5 = new cge($$4);
         afs $$6 = (afs)$$3.getValue();
         Optional<cxj> $$7 = Optional.ofNullable($$6.g());
         Optional<cxt> $$8 = $$7.flatMap(($$0x) -> {
            return $$0x instanceof cxt ? Optional.of((cxt)$$0x) : Optional.empty();
         });
         $$1.a($$5.e, $$5.f, $$6.k(), $$7.isPresent(), $$7.map(cxj::j).orElse((Object)null), $$8.map(cxt::B).orElse((Object)null), a($$6.c()), a($$6.a()), a($$6.b()), this.F.e($$4), this.d($$5), $$8.map(($$0x) -> {
            return $$0x.E().size();
         }).orElse(0), $$2.d($$4), $$2.c($$4), $$8.map(($$0x) -> {
            return $$0x.o().a();
         }).orElse(0), $$8.map(($$0x) -> {
            return $$0x.p().a();
         }).orElse(0));
      }

   }

   private static String a(CompletableFuture<Either<cxt, afs.a>> $$0) {
      try {
         Either<cxt, afs.a> $$1 = (Either)$$0.getNow((Object)null);
         return $$1 != null ? (String)$$1.map(($$0x) -> {
            return "done";
         }, ($$0x) -> {
            return "unloaded";
         }) : "not completed";
      } catch (CompletionException var2) {
         return "failed " + var2.getCause().getMessage();
      } catch (CancellationException var3) {
         return "cancelled";
      }
   }

   private CompletableFuture<Optional<pj>> k(cge $$0) {
      return this.f($$0).thenApplyAsync(($$0x) -> {
         return $$0x.map(this::c);
      }, ad.g());
   }

   private pj c(pj $$0) {
      return this.a(this.r.ab(), this.w, $$0, this.u.c());
   }

   boolean d(cge $$0) {
      long $$1 = $$0.a();
      if (!this.F.f($$1)) {
         return false;
      } else {
         Iterator var4 = this.J.a($$1).iterator();

         agh $$2;
         do {
            if (!var4.hasNext()) {
               return false;
            }

            $$2 = (agh)var4.next();
         } while(!this.a($$2, $$0));

         return true;
      }
   }

   public List<agh> e(cge $$0) {
      long $$1 = $$0.a();
      if (!this.F.f($$1)) {
         return List.of();
      } else {
         Builder<agh> $$2 = ImmutableList.builder();
         Iterator var5 = this.J.a($$1).iterator();

         while(var5.hasNext()) {
            agh $$3 = (agh)var5.next();
            if (this.a($$3, $$0)) {
               $$2.add($$3);
            }
         }

         return $$2.build();
      }
   }

   private boolean a(agh $$0, cge $$1) {
      if ($$0.B_()) {
         return false;
      } else {
         double $$2 = a((cge)$$1, (bbn)$$0);
         return $$2 < 16384.0D;
      }
   }

   private boolean b(agh $$0) {
      return $$0.B_() && !this.r.W().b(cgt.q);
   }

   void a(agh $$0, boolean $$1) {
      boolean $$2 = this.b($$0);
      boolean $$3 = this.J.c($$0);
      int $$4 = hq.a($$0.de());
      int $$5 = hq.a($$0.dk());
      if ($$1) {
         this.J.a(cge.c($$4, $$5), $$0, $$2);
         this.c($$0);
         if (!$$2) {
            this.F.a(hq.a((czc)$$0), $$0);
         }
      } else {
         hq $$6 = $$0.R();
         this.J.a($$6.r().a(), $$0);
         if (!$$3) {
            this.F.b($$6, $$0);
         }
      }

      for(int $$7 = $$4 - this.O - 1; $$7 <= $$4 + this.O + 1; ++$$7) {
         for(int $$8 = $$5 - this.O - 1; $$8 <= $$5 + this.O + 1; ++$$8) {
            if (a($$7, $$8, $$4, $$5, this.O)) {
               cge $$9 = new cge($$7, $$8);
               this.a($$0, $$9, new MutableObject(), !$$1, $$1);
            }
         }
      }

   }

   private hq c(agh $$0) {
      hq $$1 = hq.a((czc)$$0);
      $$0.a($$1);
      $$0.b.a((tc)(new wd($$1.a(), $$1.c())));
      return $$1;
   }

   public void a(agh $$0) {
      ObjectIterator var2 = this.K.values().iterator();

      while(var2.hasNext()) {
         aft.b $$1 = (aft.b)var2.next();
         if ($$1.c == $$0) {
            $$1.a(this.r.w());
         } else {
            $$1.b($$0);
         }
      }

      int $$2 = hq.a($$0.de());
      int $$3 = hq.a($$0.dk());
      hq $$4 = $$0.R();
      hq $$5 = hq.a((czc)$$0);
      long $$6 = $$4.r().a();
      long $$7 = $$5.r().a();
      boolean $$8 = this.J.d($$0);
      boolean $$9 = this.b($$0);
      boolean $$10 = $$4.s() != $$5.s();
      if ($$10 || $$8 != $$9) {
         this.c($$0);
         if (!$$8) {
            this.F.b($$4, $$0);
         }

         if (!$$9) {
            this.F.a($$5, $$0);
         }

         if (!$$8 && $$9) {
            this.J.a($$0);
         }

         if ($$8 && !$$9) {
            this.J.b($$0);
         }

         if ($$6 != $$7) {
            this.J.a($$6, $$7, $$0);
         }
      }

      int $$11 = $$4.a();
      int $$12 = $$4.c();
      int $$25;
      int $$26;
      if (Math.abs($$11 - $$2) <= this.O * 2 && Math.abs($$12 - $$3) <= this.O * 2) {
         $$25 = Math.min($$2, $$11) - this.O - 1;
         $$26 = Math.min($$3, $$12) - this.O - 1;
         int $$15 = Math.max($$2, $$11) + this.O + 1;
         int $$16 = Math.max($$3, $$12) + this.O + 1;

         for(int $$17 = $$25; $$17 <= $$15; ++$$17) {
            for(int $$18 = $$26; $$18 <= $$16; ++$$18) {
               boolean $$19 = a($$17, $$18, $$11, $$12, this.O);
               boolean $$20 = a($$17, $$18, $$2, $$3, this.O);
               this.a($$0, new cge($$17, $$18), new MutableObject(), $$19, $$20);
            }
         }
      } else {
         boolean $$27;
         boolean $$28;
         for($$25 = $$11 - this.O - 1; $$25 <= $$11 + this.O + 1; ++$$25) {
            for($$26 = $$12 - this.O - 1; $$26 <= $$12 + this.O + 1; ++$$26) {
               if (a($$25, $$26, $$11, $$12, this.O)) {
                  $$27 = true;
                  $$28 = false;
                  this.a($$0, new cge($$25, $$26), new MutableObject(), true, false);
               }
            }
         }

         for($$25 = $$2 - this.O - 1; $$25 <= $$2 + this.O + 1; ++$$25) {
            for($$26 = $$3 - this.O - 1; $$26 <= $$3 + this.O + 1; ++$$26) {
               if (a($$25, $$26, $$2, $$3, this.O)) {
                  $$27 = false;
                  $$28 = true;
                  this.a($$0, new cge($$25, $$26), new MutableObject(), false, true);
               }
            }
         }
      }

   }

   public List<agh> a(cge $$0, boolean $$1) {
      Set<agh> $$2 = this.J.a($$0.a());
      Builder<agh> $$3 = ImmutableList.builder();
      Iterator var5 = $$2.iterator();

      while(true) {
         agh $$4;
         hq $$5;
         do {
            if (!var5.hasNext()) {
               return $$3.build();
            }

            $$4 = (agh)var5.next();
            $$5 = $$4.R();
         } while((!$$1 || !b($$0.e, $$0.f, $$5.a(), $$5.c(), this.O)) && ($$1 || !a($$0.e, $$0.f, $$5.a(), $$5.c(), this.O)));

         $$3.add($$4);
      }
   }

   protected void a(bbn $$0) {
      if (!($$0 instanceof bpn)) {
         bbr<?> $$1 = $$0.ad();
         int $$2 = $$1.n() * 16;
         if ($$2 != 0) {
            int $$3 = $$1.o();
            if (this.K.containsKey($$0.ae())) {
               throw (IllegalStateException)ad.c((Throwable)(new IllegalStateException("Entity is already tracked!")));
            } else {
               aft.b $$4 = new aft.b($$0, $$2, $$3, $$1.p());
               this.K.put($$0.ae(), $$4);
               $$4.a(this.r.w());
               if ($$0 instanceof agh) {
                  agh $$5 = (agh)$$0;
                  this.a($$5, true);
                  ObjectIterator var7 = this.K.values().iterator();

                  while(var7.hasNext()) {
                     aft.b $$6 = (aft.b)var7.next();
                     if ($$6.c != $$5) {
                        $$6.b($$5);
                     }
                  }
               }

            }
         }
      }
   }

   protected void b(bbn $$0) {
      if ($$0 instanceof agh) {
         agh $$1 = (agh)$$0;
         this.a($$1, false);
         ObjectIterator var3 = this.K.values().iterator();

         while(var3.hasNext()) {
            aft.b $$2 = (aft.b)var3.next();
            $$2.a($$1);
         }
      }

      aft.b $$3 = (aft.b)this.K.remove($$0.ae());
      if ($$3 != null) {
         $$3.a();
      }

   }

   protected void k() {
      List<agh> $$0 = Lists.newArrayList();
      List<agh> $$1 = this.r.w();
      ObjectIterator var3 = this.K.values().iterator();

      aft.b $$7;
      while(var3.hasNext()) {
         $$7 = (aft.b)var3.next();
         hq $$3 = $$7.e;
         hq $$4 = hq.a((czc)$$7.c);
         boolean $$5 = !Objects.equals($$3, $$4);
         if ($$5) {
            $$7.a($$1);
            bbn $$6 = $$7.c;
            if ($$6 instanceof agh) {
               $$0.add((agh)$$6);
            }

            $$7.e = $$4;
         }

         if ($$5 || this.F.c($$4.r().a())) {
            $$7.b.a();
         }
      }

      if (!$$0.isEmpty()) {
         var3 = this.K.values().iterator();

         while(var3.hasNext()) {
            $$7 = (aft.b)var3.next();
            $$7.a((List)$$0);
         }
      }

   }

   public void a(bbn $$0, tc<?> $$1) {
      aft.b $$2 = (aft.b)this.K.get($$0.ae());
      if ($$2 != null) {
         $$2.a($$1);
      }

   }

   protected void b(bbn $$0, tc<?> $$1) {
      aft.b $$2 = (aft.b)this.K.get($$0.ae());
      if ($$2 != null) {
         $$2.b($$1);
      }

   }

   private void a(agh $$0, MutableObject<uo> $$1, cxt $$2) {
      if ($$1.getValue() == null) {
         $$1.setValue(new uo($$2, this.s, (BitSet)null, (BitSet)null, true));
      }

      $$0.a($$2.f(), (tc)$$1.getValue());
      xl.a(this.r, $$2.f());
      List<bbn> $$3 = Lists.newArrayList();
      List<bbn> $$4 = Lists.newArrayList();
      ObjectIterator var6 = this.K.values().iterator();

      while(var6.hasNext()) {
         aft.b $$5 = (aft.b)var6.next();
         bbn $$6 = $$5.c;
         if ($$6 != $$0 && $$6.dc().equals($$2.f())) {
            $$5.b($$0);
            if ($$6 instanceof bce && ((bce)$$6).fz() != null) {
               $$3.add($$6);
            }

            if (!$$6.cI().isEmpty()) {
               $$4.add($$6);
            }
         }
      }

      Iterator var9;
      bbn $$8;
      if (!$$3.isEmpty()) {
         var9 = $$3.iterator();

         while(var9.hasNext()) {
            $$8 = (bbn)var9.next();
            $$0.b.a((tc)(new wj($$8, ((bce)$$8).fz())));
         }
      }

      if (!$$4.isEmpty()) {
         var9 = $$4.iterator();

         while(var9.hasNext()) {
            $$8 = (bbn)var9.next();
            $$0.b.a((tc)(new wp($$8)));
         }
      }

   }

   protected bms l() {
      return this.x;
   }

   public String m() {
      return this.I;
   }

   void a(cge $$0, afs.c $$1) {
      this.E.onChunkStatusChange($$0, $$1);
   }

   class a extends afz {
      protected a(Executor $$0, Executor $$1) {
         super($$0, $$1);
      }

      protected boolean a(long $$0) {
         return aft.this.y.contains($$0);
      }

      @Nullable
      protected afs b(long $$0) {
         return aft.this.a($$0);
      }

      @Nullable
      protected afs a(long $$0, int $$1, @Nullable afs $$2, int $$3) {
         return aft.this.a($$0, $$1, $$2, $$3);
      }
   }

   class b {
      final agf b;
      final bbn c;
      private final int d;
      hq e;
      private final Set<ahc> f = Sets.newIdentityHashSet();

      public b(bbn $$0, int $$1, int $$2, boolean $$3) {
         this.b = new agf(aft.this.r, $$0, $$2, $$3, this::a);
         this.c = $$0;
         this.d = $$1;
         this.e = hq.a((czc)$$0);
      }

      public boolean equals(Object $$0) {
         if ($$0 instanceof aft.b) {
            return ((aft.b)$$0).c.ae() == this.c.ae();
         } else {
            return false;
         }
      }

      public int hashCode() {
         return this.c.ae();
      }

      public void a(tc<?> $$0) {
         Iterator var2 = this.f.iterator();

         while(var2.hasNext()) {
            ahc $$1 = (ahc)var2.next();
            $$1.a($$0);
         }

      }

      public void b(tc<?> $$0) {
         this.a($$0);
         if (this.c instanceof agh) {
            ((agh)this.c).b.a($$0);
         }

      }

      public void a() {
         Iterator var1 = this.f.iterator();

         while(var1.hasNext()) {
            ahc $$0 = (ahc)var1.next();
            this.b.a($$0.f());
         }

      }

      public void a(agh $$0) {
         if (this.f.remove($$0.b)) {
            this.b.a($$0);
         }

      }

      public void b(agh $$0) {
         if ($$0 != this.c) {
            dwq $$1 = $$0.cY().d(this.c.cY());
            double $$2 = (double)Math.min(this.b(), (aft.this.O - 1) * 16);
            double $$3 = $$1.c * $$1.c + $$1.e * $$1.e;
            double $$4 = $$2 * $$2;
            boolean $$5 = $$3 <= $$4 && this.c.a($$0);
            if ($$5) {
               if (this.f.add($$0.b)) {
                  this.b.b($$0);
               }
            } else if (this.f.remove($$0.b)) {
               this.b.a($$0);
            }

         }
      }

      private int a(int $$0) {
         return aft.this.r.n().b($$0);
      }

      private int b() {
         int $$0 = this.d;
         Iterator var2 = this.c.cM().iterator();

         while(var2.hasNext()) {
            bbn $$1 = (bbn)var2.next();
            int $$2 = $$1.ad().n() * 16;
            if ($$2 > $$0) {
               $$0 = $$2;
            }
         }

         return this.a($$0);
      }

      public void a(List<agh> $$0) {
         Iterator var2 = $$0.iterator();

         while(var2.hasNext()) {
            agh $$1 = (agh)var2.next();
            this.b($$1);
         }

      }
   }
}
