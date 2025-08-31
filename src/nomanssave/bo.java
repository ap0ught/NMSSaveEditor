// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bo extends G
{
    final /* synthetic */ bl er;
    
    bo(final bl er) {
        this.er = er;
    }
    
    @Override
    protected String g(final String s) {
        if (this.er.eq < 0) {
            return "";
        }
        final int dd = this.er.ep[this.er.eq].dd();
        try {
            final int b = hf.b(s, 0, Integer.MAX_VALUE);
            if (b != dd) {
                this.er.ep[this.er.eq].at(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(dd);
        }
    }
}
