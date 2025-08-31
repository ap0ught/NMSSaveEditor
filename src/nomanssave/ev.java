// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.util.ArrayList;

class ev extends ArrayList
{
    final String id;
    
    ev(final Element element) {
        this.id = element.getAttribute("id");
        final NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item instanceof Element && item.getNodeName().equals("stacksize")) {
                this.add(new ew((Element)item));
            }
        }
    }
}
