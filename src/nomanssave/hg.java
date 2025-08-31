// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.security.SecureRandom;

public class hg
{
    private static final SecureRandom sv;
    private final long sw;
    
    static {
        sv = new SecureRandom();
    }
    
    public static hg aB(String trim) {
        trim = trim.trim();
        if (!trim.startsWith("0x")) {
            throw new RuntimeException("Invalid seed: " + trim);
        }
        return new hg(Long.parseUnsignedLong(trim.substring(2), 16));
    }
    
    public static hg eo() {
        return new hg(hg.sv.nextLong());
    }
    
    public hg(final long sw) {
        this.sw = sw;
    }
    
    @Override
    public String toString() {
        return "0x" + Long.toHexString(this.sw).toUpperCase();
    }
}
