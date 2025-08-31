// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Arrays;
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

public class er
{
    final String id;
    final String name;
    final gq iB;
    final int iC;
    final gr iD;
    final boolean iE;
    final gr[] iF;
    private static final List iG;
    
    static {
        iG = new ArrayList();
        final InputStream resourceAsStream = Application.class.getResourceAsStream("db/frigates.xml");
        if (resourceAsStream != null) {
            try {
                final NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream).getDocumentElement().getChildNodes();
                for (int i = 0; i < childNodes.getLength(); ++i) {
                    final Node item = childNodes.item(i);
                    if (item instanceof Element && item.getNodeName().equals("trait")) {
                        er.iG.add(new er((Element)item));
                    }
                }
            }
            catch (final ParserConfigurationException ex) {}
            catch (final SAXException ex2) {}
            catch (final IOException ex3) {}
        }
        er.iG.sort(new es());
    }
    
    private er(final Element element) {
        this.id = element.getAttribute("id");
        this.name = element.getAttribute("name");
        final String attribute = element.getAttribute("type");
        this.iB = ((attribute == null) ? null : gq.valueOf(attribute));
        this.iC = Integer.parseInt(element.getAttribute("strength"));
        final String attribute2 = element.getAttribute("primary");
        this.iD = ((attribute2 == null) ? null : gr.an(attribute2));
        this.iE = Boolean.parseBoolean(element.getAttribute("beneficial"));
        this.iF = n(element.getAttribute("secondary"));
    }
    
    private static gr[] n(final String s) {
        final ArrayList list = new ArrayList();
        int i = 0;
        while (i < s.length()) {
            final int index = s.indexOf(",", i);
            gr e;
            if (index >= 0) {
                e = gr.an(s.substring(i, index));
                i = index + 1;
            }
            else {
                e = gr.an(s.substring(i));
                i = s.length();
            }
            if (e != null) {
                list.add(e);
            }
        }
        return list.toArray(new gr[0]);
    }
    
    public String getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public gq aU() {
        return this.iB;
    }
    
    public int aV() {
        return this.iC * this.iB.di();
    }
    
    public boolean aW() {
        return this.iE;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.name) + " (" + (String.valueOf((this.iC > 0) ? "+" : "") + this.iC + ((this.iB == gq.oY) ? "%" : "")) + " " + this.iB + ")";
    }
    
    public static er[] a(final gr gr) {
        return (er[])er.iG.stream().filter(er -> er.iD == gr2).toArray(er[]::new);
    }
    
    public static er[] b(final gr gr) {
        return (er[])er.iG.stream().filter(er -> Arrays.stream(er.iF).anyMatch(gr3 -> gr3 == gr2)).toArray(er[]::new);
    }
    
    public static er o(final String s) {
        final int index = er.iG.indexOf(new et(s));
        if (index >= 0) {
            return (er)er.iG.get(index);
        }
        return null;
    }
}
