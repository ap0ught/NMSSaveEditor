// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bA extends G
{
    private final int index;
    final /* synthetic */ bl er;
    
    private bA(final bl er, final int index) {
        this.er = er;
        this.index = index;
    }
    
    @Override
    protected String g(final String s) {
        if (this.er.eq < 0) {
            return "";
        }
        final int aq = this.er.ep[this.er.eq].aq(this.index);
        try {
            final int b = hf.b(s, 0, 50);
            if (b != aq) {
                this.er.ep[this.er.eq].e(this.index, b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(aq);
        }
    }
}
