// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.InputStream;
import java.net.URLConnection;
import java.io.IOException;
import java.io.FileOutputStream;
import java.net.URL;
import java.io.File;
import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JOptionPane;

class y implements Runnable
{
    final /* synthetic */ x bb;
    private final /* synthetic */ boolean ba;
    
    y(final x bb, final boolean ba) {
        this.bb = bb;
        this.ba = ba;
    }
    
    @Override
    public void run() {
        final String s = "A newer version of the save editor is available.\n";
        if (!this.ba) {
            JOptionPane.showOptionDialog(this.bb.aZ.N, String.valueOf(s) + "Please visit https://github.com/goatfungus/NMSSaveEditor to download the latest release.", "New Version Available", 0, 1, null, new Object[] { "OK" }, null);
        }
        else if (JOptionPane.showConfirmDialog(this.bb.aZ.N, String.valueOf(s) + "Would you like to download and install? (will require app restart)", "New Version Available", 0) == 0) {
            this.bb.aZ.N.dispose();
            hc.info("Starting download...");
            final File file = new File("~NMSSaveEditor.dl");
            try {
                final URLConnection openConnection = new URL("https://github.com/goatfungus/NMSSaveEditor/raw/master/NMSSaveEditor.jar").openConnection();
                int contentLength = openConnection.getContentLength();
                final InputStream inputStream = openConnection.getInputStream();
                final FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    final byte[] array = new byte[4096];
                    int read;
                    while ((read = inputStream.read(array)) > 0) {
                        fileOutputStream.write(array, 0, read);
                        contentLength -= read;
                    }
                    if (contentLength != 0) {
                        throw new IOException("invalid file size");
                    }
                }
                finally {
                    fileOutputStream.close();
                }
                fileOutputStream.close();
                hc.info("Restarting editor...");
                System.exit(2);
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                file.delete();
                System.exit(1);
            }
        }
    }
}
