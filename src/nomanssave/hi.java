// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.InputStream;
import java.net.URLConnection;
import java.io.EOFException;
import java.net.URL;
import java.util.HashMap;

public class hi
{
    private static final String sI = "9710BD8FCF192837DC6DEF6037AB2837";
    private static final HashMap sJ;
    
    static {
        sJ = new HashMap();
    }
    
    public static String h(final long n) {
        hj hj;
        synchronized (hi.sJ) {
            if (hi.sJ.containsKey(n)) {
                hj = hi.sJ.get(n);
            }
            else {
                hj = new hj(n);
            }
            monitorexit(hi.sJ);
        }
        try {
            hj.join(500L);
        }
        catch (final InterruptedException ex) {}
        return hj.sL;
    }
    
    private static String i(final long n) {
        final eV d = aC("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=9710BD8FCF192837DC6DEF6037AB2837&steamids=" + n).d("response.players");
        if (d == null || d.size() == 0) {
            return null;
        }
        for (int i = 0; i < d.size(); ++i) {
            final eY v = d.V(i);
            if (Long.toString(n).equals(v.getValueAsString("steamid"))) {
                return v.getValueAsString("personaname");
            }
        }
        return null;
    }
    
    private static eY aC(final String spec) {
        final URLConnection openConnection = new URL(spec).openConnection();
        int contentLength;
        int off;
        InputStream inputStream;
        byte[] array;
        int read;
        for (contentLength = openConnection.getContentLength(), off = 0, inputStream = openConnection.getInputStream(), array = new byte[contentLength]; (read = inputStream.read(array, off, contentLength)) >= 0; off += read, contentLength -= read) {}
        if (contentLength > 0) {
            throw new EOFException();
        }
        final String contentEncoding = openConnection.getContentEncoding();
        return eY.E(new String(array, (contentEncoding == null) ? "UTF-8" : contentEncoding));
    }
}
