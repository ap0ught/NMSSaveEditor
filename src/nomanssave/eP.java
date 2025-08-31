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

public class eP extends ey
{
    final String name;
    final ex jZ;
    final boolean special;
    final Integer ka;
    final String jM;
    final boolean kb;
    final String kc;
    final int kd;
    final String description;
    final List ke;
    
    eP(Element element) {
        super(element.getAttribute("id"));
        this.name = element.getAttribute("name");
        this.jZ = ex.valueOf(element.getAttribute("category"));
        this.special = (element.hasAttribute("special") && Boolean.valueOf(element.getAttribute("special")));
        this.ka = (element.hasAttribute("chargeable") ? new Integer(element.getAttribute("chargeable")) : null);
        this.jM = element.getAttribute("subtitle");
        this.kb = (element.hasAttribute("cooking") && Boolean.valueOf(element.getAttribute("cooking")));
        this.kc = (element.hasAttribute("icon") ? element.getAttribute("icon") : null);
        if (element.hasAttribute("multiplier")) {
            this.kd = Integer.parseInt(element.getAttribute("multiplier"));
        }
        else {
            this.kd = 0;
        }
        String a = null;
        final NodeList childNodes = element.getChildNodes();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item instanceof Element) {
                element = (Element)item;
                if (element.getNodeName().equals("description")) {
                    a = ey.a(element);
                }
                else if (element.getNodeName().equals("requirement")) {
                    list.add(new ez(this, element));
                }
            }
        }
        this.description = a;
        this.ke = Collections.unmodifiableList((List<?>)list);
    }
    
    @Override
    public eB ba() {
        return eB.jP;
    }
    
    @Override
    public boolean bb() {
        return false;
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
        return this.jZ != ex.ja && this.jZ != ex.iZ;
    }
    
    @Override
    public boolean be() {
        return this.special;
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
        return this.kb;
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
    
    @Override
    public String toString() {
        return (this.name.length() == 0) ? this.id : this.name;
    }
}
