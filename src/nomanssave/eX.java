// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;

public class eX extends IOException
{
    final int kF;
    final int kG;
    
    eX(final String s) {
        this(s, 1, 0);
    }
    
    eX(final String message, final int kf, final int kg) {
        super(message);
        this.kF = kf;
        this.kG = kg;
    }
    
    eX(final String message, final IOException cause, final int kf, final int kg) {
        super(message, cause);
        this.kF = kf;
        this.kG = kg;
    }
    
    public int getLineNumber() {
        return this.kF;
    }
    
    public int bD() {
        return this.kG;
    }
}
