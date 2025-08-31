// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.InputStream;
import java.net.URLConnection;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.URL;

class x extends Thread
{
    final /* synthetic */ Application aZ;
    private final /* synthetic */ boolean ba;
    
    x(final Application az, final boolean ba) {
        this.aZ = az;
        this.ba = ba;
    }
    
    @Override
    public void run() {
        try {
            hc.debug("Mem Usage: " + Math.round(Runtime.getRuntime().totalMemory() / 1000000.0) + "/" + Math.round(Runtime.getRuntime().maxMemory() / 1000000.0) + " MB");
            final URLConnection openConnection = new URL("https://github.com/goatfungus/NMSSaveEditor/raw/master/VERSION.txt").openConnection();
            int contentLength = openConnection.getContentLength();
            final InputStream inputStream = openConnection.getInputStream();
            final byte[] array = new byte[contentLength];
            int read;
            for (int off = 0; (read = inputStream.read(array, off, contentLength)) > 0; off += read, contentLength -= read) {}
            if (contentLength > 0) {
                throw new IOException("short read");
            }
            String s = new String(array, 0, array.length);
            if (s.endsWith("\r\n")) {
                s = s.substring(0, s.length() - 2);
            }
            else if (s.endsWith("\n")) {
                s = s.substring(0, s.length() - 1);
            }
            hc.debug("Latest version: \"" + s + "\"");
            hc.debug("Current version: \"1.19.0\"");
            if (!"1.19.0".equals(s)) {
                EventQueue.invokeLater(new y(this, this.ba));
            }
        }
        catch (final IOException ex) {}
    }
}
