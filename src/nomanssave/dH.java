// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dH extends G
{
    final /* synthetic */ dE hE;
    
    dH(final dE he) {
        this.hE = he;
    }
    
    @Override
    protected String g(String string) {
        final gE ge = (gE)this.hE.hx.getSelectedItem();
        if (ge == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(ge.cK())) {
                ge.aa(string);
            }
            return string;
        }
        catch (final RuntimeException ex) {
            return ge.cK();
        }
    }
}
