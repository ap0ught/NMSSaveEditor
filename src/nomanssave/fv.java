// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

class fv implements fr
{
    final fw lI;
    final /* synthetic */ fu lJ;
    
    fv(final fu lj, final fw li) {
        this.lJ = lj;
        this.lI = li;
    }
    
    @Override
    public String K() {
        return "accountdata";
    }
    
    @Override
    public eY M() {
        final byte[] ca = this.lI.ca();
        Throwable t = null;
        try {
            final ff ff = new ff(new ByteArrayInputStream(ca), 2);
            try {
                return ff.a(eG.jW);
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
    
    @Override
    public void k(final eY ey) {
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
        this.lI.d(byteArrayOutputStream.toByteArray());
    }
}
