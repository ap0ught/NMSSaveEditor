// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bf extends G
{
    final /* synthetic */ bd dP;
    
    bf(final bd dp) {
        this.dP = dp;
    }
    
    @Override
    protected String g(String trim) {
        if (this.dP.dO == null) {
            return "";
        }
        try {
            trim = trim.trim();
            if (!trim.equals(this.dP.dO.cU())) {
                this.dP.dO.ah(trim);
                this.dP.dJ.setText(trim);
            }
            return trim;
        }
        catch (final RuntimeException ex) {
            return this.dP.dO.cU();
        }
    }
}
