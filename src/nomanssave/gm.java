// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Collections;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.List;

public class gm
{
    private final eY oI;
    private final List gT;
    private final gn oJ;
    
    public static gm p(final eY ey) {
        if (ey.d("CurrentFreighter.Seed").ab(0) && !isEmpty(ey.getValueAsString("CurrentFreighter.Filename"))) {
            return new gm(ey, ey.H("FreighterInventory"), ey.H("FreighterInventory_TechOnly"), ey.H("FreighterInventory_Cargo"));
        }
        return null;
    }
    
    private static boolean isEmpty(final String s) {
        return s == null || s.length() == 0;
    }
    
    private static Function a(final gm gm, final String s) {
        return p1 -> new String[] { "Freighter", s2 };
    }
    
    private gm(final eY oi, final eY ey, final eY ey2, eY ey3) {
        this.oI = oi;
        int n = 0;
        int n2 = 8;
        int n3 = 6;
        int n4 = 7;
        int n5 = 2;
        int n6;
        int n7;
        String s;
        String s2;
        if (Application.e().D()) {
            n6 = 3584;
            n7 = 8;
            n2 = 10;
            n3 = 12;
            n4 = 10;
            n5 = 6;
            s = "Cargo";
            s2 = "Unused";
            ey3 = null;
        }
        else {
            n6 = 3592;
            n7 = 8;
            n = 3584;
            s = "General";
            s2 = "Cargo";
        }
        final ArrayList list = new ArrayList();
        list.add(new gt(a(this, s), ey, n6, n2, n3, false, true));
        if (ey2 != null) {
            list.add(new gt(a(this, "Technology"), ey2, n7, n4, n5, true, true));
        }
        if (ey3 != null) {
            list.add(new gt(a(this, s2), ey3, n, 8, 6, false, true));
        }
        this.gT = Collections.unmodifiableList((List<?>)list);
        final eV d = oi.d("PersistentPlayerBases");
        eY ey4 = null;
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if ("FreighterBase".equals(v.getValueAsString("BaseType.PersistentBaseTypes")) && v.J("BaseVersion") >= 3) {
                ey4 = v;
                break;
            }
        }
        this.oJ = ((ey4 == null) ? null : new gn(this, ey4, null));
    }
    
    public String getName() {
        return this.oI.getValueAsString("PlayerFreighterName");
    }
    
    public void setName(final String s) {
        this.oI.b("PlayerFreighterName", s);
    }
    
    public String cT() {
        return this.oI.getValueAsString("CurrentFreighter.Filename");
    }
    
    public void ag(final String s) {
        this.oI.b("CurrentFreighter.Filename", s);
    }
    
    public String cU() {
        final eV d = this.oI.d("CurrentFreighterHomeSystemSeed");
        if (d == null || !d.ab(0)) {
            return "";
        }
        final String x = d.X(1);
        return "0x0".equals(x) ? "" : x;
    }
    
    public void ah(final String s) {
        eV d = this.oI.d("CurrentFreighterHomeSystemSeed");
        if (d == null) {
            d = new eV(new Object[] { Boolean.FALSE, "0x0" });
            this.oI.b("CurrentFreighterHomeSystemSeed", d);
        }
        d.a(0, Boolean.TRUE);
        d.a(1, (s.length() == 0) ? "0x0" : s);
    }
    
    public String cV() {
        return this.oI.d("CurrentFreighter.Seed").X(1);
    }
    
    public void ai(final String s) {
        this.oI.d("CurrentFreighter.Seed").a(1, s);
    }
    
    public String cW() {
        return this.oI.getValueAsString("FreighterInventory.Class.InventoryClass");
    }
    
    public void aj(final String s) {
        this.oI.b("FreighterInventory.Class.InventoryClass", s);
        final eY h = this.oI.H("FreighterInventory_TechOnly.Class");
        if (h != null) {
            h.b("InventoryClass", s);
        }
        final eY h2 = this.oI.H("FreighterInventory_Cargo.Class");
        if (h2 != null) {
            h2.b("InventoryClass", s);
        }
    }
    
    public List cC() {
        return this.gT;
    }
    
    private double ak(final String s) {
        return this.gT.get(0).ak(s);
    }
    
    private void d(final String s, final double n) {
        this.gT.stream().forEach(gt -> gt.d(s2, n2));
    }
    
    public double cX() {
        return this.ak("^FREI_HYPERDRIVE");
    }
    
    public void a(final double n) {
        this.d("^FREI_HYPERDRIVE", n);
    }
    
    public double cY() {
        return this.ak("^FREI_FLEET");
    }
    
    public void b(final double n) {
        this.d("^FREI_FLEET", n);
    }
    
    public gn cZ() {
        return this.oJ;
    }
    
    @Override
    public String toString() {
        final String name = this.getName();
        if (name != null && name.length() != 0) {
            return name;
        }
        return "Freighter";
    }
}
