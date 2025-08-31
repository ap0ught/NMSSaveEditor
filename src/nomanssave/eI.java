// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

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

public class eI
{
    public static final int kf = 0;
    public static final int kg = 1;
    public static final int kh = 2;
    final int type;
    final String id;
    final String name;
    private static final List ki;
    private static final List kj;
    private static final List kk;
    
    static {
        ki = new ArrayList();
        kj = new ArrayList();
        kk = new ArrayList();
        final InputStream resourceAsStream = Application.class.getResourceAsStream("db/rewards.xml");
        if (resourceAsStream != null) {
            try {
                final NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream).getDocumentElement().getChildNodes();
                for (int i = 0; i < childNodes.getLength(); ++i) {
                    final Node item = childNodes.item(i);
                    if (item instanceof Element && item.getNodeName().equals("season")) {
                        eI.ki.add(new eI((Element)item, 0));
                    }
                    if (item instanceof Element && item.getNodeName().equals("twitch")) {
                        eI.kj.add(new eI((Element)item, 1));
                    }
                    if (item instanceof Element && item.getNodeName().equals("platform")) {
                        eI.kk.add(new eI((Element)item, 2));
                    }
                }
            }
            catch (final ParserConfigurationException ex) {}
            catch (final SAXException ex2) {}
            catch (final IOException ex3) {}
        }
        eI.ki.sort(new eJ());
        eI.kj.sort(new eK());
        eI.kk.sort(new eL());
    }
    
    private eI(final Element element, final int type) {
        this.type = type;
        this.id = element.getAttribute("id");
        this.name = element.getAttribute("name");
    }
    
    public String getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static int bq() {
        return eI.ki.size();
    }
    
    public static eI P(final int n) {
        return eI.ki.get(n);
    }
    
    public static int br() {
        return eI.kj.size();
    }
    
    public static eI Q(final int n) {
        return eI.kj.get(n);
    }
    
    public static int bs() {
        return eI.kk.size();
    }
    
    public static eI R(final int n) {
        return eI.kk.get(n);
    }
    
    public static Iterable bt() {
        return Collections.unmodifiableList((List<?>)eI.ki);
    }
    
    public static Iterable bu() {
        return Collections.unmodifiableList((List<?>)eI.kj);
    }
}
