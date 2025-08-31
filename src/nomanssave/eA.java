// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.util.function.Function;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

class eA
{
    final String id;
    final String name;
    final String jM;
    final String description;
    
    eA(Element element) {
        this.id = element.getAttribute("id");
        this.name = element.getAttribute("name");
        this.jM = element.getAttribute("subtitle");
        String a = null;
        final NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item instanceof Element) {
                element = (Element)item;
                if (element.getNodeName().equals("description")) {
                    a = ey.a(element);
                }
            }
        }
        this.description = a;
    }
    
    private String a(final String input, final Function function) {
        final StringBuilder sb = new StringBuilder();
        int end = 0;
        final Matcher matcher = ey.jH.matcher(input);
        while (matcher.find()) {
            sb.append(input.substring(end, matcher.start()));
            sb.append((String)function.apply(matcher.group(1)));
            end = matcher.end();
        }
        sb.append(input.substring(end));
        return sb.toString();
    }
    
    String a(final Function function) {
        return this.a(this.name, function);
    }
    
    String b(final Function function) {
        return this.a(this.jM, function);
    }
    
    String c(final Function function) {
        return (this.description == null) ? null : this.a(this.description, function);
    }
}
