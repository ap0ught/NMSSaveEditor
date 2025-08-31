// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.PrintStream;
import java.awt.Dimension;
import java.util.function.Function;

public class gt
{
    public static final int pW = 1;
    public static final int pX = 2;
    public static final int pY = 4;
    public static final int pZ = 8;
    public static final int qa = 16;
    public static final int qb = 32;
    public static final int qc = 64;
    public static final int qd = 128;
    public static final int qe = 256;
    public static final int qf = 324;
    public static final int qg = 176;
    public static final int qh = 260;
    public static final int qi = 511;
    public static final int qj = 512;
    public static final int qk = 1024;
    public static final int ql = 2048;
    public static final int qm = 3584;
    public static final int qn = 8192;
    public static final int qo = 16384;
    public static final int qp = 32768;
    public static final int qq = 8;
    public static final int qr = 6;
    private final Function qs;
    private final eY qt;
    private final int r;
    private final boolean qu;
    private final boolean qv;
    private final boolean qw;
    private final boolean qx;
    private int width;
    private int height;
    private int bE;
    private int bF;
    private eY[][] qy;
    private boolean[][] qz;
    private static /* synthetic */ int[] qA;
    private static /* synthetic */ int[] qB;
    private static /* synthetic */ int[] qC;
    
    public static int a(final ex ex) {
        switch (dw()[ex.ordinal()]) {
            case 23:
            case 24: {
                return 1;
            }
            case 20: {
                return 4;
            }
            case 32:
            case 33: {
                return 64;
            }
            case 21:
            case 22: {
                return 2;
            }
            case 28:
            case 29: {
                return 16;
            }
            case 30:
            case 31: {
                return 32;
            }
            case 39:
            case 40: {
                return 128;
            }
            case 26:
            case 27: {
                return 8;
            }
            case 34: {
                return 324;
            }
            case 36: {
                return 256;
            }
            case 37:
            case 38: {
                return 260;
            }
            case 35: {
                return 176;
            }
            case 18: {
                return 3584;
            }
            default: {
                return 1536;
            }
        }
    }
    
    gt(final Function function, final eY ey, final int n, final int n2, final int n3, final boolean b, final boolean b2) {
        this(function, ey, n, n2, n3, b, b2, true, true);
    }
    
    gt(final Function qs, final eY qt, final int r, final int b, final int b2, final boolean qu, final boolean qv, final boolean qw, final boolean qx) {
        this.qs = qs;
        this.qt = qt;
        this.r = r;
        this.qu = qu;
        this.qv = qv;
        this.qw = qw;
        this.qx = qx;
        this.width = qt.J("Width");
        this.height = qt.J("Height");
        final ew b3 = eu.b(Application.e().E(), qt.getValueAsString("StackSizeGroup.InventoryStackSizeGroup"));
        if (b3 != null) {
            this.bE = b3.aX();
            this.bF = b3.aY();
        }
        else {
            switch (dx()[Application.e().F().ordinal()]) {
                case 2:
                case 5: {
                    this.bE = 250 * qt.c("SubstanceMaxStorageMultiplier", 2);
                    this.bF = qt.c("ProductMaxStorageMultiplier", 10);
                    break;
                }
                default: {
                    this.bE = 9999;
                    this.bF = qt.c("ProductMaxStorageMultiplier", 10);
                    break;
                }
            }
        }
        final int max = Math.max(this.height, b2);
        final int max2 = Math.max(this.width, b);
        this.qy = new eY[max][];
        this.qz = new boolean[max][];
        for (int i = 0; i < max; ++i) {
            this.qy[i] = new eY[max2];
            this.qz[i] = new boolean[max2];
        }
        final eV d = qt.d("ValidSlotIndices");
        for (int j = 0; j < d.size(); ++j) {
            final eY v = d.V(j);
            final int k = v.J("X");
            final int l = v.J("Y");
            if (k >= 0) {
                if (k < max2) {
                    if (l >= 0) {
                        if (l < max) {
                            this.qz[l][k] = true;
                        }
                    }
                }
            }
        }
        final eV d2 = qt.d("Slots");
        for (int n = 0; n < d2.size(); ++n) {
            final eY v2 = d2.V(n);
            final int m = v2.J("Index.X");
            final int j2 = v2.J("Index.Y");
            if (m >= 0) {
                if (m < max2) {
                    if (j2 >= 0) {
                        if (j2 < max) {
                            this.qy[j2][m] = v2;
                        }
                    }
                }
            }
        }
    }
    
    public String getSimpleName() {
        final String[] array = this.qs.apply(this);
        if (array.length == 0) {
            return "Unknown";
        }
        return (array.length == 1) ? array[0] : array[1];
    }
    
    public String getFullName() {
        final String[] array = this.qs.apply(this);
        if (array.length == 0) {
            return "Unknown";
        }
        return (array.length == 1) ? array[0] : (String.valueOf(array[0]) + " - " + array[1]);
    }
    
    public String getName() {
        return this.qt.getValueAsString("Name");
    }
    
    public void setName(String s) {
        if (s == null) {
            s = "";
        }
        this.qt.b("Name", s);
    }
    
    public int dj() {
        return this.r;
    }
    
    public boolean ay(final int n) {
        return (this.dj() & n) != 0x0;
    }
    
    public boolean dk() {
        return this.qv;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    boolean ao(final String anObject) {
        final eV d = this.qt.d("BaseStatValues");
        if (d == null) {
            return false;
        }
        for (int i = 0; i < d.size(); ++i) {
            if (d.V(i).getValueAsString("BaseStatID").equals(anObject)) {
                return true;
            }
        }
        return false;
    }
    
    double ak(final String anObject) {
        final eV d = this.qt.d("BaseStatValues");
        if (d == null) {
            return 0.0;
        }
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (v.getValueAsString("BaseStatID").equals(anObject)) {
                return v.L("Value");
            }
        }
        return 0.0;
    }
    
    void d(final String anObject, final double n) {
        final eV d = this.qt.d("BaseStatValues");
        if (d == null) {
            throw new RuntimeException("Could not set base stat");
        }
        boolean b = false;
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (v.getValueAsString("BaseStatID").equals(anObject)) {
                v.b("Value", n);
                b = true;
                break;
            }
        }
        if (!b) {
            final eY ey = new eY();
            ey.b("BaseStatID", anObject);
            ey.b("Value", n);
            d.f(ey);
        }
    }
    
    boolean ap(final String anObject) {
        final eV d = this.qt.d("BaseStatValues");
        if (d == null) {
            return false;
        }
        for (int i = 0; i < d.size(); ++i) {
            if (d.V(i).getValueAsString("BaseStatID").equals(anObject)) {
                d.ac(i);
                return true;
            }
        }
        return false;
    }
    
    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }
    
    public boolean a(final Dimension dimension) {
        int max = 1;
        int max2 = 1;
        for (int i = 0; i < this.qy.length; ++i) {
            for (int j = 0; j < this.qy[i].length; ++j) {
                if (this.qz[i][j]) {
                    max = Math.max(max, j + 1);
                    max2 = Math.max(max2, i + 1);
                }
            }
        }
        if (dimension.width < max) {
            throw new RuntimeException("Cannot resize less than min width");
        }
        if (dimension.height < max2) {
            throw new RuntimeException("Cannot resize less than min height");
        }
        if (en.aS()) {
            if (dimension.width > this.qz[0].length) {
                for (int k = 0; k < this.qy.length; ++k) {
                    final eY[] array = new eY[dimension.width];
                    final boolean[] array2 = new boolean[dimension.width];
                    System.arraycopy(this.qy[k], 0, array, 0, this.qz[k].length);
                    System.arraycopy(this.qz[k], 0, array2, 0, this.qz[k].length);
                    this.qy[k] = array;
                    this.qz[k] = array2;
                }
            }
            if (dimension.height > this.qz.length) {
                final eY[][] qy = new eY[dimension.height][];
                final boolean[][] qz = new boolean[dimension.height][];
                System.arraycopy(this.qy, 0, qy, 0, this.qz.length);
                System.arraycopy(this.qz, 0, qz, 0, this.qz.length);
                for (int l = this.qz.length; l < dimension.height; ++l) {
                    qy[l] = new eY[dimension.width];
                    qz[l] = new boolean[dimension.width];
                }
                this.qy = qy;
                this.qz = qz;
            }
        }
        else {
            if (dimension.width > this.qz[0].length) {
                throw new RuntimeException("Cannot resize width greater than " + this.qz[0].length);
            }
            if (dimension.height > this.qz.length) {
                throw new RuntimeException("Cannot resize height greater than " + this.qz.length);
            }
        }
        boolean b = false;
        if (this.width != dimension.width) {
            this.width = dimension.width;
            this.qt.b("Width", new Integer(this.width));
            b = true;
        }
        if (this.height != dimension.height) {
            this.height = dimension.height;
            this.qt.b("Height", new Integer(this.height));
            b = true;
        }
        return b;
    }
    
    public boolean dl() {
        boolean b = false;
        if (this.width < this.qz[0].length) {
            this.width = this.qz[0].length;
            this.qt.b("Width", new Integer(this.width));
            b = true;
        }
        if (this.height < this.qz.length) {
            this.height = this.qz.length;
            this.qt.b("Height", new Integer(this.height));
            b = true;
        }
        return b;
    }
    
    public Dimension dm() {
        int max = 1;
        int max2 = 1;
        for (int i = 0; i < this.qy.length; ++i) {
            for (int j = 0; j < this.qy[i].length; ++j) {
                if (this.qz[i][j]) {
                    max = Math.max(max, j + 1);
                    max2 = Math.max(max2, i + 1);
                }
            }
        }
        return new Dimension(max, max2);
    }
    
    public Dimension dn() {
        return new Dimension(this.qz[0].length, this.qz.length);
    }
    
    public void a(final int n, final int n2, final int i, final int j) {
        if (!this.qz[n2][n]) {
            throw new RuntimeException("Old slot not enabled");
        }
        if (!this.qz[j][i]) {
            throw new RuntimeException("New slot not enabled");
        }
        final eV d = this.qt.d("Slots");
        if (this.qy[j][i] != null) {
            d.g(this.qy[j][i]);
        }
        if (this.qy[n2][n] == null) {
            this.qy[j][i] = null;
        }
        else {
            final eY be = this.qy[n2][n].bE();
            be.b("Index.X", i);
            be.b("Index.Y", j);
            d.f(be);
            this.qy[j][i] = be;
        }
    }
    
    public void b(final int i, final int j, final int k, final int l) {
        if (!this.qz[j][i]) {
            throw new RuntimeException("Old slot not enabled");
        }
        if (!this.qz[l][k]) {
            throw new RuntimeException("New slot not enabled");
        }
        final eY ey = this.qy[j][i];
        final eY ey2 = this.qy[l][k];
        if (ey != null && ey2 != null && ey.getValue("Id").equals(ey2.getValue("Id"))) {
            final int m = ey2.J("MaxAmount");
            final int i2 = ey.J("Amount") + ey2.J("Amount");
            if (i2 <= m) {
                ey2.b("Amount", i2);
                this.g(i, j);
            }
            else {
                ey2.b("Amount", m);
                ey.b("Amount", i2 - m);
            }
            return;
        }
        if (ey != null) {
            ey.b("Index", new fa().d("X", k).d("Y", l).bH());
        }
        this.qy[l][k] = ey;
        if (ey2 != null) {
            ey2.b("Index", new fa().d("X", i).d("Y", j).bH());
        }
        this.qy[j][i] = ey2;
    }
    
    public void c(final int i, final int j, final int k, final int l) {
        if (!this.qz[j][i]) {
            throw new RuntimeException("Old slot not enabled");
        }
        if (!this.qz[l][k]) {
            throw new RuntimeException("New slot not enabled");
        }
        final eY ey = this.qy[j][i];
        final eY ey2 = this.qy[l][k];
        if (ey != null) {
            ey.b("Index", new fa().d("X", k).d("Y", l).bH());
        }
        this.qy[l][k] = ey;
        if (ey2 != null) {
            ey2.b("Index", new fa().d("X", i).d("Y", j).bH());
        }
        this.qy[j][i] = ey2;
    }
    
    public gu f(final int n, final int n2) {
        if (this.qy[n2][n] == null) {
            return null;
        }
        return new gu(this, this.qy[n2][n], null);
    }
    
    public void az(final int n) {
        final eV d = this.qt.d("Slots");
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (v.getValueAsString("Type.InventoryType").equals("Technology")) {
                final ey d2 = ey.d(v.getValue("Id"));
                if (d2 == null || (a(d2.bc()) & n) == 0x0) {
                    final int j = v.J("Index.X");
                    final int k = v.J("Index.Y");
                    if (k < this.qy.length && j < this.qy[k].length) {
                        this.qy[k][j] = null;
                    }
                    d.ac(i--);
                }
            }
        }
    }
    
    public boolean g(final int n, final int n2) {
        if (this.qy[n2][n] == null) {
            return false;
        }
        final eV d = this.qt.d("Slots");
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (n == v.J("Index.X") && n2 == v.J("Index.Y")) {
                d.ac(i);
            }
        }
        this.qy[n2][n] = null;
        return true;
    }
    
    public boolean a(final int n, final int n2, final gt gt) {
        if (this.qy[n2][n] == null) {
            return false;
        }
        final String valueAsString = this.qy[n2][n].getValueAsString("Type.InventoryType");
        final Object value = this.qy[n2][n].getValue("Id");
        int j = this.qy[n2][n].J("Amount");
        final double l = this.qy[n2][n].L("DamageFactor");
        final boolean m = this.qy[n2][n].M("FullyInstalled");
        boolean b = false;
        if (valueAsString.equals("Technology")) {
            final int i = this.qy[n2][n].J("MaxAmount");
            for (int k = 0; k < gt.qy.length; ++k) {
                for (int n3 = 0; n3 < gt.qy[k].length; ++n3) {
                    if (gt.qy[k][n3] == null && gt.qz[k][n3] && !gt.l(n3, k)) {
                        gt.a(n3, k, valueAsString, value, j, i, l, m);
                        j = 0;
                        b = true;
                        break;
                    }
                }
                if (j == 0) {
                    break;
                }
            }
        }
        if (j > 0 && !valueAsString.equals("Technology")) {
            for (int n4 = 0; n4 < gt.qy.length; ++n4) {
                for (int n5 = 0; n5 < gt.qy[n4].length; ++n5) {
                    if (gt.qy[n4][n5] != null && valueAsString.equals(gt.qy[n4][n5].getValueAsString("Type.InventoryType")) && value.equals(gt.qy[n4][n5].getValue("Id"))) {
                        final int j2 = gt.qy[n4][n5].J("Amount");
                        final int j3 = gt.qy[n4][n5].J("MaxAmount");
                        if (j2 < j3) {
                            final int i2 = (j > j3 - j2) ? (j3 - j2) : j;
                            hc.info("  added to existing stack: " + i2);
                            gt.qy[n4][n5].b("Amount", new Integer(j2 + i2));
                            j -= i2;
                            b = true;
                            if (j == 0) {
                                break;
                            }
                        }
                    }
                }
                if (j == 0) {
                    break;
                }
            }
        }
        if (j > 0 && !valueAsString.equals("Technology")) {
            final ey d = ey.d(this.qy[n2][n].getValue("Id"));
            int n6;
            if (valueAsString.equals("Technology")) {
                n6 = this.qy[n2][n].J("MaxAmount");
            }
            else if (valueAsString.equals("Substance")) {
                if (d == null) {
                    n6 = gt.bE;
                }
                else {
                    n6 = Math.max(1, gt.bE * d.bj());
                }
            }
            else if (valueAsString.equals("Product")) {
                if (d == null) {
                    n6 = gt.bF;
                }
                else {
                    n6 = Math.max(1, gt.bF * d.bj());
                }
            }
            else {
                n6 = 1;
            }
            for (int n7 = 0; n7 < gt.qy.length; ++n7) {
                for (int n8 = 0; n8 < gt.qy[n7].length; ++n8) {
                    if (gt.qy[n7][n8] == null && gt.qz[n7][n8] && !gt.l(n8, n7)) {
                        final int i3 = (j > n6) ? n6 : j;
                        hc.info("  new stack: " + i3);
                        gt.a(n8, n7, valueAsString, value, i3, n6, l, m);
                        j -= i3;
                        b = true;
                        if (j == 0) {
                            break;
                        }
                    }
                }
                if (j == 0) {
                    break;
                }
            }
        }
        if (!b) {
            return false;
        }
        if (j == 0) {
            final eV d2 = this.qt.d("Slots");
            for (int n9 = 0; n9 < d2.size(); ++n9) {
                final eY v = d2.V(n9);
                if (n == v.J("Index.X") && n2 == v.J("Index.Y")) {
                    d2.ac(n9);
                }
            }
            this.qy[n2][n] = null;
        }
        else {
            hc.info("  remainder: " + j);
            this.qy[n2][n].b("Amount", new Integer(j));
        }
        return true;
    }
    
    public int a(final ey ey, int n) {
        int n2 = 0;
        String s = null;
        switch (dy()[ey.ba().ordinal()]) {
            case 1: {
                return n;
            }
            case 3: {
                n2 = Math.max(1, this.bE * ey.bj());
                s = "Substance";
                break;
            }
            case 2: {
                n2 = Math.max(1, this.bF * ey.bj());
                s = "Product";
                break;
            }
            case 4: {
                n2 = Math.max(1, this.bF * ey.bj());
                s = "Techbox";
                break;
            }
            default: {
                return n;
            }
        }
        if (n > 0) {
            for (int i = 0; i < this.qy.length; ++i) {
                for (int j = 0; j < this.qy[i].length; ++j) {
                    if (this.qy[i][j] != null && s.equals(this.qy[i][j].getValueAsString("Type.InventoryType")) && ey.getID().equals(this.qy[i][j].getValue("Id"))) {
                        final int k = this.qy[i][j].J("Amount");
                        final int l = this.qy[i][j].J("MaxAmount");
                        if (k < l) {
                            final int m = (n > l - k) ? (l - k) : n;
                            hc.info("  added to existing stack: " + m);
                            this.qy[i][j].b("Amount", new Integer(k + m));
                            n -= m;
                            if (n == 0) {
                                break;
                            }
                        }
                    }
                }
                if (n == 0) {
                    break;
                }
            }
        }
        if (n > 0) {
            final Object az = ey.aZ();
            for (int n3 = 0; n3 < this.qy.length; ++n3) {
                for (int n4 = 0; n4 < this.qy[n3].length; ++n4) {
                    if (this.qy[n3][n4] == null && this.qz[n3][n4] && !this.l(n4, n3)) {
                        final int i2 = (n > n2) ? n2 : n;
                        hc.info("  new stack: " + i2);
                        this.a(n4, n3, s, az, i2, n2, 0.0, true);
                        n -= i2;
                        if (n == 0) {
                            break;
                        }
                    }
                }
                if (n == 0) {
                    break;
                }
            }
        }
        return n;
    }
    
    public boolean a(final int n, final int n2, final ey ey) {
        if (this.qy[n2][n] != null) {
            return false;
        }
        int n3 = 0;
        int intValue = 0;
        switch (dy()[ey.ba().ordinal()]) {
            case 1: {
                final Integer bf = ey.bf();
                if (bf == null) {
                    n3 = -1;
                    intValue = 1;
                    break;
                }
                n3 = bf;
                intValue = bf;
                break;
            }
            case 3: {
                intValue = (n3 = Math.max(1, this.bE * ey.bj()));
                break;
            }
            case 2: {
                intValue = (n3 = Math.max(1, this.bF * ey.bj()));
                break;
            }
            case 4: {
                intValue = (n3 = Math.max(1, this.bF * ey.bj()));
                break;
            }
            default: {
                return false;
            }
        }
        this.a(n, n2, ey.ba().toString(), ey.aZ(), n3, intValue, 0.0, true);
        return true;
    }
    
    private void a(final int i, final int j, final String s, final Object o, final int value, final int value2, final double value3, final boolean value4) {
        final eV d = this.qt.d("Slots");
        final eY az = gR.az("slot");
        az.b("Type.InventoryType", s);
        az.b("Id", o);
        az.b("Amount", new Integer(value));
        az.b("MaxAmount", new Integer(value2));
        az.b("DamageFactor", new Double(value3));
        az.b("FullyInstalled", new Boolean(value4));
        az.b("Index.X", i);
        az.b("Index.Y", j);
        d.f(az);
        this.qy[j][i] = az;
    }
    
    public boolean aq(final String s) {
        for (int i = 0; i < this.qy.length; ++i) {
            for (int j = 0; j < this.qy[i].length; ++j) {
                if (this.qy[i][j] != null && s.equals(this.qy[i][j].getValue("Type"))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean h(final int n, final int n2) {
        return this.qz[n2][n];
    }
    
    public void i(final int i, final int j) {
        if (!this.qz[j][i]) {
            final eY ey = new eY();
            ey.b("X", i);
            ey.b("Y", j);
            this.qt.d("ValidSlotIndices").f(ey);
            this.qz[j][i] = true;
        }
    }
    
    public void j(final int n, final int n2) {
        if (this.qz[n2][n]) {
            if (this.qy[n2][n] != null) {
                throw new RuntimeException("Cannot disable slot in use");
            }
            final eV d = this.qt.d("ValidSlotIndices");
            for (int i = 0; i < d.size(); ++i) {
                final eY v = d.V(i);
                if (n == v.J("X") && n2 == v.J("Y")) {
                    d.ac(i);
                }
            }
            this.qz[n2][n] = false;
        }
    }
    
    public boolean do() {
        return this.qu;
    }
    
    public boolean dp() {
        return this.qw;
    }
    
    public boolean dq() {
        return this.qx;
    }
    
    public boolean k(final int n, final int n2) {
        final eV d = this.qt.d("SpecialSlots");
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (v.J("Index.X") == n && v.J("Index.Y") == n2) {
                return "TechBonus".equals(v.getValueAsString("Type.InventorySpecialSlotType"));
            }
        }
        return false;
    }
    
    public void a(final int i, final int j, final boolean b) {
        final eV d = this.qt.d("SpecialSlots");
        for (int k = 0; k < d.size(); ++k) {
            final eY v = d.V(k);
            if (v.J("Index.X") == i && v.J("Index.Y") == j) {
                if (!b) {
                    d.ac(k);
                }
                else {
                    v.b("Type.InventorySpecialSlotType", "TechBonus");
                }
                return;
            }
        }
        if (b) {
            final eY az = gR.az("specialSlot");
            az.b("Type.InventorySpecialSlotType", "TechBonus");
            az.b("Index.X", i);
            az.b("Index.Y", j);
            d.f(az);
        }
    }
    
    public boolean dr() {
        final boolean[][] array = new boolean[this.height][this.width];
        final eV d = this.qt.d("SpecialSlots");
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            final int j = v.J("Index.X");
            final int k = v.J("Index.Y");
            if (j < this.width && k < this.height) {
                array[k][j] = "TechBonus".equals(v.getValueAsString("Type.InventorySpecialSlotType"));
            }
        }
        boolean b = false;
        for (int l = 0; l < this.height; ++l) {
            for (int m = 0; m < this.width; ++m) {
                if (!array[l][m]) {
                    final eY az = gR.az("specialSlot");
                    az.b("Type.InventorySpecialSlotType", "TechBonus");
                    az.b("Index.X", m);
                    az.b("Index.Y", l);
                    d.f(az);
                    b = true;
                }
            }
        }
        return b;
    }
    
    public boolean l(final int i, final int j) {
        final eV d = this.qt.d("SpecialSlots");
        int k = 0;
        while (k < d.size()) {
            final eY v = d.V(k);
            if ("Broken".equals(v.getValueAsString("Type.InventorySpecialSlotType")) && i == v.J("Index.X") && j == v.J("Index.Y")) {
                return true;
            }
            if ("BlockedByBrokenTech".equals(v.getValueAsString("Type.InventorySpecialSlotType")) && i == v.J("Index.X") && j == v.J("Index.Y")) {
                final gu f;
                if ((f = this.f(i, j)) == null || f.dC() == 0.0) {
                    hc.info(String.valueOf(this.getFullName()) + " slot[" + i + "," + j + "] appears to be broken, ignoring");
                    return false;
                }
                return true;
            }
            else {
                ++k;
            }
        }
        return false;
    }
    
    public void m(final int n, final int n2) {
        final eV d = this.qt.d("SpecialSlots");
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if ("Broken".equals(v.getValueAsString("Type.InventorySpecialSlotType")) && n == v.J("Index.X") && n2 == v.J("Index.Y")) {
                d.ac(i);
            }
            if ("BlockedByBrokenTech".equals(v.getValueAsString("Type.InventorySpecialSlotType")) && n == v.J("Index.X") && n2 == v.J("Index.Y")) {
                final gu f;
                if ((f = this.f(n, n2)) != null && f.dC() != 0.0) {
                    this.g(n, n2);
                }
                d.ac(i);
            }
        }
    }
    
    public boolean ds() {
        boolean b = false;
        final eV d = this.qt.d("SpecialSlots");
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if ("Broken".equals(v.getValueAsString("Type.InventorySpecialSlotType"))) {
                d.ac(i--);
                b = true;
            }
            if ("BlockedByBrokenTech".equals(v.getValueAsString("Type.InventorySpecialSlotType"))) {
                final gu f;
                if ((f = this.f(v.J("Index.X"), v.J("Index.Y"))) != null && f.dC() != 0.0) {
                    this.g(v.J("Index.X"), v.J("Index.Y"));
                }
                d.ac(i--);
                b = true;
            }
        }
        for (int j = 0; j < this.qy.length; ++j) {
            for (int k = 0; k < this.qy[j].length; ++k) {
                if (this.qy[j][k] != null) {
                    if (this.qy[j][k].L("DamageFactor") != 0.0) {
                        this.qy[j][k].b("DamageFactor", new Double(0.0));
                        this.qy[j][k].b("FullyInstalled", new Boolean(true));
                        b = true;
                    }
                }
            }
        }
        return b;
    }
    
    private static String l(final Object o) {
        final StringBuffer sb = new StringBuffer();
        sb.append(' ');
        if (o instanceof fg) {
            sb.append(((fg)o).bP());
        }
        else if (o != null) {
            sb.append(o.toString());
        }
        if (sb.length() > 10) {
            sb.delete(10, sb.length());
        }
        while (sb.length() < 11) {
            sb.append(' ');
        }
        return sb.toString();
    }
    
    public void a(final PrintStream printStream) {
        printStream.print("\t|");
        for (int i = 0; i < this.qy[0].length; ++i) {
            printStream.print("-----------|");
        }
        printStream.println();
        for (int j = 0; j < this.qy.length; ++j) {
            printStream.print("\t|");
            for (int k = 0; k < this.qy[0].length; ++k) {
                if (!this.qz[j][k]) {
                    printStream.print("###########|");
                }
                else if (this.qy[j][k] != null) {
                    printStream.print(String.valueOf(l(r(this.qy[j][k]))) + "|");
                }
                else {
                    printStream.print("           |");
                }
            }
            printStream.println();
            printStream.print("\t|");
            for (int l = 0; l < this.qy[j].length; ++l) {
                if (!this.qz[j][l]) {
                    printStream.print("###########|");
                }
                else if (this.qy[j][l] != null) {
                    printStream.print(String.valueOf(l(s(this.qy[j][l]))) + "|");
                }
                else {
                    printStream.print("           |");
                }
            }
            printStream.println();
            printStream.print("\t|");
            for (int n = 0; n < this.qy[0].length; ++n) {
                if (!this.qz[j][n]) {
                    printStream.print("###########|");
                }
                else if (this.qy[j][n] != null) {
                    final int t = t(this.qy[j][n]);
                    if (t < 0) {
                        printStream.print("           |");
                    }
                    else {
                        printStream.print(String.valueOf(l(new StringBuilder(String.valueOf(Integer.toString(t))).append("/").append(Integer.toString(u(this.qy[j][n]))).toString())) + "|");
                    }
                }
                else {
                    printStream.print("           |");
                }
            }
            printStream.println();
            printStream.print("\t|");
            for (int n2 = 0; n2 < this.qy[0].length; ++n2) {
                printStream.print("-----------|");
            }
            printStream.println();
        }
    }
    
    private static String r(final eY ey) {
        return ey.getValueAsString("Type.InventoryType");
    }
    
    private static Object s(final eY ey) {
        return ey.getValue("Id");
    }
    
    private static int t(final eY ey) {
        return ey.J("Amount");
    }
    
    private static int u(final eY ey) {
        return ey.J("MaxAmount");
    }
    
    public boolean dt() {
        boolean b = false;
        for (int i = 0; i < this.qy.length; ++i) {
            for (int j = 0; j < this.qy[i].length; ++j) {
                if (this.qy[i][j] != null) {
                    final int k;
                    if ("Technology".equals(this.qy[i][j].getValueAsString("Type.InventoryType")) && this.qy[i][j].J("Amount") >= 0 && (k = this.qy[i][j].J("MaxAmount")) > 0) {
                        this.qy[i][j].b("Amount", new Integer(k));
                        b = true;
                    }
                }
            }
        }
        return b;
    }
    
    public boolean du() {
        boolean b = false;
        for (int i = 0; i < this.qy.length; ++i) {
            for (int j = 0; j < this.qy[i].length; ++j) {
                if (this.qy[i][j] != null) {
                    final int k;
                    if (!"Technology".equals(this.qy[i][j].getValueAsString("Type.InventoryType")) && (k = this.qy[i][j].J("MaxAmount")) > 1) {
                        this.qy[i][j].b("Amount", new Integer(k));
                        b = true;
                    }
                }
            }
        }
        return b;
    }
    
    public boolean dv() {
        boolean b = false;
        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                if (!this.qz[i][j]) {
                    final eY ey = new eY();
                    ey.b("X", j);
                    ey.b("Y", i);
                    this.qt.d("ValidSlotIndices").f(ey);
                    this.qz[i][j] = true;
                    b = true;
                }
            }
        }
        return b;
    }
    
    @Override
    public String toString() {
        return this.getFullName();
    }
    
    static /* synthetic */ int[] dw() {
        final int[] qa = gt.qA;
        if (qa != null) {
            return qa;
        }
        final int[] qa2 = new int[ex.values().length];
        try {
            qa2[ex.jq.ordinal()] = 32;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            qa2[ex.js.ordinal()] = 34;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            qa2[ex.jv.ordinal()] = 37;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            qa2[ex.jt.ordinal()] = 35;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        try {
            qa2[ex.jo.ordinal()] = 30;
        }
        catch (final NoSuchFieldError noSuchFieldError5) {}
        try {
            qa2[ex.iX.ordinal()] = 13;
        }
        catch (final NoSuchFieldError noSuchFieldError6) {}
        try {
            qa2[ex.iN.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError7) {}
        try {
            qa2[ex.iT.ordinal()] = 9;
        }
        catch (final NoSuchFieldError noSuchFieldError8) {}
        try {
            qa2[ex.iU.ordinal()] = 10;
        }
        catch (final NoSuchFieldError noSuchFieldError9) {}
        try {
            qa2[ex.jA.ordinal()] = 42;
        }
        catch (final NoSuchFieldError noSuchFieldError10) {}
        try {
            qa2[ex.iW.ordinal()] = 12;
        }
        catch (final NoSuchFieldError noSuchFieldError11) {}
        try {
            qa2[ex.iZ.ordinal()] = 15;
        }
        catch (final NoSuchFieldError noSuchFieldError12) {}
        try {
            qa2[ex.iQ.ordinal()] = 6;
        }
        catch (final NoSuchFieldError noSuchFieldError13) {}
        try {
            qa2[ex.ja.ordinal()] = 16;
        }
        catch (final NoSuchFieldError noSuchFieldError14) {}
        try {
            qa2[ex.iR.ordinal()] = 7;
        }
        catch (final NoSuchFieldError noSuchFieldError15) {}
        try {
            qa2[ex.jc.ordinal()] = 18;
        }
        catch (final NoSuchFieldError noSuchFieldError16) {}
        try {
            qa2[ex.iP.ordinal()] = 5;
        }
        catch (final NoSuchFieldError noSuchFieldError17) {}
        try {
            qa2[ex.jk.ordinal()] = 26;
        }
        catch (final NoSuchFieldError noSuchFieldError18) {}
        try {
            qa2[ex.iL.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError19) {}
        try {
            qa2[ex.jz.ordinal()] = 41;
        }
        catch (final NoSuchFieldError noSuchFieldError20) {}
        try {
            qa2[ex.jx.ordinal()] = 39;
        }
        catch (final NoSuchFieldError noSuchFieldError21) {}
        try {
            qa2[ex.iM.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError22) {}
        try {
            qa2[ex.jj.ordinal()] = 25;
        }
        catch (final NoSuchFieldError noSuchFieldError23) {}
        try {
            qa2[ex.jb.ordinal()] = 17;
        }
        catch (final NoSuchFieldError noSuchFieldError24) {}
        try {
            qa2[ex.jr.ordinal()] = 33;
        }
        catch (final NoSuchFieldError noSuchFieldError25) {}
        try {
            qa2[ex.jw.ordinal()] = 38;
        }
        catch (final NoSuchFieldError noSuchFieldError26) {}
        try {
            qa2[ex.jp.ordinal()] = 31;
        }
        catch (final NoSuchFieldError noSuchFieldError27) {}
        try {
            qa2[ex.jB.ordinal()] = 43;
        }
        catch (final NoSuchFieldError noSuchFieldError28) {}
        try {
            qa2[ex.jl.ordinal()] = 27;
        }
        catch (final NoSuchFieldError noSuchFieldError29) {}
        try {
            qa2[ex.jy.ordinal()] = 40;
        }
        catch (final NoSuchFieldError noSuchFieldError30) {}
        try {
            qa2[ex.iY.ordinal()] = 14;
        }
        catch (final NoSuchFieldError noSuchFieldError31) {}
        try {
            qa2[ex.ji.ordinal()] = 24;
        }
        catch (final NoSuchFieldError noSuchFieldError32) {}
        try {
            qa2[ex.jn.ordinal()] = 29;
        }
        catch (final NoSuchFieldError noSuchFieldError33) {}
        try {
            qa2[ex.jg.ordinal()] = 22;
        }
        catch (final NoSuchFieldError noSuchFieldError34) {}
        try {
            qa2[ex.ju.ordinal()] = 36;
        }
        catch (final NoSuchFieldError noSuchFieldError35) {}
        try {
            qa2[ex.je.ordinal()] = 20;
        }
        catch (final NoSuchFieldError noSuchFieldError36) {}
        try {
            qa2[ex.iS.ordinal()] = 8;
        }
        catch (final NoSuchFieldError noSuchFieldError37) {}
        try {
            qa2[ex.iO.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError38) {}
        try {
            qa2[ex.jh.ordinal()] = 23;
        }
        catch (final NoSuchFieldError noSuchFieldError39) {}
        try {
            qa2[ex.jd.ordinal()] = 19;
        }
        catch (final NoSuchFieldError noSuchFieldError40) {}
        try {
            qa2[ex.iV.ordinal()] = 11;
        }
        catch (final NoSuchFieldError noSuchFieldError41) {}
        try {
            qa2[ex.jm.ordinal()] = 28;
        }
        catch (final NoSuchFieldError noSuchFieldError42) {}
        try {
            qa2[ex.jf.ordinal()] = 21;
        }
        catch (final NoSuchFieldError noSuchFieldError43) {}
        return gt.qA = qa2;
    }
    
    static /* synthetic */ int[] dx() {
        final int[] qb = gt.qB;
        if (qb != null) {
            return qb;
        }
        final int[] qb2 = new int[fn.values().length];
        try {
            qb2[fn.lp.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            qb2[fn.lo.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            qb2[fn.lt.ordinal()] = 8;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            qb2[fn.lr.ordinal()] = 6;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        try {
            qb2[fn.lm.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError5) {}
        try {
            qb2[fn.lq.ordinal()] = 5;
        }
        catch (final NoSuchFieldError noSuchFieldError6) {}
        try {
            qb2[fn.ls.ordinal()] = 7;
        }
        catch (final NoSuchFieldError noSuchFieldError7) {}
        try {
            qb2[fn.ln.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError8) {}
        return gt.qB = qb2;
    }
    
    static /* synthetic */ int[] dy() {
        final int[] qc = gt.qC;
        if (qc != null) {
            return qc;
        }
        final int[] qc2 = new int[eB.values().length];
        try {
            qc2[eB.jO.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            qc2[eB.jP.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            qc2[eB.jQ.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            qc2[eB.jN.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        return gt.qC = qc2;
    }
}
