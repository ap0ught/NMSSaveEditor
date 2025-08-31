// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.stream.Collectors;
import java.util.Map;
import java.io.InputStream;
import java.io.IOException;
import java.util.Iterator;

public class eC
{
    private static eD[] jS;
    private final eD jT;
    private final eE jU;
    
    static {
        (eC.jS = new eD[2])[0] = c("db/jsonmap.txt", "NMS 5.21 (savegame)");
        eC.jS[1] = c("db/jsonmapac.txt", "NMS 5.21 (account)");
    }
    
    public static void main(final String[] array) {
        for (int i = 0; i < eC.jS.length; ++i) {
            if (eC.jS[i] != null) {
                for (final eF ef : eC.jS[i]) {
                    final String hashName = hashName(ef.name);
                    if (!ef.key.equals(hashName)) {
                        System.out.println(String.valueOf(ef.name) + " = " + ef.key + " incorrect, should be " + hashName);
                    }
                }
            }
        }
    }
    
    private static String hashName(final String s) {
        final long[] array = { 8268756125562466087L, 8268756125562466087L };
        hh.a(s.getBytes("UTF-8"), array);
        final String s2 = "0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy";
        return new String(new char[] { s2.charAt((int)(((0xFFFFFFFFL & array[0] >> 32) % 68L << 32 | (0xFFFFFFFFL & array[0])) % 68L)), s2.charAt((int)((0x7FFFFFFFFFFL & array[0] >> 21) % 68L)), s2.charAt((int)((0x3FFFFFL & array[0] >> 42) % 68L)) });
    }
    
    public static eC a(final eG eg, final String s) {
        final eD ed = eC.jS[eg.ordinal()];
        if (ed != null && ed.s(s)) {
            return new eC(ed);
        }
        return null;
    }
    
    private static eD c(final String s, final String s2) {
        final InputStream resourceAsStream = Application.class.getResourceAsStream(s);
        if (resourceAsStream == null) {
            return null;
        }
        try {
            return new eD(resourceAsStream, s2, null);
        }
        catch (final IOException ex) {
            hc.error("Could not load key mapping file: " + s, ex);
            return null;
        }
    }
    
    private eC(final eD jt) {
        this.jT = jt;
        this.jU = new eE(null, null);
    }
    
    public Map bp() {
        return this.jU.stream().collect(Collectors.toMap(ef -> ef.key, ef2 -> ef2.name));
    }
    
    public String q(final String str) {
        final eF t;
        String s;
        if ((t = this.jU.t(str)) != null) {
            s = t.name;
        }
        else {
            final eF t2;
            if ((t2 = this.jT.t(str)) != null) {
                s = t2.name;
            }
            else {
                final eF v;
                if ((v = this.jT.v(str)) != null) {
                    s = v.name;
                }
                else {
                    hc.warn("  name mapping not found: " + str);
                    s = str;
                }
                this.jU.add(str, s);
            }
        }
        return s;
    }
    
    public String r(final String str) {
        final eF u;
        String s;
        if ((u = this.jU.u(str)) != null) {
            s = u.key;
        }
        else {
            final eF u2;
            if ((u2 = this.jT.u(str)) != null) {
                s = u2.key;
            }
            else {
                s = str;
                if (this.jT.t(s) == null) {
                    hc.warn("  reverse mapping not found: " + str);
                }
            }
        }
        return s;
    }
    
    @Override
    public String toString() {
        return this.jT.toString();
    }
}
