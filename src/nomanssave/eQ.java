// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Collections;
import java.util.ArrayList;
import org.w3c.dom.Element;
import java.util.List;

public class eQ extends ey
{
    private static final String gc = "0123456789ABCDEFabcdef";
    final boolean jY;
    final String name;
    final ex jZ;
    final boolean special;
    final Integer ka;
    final String jM;
    final String kc;
    final int kd;
    final String description;
    final List ke;
    final eR km;
    
    eQ(final Element element, final boolean jy) {
        super(element.getAttribute("id"));
        this.jY = jy;
        this.name = element.getAttribute("name");
        try {
            if (jy) {
                this.jZ = ex.valueOf("PROC_" + element.getAttribute("category"));
            }
            else {
                this.jZ = ex.valueOf(element.getAttribute("category"));
            }
        }
        catch (final IllegalArgumentException cause) {
            throw new RuntimeException("Error in tech: " + this.id, cause);
        }
        this.special = (element.hasAttribute("special") && Boolean.valueOf(element.getAttribute("special")));
        this.ka = (element.hasAttribute("chargeable") ? new Integer(element.getAttribute("chargeable")) : null);
        this.jM = element.getAttribute("subtitle");
        this.kc = (element.hasAttribute("icon") ? element.getAttribute("icon") : null);
        if (element.hasAttribute("multiplier")) {
            this.kd = Integer.parseInt(element.getAttribute("multiplier"));
        }
        else {
            this.kd = 0;
        }
        String a = null;
        final ArrayList list = new ArrayList();
        eR km = null;
        final NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item instanceof Element) {
                final Element element2 = (Element)item;
                if (element2.getNodeName().equals("description")) {
                    a = ey.a(element2);
                }
                else if (element2.getNodeName().equals("requirement")) {
                    list.add(new ez(this, element2));
                }
                else if (element2.getNodeName().equals("techbox")) {
                    km = new eR(this, element2);
                }
            }
        }
        this.description = a;
        this.ke = Collections.unmodifiableList((List<?>)list);
        this.km = km;
    }
    
    @Override
    public eB ba() {
        return eB.jN;
    }
    
    @Override
    public boolean bb() {
        return this.jY;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public ex bc() {
        return this.jZ;
    }
    
    @Override
    public boolean bd() {
        return !this.jY && this.jZ != ex.ja && this.jZ != ex.iZ;
    }
    
    @Override
    public boolean be() {
        return !this.jY && this.special;
    }
    
    @Override
    public Integer bf() {
        return this.ka;
    }
    
    @Override
    public String bg() {
        return this.jM;
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
        return this.kd;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public List bk() {
        return this.ke;
    }
    
    public eR bv() {
        return this.km;
    }
    
    @Override
    public String toString() {
        return (this.name.length() == 0) ? this.id : this.name;
    }
}
