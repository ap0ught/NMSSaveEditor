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

public class cp extends JFileChooser
{
    private static cp fJ;
    private static final String name = "Companion Export File";
    private static final ImageIcon fK;
    private static final ImageIcon fL;
    
    static {
        cp.fJ = null;
        fK = Application.a("UI-PET.PNG", 16, 16);
        fL = Application.a("UI-EGG.PNG", 16, 16);
    }
    
    public static cp at() {
        if (cp.fJ == null) {
            cp.fJ = new cp();
        }
        return cp.fJ;
    }
    
    private cp() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new cq(this));
        this.setFileFilter(new cr(this));
        this.setDialogTitle("Choose Companion Export File");
        UIManager.addPropertyChangeListener(propertyChangeEvent2 -> {
            if ("lookAndFeel".equals(propertyChangeEvent2.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }
}
