// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dP extends G
{
    final /* synthetic */ dN ia;
    
    dP(final dN ia) {
        this.ia = ia;
    }
    
    @Override
    protected String g(final String s) {
        final gH gh = (gH)this.ia.hK.getSelectedItem();
        if (gh == null) {
            return "";
        }
        final double ec = gh.ec();
        try {
            final double a = hf.a(s, 0.0, 1000.0);
            if (a != ec) {
                gh.i(a);
            }
            return Double.toString(a);
        }
        catch (final RuntimeException ex) {
            return Double.toString(ec);
        }
    }
}
