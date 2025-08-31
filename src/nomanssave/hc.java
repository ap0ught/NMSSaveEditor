// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.logging.LogRecord;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.io.PrintStream;
import java.util.logging.Handler;

public class hc
{
    private static final Handler sn;
    private static final PrintStream so;
    private static final PrintStream sp;
    private static PrintStream sq;
    private static int sr;
    
    static {
        sn = new hd();
        final Logger logger = LogManager.getLogManager().getLogger("");
        final Handler[] handlers = logger.getHandlers();
        for (int i = 0; i < handlers.length; ++i) {
            logger.removeHandler(handlers[0]);
        }
        logger.setLevel(Level.ALL);
        logger.addHandler(hc.sn);
        em();
        so = System.out;
        sp = System.err;
        hc.sr = Level.INFO.intValue();
    }
    
    private static void em() {
        try {
            final Class<?> forName = Class.forName("sun.misc.Unsafe");
            final Field declaredField = forName.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object value = declaredField.get(null);
            final Method declaredMethod = forName.getDeclaredMethod("putObjectVolatile", Object.class, Long.TYPE, Object.class);
            final Method declaredMethod2 = forName.getDeclaredMethod("staticFieldOffset", Field.class);
            final Class<?> forName2 = Class.forName("jdk.internal.module.IllegalAccessLogger");
            declaredMethod.invoke(value, forName2, declaredMethod2.invoke(value, forName2.getDeclaredField("logger")), null);
        }
        catch (final Throwable t) {}
    }
    
    public static void k(final File file) {
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> close()));
            System.setOut(new PrintStream(new he(hc.so, "[STDOUT] ")));
            System.setErr(new PrintStream(new he(hc.sp, "[STDERR] ")));
        }
        catch (final FileNotFoundException ex) {
            out = null;
        }
        hc.sq = ((out == null) ? null : new PrintStream(out, true));
    }
    
    public static void aA(final String str) {
        try {
            hc.sr = Level.parse(str).intValue();
            info("Set LogLevel: " + str);
        }
        catch (final IllegalArgumentException ex) {
            warn("Invalid LogLevel: " + str);
        }
    }
    
    public static void debug(final String s) {
        if (hc.sq != null) {
            synchronized (hc.sq) {
                hc.sq.println("[DEBUG] " + s.trim());
                monitorexit(hc.sq);
            }
        }
    }
    
    public static void debug(final String s, final Throwable t) {
        if (hc.sq != null) {
            synchronized (hc.sq) {
                hc.sq.println("[DEBUG] " + s.trim());
                if (t != null) {
                    hc.sq.print("[DEBUG] ");
                    t.printStackTrace(hc.sq);
                }
                monitorexit(hc.sq);
            }
        }
    }
    
    public static void info(final String x) {
        hc.so.println(x);
        if (hc.sq != null) {
            synchronized (hc.sq) {
                hc.sq.println("[INFO] " + x.trim());
                monitorexit(hc.sq);
            }
        }
    }
    
    public static void info(final String x, final Throwable t) {
        hc.so.println(x);
        if (hc.sq != null) {
            synchronized (hc.sq) {
                hc.sq.println("[INFO] " + x.trim());
                if (t != null) {
                    hc.sq.print("[INFO] ");
                    t.printStackTrace(hc.sq);
                }
                monitorexit(hc.sq);
            }
        }
    }
    
    private static String d(final String s, final String str) {
        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return String.valueOf(s.substring(0, i)) + str + s.substring(i);
            }
        }
        return "";
    }
    
    public static void warn(final String s) {
        hc.so.println(d(s, "WARNING: "));
        if (hc.sq != null) {
            synchronized (hc.sq) {
                hc.sq.println("[WARNING] " + s.trim());
                monitorexit(hc.sq);
            }
        }
    }
    
    public static void a(final String s, final Throwable t) {
        hc.so.println(d(s, "WARNING: "));
        if (hc.sq != null) {
            synchronized (hc.sq) {
                hc.sq.println("[WARNING] " + s.trim());
                if (t != null) {
                    hc.sq.print("[WARNING] ");
                    t.printStackTrace(hc.sq);
                }
                monitorexit(hc.sq);
            }
        }
    }
    
    public static void error(final String s, final Throwable t) {
        hc.sp.println(d(s, "ERROR: "));
        if (hc.sq != null) {
            synchronized (hc.sq) {
                hc.sq.println("[ERROR] " + s.trim());
                if (t != null) {
                    hc.sq.print("[ERROR] ");
                    t.printStackTrace(hc.sq);
                }
                monitorexit(hc.sq);
            }
        }
    }
    
    private static void log(final LogRecord logRecord) {
        final Level level = logRecord.getLevel();
        if (level.intValue() < hc.sr) {
            return;
        }
        final String loggerName = logRecord.getLoggerName();
        String string;
        if (loggerName == null) {
            string = "";
        }
        else {
            string = String.valueOf(loggerName) + ": ";
        }
        final String string2 = String.valueOf(string) + logRecord.getMessage();
        String str;
        PrintStream printStream;
        if (level.intValue() >= Level.SEVERE.intValue()) {
            str = "SEVERE";
            printStream = hc.sp;
        }
        else if (level.intValue() >= Level.WARNING.intValue()) {
            str = "WARNING";
            printStream = hc.sp;
        }
        else if (level.intValue() >= Level.INFO.intValue()) {
            str = "INFO";
            printStream = hc.so;
        }
        else if (level.intValue() >= Level.CONFIG.intValue()) {
            str = "CONFIG";
            printStream = hc.so;
        }
        else if (level.intValue() >= Level.FINE.intValue()) {
            str = "FINE";
            printStream = hc.so;
        }
        else if (level.intValue() >= Level.FINER.intValue()) {
            str = "FINER";
            printStream = hc.so;
        }
        else if (level.intValue() >= Level.FINEST.intValue()) {
            str = "FINEST";
            printStream = hc.so;
        }
        else {
            str = "DEBUG";
            printStream = hc.so;
        }
        if (level.intValue() >= Level.INFO.intValue()) {
            printStream.println(d(string2, String.valueOf(str) + ": "));
        }
        if (hc.sq != null) {
            synchronized (hc.sq) {
                hc.sq.println("[" + str + "] " + string2.trim());
                if (logRecord.getThrown() != null) {
                    hc.sq.print("[" + str + "] ");
                    logRecord.getThrown().printStackTrace(hc.sq);
                }
                monitorexit(hc.sq);
            }
        }
    }
    
    private static void close() {
        hc.sq.close();
    }
}
