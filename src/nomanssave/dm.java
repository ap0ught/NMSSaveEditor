// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dm extends G
{
    final /* synthetic */ dj hl;
    
    dm(final dj hl) {
        this.hl = hl;
    }
    
    @Override
    protected String g(String string) {
        final gv gv = (gv)this.hl.ha.getSelectedItem();
        if (gv == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(gv.cK())) {
                gv.aa(string);
            }
            return string;
        }
        catch (final RuntimeException ex) {
            return gv.cK();
        }
    }
}
