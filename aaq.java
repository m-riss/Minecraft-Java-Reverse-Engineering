import java.util.Iterator;

public interface aaq<T> {
   default void a(int $$0, int $$1, int $$2, cdp<?> $$3, Iterator<T> $$4, int $$5) {
      int $$6 = $$0;
      int $$7 = $$1;
      if ($$3 instanceof cdu) {
         cdu $$8 = (cdu)$$3;
         $$6 = $$8.j();
         $$7 = $$8.k();
      }

      int $$9 = 0;

      for(int $$10 = 0; $$10 < $$1; ++$$10) {
         if ($$9 == $$2) {
            ++$$9;
         }

         boolean $$11 = (float)$$7 < (float)$$1 / 2.0F;
         int $$12 = ami.d((float)$$1 / 2.0F - (float)$$7 / 2.0F);
         if ($$11 && $$12 > $$10) {
            $$9 += $$0;
            ++$$10;
         }

         for(int $$13 = 0; $$13 < $$0; ++$$13) {
            if (!$$4.hasNext()) {
               return;
            }

            $$11 = (float)$$6 < (float)$$0 / 2.0F;
            $$12 = ami.d((float)$$0 / 2.0F - (float)$$6 / 2.0F);
            int $$14 = $$6;
            boolean $$15 = $$13 < $$6;
            if ($$11) {
               $$14 = $$12 + $$6;
               $$15 = $$12 <= $$13 && $$13 < $$12 + $$6;
            }

            if ($$15) {
               this.a($$4, $$9, $$5, $$10, $$13);
            } else if ($$14 == $$13) {
               $$9 += $$0 - $$13;
               break;
            }

            ++$$9;
         }
      }

   }

   void a(Iterator<T> var1, int var2, int var3, int var4, int var5);
}
