// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.OutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import java.io.FilterOutputStream;

public class hb extends FilterOutputStream
{
    private static final LZ4Factory se;
    private static final int sm = 65536;
    private final LZ4Compressor sf;
    private byte[] buffer;
    private int sg;
    private int si;
    
    static {
        se = LZ4Factory.safeInstance();
    }
    
    public hb(final OutputStream out) {
        super(out);
        this.sf = hb.se.fastCompressor();
        this.buffer = new byte[65536];
        this.sg = 0;
        this.si = 0;
    }
    
    private void aK(int n) {
        if (this.sg + n > this.buffer.length) {
            n += this.buffer.length;
            int n2 = (this.buffer.length + n) / 65536;
            if ((this.buffer.length + n) % 65536 > 0) {
                ++n2;
            }
            final byte[] buffer = new byte[n2 * 65536];
            System.arraycopy(this.buffer, 0, buffer, 0, this.sg);
            this.buffer = buffer;
        }
    }
    
    @Override
    public void write(final int n) {
        this.aK(1);
        this.buffer[this.sg++] = (byte)n;
    }
    
    @Override
    public void write(final byte[] array) {
        this.write(array, 0, array.length);
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) {
        this.aK(n2);
        System.arraycopy(array, n, this.buffer, this.sg, n2);
        this.sg += n2;
    }
    
    public int ch() {
        return this.sg;
    }
    
    public int ci() {
        return this.si;
    }
    
    @Override
    public void flush() {
        this.out.flush();
    }
    
    @Override
    public void close() {
        try {
            if (this.sg > 0) {
                final int maxCompressedLength = this.sf.maxCompressedLength(this.sg);
                final byte[] b = new byte[maxCompressedLength];
                this.si = this.sf.compress(this.buffer, 0, this.sg, b, 0, maxCompressedLength);
                this.out.write(b, 0, this.si);
            }
        }
        finally {
            this.out.close();
        }
        this.out.close();
    }
}
