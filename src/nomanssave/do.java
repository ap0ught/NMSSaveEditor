// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class do extends G
{
    final /* synthetic */ dj hl;
    
    do(final dj hl) {
        this.hl = hl;
    }
    
    @Override
    protected String g(final String s) {
        final gv gv = (gv)this.hl.ha.getSelectedItem();
        if (gv == null) {
            return "";
        }
        final double dg = gv.dG();
        try {
            final double a = hf.a(s, 0.0, 1000.0);
            if (a != dg) {
                gv.e(a);
            }
            return Double.toString(a);
        }
        catch (final RuntimeException ex) {
            return Double.toString(dg);
        }
    }
}
