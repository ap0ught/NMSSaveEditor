// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class af extends G
{
    final /* synthetic */ X bV;
    
    af(final X bv) {
        this.bV = bv;
    }
    
    @Override
    protected String g(String trim) {
        final gj gj = (gj)this.bV.bG.getSelectedItem();
        if (gj == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(gj.cO())) {
            gj.ac(trim);
            this.bV.bL.setText(trim);
        }
        return trim;
    }
}
