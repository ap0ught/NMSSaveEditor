// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;

public class gE
{
    private final int index;
    private final eY bf;
    
    public static gE[] z(final eY ey) {
        final List<Object> list = ey.d("TeleportEndpoints").bB().filter(ey2 -> "Settlement".equals(ey2.getValueAsString("TeleporterType"))).map(ey3 -> hl.n(ey3.H("UniverseAddress"))).collect((Collector<? super Object, ?, List<Object>>)Collectors.toList());
        final eV d = ey.d("SettlementStatesV2");
        if (d == null || d.size() == 0) {
            return new gE[0];
        }
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (list.contains(hl.n(v.getValue("UniverseAddress")))) {
                list2.add(new gE(i, v));
            }
        }
        return (gE[])list2.toArray(new gE[0]);
    }
    
    private gE(final int index, final eY bf) {
        this.index = index;
        this.bf = bf;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public String getName() {
        return this.bf.getValueAsString("Name");
    }
    
    public void setName(final String s) {
        this.bf.b("Name", s);
    }
    
    public int aq(final int n) {
        return this.bf.d("Stats").Y(n);
    }
    
    public void e(final int n, final int i) {
        this.bf.d("Stats").a(n, i);
    }
    
    public int a(final gG gg) {
        return this.bf.d("Stats").Y(gg.ordinal());
    }
    
    public void a(final gG gg, final int i) {
        this.bf.d("Stats").a(gg.ordinal(), i);
    }
    
    public int dW() {
        return this.bf.d("Perks").size();
    }
    
    public String aH(final int n) {
        return this.bf.d("Perks").X(n);
    }
    
    public void c(final int n, final String s) {
        this.bf.d("Perks").a(n, s);
    }
    
    public String cK() {
        return this.bf.I("SeedValue");
    }
    
    public void aa(final String s) {
        this.bf.b("SeedValue", s);
    }
    
    public gF[] dX() {
        final eV d = this.bf.d("ProductionState");
        if (d == null) {
            return new gF[0];
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < d.size(); ++i) {
            list.add(new gF(this, d.V(i), null));
        }
        return (gF[])list.toArray(new gF[0]);
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
