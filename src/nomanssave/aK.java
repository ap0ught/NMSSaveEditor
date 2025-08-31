// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class aK extends G
{
    final /* synthetic */ aJ dj;
    
    aK(final aJ dj) {
        this.dj = dj;
    }
    
    @Override
    protected String g(final String s) {
        if (this.dj.di == null) {
            return "";
        }
        final int dm = this.dj.di.dM();
        try {
            final int b = hf.b(s, 1, 200);
            if (b != dm) {
                this.dj.di.aB(b);
            }
            return Integer.toString(b);
        }
        catch (final RuntimeException ex) {
            return Integer.toString(dm);
        }
    }
}
