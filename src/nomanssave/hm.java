// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.InputStream;
import java.io.FilterInputStream;

public class hm extends FilterInputStream
{
    private ha sa;
    private int sb;
    
    public hm(final InputStream in) {
        super(in);
        final byte[] array = new byte[8];
        hk.readFully(in, array);
        this.sa = new ha(new hn(this, (0xFF & array[4]) | (0xFF & array[5]) << 8 | (0xFF & array[6]) << 16 | (0xFF & array[7]) << 24, null), (0xFF & array[0]) | (0xFF & array[1]) << 8 | (0xFF & array[2]) << 16 | (0xFF & array[3]) << 24);
        this.sb = 1;
    }
    
    public int getFrameCount() {
        return this.sb;
    }
    
    private boolean ej() {
        final byte[] array = new byte[8];
        hk.readFully(this.in, array);
        this.sa = new ha(new hn(this, (0xFF & array[4]) | (0xFF & array[5]) << 8 | (0xFF & array[6]) << 16 | (0xFF & array[7]) << 24, null), (0xFF & array[0]) | (0xFF & array[1]) << 8 | (0xFF & array[2]) << 16 | (0xFF & array[3]) << 24);
        ++this.sb;
        return true;
    }
    
    @Override
    public int read() {
        if (this.sa == null || (this.sa.available() == 0 && !this.ej())) {
            return -1;
        }
        return this.sa.read();
    }
    
    @Override
    public int read(final byte[] array) {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) {
        if (this.sa == null || (this.sa.available() == 0 && !this.ej())) {
            return -1;
        }
        return this.sa.read(array, n, n2);
    }
}
