// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dG extends G
{
    final /* synthetic */ dE hE;
    
    dG(final dE he) {
        this.hE = he;
    }
    
    @Override
    protected String g(String trim) {
        final gE ge = (gE)this.hE.hx.getSelectedItem();
        if (ge == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(ge.getName())) {
            ge.setName(trim);
            this.hE.hy.setText(trim);
        }
        return trim;
    }
}
