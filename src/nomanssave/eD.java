// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

class eD extends eE
{
    private final String version;
    
    private eD(final InputStream in, final String version) {
        super(null);
        this.version = version;
        final ArrayList list = new ArrayList();
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    if (line.length() == 0) {
                        continue;
                    }
                    final int index = line.indexOf("\t");
                    if (index < 0) {
                        hc.debug("Mapping not available: " + line);
                        list.add(line);
                    }
                    else {
                        final String substring = line.substring(0, index);
                        final String substring2 = line.substring(index + 1, line.length());
                        final eF t;
                        if ((t = this.t(substring)) != null) {
                            if (!substring2.equals(t.name)) {
                                throw new IOException("Mapping error: " + substring);
                            }
                            hc.debug("Mapping duplicated: " + substring);
                        }
                        else {
                            final eF u;
                            if ((u = this.u(substring2)) != null) {
                                if (!substring.equals(u.key)) {
                                    throw new IOException("Reverse error: " + substring2);
                                }
                                hc.debug("Reverse duplicated: " + substring2);
                            }
                            else {
                                this.add(substring, substring2);
                            }
                        }
                    }
                }
                catch (final RuntimeException ex) {
                    hc.a("Ignoring: " + line, ex);
                }
            }
        }
        finally {
            bufferedReader.close();
        }
        bufferedReader.close();
        for (final String s : list) {
            if (this.t(s) != null) {
                throw new IOException("Mapping error: " + s);
            }
            if (this.u(s) != null) {
                throw new IOException("Reverse error: " + s);
            }
            this.add(s, s);
        }
    }
    
    @Override
    public String toString() {
        return this.version;
    }
}
