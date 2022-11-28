import com.mojang.authlib.GameProfile;
import com.mojang.logging.LogUtils;
import java.io.IOException;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

public class afg extends aiz {
   private static final Logger a = LogUtils.getLogger();

   public afg(afh $$0, hn.a $$1, drt $$2) {
      super($$0, $$1, $$2, $$0.a().H);
      afi $$3 = $$0.a();
      this.a($$3.F);
      this.b($$3.G);
      super.a((Boolean)$$3.V.get());
      this.z();
      this.x();
      this.y();
      this.w();
      this.A();
      this.C();
      this.B();
      if (!this.i().b().exists()) {
         this.D();
      }

   }

   public void a(boolean $$0) {
      super.a($$0);
      this.b().i($$0);
   }

   public void a(GameProfile $$0) {
      super.a($$0);
      this.B();
   }

   public void b(GameProfile $$0) {
      super.b($$0);
      this.B();
   }

   public void a() {
      this.C();
   }

   private void w() {
      try {
         this.g().e();
      } catch (IOException var2) {
         a.warn("Failed to save ip banlist: ", var2);
      }

   }

   private void x() {
      try {
         this.f().e();
      } catch (IOException var2) {
         a.warn("Failed to save user banlist: ", var2);
      }

   }

   private void y() {
      try {
         this.g().f();
      } catch (IOException var2) {
         a.warn("Failed to load ip banlist: ", var2);
      }

   }

   private void z() {
      try {
         this.f().f();
      } catch (IOException var2) {
         a.warn("Failed to load user banlist: ", var2);
      }

   }

   private void A() {
      try {
         this.k().f();
      } catch (Exception var2) {
         a.warn("Failed to load operators list: ", var2);
      }

   }

   private void B() {
      try {
         this.k().e();
      } catch (Exception var2) {
         a.warn("Failed to save operators list: ", var2);
      }

   }

   private void C() {
      try {
         this.i().f();
      } catch (Exception var2) {
         a.warn("Failed to load white-list: ", var2);
      }

   }

   private void D() {
      try {
         this.i().e();
      } catch (Exception var2) {
         a.warn("Failed to save white-list: ", var2);
      }

   }

   public boolean c(GameProfile $$0) {
      return !this.o() || this.e($$0) || this.i().a($$0);
   }

   public afh b() {
      return (afh)super.c();
   }

   public boolean d(GameProfile $$0) {
      return this.k().a($$0);
   }

   // $FF: synthetic method
   public MinecraftServer c() {
      return this.b();
   }
}
