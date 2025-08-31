// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Arrays;
import java.io.IOException;

class hj extends Thread
{
    final long sK;
    String sL;
    
    hj(final long l) {
        this.sK = l;
        this.sL = aH.getProperty("KnownPlayers." + l);
        hi.sJ.put(l, this);
        this.start();
    }
    
    @Override
    public void run() {
        String j;
        try {
            j = i(this.sK);
        }
        catch (final IOException ex) {
            hc.a("Steam lookup error", ex);
            j = null;
        }
        synchronized (hi.sJ) {
            if (j != null) {
                final Long[] a = (Long[])aH.a("SteamIDs", Long.class);
                if (!Arrays.asList(a).stream().anyMatch(n -> n.equals(this.sK))) {
                    final Long[] array = new Long[a.length + 1];
                    System.arraycopy(a, 0, array, 0, a.length);
                    array[a.length] = this.sK;
                    aH.a("SteamIDs", array);
                }
                if (!j.equals(this.sL)) {
                    aH.setProperty("KnownPlayers." + this.sK, j);
                    this.sL = j;
                }
            }
            monitorexit(hi.sJ);
        }
    }
}
