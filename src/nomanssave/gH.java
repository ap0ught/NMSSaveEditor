// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.function.Function;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class gH
{
    private final int index;
    private final eY rp;
    private final List gT;
    
    public static gH[] C(final eY ey) {
        final eV d = ey.d("ShipOwnership");
        if (d == null || d.size() == 0) {
            return new gH[0];
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (v.d("Resource.Seed").ab(0)) {
                list.add(new gH(i, v, v.H("Inventory"), v.H("Inventory_TechOnly"), v.H("Inventory_Cargo")));
            }
        }
        return (gH[])list.toArray(new gH[0]);
    }
    
    public static gH c(final eY ey, final File file) {
        final eV d = ey.d("ShipOwnership");
        if (d == null || d.size() == 0) {
            throw new RuntimeException("Ship cannot be imported to current file!");
        }
        int n = -1;
        for (int i = 0; i < d.size(); ++i) {
            if (!d.V(i).d("Resource.Seed").ab(0)) {
                n = i;
                break;
            }
        }
        if (n < 0) {
            throw new RuntimeException("Ship cannot be imported to current file!");
        }
        eY ey2 = gR.az("ship");
        Throwable t = null;
        try {
            final ff ff = new ff(new FileInputStream(file));
            try {
                if (ey2 == null) {
                    ey2 = ff.bK();
                }
                else {
                    ey2.c(ff.bK());
                }
            }
            finally {
                if (ff != null) {
                    ff.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception;
                t = exception;
            }
            else {
                final Throwable exception;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
        final eY h = ey2.H("Inventory");
        if (h == null) {
            throw new RuntimeException("Invalid ship data");
        }
        final eV d2 = ey2.d("Resource.Seed");
        if (d2 == null || !d2.ab(0)) {
            throw new RuntimeException("Invalid ship data");
        }
        d.a(n, ey2);
        return new gH(n, ey2, h, ey2.H("Inventory_TechOnly"), ey2.H("Inventory_Cargo"));
    }
    
    private static Function a(final gH gh, final String[] array) {
        return p2 -> {
            gh2.getName();
            String string = null;
            if (string == null || string.length() == 0) {
                string = "Ship [" + gh2.index + "]";
            }
            return new String[] { string, array2[gh2.dZ()] };
        };
    }
    
    private gH(final int index, final eY rp, final eY ey, final eY ey2, eY ey3) {
        this.index = index;
        this.rp = rp;
        final String[] array = { "Technology", "Organ Chamber" };
        int n = 0;
        int n2 = 8;
        int n3 = 6;
        int n4 = 8;
        int n5 = 6;
        final boolean d = Application.e().D();
        String[] array2;
        String[] array3;
        if (d) {
            n2 = 10;
            n3 = 12;
            n4 = 10;
            n5 = 6;
            array2 = new String[] { "Cargo", "Storage Sacs" };
            array3 = new String[] { "Unused", "Unused" };
            ey3 = null;
        }
        else {
            n = 3584;
            array2 = new String[] { "General", "Storage Sacs" };
            array3 = new String[] { "Cargo", "Inflated Sacs" };
        }
        final ArrayList list = new ArrayList();
        list.add(new gI(this, a(this, array2), ey, 0, n2, n3, false, true, d, index));
        if (ey2 != null) {
            list.add(new gJ(this, a(this, array), ey2, 0, n4, n5, true, true, index));
        }
        if (ey3 != null) {
            list.add(new gK(this, a(this, array3), ey3, n, 8, 6, false, true, index));
        }
        this.gT = Collections.unmodifiableList((List<?>)list);
    }
    
    public void a(final File file, final boolean b) {
        Throwable t = null;
        try {
            final fj fj = new fj(new FileOutputStream(file));
            try {
                final eY be = this.rp.bE();
                if (!b) {
                    final eV d = be.d("Inventory.Slots");
                    for (int i = 0; i < d.size(); ++i) {
                        if (!d.V(i).getValueAsString("Type.InventoryType").equals("Technology")) {
                            d.ac(i--);
                        }
                    }
                    final eV d2 = be.d("Inventory_Cargo.Slots");
                    for (int j = 0; j < d2.size(); ++j) {
                        if (!d2.V(j).getValueAsString("Type.InventoryType").equals("Technology")) {
                            d2.ac(j--);
                        }
                    }
                }
                fj.h(be);
            }
            finally {
                if (fj != null) {
                    fj.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception;
                t = exception;
            }
            else {
                final Throwable exception;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public String getName() {
        return this.rp.getValueAsString("Name");
    }
    
    public void setName(final String s) {
        this.rp.b("Name", s);
    }
    
    public boolean dZ() {
        return gL.aw(this.cT()) == gL.rx;
    }
    
    private int ea() {
        final gL aw = gL.aw(this.cT());
        return (aw == null) ? 4 : aw.ea();
    }
    
    public String cT() {
        return this.rp.getValueAsString("Resource.Filename");
    }
    
    public void ag(final String s) {
        this.rp.b("Resource.Filename", s);
        final gL aw = gL.aw(s);
        this.gT.stream().forEach(gt -> gt.az((gl == null) ? 4 : gl.ea()));
        if (aw == gL.rx) {
            this.d("^ALIEN_SHIP", 1.0);
            this.av("^ROBOT_SHIP");
        }
        else if (aw == gL.rC) {
            this.av("^ALIEN_SHIP");
            this.d("^ROBOT_SHIP", 1.0);
        }
        else {
            this.av("^ALIEN_SHIP");
            this.av("^ROBOT_SHIP");
        }
    }
    
    public String cK() {
        return this.rp.d("Resource.Seed").X(1);
    }
    
    public void aa(final String s) {
        this.rp.d("Resource.Seed").a(1, s);
    }
    
    public void cm() {
        this.rp.b("Resource.Filename", "");
        this.rp.d("Resource.Seed").a(0, Boolean.FALSE);
        this.rp.d("Resource.Seed").a(1, "0x0");
    }
    
    public String cW() {
        return this.rp.getValueAsString("Inventory.Class.InventoryClass");
    }
    
    public void aj(final String s) {
        this.rp.b("Inventory.Class.InventoryClass", s);
        final eY h = this.rp.H("Inventory_TechOnly.Class");
        if (h != null) {
            h.b("InventoryClass", s);
        }
        final eY h2 = this.rp.H("Inventory_Cargo.Class");
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
    
    private void av(final String s) {
        this.gT.stream().forEach(gt -> gt.ap(s2));
    }
    
    public double dF() {
        return this.ak("^SHIP_DAMAGE");
    }
    
    public void d(final double n) {
        this.d("^SHIP_DAMAGE", n);
    }
    
    public double eb() {
        return this.ak("^SHIP_SHIELD");
    }
    
    public void h(final double n) {
        this.d("^SHIP_SHIELD", n);
    }
    
    public double cX() {
        return this.ak("^SHIP_HYPERDRIVE");
    }
    
    public void a(final double n) {
        this.d("^SHIP_HYPERDRIVE", n);
    }
    
    public double ec() {
        return this.ak("^SHIP_AGILE");
    }
    
    public void i(final double n) {
        this.d("^SHIP_AGILE", n);
    }
    
    @Override
    public String toString() {
        final String name = this.getName();
        if (name != null && name.length() != 0) {
            return name;
        }
        final gL aw = gL.aw(this.cT());
        if (aw == null) {
            return "Unknown [" + this.index + "]";
        }
        return aw + " [" + this.index + "]";
    }
}
