// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.function.Function;

class gP extends gt
{
    final /* synthetic */ gO rP;
    private final /* synthetic */ boolean rr;
    private final /* synthetic */ int rQ;
    
    gP(final gO rp, final Function function, final eY ey, final int n, final int n2, final int n3, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean rr, final int rq) {
        this.rP = rp;
        this.rr = rr;
        this.rQ = rq;
        super(function, ey, n, n2, n3, b, b2, b3, b4);
    }
    
    @Override
    public int dj() {
        if (this.rr) {
            return 3584;
        }
        return 0xE00 | this.rQ;
    }
}
