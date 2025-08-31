package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

// $VF: renamed from: nomanssave.aj
public class class_325 extends JDialog {
   // $VF: renamed from: bW java.util.List
   private static final List field_1063 = Arrays.asList(
      "Euclid",
      "Hilbert Dimension",
      "Calypso",
      "Hesperius Dimension",
      "Hyades",
      "Ickjamatew",
      "Budullangr",
      "Kikolgallr",
      "Eltiensleen",
      "Eissentam",
      "Elkupalos",
      "Aptarkaba",
      "Ontiniangp",
      "Odiwagiri",
      "Ogtialabi",
      "Muhacksonto",
      "Hitonskyer",
      "Rerasmutul",
      "Isdoraijung",
      "Doctinawyra",
      "Loychazinq",
      "Zukasizawa",
      "Ekwathore",
      "Yeberhahne",
      "Twerbetek",
      "Sivarates",
      "Eajerandal",
      "Aldukesci",
      "Wotyarogii",
      "Sudzerbal",
      "Maupenzhay",
      "Sugueziume",
      "Brogoweldian",
      "Ehbogdenbu",
      "Ijsenufryos",
      "Nipikulha",
      "Autsurabin",
      "Lusontrygiamh",
      "Rewmanawa",
      "Ethiophodhe",
      "Urastrykle",
      "Xobeurindj",
      "Oniijialdu",
      "Wucetosucc",
      "Ebyeloofdud",
      "Odyavanta",
      "Milekistri",
      "Waferganh",
      "Agnusopwit",
      "Teyaypilny",
      "Zalienkosm",
      "Ladgudiraf",
      "Mushonponte",
      "Amsentisz",
      "Fladiselm",
      "Laanawemb",
      "Ilkerloor",
      "Davanossi",
      "Ploehrliou",
      "Corpinyaya",
      "Leckandmeram",
      "Quulngais",
      "Nokokipsechl",
      "Rinblodesa",
      "Loydporpen",
      "Ibtrevskip",
      "Elkowaldb",
      "Heholhofsko",
      "Yebrilowisod",
      "Husalvangewi",
      "Ovna'uesed",
      "Bahibusey",
      "Nuybeliaure",
      "Doshawchuc",
      "Ruckinarkh",
      "Thorettac",
      "Nuponoparau",
      "Moglaschil",
      "Uiweupose",
      "Nasmilete",
      "Ekdaluskin",
      "Hakapanasy",
      "Dimonimba",
      "Cajaccari",
      "Olonerovo",
      "Umlanswick",
      "Henayliszm",
      "Utzenmate",
      "Umirpaiya",
      "Paholiang",
      "Iaereznika",
      "Yudukagath",
      "Boealalosnj",
      "Yaevarcko",
      "Coellosipp",
      "Wayndohalou",
      "Smoduraykl",
      "Apmaneessu",
      "Hicanpaav",
      "Akvasanta",
      "Tuychelisaor",
      "Rivskimbe",
      "Daksanquix",
      "Kissonlin",
      "Aediabiel",
      "Ulosaginyik",
      "Roclaytonycar",
      "Kichiaroa",
      "Irceauffey",
      "Nudquathsenfe",
      "Getaizakaal",
      "Hansolmien",
      "Bloytisagra",
      "Ladsenlay",
      "Luyugoslasr",
      "Ubredhatk",
      "Cidoniana",
      "Jasinessa",
      "Torweierf",
      "Saffneckm",
      "Thnistner",
      "Dotusingg",
      "Luleukous",
      "Jelmandan",
      "Otimanaso",
      "Enjaxusanto",
      "Sezviktorew",
      "Zikehpm",
      "Bephembah",
      "Broomerrai",
      "Meximicka",
      "Venessika",
      "Gaiteseling",
      "Zosakasiro",
      "Drajayanes",
      "Ooibekuar",
      "Urckiansi",
      "Dozivadido",
      "Emiekereks",
      "Meykinunukur",
      "Kimycuristh",
      "Roansfien",
      "Isgarmeso",
      "Daitibeli",
      "Gucuttarik",
      "Enlaythie",
      "Drewweste",
      "Akbulkabi",
      "Homskiw",
      "Zavainlani",
      "Jewijkmas",
      "Itlhotagra",
      "Podalicess",
      "Hiviusauer",
      "Halsebenk",
      "Puikitoac",
      "Gaybakuaria",
      "Grbodubhe",
      "Rycempler",
      "Indjalala",
      "Fontenikk",
      "Pasycihelwhee",
      "Ikbaksmit",
      "Telicianses",
      "Oyleyzhan",
      "Uagerosat",
      "Impoxectin",
      "Twoodmand",
      "Hilfsesorbs",
      "Ezdaranit",
      "Wiensanshe",
      "Ewheelonc",
      "Litzmantufa",
      "Emarmatosi",
      "Mufimbomacvi",
      "Wongquarum",
      "Hapirajua",
      "Igbinduina",
      "Wepaitvas",
      "Sthatigudi",
      "Yekathsebehn",
      "Ebedeagurst",
      "Nolisonia",
      "Ulexovitab",
      "Iodhinxois",
      "Irroswitzs",
      "Bifredait",
      "Beiraghedwe",
      "Yeonatlak",
      "Cugnatachh",
      "Nozoryenki",
      "Ebralduri",
      "Evcickcandj",
      "Ziybosswin",
      "Heperclait",
      "Sugiuniam",
      "Aaseertush",
      "Uglyestemaa",
      "Horeroedsh",
      "Drundemiso",
      "Ityanianat",
      "Purneyrine",
      "Dokiessmat",
      "Nupiacheh",
      "Dihewsonj",
      "Rudrailhik",
      "Tweretnort",
      "Snatreetze",
      "Iwunddaracos",
      "Digarlewena",
      "Erquagsta",
      "Logovoloin",
      "Boyaghosganh",
      "Kuolungau",
      "Pehneldept",
      "Yevettiiqidcon",
      "Sahliacabru",
      "Noggalterpor",
      "Chmageaki",
      "Veticueca",
      "Vittesbursul",
      "Nootanore",
      "Innebdjerah",
      "Kisvarcini",
      "Cuzcogipper",
      "Pamanhermonsu",
      "Brotoghek",
      "Mibittara",
      "Huruahili",
      "Raldwicarn",
      "Ezdartlic",
      "Badesclema",
      "Isenkeyan",
      "Iadoitesu",
      "Yagrovoisi",
      "Ewcomechio",
      "Inunnunnoda",
      "Dischiutun",
      "Yuwarugha",
      "Ialmendra",
      "Reponudrle",
      "Rinjanagrbo",
      "Zeziceloh",
      "Oeileutasc",
      "Zicniijinis",
      "Dugnowarilda",
      "Neuxoisan",
      "Ilmenhorn",
      "Rukwatsuku",
      "Nepitzaspru",
      "Chcehoemig",
      "Haffneyrin",
      "Uliciawai",
      "Tuhgrespod",
      "Iousongola",
      "Odyalutai",
      "Yilsrussimil"
   );
   // $VF: renamed from: bX javax.swing.JComboBox
   private JComboBox field_1064;
   // $VF: renamed from: bY javax.swing.JTextField
   private JTextField field_1065;
   // $VF: renamed from: bZ javax.swing.JTextField
   private JTextField field_1066;
   // $VF: renamed from: ca javax.swing.JLabel[]
   private JLabel[] field_1067;
   // $VF: renamed from: m javax.swing.JTextField
   private JTextField field_1068;
   // $VF: renamed from: cb javax.swing.ImageIcon[]
   private ImageIcon[] field_1069;
   // $VF: renamed from: cc nomanssave.hl
   private class_30 field_1070 = null;
   // $VF: renamed from: cd boolean
   private boolean field_1071 = false;
   // $VF: renamed from: ce java.lang.String
   private static final String field_1072 = "0123456789ABCDEF";
   // $VF: renamed from: cf nomanssave.aj
   private static class_325 field_1073 = null;

   private class_325(Frame var1) {
      super(var1);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Coordinate Viewer");
      this.setModal(true);
      JPanel var2 = new JPanel();
      this.setContentPane(var2);
      var2.setLayout(new BorderLayout(0, 0));
      JPanel var3 = new JPanel();
      var3.setLayout(
         new FormLayout(
            new ColumnSpec[]{
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("100px"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("default:grow"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
               ColumnSpec.decode("100px"),
               FormFactory.LABEL_COMPONENT_GAP_COLSPEC
            },
            new RowSpec[]{
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               RowSpec.decode("bottom:10px"),
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC,
               FormFactory.DEFAULT_ROWSPEC,
               FormFactory.LINE_GAP_ROWSPEC
            }
         )
      );
      JLabel var4 = new JLabel("Search:");
      var4.putClientProperty("FlatLaf.styleClass", "semibold");
      var3.add(var4, "2, 2, left, center");
      this.field_1068 = new JTextField();
      var3.add(this.field_1068, "4, 2, fill, default");
      JButton var5 = new JButton("Search");
      var5.addActionListener(new class_268(this));
      var3.add(var5, "6, 2, fill, fill");
      JLabel var6 = new JLabel("Coordinate Location:");
      var6.putClientProperty("FlatLaf.styleClass", "semibold");
      var3.add(var6, "2, 6, 5, 1, left, center");
      JLabel var7 = new JLabel("Galaxy:");
      var3.add(var7, "2, 8, left, center");
      this.field_1064 = new JComboBox();
      this.field_1064.setModel(new class_267(this));
      var3.add(this.field_1064, "4, 8, 3, 1, fill, default");
      JLabel var8 = new JLabel("Galactic Addr:");
      var3.add(var8, "2, 10, left, center");
      this.field_1065 = new JTextField();
      this.field_1065.setEditable(false);
      var3.add(this.field_1065, "4, 10, 3, 1, fill, default");
      JLabel var9 = new JLabel("Portal Addr:");
      var3.add(var9, "2, 12, left, center");
      this.field_1066 = new JTextField();
      this.field_1066.setEditable(false);
      var3.add(this.field_1066, "4, 12, 3, 1, fill, default");
      JPanel var10 = new JPanel();
      var10.setBackground(Color.GRAY);
      var10.setBorder(new LineBorder(Color.DARK_GRAY));
      var10.setLayout(new FlowLayout(1, 5, 5));
      var10.setMinimumSize(new Dimension(449, 42));
      this.field_1069 = new ImageIcon[16];

      for (int var11 = 0; var11 < 16; var11++) {
         this.field_1069[var11] = Application.method_1324("UI-GLYPH" + (var11 + 1) + ".PNG");
      }

      this.field_1067 = new JLabel[12];

      for (int var14 = 0; var14 < 12; var14++) {
         this.field_1067[var14] = new JLabel(this.field_1069[0]);
         var10.add(this.field_1067[var14]);
      }

      var3.add(var10, "2, 14, 5, 1, fill, fill");
      var2.add(var3);
      JPanel var15 = new JPanel();
      var15.setLayout(new FlowLayout(2));
      var2.add(var15, "South");
      JButton var12 = new JButton("Save / Warp");
      var12.addActionListener(new class_266(this));
      var15.add(var12);
      this.getRootPane().setDefaultButton(var12);
      JButton var13 = new JButton("Cancel");
      var13.addActionListener(new class_265(this));
      var15.add(var13);
      this.getRootPane().registerKeyboardAction(new class_264(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.pack();
   }

   // $VF: renamed from: P () void
   private void method_947() {
      this.field_1064.setSelectedIndex(this.field_1070.method_104() >= field_1063.size() ? -1 : this.field_1070.method_104());
      this.field_1064.updateUI();
      this.field_1065.setText(this.field_1070.method_115());
      String var1 = this.field_1070.method_114();
      this.field_1066.setText(var1);

      for (int var2 = 0; var2 < 12; var2++) {
         int var3 = "0123456789ABCDEF".indexOf(var1.charAt(var2));
         this.field_1067[var2].setIcon(var3 < 0 ? null : this.field_1069[var3]);
      }
   }

   // $VF: renamed from: a (nomanssave.hl) nomanssave.hl
   private class_30 method_948(class_30 var1) {
      this.field_1070 = var1;
      this.field_1068.setText("");
      this.method_947();
      this.field_1071 = false;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.field_1071 ? this.field_1070 : null;
   }

   // $VF: renamed from: a (java.awt.Container, nomanssave.hl) nomanssave.hl
   public static class_30 method_949(Container var0, class_30 var1) {
      if (field_1073 == null) {
         Frame var2 = JOptionPane.getFrameForComponent(var0);
         field_1073 = new class_325(var2);
      }

      return field_1073.method_948(var1);
   }
}
