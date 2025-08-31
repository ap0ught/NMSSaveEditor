// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.function.Function;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;

public class gv
{
    private final int index;
    private final eY qF;
    private final gt qG;
    
    public static gv[] v(final eY ey) {
        final eV d = ey.d("Multitools");
        if (d == null || d.size() == 0) {
            return new gv[] { new gw(ey, ey.H("WeaponInventory")) };
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (v.d("Seed").ab(0)) {
                list.add(new gv(i, v, v.H("Store")));
            }
        }
        return (gv[])list.toArray(new gv[0]);
    }
    
    public static gv b(final eY ey, final File file) {
        final eV d = ey.d("Multitools");
        if (d == null || d.size() == 0) {
            throw new RuntimeException("Weapon cannot be imported to current file!");
        }
        int n = -1;
        for (int i = 0; i < d.size(); ++i) {
            if (!d.V(i).d("Seed").ab(0)) {
                n = i;
                break;
            }
        }
        if (n < 0) {
            throw new RuntimeException("Weapon cannot be imported to current file!");
        }
        eY ey2 = gR.az("multitool");
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
        d.a(n, ey2);
        final eY h = ey2.H("Store");
        if (h == null) {
            throw new RuntimeException("Invalid weapon data");
        }
        final eV d2 = ey2.d("Seed");
        if (d2 == null || !d2.ab(0)) {
            throw new RuntimeException("Invalid weapon data");
        }
        return new gv(n, ey2, h);
    }
    
    private static Function b(final gv gv) {
        return p1 -> {
            gv2.getName();
            String string = null;
            if (string == null || string.length() == 0) {
                string = "Multitool [" + gv2.index + "]";
            }
            return new String[] { string };
        };
    }
    
    gv(final int index, final eY qf, final eY ey) {
        this.index = index;
        this.qF = qf;
        int n = 8;
        int n2 = 6;
        if (Application.e().D()) {
            n = 10;
            n2 = 10;
        }
        this.qG = new gt(b(this), ey, 2, n, n2, true, true);
    }
    
    public void j(final File file) {
        Throwable t = null;
        try {
            final fj fj = new fj(new FileOutputStream(file));
            try {
                fj.h(this.qF.bE());
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
        return this.qF.getValueAsString("Name");
    }
    
    public void setName(final String s) {
        this.qF.b("Name", s);
    }
    
    public String cT() {
        return this.qF.getValueAsString("Resource.Filename");
    }
    
    public void ag(final String s) {
        this.qF.b("Resource.Filename", s);
    }
    
    public String cK() {
        return this.qF.d("Seed").X(1);
    }
    
    public void aa(final String s) {
        this.qF.d("Seed").a(1, s);
    }
    
    public String cW() {
        return this.qF.getValueAsString("Store.Class.InventoryClass");
    }
    
    public void aj(final String s) {
        this.qF.b("Store.Class.InventoryClass", s);
    }
    
    public gt dE() {
        return this.qG;
    }
    
    private double ak(final String s) {
        return this.qG.ak(s);
    }
    
    private void d(final String s, final double n) {
        this.qG.d(s, n);
    }
    
    public double dF() {
        return this.ak("^WEAPON_DAMAGE");
    }
    
    public void d(final double n) {
        this.d("^WEAPON_DAMAGE", n);
    }
    
    public double dG() {
        return this.ak("^WEAPON_MINING");
    }
    
    public void e(final double n) {
        this.d("^WEAPON_MINING", n);
    }
    
    public double dH() {
        return this.ak("^WEAPON_SCAN");
    }
    
    public void f(final double n) {
        this.d("^WEAPON_SCAN", n);
    }
    
    public void cm() {
        this.qF.b("Seed", new eV(new Object[] { Boolean.FALSE, "0x0" }));
    }
    
    @Override
    public String toString() {
        final String name = this.getName();
        if (name != null && name.length() != 0) {
            return name;
        }
        return "Multitool [" + this.index + "]";
    }
}
