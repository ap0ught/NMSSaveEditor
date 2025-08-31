// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;
import java.io.InputStream;

class hn extends InputStream
{
    private int sc;
    final /* synthetic */ hm sW;
    
    private hn(final hm sw, final int sc) {
        this.sW = sw;
        this.sc = sc;
    }
    
    @Override
    public int read() {
        if (this.sc == 0) {
            return -1;
        }
        final int read = this.sW.in.read();
        if (read < 0) {
            throw new IOException("short read");
        }
        --this.sc;
        return read;
    }
    
    @Override
    public int read(final byte[] array) {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] b, final int off, int len) {
        if (this.sc == 0) {
            return -1;
        }
        if (len > this.sc) {
            len = this.sc;
        }
        len = this.sW.in.read(b, off, len);
        if (len <= 0) {
            throw new IOException("short read");
        }
        this.sc -= len;
        return len;
    }
}
