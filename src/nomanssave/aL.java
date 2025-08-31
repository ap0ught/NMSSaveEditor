// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class aL extends G
{
    final /* synthetic */ aJ dj;
    
    aL(final aJ dj) {
        this.dj = dj;
    }
    
    @Override
    protected String g(final String s) {
        if (this.dj.di == null) {
            return "";
        }
        final int dn = this.dj.di.dN();
        try {
            final int b = hf.b(s, 0, 100);
            if (b != dn) {
                this.dj.di.aC(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(dn);
        }
    }
}
