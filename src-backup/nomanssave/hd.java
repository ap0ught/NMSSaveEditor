package nomanssave;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

class hd extends Handler {
   @Override
   public void publish(LogRecord var1) {
      hc.a(var1);
   }

   @Override
   public void flush() {
   }

   @Override
   public void close() {
   }
}
