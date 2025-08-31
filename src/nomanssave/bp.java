// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bp extends G
{
    final /* synthetic */ bl er;
    
    bp(final bl er) {
        this.er = er;
    }
    
    @Override
    protected String g(final String s) {
        if (this.er.eq < 0) {
            return "";
        }
        final int de = this.er.ep[this.er.eq].de();
        try {
            final int b = hf.b(s, 0, Integer.MAX_VALUE);
            if (b != de) {
                this.er.ep[this.er.eq].au(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(de);
        }
    }
}
