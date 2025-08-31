// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.regex.Pattern;

public class fA implements fq
{
    private static final byte[] lA;
    private static final Pattern lV;
    private static final Pattern lW;
    private final File lX;
    private final fR lE;
    private fB lY;
    private fD[] lZ;
    
    static {
        lA = "NOMANSKY".getBytes();
        lV = Pattern.compile("savedata(\\d{2})\\.hg", 2);
        lW = Pattern.compile("ps4_backup(\\d*)\\.\\d*\\.zip", 2);
    }
    
    fA(final File lx, final fR le) {
        this.lX = lx;
        this.lE = le;
        try {
            this.lY = new fB(this);
        }
        catch (final FileNotFoundException ex) {}
        catch (final IOException ex2) {
            hc.a("cannot read file metadata: savedata00.hg", ex2);
        }
        this.lZ = new fD[30];
        for (int i = 0; i < this.lZ.length; ++i) {
            try {
                this.lZ[i] = new fD(this, i);
            }
            catch (final FileNotFoundException ex3) {}
            catch (final IOException ex4) {
                final int j = i + 2;
                hc.a("cannot read file metadata: " + ("savedata" + ((j < 10) ? "0" : "") + Integer.toString(j) + ".hg"), ex4);
            }
        }
        fl.a(this, lx);
    }
    
    private static eY a(final byte[] buf, final eG eg) {
        Throwable t = null;
        try {
            final ff ff = new ff(new ByteArrayInputStream(buf), 2);
            try {
                return ff.a(eg);
            }
            finally {
                if (ff != null) {
                    ff.close();
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
    
    private static byte[] g(final eY ey) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable t = null;
        try {
            final fj fj = new fj(byteArrayOutputStream, 2);
            try {
                fj.h(ey);
            }
            finally {
                if (fj != null) {
                    fj.close();
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
        return byteArrayOutputStream.toByteArray();
    }
    
    @Override
    public File bS() {
        return this.lX;
    }
    
    @Override
    public fr bT() {
        return this.lY;
    }
    
    @Override
    public ft[] bU() {
        final ft[] array = new ft[15];
        for (int i = 0; i < 15; ++i) {
            array[i] = new fE(this, i);
        }
        return array;
    }
    
    @Override
    public int W(final String input) {
        final Matcher matcher = fA.lV.matcher(input);
        if (!matcher.matches()) {
            return -1;
        }
        final int n = Integer.parseInt(matcher.group(1)) - 2;
        return (n >= 0) ? (n / 2) : -1;
    }
    
    @Override
    public void X(final String str) {
        final Matcher matcher = fA.lV.matcher(str);
        if (matcher.matches()) {
            final int n = Integer.parseInt(matcher.group(1)) - 2;
            if (n == -2) {
                try {
                    this.lY = new fB(this);
                    hc.info("Account data reloaded from storage.");
                }
                catch (final FileNotFoundException ex) {
                    this.lY = null;
                    hc.info("Account data deleted from storage.");
                }
                catch (final IOException ex2) {
                    this.lY = null;
                    hc.a("cannot read file metadata: " + str, ex2);
                }
                this.lE.a(this);
            }
            else if (n >= 0) {
                try {
                    this.lZ[n] = new fD(this, n);
                    hc.info("Save file reloaded from storage: " + str);
                }
                catch (final FileNotFoundException ex3) {
                    this.lZ[n] = null;
                    hc.info("Save file deleted from storage: " + str);
                }
                catch (final IOException ex4) {
                    this.lZ[n] = null;
                    hc.a("cannot read file metadata: " + str, ex4);
                }
                this.lE.a(this, n / 2, str);
            }
        }
    }
}
