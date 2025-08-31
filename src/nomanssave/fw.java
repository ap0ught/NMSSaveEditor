// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Date;
import java.io.OutputStream;
import java.io.InputStream;

class fw
{
    public fn be;
    final byte[] lK;
    final int lL;
    final int lM;
    final int lN;
    final int lO;
    long bd;
    long length;
    long lP;
    final int lQ;
    final int lR;
    final int lS;
    final /* synthetic */ fu lJ;
    
    fw(final fu lj, final InputStream inputStream) {
        this.lJ = lj;
        hk.readFully(inputStream, this.lK = new byte[8]);
        this.lL = hk.readInt(inputStream);
        this.lM = hk.readInt(inputStream);
        this.lN = hk.readInt(inputStream);
        this.lO = hk.readInt(inputStream);
        this.bd = 1000L * hk.readInt(inputStream);
        this.length = (0xFFFFFFFFL & (long)hk.readInt(inputStream));
        this.lP = (0xFFFFFFFFL & (long)hk.readInt(inputStream));
        this.lQ = hk.readInt(inputStream);
        this.lR = hk.readInt(inputStream);
        this.lS = hk.readInt(inputStream);
    }
    
    boolean isValid() {
        return a(this.lK, fu.lB) && this.lO >= 0;
    }
    
    int a(final OutputStream outputStream) {
        outputStream.write(this.lK);
        hk.a(outputStream, this.lL);
        hk.a(outputStream, this.lM);
        hk.a(outputStream, this.lN);
        hk.a(outputStream, this.lO);
        hk.a(outputStream, (int)(this.bd / 1000L));
        hk.a(outputStream, (int)this.length);
        hk.a(outputStream, (int)this.lP);
        hk.a(outputStream, this.lQ);
        hk.a(outputStream, this.lR);
        hk.a(outputStream, this.lS);
        return 48;
    }
    
    void bZ() {
        System.out.println("  unknown1 = " + this.lL + " 0x" + Integer.toHexString(this.lL) + " " + Integer.toBinaryString(this.lL));
        System.out.println("  unknown2 = " + this.lM + " 0x" + Integer.toHexString(this.lM) + " " + Integer.toBinaryString(this.lM));
        System.out.println("  fileType = " + this.lN + " 0x" + Integer.toHexString(this.lN) + " " + Integer.toBinaryString(this.lN));
        System.out.println("  archiveNumber = " + this.lO + " 0x" + Integer.toHexString(this.lO) + " " + Integer.toBinaryString(this.lO));
        System.out.println("  modified = " + new Date(this.bd));
        System.out.println("  length = " + this.length);
        System.out.println("  startPos = 0x" + Long.toHexString(this.lP));
        System.out.println("  valid = " + this.lQ);
        if (this.lR != 0) {
            System.out.println("  unknown3 = " + this.lR + " 0x" + Integer.toHexString(this.lR) + " " + Integer.toBinaryString(this.lR) + " date:" + new Date(1000L * this.lR));
        }
        if (this.lS != 0) {
            System.out.println("  unknown4 = " + this.lS + " 0x" + Integer.toHexString(this.lS) + " " + Integer.toBinaryString(this.lS) + " len:" + (0xFFFFFFFFL & (long)this.lS));
        }
    }
    
    byte[] ca() {
        if (!this.isValid()) {
            return null;
        }
        final FileInputStream fileInputStream = new FileInputStream(this.lJ.lD);
        try {
            fileInputStream.skip(this.lP);
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final byte[] array = new byte[4096];
            long length = this.length;
            int read;
            while (length > 0L && (read = fileInputStream.read(array, 0, (int)Math.min(array.length, length))) > 0) {
                length -= read;
                byteArrayOutputStream.write(array, 0, read);
            }
            if (length > 0L) {
                throw new IOException("short read");
            }
            return byteArrayOutputStream.toByteArray();
        }
        finally {
            fileInputStream.close();
        }
    }
    
    void d(final byte[] b) {
        if (!this.isValid()) {
            throw new IOException("header not valid");
        }
        int n = -1;
        for (int i = 0; i < this.lJ.lF.length; ++i) {
            if (this.lJ.lF[i] == this) {
                n = i;
                break;
            }
        }
        if (n < 0) {
            throw new IOException("header not valid");
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final FileOutputStream fileOutputStream = new FileOutputStream(new File(this.lJ.lD.getParentFile(), "~" + this.lJ.lD.getName()));
        try {
            final FileInputStream fileInputStream = new FileInputStream(this.lJ.lD);
            try {
                System.out.println("Reading header");
                final byte[] b2 = new byte[64];
                hk.readFully(fileInputStream, b2);
                fileOutputStream.write(b2);
                final long n2 = b.length - this.lJ.lF[n].length;
                long n3 = 64L;
                for (int j = 0; j < n; ++j) {
                    if (this.lJ.lF[j].lP < this.lJ.lF[n].lP) {
                        final fw fw = this.lJ.lF[j];
                        fw.lP += n2;
                    }
                    n3 += this.lJ.lF[j].a(fileOutputStream);
                }
                fileOutputStream.write(fu.lB);
                this.lJ.lF[n].length = b.length;
                this.lJ.lF[n].bd = currentTimeMillis;
                long n4 = n3 + this.lJ.lF[n].a(fileOutputStream);
                for (int k = n + 1; k < this.lJ.lF.length; ++k) {
                    if (this.lJ.lF[k].lP < this.lJ.lF[n].lP) {
                        final fw fw2 = this.lJ.lF[k];
                        fw2.lP += n2;
                    }
                    n4 += this.lJ.lF[k].a(fileOutputStream);
                }
                long b3;
                byte[] b4;
                int read;
                for (b3 = this.lJ.lF[n].lP - n4, b4 = new byte[4096]; b3 > 0L && (read = fileInputStream.read(b4, 0, (int)Math.min(b4.length, b3))) > 0; b3 -= read) {
                    fileOutputStream.write(b4, 0, read);
                    n4 += read;
                }
                if (b3 > 0L) {
                    throw new IOException("short read");
                }
                fileOutputStream.write(b);
                final long n5 = n4 + b.length;
                long b5;
                int read2;
                for (b5 = b.length - n2; b5 > 0L && (read2 = fileInputStream.read(b4, 0, (int)Math.min(b4.length, b5))) > 0; b5 -= read2) {}
                if (b5 > 0L) {
                    throw new IOException("short read");
                }
                int read3;
                while ((read3 = fileInputStream.read(b4)) > 0) {
                    fileOutputStream.write(b4, 0, read3);
                }
            }
            finally {
                fileInputStream.close();
            }
            fileInputStream.close();
        }
        finally {
            fileOutputStream.close();
        }
        fileOutputStream.close();
    }
}
