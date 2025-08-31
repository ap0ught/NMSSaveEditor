// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.math.RoundingMode;
import java.math.BigDecimal;

public class gT
{
    static final int rT = 12;
    private static final double rU = 0.1;
    private final double[] rV;
    private final double[] rW;
    private final double[] rX;
    
    private static double[] b(final double[] array) {
        final double sqrt = Math.sqrt(array[0] * array[0] + array[1] * array[1] + array[2] * array[2]);
        if (sqrt < 0.1) {
            throw new RuntimeException("vector cannot be normalized");
        }
        return new double[] { array[0] / sqrt, array[1] / sqrt, array[2] / sqrt };
    }
    
    public gT() {
        this.rX = new double[] { 0.0, 0.0, 1.0 };
        this.rW = new double[] { 0.0, 1.0, 0.0 };
        this.rV = new double[] { 1.0, 0.0, 0.0 };
    }
    
    public gT(double[] array, double[] b) {
        final double sqrt = Math.sqrt(array[0] * array[0] + array[1] * array[1] + array[2] * array[2]);
        if (sqrt < 0.1) {
            if (b[0] != 0.0 || b[1] != 0.0 || b[2] != 1.0) {
                throw new RuntimeException("Unable to calculate base structures");
            }
            this.rX = new double[] { 0.0, 0.0, 1.0 };
            this.rW = new double[] { 0.0, 1.0, 0.0 };
            this.rV = new double[] { 1.0, 0.0, 0.0 };
        }
        else {
            array = new double[] { array[0] / sqrt, array[1] / sqrt, array[2] / sqrt };
            b = b(b);
            final double n = b[0] * array[0] + b[1] * array[1] + b[2] * array[2];
            this.rX = b;
            this.rW = b(new double[] { array[0] - n * b[0], array[1] - n * b[1], array[2] - n * b[2] });
            this.rV = b(new double[] { this.rW[1] * b[2] - this.rW[2] * b[1], this.rW[2] * b[0] - this.rW[0] * b[2], this.rW[0] * b[1] - this.rW[1] * b[0] });
        }
    }
    
    private static double[] a(final double n, final double[] array, final double[] array2) {
        final double cos = Math.cos(n);
        final double n2 = -Math.sin(n);
        final double n3 = array2[0];
        final double n4 = array2[1];
        final double n5 = array2[2];
        final double[][] array3 = new double[3][3];
        array3[0][0] = n3 * n3 * (1.0 - cos) + cos;
        array3[0][1] = n3 * n4 * (1.0 - cos) + n5 * n2;
        array3[0][2] = n3 * n5 * (1.0 - cos) - n4 * n2;
        array3[1][0] = n3 * n4 * (1.0 - cos) - n5 * n2;
        array3[1][1] = n4 * n4 * (1.0 - cos) + cos;
        array3[1][2] = n4 * n5 * (1.0 - cos) + n3 * n2;
        array3[2][0] = n3 * n5 * (1.0 - cos) + n4 * n2;
        array3[2][1] = n4 * n5 * (1.0 - cos) - n3 * n2;
        array3[2][2] = n5 * n5 * (1.0 - cos) + cos;
        final double n6 = array[0] * array3[0][0] + array[1] * array3[1][0] + array[2] * array3[2][0];
        final double n7 = array[0] * array3[0][1] + array[1] * array3[1][1] + array[2] * array3[2][1];
        final double n8 = array[0] * array3[0][2] + array[1] * array3[1][2] + array[2] * array3[2][2];
        final double sqrt = Math.sqrt(n6 * n6 + n7 * n7 + n8 * n8);
        return new double[] { n6 / sqrt, n7 / sqrt, n8 / sqrt };
    }
    
    public double[] a(final gU gu) {
        if (gu.rY.equals("fr")) {
            return a(gu.rZ, this.rX, this.rV);
        }
        if (gu.rY.equals("fu")) {
            return a(gu.rZ, this.rX, this.rW);
        }
        if (gu.rY.equals("ur")) {
            return a(gu.rZ, this.rW, this.rV);
        }
        if (gu.rY.equals("uf")) {
            return a(gu.rZ, this.rW, this.rX);
        }
        if (gu.rY.equals("ru")) {
            return a(gu.rZ, this.rV, this.rW);
        }
        if (gu.rY.equals("rf")) {
            return a(gu.rZ, this.rV, this.rX);
        }
        throw new RuntimeException("Unsupported rotation axis");
    }
    
    public double[] c(final double[] array) {
        return new double[] { array[0] * this.rV[0] + array[1] * this.rW[0] + array[2] * this.rX[0], array[0] * this.rV[1] + array[1] * this.rW[1] + array[2] * this.rX[1], array[0] * this.rV[2] + array[1] * this.rW[2] + array[2] * this.rX[2] };
    }
    
    public double[] d(final double[] array) {
        return new double[] { array[0] * this.rV[0] + array[1] * this.rV[1] + array[2] * this.rV[2], array[0] * this.rW[0] + array[1] * this.rW[1] + array[2] * this.rW[2], array[0] * this.rX[0] + array[1] * this.rX[1] + array[2] * this.rX[2] };
    }
    
    private void a(final double[] array, final StringBuffer sb, final StringBuffer sb2, final StringBuffer sb3, final int n) {
        final int length = sb.length();
        sb.append(a(array[0], n));
        sb2.append(a(array[1], n));
        sb3.append(a(array[2], n));
        final int max = Math.max(Math.max(sb.length(), sb2.length()), sb3.length());
        while (sb.length() < max) {
            sb.insert(length, ' ');
        }
        while (sb2.length() < max) {
            sb2.insert(length, ' ');
        }
        while (sb3.length() < max) {
            sb3.insert(length, ' ');
        }
    }
    
    private void a(final StringBuffer sb, final StringBuffer sb2, final StringBuffer sb3, final int n) {
        final int max = Math.max(Math.max(sb.length(), sb2.length()), sb3.length());
        while (sb.length() < max) {
            sb.append(' ');
        }
        while (sb2.length() < max) {
            sb2.append(' ');
        }
        while (sb3.length() < max) {
            sb3.append(' ');
        }
        sb.append("| ");
        sb2.append("| ");
        sb3.append("| ");
        this.a(this.rV, sb, sb2, sb3, n);
        sb.append(' ');
        sb2.append(' ');
        sb3.append(' ');
        this.a(this.rW, sb, sb2, sb3, n);
        sb.append(' ');
        sb2.append(' ');
        sb3.append(' ');
        this.a(this.rX, sb, sb2, sb3, n);
        sb.append(" |");
        sb2.append(" |");
        sb3.append(" |");
    }
    
    @Override
    public String toString() {
        return this.toString(12);
    }
    
    public String toString(final int n) {
        final StringBuffer sb = new StringBuffer();
        final StringBuffer sb2 = new StringBuffer();
        final StringBuffer sb3 = new StringBuffer();
        this.a(sb, sb2, sb3, n);
        final StringBuffer sb4 = new StringBuffer();
        sb4.append(sb).append("\n");
        sb4.append(sb2).append("\n");
        sb4.append(sb3).append("\n");
        return sb4.toString();
    }
    
    static String e(final double[] array) {
        return a(array, 12);
    }
    
    static String a(final double[] array, final int n) {
        return "[ " + b(array[0], n) + " , " + b(array[1], n) + " , " + b(array[2], n) + " ]";
    }
    
    static String f(final double[] array) {
        return b(array, 12);
    }
    
    static String b(final double[] array, final int n) {
        return "[ " + b(array[0], n) + " , " + b(array[1], n) + " , " + b(array[2], n) + " , " + b(array[3], n) + " ]";
    }
    
    static String a(final double val, final int newScale) {
        if (Double.isInfinite(val)) {
            return "Infinite";
        }
        if (Double.isNaN(val)) {
            return "NaN";
        }
        return new BigDecimal(val).setScale(newScale, RoundingMode.HALF_UP).toPlainString();
    }
    
    static String b(final double val, final int newScale) {
        if (Double.isInfinite(val)) {
            return "Infinite";
        }
        if (Double.isNaN(val)) {
            return "NaN";
        }
        String s = new BigDecimal(val).setScale(newScale, RoundingMode.HALF_UP).toPlainString();
        if (newScale <= 0) {
            return s;
        }
        while (s.endsWith("0") && !s.endsWith(".0")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
