// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.io.File;
import javax.swing.filechooser.FileView;

class ct extends FileView
{
    final /* synthetic */ cs fP;
    
    ct(final cs fp) {
        this.fP = fp;
    }
    
    @Override
    public Icon getIcon(final File f) {
        if (f.getName().endsWith(".fb3")) {
            return cs.fH;
        }
        return super.getIcon(f);
    }
    
    @Override
    public String getName(final File file) {
        final String name = file.getName();
        if (name.endsWith(".fb3")) {
            return name.substring(0, name.length() - 4);
        }
        return name;
    }
}
