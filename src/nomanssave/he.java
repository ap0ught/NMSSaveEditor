// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.OutputStream;

class he extends OutputStream
{
    final PrintStream ss;
    final String st;
    final ByteArrayOutputStream su;
    
    he(final PrintStream ss, final String st) {
        this.ss = ss;
        this.st = st;
        this.su = new ByteArrayOutputStream();
    }
    
    @Override
    public void write(final int n) {
        this.ss.write(n);
        this.su.write(n);
        if (n == 10) {
            if (hc.sq != null) {
                synchronized (hc.sq) {
                    hc.sq.write(this.st.getBytes());
                    hc.sq.write(this.su.toByteArray());
                    monitorexit(hc.sq);
                }
            }
            this.su.reset();
        }
    }
    
    @Override
    public void write(final byte[] b, int off, int n) {
        if (this.ss != null) {
            this.ss.write(b, off, n);
        }
        for (int i = 0; i < n; ++i) {
            if (b[off + i] == 10) {
                this.su.write(b, off, i + 1);
                if (hc.sq != null) {
                    synchronized (hc.sq) {
                        hc.sq.write(this.st.getBytes());
                        hc.sq.write(this.su.toByteArray());
                        monitorexit(hc.sq);
                    }
                }
                this.su.reset();
                n -= i + 1;
                off = i + 1;
                i = -1;
            }
        }
        this.su.write(b, off, n);
    }
    
    @Override
    public void flush() {
        if (this.su.size() > 0) {
            this.su.write(System.lineSeparator().getBytes());
            if (hc.sq != null) {
                synchronized (hc.sq) {
                    hc.sq.write(this.st.getBytes());
                    hc.sq.write(this.su.toByteArray());
                    monitorexit(hc.sq);
                }
            }
            this.su.reset();
        }
    }
}
