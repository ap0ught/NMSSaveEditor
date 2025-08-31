// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class ei extends G
{
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;
    
    ei(final ec ik, final int il) {
        this.ik = ik;
        this.il = il;
    }
    
    @Override
    protected String g(final String s) {
        try {
            final int int1 = Integer.parseInt(s);
            if (int1 != this.ik.ij.ic[this.il].eh()) {
                this.ik.ij.ic[this.il].aI(int1);
            }
            return s;
        }
        catch (final RuntimeException ex) {
            return Integer.toString(this.ik.ij.ic[this.il].eh());
        }
    }
}
