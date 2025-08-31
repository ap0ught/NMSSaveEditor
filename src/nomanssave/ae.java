// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class ae extends G
{
    final /* synthetic */ X bV;
    
    ae(final X bv) {
        this.bV = bv;
    }
    
    @Override
    protected String g(String trim) {
        final gj gj = (gj)this.bV.bG.getSelectedItem();
        if (gj == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(gj.cN())) {
            gj.ab(trim);
            this.bV.bK.setText(trim);
        }
        return trim;
    }
}
