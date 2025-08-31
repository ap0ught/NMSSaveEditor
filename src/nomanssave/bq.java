// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bq extends G
{
    final /* synthetic */ bl er;
    
    bq(final bl er) {
        this.er = er;
    }
    
    @Override
    protected String g(final String s) {
        if (this.er.eq < 0) {
            return "";
        }
        final int df = this.er.ep[this.er.eq].df();
        try {
            final int b = hf.b(s, 0, Integer.MAX_VALUE);
            if (b != df) {
                this.er.ep[this.er.eq].av(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(df);
        }
    }
}
