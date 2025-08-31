// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.function.Function;

class gK extends gt
{
    final /* synthetic */ gH rq;
    private final /* synthetic */ int il;
    
    gK(final gH rq, final Function function, final eY ey, final int n, final int n2, final int n3, final boolean b, final boolean b2, final int il) {
        this.rq = rq;
        this.il = il;
        super(function, ey, n, n2, n3, b, b2);
    }
    
    @Override
    public String toString() {
        return this.rq.dZ() ? ("Ship " + this.il + " - Inflated Sacs") : super.toString();
    }
}
