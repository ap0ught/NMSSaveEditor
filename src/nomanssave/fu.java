// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.regex.Pattern;

public class fu implements fq
{
    private static final byte[] lA;
    private static final byte[] lB;
    private static final Pattern lC;
    private final File lD;
    private fR lE;
    private fw[] lF;
    private fv lG;
    private fx[] lH;
    
    static {
        lA = "NOMANSKY".getBytes();
        lB = new byte[] { 126, -25, 85, -54, -47, 7, 0, 0 };
        lC = Pattern.compile("\\{\"Version\":(\\d*),.*");
    }
    
    public static fn ag(final int i) {
        final int n = (0xE00 & i) >> 9;
        if (n > 0 || n <= fn.values().length) {
            return fn.values()[n - 1];
        }
        throw new RuntimeException("Unsupported version: " + i);
    }
    
    fu(final File parent, final fR le) {
        this.lD = (parent.isFile() ? parent : new File(parent, "memory.dat"));
        this.lE = le;
        System.out.println(this.lD.getAbsolutePath());
        final FileInputStream fileInputStream = new FileInputStream(this.lD);
        try {
            final long n = 0L;
            System.out.println("Reading header");
            final byte[] array = new byte[8];
            hk.readFully(fileInputStream, array);
            long n2 = n + array.length;
            if (!a(array, fu.lA)) {
                throw new IOException("Invalid header");
            }
            final int[] array2 = new int[14];
            for (int i = 0; i < array2.length; ++i) {
                array2[i] = hk.readInt(fileInputStream);
                n2 += 4L;
                if (array2[i] != 0) {
                    System.out.println("  ints[" + i + "] = " + array2[i] + " 0x" + Integer.toHexString(array2[i]) + " " + Integer.toBinaryString(array2[i]));
                }
            }
            System.out.println("Reading files");
            this.lF = new fw[32];
            for (int j = 0; j < this.lF.length; ++j) {
                this.lF[j] = new fw(this, fileInputStream);
                if (this.lF[j].isValid()) {
                    System.out.println("file[" + j + "]");
                    this.lF[j].bZ();
                }
                n2 += 48L;
            }
            for (int k = 0; k < this.lF.length; ++k) {
                if (this.lF[k].isValid()) {
                    fileInputStream.skip(this.lF[k].lP - n2);
                    final long lp = this.lF[k].lP;
                    final byte[] array3 = new byte[20];
                    final int read = fileInputStream.read(array3);
                    final Matcher matcher = fu.lC.matcher(new String(array3, 0, read, "ISO-8859-1"));
                    if (matcher.matches()) {
                        try {
                            this.lF[k].be = ag(Integer.parseInt(matcher.group(1)));
                        }
                        catch (final RuntimeException ex) {}
                    }
                    n2 = lp + read;
                }
            }
        }
        finally {
            fileInputStream.close();
        }
        fileInputStream.close();
        this.lG = null;
        this.lH = new fx[30];
        for (int l = 0; l < this.lF.length; ++l) {
            if (this.lF[l].isValid()) {
                if (this.lF[l].lN == 262144 && this.lG == null) {
                    this.lG = new fv(this, this.lF[l]);
                }
                if (this.lF[l].lN == 3145728 && this.lF[l].lO >= 2) {
                    this.lH[this.lF[l].lO - 2] = new fx(this, this.lF[l]);
                }
            }
        }
        fl.a(this, this.lD.getParentFile());
    }
    
    @Override
    public File bS() {
        return this.lD;
    }
    
    @Override
    public fr bT() {
        return this.lG;
    }
    
    @Override
    public ft[] bU() {
        final ft[] array = new ft[15];
        for (int i = 0; i < 15; ++i) {
            array[i] = new fy(this, i);
        }
        return array;
    }
    
    @Override
    public int W(final String s) {
        return -1;
    }
    
    @Override
    public void X(final String s) {
        s.equals(this.lD.getName());
    }
    
    public static void main(final String[] array) {
        final fu fu = new fu(new File("D:\\Temp\\PS4_NEW"), null);
    }
    
    private static boolean a(final byte[] array, final byte[] array2) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
