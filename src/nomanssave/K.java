// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class K extends G
{
    final /* synthetic */ I bt;
    
    K(final I bt) {
        this.bt = bt;
    }
    
    @Override
    protected String g(String string) {
        final gh gh = (gh)this.bt.bh.getSelectedItem();
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
