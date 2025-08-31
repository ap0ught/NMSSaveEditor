// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.function.Predicate;

public class fh
{
    public static final int kU = 0;
    public static final int kV = 1;
    public static final int kW = 2;
    public static final int kX = 3;
    public static final int kY = 4;
    static final Predicate kZ;
    static final Predicate la;
    static final Predicate lb;
    static final Predicate lc;
    static final Predicate ld;
    static final String gc = "0123456789ABCDEFabcdef";
    
    static {
        kZ = (n -> n >= 48 && n <= 57);
        la = (n2 -> n2 == 46);
        lb = (n3 -> n3 == 101 || n3 == 69);
        lc = (n4 -> (n4 >= 48 && n4 <= 57) || n4 == 43 || n4 == 45);
        ld = (n5 -> (n5 & 0xC0) == 0x80);
    }
    
    static boolean a(final Class clazz) {
        if (clazz == null) {
            return true;
        }
        if (Boolean.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (BigDecimal.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (Number.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (String.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (eY.class.isAssignableFrom(clazz)) {
            return !fk.class.isAssignableFrom(clazz);
        }
        return eV.class.isAssignableFrom(clazz) || fg.class.isAssignableFrom(clazz);
    }
    
    public static String b(final Object o, final boolean b) {
        return a(o, b ? 7 : 0, null);
    }
    
    public static String a(final Object o, final int n, final Predicate predicate) {
        String lineSeparator = null;
        if ((n & 0x3) != 0x0) {
            switch (n & 0x3) {
                case 1: {
                    lineSeparator = "\n";
                    break;
                }
                case 2: {
                    lineSeparator = "\r\n";
                    break;
                }
                default: {
                    lineSeparator = System.lineSeparator();
                    break;
                }
            }
        }
        return a(o, lineSeparator, (n & 0x4) != 0x0, predicate);
    }
    
    static String a(final Object o, final String s, final boolean b) {
        return a(o, s, b, null);
    }
    
    private static String a(final Object o, final String s, final boolean b, final Predicate predicate) {
        if (o == null) {
            return "null";
        }
        if (o instanceof Boolean) {
            return o.toString();
        }
        if (o instanceof BigDecimal) {
            return ((BigDecimal)o).toEngineeringString();
        }
        if (o instanceof Number) {
            return o.toString();
        }
        if (o instanceof String) {
            return b((String)o, predicate);
        }
        if (o instanceof eY) {
            return a((eY)o, s, b, predicate);
        }
        if (o instanceof eV) {
            return a((eV)o, s, b, predicate);
        }
        if (o instanceof fg) {
            return b((fg)o);
        }
        throw new RuntimeException("unsupported data type");
    }
    
    static String a(final eV ev, final String s, final boolean b) {
        return a(ev, s, b, null);
    }
    
    private static String a(final eV ev, final String str, final boolean b, final Predicate predicate) {
        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < ev.length; ++i) {
            if (i > 0) {
                sb.append(',');
            }
            if (str != null) {
                sb.append(String.valueOf(str) + "\t");
            }
            sb.append(a(ev.values[i], (str == null) ? null : (String.valueOf(str) + "\t"), b, predicate));
        }
        if (ev.length > 0) {
            sb.append(str);
        }
        sb.append(']');
        return sb.toString();
    }
    
    static String a(final eY ey, final String s, final boolean b) {
        return a(ey, s, b, null);
    }
    
    private static String a(final eY ey, final String str, final boolean b, final Predicate predicate) {
        final StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < ey.length; ++i) {
            if (i > 0) {
                sb.append(',');
            }
            if (str != null) {
                sb.append(String.valueOf(str) + "\t");
            }
            sb.append(b(ey.names[i], predicate));
            sb.append(':');
            if (b) {
                sb.append(' ');
            }
            sb.append(a(ey.values[i], (str == null) ? null : (String.valueOf(str) + "\t"), b, predicate));
        }
        if (ey.length > 0) {
            sb.append(str);
        }
        sb.append('}');
        return sb.toString();
    }
    
    private static String a(final fg fg) {
        final StringBuilder sb = new StringBuilder();
        byte[] byteArray;
        for (int length = (byteArray = fg.toByteArray()).length, i = 0; i < length; ++i) {
            final int n = byteArray[i] & 0xFF;
            if (n == 13) {
                sb.append("\\r");
            }
            else if (n == 10) {
                sb.append("\\n");
            }
            else if (n == 9) {
                sb.append("\\t");
            }
            else if (n == 12) {
                sb.append("\\f");
            }
            else if (n == 8) {
                sb.append("\\b");
            }
            else if (n == 11) {
                sb.append("\\v");
            }
            else if (n == 0) {
                sb.append("\\0");
            }
            else if (n == 34) {
                sb.append("\\\"");
            }
            else if (n == 92) {
                sb.append("\\\\");
            }
            else if (n < 32 || n >= 128) {
                sb.append("\\x");
                sb.append("0123456789ABCDEFabcdef".charAt(n >> 4 & 0xF));
                sb.append("0123456789ABCDEFabcdef".charAt(n & 0xF));
            }
            else {
                sb.append(Character.toString((char)n));
            }
        }
        return sb.toString();
    }
    
    private static String b(final fg fg) {
        final StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(a(fg));
        sb.append('\"');
        return sb.toString();
    }
    
    private static String a(final String s, final Predicate predicate) {
        final StringBuilder sb = new StringBuilder();
        char[] charArray;
        for (int length = (charArray = s.toCharArray()).length, i = 0; i < length; ++i) {
            final char c = charArray[i];
            if (c == '\r') {
                sb.append("\\r");
            }
            else if (c == '\n') {
                sb.append("\\n");
            }
            else if (c == '\t') {
                sb.append("\\t");
            }
            else if (c == '\f') {
                sb.append("\\f");
            }
            else if (c == '\b') {
                sb.append("\\b");
            }
            else if (c == '\"') {
                sb.append("\\\"");
            }
            else if (c == '\\') {
                sb.append("\\\\");
            }
            else if (c < ' ' || (predicate != null && !predicate.test(c))) {
                sb.append("\\u");
                sb.append("0123456789ABCDEFabcdef".charAt(c >> 12 & 0xF));
                sb.append("0123456789ABCDEFabcdef".charAt(c >> 8 & 0xF));
                sb.append("0123456789ABCDEFabcdef".charAt(c >> 4 & 0xF));
                sb.append("0123456789ABCDEFabcdef".charAt(c & '\u000f'));
            }
            else {
                sb.append(Character.toString(c));
            }
        }
        return sb.toString();
    }
    
    static String O(final String s) {
        return b(s, null);
    }
    
    private static String b(final String s, final Predicate predicate) {
        final StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(a(s, predicate));
        sb.append('\"');
        return sb.toString();
    }
    
    public static Object P(final String s) {
        final fi fi = new fi(s);
        final Object a = a(fi, fi.bI());
        if (fi.bI() >= 0) {
            throw new eX("Invalid trailing data", fi.kF, fi.kG);
        }
        return a;
    }
    
    private static Object a(final fi fi, final int n) {
        if (n < 0) {
            throw new eX("Short read", fi.kF, fi.kG);
        }
        if (n == 123) {
            return a(fi);
        }
        if (n == 91) {
            return b(fi);
        }
        if (n == 34) {
            return d(fi);
        }
        if (n == 102) {
            if (fi.read() != 97) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 108) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 115) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 101) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            return Boolean.FALSE;
        }
        else if (n == 116) {
            if (fi.read() != 114) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 117) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 101) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            return Boolean.TRUE;
        }
        else if (n == 110) {
            if (fi.read() != 117) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 108) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 108) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            return null;
        }
        else if (n == 100) {
            if (fi.read() != 97) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 116) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 97) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.read() != 40) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            if (fi.bI() != 34) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            final fg e = e(fi);
            if (fi.bI() != 41) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            return e;
        }
        else {
            if (n == 45 || (n >= 48 && n <= 57)) {
                return b(fi, n);
            }
            throw new eX("Invalid token", fi.kF, fi.kG);
        }
    }
    
    static eY Q(final String s) {
        Throwable t = null;
        try {
            final fi fi = new fi(s);
            try {
                if (fi.bI() != 123) {
                    throw new eX("Invalid object string", fi.kF, fi.kG);
                }
                final eY a = a(fi);
                if (fi.bI() >= 0) {
                    throw new eX("Invalid trailing data", fi.kF, fi.kG);
                }
                return a;
            }
            finally {
                if (fi != null) {
                    fi.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception;
                t = exception;
            }
            else {
                final Throwable exception;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
    }
    
    private static eY a(final fi fi) {
        final eY ey = new eY();
        final int bi = fi.bI();
        if (bi == 34) {
            do {
                final String c = c(fi);
                if (fi.bI() != 58) {
                    throw new eX("Invalid token", fi.kF, fi.kG);
                }
                ey.a(c, a(fi, fi.bI()));
                final int bi2 = fi.bI();
                if (bi2 == 125) {
                    return ey;
                }
                if (bi2 != 44) {
                    throw new eX("Invalid token", fi.kF, fi.kG);
                }
            } while (fi.bI() == 34);
            throw new eX("Invalid token", fi.kF, fi.kG);
        }
        if (bi != 125) {
            throw new eX("Invalid token", fi.kF, fi.kG);
        }
        return ey;
    }
    
    static eV R(final String s) {
        Throwable t = null;
        try {
            final fi fi = new fi(s);
            try {
                if (fi.bI() != 91) {
                    throw new eX("Invalid array string", fi.kF, fi.kG);
                }
                final eV b = b(fi);
                if (fi.bI() >= 0) {
                    throw new eX("Invalid trailing data", fi.kF, fi.kG);
                }
                return b;
            }
            finally {
                if (fi != null) {
                    fi.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception;
                t = exception;
            }
            else {
                final Throwable exception;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
    }
    
    private static eV b(final fi fi) {
        final eV ev = new eV();
        int n;
        if ((n = fi.bI()) != 93) {
            while (true) {
                ev.e(a(fi, n));
                final int bi = fi.bI();
                if (bi == 93) {
                    break;
                }
                if (bi != 44) {
                    throw new eX("Invalid token", fi.kF, fi.kG);
                }
                n = fi.bI();
            }
        }
        return ev;
    }
    
    static int ae(int index) {
        if (index < 0) {
            throw new IOException("short read");
        }
        index = "0123456789ABCDEFabcdef".indexOf((char)index);
        if (index < 0) {
            throw new IOException("invalid hex char");
        }
        if (index >= 16) {
            index -= 6;
        }
        return index;
    }
    
    private static String c(final fi fi) {
        final Object d = d(fi);
        if (d instanceof String) {
            return (String)d;
        }
        throw new eX("Invalid string", fi.kF, fi.kG);
    }
    
    private static Object d(final fi fi) {
        try {
            StringBuilder sb = new StringBuilder();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b;
            while ((b = fi.read()) != 34) {
                if (b < 0) {
                    throw new eX("Short read");
                }
                if (b == 92) {
                    b = fi.read();
                    if (b < 0) {
                        throw new eX("Short read");
                    }
                    switch (b) {
                        case 114: {
                            b = 13;
                            break;
                        }
                        case 110: {
                            b = 10;
                            break;
                        }
                        case 116: {
                            b = 9;
                            break;
                        }
                        case 102: {
                            b = 12;
                            break;
                        }
                        case 98: {
                            b = 8;
                            break;
                        }
                        case 118: {
                            b = 11;
                            break;
                        }
                        case 48: {
                            b = 0;
                            break;
                        }
                        case 117: {
                            final int b2 = ae(fi.read()) << 12 | ae(fi.read()) << 8 | ae(fi.read()) << 4 | ae(fi.read());
                            if (b2 <= 255) {
                                if (sb != null) {
                                    sb.append((char)b2);
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.write(b2);
                                    continue;
                                }
                                continue;
                            }
                            else {
                                if (sb == null) {
                                    throw new eX("Mixed encodings detected in string");
                                }
                                byteArrayOutputStream = null;
                                sb.append((char)b2);
                                continue;
                            }
                            break;
                        }
                        case 120: {
                            final int b3 = ae(fi.read()) << 4 | ae(fi.read());
                            if (byteArrayOutputStream == null) {
                                throw new eX("Mixed encodings detected in stringx");
                            }
                            byteArrayOutputStream.write(b3);
                            sb = null;
                            continue;
                        }
                    }
                }
                if (sb != null) {
                    sb.append((char)b);
                }
                if (byteArrayOutputStream == null) {
                    continue;
                }
                byteArrayOutputStream.write(b);
            }
            if (sb != null) {
                return sb.toString();
            }
            return new fg(byteArrayOutputStream.toByteArray());
        }
        catch (final eX ex) {
            throw ex;
        }
        catch (final IOException ex2) {
            throw new eX("Invalid string", ex2, fi.kF, fi.kG);
        }
    }
    
    private static fg e(final fi fi) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (fi.read() != 48) {
            throw new eX("Invalid hex data", fi.kF, fi.kG);
        }
        if (fi.read() != 120) {
            throw new eX("Invalid hex data", fi.kF, fi.kG);
        }
        int read;
        while ((read = fi.read()) != 34) {
            if (read < 0) {
                throw new eX("Short read", fi.kF, fi.kG);
            }
            final int read2;
            if ((read2 = fi.read()) < 0) {
                throw new eX("Short read", fi.kF, fi.kG);
            }
            int index = "0123456789abcdefABCDEF".indexOf((char)read);
            if (index < 0) {
                throw new eX("Invalid hex data", fi.kF, fi.kG);
            }
            if (index >= 16) {
                index -= 6;
            }
            int index2 = "0123456789abcdefABCDEF".indexOf((char)read2);
            if (index2 < 0) {
                throw new eX("Invalid hex data", fi.kF, fi.kG);
            }
            if (index2 >= 16) {
                index2 -= 6;
            }
            byteArrayOutputStream.write(index << 4 | index2);
        }
        return new fg(byteArrayOutputStream.toByteArray());
    }
    
    private static Number b(final fi fi, int n) {
        boolean b = false;
        if (n == 45) {
            n = fi.a(fh.kZ);
            if (n < 0) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            b = true;
        }
        BigDecimal bigDecimal = new BigDecimal(n - 48);
        if (n != 48) {
            while ((n = fi.a(fh.kZ)) >= 0) {
                bigDecimal = bigDecimal.multiply(BigDecimal.TEN).add(new BigDecimal(n - 48));
            }
        }
        boolean b2 = true;
        if (fi.a(fh.la) >= 0) {
            b2 = false;
            n = fi.a(fh.kZ);
            if (n < 0) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            int n2 = 0;
            do {
                bigDecimal = bigDecimal.add(new BigDecimal(n - 48).scaleByPowerOfTen(--n2));
            } while ((n = fi.a(fh.kZ)) >= 0);
        }
        if (fi.a(fh.lb) >= 0) {
            b2 = false;
            n = fi.a(fh.lc);
            int n3 = 0;
            if (n == 43 || n == 45) {
                n3 = ((n == 45) ? 1 : 0);
                n = fi.a(fh.kZ);
            }
            if (n < 0) {
                throw new eX("Invalid token", fi.kF, fi.kG);
            }
            int n4 = 0;
            do {
                n4 = n4 * 10 + (n - 48);
            } while ((n = fi.a(fh.kZ)) >= 0);
            if (n3 != 0) {
                n4 = -n4;
            }
            bigDecimal = bigDecimal.scaleByPowerOfTen(n4);
        }
        if (b) {
            bigDecimal = bigDecimal.negate();
        }
        if (b2) {
            try {
                return bigDecimal.intValueExact();
            }
            catch (final ArithmeticException ex) {
                try {
                    return bigDecimal.longValueExact();
                }
                catch (final ArithmeticException ex2) {}
            }
        }
        return bigDecimal;
    }
    
    static void i(final Object o) {
        if (o instanceof eY) {
            ((eY)o).kD = null;
        }
        if (o instanceof eV) {
            ((eV)o).kD = null;
        }
    }
    
    static void a(final Object o, final Object o2) {
        if (o instanceof eY) {
            ((eY)o).kD = o2;
        }
        if (o instanceof eV) {
            ((eV)o).kD = o2;
        }
    }
}
