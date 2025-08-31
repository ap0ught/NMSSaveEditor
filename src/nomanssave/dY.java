// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dY extends G
{
    final /* synthetic */ dN ia;
    
    dY(final dN ia) {
        this.ia = ia;
    }
    
    @Override
    protected String g(final String s) {
        final gH gh = (gH)this.ia.hK.getSelectedItem();
        if (gh == null) {
            return "";
        }
        final double df = gh.dF();
        try {
            final double a = hf.a(s, 0.0, 1000.0);
            if (a != df) {
                gh.d(a);
            }
            return Double.toString(a);
        }
        catch (final RuntimeException ex) {
            return Double.toString(df);
        }
    }
}
