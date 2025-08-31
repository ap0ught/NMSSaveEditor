// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.util.Date;
import java.io.IOException;
import java.io.InputStream;

class fW
{
    final String name;
    final String filename;
    final String id;
    int mT;
    final int lL;
    String mU;
    long timestamp;
    final long mV;
    long mW;
    final /* synthetic */ fT mN;
    
    fW(final fT mn, final InputStream inputStream) {
        this.mN = mn;
        this.name = gc.c(inputStream);
        hc.info("  " + this.name);
        this.filename = gc.c(inputStream);
        hc.debug("    filename: " + this.filename);
        this.id = gc.c(inputStream);
        hc.debug("    id: " + this.id);
        this.mT = inputStream.read();
        if (this.mT < 0) {
            throw new IOException("short read");
        }
        hc.debug("    suffix: " + this.mT);
        this.lL = hk.readInt(inputStream);
        if (this.lL != 0) {
            hc.debug("    unknown1: " + Integer.toHexString(this.lL));
        }
        this.mU = gc.a(inputStream);
        hc.debug("    containerPath: " + this.mU);
        this.timestamp = gc.b(inputStream);
        hc.debug("    timestamp: " + new Date(this.timestamp));
        this.mV = hk.f(inputStream);
        if (this.mV != 0L) {
            hc.debug("    unknown2: " + Long.toHexString(this.mV));
        }
        this.mW = hk.f(inputStream);
        hc.debug("    totalSize: " + this.mW);
    }
    
    fW(final fT ft, final String s) {
        this(ft, new ByteArrayInputStream(hk.aD(s)));
    }
    
    fW(final fT mn, final fW fw) {
        this.mN = mn;
        this.name = fw.name;
        this.filename = fw.filename;
        this.id = fw.id;
        this.mT = fw.mT;
        this.lL = fw.lL;
        this.mU = mn.ct();
        this.timestamp = fw.timestamp;
        this.mV = fw.mV;
        this.mW = fw.mW;
    }
    
    void write(final OutputStream outputStream) {
        gc.b(outputStream, this.name);
        gc.b(outputStream, this.filename);
        gc.b(outputStream, this.id);
        outputStream.write(this.mT);
        hk.a(outputStream, this.lL);
        gc.a(outputStream, this.mU);
        gc.a(outputStream, this.timestamp);
        hk.b(outputStream, this.mV);
        hk.b(outputStream, this.mW);
    }
    
    String cz() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.write(byteArrayOutputStream);
        return hk.k(byteArrayOutputStream.toByteArray());
    }
}
