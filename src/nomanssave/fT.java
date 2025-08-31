// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.BufferedInputStream;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.io.File;
import java.util.regex.Pattern;

public class fT implements fq
{
    private static final byte[] lA;
    private static final Pattern lV;
    private static final Pattern lW;
    static final String mC = "containers.index";
    private final File lX;
    private final fR lE;
    private fU mD;
    private fY[] mE;
    private int header;
    private int lL;
    private String name;
    private int lM;
    private int lR;
    private int lS;
    private String mF;
    private int mG;
    private int mH;
    private List mI;
    private static final Pattern mJ;
    private static int mK;
    private static int mL;
    private static int mM;
    
    static {
        lA = "HGSAVEV2\u0000".getBytes();
        lV = Pattern.compile("Slot(\\d+)((Auto)|(Manual))");
        lW = Pattern.compile("wgsbackup(\\d*)\\.\\d*\\.zip");
        mJ = Pattern.compile("\"((?:<h0)|(?:CommonStateData))\":\\{\"((?:Pk4)|(?:SaveName))\":\"([^\"]+)\"");
        fT.mK = 1;
        fT.mL = 2;
        fT.mM = 3;
    }
    
    fT(final File file, final fR le) {
        this.lX = (file.isDirectory() ? file : file.getParentFile());
        this.lE = le;
        this.cr();
        try {
            this.mD = new fU(this);
        }
        catch (final FileNotFoundException ex) {}
        catch (final IOException ex2) {
            hc.a("Cannot read account data", ex2);
        }
        this.mE = new fY[30];
        for (int i = 0; i < this.mE.length; ++i) {
            try {
                this.mE[i] = new fY(this, i);
            }
            catch (final FileNotFoundException ex3) {}
            catch (final IOException ex4) {
                hc.a("Cannot read file data", ex4);
            }
        }
        fl.a(this, this.lX);
    }
    
    @Override
    protected void finalize() {
        fl.b(this);
    }
    
    @Override
    public void X(final String s) {
        s.equals("containers.index");
    }
    
    @Override
    public File bS() {
        return this.lX;
    }
    
    private void cr() {
        hc.info("Reading Container Index");
        final FileInputStream fileInputStream = new FileInputStream(new File(this.lX, "containers.index"));
        try {
            this.header = hk.readInt(fileInputStream);
            hc.debug("  header: " + this.header);
            final int int1 = hk.readInt(fileInputStream);
            hc.debug("  count: " + int1);
            this.lL = hk.readInt(fileInputStream);
            if (this.lL != 0) {
                hc.debug("  unknown1: " + this.lL);
            }
            this.name = gc.c(fileInputStream);
            hc.debug("  name: " + this.name);
            this.lM = hk.readInt(fileInputStream);
            if (this.lM != 0) {
                hc.debug("  unknown2: " + this.lM);
            }
            this.lR = hk.readInt(fileInputStream);
            if (this.lR != 0) {
                hc.debug("  unknown3: " + this.lR);
            }
            this.lS = hk.readInt(fileInputStream);
            if (this.lS != 0) {
                hc.debug("  unknown4: " + this.lS);
            }
            this.mF = gc.c(fileInputStream);
            hc.debug("  appid: " + this.mF);
            this.mG = hk.readInt(fileInputStream);
            if (this.mG != 0) {
                hc.debug("  unknown5: " + this.mG);
            }
            this.mH = hk.readInt(fileInputStream);
            if (this.mH != 0) {
                hc.debug("  unknown6: " + this.mH);
            }
            this.mI = new ArrayList();
            for (int i = 0; i < int1; ++i) {
                this.mI.add(new fW(this, fileInputStream));
            }
            if (fileInputStream.read() >= 0) {
                throw new IOException("Invalid footer");
            }
        }
        finally {
            fileInputStream.close();
        }
        fileInputStream.close();
    }
    
    private void cs() {
        final FileOutputStream fileOutputStream = new FileOutputStream(new File(this.lX, "containers.index"));
        try {
            hk.a(fileOutputStream, this.header);
            hk.a(fileOutputStream, this.mI.size());
            hk.a(fileOutputStream, this.lL);
            gc.b(fileOutputStream, this.name);
            hk.a(fileOutputStream, this.lM);
            hk.a(fileOutputStream, this.lR);
            hk.a(fileOutputStream, this.lS);
            gc.b(fileOutputStream, this.mF);
            hk.a(fileOutputStream, this.mG);
            hk.a(fileOutputStream, this.mH);
            final Iterator iterator = this.mI.iterator();
            while (iterator.hasNext()) {
                ((fW)iterator.next()).write(fileOutputStream);
            }
        }
        finally {
            fileOutputStream.close();
        }
        fileOutputStream.close();
    }
    
    private fW Z(final String s) {
        for (final fW fw : this.mI) {
            if (fw.name.equals(s)) {
                return fw;
            }
        }
        throw new FileNotFoundException(s);
    }
    
    private String ct() {
        boolean b;
        File file;
        String ca;
        do {
            b = true;
            ca = gc.cA();
            final Iterator iterator = this.mI.iterator();
            while (iterator.hasNext()) {
                b &= ((fW)iterator.next()).mU.equals(ca);
            }
            file = new File(this.lX, ca);
        } while (!(b & file.exists()));
        if (!file.mkdir()) {
            throw new FileNotFoundException(ca);
        }
        return ca;
    }
    
    @Override
    public fr bT() {
        return this.mD;
    }
    
    @Override
    public ft[] bU() {
        final ft[] array = new ft[15];
        for (int i = 0; i < 15; ++i) {
            array[i] = new fZ(this, i);
        }
        return array;
    }
    
    @Override
    public int W(final String input) {
        final Matcher matcher = fT.lV.matcher(input);
        if (!matcher.matches()) {
            return -1;
        }
        return Integer.parseInt(matcher.group(1));
    }
    
    private static int an(final int n) {
        return (0x7FFF0000 & n) | (0xE00 & n) >> 9;
    }
    
    private static boolean h(final File file) {
        final File[] listFiles = file.listFiles();
        if (listFiles != null) {
            File[] array;
            for (int length = (array = listFiles).length, i = 0; i < length; ++i) {
                h(array[i]);
            }
        }
        return file.delete();
    }
    
    private static InputStream a(InputStream in, final int n) {
        try {
            boolean b = true;
            if (!in.markSupported()) {
                in = new BufferedInputStream(in);
            }
            in.mark(fT.lA.length);
            final byte[] array = new byte[fT.lA.length];
            hk.readFully(in, array);
            for (int i = 0; i < fT.lA.length; ++i) {
                if (array[i] != fT.lA[i]) {
                    b = false;
                    break;
                }
            }
            if (b) {
                return new hm(in);
            }
            in.reset();
            final byte[] array2 = new byte[16];
            in.mark(array2.length);
            hk.readFully(in, array2);
            if ((0xFF & array2[0]) == 0xE5 && (0xFF & array2[1]) == 0xA1 && (0xFF & array2[2]) == 0xED && (0xFF & array2[3]) == 0xFE) {
                return new gX(in, array2);
            }
            in.reset();
            return new ha(in, n);
        }
        catch (final IOException ex) {
            try {
                in.close();
            }
            catch (final IOException ex2) {}
            throw ex;
        }
    }
}
