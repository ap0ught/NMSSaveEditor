// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.beans.PropertyChangeEvent;
import java.util.regex.Matcher;
import java.io.File;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileView;
import javax.swing.filechooser.FileFilter;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class ej extends JFileChooser
{
    private static final ImageIcon im;
    private static final ImageIcon io;
    private static final ImageIcon ip;
    private static final Pattern iq;
    private static ej ir;
    
    static {
        im = Application.a("UI-FILEICON.PNG", 16, 16);
        io = Application.a("UI-GAMEPASS.PNG", 16, 16);
        ip = Application.a("UI-STEAMLOGO.PNG", 16, 16);
        iq = Pattern.compile("st_(\\d*)");
        ej.ir = null;
    }
    
    private ej() {
        this.setFileSelectionMode(2);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileFilter(new ek(this));
        this.setFileView(new el(this));
        this.setDialogTitle("Choose Save Path");
        UIManager.addPropertyChangeListener(propertyChangeEvent2 -> {
            if ("lookAndFeel".equals(propertyChangeEvent2.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }
    
    private String a(final File file) {
        final Matcher matcher = ej.iq.matcher(file.getName());
        if (matcher.matches()) {
            return hi.h(Long.parseLong(matcher.group(1)));
        }
        return null;
    }
    
    public static File b(File parentFile) {
        if (ej.ir == null) {
            ej.ir = new ej();
        }
        if (parentFile != null && parentFile.exists()) {
            if (parentFile.isFile()) {
                parentFile = parentFile.getParentFile();
            }
            ej.ir.setCurrentDirectory(parentFile);
        }
        else {
            final File currentDirectory = new File(System.getProperty("user.home"));
            final File currentDirectory2 = new File(currentDirectory, "AppData\\Roaming\\HelloGames\\NMS");
            final File currentDirectory3 = new File(currentDirectory, "AppData\\Local\\Packages\\HelloGames.NoMansSky_bs190hzg1sesy\\SystemAppData");
            if (currentDirectory2.isDirectory()) {
                ej.ir.setCurrentDirectory(currentDirectory2);
            }
            else if (currentDirectory3.isDirectory()) {
                ej.ir.setCurrentDirectory(currentDirectory3);
            }
            else {
                ej.ir.setCurrentDirectory(currentDirectory);
            }
        }
        if (ej.ir.showOpenDialog(null) == 0) {
            return ej.ir.getSelectedFile();
        }
        return null;
    }
}
