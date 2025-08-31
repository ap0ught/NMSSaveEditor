// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class be extends G
{
    final /* synthetic */ bd dP;
    
    be(final bd dp) {
        this.dP = dp;
    }
    
    @Override
    protected String g(String trim) {
        if (this.dP.dO == null) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(this.dP.dO.getName())) {
            this.dP.dO.setName(trim);
            this.dP.dG.setText(trim);
        }
        return trim;
    }
}
