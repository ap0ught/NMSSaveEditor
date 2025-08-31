// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dM extends G
{
    private final gG hH;
    final /* synthetic */ dE hE;
    
    private dM(final dE he, final gG hh) {
        this.hE = he;
        this.hH = hh;
    }
    
    @Override
    protected String g(final String s) {
        final gE ge = (gE)this.hE.hx.getSelectedItem();
        if (ge == null) {
            return "";
        }
        final int aq = ge.aq(this.hH.ordinal());
        try {
            final int b = hf.b(s, 0, this.hH.dY());
            if (b != aq) {
                ge.e(this.hH.ordinal(), b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(aq);
        }
    }
}
