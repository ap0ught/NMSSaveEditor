// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.util.Collections;
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
import java.util.HashMap;

public class eS
{
    final String id;
    final String text;
    private final HashMap kp;
    private static final List kq;
    
    static {
        kq = new ArrayList();
        final InputStream resourceAsStream = Application.class.getResourceAsStream("db/words.xml");
        if (resourceAsStream != null) {
            try {
                final NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream).getDocumentElement().getChildNodes();
                for (int i = 0; i < childNodes.getLength(); ++i) {
                    final Node item = childNodes.item(i);
                    if (item instanceof Element && item.getNodeName().equals("word")) {
                        eS.kq.add(new eS((Element)item));
                    }
                }
            }
            catch (final ParserConfigurationException ex) {}
            catch (final SAXException ex2) {}
            catch (final IOException ex3) {}
        }
        eS.kq.sort(new eT());
    }
    
    private eS(final Element element) {
        this.id = element.getAttribute("id");
        this.text = element.getAttribute("text");
        this.kp = new HashMap();
        final NodeList elementsByTagName = element.getElementsByTagName("group");
        for (int i = 0; i < elementsByTagName.getLength(); ++i) {
            final Element element2 = (Element)elementsByTagName.item(i);
            final String attribute = element2.getAttribute("group");
            final eU c = eU.C(element2.getAttribute("race"));
            if (c != null) {
                this.kp.put(attribute, c);
            }
        }
    }
    
    public String getID() {
        return this.id;
    }
    
    public String getText() {
        return this.text;
    }
    
    public Iterable bw() {
        return Collections.unmodifiableSet(this.kp.keySet());
    }
    
    public eU z(final String key) {
        return this.kp.get(key);
    }
    
    public boolean a(final eU value) {
        return this.kp.containsValue(value);
    }
    
    public static eS A(final String anObject) {
        for (final eS es : eS.kq) {
            if (es.id.equals(anObject)) {
                return es;
            }
        }
        return null;
    }
    
    public static eS B(final String key) {
        for (final eS es : eS.kq) {
            if (es.kp.containsKey(key)) {
                return es;
            }
        }
        return null;
    }
    
    public static int bx() {
        return eS.kq.size();
    }
    
    public static eS T(final int n) {
        return eS.kq.get(n);
    }
    
    public static Iterable by() {
        return Collections.unmodifiableList((List<?>)eS.kq);
    }
}
