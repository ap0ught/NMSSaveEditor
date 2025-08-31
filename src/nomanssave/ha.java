// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public class ha extends FilterInputStream
{
    private boolean sj;
    private byte[] buffer;
    private int sk;
    private int sg;
    private int sl;
    private boolean eof;
    
    public ha(final InputStream in, final int n) {
        super(in);
        if (n == 0) {
            this.sj = true;
            this.buffer = new byte[1048576];
        }
        else {
            this.sj = false;
            this.buffer = new byte[n];
        }
        this.sg = 0;
        this.sk = 0;
        this.eof = false;
    }
    
    private void aJ(final int n) {
        if (this.sg + n > this.buffer.length) {
            if (!this.sj) {
                throw new IOException("buffer exceeded");
            }
            int length = this.buffer.length;
            do {
                length += 1048576;
            } while (this.sg + n > length);
            final byte[] buffer = new byte[length];
            System.arraycopy(this.buffer, 0, buffer, 0, this.sg);
            this.buffer = buffer;
        }
    }
    
    private boolean el() {
        if (this.eof) {
            return false;
        }
        final int read = super.read();
        if (read < 0) {
            if (this.sj) {
                this.eof = true;
                return false;
            }
            throw new EOFException("Unexpected end of stream");
        }
        else {
            int n = read >> 4;
            int i = read & 0xF;
            if (n == 15) {
                int j;
                do {
                    j = super.read();
                    if (j < 0) {
                        throw new EOFException("Unexpected end of literal length");
                    }
                    n += j;
                } while (j == 255);
            }
            if (n > 0) {
                int len = n;
                this.aJ(len);
                int read2;
                while ((read2 = super.read(this.buffer, this.sg, len)) > 0) {
                    this.sg += read2;
                    len -= read2;
                    if (len == 0) {
                        break;
                    }
                }
                if (len > 0) {
                    throw new EOFException("Unexpected end of literal value");
                }
            }
            if (this.sg == this.buffer.length && !this.sj) {
                return this.eof = true;
            }
            final int read3 = super.read();
            if (read3 < 0) {
                if (this.sj) {
                    return this.eof = true;
                }
                throw new EOFException("Unexpected end of offset");
            }
            else {
                final int read4 = super.read();
                if (read4 < 0) {
                    throw new EOFException("Unexpected end of offset");
                }
                final int b = read3 | read4 << 8;
                if (i == 15) {
                    int k;
                    do {
                        k = super.read();
                        if (k < 0) {
                            throw new EOFException("Unexpected end of literal length");
                        }
                        i += k;
                    } while (k == 255);
                }
                i += 4;
                if (b == 0) {
                    throw new EOFException("Offset is zero!");
                }
                if (b > this.sg) {
                    throw new EOFException("Buffer too small");
                }
                this.aJ(i);
                if (i > b) {
                    final int n2 = this.sg - b;
                    do {
                        System.arraycopy(this.buffer, n2, this.buffer, this.sg, b);
                        i -= b;
                        this.sg += b;
                    } while (i > b);
                    System.arraycopy(this.buffer, n2, this.buffer, this.sg, i);
                    this.sg += i;
                }
                else {
                    System.arraycopy(this.buffer, this.sg - b, this.buffer, this.sg, i);
                    this.sg += i;
                }
                this.sl = Math.max(this.sl, b);
                return true;
            }
        }
    }
    
    @Override
    public int available() {
        if (this.sk == this.sg && !this.el()) {
            return 0;
        }
        return this.sg - this.sk;
    }
    
    @Override
    public int read() {
        if (this.sk == this.sg && !this.el()) {
            return -1;
        }
        return 0xFF & this.buffer[this.sk++];
    }
    
    @Override
    public int read(final byte[] array) {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) {
        if (this.sk == this.sg && !this.el()) {
            return -1;
        }
        final int min = Math.min(n2 - n, this.sg - this.sk);
        System.arraycopy(this.buffer, this.sk, array, n, min);
        this.sk += min;
        return min;
    }
}
