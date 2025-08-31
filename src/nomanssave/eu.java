// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class eu
{
    private static List iH;
    
    static {
        eu.iH = new ArrayList();
        final InputStream resourceAsStream = Application.class.getResourceAsStream("db/inventory.xml");
        if (resourceAsStream != null) {
            try {
                final NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream).getDocumentElement().getChildNodes();
                for (int i = 0; i < childNodes.getLength(); ++i) {
                    final Node item = childNodes.item(i);
                    if (item instanceof Element && item.getNodeName().equals("difficulty")) {
                        eu.iH.add(new ev((Element)item));
                    }
                }
            }
            catch (final ParserConfigurationException ex) {}
            catch (final SAXException ex2) {}
            catch (final IOException ex3) {}
        }
    }
    
    public static ew b(final String anObject, final String anObject2) {
        for (final ev ev : eu.iH) {
            if (ev.id.equals(anObject)) {
                for (final ew ew : ev) {
                    if (ew.iI.equals(anObject2)) {
                        return ew;
                    }
                }
            }
        }
        return null;
    }
}
