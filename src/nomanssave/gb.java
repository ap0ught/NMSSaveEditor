// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Comparator;

class gb implements Comparator
{
    final /* synthetic */ fZ nb;
    
    gb(final fZ nb) {
        this.nb = nb;
    }
    
    public int a(final fs fs, final fs fs2) {
        final long n = fs2.lastModified() - fs.lastModified();
        if (n < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (n > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int)n;
    }
}
