// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public class gX extends FilterInputStream
{
    private ha sa;
    private int sb;
    
    public gX(final InputStream in, final byte[] array) {
        super(in);
        this.sa = new ha(new gY(this, (0xFF & array[4]) | (0xFF & array[5]) << 8 | (0xFF & array[6]) << 16 | (0xFF & array[7]) << 24, null), (0xFF & array[8]) | (0xFF & array[9]) << 8 | (0xFF & array[10]) << 16 | (0xFF & array[11]) << 24);
        this.sb = 1;
    }
    
    public int getFrameCount() {
        return this.sb;
    }
    
    private boolean ej() {
        final byte[] b = new byte[16];
        final int read = this.in.read(b, 0, 16);
        if (read < 0) {
            this.sa = null;
            return false;
        }
        if (read < 16) {
            throw new IOException("Short read " + read);
        }
        if ((0xFF & b[0]) == 0xE5 && (0xFF & b[1]) == 0xA1 && (0xFF & b[2]) == 0xED && (0xFF & b[3]) == 0xFE) {
            this.sa = new ha(new gY(this, (0xFF & b[4]) | (0xFF & b[5]) << 8 | (0xFF & b[6]) << 16 | (0xFF & b[7]) << 24, null), (0xFF & b[8]) | (0xFF & b[9]) << 8 | (0xFF & b[10]) << 16 | (0xFF & b[11]) << 24);
            ++this.sb;
            return true;
        }
        throw new IOException("Invalid header");
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
