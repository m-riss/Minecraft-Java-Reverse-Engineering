import com.google.common.collect.Lists;
import com.mojang.logging.LogQueues;
import com.mojang.logging.LogUtils;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.slf4j.Logger;

public class afn extends JComponent {
   private static final Font a = new Font("Monospaced", 0, 12);
   private static final Logger b = LogUtils.getLogger();
   private static final String c = "Minecraft server";
   private static final String d = "Minecraft server - shutting down!";
   private final afh e;
   private Thread f;
   private final Collection<Runnable> g = Lists.newArrayList();
   final AtomicBoolean h = new AtomicBoolean();

   public static afn a(final afh $$0) {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception var3) {
      }

      final JFrame $$1 = new JFrame("Minecraft server");
      final afn $$2 = new afn($$0);
      $$1.setDefaultCloseOperation(2);
      $$1.add($$2);
      $$1.pack();
      $$1.setLocationRelativeTo((Component)null);
      $$1.setVisible(true);
      $$1.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent $$0x) {
            if (!$$2.h.getAndSet(true)) {
               $$1.setTitle("Minecraft server - shutting down!");
               $$0.a(true);
               $$2.f();
            }

         }
      });
      Objects.requireNonNull($$1);
      $$2.a($$1::dispose);
      $$2.a();
      return $$2;
   }

   private afn(afh $$0) {
      this.e = $$0;
      this.setPreferredSize(new Dimension(854, 480));
      this.setLayout(new BorderLayout());

      try {
         this.add(this.e(), "Center");
         this.add(this.c(), "West");
      } catch (Exception var3) {
         b.error("Couldn't build server GUI", var3);
      }

   }

   public void a(Runnable $$0) {
      this.g.add($$0);
   }

   private JComponent c() {
      JPanel $$0 = new JPanel(new BorderLayout());
      afp $$1 = new afp(this.e);
      Collection var10000 = this.g;
      Objects.requireNonNull($$1);
      var10000.add($$1::a);
      $$0.add($$1, "North");
      $$0.add(this.d(), "Center");
      $$0.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
      return $$0;
   }

   private JComponent d() {
      JList<?> $$0 = new afo(this.e);
      JScrollPane $$1 = new JScrollPane($$0, 22, 30);
      $$1.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
      return $$1;
   }

   private JComponent e() {
      JPanel $$0 = new JPanel(new BorderLayout());
      JTextArea $$1 = new JTextArea();
      JScrollPane $$2 = new JScrollPane($$1, 22, 30);
      $$1.setEditable(false);
      $$1.setFont(a);
      JTextField $$3 = new JTextField();
      $$3.addActionListener(($$1x) -> {
         String $$2 = $$3.getText().trim();
         if (!$$2.isEmpty()) {
            this.e.a($$2, this.e.aD());
         }

         $$3.setText("");
      });
      $$1.addFocusListener(new FocusAdapter() {
         public void focusGained(FocusEvent $$0) {
         }
      });
      $$0.add($$2, "Center");
      $$0.add($$3, "South");
      $$0.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
      this.f = new Thread(() -> {
         String $$2x;
         while(($$2x = LogQueues.getNextLogEvent("ServerGuiConsole")) != null) {
            this.a($$1, $$2, $$2x);
         }

      });
      this.f.setUncaughtExceptionHandler(new t(b));
      this.f.setDaemon(true);
      return $$0;
   }

   public void a() {
      this.f.start();
   }

   public void b() {
      if (!this.h.getAndSet(true)) {
         this.f();
      }

   }

   void f() {
      this.g.forEach(Runnable::run);
   }

   public void a(JTextArea $$0, JScrollPane $$1, String $$2) {
      if (!SwingUtilities.isEventDispatchThread()) {
         SwingUtilities.invokeLater(() -> {
            this.a($$0, $$1, $$2);
         });
      } else {
         Document $$3 = $$0.getDocument();
         JScrollBar $$4 = $$1.getVerticalScrollBar();
         boolean $$5 = false;
         if ($$1.getViewport().getView() == $$0) {
            $$5 = (double)$$4.getValue() + $$4.getSize().getHeight() + (double)(a.getSize() * 4) > (double)$$4.getMaximum();
         }

         try {
            $$3.insertString($$3.getLength(), $$2, (AttributeSet)null);
         } catch (BadLocationException var8) {
         }

         if ($$5) {
            $$4.setValue(Integer.MAX_VALUE);
         }

      }
   }
}
