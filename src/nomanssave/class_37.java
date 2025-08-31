package nomanssave;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

// $VF: renamed from: nomanssave.hc
public class class_37 {
   // $VF: renamed from: sn java.util.logging.Handler
   private static final Handler field_100 = new class_36();
   // $VF: renamed from: so java.io.PrintStream
   private static final PrintStream field_101;
   // $VF: renamed from: sp java.io.PrintStream
   private static final PrintStream field_102;
   // $VF: renamed from: sq java.io.PrintStream
   private static PrintStream field_103;
   // $VF: renamed from: sr int
   private static int field_104;

   static {
      Logger var0 = LogManager.getLogManager().getLogger("");
      Handler[] var1 = var0.getHandlers();

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.removeHandler(var1[0]);
      }

      var0.setLevel(Level.ALL);
      var0.addHandler(field_100);
      method_152();
      field_101 = System.out;
      field_102 = System.err;
      field_104 = Level.INFO.intValue();
   }

   // $VF: renamed from: em () void
   private static void method_152() {
      try {
         Class var0 = Class.forName("sun.misc.Unsafe");
         Field var1 = var0.getDeclaredField("theUnsafe");
         var1.setAccessible(true);
         Object var2 = var1.get(null);
         Method var3 = var0.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
         Method var4 = var0.getDeclaredMethod("staticFieldOffset", Field.class);
         Class var5 = Class.forName("jdk.internal.module.IllegalAccessLogger");
         Field var6 = var5.getDeclaredField("logger");
         Long var7 = (Long)var4.invoke(var2, var6);
         var3.invoke(var2, var5, var7, null);
      } catch (Throwable var8) {
      }
   }

   // $VF: renamed from: k (java.io.File) void
   public static void method_153(File var0) {
      FileOutputStream var1;
      try {
         var1 = new FileOutputStream(var0);
         Runtime.getRuntime().addShutdownHook(new Thread(hc::J));
         System.setOut(new PrintStream(new class_53(field_101, "[STDOUT] ")));
         System.setErr(new PrintStream(new class_53(field_102, "[STDERR] ")));
      } catch (FileNotFoundException var3) {
         var1 = null;
      }

      field_103 = var1 == null ? null : new PrintStream(var1, true);
   }

   // $VF: renamed from: aA (java.lang.String) void
   public static void method_154(String var0) {
      try {
         Level var1 = Level.parse(var0);
         field_104 = var1.intValue();
         info("Set LogLevel: " + var0);
      } catch (IllegalArgumentException var2) {
         warn("Invalid LogLevel: " + var0);
      }
   }

   public static void debug(String var0) {
      if (field_103 != null) {
         synchronized (field_103) {
            field_103.println("[DEBUG] " + var0.trim());
         }
      }
   }

   public static void debug(String var0, Throwable var1) {
      if (field_103 != null) {
         synchronized (field_103) {
            field_103.println("[DEBUG] " + var0.trim());
            if (var1 != null) {
               field_103.print("[DEBUG] ");
               var1.printStackTrace(field_103);
            }
         }
      }
   }

   public static void info(String var0) {
      field_101.println(var0);
      if (field_103 != null) {
         synchronized (field_103) {
            field_103.println("[INFO] " + var0.trim());
         }
      }
   }

   public static void info(String var0, Throwable var1) {
      field_101.println(var0);
      if (field_103 != null) {
         synchronized (field_103) {
            field_103.println("[INFO] " + var0.trim());
            if (var1 != null) {
               field_103.print("[INFO] ");
               var1.printStackTrace(field_103);
            }
         }
      }
   }

   // $VF: renamed from: d (java.lang.String, java.lang.String) java.lang.String
   private static String method_155(String var0, String var1) {
      for (int var2 = 0; var2 < var0.length(); var2++) {
         if (!Character.isWhitespace(var0.charAt(var2))) {
            return var0.substring(0, var2) + var1 + var0.substring(var2);
         }
      }

      return "";
   }

   public static void warn(String var0) {
      field_101.println(method_155(var0, "WARNING: "));
      if (field_103 != null) {
         synchronized (field_103) {
            field_103.println("[WARNING] " + var0.trim());
         }
      }
   }

   // $VF: renamed from: a (java.lang.String, java.lang.Throwable) void
   public static void method_156(String var0, Throwable var1) {
      field_101.println(method_155(var0, "WARNING: "));
      if (field_103 != null) {
         synchronized (field_103) {
            field_103.println("[WARNING] " + var0.trim());
            if (var1 != null) {
               field_103.print("[WARNING] ");
               var1.printStackTrace(field_103);
            }
         }
      }
   }

   public static void error(String var0, Throwable var1) {
      field_102.println(method_155(var0, "ERROR: "));
      if (field_103 != null) {
         synchronized (field_103) {
            field_103.println("[ERROR] " + var0.trim());
            if (var1 != null) {
               field_103.print("[ERROR] ");
               var1.printStackTrace(field_103);
            }
         }
      }
   }

   // $VF: renamed from: log (java.util.logging.LogRecord) void
   private static void method_157(LogRecord var0) {
      Level var1 = var0.getLevel();
      if (var1.intValue() >= field_104) {
         String var2 = var0.getLoggerName();
         if (var2 == null) {
            var2 = "";
         } else {
            var2 = var2 + ": ";
         }

         var2 = var2 + var0.getMessage();
         String var3;
         PrintStream var4;
         if (var1.intValue() >= Level.SEVERE.intValue()) {
            var3 = "SEVERE";
            var4 = field_102;
         } else if (var1.intValue() >= Level.WARNING.intValue()) {
            var3 = "WARNING";
            var4 = field_102;
         } else if (var1.intValue() >= Level.INFO.intValue()) {
            var3 = "INFO";
            var4 = field_101;
         } else if (var1.intValue() >= Level.CONFIG.intValue()) {
            var3 = "CONFIG";
            var4 = field_101;
         } else if (var1.intValue() >= Level.FINE.intValue()) {
            var3 = "FINE";
            var4 = field_101;
         } else if (var1.intValue() >= Level.FINER.intValue()) {
            var3 = "FINER";
            var4 = field_101;
         } else if (var1.intValue() >= Level.FINEST.intValue()) {
            var3 = "FINEST";
            var4 = field_101;
         } else {
            var3 = "DEBUG";
            var4 = field_101;
         }

         if (var1.intValue() >= Level.INFO.intValue()) {
            var4.println(method_155(var2, var3 + ": "));
         }

         if (field_103 != null) {
            synchronized (field_103) {
               field_103.println("[" + var3 + "] " + var2.trim());
               if (var0.getThrown() != null) {
                  field_103.print("[" + var3 + "] ");
                  var0.getThrown().printStackTrace(field_103);
               }
            }
         }
      }
   }

   private static void close() {
      field_103.close();
   }
}
