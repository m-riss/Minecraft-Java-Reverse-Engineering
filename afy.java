public class afy extends agi {
   public static final int a = 5;
   public static final int b = 120500;
   private boolean e;
   private boolean f;
   private int g;
   private int h;

   public afy(agh $$0) {
      super($$0);
   }

   public void a() {
      super.a();
      ++this.h;
      long $$0 = this.c.U();
      long $$1 = $$0 / 24000L + 1L;
      if (!this.e && this.h > 20) {
         this.e = true;
         this.d.b.a((tc)(new uj(uj.f, 0.0F)));
      }

      this.f = $$0 > 120500L;
      if (this.f) {
         ++this.g;
      }

      if ($$0 % 24000L == 500L) {
         if ($$1 <= 6L) {
            if ($$1 == 6L) {
               this.d.b.a((tc)(new uj(uj.f, 104.0F)));
            } else {
               this.d.a((rq)rq.c("demo.day." + $$1));
            }
         }
      } else if ($$1 == 1L) {
         if ($$0 == 100L) {
            this.d.b.a((tc)(new uj(uj.f, 101.0F)));
         } else if ($$0 == 175L) {
            this.d.b.a((tc)(new uj(uj.f, 102.0F)));
         } else if ($$0 == 250L) {
            this.d.b.a((tc)(new uj(uj.f, 103.0F)));
         }
      } else if ($$1 == 5L && $$0 % 24000L == 22000L) {
         this.d.a((rq)rq.c("demo.day.warning"));
      }

   }

   private void f() {
      if (this.g > 100) {
         this.d.a((rq)rq.c("demo.reminder"));
         this.g = 0;
      }

   }

   public void a(gt $$0, yo.a $$1, gy $$2, int $$3, int $$4) {
      if (this.f) {
         this.f();
      } else {
         super.a($$0, $$1, $$2, $$3, $$4);
      }
   }

   public baj a(agh $$0, cgx $$1, cax $$2, bai $$3) {
      if (this.f) {
         this.f();
         return baj.d;
      } else {
         return super.a($$0, $$1, $$2, $$3);
      }
   }

   public baj a(agh $$0, cgx $$1, cax $$2, bai $$3, dwm $$4) {
      if (this.f) {
         this.f();
         return baj.d;
      } else {
         return super.a($$0, $$1, $$2, $$3, $$4);
      }
   }
}
