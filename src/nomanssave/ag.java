// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class ag extends G
{
    final /* synthetic */ X bV;
    
    ag(final X bv) {
        this.bV = bv;
    }
    
    @Override
    protected String g(String trim) {
        final gj gj = (gj)this.bV.bG.getSelectedItem();
        if (gj == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(gj.cP())) {
            gj.ad(trim);
            this.bV.bM.setText(trim);
        }
        return trim;
    }
}
