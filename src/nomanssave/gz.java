// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.List;

public class gz
{
    private final eY oI;
    private final eV rb;
    private final eV rc;
    private final List gT;
    
    public static gz w(final eY ey) {
        eV d = null;
        final eV d2 = ey.d("Stats");
        if (d2 != null) {
            for (int i = 0; i < d2.size(); ++i) {
                final eY v = d2.V(i);
                if ("^GLOBAL_STATS".equals(v.getValueAsString("GroupId"))) {
                    d = v.d("Stats");
                    break;
                }
            }
        }
        return new gz(ey, d, ey.H("Inventory"), ey.H("Inventory_TechOnly"), ey.H("Inventory_Cargo"));
    }
    
    private static Function au(final String s) {
        return p1 -> new String[] { "Exosuit", s2 };
    }
    
    private gz(final eY oi, final eV rb, final eY ey, final eY ey2, eY ey3) {
        this.oI = oi;
        this.rb = rb;
        final eV d = oi.d("KnownWords");
        eV d2 = oi.d("KnownWordGroups");
        if (d2 == null) {
            d2 = new eV();
            oi.b("KnownWordGroups", d2);
        }
        if (d.size() > 0) {
            int i = 0;
            while (i < d.size()) {
                final eY v = d.V(i);
                final eS a = eS.A(v.getValueAsString("id"));
                if (a == null) {
                    hc.warn("Could not build word groups: " + v.getValueAsString("id"));
                    ++i;
                }
                else {
                    for (final String str : a.bw()) {
                        final eU z = a.z(str);
                        if (z != null) {
                            final eY ey4 = new eY();
                            ey4.b("Group", str);
                            final eV ev = new eV(new Object[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE });
                            ev.a(z.ordinal(), Boolean.TRUE);
                            ey4.b("Races", ev);
                            d2.f(ey4);
                            hc.debug("Creating word: " + str + "[" + z.ordinal() + "] = true");
                        }
                    }
                    d.ac(i);
                    hc.debug("Removed old word: " + v.getValueAsString("id"));
                }
            }
        }
        this.rc = d2;
        int n = 0;
        int n2 = 8;
        int n3 = 6;
        int n4 = 7;
        int n5 = 2;
        int n6;
        boolean b;
        String s;
        String s2;
        if (Application.e().D()) {
            n6 = 3584;
            b = true;
            n2 = 10;
            n3 = 12;
            n4 = 10;
            n5 = 6;
            s = "Cargo";
            s2 = "Unused";
            ey3 = null;
        }
        else {
            n6 = 3585;
            b = true;
            n = 3584;
            s = "General";
            s2 = "Cargo";
        }
        final ArrayList list = new ArrayList();
        list.add(new gt(au(s), ey, n6, n2, n3, false, true));
        if (ey2 != null) {
            list.add(new gt(au("Technology"), ey2, (int)(b ? 1 : 0), n4, n5, true, true));
        }
        if (ey3 != null) {
            list.add(new gt(au(s2), ey3, n, 8, 6, false, true));
        }
        this.gT = Collections.unmodifiableList((List<?>)list);
    }
    
    public long dJ() {
        return this.oI.K("Units") & 0xFFFFFFFFL;
    }
    
    public void e(final long n) {
        this.oI.b("Units", new Integer((int)n));
    }
    
    public long dK() {
        return this.oI.K("Nanites") & 0xFFFFFFFFL;
    }
    
    public void f(final long n) {
        this.oI.b("Nanites", new Integer((int)n));
    }
    
    public long dL() {
        return this.oI.K("Specials") & 0xFFFFFFFFL;
    }
    
    public void g(final long n) {
        this.oI.b("Specials", new Integer((int)n));
    }
    
    public int dM() {
        return this.oI.J("Health");
    }
    
    public void aB(final int value) {
        this.oI.b("Health", new Integer(value));
    }
    
    public int dN() {
        return this.oI.J("Shield");
    }
    
    public void aC(final int value) {
        this.oI.b("Shield", new Integer(value));
    }
    
    public int dO() {
        return this.oI.J("Energy");
    }
    
    public void aD(final int value) {
        this.oI.b("Energy", new Integer(value));
    }
    
    public List cC() {
        return this.gT;
    }
    
    public int dP() {
        return this.oI.J("KnownPortalRunes");
    }
    
    public void aE(final int value) {
        this.oI.b("KnownPortalRunes", new Integer(value));
    }
    
    public eV dQ() {
        return this.oI.d("KnownTech");
    }
    
    public eV dR() {
        return this.oI.d("KnownProducts");
    }
    
    public eV dS() {
        return this.oI.d("KnownSpecials");
    }
    
    public int bx() {
        final int n = 0;
        final ArrayList list = new ArrayList();
        for (int i = 0; i < this.rc.size(); ++i) {
            final eS b = eS.B(this.rc.V(i).getValueAsString("Group"));
            if (b != null && !list.contains(b.getID())) {
                list.add(b.getID());
            }
        }
        return n;
    }
    
    public int b(final eU eu) {
        int n = 0;
        for (int i = 0; i < this.rc.size(); ++i) {
            if (this.rc.V(i).d("Races").ab(eu.ordinal())) {
                ++n;
            }
        }
        return n;
    }
    
    public gA a(final eS es) {
        return new gA(this, es, null);
    }
    
    private boolean d(final String s, final int n) {
        for (int i = 0; i < this.rc.size(); ++i) {
            final eY v = this.rc.V(i);
            if (s.equals(v.getValueAsString("Group"))) {
                return v.d("Races").ab(n);
            }
        }
        return false;
    }
    
    private void a(final String str, final int n, boolean b) {
        for (int i = 0; i < this.rc.size(); ++i) {
            final eY v = this.rc.V(i);
            if (str.equals(v.getValueAsString("Group"))) {
                hc.debug("Updating word: " + str + "[" + n + "] = " + b);
                final eV d = v.d("Races");
                while (d.size() < eU.values().length) {
                    d.add(Boolean.FALSE);
                }
                d.a(n, new Boolean(b));
                for (int j = 0; j < d.size(); ++j) {
                    b |= d.ab(j);
                }
                if (!b) {
                    hc.debug("Removing word: " + str);
                    this.rc.ac(i);
                }
                return;
            }
        }
        if (b) {
            hc.debug("Creating word: " + str + "[" + n + "] = " + b);
            final eY ey = new eY();
            ey.b("Group", str);
            final eV ev = new eV();
            while (ev.size() < eU.values().length) {
                ev.add(Boolean.FALSE);
            }
            ev.a(n, new Boolean(b));
            ey.b("Races", ev);
            this.rc.f(ey);
        }
    }
    
    public double dT() {
        return new Double(Math.round(this.oI.J("HazardTimeAlive") / 90.0) / 10.0);
    }
    
    public void g(final double n) {
        final long round = Math.round(n * 900.0);
        if (round < 0L || round > 2147483647L) {
            throw new RuntimeException("Stat value out of range");
        }
        this.oI.b("HazardTimeAlive", new Integer((int)round));
    }
    
    public int a(final gs gs) {
        for (int i = 0; i < this.rb.size(); ++i) {
            final eY v = this.rb.V(i);
            if (v.getValueAsString("Id").equals(gs.id)) {
                return v.J("Value.IntValue");
            }
        }
        return 0;
    }
    
    public void a(final gs gs, final int n) {
        if (n < 0) {
            throw new RuntimeException("Stat value out of range");
        }
        for (int i = 0; i < this.rb.size(); ++i) {
            final eY v = this.rb.V(i);
            if (v.getValueAsString("Id").equals(gs.id)) {
                v.b("Value.IntValue", new Integer(n));
                return;
            }
        }
        final eY ey = new eY();
        ey.b("Id", gs.id);
        final eY ey2 = new eY();
        ey2.b("IntValue", new Integer(n));
        ey2.b("FloatValue", new Double(0.0));
        ey2.b("Denominator", new Double(0.0));
        ey.b("Value", (Object)ey2);
        this.rb.f(ey);
    }
    
    public double b(final gs gs) {
        for (int i = 0; i < this.rb.size(); ++i) {
            final eY v = this.rb.V(i);
            if (v.getValueAsString("Id").equals(gs.id)) {
                return v.L("Value.FloatValue");
            }
        }
        return 0.0;
    }
    
    public void a(final gs gs, final double n) {
        if (n < 0.0) {
            throw new RuntimeException("Stat value out of range");
        }
        for (int i = 0; i < this.rb.size(); ++i) {
            final eY v = this.rb.V(i);
            if (v.getValueAsString("Id").equals(gs.id)) {
                v.b("Value.FloatValue", new Double(n));
                return;
            }
        }
        final eY ey = new eY();
        ey.b("Id", gs.id);
        final eY ey2 = new eY();
        ey2.b("IntValue", new Integer(0));
        ey2.b("FloatValue", new Double(n));
        ey2.b("Denominator", new Double(0.0));
        ey.b("Value", (Object)ey2);
        this.rb.f(ey);
    }
}
