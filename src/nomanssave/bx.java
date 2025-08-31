// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bx extends G
{
    final /* synthetic */ bl er;
    
    bx(final bl er) {
        this.er = er;
    }
    
    @Override
    protected String g(String trim) {
        if (this.er.eq < 0) {
            return "";
        }
        try {
            trim = trim.trim();
            if (!trim.equals(this.er.ep[this.er.eq].cU())) {
                this.er.ep[this.er.eq].ah(trim);
                this.er.dY.setText(trim);
            }
            return trim;
        }
        catch (final RuntimeException ex) {
            return this.er.ep[this.er.eq].cU();
        }
    }
}
