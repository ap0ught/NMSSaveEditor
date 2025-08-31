// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dn extends G
{
    final /* synthetic */ dj hl;
    
    dn(final dj hl) {
        this.hl = hl;
    }
    
    @Override
    protected String g(final String s) {
        final gv gv = (gv)this.hl.ha.getSelectedItem();
        if (gv == null) {
            return "";
        }
        final double df = gv.dF();
        try {
            final double a = hf.a(s, 0.0, 1000.0);
            if (a != df) {
                gv.d(a);
            }
            return Double.toString(a);
        }
        catch (final RuntimeException ex) {
            return Double.toString(df);
        }
    }
}
