// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class ac extends G
{
    final /* synthetic */ X bV;
    
    ac(final X bv) {
        this.bV = bv;
    }
    
    @Override
    protected String g(String trim) {
        final gj gj = (gj)this.bV.bG.getSelectedItem();
        if (gj == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(gj.getName())) {
            gj.setName(trim);
            this.bV.bI.setText(trim);
        }
        return trim;
    }
}
