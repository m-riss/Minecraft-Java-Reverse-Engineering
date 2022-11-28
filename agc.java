public abstract class agc extends dpi {
   protected agc(int $$0, int $$1, int $$2) {
      super($$0, $$1, $$2);
   }

   protected boolean a(long $$0) {
      return $$0 == Long.MAX_VALUE;
   }

   protected void a(long $$0, int $$1, boolean $$2) {
      for(int $$3 = -1; $$3 <= 1; ++$$3) {
         for(int $$4 = -1; $$4 <= 1; ++$$4) {
            for(int $$5 = -1; $$5 <= 1; ++$$5) {
               long $$6 = hq.a($$0, $$3, $$4, $$5);
               if ($$6 != $$0) {
                  this.b($$0, $$6, $$1, $$2);
               }
            }
         }
      }

   }

   protected int a(long $$0, long $$1, int $$2) {
      int $$3 = $$2;

      for(int $$4 = -1; $$4 <= 1; ++$$4) {
         for(int $$5 = -1; $$5 <= 1; ++$$5) {
            for(int $$6 = -1; $$6 <= 1; ++$$6) {
               long $$7 = hq.a($$0, $$4, $$5, $$6);
               if ($$7 == $$0) {
                  $$7 = Long.MAX_VALUE;
               }

               if ($$7 != $$1) {
                  int $$8 = this.b($$7, $$0, this.c($$7));
                  if ($$3 > $$8) {
                     $$3 = $$8;
                  }

                  if ($$3 == 0) {
                     return $$3;
                  }
               }
            }
         }
      }

      return $$3;
   }

   protected int b(long $$0, long $$1, int $$2) {
      return $$0 == Long.MAX_VALUE ? this.b($$1) : $$2 + 1;
   }

   protected abstract int b(long var1);

   public void b(long $$0, int $$1, boolean $$2) {
      this.a(Long.MAX_VALUE, $$0, $$1, $$2);
   }
}
