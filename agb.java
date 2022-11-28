import javax.annotation.Nullable;

public class agb {
   @Nullable
   protected static gt a(agg $$0, int $$1, int $$2) {
      boolean $$3 = $$0.q_().h();
      cxt $$4 = $$0.d(hq.a($$1), hq.a($$2));
      int $$5 = $$3 ? $$0.k().g().a((cgz)$$0) : $$4.a(dar.a.e, $$1 & 15, $$2 & 15);
      if ($$5 < $$0.u_()) {
         return null;
      } else {
         int $$6 = $$4.a(dar.a.b, $$1 & 15, $$2 & 15);
         if ($$6 <= $$5 && $$6 > $$4.a(dar.a.d, $$1 & 15, $$2 & 15)) {
            return null;
         } else {
            gt.a $$7 = new gt.a();

            for(int $$8 = $$5 + 1; $$8 >= $$0.u_(); --$$8) {
               $$7.d($$1, $$8, $$2);
               cvo $$9 = $$0.a_($$7);
               if (!$$9.p().c()) {
                  break;
               }

               if (cjt.a($$9.k($$0, $$7), gy.b)) {
                  return $$7.b().h();
               }
            }

            return null;
         }
      }
   }

   @Nullable
   public static gt a(agg $$0, cge $$1) {
      if (ab.a($$1)) {
         return null;
      } else {
         for(int $$2 = $$1.d(); $$2 <= $$1.f(); ++$$2) {
            for(int $$3 = $$1.e(); $$3 <= $$1.g(); ++$$3) {
               gt $$4 = a($$0, $$2, $$3);
               if ($$4 != null) {
                  return $$4;
               }
            }
         }

         return null;
      }
   }
}
