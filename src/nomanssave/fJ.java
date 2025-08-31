// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.regex.Pattern;

public class fJ implements fq
{
    private static final Pattern lV;
    private static final Pattern lW;
    private final File lX;
    private final fR lE;
    private fK mr;
    private fM[] ms;
    
    static {
        lV = Pattern.compile("save(\\d*)\\.hg");
        lW = Pattern.compile("backup(\\d*)\\.\\d*\\.zip");
    }
    
    fJ(final File lx, final fR le) {
        this.lX = lx;
        this.lE = le;
        try {
            this.mr = new fK(this);
        }
        catch (final FileNotFoundException ex) {}
        catch (final IOException ex2) {
            hc.a("cannot read file metadata: mf_accountdata.hg", ex2);
        }
        this.ms = new fM[30];
        for (int i = 0; i < this.ms.length; ++i) {
            try {
                this.ms[i] = new fM(this, i);
            }
            catch (final FileNotFoundException ex3) {}
            catch (final IOException ex4) {
                hc.a("cannot read file metadata: mf_save" + ((i == 0) ? "" : Integer.toString(i + 1)) + ".hg", ex4);
            }
        }
        fl.a(this, lx);
    }
    
    @Override
    protected void finalize() {
        fl.b(this);
    }
    
    @Override
    public void X(final String str) {
        if (str.equals("accountdata.hg")) {
            try {
                this.mr = new fK(this);
                hc.info("Account data reloaded from storage.");
            }
            catch (final FileNotFoundException ex) {
                this.mr = null;
                hc.info("Account data deleted from storage.");
            }
            catch (final IOException ex2) {
                this.mr = null;
                hc.a("cannot read file metadata: mf_accountdata.hg", ex2);
            }
            this.lE.a(this);
        }
        final Matcher matcher = fJ.lV.matcher(str);
        if (matcher.matches()) {
            final int n = (matcher.group(1).length() == 0) ? 0 : (Integer.parseInt(matcher.group(1)) - 1);
            try {
                this.ms[n] = new fM(this, n);
                hc.info("Save file reloaded from storage: " + str);
            }
            catch (final FileNotFoundException ex3) {
                this.ms[n] = null;
                hc.info("Save file deleted from storage: " + str);
            }
            catch (final IOException ex4) {
                this.ms[n] = null;
                hc.a("cannot read file metadata: mf_save" + ((n == 0) ? "" : Integer.toString(n + 1)) + ".hg", ex4);
            }
            this.lE.a(this, n / 2, str);
        }
    }
    
    @Override
    public File bS() {
        return this.lX;
    }
    
    @Override
    public fr bT() {
        return this.mr;
    }
    
    @Override
    public ft[] bU() {
        final ft[] array = new ft[15];
        for (int i = 0; i < 15; ++i) {
            array[i] = new fN(this, i);
        }
        return array;
    }
    
    @Override
    public int W(final String input) {
        final Matcher matcher = fJ.lV.matcher(input);
        if (!matcher.matches()) {
            return -1;
        }
        return ((matcher.group(1).length() == 0) ? 0 : (Integer.parseInt(matcher.group(1)) - 1)) / 2;
    }
    
    @Override
    public boolean bW() {
        return true;
    }
    
    @Override
    public String a(final int n, final eY ey) {
        if (this.ms[n * 2] != null) {
            this.ms[n * 2].cm();
            this.ms[n * 2] = null;
        }
        if (this.ms[n * 2 + 1] != null) {
            this.ms[n * 2 + 1].cm();
            this.ms[n * 2 + 1] = null;
        }
        this.ms[n * 2] = new fM(this, n * 2, ey);
        return this.ms[n * 2].filename;
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
    
    private static byte[] c(final byte[] b, final byte[] b2) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(b, 0, b.length);
        byteArrayOutputStream.write(b2, 0, b2.length);
        final long[] array = { 96176015842230784L, -8446744073709551617L };
        hh.a(byteArrayOutputStream.toByteArray(), array);
        return a(new long[] { array[0] & 0xFFFFFFFFL, array[0] >>> 32 & 0xFFFFFFFFL, array[1] & 0xFFFFFFFFL, array[1] >>> 32 & 0xFFFFFFFFL }, 0, 4);
    }
}
