// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.ArrayList;

public class gp
{
    private final int index;
    private final eY oR;
    
    public static gp[] q(final eY ey) {
        final eV d = ey.d("FleetFrigates");
        if (d == null) {
            return new gp[0];
        }
        return d(d);
    }
    
    public static gp[] d(final eV ev) {
        if (ev.size() == 0) {
            return new gp[0];
        }
        final ArrayList list = new ArrayList();
        final gp[] array = new gp[(ev == null) ? 0 : ev.size()];
        for (int i = 0; i < array.length; ++i) {
            list.add(new gp(i, ev.V(i)));
        }
        return (gp[])list.toArray(new gp[0]);
    }
    
    private gp(final int index, final eY or) {
        this.index = index;
        this.oR = or;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public String getName() {
        return this.oR.getValueAsString("CustomName");
    }
    
    public void setName(final String s) {
        this.oR.b("CustomName", s);
    }
    
    public gr da() {
        return gr.an(this.oR.getValueAsString("FrigateClass.FrigateClass"));
    }
    
    public void c(final gr gr) {
        this.oR.b("FrigateClass.FrigateClass", gr.toString());
    }
    
    public String cW() {
        int n = -2;
        final eV d = this.oR.d("TraitIDs");
        for (int i = 0; i < d.size(); ++i) {
            final er o = er.o(d.X(i));
            if (o != null && o.aW()) {
                ++n;
            }
        }
        if (n < 0) {
            n = 0;
        }
        if (n > 3) {
            n = 3;
        }
        return gN.values()[n].name();
    }
    
    public String cU() {
        return this.oR.d("HomeSystemSeed").X(1);
    }
    
    public void ah(final String s) {
        this.oR.d("HomeSystemSeed").a(1, s);
    }
    
    public String cV() {
        return this.oR.d("ResourceSeed").X(1);
    }
    
    public void ai(final String s) {
        this.oR.d("ResourceSeed").a(1, s);
    }
    
    public String db() {
        return this.oR.getValueAsString("Race.AlienRace");
    }
    
    public void am(final String s) {
        this.oR.b("Race.AlienRace", s);
    }
    
    public int aq(final int n) {
        final eV d = this.oR.d("Stats");
        if (d.size() <= n) {
            return 0;
        }
        return d.Y(n);
    }
    
    public void e(final int n, final int value) {
        final eV d = this.oR.d("Stats");
        while (d.size() <= n) {
            d.f(0);
        }
        d.a(n, new Integer(value));
    }
    
    public er ar(final int n) {
        final eV d = this.oR.d("TraitIDs");
        if (n < d.size()) {
            return er.o(d.X(n));
        }
        return null;
    }
    
    public void a(final int n, final er er) {
        final eV d = this.oR.d("TraitIDs");
        if (n < d.size()) {
            d.a(n, (er == null) ? "^" : er.getID());
        }
    }
    
    public int dc() {
        return this.oR.J("TotalNumberOfExpeditions");
    }
    
    public void as(final int value) {
        this.oR.b("TotalNumberOfExpeditions", new Integer(value));
    }
    
    public int dd() {
        return this.oR.J("TotalNumberOfSuccessfulEvents");
    }
    
    public void at(final int value) {
        this.oR.b("TotalNumberOfSuccessfulEvents", new Integer(value));
    }
    
    public int de() {
        return this.oR.J("TotalNumberOfFailedEvents");
    }
    
    public void au(final int value) {
        this.oR.b("TotalNumberOfFailedEvents", new Integer(value));
    }
    
    public int df() {
        return this.oR.J("NumberOfTimesDamaged");
    }
    
    public void av(final int value) {
        this.oR.b("NumberOfTimesDamaged", new Integer(value));
    }
    
    public int dg() {
        return this.oR.J("RepairsMade");
    }
    
    public void aw(final int value) {
        this.oR.b("RepairsMade", new Integer(value));
    }
    
    public int dh() {
        return this.oR.J("DamageTaken");
    }
    
    public void ax(final int value) {
        this.oR.b("DamageTaken", new Integer(value));
    }
    
    @Override
    public String toString() {
        final String name = this.getName();
        if (name != null && name.length() != 0) {
            return name;
        }
        final gr da = this.da();
        if (da == null) {
            return "Unknown [" + this.index + "]";
        }
        return da + " [" + this.index + "]";
    }
}
