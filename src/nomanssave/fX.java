// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.Properties;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

abstract class fX
{
    final fW mO;
    final File mX;
    final File mY;
    final fS mZ;
    int mode;
    final /* synthetic */ fT mN;
    
    fX(final fT mn, final fV fv) {
        this.mN = mn;
        int size = mn.mI.size();
        for (int i = 0; i < mn.mI.size(); ++i) {
            final int compareTo = mn.mI.get(i).name.compareTo(fv.mO.name);
            if (compareTo == 0) {
                h(new File(mn.lX, ((fW)mn.mI.remove(i)).mU));
            }
            if (compareTo >= 0) {
                size = i;
                break;
            }
        }
        this.mO = new fW(mn, fv.mO);
        final File parent = new File(mn.lX, this.mO.mU);
        if (!parent.mkdir()) {
            throw new IOException("Unable to create container path");
        }
        this.mX = new File(parent, "container." + this.mO.mT);
        this.mZ = new fS(new File(parent, fv.mP));
        this.mY = new File(parent, fv.mR);
        final FileOutputStream fileOutputStream = new FileOutputStream(this.mX);
        try {
            fv.a(fileOutputStream);
        }
        finally {
            fileOutputStream.close();
        }
        fileOutputStream.close();
        mn.mI.add(size, this.mO);
    }
    
    fX(final fT mn, final String s) {
        this.mN = mn;
        this.mO = mn.Z(s);
        final File parent = new File(mn.lX, this.mO.mU);
        if (!parent.isDirectory()) {
            throw new FileNotFoundException(this.mO.mU);
        }
        this.mX = new File(parent, "container." + this.mO.mT);
        hc.info(this.mO.filename);
        File my = null;
        File file = null;
        final FileInputStream fileInputStream = new FileInputStream(this.mX);
        try {
            hc.debug("  header: " + Integer.toHexString(hk.readInt(fileInputStream)));
            for (int int1 = hk.readInt(fileInputStream), i = 0; i < int1; ++i) {
                final String d = gc.d(fileInputStream);
                hc.debug("  name: " + d);
                final String a = gc.a(fileInputStream);
                hc.debug("  filename: " + a);
                final String a2 = gc.a(fileInputStream);
                if (!a.equals(a2)) {
                    hc.debug("  filename2: " + a2);
                }
                if (d.equals("data")) {
                    my = new File(parent, a);
                    if (!my.exists()) {
                        my = new File(parent, a2);
                    }
                }
                if (d.equals("meta")) {
                    file = new File(parent, a);
                    if (!file.exists()) {
                        file = new File(parent, a2);
                    }
                }
            }
        }
        finally {
            fileInputStream.close();
        }
        fileInputStream.close();
        if (my == null || file == null) {
            throw new FileNotFoundException("data/meta file missing");
        }
        if (this.mO.mW != file.length() + my.length()) {
            throw new IOException("data size mismatch: " + this.mO.mW);
        }
        this.mY = my;
        (this.mZ = new fS(file)).cn();
    }
    
    public String K() {
        return this.mO.filename;
    }
    
    private InputStream getInputStream() {
        final InputStream b = a(new FileInputStream(this.mY), this.mZ.ch());
        if (b instanceof gX) {
            this.mode = fT.mM;
        }
        else if (b instanceof hm) {
            this.mode = fT.mL;
        }
        else {
            this.mode = fT.mK;
        }
        return b;
    }
    
    private OutputStream getOutputStream() {
        final FileOutputStream fileOutputStream = new FileOutputStream(this.mY);
        try {
            if (this.mode == fT.mM) {
                return new gZ(fileOutputStream);
            }
            if (this.mode == fT.mL) {
                fileOutputStream.write(fT.lA);
                return new ho(fileOutputStream);
            }
            return new hb(fileOutputStream);
        }
        catch (final IOException ex) {
            try {
                fileOutputStream.close();
            }
            catch (final IOException ex2) {}
            throw ex;
        }
    }
    
    eY a(final eG eg) {
        Throwable t = null;
        try {
            final ff ff = new ff(this.getInputStream(), 2);
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
    
    byte[] ah(final int n) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable t = null;
        try {
            final InputStream inputStream = this.getInputStream();
            try {
                final byte[] array = new byte[4096];
                int read;
                while ((read = inputStream.read(array)) >= 0) {
                    byteArrayOutputStream.write(array, 0, read);
                    if (byteArrayOutputStream.size() >= n) {
                        break;
                    }
                }
            }
            finally {
                if (inputStream != null) {
                    inputStream.close();
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
    
    void h(final eY ey) {
        final boolean b = this.mode == fT.mL;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable t = null;
        try {
            final fj fj = new fj(byteArrayOutputStream, b ? 0 : 2);
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
        this.mZ.aj(byteArray.length);
        Throwable t2 = null;
        try {
            final OutputStream outputStream = this.getOutputStream();
            try {
                outputStream.write(byteArray);
                if (b) {
                    outputStream.flush();
                    outputStream.write(0);
                }
            }
            finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
        finally {
            if (t2 == null) {
                final Throwable exception2;
                t2 = exception2;
            }
            else {
                final Throwable exception2;
                if (t2 != exception2) {
                    t2.addSuppressed(exception2);
                }
            }
        }
        this.mZ.ak((int)this.mY.length());
        this.mZ.write();
        this.mO.timestamp = System.currentTimeMillis();
        this.mO.mW = this.mY.length() + this.mZ.length();
        this.mN.cs();
    }
    
    void a(final String obj, final fn fn) {
        final Properties properties = new Properties();
        properties.setProperty("MetaFile", this.mZ.getName());
        properties.setProperty("DataFile", this.mY.getName());
        properties.setProperty("ContainerFile", this.mX.getName());
        if (fn != null) {
            properties.setProperty("GameMode", fn.name());
        }
        properties.setProperty("IndexData", this.mO.cz());
        final File file = new File(aH.cG, String.valueOf(obj) + "." + System.currentTimeMillis() + ".zip");
        final ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));
        try {
            out.putNextEntry(new ZipEntry(this.mZ.getName()));
            out.write(this.mZ.co());
            out.putNextEntry(new ZipEntry(this.mY.getName()));
            final byte[] array = new byte[1024];
            final FileInputStream fileInputStream = new FileInputStream(this.mY);
            try {
                int read;
                while ((read = fileInputStream.read(array)) > 0) {
                    out.write(array, 0, read);
                }
            }
            finally {
                fileInputStream.close();
            }
            fileInputStream.close();
            out.putNextEntry(new ZipEntry(this.mX.getName()));
            final FileInputStream fileInputStream2 = new FileInputStream(this.mX);
            try {
                int read2;
                while ((read2 = fileInputStream2.read(array)) > 0) {
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
        file.setLastModified(this.mO.timestamp);
    }
}
