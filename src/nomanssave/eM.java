// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.util.Comparator;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class eM
{
    final String id;
    final String name;
    final String description;
    final boolean iE;
    final boolean jY;
    private static final List kl;
    
    static {
        kl = new ArrayList();
        final InputStream resourceAsStream = Application.class.getResourceAsStream("db/settlements.xml");
        if (resourceAsStream != null) {
            try {
                final NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream).getDocumentElement().getChildNodes();
                for (int i = 0; i < childNodes.getLength(); ++i) {
                    final Node item = childNodes.item(i);
                    if (item instanceof Element && item.getNodeName().equals("perk")) {
                        eM.kl.add(new eM((Element)item));
                    }
                }
            }
            catch (final ParserConfigurationException ex) {}
            catch (final SAXException ex2) {}
            catch (final IOException ex3) {}
        }
        eM.kl.sort(new eN());
    }
    
    private eM(final Element element) {
        this.id = element.getAttribute("id");
        this.name = element.getAttribute("name");
        this.description = element.getAttribute("description");
        this.iE = Boolean.parseBoolean(element.getAttribute("beneficial"));
        this.jY = Boolean.parseBoolean(element.getAttribute("procedural"));
    }
    
    public String getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public boolean aW() {
        return this.iE;
    }
    
    public boolean bb() {
        return this.jY;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof String)) {
            return super.equals(obj);
        }
        if (this.jY) {
            return ((String)obj).startsWith(String.valueOf(this.id) + "#");
        }
        return ((String)obj).equals(this.id);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public static int getCount() {
        return eM.kl.size();
    }
    
    public static eM S(final int n) {
        return eM.kl.get(n);
    }
    
    public static int w(final String s) {
        return eM.kl.indexOf(new eO(s));
    }
    
    public static eM x(final String s) {
        final int index = eM.kl.indexOf(new eO(s));
        if (index >= 0) {
            return (eM)eM.kl.get(index);
        }
        return null;
    }
}
