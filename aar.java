import com.google.common.collect.Lists;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public class aar<C extends bac> implements aaq<Integer> {
   private static final Logger d = LogUtils.getLogger();
   protected final bug a = new bug();
   protected bub b;
   protected bxv<C> c;

   public aar(bxv<C> $$0) {
      this.c = $$0;
   }

   public void a(agh $$0, @Nullable cdp<C> $$1, boolean $$2) {
      if ($$1 != null && $$0.E().b($$1)) {
         this.b = $$0.fA();
         if (this.a() || $$0.f()) {
            this.a.a();
            $$0.fA().a(this.a);
            this.c.a(this.a);
            if (this.a.a($$1, (IntList)null)) {
               this.a($$1, $$2);
            } else {
               this.a(true);
               $$0.b.a((tc)(new vc($$0.bU.j, $$1)));
            }

            $$0.fA().e();
         }
      }
   }

   protected void a(boolean $$0) {
      for(int $$1 = 0; $$1 < this.c.p(); ++$$1) {
         if (this.c.e($$1)) {
            cax $$2 = this.c.b($$1).e().o();
            this.b.a($$2, false);
            this.c.b($$1).d($$2);
         }
      }

      this.c.l();
   }

   protected void a(cdp<C> $$0, boolean $$1) {
      boolean $$2 = this.c.a($$0);
      int $$3 = this.a.b($$0, (IntList)null);
      int $$4;
      if ($$2) {
         for($$4 = 0; $$4 < this.c.o() * this.c.n() + 1; ++$$4) {
            if ($$4 != this.c.m()) {
               cax $$5 = this.c.b($$4).e();
               if (!$$5.b() && Math.min($$3, $$5.f()) < $$5.K() + 1) {
                  return;
               }
            }
         }
      }

      $$4 = this.a($$1, $$3, $$2);
      IntList $$7 = new IntArrayList();
      if (this.a.a($$0, $$7, $$4)) {
         int $$8 = $$4;
         IntListIterator var8 = $$7.iterator();

         while(var8.hasNext()) {
            int $$9 = (Integer)var8.next();
            int $$10 = bug.a($$9).f();
            if ($$10 < $$8) {
               $$8 = $$10;
            }
         }

         if (this.a.a($$0, $$7, $$8)) {
            this.a(false);
            this.a(this.c.n(), this.c.o(), this.c.m(), $$0, $$7.iterator(), $$8);
         }
      }

   }

   public void a(Iterator<Integer> $$0, int $$1, int $$2, int $$3, int $$4) {
      byd $$5 = this.c.b($$1);
      cax $$6 = bug.a((Integer)$$0.next());
      if (!$$6.b()) {
         for(int $$7 = 0; $$7 < $$2; ++$$7) {
            this.a($$5, $$6);
         }
      }

   }

   protected int a(boolean $$0, int $$1, boolean $$2) {
      int $$3 = 1;
      if ($$0) {
         $$3 = $$1;
      } else if ($$2) {
         $$3 = 64;

         for(int $$4 = 0; $$4 < this.c.n() * this.c.o() + 1; ++$$4) {
            if ($$4 != this.c.m()) {
               cax $$5 = this.c.b($$4).e();
               if (!$$5.b() && $$3 > $$5.K()) {
                  $$3 = $$5.K();
               }
            }
         }

         if ($$3 < 64) {
            ++$$3;
         }
      }

      return $$3;
   }

   protected void a(byd $$0, cax $$1) {
      int $$2 = this.b.c($$1);
      if ($$2 != -1) {
         cax $$3 = this.b.a($$2).o();
         if (!$$3.b()) {
            if ($$3.K() > 1) {
               this.b.a($$2, 1);
            } else {
               this.b.b($$2);
            }

            $$3.e(1);
            if ($$0.e().b()) {
               $$0.d($$3);
            } else {
               $$0.e().f(1);
            }

         }
      }
   }

   private boolean a() {
      List<cax> $$0 = Lists.newArrayList();
      int $$1 = this.b();

      for(int $$2 = 0; $$2 < this.c.n() * this.c.o() + 1; ++$$2) {
         if ($$2 != this.c.m()) {
            cax $$3 = this.c.b($$2).e().o();
            if (!$$3.b()) {
               int $$4 = this.b.d($$3);
               if ($$4 == -1 && $$0.size() <= $$1) {
                  Iterator var6 = $$0.iterator();

                  while(var6.hasNext()) {
                     cax $$5 = (cax)var6.next();
                     if ($$5.a($$3) && $$5.K() != $$5.f() && $$5.K() + $$3.K() <= $$5.f()) {
                        $$5.f($$3.K());
                        $$3.e(0);
                        break;
                     }
                  }

                  if (!$$3.b()) {
                     if ($$0.size() >= $$1) {
                        return false;
                     }

                     $$0.add($$3);
                  }
               } else if ($$4 == -1) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private int b() {
      int $$0 = 0;
      Iterator var2 = this.b.h.iterator();

      while(var2.hasNext()) {
         cax $$1 = (cax)var2.next();
         if ($$1.b()) {
            ++$$0;
         }
      }

      return $$0;
   }
}
