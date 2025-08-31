// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Collections;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;

public class gO
{
    private final int index;
    private final eY rO;
    private final List gT;
    
    public static gO[] E(final eY ey) {
        final eV d = ey.d("VehicleOwnership");
        if (d == null || d.size() == 0) {
            return new gO[0];
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (i != 4) {
                list.add(new gO(i, v, v.H("Inventory"), v.H("Inventory_TechOnly")));
            }
        }
        final eY h = ey.H("FishPlatformLayout");
        final eY h2 = ey.H("FishPlatformInventory");
        if (h != null && h2 != null) {
            list.add(new gO(h, h2));
        }
        return (gO[])list.toArray(new gO[0]);
    }
    
    private static Function a(final gO go, final String s) {
        return p2 -> new String[] { go2.getType(), s2 };
    }
    
    private gO(final int index, final eY ro, final eY ey, final eY ey2) {
        this.index = index;
        this.rO = ro;
        int n;
        if (index == 5) {
            n = 32;
        }
        else if (index == 6) {
            n = 128;
        }
        else {
            n = 16;
        }
        final boolean d = Application.e().D();
        int n2 = 8;
        int n3 = 6;
        int n4 = 8;
        int n5 = 6;
        String s;
        if (d) {
            n2 = 10;
            n3 = 5;
            n4 = 10;
            n5 = 3;
            s = "Cargo";
        }
        else {
            s = "General";
        }
        final ArrayList list = new ArrayList();
        list.add(new gP(this, a(this, s), ey, 0, n2, n3, false, false, false, false, d, n));
        if (ey2 != null) {
            list.add(new gt(a(this, "Technology"), ey2, n, n4, n5, true, false, false, false));
        }
        this.gT = Collections.unmodifiableList((List<?>)list);
    }
    
    private gO(final eY ro, final eY ey) {
        this.index = 1000;
        this.rO = ro;
        ey.a((anObject, p2, o3) -> {
            if ("ValidSlotIndices".equals(anObject) && o3 instanceof eV) {
                ey2.b("Slots", ((eV)o3).size());
            }
            return;
        });
        final int n = 8;
        final int n2 = 6;
        final ArrayList list = new ArrayList();
        list.add(new gt(a(this, "Cold Storage"), ey, 2048, n, n2, false, false, true, false));
        this.gT = Collections.unmodifiableList((List<?>)list);
    }
    
    public String getType() {
        if (this.index == 0) {
            return "Roamer";
        }
        if (this.index == 1) {
            return "Nomad";
        }
        if (this.index == 2) {
            return "Colossus";
        }
        if (this.index == 3) {
            return "Pilgrim";
        }
        if (this.index == 5) {
            return "Nautilon";
        }
        if (this.index == 6) {
            return "Minotaur";
        }
        if (this.index == 1000) {
            return "Skiff";
        }
        return "Vehicle " + this.index;
    }
    
    public List cC() {
        return this.gT;
    }
    
    @Override
    public String toString() {
        return this.getType();
    }
}
