// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class ci extends G
{
    final /* synthetic */ cg fF;
    
    ci(final cg ff) {
        this.fF = ff;
    }
    
    @Override
    protected String g(final String s) {
        if (this.fF.fD == null) {
            return "";
        }
        try {
            final int b = hf.b(s, 1, this.fF.fB.dB());
            if (this.fF.fD != b) {
                this.fF.fB.aA(b);
                cg.b(this.fF, new Integer(b));
            }
        }
        catch (final RuntimeException ex) {}
        return this.fF.fD.toString();
    }
}
