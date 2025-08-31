// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.zip.ZipEntry;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;

class fH
{
    final File mh;
    byte[] lK;
    final /* synthetic */ fA ma;
    
    fH(final fA ma, final String child, final boolean b) {
        this.ma = ma;
        this.mh = new File(ma.lX, child);
        if (b) {
            final FileInputStream fileInputStream = new FileInputStream(this.mh);
            try {
                hk.readFully(fileInputStream, this.lK = new byte[112]);
                for (int i = 0; i < fA.lA.length; ++i) {
                    if (this.lK[i] != fA.lA[i]) {
                        throw new IOException("Invalid header");
                    }
                }
            }
            finally {
                fileInputStream.close();
            }
            fileInputStream.close();
        }
    }
    
    byte[] readBytes() {
        final long n = (0xFFL & (long)this.lK[95]) << 24 | (0xFFL & (long)this.lK[94]) << 16 | (0xFFL & (long)this.lK[93]) << 8 | (0xFFL & (long)this.lK[92]);
        final FileInputStream fileInputStream = new FileInputStream(new File(this.ma.lX, this.K()));
        try {
            final byte[] array = new byte[(int)n];
            fileInputStream.skip(112L);
            hk.readFully(fileInputStream, array);
            return array;
        }
        finally {
            fileInputStream.close();
        }
    }
    
    byte[] ah(int n) {
        final long b = (0xFFL & (long)this.lK[95]) << 24 | (0xFFL & (long)this.lK[94]) << 16 | (0xFFL & (long)this.lK[93]) << 8 | (0xFFL & (long)this.lK[92]);
        final FileInputStream fileInputStream = new FileInputStream(new File(this.ma.lX, this.K()));
        try {
            n = (int)Math.min(n, b);
            final byte[] array = new byte[n];
            fileInputStream.skip(112L);
            hk.readFully(fileInputStream, array);
            return array;
        }
        finally {
            fileInputStream.close();
        }
    }
    
    void writeBytes(final byte[] b) {
        this.lK[92] = (byte)b.length;
        this.lK[93] = (byte)(b.length >> 8);
        this.lK[94] = (byte)(b.length >> 16);
        this.lK[95] = (byte)(b.length >> 24);
        final FileOutputStream fileOutputStream = new FileOutputStream(new File(this.ma.lX, this.K()));
        try {
            fileOutputStream.write(this.lK);
            fileOutputStream.write(b);
        }
        finally {
            fileOutputStream.close();
        }
        fileOutputStream.close();
    }
    
    void a(final String obj, final fn fn, final String value, final String value2) {
        final Properties properties = new Properties();
        properties.setProperty("StorageFile", this.mh.getName());
        properties.setProperty("LastModified", Long.toString(this.mh.lastModified()));
        if (fn != null) {
            properties.setProperty("GameMode", fn.name());
        }
        if (value != null) {
            properties.setProperty("SaveName", value);
        }
        if (value2 != null) {
            properties.setProperty("Description", value2);
        }
        final File file = new File(aH.cG, String.valueOf(obj) + "." + System.currentTimeMillis() + ".zip");
        final ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));
        try {
            final byte[] array = new byte[4096];
            out.putNextEntry(new ZipEntry(this.mh.getName()));
            final FileInputStream fileInputStream = new FileInputStream(this.mh);
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
            out.putNextEntry(new ZipEntry("saveinfo.txt"));
            properties.store(out, "");
        }
        finally {
            out.close();
        }
        out.close();
        file.setLastModified(this.mh.lastModified());
    }
    
    public String K() {
        return this.mh.getName();
    }
}
