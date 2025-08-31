// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import org.w3c.dom.Element;

public class ew
{
    final String iI;
    final int iJ;
    final int iK;
    
    ew(final Element element) {
        this.iI = element.getAttribute("group");
        this.iJ = Integer.parseInt(element.getAttribute("substance"));
        this.iK = Integer.parseInt(element.getAttribute("product"));
    }
    
    public int aX() {
        return this.iJ;
    }
    
    public int aY() {
        return this.iK;
    }
}
