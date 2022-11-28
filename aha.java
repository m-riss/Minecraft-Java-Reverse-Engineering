import net.minecraft.server.MinecraftServer;

public class aha implements zn {
   private static final rq a = rq.b("Ignoring status request");
   private final MinecraftServer b;
   private final qv c;

   public aha(MinecraftServer $$0, qv $$1) {
      this.b = $$0;
      this.c = $$1;
   }

   public void a(zm $$0) {
      switch($$0.b()) {
      case d:
         this.c.a(qw.d);
         if ($$0.c() != ab.b().getProtocolVersion()) {
            sb $$2;
            if ($$0.c() < 754) {
               $$2 = rq.a("multiplayer.disconnect.outdated_client", ab.b().getName());
            } else {
               $$2 = rq.a("multiplayer.disconnect.incompatible", ab.b().getName());
            }

            this.c.a((tc)(new zu($$2)));
            this.c.a((rq)$$2);
         } else {
            this.c.a((ra)(new ahb(this.b, this.c)));
         }
         break;
      case c:
         if (this.b.ai()) {
            this.c.a(qw.c);
            this.c.a((ra)(new ahd(this.b, this.c)));
         } else {
            this.c.a(a);
         }
         break;
      default:
         throw new UnsupportedOperationException("Invalid intention " + $$0.b());
      }

   }

   public void a(rq $$0) {
   }

   public qv a() {
      return this.c;
   }
}
