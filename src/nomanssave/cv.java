// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class cv extends JFileChooser
{
    private static cv fQ;
    private static final String name = "Weapon Export File";
    private static final ImageIcon fH;
    
    static {
        cv.fQ = null;
        fH = Application.a("UI-WEAPONICON.PNG", 16, 16);
    }
    
    public static cv ax() {
        if (cv.fQ == null) {
            cv.fQ = new cv();
        }
        return cv.fQ;
    }
    
    private cv() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new cw(this));
        this.setFileFilter(new cx(this));
        this.setDialogTitle("Choose Weapon Export File");
        UIManager.addPropertyChangeListener(propertyChangeEvent2 -> {
            if ("lookAndFeel".equals(propertyChangeEvent2.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }
}
