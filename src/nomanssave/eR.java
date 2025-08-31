// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.util.function.Function;
import java.io.ByteArrayOutputStream;
import org.w3c.dom.Element;

public class eR extends ey
{
    final String kc;
    final eA kn;
    final /* synthetic */ eQ ko;
    
    eR(final eQ ko, final Element element) {
        this.ko = ko;
        super(element.getAttribute("id"));
        this.kc = (element.hasAttribute("icon") ? element.getAttribute("icon") : null);
        this.kn = ey.p(element.getAttribute("template"));
    }
    
    @Override
    public Object aZ() {
        return this.M(this.ko.jY ? ((int)Math.floor(Math.random() * 100000.0)) : 0);
    }
    
    @Override
    public Object M(final int n) {
        if (this.id.length() != 13 || this.id.charAt(0) != '^') {
            throw new RuntimeException("Cannot create ID: invalid string");
        }
        if (n < 0 || n >= 100000) {
            throw new RuntimeException("Cannot create ID: invalid proc");
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(94);
        for (int i = 0; i < 6; ++i) {
            int index = "0123456789ABCDEFabcdef".indexOf(this.id.charAt(i * 2 + 1));
            int index2 = "0123456789ABCDEFabcdef".indexOf(this.id.charAt(i * 2 + 2));
            if (index < 0 || index2 < 0) {
                throw new RuntimeException("Cannot create ID: invalid hex");
            }
            if (index >= 16) {
                index -= 6;
            }
            if (index2 >= 16) {
                index2 -= 6;
            }
            byteArrayOutputStream.write(index << 4 | index2);
        }
        byteArrayOutputStream.write(35);
        for (int j = 100000; j > 1; j /= 10) {
            byteArrayOutputStream.write("0123456789ABCDEFabcdef".charAt(n * 10 / j % 10));
        }
        return new fg(byteArrayOutputStream.toByteArray());
    }
    
    @Override
    public eB ba() {
        return eB.jO;
    }
    
    @Override
    public boolean bb() {
        return this.ko.jY;
    }
    
    private String y(final String s) {
        if ("NAME".equals(s)) {
            return this.ko.name;
        }
        if ("TECH_DESC".equals(s)) {
            return this.ko.description;
        }
        return s;
    }
    
    @Override
    public String getName() {
        return this.kn.a(this::y);
    }
    
    @Override
    public ex bc() {
        return ex.jd;
    }
    
    @Override
    public boolean bd() {
        return false;
    }
    
    @Override
    public boolean be() {
        return false;
    }
    
    @Override
    public Integer bf() {
        return null;
    }
    
    @Override
    public String bg() {
        return this.kn.b(this::y);
    }
    
    @Override
    public boolean bh() {
        return false;
    }
    
    @Override
    public String bi() {
        return this.kc;
    }
    
    @Override
    public int bj() {
        return 0;
    }
    
    @Override
    public String getDescription() {
        return this.kn.c(this::y);
    }
    
    @Override
    public List bk() {
        return this.ko.ke;
    }
    
    @Override
    public String toString() {
        return (this.ko.name.length() == 0) ? this.id : this.ko.name;
    }
}
