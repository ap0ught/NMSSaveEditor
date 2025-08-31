// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;
import java.io.File;

public class fl
{
    private static final Object lock;
    private static fm lj;
    
    static {
        lock = new Object();
    }
    
    public static void a(final fq fq, final File file) {
        synchronized (fl.lock) {
            try {
                if (fl.lj == null) {
                    fl.lj = new fm();
                }
                fl.lj.a(fq, file);
            }
            catch (final IOException ex) {
                hc.a("Unable to register storage", ex);
            }
            monitorexit(fl.lock);
        }
    }
    
    public static void b(final fq fq) {
        synchronized (fl.lock) {
            try {
                if (fl.lj != null) {
                    fl.lj.b(fq);
                }
            }
            catch (final IOException ex) {
                hc.a("Unable to unregister storage", ex);
            }
            monitorexit(fl.lock);
        }
    }
}
