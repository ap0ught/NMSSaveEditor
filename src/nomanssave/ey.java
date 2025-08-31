// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.ImageIcon;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import org.w3c.dom.Node;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Collections;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;
import java.util.regex.Pattern;

public abstract class ey
{
    public static final int jD = 0;
    public static final int jE = 1;
    public static final int jF = 2;
    public static final int jG = 3;
    final String id;
    private static final Pattern jH;
    private static final List jI;
    private static final List jJ;
    
    static {
        jH = Pattern.compile("%(\\w+)%");
        Node documentElement = null;
        final InputStream resourceAsStream = Application.class.getResourceAsStream("db/items.xml");
        if (resourceAsStream != null) {
            try {
                documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream).getDocumentElement();
            }
            catch (final ParserConfigurationException ex) {}
            catch (final SAXException ex2) {}
            catch (final IOException ex3) {}
        }
        final ArrayList list = new ArrayList();
        if (documentElement != null) {
            final NodeList childNodes = documentElement.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); ++i) {
                final Node item = childNodes.item(i);
                if (item instanceof Element && item.getNodeName().equals("product-template")) {
                    list.add(new eA((Element)item));
                }
            }
        }
        jI = Collections.unmodifiableList((List<?>)list);
        final ArrayList list2 = new ArrayList();
        if (documentElement != null) {
            final NodeList childNodes2 = documentElement.getChildNodes();
            for (int j = 0; j < childNodes2.getLength(); ++j) {
                final Node item2 = childNodes2.item(j);
                if (item2 instanceof Element && item2.getNodeName().equals("substance")) {
                    list2.add(new eP((Element)item2));
                }
                else if (item2 instanceof Element && item2.getNodeName().equals("product")) {
                    list2.add(new eH((Element)item2, false));
                }
                else if (item2 instanceof Element && item2.getNodeName().equals("procedural-product")) {
                    list2.add(new eH((Element)item2, true));
                }
                else if (item2 instanceof Element && item2.getNodeName().equals("technology")) {
                    list2.add(new eQ((Element)item2, false));
                }
                else if (item2 instanceof Element && item2.getNodeName().equals("procedural-technology")) {
                    list2.add(new eQ((Element)item2, true));
                }
            }
        }
        final List list3 = (List)list2.stream().filter(ey -> ey instanceof eQ).map(eQ.class::cast).map(eq -> eq.bv()).filter(er -> er != null).collect(Collectors.toList());
        list2.addAll(list3);
        list3.sort((er2, er3) -> er2.getName().compareTo(er3.getName()));
        jJ = Collections.unmodifiableList((List<?>)list2);
    }
    
    ey(final String id) {
        this.id = id;
    }
    
    public final String getID() {
        return this.id;
    }
    
    private static String L(final int i) {
        final StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(i));
        while (sb.length() < 5) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
    
    public Object aZ() {
        if (this.id.length() < 2 || this.id.charAt(0) != '^') {
            throw new RuntimeException("Cannot create ID: invalid string");
        }
        if (this.bb()) {
            return String.valueOf(this.id) + "#" + L((int)Math.floor(Math.random() * 100000.0));
        }
        return this.id;
    }
    
    public Object M(final int n) {
        if (this.id.length() < 2 || this.id.charAt(0) != '^') {
            throw new RuntimeException("Cannot create ID: invalid string");
        }
        if (this.bb()) {
            if (n < 0 || n >= 100000) {
                throw new RuntimeException("Cannot create ID: invalid proc");
            }
            return String.valueOf(this.id) + "#" + L(n);
        }
        else {
            if (n != 0) {
                throw new RuntimeException("Cannot create ID: invalid proc");
            }
            return this.id;
        }
    }
    
    public abstract eB ba();
    
    public abstract boolean bb();
    
    public abstract String getName();
    
    public abstract ex bc();
    
    public abstract boolean bd();
    
    public abstract boolean be();
    
    public abstract Integer bf();
    
    public abstract String bg();
    
    public abstract boolean bh();
    
    public abstract String bi();
    
    public final ImageIcon N(final int n) {
        final String bi = this.bi();
        switch (n) {
            case 0: {
                return (bi == null) ? null : Application.a(bi);
            }
            case 3: {
                return (bi == null) ? null : Application.a(bi, 20, 20);
            }
            case 1: {
                return (bi == null) ? null : Application.a(bi, 40, 40);
            }
            case 2: {
                return (bi == null) ? null : Application.a(bi, 80, 80);
            }
            default: {
                return null;
            }
        }
    }
    
    public final ImageIcon c(final int n, final int n2) {
        final String bi = this.bi();
        return (bi == null) ? null : Application.a(bi, n, n2);
    }
    
    public abstract int bj();
    
    public abstract String getDescription();
    
    public abstract List bk();
    
    @Override
    public String toString() {
        return this.id;
    }
    
    static String a(final Element element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        final NodeList childNodes = element.getChildNodes();
        final StringBuffer sb = new StringBuffer();
        boolean b = false;
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item.getNodeType() == 3) {
                sb.append(item.getNodeValue());
                b = true;
            }
        }
        if (!b) {
            return null;
        }
        return sb.toString();
    }
    
    private static List O(final int n) {
        final ArrayList list = new ArrayList();
        final boolean b = (n & 0x4000) == 0x0;
        if ((n & 0x4) == 0x4) {
            list.add(ex.je);
            list.add(ex.js);
            list.add(ex.jv);
            if (b) {
                list.add(ex.jw);
            }
        }
        if ((n & 0x40) == 0x40) {
            list.add(ex.jq);
            list.add(ex.js);
            if (b) {
                list.add(ex.jr);
            }
        }
        if ((n & 0x100) == 0x100) {
            list.add(ex.ju);
            list.add(ex.js);
            list.add(ex.jv);
            if (b) {
                list.add(ex.jw);
            }
        }
        if ((n & 0x2) == 0x2) {
            list.add(ex.jf);
            if (b) {
                list.add(ex.jg);
            }
        }
        if ((n & 0x1) == 0x1) {
            list.add(ex.jh);
            if (b) {
                list.add(ex.ji);
            }
        }
        if ((n & 0x8) == 0x8) {
            list.add(ex.jk);
            if (b) {
                list.add(ex.jl);
            }
        }
        if ((n & 0x10) == 0x10) {
            list.add(ex.jm);
            list.add(ex.jt);
            if (b) {
                list.add(ex.jn);
            }
        }
        if ((n & 0x20) == 0x20) {
            list.add(ex.jo);
            list.add(ex.jt);
            if (b) {
                list.add(ex.jp);
            }
        }
        if ((n & 0x80) == 0x80) {
            list.add(ex.jx);
            list.add(ex.jt);
            if (b) {
                list.add(ex.jy);
            }
        }
        final boolean b2 = (n & 0x8000) != 0x0;
        if ((n & 0x400) == 0x400) {
            if (b2) {
                list.add(ex.iL);
                list.add(ex.iP);
                list.add(ex.iQ);
                list.add(ex.iS);
            }
            else {
                list.add(ex.iL);
                list.add(ex.iM);
                list.add(ex.iN);
                list.add(ex.iO);
                list.add(ex.iP);
                list.add(ex.iQ);
                list.add(ex.iR);
                list.add(ex.iS);
            }
        }
        if ((n & 0x200) == 0x200) {
            if (b2) {
                list.add(ex.iT);
                list.add(ex.iU);
            }
            else {
                list.add(ex.iT);
                list.add(ex.iU);
                list.add(ex.iV);
                list.add(ex.iW);
                list.add(ex.iZ);
                list.add(ex.jb);
                if (b) {
                    list.add(ex.iY);
                }
                if ((n & 0x2000) == 0x0) {
                    list.add(ex.jd);
                }
            }
        }
        if ((n & 0x800) == 0x800) {
            list.add(ex.jc);
        }
        return list;
    }
    
    public static List b(final int n, final String s) {
        return (List)ey.jJ.stream().filter(ey -> {
            s2.toUpperCase();
            return ey.getName().toUpperCase().indexOf(str) >= 0 && O(n2).contains(ey.bc());
        }).collect(Collectors.toList());
    }
    
    public static List bl() {
        return (List)ey.jJ.stream().filter(ey -> ey instanceof eQ && !ey.bb() && ey.bc() != ex.jz).collect(Collectors.toList());
    }
    
    public static List bm() {
        return (List)ey.jJ.stream().filter(ey -> ey instanceof eH && !ey.bb()).collect(Collectors.toList());
    }
    
    public static ey d(final Object o) {
        return (ey)ey.jJ.stream().filter(ey -> {
            final Object o4 = (o2 instanceof fg) ? ((fg)o2).bP() : o2.toString();
            if (ey.bb() || ey instanceof eR) {
                return s.startsWith(String.valueOf(ey.id) + "#");
            }
            else {
                return o3.equals(ey.id);
            }
        }).findFirst().orElse(null);
    }
    
    static eA p(final String s) {
        return (eA)ey.jI.stream().filter(ea -> s2.equals(ea.id)).findFirst().orElse(null);
    }
}
