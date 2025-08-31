// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import javax.crypto.CipherInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.OutputStream;
import javax.crypto.CipherOutputStream;
import java.io.FileOutputStream;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;
import java.util.Collections;
import java.io.File;

public class gS
{
    private static byte[] lA;
    private static byte[] rS;
    
    static {
        gS.lA = new byte[] { 78, 77, 83, 66 };
        gS.rS = new byte[] { 50, -99, -78, -55, 92, 88, -34, 74, -57, 17, 57, -108, -94, 127, 97, -79 };
    }
    
    private static double[] a(final eY ey, final String str) {
        final eV d = ey.d(str);
        if (d.size() != 3) {
            throw new RuntimeException("Invalid " + str + " coordinates");
        }
        return new double[] { d.aa(0), d.aa(1), d.aa(2) };
    }
    
    private static void a(final eY ey, final String s, final double[] array) {
        ey.b(s, new eV(new Object[] { new Double(Double.isNaN(array[0]) ? 0.0 : array[0]), new Double(Double.isNaN(array[1]) ? 0.0 : array[1]), new Double(Double.isNaN(array[2]) ? 0.0 : array[2]) }));
    }
    
    public static void d(final eY ey, final File file) {
        a(ey, Collections.emptyMap(), file);
    }
    
    public static void a(final eY ey, final Map map, final File file) {
        final int j = ey.J("BaseVersion");
        final eV ba = ey.d("Objects").bA();
        if (j < 3) {
            final gT gt = new gT(a(ey, "Position"), a(ey, "Forward"));
            for (int i = 0; i < ba.size(); ++i) {
                final eY v = ba.V(i);
                final double[] a = a(v, "Position");
                final double[] a2 = a(v, "Up");
                final double[] a3 = a(v, "At");
                a(v, "Position", gt.d(a));
                a(v, "Up", gt.d(a2));
                a(v, "At", gt.d(a3));
            }
        }
        final int k = ey.J("UserData");
        final SecretKeySpec key = new SecretKeySpec(gS.rS, "AES");
        final byte[] b = new byte[16];
        new SecureRandom().nextBytes(b);
        final IvParameterSpec params = new IvParameterSpec(b);
        final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, key, params);
        OutputStream os = new FileOutputStream(file);
        try {
            os.write(gS.lA);
            os.write(new byte[] { 0, 5, 0, 0 });
            os.write(b);
            os = new CipherOutputStream(os, instance);
            os.write(new byte[] { 84, 82, 85, 69 });
            hk.a(os, k);
            final byte[] b2 = fj.b(ba);
            hk.a(os, b2.length);
            os.write(b2);
            for (final Map.Entry<String, V> entry : map.entrySet()) {
                final byte[] bytes = entry.getKey().getBytes();
                if (bytes.length > 255) {
                    continue;
                }
                os.write(bytes.length);
                os.write(bytes);
                final byte[] l = fj.j(entry.getValue());
                hk.a(os, l.length);
                os.write(l);
            }
            os.flush();
        }
        finally {
            os.close();
        }
        os.close();
    }
    
    public static void e(final eY ey, final File file) {
        b(ey, Collections.emptyMap(), file);
    }
    
    public static void b(final eY ey, final Map map, final File file) {
        InputStream is = new FileInputStream(file);
        int n;
        eV ev = null;
        try {
            final byte[] array = new byte[8];
            if (is.read(array) != 8) {
                throw new IOException("short read");
            }
            if (array[0] != gS.lA[0] || array[1] != gS.lA[1] || array[2] != gS.lA[2] || array[3] != gS.lA[3]) {
                throw new IOException("invalid base file");
            }
            n = ((array[4] & 0xFF) << 8 | (array[5] & 0xFF));
            switch (n) {
                case 2: {
                    throw new IOException("unsupported base file");
                }
                case 3:
                case 4:
                case 5: {
                    final byte[] array2 = new byte[16];
                    if (is.read(array2) != 16) {
                        throw new IOException("short read");
                    }
                    final SecretKeySpec key = new SecretKeySpec(gS.rS, "AES");
                    final IvParameterSpec params = new IvParameterSpec(array2);
                    final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    instance.init(2, key, params);
                    is = new CipherInputStream(is, instance);
                    if (is.read(array, 0, 4) != 4) {
                        throw new IOException("short read");
                    }
                    if (array[0] != 84 || array[1] != 82 || array[2] != 85 || array[3] != 69) {
                        throw new IOException("invalid base file");
                    }
                    if (n >= 5) {
                        ey.b("UserData", hk.readInt(is));
                        final byte[] array3 = new byte[hk.readInt(is)];
                        hk.readFully(is, array3);
                        ev = ff.c(array3);
                        int read;
                        while ((read = is.read()) >= 0) {
                            final byte[] bytes = new byte[read];
                            hk.readFully(is, bytes);
                            final String s = new String(bytes);
                            final byte[] array4 = new byte[hk.readInt(is)];
                            hk.readFully(is, array4);
                            map.put(s, ff.a(array4));
                        }
                        break;
                    }
                    final int read2;
                    if ((read2 = is.read()) < 0) {
                        throw new IOException("short read");
                    }
                    final int read3;
                    if ((read3 = is.read()) < 0) {
                        throw new IOException("short read");
                    }
                    final int read4;
                    if ((read4 = is.read()) < 0) {
                        throw new IOException("short read");
                    }
                    final int read5;
                    if ((read5 = is.read()) < 0) {
                        throw new IOException("short read");
                    }
                    ey.b("UserData", read2 << 24 | read3 << 16 | read4 << 8 | read5);
                    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    final byte[] array5 = new byte[8096];
                    int read6;
                    while ((read6 = is.read(array5)) >= 0) {
                        byteArrayOutputStream.write(array5, 0, read6);
                    }
                    ev = ff.c(byteArrayOutputStream.toByteArray());
                    break;
                }
                default: {
                    throw new IOException("invalid base file");
                }
            }
        }
        finally {
            is.close();
        }
        is.close();
        final long k = ey.K("LastUpdateTimestamp");
        for (int i = 0; i < ev.size(); ++i) {
            ev.V(i).put("Timestamp", new Long(k));
        }
        if (n == 3) {
            for (int j = 0; j < ev.size(); ++j) {
                final eY v = ev.V(j);
                final double[] a;
                final double[] array6 = a = a(v, "Position");
                final int n2 = 0;
                a[n2] += 3.0;
                final double[] array7 = array6;
                final int n3 = 2;
                array7[n3] += 3.0;
                a(array6);
                a(v, "Position", array6);
                final double[] a2 = a(v, "Up");
                a(a2);
                a(v, "Up", a2);
                final double[] a3 = a(v, "At");
                a(a3);
                a(v, "At", a3);
            }
            final int l = ey.J("UserData");
            ev.add(0, a("^BASE_FLAG", k, l, new double[] { 0.0, 0.0, 0.0 }, new double[] { 0.0, 1.0, 0.0 }, new double[] { 0.0, 0.0, 1.0 }));
            ev.add(1, a("^MAINROOM", k, l, new double[] { -3.0, 0.0, 3.0 }, new double[] { 0.0, 1.0, 0.0 }, new double[] { 0.0, 0.0, -1.0 }));
            ev.add(2, a("^TELEPORTER", k, l, new double[] { 0.0, 0.0, 6.0 }, new double[] { 0.0, 1.0, 0.0 }, new double[] { -0.7071069478988647, 0.0, -0.7071067094802856 }));
            ev.add(3, a("^BUILDDOOR", k, l, new double[] { -9.005859375, 0.2421875, 2.98828125 }, new double[] { 0.0, 1.0, 0.0 }, new double[] { -1.0, 0.0, 0.0 }));
            ev.add(4, a("^BUILDRAMP", k, l, new double[] { -10.724609375, 0.296875, 2.98828125 }, new double[] { -0.2588191032409668, 0.9659259915351868, 2.9802322387695312E-8 }, new double[] { -0.9659258127212524, -0.2588191628456116, -3.2782554626464844E-7 }));
            ev.add(5, a("^BUILDWINDOW", k, l, new double[] { -7.248046875, 0.5, -1.25 }, new double[] { 0.0, 1.0, 0.0 }, new double[] { -0.7071069478988647, 0.0, -0.7071067094802856 }));
            ev.add(6, a("^BUILDWINDOW", k, l, new double[] { -7.248046875, 0.5, 7.25 }, new double[] { 0.0, 1.0, 0.0 }, new double[] { -0.7071069478988647, 0.0, 0.7071067094802856 }));
            ev.add(7, a("^BUILDWINDOW", k, l, new double[] { 1.248046875, 0.5, -1.25 }, new double[] { 0.0, 1.0, 0.0 }, new double[] { 0.7071069478988647, 0.0, -0.7071067094802856 }));
        }
        if (n < 5) {
            ey.b("BaseVersion", 3);
        }
        ey.b("Objects", ev);
    }
    
    private static void a(final double[] array) {
        final double n = array[0];
        array[0] = -array[2];
        array[2] = n;
    }
    
    private static eY a(final String s, final long value, final int i, final double[] array, final double[] array2, final double[] array3) {
        final eY ey = new eY();
        ey.put("Timestamp", new Long(value));
        ey.put("ObjectID", s);
        ey.put("UserData", i);
        ey.put("Position", new eV(new Object[] { new Double(array[0]), new Double(array[1]), new Double(array[2]) }));
        ey.put("Up", new eV(new Object[] { new Double(array2[0]), new Double(array2[1]), new Double(array2[2]) }));
        ey.put("At", new eV(new Object[] { new Double(array3[0]), new Double(array3[1]), new Double(array3[2]) }));
        ey.put("Message", "");
        return ey;
    }
}
