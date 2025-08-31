// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bi extends G
{
    final /* synthetic */ bd dP;
    
    bi(final bd dp) {
        this.dP = dp;
    }
    
    @Override
    protected String g(final String s) {
        if (this.dP.dO == null) {
            return "";
        }
        final double cy = this.dP.dO.cY();
        try {
            final double a = hf.a(s, 0.0, 1000.0);
            if (a != cy) {
                this.dP.dO.b(a);
            }
            return Double.toString(a);
        }
        catch (final RuntimeException ex) {
            return Double.toString(cy);
        }
    }
}
