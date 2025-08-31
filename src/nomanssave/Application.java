// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.JComponent;
import javax.swing.Icon;
import java.awt.event.ComponentListener;
import java.awt.event.WindowListener;
import java.awt.Rectangle;
import javax.swing.SwingUtilities;
import java.awt.Window;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.ArrayList;
import java.awt.Container;
import java.util.Iterator;
import java.util.Map;
import java.security.GeneralSecurityException;
import java.io.File;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.io.InputStream;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import java.util.HashMap;

public class Application
{
    public static final String VERSION = "1.19.0";
    public static final String RELEASE = "VOYAGERS";
    private static final String J = "https://github.com/goatfungus/NMSSaveEditor";
    private static final String K = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
    private static Application L;
    private static HashMap M;
    private JFrame N;
    private JTabbedPane O;
    private JLabel P;
    private JLabel Q;
    private JComboBox R;
    private JComboBox S;
    private JLabel T;
    private JLabel U;
    private JLabel V;
    private JButton W;
    private JButton X;
    private JButton Y;
    private JMenuItem Z;
    private JMenuItem aa;
    private JMenuItem ab;
    private List ac;
    private JMenuItem ad;
    private static final int ae = 0;
    private static final int af = 1;
    private static final int ag = 2;
    private static final int ah = 3;
    private static final int ai = 4;
    private static final int aj = 5;
    private static final int ak = 6;
    private static final int al = 7;
    private static final int am = 8;
    private static final int an = 9;
    private static final int ao = 10;
    private static final int ap = 11;
    private static final int aq = 12;
    private static final int ar = 13;
    private aJ as;
    private dj at;
    private dN au;
    private eb av;
    private bd aw;
    private bl ax;
    private ep ay;
    private X az;
    private I aA;
    private dE aB;
    private ap aC;
    private bE aD;
    private c aE;
    private fq aF;
    private ft[] aG;
    private int aH;
    private fs[] aI;
    private int aJ;
    private eY aK;
    private boolean aL;
    private fr aM;
    private eY aN;
    private boolean aO;
    private boolean aP;
    private boolean aQ;
    private boolean aR;
    private boolean aS;
    private boolean aT;
    private boolean aU;
    private fe aV;
    private fe aW;
    private fR aX;
    private static /* synthetic */ int[] aY;
    
    static {
        Application.M = new HashMap();
    }
    
    public static String a(final long date) {
        return new SimpleDateFormat("h:mm a, E MMM d, yyyy").format(new Date(date));
    }
    
    public static String b(final long date) {
        return new SimpleDateFormat("MMM d, HH:mm").format(new Date(date));
    }
    
    private static String a(final String s, final String s2) {
        if (s == null) {
            return s2;
        }
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_".indexOf(char1) >= 0) {
                sb.append(char1);
            }
            else if (Character.isWhitespace(char1)) {
                sb.append('_');
            }
        }
        return (sb.length() != 0) ? sb.toString() : s2;
    }
    
    public static Application e() {
        return Application.L;
    }
    
    public static void main(final String[] array) {
        int n = 0;
        boolean b;
        if (array.length > n && array[n].equals("-autoupdate")) {
            ++n;
            b = true;
        }
        else {
            b = false;
        }
        aH.init(!b);
        hc.info("Starting Editor...");
        new Thread(() -> cK.aA()).start();
        EventQueue.invokeLater(new w(b));
    }
    
    public static ImageIcon a(final String str) {
        BufferedImage read = Application.M.get(str);
        if (read == null) {
            final InputStream resourceAsStream = Application.class.getResourceAsStream("icons/" + str);
            if (resourceAsStream != null) {
                try {
                    read = ImageIO.read(resourceAsStream);
                    Application.M.put(str, read);
                }
                catch (final IOException ex) {
                    hc.info("Error loading icon: " + str);
                }
                catch (final RuntimeException ex2) {
                    hc.info("Error loading icon: " + str);
                }
            }
        }
        return (read == null) ? null : new ImageIcon(read);
    }
    
    public static ImageIcon a(final String str, final int width, final int height) {
        BufferedImage read = Application.M.get(str);
        if (read == null) {
            final InputStream resourceAsStream = Application.class.getResourceAsStream("icons/" + str);
            if (resourceAsStream != null) {
                try {
                    read = ImageIO.read(resourceAsStream);
                    Application.M.put(str, read);
                }
                catch (final IOException ex) {
                    hc.info("Error loading icon: " + str);
                }
                catch (final RuntimeException ex2) {
                    hc.info("Error loading icon: " + str);
                }
            }
        }
        return (read == null) ? null : new ImageIcon(read.getScaledInstance(width, height, 4));
    }
    
    private void f() {
        if (this.aR) {
            this.aR = false;
        }
        if (this.aS) {
            this.aS = false;
            final int n = (this.aH < 0) ? -1 : this.aG[this.aH].getIndex();
            this.aG = Arrays.asList(this.aF.bU()).stream().filter(ft -> ft.getIndex() == n3 || !ft.isEmpty()).toArray(ft[]::new);
            this.aH = -1;
            for (int i = 0; i < this.aG.length; ++i) {
                if (this.aG[i].getIndex() == n) {
                    this.aH = i;
                    break;
                }
            }
            if (n >= 0 && this.aH < 0) {
                hc.warn("Slot " + (n + 1) + " was not reloaded!");
                this.aI = new fs[0];
                this.aJ = -1;
            }
            this.R.updateUI();
        }
        this.aT &= (this.aH >= 0);
        if (this.aT) {
            this.aT = false;
            final String anObject = (this.aJ < 0) ? null : this.aI[this.aJ].K();
            final long n2 = (this.aJ < 0) ? Long.MIN_VALUE : this.aI[this.aJ].lastModified();
            final fn fn = (this.aJ < 0) ? null : this.aI[this.aJ].L();
            this.aI = this.aG[this.aH].bX();
            this.aJ = -1;
            for (int j = 0; j < this.aI.length; ++j) {
                if (this.aI[j].K().equals(anObject)) {
                    this.aJ = j;
                    break;
                }
            }
            if (anObject != null && this.aJ < 0) {
                this.aU = false;
                if (JOptionPane.showConfirmDialog(this.N, "Save file has been deleted externally. Would you like to reload?\nNOTE: All changes made in the editor will be lost.", "Reload File", 0) == 0) {
                    this.aJ = 0;
                    this.l();
                }
                else {
                    final fs[] ai = new fs[this.aI.length + 1];
                    ai[0] = new F(this, anObject, n2, fn, this.aK);
                    System.arraycopy(this.aI, 0, ai, 1, this.aI.length);
                    this.aI = ai;
                    this.aJ = 0;
                }
            }
            this.S.updateUI();
        }
        this.aU &= (this.aJ >= 0);
        if (this.aU) {
            this.aU = false;
            if (JOptionPane.showConfirmDialog(this.N, "Save file has been modified externally. Would you like to reload?\nNOTE: All changes made in the editor will be lost.", "Reload File", 0) == 0) {
                this.l();
            }
            else {
                this.aL = true;
            }
        }
    }
    
    private Application(final boolean b) {
        this.aQ = false;
        this.aR = false;
        this.aS = false;
        this.aT = false;
        this.aU = false;
        this.aV = ((s2, p1, o3) -> {
            this.aO = true;
            this.aP = true;
            if (o3 == null) {
                hc.info("Removing " + s2);
                return;
            }
            else {
                String string;
                if (o3 instanceof eY) {
                    string = "[OBJECT]";
                }
                else if (o3 instanceof eV) {
                    string = "[ARRAY]";
                }
                else {
                    string = o3.toString();
                }
                hc.info("Setting " + s2 + ": " + string);
                return;
            }
        });
        this.aW = ((s4, p1, o6) -> {
            this.aL = true;
            if (s4.startsWith("PlayerStateData.Multitools")) {
                this.aK.J("PlayerStateData.ActiveMultioolIndex");
                final int n;
                if (s4.startsWith("PlayerStateData.Multitools[" + n + "].Store.")) {
                    this.aK.b("PlayerStateData.WeaponInventory", (Object)this.aK.H("PlayerStateData.Multitools[" + n + "].Store").bE());
                }
                else if (s4.equals("PlayerStateData.Multitools[" + n + "].Seed[1]")) {
                    this.aK.b("PlayerStateData.CurrentWeapon.GenerationSeed[1]", o6);
                }
                else if (s4.equals("PlayerStateData.Multitools[" + n + "].Resource.Filename")) {
                    this.aK.b("PlayerStateData.CurrentWeapon.Filename", o6);
                }
            }
            if (o6 == null) {
                hc.info("Removing " + s4);
                return;
            }
            else {
                String str2;
                if (o6 instanceof eY) {
                    str2 = "OBJECT";
                }
                else if (o6 instanceof eV) {
                    str2 = "ARRAY[" + ((eV)o6).size() + "]";
                }
                else {
                    str2 = fh.b(o6, false);
                }
                hc.info("Setting " + s4 + ": " + str2);
                return;
            }
        });
        this.aX = new u(this);
        String str = nomanssave.aH.getProperty("GameStorage");
        final String property = nomanssave.aH.getProperty("GameSaveDir");
        this.aF = ((property == null) ? null : fq.a(str, new File(property), this.aX));
        if (this.aF == null) {
            this.aG = new ft[0];
            this.aH = -1;
            this.aI = new fs[0];
            this.aJ = -1;
            this.aM = null;
            this.aN = null;
        }
        else {
            this.aG = this.aF.bV();
            this.aH = -1;
            this.aI = new fs[0];
            this.aJ = -1;
            if (str == null) {
                str = fq.c(this.aF);
                nomanssave.aH.setProperty("GameStorage", str);
            }
            hc.debug("Storage: " + str);
            hc.debug("Save Path: " + this.aF.bS().getAbsolutePath());
            this.aM = null;
            this.aN = null;
            try {
                hc.info("Reading account data...");
                this.aM = this.aF.bT();
                this.aN = ((this.aM == null) ? null : this.aM.M());
                if (this.aN != null) {
                    this.aN.a(this.aV);
                }
            }
            catch (final IOException ex) {
                hc.a("Error reading account data", ex);
            }
        }
        this.initialize();
        new x(this, b).start();
    }
    
    public JFrame g() {
        return this.N;
    }
    
    public void a(final gH gh) {
        File file = nomanssave.aH.cF;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        final cT ac = cT.aC();
        final String a = a(gh.getName(), "Ship");
        ac.setCurrentDirectory(file);
        ac.setSelectedFile(new File(file, a));
        if (ac.showSaveDialog(this.N) == 0) {
            try {
                File selectedFile = ac.getSelectedFile();
                if (!selectedFile.getName().endsWith(".sh0")) {
                    selectedFile = new File(selectedFile.getParentFile(), String.valueOf(selectedFile.getName()) + ".sh0");
                }
                gh.a(selectedFile, ac.aw());
            }
            catch (final RuntimeException ex) {
                hc.a("Ship export error", ex);
                this.c("An error occured during export.");
            }
            catch (final IOException ex2) {
                hc.a("Ship export error", ex2);
                this.c("An error occured during export.");
            }
        }
    }
    
    public void a(final gv gv) {
        File file = nomanssave.aH.cF;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        final cv ax = cv.ax();
        final String a = a(gv.getName(), "Weapon");
        ax.setCurrentDirectory(file);
        ax.setSelectedFile(new File(file, a));
        if (ax.showSaveDialog(this.N) == 0) {
            try {
                File selectedFile = ax.getSelectedFile();
                if (!selectedFile.getName().endsWith(".wp0")) {
                    selectedFile = new File(selectedFile.getParentFile(), String.valueOf(selectedFile.getName()) + ".wp0");
                }
                gv.j(selectedFile);
            }
            catch (final RuntimeException ex) {
                hc.a("Weapon export error", ex);
                this.c("An error occured during export.");
            }
            catch (final IOException ex2) {
                hc.a("Weapon export error", ex2);
                this.c("An error occured during export.");
            }
        }
    }
    
    public void a(final gj gj) {
        File file = nomanssave.aH.cF;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        final String string = "." + gj.cL().name().toLowerCase();
        final cp at = cp.at();
        final String a = a(gj.getName(), gj.cL().name());
        at.setCurrentDirectory(file);
        at.setSelectedFile(new File(file, a));
        if (at.showSaveDialog(this.N) == 0) {
            try {
                File selectedFile = at.getSelectedFile();
                if (!selectedFile.getName().endsWith(string)) {
                    selectedFile = new File(selectedFile.getParentFile(), String.valueOf(selectedFile.getName()) + string);
                }
                gj.j(selectedFile);
            }
            catch (final RuntimeException ex) {
                hc.a("Companion export error", ex);
                this.c("An error occured during export.");
            }
            catch (final IOException ex2) {
                hc.a("Companion export error", ex2);
                this.c("An error occured during export.");
            }
        }
    }
    
    public gH h() {
        final eY h;
        if (this.aK == null || (h = this.aK.H("PlayerStateData")) == null) {
            return null;
        }
        final File currentDirectory = nomanssave.aH.cF.exists() ? nomanssave.aH.cF : nomanssave.aH.cD;
        final cT ac = cT.aC();
        ac.setCurrentDirectory(currentDirectory);
        if (ac.showOpenDialog(this.N) == 0) {
            try {
                final gH c = gH.c(h, ac.getSelectedFile());
                this.aL = true;
                return c;
            }
            catch (final RuntimeException ex) {
                hc.a("Ship import error", ex);
                this.c("An error occured during import.");
            }
            catch (final IOException ex2) {
                hc.a("Ship import error", ex2);
                this.c("An error occured during import.");
            }
        }
        return null;
    }
    
    public gv i() {
        final eY h;
        if (this.aK == null || (h = this.aK.H("PlayerStateData")) == null) {
            return null;
        }
        final File currentDirectory = nomanssave.aH.cF.exists() ? nomanssave.aH.cF : nomanssave.aH.cD;
        final cv ax = cv.ax();
        ax.setCurrentDirectory(currentDirectory);
        if (ax.showOpenDialog(this.N) == 0) {
            try {
                final gv b = gv.b(h, ax.getSelectedFile());
                this.aL = true;
                return b;
            }
            catch (final RuntimeException ex) {
                hc.a("Weapon import error", ex);
                this.c("An error occured during import.");
            }
            catch (final IOException ex2) {
                hc.a("Weapon import error", ex2);
                this.c("An error occured during import.");
            }
        }
        return null;
    }
    
    public gj j() {
        final eY h;
        if (this.aK == null || (h = this.aK.H("PlayerStateData")) == null) {
            return null;
        }
        final File currentDirectory = nomanssave.aH.cF.exists() ? nomanssave.aH.cF : nomanssave.aH.cD;
        final cp at = cp.at();
        at.setCurrentDirectory(currentDirectory);
        if (at.showOpenDialog(this.N) == 0) {
            try {
                final gj a = gj.a(h, at.getSelectedFile());
                this.aL = true;
                return a;
            }
            catch (final RuntimeException ex) {
                hc.a("Companion import error", ex);
                this.c("An error occured during import.");
            }
            catch (final IOException ex2) {
                hc.a("Companion import error", ex2);
                this.c("An error occured during import.");
            }
        }
        return null;
    }
    
    public void a(final gf gf) {
        File file = nomanssave.aH.cE;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        final cl ar = cl.ar();
        final String a = a(gf.getName(), "Base");
        ar.setCurrentDirectory(file);
        ar.setSelectedFile(new File(file, a));
        if (ar.showSaveDialog(this.N) == 0) {
            try {
                File selectedFile = ar.getSelectedFile();
                if (!selectedFile.getName().endsWith(".pb3")) {
                    selectedFile = new File(selectedFile.getParentFile(), String.valueOf(selectedFile.getName()) + ".pb3");
                }
                if (selectedFile.exists() && JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite this existing backup file?", "Confirm", 2) != 0) {
                    return;
                }
                gS.d(gf.cH(), selectedFile);
            }
            catch (final RuntimeException ex) {
                hc.a("Base backup error", ex);
                this.c("An error occured during backup.");
            }
            catch (final IOException ex2) {
                hc.a("Base backup error", ex2);
                this.c("An error occured during backup.");
            }
            catch (final GeneralSecurityException ex3) {
                hc.a("Base backup error", ex3);
                this.c("An error occured during backup.");
            }
        }
    }
    
    public boolean b(final gf gf) {
        final File currentDirectory = nomanssave.aH.cE.exists() ? nomanssave.aH.cE : nomanssave.aH.cD;
        final cl ar = cl.ar();
        ar.setCurrentDirectory(currentDirectory);
        if (ar.showOpenDialog(this.N) == 0) {
            try {
                if (JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite your existing base?", "Confirm", 2) != 0) {
                    return false;
                }
                gS.e(gf.cH(), ar.getSelectedFile());
                return this.aL = true;
            }
            catch (final IOException ex) {
                hc.a("Base restore error", ex);
                this.c("An error occured during backup.");
            }
            catch (final GeneralSecurityException ex2) {
                hc.a("Base restore error", ex2);
                this.c("An error occured during backup.");
            }
        }
        return false;
    }
    
    public void a(final gm gm) {
        final gn cz = gm.cZ();
        if (cz == null) {
            return;
        }
        File file = nomanssave.aH.cE;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        final cs av = cs.av();
        final String a = a(cz.getName(), "Freighter");
        av.setCurrentDirectory(file);
        av.setSelectedFile(new File(file, a));
        if (av.showSaveDialog(this.N) == 0) {
            try {
                File selectedFile = av.getSelectedFile();
                if (!selectedFile.getName().endsWith(".fb3")) {
                    selectedFile = new File(selectedFile.getParentFile(), String.valueOf(selectedFile.getName()) + ".fb3");
                }
                if (selectedFile.exists() && JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite this existing backup file?", "Confirm", 2) != 0) {
                    return;
                }
                final HashMap hashMap = new HashMap();
                hashMap.put("HomeSeed", gm.cU());
                hashMap.put("ResourceSeed", gm.cV());
                hashMap.put("Name", gm.getName());
                hashMap.put("TypeClass", gm.cW());
                hashMap.put("Resource", gm.cT());
                hashMap.put("FleetCoordination", gm.cY());
                hashMap.put("Hyperdrive", gm.cX());
                final eY h = this.aK.H("PlayerStateData");
                final eY be = h.H("FreighterInventory").bE();
                final eY be2 = h.H("FreighterInventory_TechOnly").bE();
                final eY be3 = h.H("FreighterInventory_Cargo").bE();
                if (!av.aw()) {
                    final eV d = be.d("Slots");
                    for (int i = 0; i < d.size(); ++i) {
                        if (!d.V(i).getValueAsString("Type.InventoryType").equals("Technology")) {
                            d.ac(i--);
                        }
                    }
                    final eV d2 = be3.d("Slots");
                    for (int j = 0; j < d2.size(); ++j) {
                        if (!d2.V(j).getValueAsString("Type.InventoryType").equals("Technology")) {
                            d2.ac(j--);
                        }
                    }
                }
                hashMap.put("Inventory", be);
                hashMap.put("InventoryTech", be2);
                hashMap.put("InventoryCargo", be3);
                gS.a(cz.cH(), hashMap, selectedFile);
            }
            catch (final RuntimeException ex) {
                hc.a("Freighter backup error", ex);
                this.c("An error occured during backup.");
            }
            catch (final IOException ex2) {
                hc.a("Freighter backup error", ex2);
                this.c("An error occured during backup.");
            }
            catch (final GeneralSecurityException ex3) {
                hc.a("Freighter backup error", ex3);
                this.c("An error occured during backup.");
            }
        }
    }
    
    public boolean b(gm p) {
        final gn cz = p.cZ();
        if (cz == null) {
            return false;
        }
        final File currentDirectory = nomanssave.aH.cE.exists() ? nomanssave.aH.cE : nomanssave.aH.cD;
        final cs av = cs.av();
        av.setCurrentDirectory(currentDirectory);
        if (av.showOpenDialog(this.N) == 0) {
            try {
                if (JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite your existing freighter?", "Confirm", 2) != 0) {
                    return false;
                }
                final File selectedFile = av.getSelectedFile();
                final HashMap hashMap = new HashMap();
                gS.b(cz.cH(), hashMap, selectedFile);
                final eY h = this.aK.H("PlayerStateData");
                boolean b = false;
                for (final Map.Entry<String, V> entry : hashMap.entrySet()) {
                    if (entry.getKey().equals("HomeSeed")) {
                        p.ah((String)entry.getValue());
                    }
                    if (entry.getKey().equals("ResourceSeed")) {
                        p.ai((String)entry.getValue());
                    }
                    if (entry.getKey().equals("Name")) {
                        p.setName((String)entry.getValue());
                    }
                    if (entry.getKey().equals("TypeClass")) {
                        p.aj((String)entry.getValue());
                    }
                    if (entry.getKey().equals("Type")) {
                        p.ag(go.valueOf((String)entry.getValue()).K());
                    }
                    if (entry.getKey().equals("Resource")) {
                        p.ag((String)entry.getValue());
                    }
                    if (entry.getKey().equals("FleetCoordination")) {
                        p.b(((Number)entry.getValue()).doubleValue());
                    }
                    if (entry.getKey().equals("Hyperdrive")) {
                        p.a(((Number)entry.getValue()).doubleValue());
                    }
                    if (entry.getKey().equals("Inventory")) {
                        h.b("FreighterInventory", entry.getValue());
                        b = true;
                    }
                    if (entry.getKey().equals("InventoryTech")) {
                        h.b("FreighterInventory_TechOnly", entry.getValue());
                        b = true;
                    }
                    if (entry.getKey().equals("InventoryCargo")) {
                        h.b("FreighterInventory_Cargo", entry.getValue());
                        b = true;
                    }
                }
                if (b) {
                    p = gm.p(h);
                }
                this.aw.c(p);
                return this.aL = true;
            }
            catch (final IOException ex) {
                hc.a("Freighter restore error", ex);
                this.c("An error occured during restore.");
            }
            catch (final GeneralSecurityException ex2) {
                hc.a("Freighter restore error", ex2);
                this.c("An error occured during restore.");
            }
        }
        return false;
    }
    
    private void k() {
        final File b = ej.b((this.aF == null) ? null : this.aF.bS());
        if (b != null) {
            File parentFile;
            String name;
            if (b.isDirectory()) {
                parentFile = b;
                name = null;
            }
            else {
                parentFile = b.getParentFile();
                name = b.getName();
            }
            if (this.aF != null) {
                if (this.aF.bS().isDirectory() && !this.aF.bS().equals(parentFile)) {
                    this.aF = null;
                }
                else if (this.aF.bS().isFile() && !this.aF.bS().equals(b)) {
                    this.aF = null;
                }
            }
            if (this.aF == null) {
                hc.info("Loading storage: " + parentFile.getAbsolutePath());
                this.aF = fq.a(parentFile, this.aX);
            }
            if (this.aF == null) {
                this.aG = new ft[0];
                this.aH = -1;
                this.aI = new fs[0];
                this.aJ = -1;
                this.aK = null;
                this.aM = null;
                this.aN = null;
                this.ad.setEnabled(false);
                this.O.setEnabledAt(13, false);
                this.aE.a(null);
                this.aO = false;
                this.P.setText("(none)");
                this.Q.setText("(none)");
            }
            else {
                final String c = fq.c(this.aF);
                nomanssave.aH.setProperty("GameStorage", c);
                nomanssave.aH.setProperty("GameSaveDir", this.aF.bS().getAbsolutePath());
                hc.debug("Storage: " + c);
                hc.debug("Save Path: " + this.aF.bS().getAbsolutePath());
                this.aG = this.aF.bV();
                this.aH = -1;
                this.aI = new fs[0];
                this.aJ = -1;
                if (name != null) {
                    for (int i = 0; i < this.aG.length; ++i) {
                        if (this.aF.W(name) == this.aG[i].getIndex()) {
                            this.aH = i;
                            this.aI = this.aG[i].bX();
                            for (int j = 0; j < this.aI.length; ++j) {
                                if (name.equals(this.aI[j].K())) {
                                    this.aJ = j;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                this.aM = null;
                this.aN = null;
                try {
                    this.aM = this.aF.bT();
                    this.aN = ((this.aM == null) ? null : this.aM.M());
                    if (this.aN != null) {
                        this.aN.a(this.aV);
                    }
                }
                catch (final IOException ex) {
                    hc.a("Error reading account data", ex);
                }
                this.ad.setEnabled(this.aN != null);
                this.O.setEnabledAt(13, this.aN != null);
                this.aE.a(this.aN);
                this.aO = false;
                this.P.setText(c);
                this.Q.setText(this.aF.bS().getAbsolutePath());
            }
            this.R.setEnabled(true);
            this.S.setEnabled(true);
            if (this.aJ > 0) {
                this.c("The save file you have selected is not the most recent.");
            }
            this.l();
        }
    }
    
    private void e(final int ah) {
        this.aH = ah;
        if (this.aH < 0) {
            this.aI = new fs[0];
            this.aJ = -1;
        }
        else {
            this.aI = this.aG[this.aH].bX();
            this.aJ = ((this.aI.length > 0) ? 0 : -1);
        }
        this.l();
    }
    
    private void f(final int aj) {
        this.aJ = aj;
        this.l();
    }
    
    public void b(final String s) {
        EventQueue.invokeLater(new z(this, s));
    }
    
    public void c(final String s) {
        EventQueue.invokeLater(new A(this, s));
    }
    
    private void l() {
        this.R.updateUI();
        this.S.updateUI();
        this.aL = false;
        this.aK = null;
        if (this.aJ < 0) {
            this.T.setText("(no file selected)");
            this.U.setText("(no file selected)");
            this.V.setText("(no file selected)");
            if (this.aH >= 0) {
                hc.info("No current save file found for " + this.aG[this.aH]);
                this.b("Save file not found for " + this.aG[this.aH]);
            }
        }
        else {
            try {
                this.T.setText(a(this.aI[this.aJ].lastModified()));
                this.U.setText(e(this.aI[this.aJ].getName()));
                this.V.setText(e(this.aI[this.aJ].getDescription()));
                hc.info("Reading save file...");
                hc.info("  Slot: " + this.aG[this.aH]);
                hc.info("  Filename: " + this.aI[this.aJ].K());
                try {
                    (this.aK = this.aI[this.aJ].M()).a(this.aW);
                }
                catch (final eX ex) {
                    hc.info("  Error parsing JSON: " + ex.getMessage());
                }
                hc.info("Finished.");
                this.aL = (this.aI[this.aJ] instanceof F);
            }
            catch (final IOException ex2) {
                hc.error("Could not load save file: " + this.aI[this.aJ].K(), ex2);
                this.aK = null;
            }
        }
        this.O.setSelectedIndex(0);
        final eY h;
        if (this.aK == null || (h = this.aK.H("PlayerStateData")) == null) {
            this.W.setEnabled(false);
            this.X.setEnabled(false);
            this.Y.setEnabled(false);
            this.Z.setEnabled(false);
            this.aa.setEnabled(false);
            this.ab.setEnabled(false);
            final Iterator iterator = this.ac.iterator();
            while (iterator.hasNext()) {
                ((JMenuItem)iterator.next()).setEnabled(false);
            }
            this.as.a((gz)null);
            this.at.a(new gv[0], null);
            this.au.a(new gH[0], null);
            this.av.a(new gM[0]);
            this.aw.c((gm)null);
            this.ax.a(new gp[0]);
            this.ay.a(new gO[0]);
            this.az.a(new gj[0]);
            this.aA.a((ge)null);
            this.aB.a(new gE[0]);
            this.aC.a((gz)null);
            this.aD.a((gz)null);
            this.O.setEnabledAt(1, false);
            this.O.setEnabledAt(2, false);
            this.O.setEnabledAt(3, false);
            this.O.setEnabledAt(4, false);
            this.O.setEnabledAt(5, false);
            this.O.setEnabledAt(6, false);
            this.O.setEnabledAt(7, false);
            this.O.setEnabledAt(8, false);
            this.O.setEnabledAt(9, false);
            this.O.setEnabledAt(11, false);
            this.O.setEnabledAt(12, false);
            if (this.aJ >= 0) {
                if (this.aK == null) {
                    this.b("There was an error loading the file.");
                }
                else {
                    this.b("Save file corrupted");
                }
            }
        }
        else {
            final boolean bw = this.aF.bW();
            final gz w = gz.w(h);
            final gv[] v = gv.v(h);
            final gB x = gB.x(h);
            final gH[] c = gH.C(h);
            final gC y = gC.y(h);
            final gM[] d = gM.D(h);
            final gm p = gm.p(h);
            final gp[] q = gp.q(h);
            final gO[] e = gO.E(h);
            final gE[] z = gE.z(h);
            final boolean n = gj.n(h);
            final gj[] o = gj.o(h);
            final ge m = ge.m(h);
            this.O.setEnabledAt(1, w != null);
            this.as.a(w);
            this.O.setEnabledAt(2, v.length > 0);
            this.at.a(v, x);
            this.O.setEnabledAt(3, c.length > 0);
            this.au.a(c, y);
            this.O.setEnabledAt(4, d.length > 0);
            this.av.a(d);
            this.O.setEnabledAt(5, p != null);
            this.aw.c(p);
            this.O.setEnabledAt(6, p != null);
            this.ax.a(q);
            this.O.setEnabledAt(7, e.length > 0);
            this.ay.a(e);
            this.O.setEnabledAt(8, n);
            this.az.a(o);
            this.O.setEnabledAt(9, m != null);
            this.aA.a(m);
            this.O.setEnabledAt(10, z.length > 0);
            this.aB.a(z);
            this.O.setEnabledAt(11, w != null);
            this.aC.a(w);
            this.O.setEnabledAt(12, w != null);
            this.aD.a(w);
            this.W.setEnabled(!(this.aI[this.aJ] instanceof F));
            this.X.setEnabled(true);
            this.Y.setEnabled(bw);
            this.Z.setEnabled(true);
            this.aa.setEnabled(true);
            this.ab.setEnabled(bw);
            final Iterator iterator2 = this.ac.iterator();
            while (iterator2.hasNext()) {
                ((JMenuItem)iterator2.next()).setEnabled(true);
            }
        }
    }
    
    private void m() {
        try {
            this.aM.k(this.aN);
            this.aO = false;
        }
        catch (final Exception ex) {
            hc.a("Error saving account data", ex);
            this.c("An error occured saving the account data.");
        }
    }
    
    private void n() {
        if (this.aJ < 0) {
            this.b("No save file selected.");
            return;
        }
        try {
            hc.info("Formatting JSON...");
            final String b = this.aI[this.aJ].b(this.aK);
            this.aI = this.aG[this.aH].bX();
            this.aJ = -1;
            for (int i = 0; i < this.aI.length; ++i) {
                if (b.equals(this.aI[i].K())) {
                    this.aJ = i;
                    break;
                }
            }
            this.aL = false;
            this.R.updateUI();
            this.S.updateUI();
            if (this.aJ < 0) {
                this.T.setText("(no file selected)");
                this.U.setText("(no file selected)");
                this.V.setText("(no file selected)");
            }
            else {
                this.T.setText(a(this.aI[this.aJ].lastModified()));
                this.U.setText(e(this.aI[this.aJ].getName()));
                this.V.setText(e(this.aI[this.aJ].getDescription()));
            }
            hc.info("Finished.");
        }
        catch (final IOException ex) {
            hc.error("Could not write save file: " + this.aI[this.aJ].K(), ex);
            this.b("There was an error saving the file.");
        }
    }
    
    private void o() {
        final int index = this.aG[this.aH].getIndex();
        final int a = dz.a(this.N, this.aF.bU(), index);
        if (a >= 0 && a != index) {
            try {
                hc.info("Formatting JSON...");
                hc.info("Creating game slot...");
                final String a2 = this.aF.a(a, this.aK);
                this.aG = this.aF.bV();
                this.aH = -1;
                this.aI = new fs[0];
                this.aJ = -1;
                for (int i = 0; i < this.aG.length; ++i) {
                    if (this.aF.W(a2) == this.aG[i].getIndex()) {
                        this.aH = i;
                        this.aI = this.aG[i].bX();
                        for (int j = 0; j < this.aI.length; ++j) {
                            if (a2.equals(this.aI[j].K())) {
                                this.aJ = j;
                                break;
                            }
                        }
                        break;
                    }
                }
                this.aL = false;
                this.R.updateUI();
                this.S.updateUI();
                if (this.aJ < 0) {
                    this.T.setText("(no file selected)");
                    this.U.setText("(no file selected)");
                    this.V.setText("(no file selected)");
                }
                else {
                    this.T.setText(a(this.aI[this.aJ].lastModified()));
                    this.U.setText(e(this.aI[this.aJ].getName()));
                    this.V.setText(e(this.aI[this.aJ].getDescription()));
                }
                hc.info("Finished.");
            }
            catch (final IOException ex) {
                hc.error("Could not write save file", ex);
                this.b("There was an error saving the file.");
            }
        }
    }
    
    public List g(final int n) {
        final ArrayList list = new ArrayList();
        final gz x = this.as.X();
        if (x != null) {
            list.addAll((Collection)x.cC().stream().filter(gt -> gt.ay(n2)).collect(Collectors.toList()));
        }
        final gv[] ak = this.at.aK();
        for (int i = 0; i < ak.length; ++i) {
            final gt de;
            if ((de = ak[i].dE()) != null && de.ay(n)) {
                list.add(de);
            }
        }
        final gH[] ao = this.au.aO();
        for (int j = 0; j < ao.length; ++j) {
            list.addAll((Collection)ao[j].cC().stream().filter(gt2 -> gt2.ay(n3)).collect(Collectors.toList()));
        }
        final gm z = this.aw.Z();
        if (z != null) {
            list.addAll((Collection)z.cC().stream().filter(gt3 -> gt3.ay(n4)).collect(Collectors.toList()));
        }
        final gO[] at = this.ay.aT();
        for (int k = 0; k < at.length; ++k) {
            list.addAll((Collection)at[k].cC().stream().filter(gt4 -> gt4.ay(n5)).collect(Collectors.toList()));
        }
        final ge o = this.aA.O();
        if (o != null) {
            list.addAll((Collection)o.cC().stream().filter(gt5 -> gt5.ay(n6)).collect(Collectors.toList()));
        }
        return list;
    }
    
    private void p() {
        final eY h = this.aK.H("PlayerStateData.UniverseAddress");
        final hl a;
        if ((a = nomanssave.aj.a(this.N, hl.n(h))) != null) {
            a.aL(0);
            this.aK.b("PlayerStateData.UniverseAddress", (Object)a.ew());
            this.aK.b("PlayerStateData.PreviousUniverseAddress", (Object)h);
            this.aK.b("SpawnStateData.LastKnownPlayerState", "InShip");
            this.aL = true;
        }
    }
    
    private void q() {
        hc.info("Starting JSON Editor...");
        if (cy.a(this, this.aI[this.aJ].K(), this.aK)) {
            this.t();
        }
    }
    
    private void r() {
        hc.info("Starting JSON Editor...");
        if (cy.a(this, this.aM.K(), this.aN)) {
            try {
                this.aM.k(this.aN);
            }
            catch (final IOException ex) {
                hc.a("JSON Save error", ex);
                this.c("An error occured saving the account data.");
            }
        }
    }
    
    private static void a(final Window c) {
        SwingUtilities.updateComponentTreeUI(c);
        Window[] ownedWindows;
        for (int length = (ownedWindows = c.getOwnedWindows()).length, i = 0; i < length; ++i) {
            a(ownedWindows[i]);
        }
    }
    
    private void s() {
        if (nomanssave.aD.d(this.N)) {
            nomanssave.aH.V();
            a(this.N);
        }
    }
    
    private void t() {
        this.aL = true;
        final eY h = this.aK.H("PlayerStateData");
        final gz w = gz.w(h);
        final gv[] v = gv.v(h);
        final gB x = gB.x(h);
        final gH[] c = gH.C(h);
        final gM[] d = gM.D(h);
        final gC y = gC.y(h);
        final gm p = gm.p(h);
        final gp[] q = gp.q(h);
        final gO[] e = gO.E(h);
        final gE[] z = gE.z(h);
        final boolean n = gj.n(h);
        final gj[] o = gj.o(h);
        final ge m = ge.m(h);
        this.O.setEnabledAt(1, w != null);
        this.as.a(w);
        this.O.setEnabledAt(2, v.length > 0);
        this.at.a(v, x);
        this.O.setEnabledAt(3, c.length > 0);
        this.au.a(c, y);
        this.O.setEnabledAt(4, d.length > 0);
        this.av.a(d);
        this.O.setEnabledAt(5, p != null);
        this.aw.c(p);
        this.O.setEnabledAt(6, p != null);
        this.ax.a(q);
        this.O.setEnabledAt(7, e.length > 0);
        this.ay.a(e);
        this.O.setEnabledAt(8, n);
        this.az.a(o);
        this.O.setEnabledAt(9, m != null);
        this.aA.a(m);
        this.O.setEnabledAt(10, z.length > 0);
        this.aB.a(z);
        this.O.setEnabledAt(11, w != null);
        this.aC.a(w);
        this.O.setEnabledAt(12, w != null);
        this.aD.a(w);
    }
    
    private void u() {
        hc.info("Exporting JSON...");
        final cK aa = cK.aA();
        final String string = String.valueOf(this.aI[this.aJ].K()) + ".json";
        aa.setCurrentDirectory(nomanssave.aH.cF);
        aa.setSelectedFile(new File(nomanssave.aH.cF, string));
        if (aa.showSaveDialog(this.N) == 0) {
            try {
                File selectedFile = aa.getSelectedFile();
                if (!selectedFile.getName().endsWith(".json")) {
                    selectedFile = new File(selectedFile.getParentFile(), String.valueOf(selectedFile.getName()) + ".json");
                }
                if (selectedFile.exists() && JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite this existing JSON file?", "Confirm", 2) != 0) {
                    return;
                }
                this.aK.c(selectedFile);
            }
            catch (final IOException ex) {
                hc.a("JSON Export error", ex);
                this.c("An error occured exporting the save data.");
            }
        }
    }
    
    private void v() {
        hc.info("Importing JSON...");
        final cK aa = cK.aA();
        aa.setCurrentDirectory(nomanssave.aH.cF);
        if (aa.showOpenDialog(this.N) == 0) {
            try {
                if (JOptionPane.showConfirmDialog(this.N, "Are you sure you want to update your current save data?", "Confirm", 2) != 0) {
                    return;
                }
                this.aK.d(aa.getSelectedFile());
                this.t();
            }
            catch (final IOException ex) {
                hc.a("JSON Import error", ex);
                this.c("An error occured importing the save data.");
            }
        }
    }
    
    private void w() {
        this.as.w();
        this.at.w();
        this.au.w();
        this.aw.w();
        this.ay.w();
        this.aA.w();
    }
    
    private void x() {
        this.as.x();
        this.at.x();
        this.au.x();
        this.aw.x();
        this.ay.x();
        this.aA.x();
    }
    
    private void y() {
        this.as.y();
        this.at.y();
        this.au.y();
        this.aw.y();
        this.ay.y();
        this.aA.y();
    }
    
    private void z() {
        this.at.z();
        this.au.z();
    }
    
    private void A() {
        this.as.A();
        this.at.A();
        this.au.A();
        this.aw.A();
        this.ay.A();
        this.aA.A();
    }
    
    public void a(final gt gt) {
        this.as.a(gt);
        this.at.a(gt);
        this.au.a(gt);
        this.aw.a(gt);
        this.ay.a(gt);
        this.aA.a(gt);
    }
    
    public void B() {
        this.aD.B();
    }
    
    public void C() {
        this.aD.C();
    }
    
    public eV d(final String s) {
        return this.aK.d(s);
    }
    
    public boolean D() {
        return this.aK.getValue("PlayerStateData.DifficultyState") != null;
    }
    
    public String E() {
        return this.aK.getValueAsString("PlayerStateData.DifficultyState.Settings.InventoryStackLimits.InventoryStackLimitsDifficulty");
    }
    
    public fn F() {
        final String valueAsString = this.aK.getValueAsString("PlayerStateData.DifficultyState.Preset.DifficultyPresetType");
        if (valueAsString != null) {
            fn[] values;
            for (int length = (values = fn.values()).length, i = 0; i < length; ++i) {
                final fn fn = values[i];
                if (valueAsString.equalsIgnoreCase(fn.name())) {
                    return fn;
                }
            }
        }
        fn fn2 = this.aI[this.aJ].L();
        if (fn2 == fn.lr) {
            final String valueAsString2 = this.aK.getValueAsString("PlayerStateData.SeasonData.GameMode.PresetGameMode");
            if ("Normal".equals(valueAsString2)) {
                fn2 = fn.lm;
            }
            if ("Creative".equals(valueAsString2)) {
                fn2 = fn.lo;
            }
            if ("Survival".equals(valueAsString2)) {
                fn2 = fn.ln;
            }
            if ("Ambient".equals(valueAsString2)) {
                fn2 = fn.lp;
            }
            if ("Permadeath".equals(valueAsString2)) {
                fn2 = fn.lq;
            }
        }
        return fn2;
    }
    
    public void h(final int n) {
        final eY h = this.aK.H("PlayerStateData");
        final eV d = h.d("Multitools");
        if (d == null || d.size() == 0) {
            return;
        }
        final eY az = gR.az("multitool");
        if (n < 0 || n >= d.size() || az == null) {
            return;
        }
        d.remove(n);
        d.add(az);
        final gB x = gB.x(h);
        int du = x.dU();
        if (du > 0 && du >= n) {
            x.aF(--du);
        }
        this.at.a(gv.v(h), x);
    }
    
    public void i(final int n) {
        final eY h = this.aK.H("PlayerStateData");
        final eV d = h.d("ShipOwnership");
        if (d == null || d.size() == 0) {
            return;
        }
        final eY az = gR.az("ship");
        if (n < 0 || n >= d.size() || az == null) {
            return;
        }
        d.remove(n);
        d.add(az);
        final gC y = gC.y(h);
        int dv = y.dV();
        if (dv > 0 && dv >= n) {
            y.aG(--dv);
        }
        this.au.a(gH.C(h), y);
    }
    
    public void a(final gl gl, final int n) {
        final eY h = this.aK.H("PlayerStateData");
        eV ev = null;
        switch (I()[gl.ordinal()]) {
            case 2: {
                ev = h.d("Eggs");
                break;
            }
            case 1: {
                ev = h.d("Pets");
                break;
            }
            default: {
                return;
            }
        }
        if (ev == null || ev.size() == 0) {
            return;
        }
        final eY az = gR.az("companion");
        if (n < 0 || n >= ev.size() || az == null) {
            return;
        }
        ev.remove(n);
        ev.add(az);
        this.az.a(gj.o(h));
    }
    
    public boolean j(final int value) {
        final eV d = this.aK.d("PlayerStateData.FleetExpeditions");
        for (int i = 0; i < d.size(); ++i) {
            if (d.V(i).d("AllFrigateIndices").hasValue(new Integer(value))) {
                return true;
            }
        }
        return false;
    }
    
    public gp[] k(final int value) {
        final eV d = this.aK.d("PlayerStateData.FleetFrigates");
        final eV d2 = this.aK.d("PlayerStateData.FleetExpeditions");
        for (int i = 0; i < d2.size(); ++i) {
            if (d2.V(i).d("AllFrigateIndices").hasValue(new Integer(value))) {
                this.c("This frigate is currently on a mission and cannot be deleted!");
                return gp.d(d);
            }
        }
        if (d != null && value < d.size()) {
            d.ac(value);
            for (int j = 0; j < d2.size(); ++j) {
                final eY v = d2.V(j);
                final eV d3 = v.d("ActiveFrigateIndices");
                for (int k = 0; k < d3.size(); ++k) {
                    final int y;
                    if ((y = d3.Y(k)) > value) {
                        d3.a(k, y - 1);
                    }
                }
                final eV d4 = v.d("DamagedFrigateIndices");
                for (int l = 0; l < d4.size(); ++l) {
                    final int y2;
                    if ((y2 = d4.Y(l)) > value) {
                        d4.a(l, y2 - 1);
                    }
                }
                final eV d5 = v.d("DestroyedFrigateIndices");
                for (int n = 0; n < d5.size(); ++n) {
                    final int y3;
                    if ((y3 = d5.Y(n)) > value) {
                        d5.a(n, y3 - 1);
                    }
                }
                eV ev = v.d("AllFrigateIndices");
                for (int n2 = 0; n2 < ev.size(); ++n2) {
                    final int y4;
                    if ((y4 = ev.Y(n2)) > value) {
                        ev.a(n2, y4 - 1);
                    }
                }
                final eV d6 = v.d("Events");
                for (int n3 = 0; n3 < ev.size(); ++n3) {
                    final eY v2 = d6.V(n3);
                    final eV d7 = v2.d("AffectedFrigateIndices");
                    for (int n4 = 0; n4 < d7.size(); ++n4) {
                        final int y5;
                        if ((y5 = d7.Y(n4)) > value) {
                            d7.a(n4, y5 - 1);
                        }
                    }
                    final eV d8 = v2.d("RepairingFrigateIndices");
                    for (int n5 = 0; n5 < d8.size(); ++n5) {
                        final int y6;
                        if ((y6 = d8.Y(n5)) > value) {
                            d8.a(n5, y6 - 1);
                        }
                    }
                    ev = v2.d("AffectedFrigateResponses");
                    for (int n6 = 0; n6 < ev.size(); ++n6) {
                        final int y7;
                        if ((y7 = ev.Y(n6)) > value) {
                            ev.a(n6, y7 - 1);
                        }
                    }
                }
            }
            this.aL = true;
        }
        return gp.d(d);
    }
    
    public gp[] a(final int n, final String s) {
        final eV d = this.aK.d("PlayerStateData.FleetFrigates");
        if (d != null && n < d.size()) {
            final eY be = d.V(n).bE();
            be.d("ResourceSeed").a(1, s);
            be.b("CustomName", "");
            d.f(be);
            this.aL = true;
        }
        return gp.d(d);
    }
    
    private void G() {
        final int j = this.aK.J("PlayerStateData.TotalPlayTime");
        int n = 0;
        final eV d = this.aK.d("PlayerStateData.PersistentPlayerBases");
        for (int i = 0; i < d.size(); ++i) {
            final eV d2 = d.V(i).d("Objects");
            for (int k = 0; k < d2.size(); ++k) {
                final String valueAsString = d2.V(k).getValueAsString("ObjectID");
                if ("^PLANTER".equals(valueAsString)) {
                    ++n;
                }
                else if ("^PLANTERMEGA".equals(valueAsString)) {
                    ++n;
                }
            }
        }
        final eV d3 = this.aK.d("PlayerStateData.MaintenanceInteractions");
        for (int l = 0; l < d3.size(); ++l) {
            final eY v = d3.V(l);
            final eV d4 = v.d("InventoryContainer.Slots");
            for (int n2 = 0; n2 < d4.size(); ++n2) {
                final eY v2 = d4.V(n2);
                if ("^MAINT_FARM5".equals(v2.getValueAsString("Id"))) {
                    final int m;
                    if ((m = v2.J("MaxAmount")) > 0 && v2.J("Amount") < m) {
                        v2.b("Amount", new Integer(m));
                    }
                    v.b("LastUpdateTimestamp", new Integer(j));
                    this.aL = true;
                    --n;
                }
            }
        }
    }
    
    private void initialize() {
        this.N = new JFrame();
        final ImageIcon a = a("UI-FILEICON.PNG");
        if (a != null) {
            this.N.setIconImage(a.getImage());
        }
        this.N.setTitle("No Man's Sky Save Editor - 1.19.0 (VOYAGERS)");
        final Rectangle bounds = new Rectangle(100, 100, 1100, 720);
        bounds.x = nomanssave.aH.a("MainFrame.X", 100);
        bounds.y = nomanssave.aH.a("MainFrame.Y", 100);
        bounds.width = nomanssave.aH.a("MainFrame.Width", 1000);
        bounds.height = nomanssave.aH.a("MainFrame.Height", 700);
        this.N.setBounds(bounds);
        this.N.setDefaultCloseOperation(3);
        this.N.addWindowListener(new B(this));
        this.N.addComponentListener(new C(this));
        this.O = new JTabbedPane(1);
        this.N.getContentPane().add(this.O, "Center");
        final ba component = new ba(new int[] { nomanssave.aH.cH, nomanssave.aH.cI, 0 });
        this.O.addTab("Main", null, component, null);
        component.k("File Details");
        (this.P = new JLabel()).setText((this.aF == null) ? "" : fq.c(this.aF));
        component.a("Storage", this.P, 2);
        (this.Q = new JLabel()).setText((this.aF == null) ? "(no path selected)" : this.aF.bS().getAbsolutePath());
        component.a("Save Path", this.Q, 2);
        (this.R = new JComboBox()).setModel(new D(this));
        this.R.setEnabled(this.aF != null);
        component.a("Game Slot", this.R);
        (this.S = new JComboBox()).setEditable(false);
        this.S.setModel(new E(this));
        this.S.setEnabled(this.aF != null);
        component.a("Save File", this.S);
        (this.T = new JLabel()).setText("(no file selected)");
        component.a("Modified", this.T, 2);
        (this.U = new JLabel()).setText("(no file selected)");
        component.a("Save Name", this.U, 2);
        (this.V = new JLabel()).setText("(no file selected)");
        component.a("Description", this.V, 2);
        component.Y();
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(0, 0, 0));
        (this.W = new JButton("Reload")).setEnabled(false);
        this.W.addActionListener(p0 -> this.l());
        panel.add(this.W);
        (this.X = new JButton("Save Changes")).setEnabled(false);
        this.X.addActionListener(p0 -> this.n());
        panel.add(this.X);
        (this.Y = new JButton("Save As")).setEnabled(false);
        this.Y.addActionListener(p0 -> this.o());
        panel.add(this.Y);
        component.a(null, panel, 2);
        this.as = new aJ(this);
        this.O.addTab("Exosuit", null, this.as, null);
        this.O.setEnabledAt(1, false);
        this.at = new dj(this);
        this.O.addTab("Multitool", null, this.at, null);
        this.O.setEnabledAt(2, false);
        this.au = new dN(this);
        this.O.addTab("Ships", null, this.au, null);
        this.O.setEnabledAt(3, false);
        this.av = new eb(this);
        this.O.addTab("Squadron", null, this.av, null);
        this.O.setEnabledAt(4, false);
        this.aw = new bd(this);
        this.O.addTab("Freighter", null, this.aw, null);
        this.O.setEnabledAt(5, false);
        this.ax = new bl(this);
        this.O.addTab("Frigates", null, this.ax, null);
        this.O.setEnabledAt(6, false);
        this.ay = new ep(this);
        this.O.addTab("Vehicles", null, this.ay, null);
        this.O.setEnabledAt(7, false);
        this.az = new X(this);
        this.O.addTab("Companions", null, this.az, null);
        this.O.setEnabledAt(8, false);
        this.aA = new I(this);
        this.O.addTab("Bases & Storage", null, this.aA, null);
        this.O.setEnabledAt(9, false);
        this.aB = new dE(this);
        this.O.addTab("Settlements", null, this.aB, null);
        this.O.setEnabledAt(10, false);
        this.aC = new ap(this);
        this.O.addTab("Discovery", null, this.aC, null);
        this.O.setEnabledAt(11, false);
        this.aD = new bE(this);
        this.O.addTab("Milestones / Reputation", null, this.aD, null);
        this.O.setEnabledAt(12, false);
        this.aE = new c(this);
        this.O.addTab("Account", null, this.aE, null);
        this.O.setEnabledAt(13, false);
        this.O.addChangeListener(p0 -> {
            if (this.O.getSelectedIndex() == 12) {
                this.aD.aa();
            }
            if (this.aF != null && this.aO && this.aP) {
                this.aP = (JOptionPane.showConfirmDialog(this.N, "Save account data?", "Save", 0) == 0);
                if (this.aP) {
                    this.m();
                }
            }
            return;
        });
        final JMenuBar jMenuBar = new JMenuBar();
        this.N.setJMenuBar(jMenuBar);
        final JMenu c = new JMenu("File");
        jMenuBar.add(c);
        final JMenuItem menuItem = new JMenuItem("Open File/Path");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        menuItem.addActionListener(p0 -> this.k());
        c.add(menuItem);
        (this.Z = new JMenuItem("Reload File")).setEnabled(false);
        this.Z.setAccelerator(KeyStroke.getKeyStroke(82, 2));
        this.Z.addActionListener(p0 -> this.l());
        c.add(this.Z);
        (this.aa = new JMenuItem("Save File")).setEnabled(false);
        this.aa.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        this.aa.addActionListener(p0 -> {
            this.N.getFocusOwner();
            final G g;
            if (g instanceof G) {
                g.N();
            }
            this.n();
            return;
        });
        c.add(this.aa);
        (this.ab = new JMenuItem("Save File As")).setEnabled(false);
        this.ab.addActionListener(p0 -> {
            this.N.getFocusOwner();
            final G g2;
            if (g2 instanceof G) {
                g2.N();
            }
            this.o();
            return;
        });
        c.add(this.ab);
        c.addSeparator();
        final JMenuItem menuItem2 = new JMenuItem("Exit");
        menuItem2.addActionListener(p0 -> {
            if (this.aL || this.aO) {
                if (JOptionPane.showConfirmDialog(this.N, "Save data before closing?", "Save", 0) == 0) {
                    if (this.aL) {
                        this.n();
                    }
                    if (this.aO) {
                        this.m();
                    }
                }
            }
            this.N.dispose();
            return;
        });
        c.add(menuItem2);
        final JMenu c2 = new JMenu("Edit");
        jMenuBar.add(c2);
        this.ac = new ArrayList();
        final JMenuItem menuItem3 = new JMenuItem("Edit Raw JSON");
        menuItem3.addActionListener(p0 -> this.q());
        c2.add(menuItem3);
        this.ac.add(menuItem3);
        final JMenuItem menuItem4 = new JMenuItem("Export JSON");
        menuItem4.addActionListener(p0 -> this.u());
        c2.add(menuItem4);
        this.ac.add(menuItem4);
        final JMenuItem menuItem5 = new JMenuItem("Import JSON");
        menuItem5.addActionListener(p0 -> this.v());
        c2.add(menuItem5);
        this.ac.add(menuItem5);
        final JMenuItem menuItem6 = new JMenuItem("Coordinate Viewer");
        menuItem6.addActionListener(p0 -> this.p());
        c2.add(menuItem6);
        this.ac.add(menuItem6);
        final JCheckBoxMenuItem menuItem7 = new JCheckBoxMenuItem("Test Mode");
        menuItem7.setSelected(en.aS());
        menuItem7.addActionListener(p1 -> {
            checkBoxMenuItem.isSelected();
            final boolean b;
            if (b) {
                if (JOptionPane.showConfirmDialog(this.N, "This mode removes any restrictions imposed by the editor.\nUSE WITH CAUTION: Changes made in test mode may not work in game.", "Test Mode", 2) == 2) {
                    checkBoxMenuItem.setSelected((boolean)(0 != 0));
                    return;
                }
            }
            en.c(b);
            return;
        });
        c2.add(menuItem7);
        c2.addSeparator();
        final JMenuItem menuItem8 = new JMenuItem("Recharge All Technology");
        menuItem8.addActionListener(p0 -> this.w());
        c2.add(menuItem8);
        this.ac.add(menuItem8);
        final JMenuItem menuItem9 = new JMenuItem("Refill All Stacks");
        menuItem9.addActionListener(p0 -> this.x());
        c2.add(menuItem9);
        this.ac.add(menuItem9);
        final JMenuItem menuItem10 = new JMenuItem("Recharge Base Planters");
        menuItem10.addActionListener(p0 -> this.G());
        c2.add(menuItem10);
        this.ac.add(menuItem10);
        final JMenuItem menuItem11 = new JMenuItem("Expand All Inventories");
        menuItem11.addActionListener(p0 -> this.A());
        c2.add(menuItem11);
        this.ac.add(menuItem11);
        final JMenuItem menuItem12 = new JMenuItem("Enable All Slots");
        menuItem12.addActionListener(p0 -> this.y());
        c2.add(menuItem12);
        this.ac.add(menuItem12);
        final JMenuItem menuItem13 = new JMenuItem("Repair All Slots / Technology");
        menuItem13.addActionListener(p0 -> this.z());
        c2.add(menuItem13);
        this.ac.add(menuItem13);
        c2.addSeparator();
        (this.ad = new JMenuItem("Edit Account JSON")).addActionListener(p0 -> this.r());
        c2.add(this.ad);
        final Iterator iterator = this.ac.iterator();
        while (iterator.hasNext()) {
            ((JMenuItem)iterator.next()).setEnabled(false);
        }
        this.ad.setEnabled(false);
        final JMenu c3 = new JMenu("View");
        jMenuBar.add(c3);
        final JMenuItem menuItem14 = new JMenuItem("Settings");
        menuItem14.addActionListener(p0 -> this.s());
        c3.add(menuItem14);
        jMenuBar.add(Box.createHorizontalGlue());
        final JMenu c4 = new JMenu("Help");
        jMenuBar.add(c4);
        final JMenuItem menuItem15 = new JMenuItem("About");
        menuItem15.addActionListener(p0 -> nomanssave.a.a(this.N));
        c4.add(menuItem15);
        if (this.aF == null) {
            EventQueue.invokeLater(new v(this));
        }
        else if (this.aN != null) {
            this.ad.setEnabled(true);
            this.O.setEnabledAt(13, true);
            this.aE.a(this.aN);
            this.aO = false;
        }
        this.N.pack();
    }
    
    private static String e(final String s) {
        return (s == null) ? "(unknown)" : s;
    }
    
    static /* synthetic */ int[] I() {
        final int[] ay = Application.aY;
        if (ay != null) {
            return ay;
        }
        final int[] ay2 = new int[gl.values().length];
        try {
            ay2[gl.oG.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            ay2[gl.oF.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        return Application.aY = ay2;
    }
}
