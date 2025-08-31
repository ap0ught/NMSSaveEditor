// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class aP extends G
{
    final /* synthetic */ aJ dj;
    
    aP(final aJ dj) {
        this.dj = dj;
    }
    
    @Override
    protected String g(final String s) {
        if (this.dj.di == null) {
            return "";
        }
        final long dl = this.dj.di.dL();
        try {
            final long a = hf.a(s, 0L, 4294967295L);
            if (a != dl) {
                this.dj.di.g(a);
            }
            return Long.toString(a);
        }
        catch (final RuntimeException ex) {
            return Long.toString(dl);
        }
    }
}
