// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.ClipboardOwner;
import java.io.IOException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.datatransfer.DataFlavor;
import java.awt.Toolkit;
import java.util.Iterator;
import java.awt.Point;
import javax.swing.KeyStroke;
import java.awt.event.WindowListener;
import java.awt.Container;
import java.beans.PropertyChangeListener;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import javax.swing.event.DocumentListener;
import javax.swing.Action;
import java.awt.Component;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import java.awt.event.ComponentListener;
import java.awt.Dialog;
import java.awt.Rectangle;
import java.awt.Frame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JDialog;

public class cy extends JDialog implements TreeSelectionListener
{
    private String fS;
    private eY fT;
    private JButton fU;
    private JTree fV;
    private JScrollPane fW;
    private JTextArea fX;
    private JScrollPane fY;
    private cJ fZ;
    private boolean ga;
    private boolean gb;
    private static final String gc = "0123456789ABCDEFabcdef";
    private static cy gd;
    private boolean ge;
    private String gf;
    
    static {
        cy.gd = null;
    }
    
    private cy(final Application application) {
        super(application.g());
        this.ge = true;
        this.gf = "";
        this.fT = null;
        final Rectangle bounds = new Rectangle(100, 100, 1000, 700);
        final Point location = application.g().getLocation();
        bounds.x = aH.a("JSONEditor.X", location.x + 10);
        bounds.y = aH.a("JSONEditor.Y", location.y + 10);
        bounds.width = aH.a("JSONEditor.Width", 1000);
        bounds.height = aH.a("JSONEditor.Height", 700);
        this.setBounds(bounds);
        this.setDefaultCloseOperation(0);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("JSON Editor (Advanced Users Only)");
        this.setModal(true);
        this.addComponentListener(new cz(this));
        (this.fV = new JTree()).setModel(new cI(this, null));
        this.fV.setCellRenderer(new cA(this));
        this.fV.addTreeSelectionListener(this);
        (this.fW = new JScrollPane()).setViewportView(this.fV);
        (this.fX = new JTextArea()).putClientProperty("FlatLaf.styleClass", "monospaced");
        this.fX.setEditable(false);
        this.fX.setTabSize(4);
        this.fX.getActionMap().put("copy-to-clipboard", new cG(this));
        this.fX.getActionMap().put("paste-from-clipboard", new cH(this));
        this.fX.getDocument().addDocumentListener(new cB(this));
        (this.fY = new JScrollPane()).setRowHeaderView(new cW(this.fX));
        this.fY.setViewportView(this.fX);
        final JPanel newLeftComponent = new JPanel();
        newLeftComponent.setLayout(new BorderLayout());
        (this.fU = new JButton("Validate")).addActionListener(new cC(this));
        newLeftComponent.add(this.fU, "North");
        newLeftComponent.add(this.fW, "Center");
        final JSplitPane contentPane = new JSplitPane(1, newLeftComponent, this.fY);
        contentPane.setDividerLocation(aH.a("JSONEditor.Divider", 280));
        contentPane.addPropertyChangeListener("dividerLocation", new cD(this));
        this.setContentPane(contentPane);
        this.addWindowListener(new cE(this));
        final cF cf = new cF(this);
        this.fV.getInputMap().put(KeyStroke.getKeyStroke(70, 2), "find");
        this.fV.getActionMap().put("find", cf);
        this.fX.getInputMap().put(KeyStroke.getKeyStroke(70, 2), "find");
        this.fX.getActionMap().put("find", cf);
    }
    
    private boolean a(final String fs, final eY ft) {
        this.setTitle("JSON Editor (Advanced Users Only)");
        this.fS = fs;
        this.fT = ft;
        this.fX.setText("");
        this.ga = false;
        this.fZ = null;
        this.fV.updateUI();
        int selectionRow = 0;
        int n = 0;
        for (final String s : ft.names()) {
            ++n;
            if (ft.get(s) instanceof eY) {
                selectionRow = n;
                break;
            }
        }
        this.fV.setSelectionRow(selectionRow);
        this.gb = false;
        this.fV.setVisible(true);
        this.fU.setVisible(false);
        this.setVisible(true);
        return this.gb;
    }
    
    private static String ay() {
        String s;
        try {
            s = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        }
        catch (final UnsupportedFlavorException | IOException ex) {
            hc.error("Could not retrieve clipboard contents", (Throwable)ex);
            return "";
        }
        final StringBuffer sb = new StringBuffer();
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == '\r' || charArray[i] == '\n' || charArray[i] == '\t') {
                sb.append(charArray[i]);
            }
            else if (charArray[i] == '\f') {
                sb.append("\\f");
            }
            else if (charArray[i] == '\b') {
                sb.append("\\b");
            }
            else if (charArray[i] == '\u000b') {
                sb.append("\\v");
            }
            else if (charArray[i] == '\0') {
                sb.append("\\0");
            }
            else if (charArray[i] < ' ' || charArray[i] >= '\u0080') {
                sb.append("\\u");
                sb.append("0123456789ABCDEFabcdef".charAt(charArray[i] >> 12 & 0xF));
                sb.append("0123456789ABCDEFabcdef".charAt(charArray[i] >> 8 & 0xF));
                sb.append("0123456789ABCDEFabcdef".charAt(charArray[i] >> 4 & 0xF));
                sb.append("0123456789ABCDEFabcdef".charAt(charArray[i] & '\u000f'));
            }
            else {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }
    
    private static int a(final char ch) {
        int index = "0123456789ABCDEFabcdef".indexOf(ch);
        if (index < 0) {
            throw new RuntimeException("Error decoding hex");
        }
        if (index >= 16) {
            index -= 6;
        }
        return index;
    }
    
    private static void a(final String s, final ClipboardOwner owner) {
        final StringBuffer sb = new StringBuffer();
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == '\\' && i + 5 < charArray.length && charArray[i + 1] == 'u') {
                try {
                    final int n = a(charArray[i + 2]) << 12 | a(charArray[i + 3]) << 8 | a(charArray[i + 4]) << 4 | a(charArray[i + 5]);
                    if (n < 32) {
                        sb.append(charArray[i]);
                        sb.append(charArray[i + 1]);
                        sb.append(charArray[i + 2]);
                        sb.append(charArray[i + 3]);
                        sb.append(charArray[i + 4]);
                        sb.append(charArray[i + 5]);
                    }
                    else {
                        sb.append((char)n);
                    }
                    i += 5;
                }
                catch (final RuntimeException ex) {}
            }
            else {
                sb.append(charArray[i]);
            }
        }
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(sb.toString()), owner);
    }
    
    public static boolean a(final Application application, final String s, final eY ey) {
        if (cy.gd == null) {
            cy.gd = new cy(application);
        }
        return cy.gd.a(s, ey);
    }
    
    @Override
    public void valueChanged(final TreeSelectionEvent treeSelectionEvent) {
        if (!this.ge) {
            return;
        }
        if (this.ga && this.fZ != null) {
            try {
                final String trim = this.fX.getText().trim();
                if (trim.length() == 0 && JOptionPane.showConfirmDialog(this, "The JSON data has been deleted, do you wish to apply these changes to the save file?", this.getTitle(), 0) == 0) {
                    this.fZ.remove();
                    ((cI)this.fV.getModel()).a(this.fZ.gi);
                }
                else if (JOptionPane.showConfirmDialog(this, "The JSON data has changed, do you wish to apply these changes to the save file?", this.getTitle(), 0) == 0) {
                    this.fZ.setText(trim);
                    ((cI)this.fV.getModel()).a(this.fZ);
                }
            }
            catch (final eX ex) {
                JOptionPane.showOptionDialog(this, "Error on line #" + ex.getLineNumber() + ": " + ex.getMessage(), "Error", 0, 0, null, new Object[] { "Cancel" }, null);
                this.fX.setCaretPosition(ex.bD());
                this.fX.requestFocus();
                return;
            }
        }
        this.fZ = (cJ)this.fV.getLastSelectedPathComponent();
        if (this.fZ == null) {
            this.fX.setText("");
            this.fX.setEditable(false);
        }
        else {
            this.fX.setText(this.fZ.getText());
            this.fX.setEditable(true);
        }
        this.ga = false;
        this.fX.setCaretPosition(0);
        this.fX.requestFocus();
    }
    
    void a(String upperCase, final boolean b, final boolean b2, final boolean b3) {
        String s = this.fX.getText();
        if (!this.gf.equals(upperCase)) {
            final Highlighter highlighter = this.fX.getHighlighter();
            highlighter.removeAllHighlights();
            final DefaultHighlighter.DefaultHighlightPainter defaultHighlightPainter = new DefaultHighlighter.DefaultHighlightPainter(UIManager.getColor("JSONEditor.hiliteColor"));
            int index = -1;
            while ((index = s.indexOf(upperCase, index + 1)) >= 0) {
                try {
                    highlighter.addHighlight(index, index + upperCase.length(), defaultHighlightPainter);
                }
                catch (final BadLocationException ex) {}
            }
        }
        if (!b2) {
            s = s.toUpperCase();
            upperCase = upperCase.toUpperCase();
        }
        final int caretPosition = this.fX.getCaretPosition();
        int n = -1;
        if (b) {
            if (caretPosition > upperCase.length()) {
                n = s.lastIndexOf(upperCase, caretPosition - upperCase.length() - 1);
            }
            if (n < 0 && b3) {
                n = s.lastIndexOf(upperCase);
            }
        }
        else {
            if (caretPosition < s.length() - 1) {
                n = s.indexOf(upperCase, caretPosition + 1);
            }
            if (n < 0 && b3) {
                n = s.indexOf(upperCase);
            }
        }
        if (n < 0) {
            JOptionPane.showMessageDialog(this, "Text not found!");
        }
        else {
            this.fX.setCaretPosition(n);
            this.fX.setSelectionStart(n);
            this.fX.setSelectionEnd(n + upperCase.length());
        }
    }
}
