// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public class hk
{
    private static final String sM = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    
    public static String k(final byte[] array) {
        final StringBuilder sb = new StringBuilder();
        int n;
        for (n = 0; n + 3 <= array.length; n += 3) {
            final int n2 = (0xFF & array[n]) << 16 | (0xFF & array[n + 1]) << 8 | (0xFF & array[n + 2]);
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((0xFC0000 & n2) >> 18));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((0x3F000 & n2) >> 12));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((0xFC0 & n2) >> 6));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(0x3F & n2));
        }
        if (n + 2 == array.length) {
            final int n3 = (0xFF & array[n]) << 16 | (0xFF & array[n + 1]) << 8;
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((0xFC0000 & n3) >> 18));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((0x3F000 & n3) >> 12));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((0xFC0 & n3) >> 6));
        }
        if (n + 1 == array.length) {
            final int n4 = (0xFF & array[n]) << 16;
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((0xFC0000 & n4) >> 18));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((0x3F000 & n4) >> 12));
        }
        return sb.toString();
    }
    
    public static byte[] aD(final String s) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int index;
        for (index = 0; index + 4 <= s.length(); index += 4) {
            final int index2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index));
            final int index3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index + 1));
            final int index4 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index + 2));
            final int index5 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index + 3));
            if (index2 < 0 || index3 < 0 || index4 < 0 || index5 < 0) {
                throw new RuntimeException("Invalid base64 character");
            }
            byteArrayOutputStream.write(index2 << 2 | index3 >> 4);
            byteArrayOutputStream.write((0xF & index3) << 4 | index4 >> 2);
            byteArrayOutputStream.write((0x3 & index4) << 6 | index5);
        }
        if (index + 3 == s.length()) {
            final int index6 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index));
            final int index7 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index + 1));
            final int index8 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index + 2));
            if (index6 < 0 || index7 < 0 || index8 < 0) {
                throw new RuntimeException("Invalid base64 character");
            }
            byteArrayOutputStream.write(index6 << 2 | index7 >> 4);
            byteArrayOutputStream.write((0xF & index7) << 4 | index8 >> 2);
        }
        if (index + 2 == s.length()) {
            final int index9 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index));
            final int index10 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(index + 1));
            if (index9 < 0 || index10 < 0) {
                throw new RuntimeException("Invalid base64 character");
            }
            byteArrayOutputStream.write(index9 << 2 | index10 >> 4);
        }
        if (index + 1 == s.length()) {
            throw new RuntimeException("Unfinished base64 data");
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    public static int readInt(final InputStream inputStream) {
        final byte[] array = new byte[4];
        readFully(inputStream, array);
        return (0xFF & array[3]) << 24 | (0xFF & array[2]) << 16 | (0xFF & array[1]) << 8 | (0xFF & array[0]);
    }
    
    public static void a(final OutputStream outputStream, final int n) {
        outputStream.write(0xFF & n);
        outputStream.write(0xFF & n >> 8);
        outputStream.write(0xFF & n >> 16);
        outputStream.write(0xFF & n >> 24);
    }
    
    public static long f(final InputStream inputStream) {
        final byte[] array = new byte[8];
        readFully(inputStream, array);
        return (0xFFL & (long)array[7]) << 56 | (0xFFL & (long)array[6]) << 48 | (0xFFL & (long)array[5]) << 40 | (0xFFL & (long)array[4]) << 32 | (0xFFL & (long)array[3]) << 24 | (0xFFL & (long)array[2]) << 16 | (0xFFL & (long)array[1]) << 8 | (0xFFL & (long)array[0]);
    }
    
    public static void b(final OutputStream outputStream, final long n) {
        outputStream.write((int)(0xFFL & n));
        outputStream.write((int)(0xFFL & n >> 8));
        outputStream.write((int)(0xFFL & n >> 16));
        outputStream.write((int)(0xFFL & n >> 24));
        outputStream.write((int)(0xFFL & n >> 32));
        outputStream.write((int)(0xFFL & n >> 40));
        outputStream.write((int)(0xFFL & n >> 48));
        outputStream.write((int)(0xFFL & n >> 56));
    }
    
    public static byte[] l(final File file) {
        final FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return g(fileInputStream);
        }
        finally {
            fileInputStream.close();
        }
    }
    
    public static byte[] g(final InputStream inputStream) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final byte[] array = new byte[4096];
        int read;
        while ((read = inputStream.read(array)) >= 0) {
            byteArrayOutputStream.write(array, 0, read);
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    public static void readFully(final InputStream inputStream, final byte[] array) {
        readFully(inputStream, array, 0, array.length);
    }
    
    public static void readFully(final InputStream inputStream, final byte[] b, int off, int len) {
        int read;
        while (len > 0 && (read = inputStream.read(b, off, len)) > 0) {
            off += read;
            len -= read;
        }
        if (len != 0) {
            throw new IOException("short read");
        }
    }
}
