// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.OutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import java.io.FilterOutputStream;

public class gZ extends FilterOutputStream
{
    private static final LZ4Factory se;
    private final LZ4Compressor sf;
    private byte[] buffer;
    private int sg;
    private int sh;
    private int si;
    
    static {
        se = LZ4Factory.safeInstance();
    }
    
    public gZ(final OutputStream out) {
        super(out);
        this.sf = gZ.se.fastCompressor();
        this.buffer = new byte[524288];
        this.sg = 0;
        this.sh = 0;
        this.si = 0;
    }
    
    @Override
    public void write(final int n) {
        if (this.sg == this.buffer.length) {
            this.ek();
        }
        this.buffer[this.sg++] = (byte)n;
    }
    
    @Override
    public void write(final byte[] array) {
        this.write(array, 0, array.length);
    }
    
    @Override
    public void write(final byte[] array, int n, int i) {
        if (i == this.buffer.length) {
            this.ek();
        }
        while (i >= this.buffer.length - this.sg) {
            final int n2 = this.buffer.length - this.sg;
            System.arraycopy(array, n, this.buffer, this.sg, n2);
            this.sg = this.buffer.length;
            this.ek();
            n += n2;
            i -= n2;
        }
        if (i > 0) {
            System.arraycopy(array, n, this.buffer, this.sg, i);
            this.sg += i;
        }
    }
    
    private void ek() {
        final int maxCompressedLength = this.sf.maxCompressedLength(this.sg);
        final byte[] b = new byte[maxCompressedLength];
        final int compress = this.sf.compress(this.buffer, 0, this.sg, b, 0, maxCompressedLength);
        this.out.write(new byte[] { -27, -95, -19, -2, (byte)(0xFF & compress), (byte)(0xFF & compress >> 8), (byte)(0xFF & compress >> 16), (byte)(0xFF & compress >> 24), (byte)(0xFF & this.sg), (byte)(0xFF & this.sg >> 8), (byte)(0xFF & this.sg >> 16), (byte)(0xFF & this.sg >> 24), 0, 0, 0, 0 });
        this.out.write(b, 0, compress);
        this.sh += this.sg;
        this.sg = 0;
        this.si += compress + 16;
    }
    
    public int ch() {
        return this.sh;
    }
    
    public int ci() {
        return this.si;
    }
    
    @Override
    public void flush() {
        if (this.sg > 0) {
            this.ek();
        }
        this.out.flush();
    }
    
    @Override
    public void close() {
        try {
            if (this.sg > 0) {
                this.ek();
            }
        }
        finally {
            this.out.close();
        }
        this.out.close();
    }
}
