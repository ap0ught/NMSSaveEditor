// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dW extends G
{
    final /* synthetic */ dN ia;
    
    dW(final dN ia) {
        this.ia = ia;
    }
    
    @Override
    protected String g(final String s) {
        if (this.ia.hY == null) {
            return "";
        }
        final int dm = this.ia.hY.dM();
        try {
            final int b = hf.b(s, 1, 500);
            if (b != dm) {
                this.ia.hY.aB(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(dm);
        }
    }
}
