// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dU extends G
{
    final /* synthetic */ dN ia;
    
    dU(final dN ia) {
        this.ia = ia;
    }
    
    @Override
    protected String g(String string) {
        final gH gh = (gH)this.ia.hK.getSelectedItem();
        if (gh == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(gh.cK())) {
                gh.aa(string);
            }
            return string;
        }
        catch (final RuntimeException ex) {
            return gh.cK();
        }
    }
}
