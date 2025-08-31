// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class ef extends G
{
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;
    
    ef(final ec ik, final int il) {
        this.ik = ik;
        this.il = il;
    }
    
    @Override
    protected String g(String string) {
        try {
            string = hg.aB(string).toString();
            if (!string.equals(this.ik.ij.ic[this.il].ee())) {
                this.ik.ij.ic[this.il].ax(string);
            }
            return string;
        }
        catch (final RuntimeException ex) {
            return this.ik.ij.ic[this.il].ee();
        }
    }
}
