// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hl
{
    private static final Pattern sN;
    private static final Pattern sO;
    private static final Pattern sP;
    private int sQ;
    private int sR;
    private int sS;
    private int sT;
    private int sU;
    private int sV;
    
    static {
        sN = Pattern.compile("0x([0-9a-fA-F]{1,16})");
        sO = Pattern.compile("[0-9a-fA-F]{12}");
        sP = Pattern.compile("([0-9a-fA-F]{4}):([0-9a-fA-F]{4}):([0-9a-fA-F]{4}):([0-9a-fA-F]{4})");
    }
    
    private static long aE(final String s) {
        long n = 0L;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            final long n2 = n << 4;
            if (char1 >= 'A' && char1 <= 'F') {
                n = (n2 | (long)(char1 - '7'));
            }
            else if (char1 >= 'a' && char1 <= 'f') {
                n = (n2 | (long)(char1 - 'W'));
            }
            else {
                n = (n2 | (long)(char1 - '0'));
            }
        }
        return n;
    }
    
    private static int a(final long n, final int n2) {
        final int n3 = -1 >>> 32 - n2;
        final int n4 = Integer.MIN_VALUE >>> 32 - n2;
        int n5 = (int)(n & (long)n3);
        if ((n5 & n4) == n4) {
            n5 |= ~n3;
        }
        return n5;
    }
    
    private static int b(final long n, final int n2) {
        return (int)(n & (long)(-1 >>> 32 - n2));
    }
    
    public static hl e(final String s, final int n) {
        final Matcher matcher;
        if ((matcher = hl.sP.matcher(s)).matches()) {
            final long n2 = aE(matcher.group(1)) - 2047L;
            if (n2 > 2047L) {
                throw new RuntimeException("Invalid galactic coordinates");
            }
            final long n3 = aE(matcher.group(2)) - 127L;
            if (n3 > 127L) {
                throw new RuntimeException("Invalid galactic coordinates");
            }
            final long n4 = aE(matcher.group(3)) - 2047L;
            if (n4 > 2047L) {
                throw new RuntimeException("Invalid galactic coordinates");
            }
            final long ae = aE(matcher.group(4));
            if (ae > 65535L) {
                throw new RuntimeException("Invalid galactic coordinates");
            }
            return new hl((int)(ae >> 12 & 0xFL), (int)(ae & 0xFFFL), n, (int)n3, (int)n4, (int)n2);
        }
        else {
            if (hl.sO.matcher(s).matches()) {
                final long ae2 = aE(s);
                return new hl(b(ae2 >> 44, 4), b(ae2 >> 32, 12), n, a(ae2 >> 24, 8), a(ae2 >> 12, 12), a(ae2, 12));
            }
            throw new RuntimeException("Unable to decode value");
        }
    }
    
    public static hl n(final Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Number) {
            return new hl(((Number)o).longValue());
        }
        if (o instanceof String) {
            final String input = (String)o;
            final Matcher matcher;
            if ((matcher = hl.sN.matcher(input)).matches()) {
                return new hl(aE(matcher.group(1)));
            }
            return e(input, 0);
        }
        else {
            if (o instanceof eY && ((eY)o).contains("GalacticAddress")) {
                return new hl((eY)o);
            }
            return null;
        }
    }
    
    private hl(final eY ey) {
        this.sQ = ey.c("GalacticAddress.PlanetIndex", 0);
        this.sR = ey.c("GalacticAddress.SolarSystemIndex", 0);
        this.sS = ey.c("RealityIndex", 0);
        this.sT = ey.c("GalacticAddress.VoxelY", 0);
        this.sU = ey.c("GalacticAddress.VoxelZ", 0);
        this.sV = ey.c("GalacticAddress.VoxelX", 0);
    }
    
    public hl(final long n) {
        this.sQ = b(n >> 52, 12);
        this.sR = b(n >> 40, 12);
        this.sS = b(n >> 32, 8);
        this.sT = a(n >> 24, 8);
        this.sU = a(n >> 12, 12);
        this.sV = a(n >> 0, 12);
    }
    
    private hl(final int sq, final int sr, final int ss, final int st, final int su, final int sv) {
        this.sQ = sq;
        this.sR = sr;
        this.sS = ss;
        this.sT = st;
        this.sU = su;
        this.sV = sv;
    }
    
    public int eq() {
        return this.sQ;
    }
    
    public void aL(final int n) {
        if (n < 0 || n > 15) {
            throw new RuntimeException("Invalid planet index: " + n);
        }
        this.sQ = n;
    }
    
    public int er() {
        return this.sR;
    }
    
    public void aM(final int n) {
        if (n < 0 || n > 4095) {
            throw new RuntimeException("Invalid solar system index: " + n);
        }
        this.sR = n;
    }
    
    public int es() {
        return this.sS;
    }
    
    public void aN(final int n) {
        if (n < 0 || n > 255) {
            throw new RuntimeException("Invalid reality index: " + n);
        }
        this.sS = n;
    }
    
    public int et() {
        return this.sT;
    }
    
    public void aO(final int n) {
        if (n < -127 || n > 127) {
            throw new RuntimeException("Invalid voxelY coordinate: " + n);
        }
        this.sT = n;
    }
    
    public int eu() {
        return this.sU;
    }
    
    public void aP(final int n) {
        if (n < -2047 || n > 2047) {
            throw new RuntimeException("Invalid voxelZ coordinate: " + n);
        }
        this.sU = n;
    }
    
    public int ev() {
        return this.sV;
    }
    
    public void aQ(final int n) {
        if (n < -2047 || n > 2047) {
            throw new RuntimeException("Invalid voxelX coordinate: " + n);
        }
        this.sV = n;
    }
    
    public eY ew() {
        return new fa().d("RealityIndex", this.sS).d("GalacticAddress", new fa().d("VoxelX", this.sV).d("VoxelY", this.sT).d("VoxelZ", this.sU).d("SolarSystemIndex", this.sR).d("PlanetIndex", this.sQ).bH()).bH();
    }
    
    public long ex() {
        return ((long)this.sQ & 0xFL) << 52 | ((long)this.sR & 0xFFFL) << 40 | ((long)this.sS & 0xFFL) << 32 | ((long)this.sT & 0xFFL) << 24 | ((long)this.sU & 0xFFFL) << 12 | ((long)this.sV & 0xFFFL);
    }
    
    public String ey() {
        final StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.sQ & 0xF, 16));
        sb.append(Integer.toString(this.sR & 0xFFF, 16));
        while (sb.length() < 4) {
            sb.insert(1, '0');
        }
        sb.append(Integer.toString(this.sT & 0xFF, 16));
        while (sb.length() < 6) {
            sb.insert(4, '0');
        }
        sb.append(Integer.toString(this.sU & 0xFFF, 16));
        while (sb.length() < 9) {
            sb.insert(6, '0');
        }
        sb.append(Integer.toString(this.sV & 0xFFF, 16));
        while (sb.length() < 12) {
            sb.insert(9, '0');
        }
        return sb.toString().toUpperCase();
    }
    
    public String ez() {
        final StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.sV + 2047, 16));
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }
        sb.append(':');
        sb.append(Integer.toString(this.sT + 127, 16));
        while (sb.length() < 9) {
            sb.insert(5, '0');
        }
        sb.append(':');
        sb.append(Integer.toString(this.sU + 2047, 16));
        while (sb.length() < 14) {
            sb.insert(10, '0');
        }
        sb.append(':');
        sb.append(Integer.toString(this.sQ << 12 | this.sR, 16));
        while (sb.length() < 19) {
            sb.insert(15, '0');
        }
        return sb.toString().toUpperCase();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof hl) {
            final hl hl = (hl)o;
            return this.sQ == hl.sQ && this.sR == hl.sR && this.sS == hl.sS && this.sT == hl.sT && this.sU == hl.sU && this.sV == hl.sV;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (int)this.ex();
    }
    
    @Override
    public String toString() {
        return "0x" + Long.toString(this.ex(), 16);
    }
}
