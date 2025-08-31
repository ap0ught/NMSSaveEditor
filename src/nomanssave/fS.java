// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;

public class fS
{
    private final File mh;
    private int lL;
    private int version;
    private long my;
    private int mz;
    private int mA;
    private byte[] mB;
    private String name;
    private String description;
    private int lM;
    
    fS(final File mh) {
        this.mh = mh;
    }
    
    void cn() {
        Throwable t = null;
        try {
            final FileInputStream fileInputStream = new FileInputStream(this.mh);
            try {
                this.read(fileInputStream);
            }
            finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
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
    
    void read(final InputStream inputStream) {
        this.lL = hk.readInt(inputStream);
        if (this.lL != 0) {
            hc.debug("  unknown1: " + Integer.toHexString(this.lL));
        }
        this.version = hk.readInt(inputStream);
        if (this.version != 0) {
            hc.info("  version: " + this.version);
        }
        this.my = hk.f(inputStream);
        if (this.my != 0L) {
            hc.info("  totalPlayTime: " + fq.c(this.my));
        }
        if (this.lL == 1) {
            this.mz = hk.readInt(inputStream);
            if (this.mz != 0) {
                hc.debug("  decompressed: " + this.mz);
            }
            this.mA = 0;
            hk.readFully(inputStream, this.mB = new byte[128]);
        }
        else {
            this.mz = 0;
            this.mA = hk.readInt(inputStream);
            if (this.mA != 0) {
                hc.debug("  compressed: " + this.mA);
            }
            this.mB = null;
            this.name = gc.e(inputStream);
            if (this.name.length() != 0) {
                hc.debug("  name: " + this.name);
            }
            this.description = gc.e(inputStream);
            if (this.description.length() != 0) {
                hc.debug("  description: " + this.description);
            }
        }
        this.lM = hk.readInt(inputStream);
        if (this.lM != 0) {
            hc.debug("  unknown2: " + Integer.toHexString(this.lM));
        }
    }
    
    void write() {
        Throwable t = null;
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(this.mh);
            try {
                this.write(fileOutputStream);
            }
            finally {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
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
    
    void write(final OutputStream outputStream) {
        hk.a(outputStream, this.lL);
        hk.a(outputStream, this.version);
        hk.b(outputStream, this.my);
        if (this.mB != null) {
            hk.a(outputStream, this.mz);
            outputStream.write(this.mB);
        }
        else {
            hk.a(outputStream, this.mA);
            gc.c(outputStream, this.name);
            gc.c(outputStream, this.description);
        }
        hk.a(outputStream, this.lM);
    }
    
    byte[] co() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.write(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    
    boolean cp() {
        return this.mB == null;
    }
    
    int getVersion() {
        return this.version;
    }
    
    void setVersion(final int version) {
        this.version = version;
    }
    
    int ch() {
        return this.mz;
    }
    
    void aj(final int mz) {
        if (this.mB != null) {
            this.mz = mz;
        }
    }
    
    int ci() {
        return this.mA;
    }
    
    void ak(final int ma) {
        if (this.mB == null) {
            this.mA = ma;
        }
    }
    
    String ck() {
        return this.name;
    }
    
    void Y(final String name) {
        this.name = name;
    }
    
    String getDescription() {
        return this.description;
    }
    
    long cq() {
        return this.my;
    }
    
    void d(final long my) {
        this.my = my;
    }
    
    String getName() {
        return this.mh.getName();
    }
    
    long length() {
        return this.mh.length();
    }
    
    void a(final fS fs) {
        this.lL = fs.lL;
        this.version = fs.version;
        this.my = fs.my;
        this.mA = fs.mA;
        this.mz = fs.mz;
        this.mB = fs.mB;
        this.name = fs.name;
        this.description = fs.description;
        this.lM = fs.lM;
    }
}
