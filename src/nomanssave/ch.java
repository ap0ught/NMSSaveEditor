// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class ch extends G
{
    final /* synthetic */ cg fF;
    
    ch(final cg ff) {
        this.fF = ff;
    }
    
    @Override
    protected String g(final String s) {
        if (this.fF.fC == null) {
            return "";
        }
        try {
            final int b = hf.b(s, 0, 99999);
            if (this.fF.fC != b) {
                this.fF.fB.m(this.fF.fA.M(b));
                cg.a(this.fF, new Integer(b));
            }
        }
        catch (final RuntimeException ex) {}
        return this.fF.fC.toString();
    }
}
