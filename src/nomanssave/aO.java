// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class aO extends G
{
    final /* synthetic */ aJ dj;
    
    aO(final aJ dj) {
        this.dj = dj;
    }
    
    @Override
    protected String g(final String s) {
        if (this.dj.di == null) {
            return "";
        }
        final long dk = this.dj.di.dK();
        try {
            final long a = hf.a(s, 0L, 4294967295L);
            if (a != dk) {
                this.dj.di.f(a);
            }
            return Long.toString(a);
        }
        catch (final RuntimeException ex) {
            return Long.toString(dk);
        }
    }
}
