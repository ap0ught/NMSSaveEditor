// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.io.File;
import javax.swing.filechooser.FileView;

class cw extends FileView
{
    final /* synthetic */ cv fR;
    
    cw(final cv fr) {
        this.fR = fr;
    }
    
    @Override
    public Icon getIcon(final File f) {
        if (f.getName().endsWith(".wp0")) {
            return cv.fH;
        }
        return super.getIcon(f);
    }
    
    @Override
    public String getName(final File file) {
        final String name = file.getName();
        if (name.endsWith(".wp0")) {
            return name.substring(0, name.length() - 4);
        }
        return name;
    }
}
