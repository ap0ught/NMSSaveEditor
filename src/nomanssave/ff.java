// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.nio.charset.CharacterCodingException;
import java.nio.ByteBuffer;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.function.Predicate;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.io.ByteArrayInputStream;
import java.nio.charset.CharsetDecoder;
import java.io.InputStream;
import java.io.Closeable;

public class ff implements Closeable
{
    public static final int kO = 1;
    public static final int kP = 2;
    public static final int kQ = 4;
    private final InputStream in;
    private final int flags;
    private int kR;
    private final CharsetDecoder kS;
    
    public static Object a(final byte[] buf) {
        Throwable t = null;
        try {
            final ff ff = new ff(new ByteArrayInputStream(buf), 0);
            try {
                return ff.bJ();
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
    
    public static eY b(final byte[] buf) {
        Throwable t = null;
        try {
            final ff ff = new ff(new ByteArrayInputStream(buf), 0);
            try {
                return ff.bK();
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
    
    public static eV c(final byte[] buf) {
        Throwable t = null;
        try {
            final ff ff = new ff(new ByteArrayInputStream(buf), 0);
            try {
                return ff.bL();
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
    
    public ff(final InputStream inputStream) {
        this(inputStream, 0);
    }
    
    public ff(final InputStream in, final int flags) {
        this.in = in;
        this.flags = flags;
        this.kR = -1;
        this.kS = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }
    
    private int read() {
        if (this.kR >= 0) {
            final int kr = this.kR;
            this.kR = -1;
            return kr;
        }
        return this.in.read();
    }
    
    private int a(final Predicate predicate) {
        if (this.kR < 0) {
            this.kR = this.in.read();
        }
        if (this.kR >= 0 && predicate.test(this.kR)) {
            final int kr = this.kR;
            this.kR = -1;
            return kr;
        }
        return -1;
    }
    
    private int bI() {
        if ((this.flags & 0x1) != 0x0) {
            return this.read();
        }
        if (this.kR < 0) {
            this.kR = this.in.read();
        }
        while (this.kR == 32 || this.kR == 13 || this.kR == 10 || this.kR == 9) {
            this.kR = this.in.read();
        }
        if (this.kR >= 0) {
            final int kr = this.kR;
            this.kR = -1;
            return kr;
        }
        return -1;
    }
    
    @Override
    public void close() {
        try {
            if (this.kR < 0) {
                this.kR = this.in.read();
            }
            if ((this.flags & 0x1) == 0x0) {
                while (this.kR == 32 || this.kR == 13 || this.kR == 10 || this.kR == 9) {
                    this.kR = this.in.read();
                }
            }
            if ((this.flags & 0x2) != 0x0) {
                if (this.kR != 0) {
                    throw new eX("Missing null terminator");
                }
                this.kR = -1;
            }
            if (this.kR >= 0) {
                throw new eX("Unexpected termination: " + this.kR);
            }
        }
        finally {
            if ((this.flags & 0x4) == 0x0) {
                this.in.close();
            }
        }
        if ((this.flags & 0x4) == 0x0) {
            this.in.close();
        }
    }
    
    public Object bJ() {
        return this.a(this.bI(), null);
    }
    
    public eY bK() {
        final int bi = this.bI();
        if (bi < 0) {
            throw new eX("Short read");
        }
        if (bi != 123) {
            throw new eX("Unexpected token");
        }
        return this.a((eC)null);
    }
    
    public eY a(final eG eg) {
        final int bi = this.bI();
        if (bi < 0) {
            throw new eX("Short read");
        }
        if (bi != 123) {
            throw new eX("Unexpected token");
        }
        eY ey = null;
        eC a = null;
        final int bi2 = this.bI();
        Label_0226: {
            if (bi2 == 34) {
                do {
                    String s = this.bN();
                    if (ey == null) {
                        if (eg != null && (a = eC.a(eg, s)) != null) {
                            ey = new fk(a);
                        }
                        else {
                            ey = new eY();
                        }
                    }
                    if (a != null) {
                        s = a.q(s);
                    }
                    if (this.bI() != 58) {
                        throw new eX("Invalid token");
                    }
                    ey.a(s, this.a(this.bI(), a));
                    final int bi3 = this.bI();
                    if (bi3 == 125) {
                        break Label_0226;
                    }
                    if (bi3 != 44) {
                        throw new eX("Invalid token");
                    }
                } while (this.bI() == 34);
                throw new eX("Invalid token");
            }
            if (bi2 != 125) {
                throw new eX("Invalid token");
            }
        }
        if (ey == null) {
            ey = new eY();
        }
        if (ey.H("PlayerStateData") == null) {
            ey.b("PlayerStateData", ey2 -> {
                ey2.getValueAsString("ActiveContext");
                final String s2;
                if ("Main".equals(s2) && ey2.H("BaseContext.PlayerStateData") != null) {
                    return "BaseContext.PlayerStateData";
                }
                else if ("Season".equals(s2) && ey2.H("ExpeditionContext.PlayerStateData") != null) {
                    return "ExpeditionContext.PlayerStateData";
                }
                else {
                    return "PlayerStateData";
                }
            });
        }
        return ey;
    }
    
    public eV bL() {
        final int bi = this.bI();
        if (bi < 0) {
            throw new eX("Short read");
        }
        if (bi != 91) {
            throw new eX("Unexpected token");
        }
        return this.b((eC)null);
    }
    
    private Object a(final int n, final eC ec) {
        if (n < 0) {
            throw new eX("Short read");
        }
        if (n == 123) {
            return this.a(ec);
        }
        if (n == 91) {
            return this.b(ec);
        }
        if (n == 34) {
            return this.bO();
        }
        if (n == 116) {
            if (this.read() != 114) {
                throw new eX("Invalid token");
            }
            if (this.read() != 117) {
                throw new eX("Invalid token");
            }
            if (this.read() != 101) {
                throw new eX("Invalid token");
            }
            return Boolean.TRUE;
        }
        else if (n == 102) {
            if (this.read() != 97) {
                throw new eX("Invalid token");
            }
            if (this.read() != 108) {
                throw new eX("Invalid token");
            }
            if (this.read() != 115) {
                throw new eX("Invalid token");
            }
            if (this.read() != 101) {
                throw new eX("Invalid token");
            }
            return Boolean.FALSE;
        }
        else if (n == 110) {
            if (this.read() != 117) {
                throw new eX("Invalid token");
            }
            if (this.read() != 108) {
                throw new eX("Invalid token");
            }
            if (this.read() != 108) {
                throw new eX("Invalid token");
            }
            return null;
        }
        else {
            if (n == 45 || (n >= 48 && n <= 57)) {
                return this.ad(n);
            }
            throw new eX("Invalid token");
        }
    }
    
    private Number ad(int n) {
        boolean b = false;
        if (n == 45) {
            n = this.a(fh.kZ);
            if (n < 0) {
                throw new eX("Invalid token");
            }
            b = true;
        }
        BigDecimal bigDecimal = new BigDecimal(n - 48);
        if (n != 48) {
            while ((n = this.a(fh.kZ)) >= 0) {
                bigDecimal = bigDecimal.multiply(BigDecimal.TEN).add(new BigDecimal(n - 48));
            }
        }
        boolean b2 = true;
        if (this.a(fh.la) >= 0) {
            b2 = false;
            n = this.a(fh.kZ);
            if (n < 0) {
                throw new eX("Invalid token");
            }
            int n2 = 0;
            do {
                bigDecimal = bigDecimal.add(new BigDecimal(n - 48).scaleByPowerOfTen(--n2));
            } while ((n = this.a(fh.kZ)) >= 0);
        }
        if (this.a(fh.lb) >= 0) {
            b2 = false;
            n = this.a(fh.lc);
            int n3 = 0;
            if (n == 43 || n == 45) {
                n3 = ((n == 45) ? 1 : 0);
                n = this.a(fh.kZ);
            }
            if (n < 0) {
                throw new eX("Invalid token");
            }
            int n4 = 0;
            do {
                n4 = n4 * 10 + (n - 48);
            } while ((n = this.a(fh.kZ)) >= 0);
            if (n3 != 0) {
                n4 = -n4;
            }
            bigDecimal = bigDecimal.scaleByPowerOfTen(n4);
        }
        if (b) {
            bigDecimal = bigDecimal.negate();
        }
        if (b2) {
            try {
                return bigDecimal.intValueExact();
            }
            catch (final ArithmeticException ex) {
                try {
                    return bigDecimal.longValueExact();
                }
                catch (final ArithmeticException ex2) {}
            }
        }
        return bigDecimal;
    }
    
    private eY a(final eC ec) {
        final eY ey = new eY();
        final int bi = this.bI();
        if (bi == 34) {
            do {
                String s = this.bN();
                if (ec != null) {
                    s = ec.q(s);
                }
                if (this.bI() != 58) {
                    throw new eX("Invalid token");
                }
                ey.a(s, this.a(this.bI(), ec));
                final int bi2 = this.bI();
                if (bi2 == 125) {
                    return ey;
                }
                if (bi2 != 44) {
                    throw new eX("Invalid token");
                }
            } while (this.bI() == 34);
            throw new eX("Invalid token");
        }
        if (bi != 125) {
            throw new eX("Invalid token");
        }
        return ey;
    }
    
    private eV b(final eC ec) {
        final eV ev = new eV();
        int n;
        if ((n = this.bI()) != 93) {
            while (true) {
                ev.e(this.a(n, ec));
                final int bi = this.bI();
                if (bi == 93) {
                    break;
                }
                if (bi != 44) {
                    throw new eX("Invalid token");
                }
                n = this.bI();
            }
        }
        return ev;
    }
    
    private byte[] bM() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n;
        while ((n = this.read()) != 34) {
            if (n < 0) {
                throw new eX("Short read");
            }
            if (n == 92) {
                n = this.read();
                if (n < 0) {
                    throw new eX("Short read");
                }
                switch (n) {
                    case 114: {
                        n = 13;
                        break;
                    }
                    case 110: {
                        n = 10;
                        break;
                    }
                    case 116: {
                        n = 9;
                        break;
                    }
                    case 102: {
                        n = 12;
                        break;
                    }
                    case 98: {
                        n = 8;
                        break;
                    }
                    case 117: {
                        n = (fh.ae(this.read()) << 12 | fh.ae(this.read()) << 8 | fh.ae(this.read()) << 4 | fh.ae(this.read()));
                        if (n > 255) {
                            throw new eX("Unexpected unicode escape: " + n);
                        }
                        break;
                    }
                }
            }
            byteArrayOutputStream.write(n);
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    private String bN() {
        final byte[] bm = this.bM();
        try {
            return this.kS.decode(ByteBuffer.wrap(bm)).toString();
        }
        catch (final CharacterCodingException ex) {
            throw new eX("Invalid string");
        }
    }
    
    private Object bO() {
        final byte[] bm = this.bM();
        try {
            return this.kS.decode(ByteBuffer.wrap(bm)).toString();
        }
        catch (final CharacterCodingException ex) {
            return new fg(bm);
        }
    }
}
