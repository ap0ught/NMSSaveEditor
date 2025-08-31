// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class aM extends G
{
    final /* synthetic */ aJ dj;
    
    aM(final aJ dj) {
        this.dj = dj;
    }
    
    @Override
    protected String g(final String s) {
        if (this.dj.di == null) {
            return "";
        }
        final int do1 = this.dj.di.dO();
        try {
            final int b = hf.b(s, 0, 100);
            if (b != do1) {
                this.dj.di.aD(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(do1);
        }
    }
}
