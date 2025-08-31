// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class cQ
{
    final String value;
    final /* synthetic */ cN gt;
    
    cQ(final cN gt, final String value) {
        this.gt = gt;
        this.value = value;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof String) {
            return this.value.equals(o);
        }
        if (o instanceof cS) {
            return this.value.equals(((cS)o).filename);
        }
        return super.equals(o);
    }
}
