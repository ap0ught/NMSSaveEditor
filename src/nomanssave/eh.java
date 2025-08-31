// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class eh extends G
{
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;
    
    eh(final ec ik, final int il) {
        this.ik = ik;
        this.il = il;
    }
    
    @Override
    protected String g(String string) {
        try {
            string = hg.aB(string).toString();
            if (!string.equals(this.ik.ij.ic[this.il].eg())) {
                this.ik.ij.ic[this.il].ay(string);
            }
            return string;
        }
        catch (final RuntimeException ex) {
            return this.ik.ij.ic[this.il].eg();
        }
    }
}
