// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.JComponent;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class cs extends JFileChooser
{
    private static cs fN;
    private static final String name = "Freighter Backup File";
    private static final ImageIcon fH;
    private JCheckBox fO;
    
    static {
        cs.fN = null;
        fH = Application.a("UI-FREIGHTERICON.PNG", 16, 16);
    }
    
    public static cs av() {
        if (cs.fN == null) {
            cs.fN = new cs();
        }
        return cs.fN;
    }
    
    private cs() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new ct(this));
        this.setFileFilter(new cu(this));
        this.setDialogTitle("Choose Backup File");
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 2));
        panel.add(new JLabel("Export Options:"));
        panel.add(this.fO = new JCheckBox("Products/Substances"));
        this.setAccessory(panel);
        UIManager.addPropertyChangeListener(propertyChangeEvent2 -> {
            if ("lookAndFeel".equals(propertyChangeEvent2.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }
    
    public boolean aw() {
        return this.fO.isSelected();
    }
    
    @Override
    public int showSaveDialog(final Component parent) {
        this.getAccessory().setVisible(true);
        return super.showSaveDialog(parent);
    }
    
    @Override
    public int showOpenDialog(final Component parent) {
        this.getAccessory().setVisible(false);
        return super.showOpenDialog(parent);
    }
}
