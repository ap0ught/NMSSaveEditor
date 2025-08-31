// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.logging.LogRecord;
import java.util.logging.Handler;

class hd extends Handler
{
    @Override
    public void publish(final LogRecord logRecord) {
        log(logRecord);
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void close() {
    }
}
