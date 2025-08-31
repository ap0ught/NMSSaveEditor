// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import com.formdev.flatlaf.FlatLaf;
import java.util.logging.Level;
import java.util.logging.Logger;

class LoggingFacadeImpl implements LoggingFacade
{
    private static final Logger LOG;
    
    @Override
    public void logSevere(final String message, final Throwable t) {
        LoggingFacadeImpl.LOG.log(Level.SEVERE, message, t);
    }
    
    @Override
    public void logConfig(final String message, final Throwable t) {
        LoggingFacadeImpl.LOG.log(Level.CONFIG, message, t);
    }
    
    static {
        LOG = Logger.getLogger(FlatLaf.class.getName());
    }
}
