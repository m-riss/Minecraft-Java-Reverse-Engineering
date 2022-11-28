import net.minecraft.server.MinecraftServer;

public class ahd implements aaf {
   private static final rq a = rq.c("multiplayer.status.request_handled");
   private final MinecraftServer b;
   private final qv c;
   private boolean d;

   public ahd(MinecraftServer $$0, qv $$1) {
      this.b = $$0;
      this.c = $$1;
   }

   public void a(rq $$0) {
   }

   public qv a() {
      return this.c;
   }

   public void a(aah $$0) {
      if (this.d) {
         this.c.a(a);
      } else {
         this.d = true;
         this.c.a((tc)(new aad(this.b.aq())));
      }
   }

   public void a(aag $$0) {
      this.c.a((tc)(new aac($$0.b())));
      this.c.a(a);
   }
}
