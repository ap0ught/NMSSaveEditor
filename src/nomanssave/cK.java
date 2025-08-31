// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import javax.swing.JFileChooser;

public class cK extends JFileChooser
{
    private static cK gk;
    private static final String name = "JSON File";
    
    static {
        cK.gk = null;
    }
    
    public static cK aA() {
        if (cK.gk == null) {
            cK.gk = new cK();
        }
        return cK.gk;
    }
    
    private cK() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new cL(this));
        this.setFileFilter(new cM(this));
        this.setDialogTitle("Choose JSON File");
    }
}
