// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class aN extends G
{
    final /* synthetic */ aJ dj;
    private final /* synthetic */ Application bv;
    
    aN(final aJ dj, final Application bv) {
        this.dj = dj;
        this.bv = bv;
    }
    
    @Override
    protected String g(final String s) {
        if (this.dj.di == null) {
            return "";
        }
        final long dj = this.dj.di.dJ();
        try {
            final long a = hf.a(s, 0L, 4294967295L);
            if (a != dj) {
                this.dj.di.e(a);
                this.bv.C();
            }
            return Long.toString(a);
        }
        catch (final RuntimeException ex) {
            return Long.toString(dj);
        }
    }
}
