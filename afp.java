import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.function.Consumer;
import javax.swing.JComponent;
import javax.swing.Timer;
import net.minecraft.server.MinecraftServer;

public class afp extends JComponent {
   private static final DecimalFormat a = (DecimalFormat)ad.a((Object)(new DecimalFormat("########0.000")), (Consumer)(($$0) -> {
      $$0.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ROOT));
   }));
   private final int[] b = new int[256];
   private int c;
   private final String[] d = new String[11];
   private final MinecraftServer e;
   private final Timer f;

   public afp(MinecraftServer $$0) {
      this.e = $$0;
      this.setPreferredSize(new Dimension(456, 246));
      this.setMinimumSize(new Dimension(456, 246));
      this.setMaximumSize(new Dimension(456, 246));
      this.f = new Timer(500, ($$0x) -> {
         this.b();
      });
      this.f.start();
      this.setBackground(Color.BLACK);
   }

   private void b() {
      long $$0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
      this.d[0] = "Memory use: " + $$0 / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
      String[] var10000 = this.d;
      DecimalFormat var10002 = a;
      double var10003 = this.a(this.e.k);
      var10000[1] = "Avg tick: " + var10002.format(var10003 * 1.0E-6D) + " ms";
      this.b[this.c++ & 255] = (int)($$0 * 100L / Runtime.getRuntime().maxMemory());
      this.repaint();
   }

   private double a(long[] $$0) {
      long $$1 = 0L;
      long[] var4 = $$0;
      int var5 = $$0.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         long $$2 = var4[var6];
         $$1 += $$2;
      }

      return (double)$$1 / (double)$$0.length;
   }

   public void paint(Graphics $$0) {
      $$0.setColor(new Color(16777215));
      $$0.fillRect(0, 0, 456, 246);

      int $$3;
      for($$3 = 0; $$3 < 256; ++$$3) {
         int $$2 = this.b[$$3 + this.c & 255];
         $$0.setColor(new Color($$2 + 28 << 16));
         $$0.fillRect($$3, 100 - $$2, 1, $$2);
      }

      $$0.setColor(Color.BLACK);

      for($$3 = 0; $$3 < this.d.length; ++$$3) {
         String $$4 = this.d[$$3];
         if ($$4 != null) {
            $$0.drawString($$4, 32, 116 + $$3 * 16);
         }
      }

   }

   public void a() {
      this.f.stop();
   }
}
