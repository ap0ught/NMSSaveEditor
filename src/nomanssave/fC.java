// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.Properties;
import java.io.IOException;
import java.util.zip.ZipFile;
import java.io.File;

class fC implements fs
{
    final int mb;
    final File mc;
    final String md;
    final byte[] lK;
    final fn be;
    final /* synthetic */ fA ma;
    
    fC(final fA ma, final String child, final int mb) {
        this.ma = ma;
        this.mb = mb;
        this.mc = new File(aH.cG, child);
        final ZipFile zipFile = new ZipFile(this.mc);
        try {
            final ZipEntry entry = zipFile.getEntry("saveinfo.txt");
            if (entry == null) {
                throw new IOException("Invalid backup file");
            }
            final Properties properties = new Properties();
            properties.load(zipFile.getInputStream(entry));
            this.md = properties.getProperty("StorageFile");
            if (this.md == null) {
                throw new IOException("Invalid backup file");
            }
            final String property = properties.getProperty("GameMode");
            this.be = ((property == null) ? null : fn.valueOf(property));
            final InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(this.md));
            try {
                hk.readFully(inputStream, this.lK = new byte[112]);
                for (int i = 0; i < fA.lA.length; ++i) {
                    if (this.lK[i] != fA.lA[i]) {
                        throw new IOException("Invalid header");
                    }
                }
            }
            finally {
                inputStream.close();
            }
            inputStream.close();
        }
        catch (final NumberFormatException ex) {
            throw new IOException("Invalid backup file");
        }
        finally {
            zipFile.close();
        }
        zipFile.close();
    }
    
    @Override
    public fn L() {
        return this.be;
    }
    
    @Override
    public String K() {
        return this.mc.getName();
    }
    
    @Override
    public long lastModified() {
        return this.mc.lastModified();
    }
    
    @Override
    public eY M() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable t = null;
        try {
            final ZipFile zipFile = new ZipFile(this.mc);
            try {
                final ZipEntry entry = zipFile.getEntry(this.md);
                if (entry == null) {
                    throw new IOException("Invalid backup file");
                }
                final InputStream inputStream = zipFile.getInputStream(entry);
                try {
                    inputStream.skip(112L);
                    final byte[] array = new byte[4096];
                    int read;
                    while ((read = inputStream.read(array)) >= 0) {
                        byteArrayOutputStream.write(array, 0, read);
                    }
                }
                finally {
                    inputStream.close();
                }
                inputStream.close();
                return a(byteArrayOutputStream.toByteArray(), eG.jV);
            }
            finally {
                if (zipFile != null) {
                    zipFile.close();
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
        return a(byteArrayOutputStream.toByteArray(), eG.jV);
    }
    
    @Override
    public String b(final eY ey) {
        hc.info("Writing new save file...");
        String s;
        if (this.ma.lZ[this.mb] != null) {
            s = this.ma.lZ[this.mb].b(ey);
        }
        else {
            this.ma.lZ[this.mb] = new fD(this.ma, this.mb, this.lK, ey);
            s = this.ma.lZ[this.mb].K();
        }
        hc.info("Finished.");
        return s;
    }
    
    @Override
    public String toString() {
        return this.mc.getName();
    }
}
