package com.formdev.flatlaf.util;

import com.formdev.flatlaf.FlatLaf;
import java.util.logging.Level;
import java.util.logging.Logger;

class LoggingFacadeImpl implements LoggingFacade {
   // $VF: renamed from: LOG java.util.logging.Logger
   private static final Logger field_3 = Logger.getLogger(FlatLaf.class.getName());

   @Override
   public void logSevere(String message, Throwable t) {
      field_3.log(Level.SEVERE, message, t);
   }

   @Override
   public void logConfig(String message, Throwable t) {
      field_3.log(Level.CONFIG, message, t);
   }
}
