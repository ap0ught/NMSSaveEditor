// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class hf
{
    public static int b(String trim, final int n, final int n2) {
        trim = trim.trim();
        if (trim.length() == 0) {
            throw new RuntimeException("No digits found");
        }
        long n3 = 0L;
        for (int i = 0; i < trim.length(); ++i) {
            final long n4 = n3 * 10L;
            final char char1 = trim.charAt(i);
            if (char1 < '0' || char1 > '9') {
                throw new RuntimeException("Invalid digit: " + char1);
            }
            n3 = n4 + (char1 - '0');
            if (n3 > n2) {
                return n2;
            }
        }
        if (n3 < n) {
            return n;
        }
        return (int)n3;
    }
    
    public static long a(String trim, final long n, final long n2) {
        trim = trim.trim();
        if (trim.length() == 0) {
            throw new RuntimeException("No digits found");
        }
        long n3 = 0L;
        for (int i = 0; i < trim.length(); ++i) {
            final long n4 = n3 * 10L;
            final char char1 = trim.charAt(i);
            if (char1 < '0' || char1 > '9') {
                throw new RuntimeException("Invalid digit: " + char1);
            }
            n3 = n4 + (char1 - '0');
            if (n3 > n2) {
                return n2;
            }
        }
        if (n3 < n) {
            return n;
        }
        return n3;
    }
    
    public static double a(String trim, final double n, final double n2) {
        trim = trim.trim();
        final double double1 = Double.parseDouble(trim);
        if (double1 < n) {
            return n;
        }
        if (double1 > n2) {
            return n2;
        }
        return double1;
    }
}
