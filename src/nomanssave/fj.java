// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Closeable;

public class fj implements Closeable
{
    public static final int kP = 2;
    public static final int kQ = 8;
    private static final byte[] le;
    private static final byte[] lf;
    private static final byte[] lg;
    private final OutputStream lh;
    private final int flags;
    
    static {
        le = "null".getBytes();
        lf = "true".getBytes();
        lg = "false".getBytes();
    }
    
    public static byte[] j(final Object o) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable t = null;
        try {
            final fj fj = new fj(byteArrayOutputStream, 0);
            try {
                fj.k(o);
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
    
    public static byte[] g(final eY ey) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable t = null;
        try {
            final fj fj = new fj(byteArrayOutputStream, 0);
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
    
    public static byte[] b(final eV ev) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable t = null;
        try {
            final fj fj = new fj(byteArrayOutputStream, 0);
            try {
                fj.c(ev);
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
    
    public fj(final OutputStream outputStream) {
        this(outputStream, 0);
    }
    
    public fj(final OutputStream lh, final int flags) {
        this.lh = lh;
        this.flags = flags;
    }
    
    public void k(final Object o) {
        if (o == null) {
            this.lh.write(fj.le);
        }
        else if (o.equals(Boolean.TRUE)) {
            this.lh.write(fj.lf);
        }
        else if (o.equals(Boolean.FALSE)) {
            this.lh.write(fj.lg);
        }
        else if (o instanceof String) {
            this.writeString((String)o);
        }
        else if (o instanceof fg) {
            this.c((fg)o);
        }
        else if (o instanceof fk) {
            this.a((eY)o, ((fk)o).li);
        }
        else if (o instanceof eY) {
            this.a((eY)o, null);
        }
        else if (o instanceof eV) {
            this.a((eV)o, null);
        }
        else {
            if (!(o instanceof Number)) {
                throw new IOException("Cannot write value");
            }
            this.a((Number)o);
        }
    }
    
    private void a(final Object o, final eC ec) {
        if (o == null) {
            this.lh.write(fj.le);
        }
        else if (o.equals(Boolean.TRUE)) {
            this.lh.write(fj.lf);
        }
        else if (o.equals(Boolean.FALSE)) {
            this.lh.write(fj.lg);
        }
        else if (o instanceof String) {
            this.writeString((String)o);
        }
        else if (o instanceof fg) {
            this.c((fg)o);
        }
        else if (o instanceof eY) {
            this.a((eY)o, ec);
        }
        else if (o instanceof eV) {
            this.a((eV)o, ec);
        }
        else {
            if (!(o instanceof Number)) {
                throw new IOException("Cannot write value");
            }
            this.a((Number)o);
        }
    }
    
    private void writeString(final String s) {
        this.lh.write(fh.O(s).getBytes(StandardCharsets.UTF_8));
    }
    
    private void c(final fg fg) {
        this.lh.write(34);
        byte[] byteArray;
        for (int length = (byteArray = fg.toByteArray()).length, i = 0; i < length; ++i) {
            final int n = byteArray[i] & 0xFF;
            if (n == 13) {
                this.lh.write("\\r".getBytes(StandardCharsets.UTF_8));
            }
            else if (n == 10) {
                this.lh.write("\\n".getBytes(StandardCharsets.UTF_8));
            }
            else if (n == 9) {
                this.lh.write("\\t".getBytes(StandardCharsets.UTF_8));
            }
            else if (n == 12) {
                this.lh.write("\\f".getBytes(StandardCharsets.UTF_8));
            }
            else if (n == 8) {
                this.lh.write("\\b".getBytes(StandardCharsets.UTF_8));
            }
            else if (n == 34) {
                this.lh.write("\\\"".getBytes(StandardCharsets.UTF_8));
            }
            else if (n == 92) {
                this.lh.write("\\\\".getBytes(StandardCharsets.UTF_8));
            }
            else if (n >= 32) {
                this.lh.write(n);
            }
            else {
                final StringBuffer sb = new StringBuffer();
                sb.append("\\u00");
                sb.append("0123456789ABCDEFabcdef".charAt(n >> 4 & 0xF));
                sb.append("0123456789ABCDEFabcdef".charAt(n & 0xF));
                this.lh.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            }
        }
        this.lh.write(34);
    }
    
    public void h(final eY ey) {
        this.a(ey, (ey instanceof fk) ? ((fk)ey).li : null);
    }
    
    private void a(final eY ey, final eC ec) {
        this.lh.write(123);
        if (ey.length > 0) {
            for (int i = 0; i < ey.length; ++i) {
                if (i > 0) {
                    this.lh.write(44);
                }
                this.writeString((ec == null) ? ey.names[i] : ec.r(ey.names[i]));
                this.lh.write(58);
                this.a(ey.values[i], ec);
            }
        }
        this.lh.write(125);
    }
    
    public void c(final eV ev) {
        this.a(ev, null);
    }
    
    private void a(final eV ev, final eC ec) {
        this.lh.write(91);
        if (ev.length > 0) {
            for (int i = 0; i < ev.length; ++i) {
                if (i > 0) {
                    this.lh.write(44);
                }
                this.a(ev.values[i], ec);
            }
        }
        this.lh.write(93);
    }
    
    private void a(final Number n) {
        if (n instanceof BigDecimal) {
            this.lh.write(((BigDecimal)n).toString().replace('E', 'e').getBytes(StandardCharsets.UTF_8));
        }
        else {
            this.lh.write(n.toString().getBytes(StandardCharsets.UTF_8));
        }
    }
    
    @Override
    public void close() {
        try {
            if ((this.flags & 0x2) != 0x0) {
                this.lh.write(0);
            }
        }
        finally {
            if ((this.flags & 0x8) == 0x0) {
                this.lh.close();
            }
        }
        if ((this.flags & 0x8) == 0x0) {
            this.lh.close();
        }
    }
}
