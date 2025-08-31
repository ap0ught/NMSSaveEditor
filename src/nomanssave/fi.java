// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.function.Predicate;
import java.io.IOException;
import java.io.StringReader;

class fi extends StringReader
{
    int kF;
    int kG;
    
    fi(final String s) {
        super(s);
        this.kF = 1;
        this.kG = 0;
    }
    
    public int bI() {
        int read;
        while ((read = this.read()) >= 0) {
            if (read != 32 && read != 13 && read != 10 && read != 9) {
                return read;
            }
        }
        return -1;
    }
    
    @Override
    public int read() {
        int read;
        try {
            read = super.read();
        }
        catch (final IOException ex) {
            throw new eX("stream error", ex, this.kF, this.kG);
        }
        if (read == 10) {
            ++this.kF;
        }
        ++this.kG;
        return read;
    }
    
    private int a(final Predicate predicate) {
        try {
            this.mark(1);
            final int read = super.read();
            if (read >= 0 && predicate.test(read)) {
                if (read == 10) {
                    ++this.kF;
                }
                ++this.kG;
                return read;
            }
            this.reset();
        }
        catch (final IOException ex) {
            throw new eX("stream error", ex, this.kF, this.kG);
        }
        return -1;
    }
}
