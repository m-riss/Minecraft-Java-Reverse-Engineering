import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.io.File;

public record abr(MinecraftSessionService a, amp b, GameProfileRepository c, aiv d) {
   private static final String e = "usercache.json";

   public abr(MinecraftSessionService $$0, amp $$1, GameProfileRepository $$2, aiv $$3) {
      this.a = $$0;
      this.b = $$1;
      this.c = $$2;
      this.d = $$3;
   }

   public static abr a(YggdrasilAuthenticationService $$0, File $$1) {
      MinecraftSessionService $$2 = $$0.createMinecraftSessionService();
      GameProfileRepository $$3 = $$0.createProfileRepository();
      aiv $$4 = new aiv($$3, new File($$1, "usercache.json"));
      amp $$5 = amp.a($$0.getServicesKey());
      return new abr($$2, $$5, $$3, $$4);
   }

   public MinecraftSessionService a() {
      return this.a;
   }

   public amp b() {
      return this.b;
   }

   public GameProfileRepository c() {
      return this.c;
   }

   public aiv d() {
      return this.d;
   }
}
