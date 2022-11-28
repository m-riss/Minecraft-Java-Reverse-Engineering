import net.minecraft.server.MinecraftServer;

public class agx implements zn {
   private final MinecraftServer a;
   private final qv b;

   public agx(MinecraftServer $$0, qv $$1) {
      this.a = $$0;
      this.b = $$1;
   }

   public void a(zm $$0) {
      this.b.a($$0.b());
      this.b.a((ra)(new ahb(this.a, this.b)));
   }

   public void a(rq $$0) {
   }

   public qv a() {
      return this.b;
   }
}
