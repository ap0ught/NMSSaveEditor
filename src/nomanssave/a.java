// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.KeyStroke;
import java.awt.Component;
import javax.swing.text.BadLocationException;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JDialog;

public class a extends JDialog
{
    private static a a;
    
    static {
        nomanssave.a.a = null;
    }
    
    private a(final Frame owner) {
        super(owner);
        this.setResizable(false);
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("About Save Editor");
        this.setModal(true);
        final JTextPane comp = new JTextPane();
        comp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        comp.setOpaque(false);
        try {
            final StyledDocument styledDocument = (StyledDocument)comp.getDocument();
            final SimpleAttributeSet a = new SimpleAttributeSet();
            StyleConstants.setBold(a, true);
            final SimpleAttributeSet set = new SimpleAttributeSet();
            styledDocument.insertString(styledDocument.getLength(), "No Man's Sky Save Editor\n\n", a);
            styledDocument.insertString(styledDocument.getLength(), "Version: 1.19.0\n", set);
            styledDocument.insertString(styledDocument.getLength(), "by GoatFungus\n\n", set);
            styledDocument.insertString(styledDocument.getLength(), "For further information visit:\n", set);
            styledDocument.insertString(styledDocument.getLength(), "https://github.com/goatfungus/NMSSaveEditor", set);
        }
        catch (final BadLocationException ex) {
            comp.setText("No Man's Sky Save Editor\r\n\r\nVersion: 1.19.0\r\nby GoatFungus\r\n\r\nFor further information visit:\r\nhttps://github.com/goatfungus/NMSSaveEditor");
        }
        comp.setEditable(false);
        this.getContentPane().add(comp, "Center");
        this.getRootPane().registerKeyboardAction(new b(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }
    
    public static void a(final Container parentComponent) {
        if (nomanssave.a.a == null) {
            nomanssave.a.a = new a(JOptionPane.getFrameForComponent(parentComponent));
        }
        nomanssave.a.a.setLocationRelativeTo(nomanssave.a.a.getParent());
        nomanssave.a.a.setVisible(true);
    }
}
