// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.nio.charset.Charset;

public class fg
{
    private static final Charset kT;
    final byte[] bytes;
    
    static {
        kT = Charset.forName("Windows-1252");
    }
    
    public fg(final byte[] bytes) {
        this.bytes = bytes;
    }
    
    byte[] toByteArray() {
        final byte[] array = new byte[this.bytes.length];
        System.arraycopy(this.bytes, 0, array, 0, this.bytes.length);
        return array;
    }
    
    public int indexOf(final int n) {
        return this.indexOf(n, 0);
    }
    
    public int indexOf(final int n, final int n2) {
        for (int i = n2; i < this.bytes.length; ++i) {
            if (n == (this.bytes[i] & 0xFF)) {
                return i;
            }
        }
        return -1;
    }
    
    public String substring(final int n) {
        return this.substring(n, this.bytes.length - n);
    }
    
    public String substring(final int offset, final int length) {
        return new String(this.bytes, offset, length, fg.kT);
    }
    
    public String bP() {
        final StringBuilder sb = new StringBuilder();
        boolean b = false;
        for (int i = 0; i < this.bytes.length; ++i) {
            final int n = this.bytes[i] & 0xFF;
            if (i == 0) {
                if (n != 94) {
                    return this.toString();
                }
                sb.append('^');
            }
            else if (n == 35) {
                sb.append('#');
                b = true;
            }
            else if (b) {
                sb.append((char)n);
            }
            else {
                sb.append("0123456789ABCDEFabcdef".charAt((this.bytes[i] & 0xF0) >> 4));
                sb.append("0123456789ABCDEFabcdef".charAt(this.bytes[i] & 0xF));
            }
        }
        return sb.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof fg)) {
            return false;
        }
        final fg fg = (fg)o;
        if (this.bytes.length != fg.bytes.length) {
            return false;
        }
        for (int i = 0; i < this.bytes.length; ++i) {
            if (this.bytes[i] != fg.bytes[i]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        return new String(this.bytes, fg.kT);
    }
}
