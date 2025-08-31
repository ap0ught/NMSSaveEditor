// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.io.InputStream;

public class gc
{
    private static final long nc = -11644473600000L;
    
    public static String a(final InputStream inputStream) {
        final byte[] array = new byte[16];
        hk.readFully(inputStream, array);
        return h(array);
    }
    
    public static String cA() {
        final byte[] bytes = new byte[16];
        new SecureRandom().nextBytes(bytes);
        return h(bytes);
    }
    
    private static String h(final byte[] array) {
        final StringBuilder sb = new StringBuilder();
        a(array[3], sb);
        a(array[2], sb);
        a(array[1], sb);
        a(array[0], sb);
        a(array[5], sb);
        a(array[4], sb);
        a(array[7], sb);
        a(array[6], sb);
        a(array[8], sb);
        a(array[9], sb);
        a(array[10], sb);
        a(array[11], sb);
        a(array[12], sb);
        a(array[13], sb);
        a(array[14], sb);
        a(array[15], sb);
        return sb.toString();
    }
    
    private static void a(final byte b, final StringBuilder sb) {
        final int index = (0xF0 & b) >> 4;
        final int index2 = 0xF & b;
        sb.append("0123456789ABCDEF".charAt(index));
        sb.append("0123456789ABCDEF".charAt(index2));
    }
    
    public static void a(final OutputStream outputStream, String str) {
        if (str.length() > 32) {
            throw new IOException("invalid container path");
        }
        while (str.length() < 32) {
            str = "0" + str;
        }
        str = str.toLowerCase();
        final byte[] b = new byte[16];
        b[3] = (byte)Integer.parseInt(str.substring(0, 2), 16);
        b[2] = (byte)Integer.parseInt(str.substring(2, 4), 16);
        b[1] = (byte)Integer.parseInt(str.substring(4, 6), 16);
        b[0] = (byte)Integer.parseInt(str.substring(6, 8), 16);
        b[5] = (byte)Integer.parseInt(str.substring(8, 10), 16);
        b[4] = (byte)Integer.parseInt(str.substring(10, 12), 16);
        b[7] = (byte)Integer.parseInt(str.substring(12, 14), 16);
        b[6] = (byte)Integer.parseInt(str.substring(14, 16), 16);
        b[8] = (byte)Integer.parseInt(str.substring(16, 18), 16);
        b[9] = (byte)Integer.parseInt(str.substring(18, 20), 16);
        b[10] = (byte)Integer.parseInt(str.substring(20, 22), 16);
        b[11] = (byte)Integer.parseInt(str.substring(22, 24), 16);
        b[12] = (byte)Integer.parseInt(str.substring(24, 26), 16);
        b[13] = (byte)Integer.parseInt(str.substring(26, 28), 16);
        b[14] = (byte)Integer.parseInt(str.substring(28, 30), 16);
        b[15] = (byte)Integer.parseInt(str.substring(30, 32), 16);
        outputStream.write(b);
    }
    
    public static long b(final InputStream inputStream) {
        return hk.f(inputStream) / 10000L - 11644473600000L;
    }
    
    public static void a(final OutputStream outputStream, final long n) {
        hk.b(outputStream, (n + 11644473600000L) * 10000L);
    }
    
    public static String c(final InputStream inputStream) {
        final int int1 = hk.readInt(inputStream);
        if (int1 < 0) {
            throw new IOException("negative length");
        }
        final byte[] bytes = new byte[int1 * 2];
        hk.readFully(inputStream, bytes);
        return new String(bytes, "UTF-16LE");
    }
    
    public static void b(final OutputStream outputStream, final String s) {
        hk.a(outputStream, s.length());
        outputStream.write(s.getBytes("UTF-16LE"));
    }
    
    public static String d(final InputStream inputStream) {
        final byte[] bytes = new byte[128];
        hk.readFully(inputStream, bytes);
        int length;
        for (length = 0; length < bytes.length && (bytes[length] != 0 || bytes[length + 1] != 0); length += 2) {}
        return new String(bytes, 0, length, "UTF-16LE");
    }
    
    public static String e(final InputStream inputStream) {
        final byte[] bytes = new byte[128];
        hk.readFully(inputStream, bytes);
        int length;
        for (length = 0; length < bytes.length && bytes[length] != 0; ++length) {}
        return new String(bytes, 0, length, "UTF-8");
    }
    
    public static void c(final OutputStream outputStream, final String s) {
        byte[] bytes = s.getBytes("UTF-8");
        if (bytes.length < 128) {
            final byte[] array = new byte[128];
            System.arraycopy(bytes, 0, array, 0, bytes.length);
            array[bytes.length] = 0;
            bytes = array;
        }
        outputStream.write(bytes, 0, 128);
    }
}
