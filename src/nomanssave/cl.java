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

public class cl extends JFileChooser
{
    private static cl fG;
    private static final String name = "Planetary Base Backup File";
    private static final ImageIcon fH;
    
    static {
        cl.fG = null;
        fH = Application.a("UI-BASEICON.PNG", 16, 16);
    }
    
    public static cl ar() {
        if (cl.fG == null) {
            cl.fG = new cl();
        }
        return cl.fG;
    }
    
    private cl() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new cm(this));
        this.setFileFilter(new cn(this));
        this.addChoosableFileFilter(new co(this));
        this.setDialogTitle("Choose Backup File");
        UIManager.addPropertyChangeListener(propertyChangeEvent2 -> {
            if ("lookAndFeel".equals(propertyChangeEvent2.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }
}
