// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import javax.swing.Icon;
import java.io.File;
import javax.swing.filechooser.FileView;

class cm extends FileView
{
    final /* synthetic */ cl fI;
    
    cm(final cl fi) {
        this.fI = fi;
    }
    
    @Override
    public Icon getIcon(final File f) {
        final String name = f.getName();
        if (name.endsWith(".pb3") || name.endsWith(".pb0")) {
            return cl.fH;
        }
        return super.getIcon(f);
    }
    
    @Override
    public String getName(final File file) {
        final String name = file.getName();
        if (name.endsWith(".pb3") || name.endsWith(".pb0")) {
            return name.substring(0, name.length() - 4);
        }
        return name;
    }
}
