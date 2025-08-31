// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.function.Function;

class gI extends gt
{
    final /* synthetic */ gH rq;
    private final /* synthetic */ boolean rr;
    private final /* synthetic */ int il;
    
    gI(final gH rq, final Function function, final eY ey, final int n, final int n2, final int n3, final boolean b, final boolean b2, final boolean rr, final int il) {
        this.rq = rq;
        this.rr = rr;
        this.il = il;
        super(function, ey, n, n2, n3, b, b2);
    }
    
    @Override
    public int dj() {
        if (this.rr) {
            return 3584;
        }
        return 0xE00 | this.rq.ea();
    }
    
    @Override
    public String toString() {
        return this.rq.dZ() ? ("Ship " + this.il + " - Storage Sacs") : super.toString();
    }
}
