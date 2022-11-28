import java.util.Vector;
import javax.swing.JList;
import net.minecraft.server.MinecraftServer;

public class afo extends JList<String> {
   private final MinecraftServer a;
   private int b;

   public afo(MinecraftServer $$0) {
      this.a = $$0;
      $$0.b(this::a);
   }

   public void a() {
      if (this.b++ % 20 == 0) {
         Vector<String> $$0 = new Vector();

         for(int $$1 = 0; $$1 < this.a.ac().t().size(); ++$$1) {
            $$0.add(((agh)this.a.ac().t().get($$1)).fy().getName());
         }

         this.setListData($$0);
      }

   }
}
