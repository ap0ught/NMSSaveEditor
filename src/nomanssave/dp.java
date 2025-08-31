// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dp extends G
{
    final /* synthetic */ dj hl;
    
    dp(final dj hl) {
        this.hl = hl;
    }
    
    @Override
    protected String g(final String s) {
        final gv gv = (gv)this.hl.ha.getSelectedItem();
        if (gv == null) {
            return "";
        }
        final double dh = gv.dH();
        try {
            final double a = hf.a(s, 0.0, 1000.0);
            if (a != dh) {
                gv.f(a);
            }
            return Double.toString(a);
        }
        catch (final RuntimeException ex) {
            return Double.toString(dh);
        }
    }
}
