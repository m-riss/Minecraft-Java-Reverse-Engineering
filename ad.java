import com.google.common.base.Ticker;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.MoreExecutors;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.DSL.TypeReference;
import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import it.unimi.dsi.fastutil.Hash.Strategy;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public class ad {
   static final Logger e = LogUtils.getLogger();
   private static final int f = 255;
   private static final String g = "max.bg.threads";
   private static final AtomicInteger h = new AtomicInteger(1);
   private static final ExecutorService i = b("Bootstrap");
   private static final ExecutorService j = b("Main");
   private static final ExecutorService k = o();
   private static final DateTimeFormatter l;
   public static anb.a a;
   public static final Ticker b;
   public static final UUID c;
   public static final FileSystemProvider d;
   private static Consumer<String> m;

   public static <K, V> Collector<Entry<? extends K, ? extends V>, ?, Map<K, V>> a() {
      return Collectors.toMap(Entry::getKey, Entry::getValue);
   }

   public static <T extends Comparable<T>> String a(cwr<T> $$0, Object $$1) {
      return $$0.a((Comparable)$$1);
   }

   public static String a(String $$0, @Nullable abb $$1) {
      return $$1 == null ? $$0 + ".unregistered_sadface" : $$0 + "." + $$1.b() + "." + $$1.a().replace('/', '.');
   }

   public static long b() {
      return c() / 1000000L;
   }

   public static long c() {
      return a.getAsLong();
   }

   public static long d() {
      return Instant.now().toEpochMilli();
   }

   public static String e() {
      return l.format(ZonedDateTime.now());
   }

   private static ExecutorService b(String $$0) {
      int $$1 = ami.a((int)(Runtime.getRuntime().availableProcessors() - 1), (int)1, (int)n());
      Object $$3;
      if ($$1 <= 0) {
         $$3 = MoreExecutors.newDirectExecutorService();
      } else {
         $$3 = new ForkJoinPool($$1, ($$1x) -> {
            ForkJoinWorkerThread $$2 = new ForkJoinWorkerThread($$1x) {
               protected void onTermination(Throwable $$0) {
                  if ($$0 != null) {
                     ad.e.warn("{} died", this.getName(), $$0);
                  } else {
                     ad.e.debug("{} shutdown", this.getName());
                  }

                  super.onTermination($$0);
               }
            };
            $$2.setName("Worker-" + $$0 + "-" + h.getAndIncrement());
            return $$2;
         }, ad::a, true);
      }

      return (ExecutorService)$$3;
   }

   private static int n() {
      String $$0 = System.getProperty("max.bg.threads");
      if ($$0 != null) {
         try {
            int $$1 = Integer.parseInt($$0);
            if ($$1 >= 1 && $$1 <= 255) {
               return $$1;
            }

            e.error("Wrong {} property value '{}'. Should be an integer value between 1 and {}.", new Object[]{"max.bg.threads", $$0, 255});
         } catch (NumberFormatException var2) {
            e.error("Could not parse {} property value '{}'. Should be an integer value between 1 and {}.", new Object[]{"max.bg.threads", $$0, 255});
         }
      }

      return 255;
   }

   public static ExecutorService f() {
      return i;
   }

   public static ExecutorService g() {
      return j;
   }

   public static ExecutorService h() {
      return k;
   }

   public static void i() {
      a(j);
      a(k);
   }

   private static void a(ExecutorService $$0) {
      $$0.shutdown();

      boolean $$3;
      try {
         $$3 = $$0.awaitTermination(3L, TimeUnit.SECONDS);
      } catch (InterruptedException var3) {
         $$3 = false;
      }

      if (!$$3) {
         $$0.shutdownNow();
      }

   }

   private static ExecutorService o() {
      return Executors.newCachedThreadPool(($$0) -> {
         Thread $$1 = new Thread($$0);
         $$1.setName("IO-Worker-" + h.getAndIncrement());
         $$1.setUncaughtExceptionHandler(ad::a);
         return $$1;
      });
   }

   public static <T> CompletableFuture<T> a(Throwable $$0) {
      CompletableFuture<T> $$1 = new CompletableFuture();
      $$1.completeExceptionally($$0);
      return $$1;
   }

   public static void b(Throwable $$0) {
      throw $$0 instanceof RuntimeException ? (RuntimeException)$$0 : new RuntimeException($$0);
   }

   private static void a(Thread $$0, Throwable $$1) {
      c($$1);
      if ($$1 instanceof CompletionException) {
         $$1 = $$1.getCause();
      }

      if ($$1 instanceof z) {
         abd.a(((z)$$1).a().e());
         System.exit(-1);
      }

      e.error(String.format(Locale.ROOT, "Caught exception in thread %s", $$0), $$1);
   }

   @Nullable
   public static Type<?> a(TypeReference $$0, String $$1) {
      return !ab.aK ? null : b($$0, $$1);
   }

   @Nullable
   private static Type<?> b(TypeReference $$0, String $$1) {
      Type $$2 = null;

      try {
         $$2 = ank.a().getSchema(DataFixUtils.makeKey(ab.b().getWorldVersion())).getChoiceType($$0, $$1);
      } catch (IllegalArgumentException var4) {
         e.error("No data fixer registered for {}", $$1);
         if (ab.aL) {
            throw var4;
         }
      }

      return $$2;
   }

   public static Runnable a(String $$0, Runnable $$1) {
      return ab.aL ? () -> {
         Thread $$2 = Thread.currentThread();
         String $$3 = $$2.getName();
         $$2.setName($$0);

         try {
            $$1.run();
         } finally {
            $$2.setName($$3);
         }

      } : $$1;
   }

   public static <V> Supplier<V> a(String $$0, Supplier<V> $$1) {
      return ab.aL ? () -> {
         Thread $$2 = Thread.currentThread();
         String $$3 = $$2.getName();
         $$2.setName($$0);

         Object var4;
         try {
            var4 = $$1.get();
         } finally {
            $$2.setName($$3);
         }

         return var4;
      } : $$1;
   }

   public static ad.b j() {
      String $$0 = System.getProperty("os.name").toLowerCase(Locale.ROOT);
      if ($$0.contains("win")) {
         return ad.b.c;
      } else if ($$0.contains("mac")) {
         return ad.b.d;
      } else if ($$0.contains("solaris")) {
         return ad.b.b;
      } else if ($$0.contains("sunos")) {
         return ad.b.b;
      } else if ($$0.contains("linux")) {
         return ad.b.a;
      } else {
         return $$0.contains("unix") ? ad.b.a : ad.b.e;
      }
   }

   public static Stream<String> k() {
      RuntimeMXBean $$0 = ManagementFactory.getRuntimeMXBean();
      return $$0.getInputArguments().stream().filter(($$0x) -> {
         return $$0x.startsWith("-X");
      });
   }

   public static <T> T a(List<T> $$0) {
      return $$0.get($$0.size() - 1);
   }

   public static <T> T a(Iterable<T> $$0, @Nullable T $$1) {
      Iterator<T> $$2 = $$0.iterator();
      T $$3 = $$2.next();
      if ($$1 != null) {
         Object $$4 = $$3;

         while($$4 != $$1) {
            if ($$2.hasNext()) {
               $$4 = $$2.next();
            }
         }

         if ($$2.hasNext()) {
            return $$2.next();
         }
      }

      return $$3;
   }

   public static <T> T b(Iterable<T> $$0, @Nullable T $$1) {
      Iterator<T> $$2 = $$0.iterator();

      Object $$3;
      Object $$4;
      for($$3 = null; $$2.hasNext(); $$3 = $$4) {
         $$4 = $$2.next();
         if ($$4 == $$1) {
            if ($$3 == null) {
               $$3 = $$2.hasNext() ? Iterators.getLast($$2) : $$1;
            }
            break;
         }
      }

      return $$3;
   }

   public static <T> T a(Supplier<T> $$0) {
      return $$0.get();
   }

   public static <T> T a(T $$0, Consumer<T> $$1) {
      $$1.accept($$0);
      return $$0;
   }

   @Nullable
   public static <T, R> R a(@Nullable T $$0, Function<T, R> $$1) {
      return $$0 == null ? null : $$1.apply($$0);
   }

   public static <T, R> R a(@Nullable T $$0, Function<T, R> $$1, R $$2) {
      return $$0 == null ? $$2 : $$1.apply($$0);
   }

   public static <K> Strategy<K> l() {
      return ad.a.a;
   }

   public static <V> CompletableFuture<List<V>> b(List<? extends CompletableFuture<V>> $$0) {
      if ($$0.isEmpty()) {
         return CompletableFuture.completedFuture(List.of());
      } else if ($$0.size() == 1) {
         return ((CompletableFuture)$$0.get(0)).thenApply(List::of);
      } else {
         CompletableFuture<Void> $$1 = CompletableFuture.allOf((CompletableFuture[])$$0.toArray(new CompletableFuture[0]));
         return $$1.thenApply(($$1x) -> {
            return $$0.stream().map(CompletableFuture::join).toList();
         });
      }
   }

   public static <V> CompletableFuture<List<V>> c(List<? extends CompletableFuture<? extends V>> $$0) {
      CompletableFuture<List<V>> $$1 = new CompletableFuture();
      Objects.requireNonNull($$1);
      return a($$0, $$1::completeExceptionally).applyToEither($$1, Function.identity());
   }

   public static <V> CompletableFuture<List<V>> d(List<? extends CompletableFuture<? extends V>> $$0) {
      CompletableFuture<List<V>> $$1 = new CompletableFuture();
      return a($$0, ($$2) -> {
         Iterator var3 = $$0.iterator();

         while(var3.hasNext()) {
            CompletableFuture<? extends V> $$3 = (CompletableFuture)var3.next();
            $$3.cancel(true);
         }

         $$1.completeExceptionally($$2);
      }).applyToEither($$1, Function.identity());
   }

   private static <V> CompletableFuture<List<V>> a(List<? extends CompletableFuture<? extends V>> $$0, Consumer<Throwable> $$1) {
      List<V> $$2 = Lists.newArrayListWithCapacity($$0.size());
      CompletableFuture<?>[] $$3 = new CompletableFuture[$$0.size()];
      $$0.forEach(($$3x) -> {
         int $$4 = $$2.size();
         $$2.add((Object)null);
         $$3[$$4] = $$3x.whenComplete(($$3xx, $$4x) -> {
            if ($$4x != null) {
               $$1.accept($$4x);
            } else {
               $$2.set($$4, $$3xx);
            }

         });
      });
      return CompletableFuture.allOf($$3).thenApply(($$1x) -> {
         return $$2;
      });
   }

   public static <T> Optional<T> a(Optional<T> $$0, Consumer<T> $$1, Runnable $$2) {
      if ($$0.isPresent()) {
         $$1.accept($$0.get());
      } else {
         $$2.run();
      }

      return $$0;
   }

   public static <T> Supplier<T> a(Supplier<T> $$0, Supplier<String> $$1) {
      return $$0;
   }

   public static Runnable a(Runnable $$0, Supplier<String> $$1) {
      return $$0;
   }

   public static void a(String $$0) {
      e.error($$0);
      if (ab.aL) {
         c($$0);
      }

   }

   public static void a(String $$0, Throwable $$1) {
      e.error($$0, $$1);
      if (ab.aL) {
         c($$0);
      }

   }

   public static <T extends Throwable> T c(T $$0) {
      if (ab.aL) {
         e.error("Trying to throw a fatal exception, pausing in IDE", $$0);
         c($$0.getMessage());
      }

      return $$0;
   }

   public static void a(Consumer<String> $$0) {
      m = $$0;
   }

   private static void c(String $$0) {
      Instant $$1 = Instant.now();
      e.warn("Did you remember to set a breakpoint here?");
      boolean $$2 = Duration.between($$1, Instant.now()).toMillis() > 500L;
      if (!$$2) {
         m.accept($$0);
      }

   }

   public static String d(Throwable $$0) {
      if ($$0.getCause() != null) {
         return d($$0.getCause());
      } else {
         return $$0.getMessage() != null ? $$0.getMessage() : $$0.toString();
      }
   }

   public static <T> T a(T[] $$0, amn $$1) {
      return $$0[$$1.a($$0.length)];
   }

   public static int a(int[] $$0, amn $$1) {
      return $$0[$$1.a($$0.length)];
   }

   public static <T> T a(List<T> $$0, amn $$1) {
      return $$0.get($$1.a($$0.size()));
   }

   public static <T> Optional<T> b(List<T> $$0, amn $$1) {
      return $$0.isEmpty() ? Optional.empty() : Optional.of(a($$0, $$1));
   }

   private static BooleanSupplier a(final Path $$0, final Path $$1) {
      return new BooleanSupplier() {
         public boolean getAsBoolean() {
            try {
               Files.move($$0, $$1);
               return true;
            } catch (IOException var2) {
               ad.e.error("Failed to rename", var2);
               return false;
            }
         }

         public String toString() {
            return "rename " + $$0 + " to " + $$1;
         }
      };
   }

   private static BooleanSupplier a(final Path $$0) {
      return new BooleanSupplier() {
         public boolean getAsBoolean() {
            try {
               Files.deleteIfExists($$0);
               return true;
            } catch (IOException var2) {
               ad.e.warn("Failed to delete", var2);
               return false;
            }
         }

         public String toString() {
            return "delete old " + $$0;
         }
      };
   }

   private static BooleanSupplier b(final Path $$0) {
      return new BooleanSupplier() {
         public boolean getAsBoolean() {
            return !Files.exists($$0, new LinkOption[0]);
         }

         public String toString() {
            return "verify that " + $$0 + " is deleted";
         }
      };
   }

   private static BooleanSupplier c(final Path $$0) {
      return new BooleanSupplier() {
         public boolean getAsBoolean() {
            return Files.isRegularFile($$0, new LinkOption[0]);
         }

         public String toString() {
            return "verify that " + $$0 + " is present";
         }
      };
   }

   private static boolean a(BooleanSupplier... $$0) {
      BooleanSupplier[] var1 = $$0;
      int var2 = $$0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         BooleanSupplier $$1 = var1[var3];
         if (!$$1.getAsBoolean()) {
            e.warn("Failed to execute {}", $$1);
            return false;
         }
      }

      return true;
   }

   private static boolean a(int $$0, String $$1, BooleanSupplier... $$2) {
      for(int $$3 = 0; $$3 < $$0; ++$$3) {
         if (a($$2)) {
            return true;
         }

         e.error("Failed to {}, retrying {}/{}", new Object[]{$$1, $$3, $$0});
      }

      e.error("Failed to {}, aborting, progress might be lost", $$1);
      return false;
   }

   public static void a(File $$0, File $$1, File $$2) {
      a($$0.toPath(), $$1.toPath(), $$2.toPath());
   }

   public static void a(Path $$0, Path $$1, Path $$2) {
      a($$0, $$1, $$2, false);
   }

   public static void a(File $$0, File $$1, File $$2, boolean $$3) {
      a($$0.toPath(), $$1.toPath(), $$2.toPath(), $$3);
   }

   public static void a(Path $$0, Path $$1, Path $$2, boolean $$3) {
      int $$4 = true;
      if (!Files.exists($$0, new LinkOption[0]) || a(10, "create backup " + $$2, a($$2), a($$0, $$2), c($$2))) {
         if (a(10, "remove old " + $$0, a($$0), b($$0))) {
            if (!a(10, "replace " + $$0 + " with " + $$1, a($$1, $$0), c($$0)) && !$$3) {
               a(10, "restore " + $$0 + " from " + $$2, a($$2, $$0), c($$0));
            }

         }
      }
   }

   public static int a(String $$0, int $$1, int $$2) {
      int $$3 = $$0.length();
      int $$4;
      if ($$2 >= 0) {
         for($$4 = 0; $$1 < $$3 && $$4 < $$2; ++$$4) {
            if (Character.isHighSurrogate($$0.charAt($$1++)) && $$1 < $$3 && Character.isLowSurrogate($$0.charAt($$1))) {
               ++$$1;
            }
         }
      } else {
         for($$4 = $$2; $$1 > 0 && $$4 < 0; ++$$4) {
            --$$1;
            if (Character.isLowSurrogate($$0.charAt($$1)) && $$1 > 0 && Character.isHighSurrogate($$0.charAt($$1 - 1))) {
               --$$1;
            }
         }
      }

      return $$1;
   }

   public static Consumer<String> a(String $$0, Consumer<String> $$1) {
      return ($$2) -> {
         $$1.accept($$0 + $$2);
      };
   }

   public static DataResult<int[]> a(IntStream $$0, int $$1) {
      int[] $$2 = $$0.limit((long)($$1 + 1)).toArray();
      if ($$2.length != $$1) {
         String $$3 = "Input is not a list of " + $$1 + " ints";
         return $$2.length >= $$1 ? DataResult.error($$3, Arrays.copyOf($$2, $$1)) : DataResult.error($$3);
      } else {
         return DataResult.success($$2);
      }
   }

   public static <T> DataResult<List<T>> a(List<T> $$0, int $$1) {
      if ($$0.size() != $$1) {
         String $$2 = "Input is not a list of " + $$1 + " elements";
         return $$0.size() >= $$1 ? DataResult.error($$2, $$0.subList(0, $$1)) : DataResult.error($$2);
      } else {
         return DataResult.success($$0);
      }
   }

   public static void m() {
      Thread $$0 = new Thread("Timer hack thread") {
         public void run() {
            while(true) {
               try {
                  Thread.sleep(2147483647L);
               } catch (InterruptedException var2) {
                  ad.e.warn("Timer hack thread interrupted, that really should not happen");
                  return;
               }
            }
         }
      };
      $$0.setDaemon(true);
      $$0.setUncaughtExceptionHandler(new t(e));
      $$0.start();
   }

   public static void b(Path $$0, Path $$1, Path $$2) throws IOException {
      Path $$3 = $$0.relativize($$2);
      Path $$4 = $$1.resolve($$3);
      Files.copy($$2, $$4);
   }

   public static String a(String $$0, o $$1) {
      return (String)$$0.toLowerCase(Locale.ROOT).chars().mapToObj(($$1x) -> {
         return $$1.test((char)$$1x) ? Character.toString((char)$$1x) : "_";
      }).collect(Collectors.joining());
   }

   public static <T, R> Function<T, R> a(final Function<T, R> $$0) {
      return new Function<T, R>() {
         private final Map<T, R> b = Maps.newHashMap();

         public R apply(T $$0x) {
            return this.b.computeIfAbsent($$0x, $$0);
         }

         public String toString() {
            Function var10000 = $$0;
            return "memoize/1[function=" + var10000 + ", size=" + this.b.size() + "]";
         }
      };
   }

   public static <T, U, R> BiFunction<T, U, R> a(final BiFunction<T, U, R> $$0) {
      return new BiFunction<T, U, R>() {
         private final Map<Pair<T, U>, R> b = Maps.newHashMap();

         public R apply(T $$0x, U $$1) {
            return this.b.computeIfAbsent(Pair.of($$0x, $$1), ($$1x) -> {
               return $$0.apply($$1x.getFirst(), $$1x.getSecond());
            });
         }

         public String toString() {
            BiFunction var10000 = $$0;
            return "memoize/2[function=" + var10000 + ", size=" + this.b.size() + "]";
         }
      };
   }

   public static <T> List<T> a(Stream<T> $$0, amn $$1) {
      ObjectArrayList<T> $$2 = (ObjectArrayList)$$0.collect(ObjectArrayList.toList());
      b($$2, $$1);
      return $$2;
   }

   public static IntArrayList a(IntStream $$0, amn $$1) {
      IntArrayList $$2 = IntArrayList.wrap($$0.toArray());
      int $$3 = $$2.size();

      for(int $$4 = $$3; $$4 > 1; --$$4) {
         int $$5 = $$1.a($$4);
         $$2.set($$4 - 1, $$2.set($$5, $$2.getInt($$4 - 1)));
      }

      return $$2;
   }

   public static <T> List<T> b(T[] $$0, amn $$1) {
      ObjectArrayList<T> $$2 = new ObjectArrayList($$0);
      b($$2, $$1);
      return $$2;
   }

   public static <T> List<T> a(ObjectArrayList<T> $$0, amn $$1) {
      ObjectArrayList<T> $$2 = new ObjectArrayList($$0);
      b($$2, $$1);
      return $$2;
   }

   public static <T> void b(ObjectArrayList<T> $$0, amn $$1) {
      int $$2 = $$0.size();

      for(int $$3 = $$2; $$3 > 1; --$$3) {
         int $$4 = $$1.a($$3);
         $$0.set($$3 - 1, $$0.set($$4, $$0.get($$3 - 1)));
      }

   }

   public static <T> CompletableFuture<T> b(Function<Executor, CompletableFuture<T>> $$0) {
      return (CompletableFuture)a($$0, CompletableFuture::isDone);
   }

   public static <T> T a(Function<Executor, T> $$0, Predicate<T> $$1) {
      BlockingQueue<Runnable> $$2 = new LinkedBlockingQueue();
      Objects.requireNonNull($$2);
      Object $$3 = $$0.apply($$2::add);

      while(!$$1.test($$3)) {
         try {
            Runnable $$4 = (Runnable)$$2.poll(100L, TimeUnit.MILLISECONDS);
            if ($$4 != null) {
               $$4.run();
            }
         } catch (InterruptedException var5) {
            e.warn("Interrupted wait");
            break;
         }
      }

      int $$6 = $$2.size();
      if ($$6 > 0) {
         e.warn("Tasks left in queue: {}", $$6);
      }

      return $$3;
   }

   public static <T> ToIntFunction<T> e(List<T> $$0) {
      return a($$0, Object2IntOpenHashMap::new);
   }

   public static <T> ToIntFunction<T> a(List<T> $$0, IntFunction<Object2IntMap<T>> $$1) {
      Object2IntMap<T> $$2 = (Object2IntMap)$$1.apply($$0.size());

      for(int $$3 = 0; $$3 < $$0.size(); ++$$3) {
         $$2.put($$0.get($$3), $$3);
      }

      return $$2;
   }

   static {
      l = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss", Locale.ROOT);
      a = System::nanoTime;
      b = new Ticker() {
         public long read() {
            return ad.a.getAsLong();
         }
      };
      c = new UUID(0L, 0L);
      d = (FileSystemProvider)FileSystemProvider.installedProviders().stream().filter(($$0) -> {
         return $$0.getScheme().equalsIgnoreCase("jar");
      }).findFirst().orElseThrow(() -> {
         return new IllegalStateException("No jar file system provider found");
      });
      m = ($$0) -> {
      };
   }

   public static enum b {
      a("linux"),
      b("solaris"),
      c("windows") {
         protected String[] b(URL $$0) {
            return new String[]{"rundll32", "url.dll,FileProtocolHandler", $$0.toString()};
         }
      },
      d("mac") {
         protected String[] b(URL $$0) {
            return new String[]{"open", $$0.toString()};
         }
      },
      e("unknown");

      private final String f;

      b(String $$0) {
         this.f = $$0;
      }

      public void a(URL $$0) {
         try {
            Process $$1 = (Process)AccessController.doPrivileged(() -> {
               return Runtime.getRuntime().exec(this.b($$0));
            });
            $$1.getInputStream().close();
            $$1.getErrorStream().close();
            $$1.getOutputStream().close();
         } catch (IOException | PrivilegedActionException var3) {
            ad.e.error("Couldn't open url '{}'", $$0, var3);
         }

      }

      public void a(URI $$0) {
         try {
            this.a($$0.toURL());
         } catch (MalformedURLException var3) {
            ad.e.error("Couldn't open uri '{}'", $$0, var3);
         }

      }

      public void a(File $$0) {
         try {
            this.a($$0.toURI().toURL());
         } catch (MalformedURLException var3) {
            ad.e.error("Couldn't open file '{}'", $$0, var3);
         }

      }

      protected String[] b(URL $$0) {
         String $$1 = $$0.toString();
         if ("file".equals($$0.getProtocol())) {
            $$1 = $$1.replace("file:", "file://");
         }

         return new String[]{"xdg-open", $$1};
      }

      public void a(String $$0) {
         try {
            this.a((new URI($$0)).toURL());
         } catch (MalformedURLException | IllegalArgumentException | URISyntaxException var3) {
            ad.e.error("Couldn't open uri '{}'", $$0, var3);
         }

      }

      public String a() {
         return this.f;
      }

      // $FF: synthetic method
      private static ad.b[] b() {
         return new ad.b[]{a, b, c, d, e};
      }
   }

   private static enum a implements Strategy<Object> {
      a;

      public int hashCode(Object $$0) {
         return System.identityHashCode($$0);
      }

      public boolean equals(Object $$0, Object $$1) {
         return $$0 == $$1;
      }

      // $FF: synthetic method
      private static ad.a[] a() {
         return new ad.a[]{a};
      }
   }
}
