// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;

class fQ
{
    final String filename;
    final int lO;
    fI mx;
    final /* synthetic */ fJ mt;
    
    fQ(final fJ mt, final String s, final int lo, final boolean b) {
        this.mt = mt;
        this.filename = s;
        this.lO = lo;
        if (b) {
            final FileInputStream fileInputStream = new FileInputStream(new File(mt.lX, "mf_" + s));
            try {
                hc.info("Reading metadata for " + s);
                final byte[] b2 = new byte[1024];
                this.mx = fI.a(lo, b2, 0, fileInputStream.read(b2));
            }
            finally {
                fileInputStream.close();
            }
            fileInputStream.close();
            final int ch = this.mx.ch();
            if (ch != 0) {
                hc.debug("  DecompressedSize: " + ch);
            }
            final int ci = this.mx.ci();
            if (ci != 0) {
                hc.debug("  CompressedSize: " + ci);
            }
            final int cj = this.mx.cj();
            if (cj != 0) {
                hc.info("  TotalPlayTime: " + fq.c(cj));
            }
        }
        else {
            hc.info("Creating new metadata for " + s);
            this.mx = fI.am(lo);
        }
    }
    
    public String K() {
        return this.filename;
    }
    
    public long lastModified() {
        return new File(this.mt.lX, "mf_" + this.filename).lastModified();
    }
    
    eY a(final eG eg) {
        FilterInputStream filterInputStream = new BufferedInputStream(new FileInputStream(new File(this.mt.lX, this.filename)));
        try {
            final byte[] array = new byte[16];
            filterInputStream.mark(array.length);
            hk.readFully(filterInputStream, array);
            if ((0xFF & array[0]) == 0xE5 && (0xFF & array[1]) == 0xA1 && (0xFF & array[2]) == 0xED && (0xFF & array[3]) == 0xFE) {
                filterInputStream = new gX(filterInputStream, array);
            }
            else {
                filterInputStream.reset();
            }
            Throwable t = null;
            try {
                final ff ff = new ff(filterInputStream, 6);
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
        finally {
            filterInputStream.close();
        }
    }
    
    byte[] ah(final int n) {
        InputStream inputStream = new FileInputStream(new File(this.mt.lX, this.filename));
        try {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final byte[] b = new byte[1024];
            hk.readFully(inputStream, b, 0, 16);
            if ((0xFF & b[0]) == 0xE5 && (0xFF & b[1]) == 0xA1 && (0xFF & b[2]) == 0xED && (0xFF & b[3]) == 0xFE) {
                inputStream = new gX(inputStream, b);
            }
            else {
                byteArrayOutputStream.write(b, 0, 16);
            }
            int read;
            while ((read = inputStream.read(b)) >= 0) {
                byteArrayOutputStream.write(b, 0, read);
                if (byteArrayOutputStream.size() >= n) {
                    break;
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        finally {
            inputStream.close();
        }
    }
    
    void a(final String obj, final fn fn, final String value, final String value2) {
        final File file = new File(this.mt.lX, "mf_" + this.filename);
        final File file2 = new File(this.mt.lX, this.filename);
        final Properties properties = new Properties();
        properties.setProperty("ArchiveNumber", Integer.toString(this.lO));
        properties.setProperty("ManifestFile", "mf_" + this.filename);
        properties.setProperty("StorageFile", this.filename);
        properties.setProperty("LastModified", Long.toString(file.lastModified()));
        if (fn != null) {
            properties.setProperty("GameMode", fn.name());
        }
        if (value != null) {
            properties.setProperty("SaveName", value);
        }
        if (value2 != null) {
            properties.setProperty("Description", value2);
        }
        final File file3 = new File(aH.cG, String.valueOf(obj) + "." + System.currentTimeMillis() + ".zip");
        final ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file3));
        try {
            final byte[] array = new byte[1024];
            out.putNextEntry(new ZipEntry(file.getName()));
            final FileInputStream fileInputStream = new FileInputStream(file);
            try {
                int read;
                while ((read = fileInputStream.read(array)) >= 0) {
                    out.write(array, 0, read);
                }
            }
            finally {
                fileInputStream.close();
            }
            fileInputStream.close();
            out.putNextEntry(new ZipEntry(file2.getName()));
            final FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                int read2;
                while ((read2 = fileInputStream2.read(array)) >= 0) {
                    out.write(array, 0, read2);
                }
            }
            finally {
                fileInputStream2.close();
            }
            fileInputStream2.close();
            out.putNextEntry(new ZipEntry("saveinfo.txt"));
            properties.store(out, "");
        }
        finally {
            out.close();
        }
        out.close();
        file3.setLastModified(file.lastModified());
    }
    
    void a(final eY ey, final boolean b) {
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
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        int ci = 0;
        OutputStream outputStream = new FileOutputStream(new File(this.mt.lX, this.filename));
        try {
            if (b) {
                outputStream = new gZ(outputStream);
            }
            outputStream.write(byteArray);
            if (b) {
                ci = ((gZ)outputStream).ci();
            }
        }
        finally {
            outputStream.close();
        }
        outputStream.close();
        if (!this.mx.ce()) {
            hc.warn("Metadata version could not be upgraded");
        }
        byte[] digest = new byte[32];
        byte[] d = new byte[16];
        if (!b) {
            try {
                digest = MessageDigest.getInstance("SHA-256").digest(byteArray);
                d = c(digest, byteArray);
            }
            catch (final NoSuchAlgorithmException ex) {
                hc.a("Error generating SHA-256 hash", ex);
            }
        }
        this.mx.e(digest);
        this.mx.f(d);
        this.mx.ak(ci);
        this.mx.aj(byteArray.length);
        final FileOutputStream fileOutputStream = new FileOutputStream(new File(this.mt.lX, "mf_" + this.filename));
        try {
            fileOutputStream.write(this.mx.encode());
        }
        finally {
            fileOutputStream.close();
        }
        fileOutputStream.close();
    }
}
