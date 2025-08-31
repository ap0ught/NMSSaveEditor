// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class cS implements gD
{
    final String filename;
    final int index;
    final /* synthetic */ cN gt;
    
    cS(final cN gt, final String filename) {
        this.gt = gt;
        this.filename = filename;
        this.index = gt.go.size() + 1;
    }
    
    @Override
    public String K() {
        return this.filename;
    }
    
    @Override
    public String toString() {
        return "Unknown " + this.index;
    }
}
