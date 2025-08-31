// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bv extends G
{
    final /* synthetic */ bl er;
    
    bv(final bl er) {
        this.er = er;
    }
    
    @Override
    protected String g(String trim) {
        if (this.er.eq < 0) {
            return "";
        }
        trim = trim.trim();
        if (!trim.equals(this.er.ep[this.er.eq].getName())) {
            this.er.ep[this.er.eq].setName(trim);
            this.er.dU.setText(trim);
            this.er.dR.updateUI();
        }
        return trim;
    }
}
