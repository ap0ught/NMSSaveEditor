// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;

public class fI
{
    private static final int mi = 2001;
    private static final int mj = 2002;
    private static final int mk = 2003;
    private static final int ml = 2004;
    private static final int mm = 6;
    private static final int mn = 2004;
    private static final int mo = 384;
    private final int mp;
    private final int lO;
    private int mq;
    private byte[] data;
    
    private static final boolean ai(final int n) {
        return n == 2001 || n == 2002 || n == 2003 || n == 2004;
    }
    
    private fI(final int mp, final int lo, final int mq, final byte[] data) {
        this.mp = mp;
        this.lO = lo;
        this.mq = mq;
        this.data = data;
    }
    
    public int cc() {
        return this.lO;
    }
    
    public int cd() {
        return this.mq;
    }
    
    public boolean ce() {
        if (this.mq == 2001) {
            return false;
        }
        if (this.data.length < 376) {
            final byte[] data = new byte[376];
            System.arraycopy(this.data, 0, data, 0, this.data.length);
            this.data = data;
        }
        this.mq = 2004;
        return true;
    }
    
    public byte[] cf() {
        return this.d(24, 32);
    }
    
    public void e(final byte[] array) {
        if (array.length != 32) {
            throw new IllegalArgumentException("SHA-256 must be 32 bytes");
        }
        this.setBytes(24, array);
    }
    
    public byte[] cg() {
        return this.d(8, 16);
    }
    
    public void f(final byte[] array) {
        if (array.length != 16) {
            throw new IllegalArgumentException("SpookyHash must be 16 bytes");
        }
        this.setBytes(8, array);
    }
    
    public int ch() {
        return this.getInt(56);
    }
    
    public void aj(final int n) {
        this.setInt(56, n);
    }
    
    public int ci() {
        return this.getInt(60);
    }
    
    public void ak(final int n) {
        this.setInt(60, n);
    }
    
    public int cj() {
        return this.getInt(76);
    }
    
    public void al(final int n) {
        this.setInt(76, n);
    }
    
    public String ck() {
        switch (this.mq) {
            case 2002:
            case 2003:
            case 2004: {
                return this.getString(88);
            }
            default: {
                return null;
            }
        }
    }
    
    public void Y(final String s) {
        switch (this.mq) {
            case 2002:
            case 2003:
            case 2004: {
                this.setString(216, s);
            }
            default: {}
        }
    }
    
    public String getDescription() {
        switch (this.mq) {
            case 2002:
            case 2003:
            case 2004: {
                return this.getString(88);
            }
            default: {
                return null;
            }
        }
    }
    
    public void setDescription(final String s) {
        switch (this.mq) {
            case 2002:
            case 2003:
            case 2004: {
                this.setString(216, s);
            }
            default: {}
        }
    }
    
    public static fI am(final int n) {
        return new fI(6, n, 2004, new byte[376]);
    }
    
    public static fI a(final int n, final byte[] array) {
        return a(n, array, 0, array.length);
    }
    
    public static fI a(final int n, final byte[] array, final int n2, final int i) {
        if (i < 8 || i % 4 != 0) {
            throw new IOException("Invalid metadata length: " + i);
        }
        final int n3 = (i == 104) ? 8 : 6;
        final long[] a = a(array, n2, i);
        long n4 = 0L;
        for (int j = 0; j < n3; ++j) {
            n4 = (n4 + 2654435769L & 0xFFFFFFFFL);
        }
        final int n5 = a.length - 1;
        final long n6 = (long)(n + 2) ^ 0x1422CB8CL;
        final long[] g = g("NAESEVADNAYRTNRG".getBytes("US-ASCII"));
        g[0] = (rotateLeft(n6, 13) * 5L + 3864292196L & 0xFFFFFFFFL);
        for (int k = 0; k < n3; ++k) {
            final int n7 = (int)(n4 >>> 2 & 0x3L);
            long n8 = a[0];
            int n9 = n5;
            for (int l = n5; l > 0; --l) {
                a[n9] = (a[n9] - ((n8 >> 3 ^ (a[n9 - 1] & 0xFFFFFFFL) << 4) + ((n8 * 4L & 0xFFFFFFFFL) ^ a[n9 - 1] >> 5) ^ (a[n9 - 1] ^ g[(l & 0x3) ^ n7]) + (n8 ^ n4)) & 0xFFFFFFFFL);
                n8 = a[n9--];
            }
            final int n10 = n5;
            a[0] = (a[0] - ((n8 >> 3 ^ (a[n10] & 0xFFFFFFFL) << 4) + ((n8 * 4L & 0xFFFFFFFFL) ^ a[n10] >> 5) ^ (a[n10] ^ g[n7]) + (n8 ^ n4)) & 0xFFFFFFFFL);
            n4 += 1640531527L;
        }
        if (a[0] != 4008636094L) {
            throw new IOException("Invalid metadata header: " + Long.toHexString(a[0]));
        }
        final int m = (int)a[1];
        if (!ai(m)) {
            throw new IOException("Invalid or unsupported format in metadata header: " + Integer.toHexString(m));
        }
        return new fI(n3, n, m, a(a, 2, a.length - 2));
    }
    
    public byte[] encode() {
        final long n = (long)(this.lO + 2) ^ 0x1422CB8CL;
        final long[] g = g("NAESEVADNAYRTNRG".getBytes("US-ASCII"));
        g[0] = (rotateLeft(n, 13) * 5L + 3864292196L & 0xFFFFFFFFL);
        final long[] g2 = g(this.data);
        final long[] array = new long[2 + g2.length];
        array[0] = 4008636094L;
        array[1] = this.mq;
        System.arraycopy(g2, 0, array, 2, g2.length);
        final int n2 = array.length - 1;
        long n3 = 0L;
        long n4 = 0L;
        for (int i = 0; i < this.mp; ++i) {
            n3 -= 1640531527L;
            final int n5 = (int)(n3 >> 2 & 0x3L);
            for (int n6 = 0, j = 0; j < n2; ++j, ++n6) {
                array[n6] = (array[n6] + ((array[n6 + 1] >> 3 ^ (n4 & 0xFFFFFFFL) << 4) + ((array[n6 + 1] * 4L & 0xFFFFFFFFL) ^ n4 >> 5) ^ (n4 ^ g[(j & 0x3) ^ n5]) + (array[n6 + 1] ^ n3)) & 0xFFFFFFFFL);
                n4 = array[n6];
            }
            array[n2] = (array[n2] + ((array[0] >> 3 ^ (n4 & 0xFFFFFFFL) << 4) + ((array[0] * 4L & 0xFFFFFFFFL) ^ n4 >> 5) ^ (n4 ^ g[(n2 & 0x3) ^ n5]) + (array[0] ^ n3)) & 0xFFFFFFFFL);
            n4 = array[n2];
        }
        return a(array, 0, array.length);
    }
    
    private int getInt(int i) {
        if (i < 8 || i % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + i);
        }
        i -= 8;
        return (this.data[i] & 0xFF) | (this.data[i + 1] & 0xFF) << 8 | (this.data[i + 2] & 0xFF) << 16 | (this.data[i + 3] & 0xFF) << 24;
    }
    
    private void setInt(int i, final int n) {
        if (i < 8 || i % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + i);
        }
        i -= 8;
        this.data[i] = (byte)(n & 0xFF);
        this.data[i + 1] = (byte)(n >> 8 & 0xFF);
        this.data[i + 2] = (byte)(n >> 16 & 0xFF);
        this.data[i + 3] = (byte)(n >> 24 & 0xFF);
    }
    
    private String getString(int n) {
        if (n < 8 || n % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + n);
        }
        n -= 8;
        for (int i = n; i < this.data.length; ++i) {
            if (this.data[i] == 0) {
                return new String(this.data, n, i - n);
            }
        }
        return "";
    }
    
    private void setString(int i, final String s) {
        if (i < 8 || i % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + i);
        }
        i -= 8;
        final byte[] bytes = s.getBytes();
        System.arraycopy(bytes, 0, this.data, i, bytes.length);
        i += bytes.length;
        for (int j = 4 - bytes.length % 4; j > 0; --j) {
            this.data[i++] = 0;
        }
    }
    
    private byte[] d(int i, final int j) {
        if (i < 8 || i % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + i);
        }
        if (j % 4 != 0) {
            throw new IllegalArgumentException("Invalid length: " + j);
        }
        i -= 8;
        final byte[] array = new byte[j];
        System.arraycopy(this.data, i, array, 0, j);
        return array;
    }
    
    private void setBytes(int i, final byte[] array) {
        if (i < 8 || i % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + i);
        }
        if (array.length % 4 != 0) {
            throw new IllegalArgumentException("Invalid length: " + array.length);
        }
        i -= 8;
        System.arraycopy(array, 0, this.data, i, array.length);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("00000000    ");
        sb.append("## ## ## ## ## ## ## ## ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("########");
        final int n = 8;
        for (int i = 0; i < this.data.length; ++i) {
            if ((i + n) % 16 == 0) {
                sb.append(System.lineSeparator());
                String s;
                for (s = String.valueOf(Integer.toString((i + 1 + n) / 16, 16)) + "0"; s.length() < 8; s = "0" + s) {}
                sb.append(String.valueOf(s) + "    ");
            }
            sb.append(Integer.toString((this.data[i] & 0xF0) >> 4, 16));
            sb.append(Integer.toString(this.data[i] & 0xF, 16));
            sb.append(' ');
            if (this.data[i] == 32) {
                sb2.append('.');
            }
            else if (this.data[i] >= 32 && this.data[i] < 127) {
                sb2.append((char)(this.data[i] & 0xFF));
            }
            else {
                sb2.append('?');
            }
            if ((i + n) % 16 == 15) {
                sb.append("   ");
                sb.append((CharSequence)sb2);
                sb2 = new StringBuilder();
            }
        }
        if (sb2.length() > 0) {
            while (sb2.length() < 16) {
                sb.append("   ");
                sb2.append(" ");
            }
            sb.append("   ");
            sb.append((CharSequence)sb2);
        }
        return sb.toString();
    }
    
    private static long rotateLeft(final long n, final int n2) {
        return (n & (long)Math.pow(2.0, 32 - n2) - 1L) << n2 | n >>> 32 - n2;
    }
    
    private static byte[] a(final long[] array, final int n, final int n2) {
        final byte[] array2 = new byte[n2 * 4];
        for (int i = 0; i < n2; ++i) {
            array2[i * 4] = (byte)(array[n + i] & 0xFFL);
            array2[i * 4 + 1] = (byte)(array[n + i] >> 8 & 0xFFL);
            array2[i * 4 + 2] = (byte)(array[n + i] >> 16 & 0xFFL);
            array2[i * 4 + 3] = (byte)(array[n + i] >> 24 & 0xFFL);
        }
        return array2;
    }
    
    private static long[] g(final byte[] array) {
        return a(array, 0, array.length);
    }
    
    private static long[] a(final byte[] array, final int n, final int n2) {
        final long[] array2 = new long[n2 / 4];
        for (int i = 0; i < n2; i += 4) {
            array2[i / 4] = (((long)array[n + i] & 0xFFL) | ((long)array[n + i + 1] & 0xFFL) << 8 | ((long)array[n + i + 2] & 0xFFL) << 16 | ((long)array[n + i + 3] & 0xFFL) << 24);
        }
        return array2;
    }
}
