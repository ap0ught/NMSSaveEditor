// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bn extends G
{
    final /* synthetic */ bl er;
    
    bn(final bl er) {
        this.er = er;
    }
    
    @Override
    protected String g(final String s) {
        if (this.er.eq < 0) {
            return "";
        }
        final int dc = this.er.ep[this.er.eq].dc();
        try {
            final int b = hf.b(s, 0, Integer.MAX_VALUE);
            if (b != dc) {
                this.er.ep[this.er.eq].as(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(dc);
        }
    }
}
