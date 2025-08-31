// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class en
{
    private static boolean iu;
    private static List iv;
    
    static {
        en.iu = false;
        en.iv = new ArrayList();
    }
    
    public static void a(final eo eo) {
        en.iv.add(eo);
    }
    
    public static boolean aS() {
        return en.iu;
    }
    
    public static void c(final boolean iu) {
        en.iu = iu;
        final Iterator iterator = en.iv.iterator();
        while (iterator.hasNext()) {
            ((eo)iterator.next()).a(iu);
        }
    }
}
