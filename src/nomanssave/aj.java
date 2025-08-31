// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Icon;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ComboBoxModel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.List;
import javax.swing.JDialog;

public class aj extends JDialog
{
    private static final List bW;
    private JComboBox bX;
    private JTextField bY;
    private JTextField bZ;
    private JLabel[] ca;
    private JTextField m;
    private ImageIcon[] cb;
    private hl cc;
    private boolean cd;
    private static final String ce = "0123456789ABCDEF";
    private static aj cf;
    
    static {
        bW = Arrays.asList("Euclid", "Hilbert Dimension", "Calypso", "Hesperius Dimension", "Hyades", "Ickjamatew", "Budullangr", "Kikolgallr", "Eltiensleen", "Eissentam", "Elkupalos", "Aptarkaba", "Ontiniangp", "Odiwagiri", "Ogtialabi", "Muhacksonto", "Hitonskyer", "Rerasmutul", "Isdoraijung", "Doctinawyra", "Loychazinq", "Zukasizawa", "Ekwathore", "Yeberhahne", "Twerbetek", "Sivarates", "Eajerandal", "Aldukesci", "Wotyarogii", "Sudzerbal", "Maupenzhay", "Sugueziume", "Brogoweldian", "Ehbogdenbu", "Ijsenufryos", "Nipikulha", "Autsurabin", "Lusontrygiamh", "Rewmanawa", "Ethiophodhe", "Urastrykle", "Xobeurindj", "Oniijialdu", "Wucetosucc", "Ebyeloofdud", "Odyavanta", "Milekistri", "Waferganh", "Agnusopwit", "Teyaypilny", "Zalienkosm", "Ladgudiraf", "Mushonponte", "Amsentisz", "Fladiselm", "Laanawemb", "Ilkerloor", "Davanossi", "Ploehrliou", "Corpinyaya", "Leckandmeram", "Quulngais", "Nokokipsechl", "Rinblodesa", "Loydporpen", "Ibtrevskip", "Elkowaldb", "Heholhofsko", "Yebrilowisod", "Husalvangewi", "Ovna'uesed", "Bahibusey", "Nuybeliaure", "Doshawchuc", "Ruckinarkh", "Thorettac", "Nuponoparau", "Moglaschil", "Uiweupose", "Nasmilete", "Ekdaluskin", "Hakapanasy", "Dimonimba", "Cajaccari", "Olonerovo", "Umlanswick", "Henayliszm", "Utzenmate", "Umirpaiya", "Paholiang", "Iaereznika", "Yudukagath", "Boealalosnj", "Yaevarcko", "Coellosipp", "Wayndohalou", "Smoduraykl", "Apmaneessu", "Hicanpaav", "Akvasanta", "Tuychelisaor", "Rivskimbe", "Daksanquix", "Kissonlin", "Aediabiel", "Ulosaginyik", "Roclaytonycar", "Kichiaroa", "Irceauffey", "Nudquathsenfe", "Getaizakaal", "Hansolmien", "Bloytisagra", "Ladsenlay", "Luyugoslasr", "Ubredhatk", "Cidoniana", "Jasinessa", "Torweierf", "Saffneckm", "Thnistner", "Dotusingg", "Luleukous", "Jelmandan", "Otimanaso", "Enjaxusanto", "Sezviktorew", "Zikehpm", "Bephembah", "Broomerrai", "Meximicka", "Venessika", "Gaiteseling", "Zosakasiro", "Drajayanes", "Ooibekuar", "Urckiansi", "Dozivadido", "Emiekereks", "Meykinunukur", "Kimycuristh", "Roansfien", "Isgarmeso", "Daitibeli", "Gucuttarik", "Enlaythie", "Drewweste", "Akbulkabi", "Homskiw", "Zavainlani", "Jewijkmas", "Itlhotagra", "Podalicess", "Hiviusauer", "Halsebenk", "Puikitoac", "Gaybakuaria", "Grbodubhe", "Rycempler", "Indjalala", "Fontenikk", "Pasycihelwhee", "Ikbaksmit", "Telicianses", "Oyleyzhan", "Uagerosat", "Impoxectin", "Twoodmand", "Hilfsesorbs", "Ezdaranit", "Wiensanshe", "Ewheelonc", "Litzmantufa", "Emarmatosi", "Mufimbomacvi", "Wongquarum", "Hapirajua", "Igbinduina", "Wepaitvas", "Sthatigudi", "Yekathsebehn", "Ebedeagurst", "Nolisonia", "Ulexovitab", "Iodhinxois", "Irroswitzs", "Bifredait", "Beiraghedwe", "Yeonatlak", "Cugnatachh", "Nozoryenki", "Ebralduri", "Evcickcandj", "Ziybosswin", "Heperclait", "Sugiuniam", "Aaseertush", "Uglyestemaa", "Horeroedsh", "Drundemiso", "Ityanianat", "Purneyrine", "Dokiessmat", "Nupiacheh", "Dihewsonj", "Rudrailhik", "Tweretnort", "Snatreetze", "Iwunddaracos", "Digarlewena", "Erquagsta", "Logovoloin", "Boyaghosganh", "Kuolungau", "Pehneldept", "Yevettiiqidcon", "Sahliacabru", "Noggalterpor", "Chmageaki", "Veticueca", "Vittesbursul", "Nootanore", "Innebdjerah", "Kisvarcini", "Cuzcogipper", "Pamanhermonsu", "Brotoghek", "Mibittara", "Huruahili", "Raldwicarn", "Ezdartlic", "Badesclema", "Isenkeyan", "Iadoitesu", "Yagrovoisi", "Ewcomechio", "Inunnunnoda", "Dischiutun", "Yuwarugha", "Ialmendra", "Reponudrle", "Rinjanagrbo", "Zeziceloh", "Oeileutasc", "Zicniijinis", "Dugnowarilda", "Neuxoisan", "Ilmenhorn", "Rukwatsuku", "Nepitzaspru", "Chcehoemig", "Haffneyrin", "Uliciawai", "Tuhgrespod", "Iousongola", "Odyalutai", "Yilsrussimil");
        aj.cf = null;
    }
    
    private aj(final Frame owner) {
        super(owner);
        this.cc = null;
        this.setResizable(this.cd = false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Coordinate Viewer");
        this.setModal(true);
        final JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel comp = new JPanel();
        comp.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("bottom:10px"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        final JLabel comp2 = new JLabel("Search:");
        comp2.putClientProperty("FlatLaf.styleClass", "semibold");
        comp.add(comp2, "2, 2, left, center");
        comp.add(this.m = new JTextField(), "4, 2, fill, default");
        final JButton comp3 = new JButton("Search");
        comp3.addActionListener(new ak(this));
        comp.add(comp3, "6, 2, fill, fill");
        final JLabel comp4 = new JLabel("Coordinate Location:");
        comp4.putClientProperty("FlatLaf.styleClass", "semibold");
        comp.add(comp4, "2, 6, 5, 1, left, center");
        comp.add(new JLabel("Galaxy:"), "2, 8, left, center");
        (this.bX = new JComboBox()).setModel(new al(this));
        comp.add(this.bX, "4, 8, 3, 1, fill, default");
        comp.add(new JLabel("Galactic Addr:"), "2, 10, left, center");
        (this.bY = new JTextField()).setEditable(false);
        comp.add(this.bY, "4, 10, 3, 1, fill, default");
        comp.add(new JLabel("Portal Addr:"), "2, 12, left, center");
        (this.bZ = new JTextField()).setEditable(false);
        comp.add(this.bZ, "4, 12, 3, 1, fill, default");
        final JPanel comp5 = new JPanel();
        comp5.setBackground(Color.GRAY);
        comp5.setBorder(new LineBorder(Color.DARK_GRAY));
        comp5.setLayout(new FlowLayout(1, 5, 5));
        comp5.setMinimumSize(new Dimension(449, 42));
        this.cb = new ImageIcon[16];
        for (int i = 0; i < 16; ++i) {
            this.cb[i] = Application.a("UI-GLYPH" + (i + 1) + ".PNG");
        }
        this.ca = new JLabel[12];
        for (int j = 0; j < 12; ++j) {
            comp5.add(this.ca[j] = new JLabel(this.cb[0]));
        }
        comp.add(comp5, "2, 14, 5, 1, fill, fill");
        contentPane.add(comp);
        final JPanel comp6 = new JPanel();
        comp6.setLayout(new FlowLayout(2));
        contentPane.add(comp6, "South");
        final JButton button = new JButton("Save / Warp");
        button.addActionListener(new am(this));
        comp6.add(button);
        this.getRootPane().setDefaultButton(button);
        final JButton comp7 = new JButton("Cancel");
        comp7.addActionListener(new an(this));
        comp6.add(comp7);
        this.getRootPane().registerKeyboardAction(new ao(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }
    
    private void P() {
        this.bX.setSelectedIndex((this.cc.es() >= aj.bW.size()) ? -1 : this.cc.es());
        this.bX.updateUI();
        this.bY.setText(this.cc.ez());
        final String ey = this.cc.ey();
        this.bZ.setText(ey);
        for (int i = 0; i < 12; ++i) {
            final int index = "0123456789ABCDEF".indexOf(ey.charAt(i));
            this.ca[i].setIcon((index < 0) ? null : this.cb[index]);
        }
    }
    
    private hl a(final hl cc) {
        this.cc = cc;
        this.m.setText("");
        this.P();
        this.cd = false;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.cd ? this.cc : null;
    }
    
    public static hl a(final Container parentComponent, final hl hl) {
        if (aj.cf == null) {
            aj.cf = new aj(JOptionPane.getFrameForComponent(parentComponent));
        }
        return aj.cf.a(hl);
    }
}
