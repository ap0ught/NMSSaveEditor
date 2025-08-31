// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bh extends G
{
    final /* synthetic */ bd dP;
    
    bh(final bd dp) {
        this.dP = dp;
    }
    
    @Override
    protected String g(final String s) {
        if (this.dP.dO == null) {
            return "";
        }
        final double cx = this.dP.dO.cX();
        try {
            final double a = hf.a(s, 0.0, 1000.0);
            if (a != cx) {
                this.dP.dO.a(a);
            }
            return Double.toString(a);
        }
        catch (final RuntimeException ex) {
            return Double.toString(cx);
        }
    }
}
