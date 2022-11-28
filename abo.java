import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;

public class abo {
   private static final rq a = rq.c("commands.debug.function.noRecursion");
   private static final abb b = new abb("tick");
   private static final abb c = new abb("load");
   final MinecraftServer d;
   @Nullable
   private abo.a e;
   private List<dm> f = ImmutableList.of();
   private boolean g;
   private abn h;

   public abo(MinecraftServer $$0, abn $$1) {
      this.d = $$0;
      this.h = $$1;
      this.b($$1);
   }

   public int a() {
      return this.d.aK().c(cgt.w);
   }

   public CommandDispatcher<dr> b() {
      return this.d.aC().a();
   }

   public void c() {
      this.a((Collection)this.f, (abb)b);
      if (this.g) {
         this.g = false;
         Collection<dm> $$0 = this.h.b(c);
         this.a($$0, c);
      }

   }

   private void a(Collection<dm> $$0, abb $$1) {
      awz var10000 = this.d.aP();
      Objects.requireNonNull($$1);
      var10000.a($$1::toString);
      Iterator var3 = $$0.iterator();

      while(var3.hasNext()) {
         dm $$2 = (dm)var3.next();
         this.a($$2, this.d());
      }

      this.d.aP().c();
   }

   public int a(dm $$0, dr $$1) {
      return this.a($$0, $$1, (abo.c)null);
   }

   public int a(dm $$0, dr $$1, @Nullable abo.c $$2) {
      if (this.e != null) {
         if ($$2 != null) {
            this.e.a(a.getString());
            return 0;
         } else {
            this.e.a($$0, $$1);
            return 0;
         }
      } else {
         int var4;
         try {
            this.e = new abo.a($$2);
            var4 = this.e.b($$0, $$1);
         } finally {
            this.e = null;
         }

         return var4;
      }
   }

   public void a(abn $$0) {
      this.h = $$0;
      this.b($$0);
   }

   private void b(abn $$0) {
      this.f = ImmutableList.copyOf($$0.b(b));
      this.g = true;
   }

   public dr d() {
      return this.d.aD().a(2).a();
   }

   public Optional<dm> a(abb $$0) {
      return this.h.a($$0);
   }

   public Collection<dm> b(abb $$0) {
      return this.h.b($$0);
   }

   public Iterable<abb> e() {
      return this.h.a().keySet();
   }

   public Iterable<abb> f() {
      return this.h.b();
   }

   public interface c {
      void a(int var1, String var2);

      void a(int var1, String var2, int var3);

      void b(int var1, String var2);

      void a(int var1, abb var2, int var3);
   }

   class a {
      private int b;
      @Nullable
      private final abo.c c;
      private final Deque<abo.b> d = Queues.newArrayDeque();
      private final List<abo.b> e = Lists.newArrayList();

      a(@Nullable abo.c $$0) {
         this.c = $$0;
      }

      void a(dm $$0, dr $$1) {
         int $$2 = abo.this.a();
         if (this.d.size() + this.e.size() < $$2) {
            this.e.add(new abo.b($$1, this.b, new dm.d($$0)));
         }

      }

      int b(dm $$0, dr $$1) {
         int $$2 = abo.this.a();
         int $$3 = 0;
         dm.c[] $$4 = $$0.b();

         for(int $$5 = $$4.length - 1; $$5 >= 0; --$$5) {
            this.d.push(new abo.b($$1, 0, $$4[$$5]));
         }

         do {
            if (this.d.isEmpty()) {
               return $$3;
            }

            try {
               abo.b $$6 = (abo.b)this.d.removeFirst();
               awz var10000 = abo.this.d.aP();
               Objects.requireNonNull($$6);
               var10000.a($$6::toString);
               this.b = $$6.b;
               $$6.a(abo.this, this.d, $$2, this.c);
               if (!this.e.isEmpty()) {
                  List var10 = Lists.reverse(this.e);
                  Deque var10001 = this.d;
                  Objects.requireNonNull(var10001);
                  var10.forEach(var10001::addFirst);
                  this.e.clear();
               }
            } finally {
               abo.this.d.aP().c();
            }

            ++$$3;
         } while($$3 < $$2);

         return $$3;
      }

      public void a(String $$0) {
         if (this.c != null) {
            this.c.b(this.b, $$0);
         }

      }
   }

   public static class b {
      private final dr a;
      final int b;
      private final dm.c c;

      public b(dr $$0, int $$1, dm.c $$2) {
         this.a = $$0;
         this.b = $$1;
         this.c = $$2;
      }

      public void a(abo $$0, Deque<abo.b> $$1, int $$2, @Nullable abo.c $$3) {
         try {
            this.c.execute($$0, this.a, $$1, $$2, this.b, $$3);
         } catch (CommandSyntaxException var6) {
            if ($$3 != null) {
               $$3.b(this.b, var6.getRawMessage().getString());
            }
         } catch (Exception var7) {
            if ($$3 != null) {
               $$3.b(this.b, var7.getMessage());
            }
         }

      }

      public String toString() {
         return this.c.toString();
      }
   }
}
