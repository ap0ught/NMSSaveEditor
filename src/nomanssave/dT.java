// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dT extends G
{
    final /* synthetic */ dN ia;
    
    dT(final dN ia) {
        this.ia = ia;
    }
    
    @Override
    protected String g(String trim) {
        final gH gh = (gH)this.ia.hK.getSelectedItem();
        if (gh == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(gh.getName())) {
            gh.setName(trim);
            this.ia.hL.setText(trim);
        }
        return trim;
    }
}
