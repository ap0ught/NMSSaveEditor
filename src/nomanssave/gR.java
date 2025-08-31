// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class gR
{
    private static Map rR;
    
    static {
        gR.rR = new HashMap();
    }
    
    public static eY az(final String s) {
        eY b = null;
        if (gR.rR.containsKey(s)) {
            b = gR.rR.get(s);
        }
        else {
            final InputStream resourceAsStream = Application.class.getResourceAsStream("templates/" + s + ".json");
            if (resourceAsStream != null) {
                try {
                    b = ff.b(hk.g(resourceAsStream));
                }
                catch (final IOException ex) {
                    hc.a("Cannot load template: " + s, ex);
                }
            }
            gR.rR.put(s, b);
        }
        return (b == null) ? null : b.bE();
    }
}
