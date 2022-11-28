import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;
import javax.annotation.Nullable;

public class aal {
   private static final alh<aak<?>> x = alh.c(16);
   public static final aak<Byte> a = aak.a(($$0, $$1) -> {
      $$0.writeByte($$1);
   }, qx::readByte);
   public static final aak<Integer> b = aak.a(qx::d, qx::k);
   public static final aak<Float> c = aak.a(qx::writeFloat, qx::readFloat);
   public static final aak<String> d = aak.a(qx::a, qx::q);
   public static final aak<rq> e = aak.a(qx::a, qx::j);
   public static final aak<Optional<rq>> f = aak.b(qx::a, qx::j);
   public static final aak<cax> g = new aak<cax>() {
      public void a(qx $$0, cax $$1) {
         $$0.a($$1);
      }

      public cax b(qx $$0) {
         return $$0.p();
      }

      public cax a(cax $$0) {
         return $$0.o();
      }

      // $FF: synthetic method
      public Object a(qx var1) {
         return this.b(var1);
      }
   };
   public static final aak<Optional<cvo>> h = new aak.a<Optional<cvo>>() {
      public void a(qx $$0, Optional<cvo> $$1) {
         if ($$1.isPresent()) {
            $$0.d(cjt.i((cvo)$$1.get()));
         } else {
            $$0.d(0);
         }

      }

      public Optional<cvo> b(qx $$0) {
         int $$1 = $$0.k();
         return $$1 == 0 ? Optional.empty() : Optional.of(cjt.a($$1));
      }

      // $FF: synthetic method
      public Object a(qx var1) {
         return this.b(var1);
      }
   };
   public static final aak<Boolean> i = aak.a(qx::writeBoolean, qx::readBoolean);
   public static final aak<im> j = new aak.a<im>() {
      public void a(qx $$0, im $$1) {
         $$0.a((hf)hm.aa, (Object)$$1.b());
         $$1.a($$0);
      }

      public im b(qx $$0) {
         return this.a($$0, (in)$$0.a((hf)hm.aa));
      }

      private <T extends im> T a(qx $$0, in<T> $$1) {
         return $$1.d().b($$1, $$0);
      }

      // $FF: synthetic method
      public Object a(qx var1) {
         return this.b(var1);
      }
   };
   public static final aak<hp> k = new aak.a<hp>() {
      public void a(qx $$0, hp $$1) {
         $$0.writeFloat($$1.b());
         $$0.writeFloat($$1.c());
         $$0.writeFloat($$1.d());
      }

      public hp b(qx $$0) {
         return new hp($$0.readFloat(), $$0.readFloat(), $$0.readFloat());
      }

      // $FF: synthetic method
      public Object a(qx var1) {
         return this.b(var1);
      }
   };
   public static final aak<gt> l = aak.a(qx::a, qx::f);
   public static final aak<Optional<gt>> m = aak.b(qx::a, qx::f);
   public static final aak<gy> n = aak.a(gy.class);
   public static final aak<Optional<UUID>> o = aak.b(qx::a, qx::m);
   public static final aak<Optional<hb>> p = aak.b(qx::a, qx::i);
   public static final aak<pj> q = new aak<pj>() {
      public void a(qx $$0, pj $$1) {
         $$0.a($$1);
      }

      public pj b(qx $$0) {
         return $$0.n();
      }

      public pj a(pj $$0) {
         return $$0.g();
      }

      // $FF: synthetic method
      public Object a(qx var1) {
         return this.b(var1);
      }
   };
   public static final aak<btq> r = new aak.a<btq>() {
      public void a(qx $$0, btq $$1) {
         $$0.a((hf)hm.ao, (Object)$$1.a());
         $$0.a((hf)hm.ap, (Object)$$1.b());
         $$0.d($$1.c());
      }

      public btq b(qx $$0) {
         return new btq((btu)$$0.a((hf)hm.ao), (bts)$$0.a((hf)hm.ap), $$0.k());
      }

      // $FF: synthetic method
      public Object a(qx var1) {
         return this.b(var1);
      }
   };
   public static final aak<OptionalInt> s = new aak.a<OptionalInt>() {
      public void a(qx $$0, OptionalInt $$1) {
         $$0.d($$1.orElse(-1) + 1);
      }

      public OptionalInt b(qx $$0) {
         int $$1 = $$0.k();
         return $$1 == 0 ? OptionalInt.empty() : OptionalInt.of($$1 - 1);
      }

      // $FF: synthetic method
      public Object a(qx var1) {
         return this.b(var1);
      }
   };
   public static final aak<bco> t = aak.a(bco.class);
   public static final aak<bni> u;
   public static final aak<bnp> v;
   public static final aak<hc<bqr>> w;

   public static void a(aak<?> $$0) {
      x.c($$0);
   }

   @Nullable
   public static aak<?> a(int $$0) {
      return (aak)x.a($$0);
   }

   public static int b(aak<?> $$0) {
      return x.a($$0);
   }

   private aal() {
   }

   static {
      u = aak.a((hf)hm.bK);
      v = aak.a((hf)hm.bM);
      w = aak.a(hm.ac.s());
      a(a);
      a(b);
      a(c);
      a(d);
      a(e);
      a(f);
      a(g);
      a(i);
      a(k);
      a(l);
      a(m);
      a(n);
      a(o);
      a(h);
      a(q);
      a(j);
      a(r);
      a(s);
      a(t);
      a(u);
      a(v);
      a(p);
      a(w);
   }
}
