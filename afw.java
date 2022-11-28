public abstract class afw extends dpi {
   protected afw(int $$0, int $$1, int $$2) {
      super($$0, $$1, $$2);
   }

   protected boolean a(long $$0) {
      return $$0 == cge.a;
   }

   protected void a(long $$0, int $$1, boolean $$2) {
      cge $$3 = new cge($$0);
      int $$4 = $$3.e;
      int $$5 = $$3.f;

      for(int $$6 = -1; $$6 <= 1; ++$$6) {
         for(int $$7 = -1; $$7 <= 1; ++$$7) {
            long $$8 = cge.c($$4 + $$6, $$5 + $$7);
            if ($$8 != $$0) {
               this.b($$0, $$8, $$1, $$2);
            }
         }
      }

   }

   protected int a(long $$0, long $$1, int $$2) {
      int $$3 = $$2;
      cge $$4 = new cge($$0);
      int $$5 = $$4.e;
      int $$6 = $$4.f;

      for(int $$7 = -1; $$7 <= 1; ++$$7) {
         for(int $$8 = -1; $$8 <= 1; ++$$8) {
            long $$9 = cge.c($$5 + $$7, $$6 + $$8);
            if ($$9 == $$0) {
               $$9 = cge.a;
            }

            if ($$9 != $$1) {
               int $$10 = this.b($$9, $$0, this.c($$9));
               if ($$3 > $$10) {
                  $$3 = $$10;
               }

               if ($$3 == 0) {
                  return $$3;
               }
            }
         }
      }

      return $$3;
   }

   protected int b(long $$0, long $$1, int $$2) {
      return $$0 == cge.a ? this.b($$1) : $$2 + 1;
   }

   protected abstract int b(long var1);

   public void b(long $$0, int $$1, boolean $$2) {
      this.a(cge.a, $$0, $$1, $$2);
   }
}
