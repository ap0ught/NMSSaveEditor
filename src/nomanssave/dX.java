// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class dX extends G
{
    final /* synthetic */ dN ia;
    
    dX(final dN ia) {
        this.ia = ia;
    }
    
    @Override
    protected String g(final String s) {
        if (this.ia.hY == null) {
            return "";
        }
        final int dn = this.ia.hY.dN();
        try {
            final int b = hf.b(s, 1, 200);
            if (b != dn) {
                this.ia.hY.aC(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(dn);
        }
    }
}
