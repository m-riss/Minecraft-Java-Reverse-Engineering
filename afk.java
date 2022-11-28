import com.google.common.collect.Streams;
import com.mojang.logging.LogUtils;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import org.slf4j.Logger;

public class afk implements Runnable {
   private static final Logger a = LogUtils.getLogger();
   private static final long b = 10000L;
   private static final int c = 1;
   private final afh d;
   private final long e;

   public afk(afh $$0) {
      this.d = $$0;
      this.e = $$0.bk();
   }

   public void run() {
      while(this.d.u()) {
         long $$0 = this.d.ax();
         long $$1 = ad.b();
         long $$2 = $$1 - $$0;
         if ($$2 > this.e) {
            a.error(LogUtils.FATAL_MARKER, "A single server tick took {} seconds (should be max {})", String.format(Locale.ROOT, "%.2f", (float)$$2 / 1000.0F), String.format(Locale.ROOT, "%.2f", 0.05F));
            a.error(LogUtils.FATAL_MARKER, "Considering it to be crashed, server will forcibly shutdown.");
            ThreadMXBean $$3 = ManagementFactory.getThreadMXBean();
            ThreadInfo[] $$4 = $$3.dumpAllThreads(true, true);
            StringBuilder $$5 = new StringBuilder();
            Error $$6 = new Error("Watchdog");
            ThreadInfo[] var11 = $$4;
            int var12 = $$4.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               ThreadInfo $$7 = var11[var13];
               if ($$7.getThreadId() == this.d.au().getId()) {
                  $$6.setStackTrace($$7.getStackTrace());
               }

               $$5.append($$7);
               $$5.append("\n");
            }

            q $$8 = new q("Watching Server", $$6);
            this.d.b($$8.g());
            r $$9 = $$8.a("Thread Dump");
            $$9.a((String)"Threads", (Object)$$5);
            r $$10 = $$8.a("Performance stats");
            $$10.a("Random tick rate", () -> {
               return ((cgt.d)this.d.aW().q().a(cgt.n)).toString();
            });
            $$10.a("Level stats", () -> {
               return (String)Streams.stream(this.d.E()).map(($$0) -> {
                  aba var10000 = $$0.ab();
                  return var10000 + ": " + $$0.E();
               }).collect(Collectors.joining(",\n"));
            });
            abd.a("Crash report:\n" + $$8.e());
            File $$11 = new File(new File(this.d.z(), "crash-reports"), "crash-" + ad.e() + "-server.txt");
            if ($$8.a($$11)) {
               a.error("This crash report has been saved to: {}", $$11.getAbsolutePath());
            } else {
               a.error("We were unable to save this crash report to disk.");
            }

            this.a();
         }

         try {
            Thread.sleep($$0 + this.e - $$1);
         } catch (InterruptedException var15) {
         }
      }

   }

   private void a() {
      try {
         Timer $$0 = new Timer();
         $$0.schedule(new TimerTask() {
            public void run() {
               Runtime.getRuntime().halt(1);
            }
         }, 10000L);
         System.exit(1);
      } catch (Throwable var2) {
         Runtime.getRuntime().halt(1);
      }

   }
}
