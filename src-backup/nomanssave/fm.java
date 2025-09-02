package nomanssave;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

class fm extends Thread {
   final WatchService lk = FileSystems.getDefault().newWatchService();
   final Map ll = new WeakHashMap();

   fm() {
      this.setDaemon(true);
      this.start();
   }

   void a(fq var1, File var2) {
      WatchKey var3 = var2.toPath()
         .register(this.lk, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
      this.ll.put(var1, var3);
   }

   void b(fq var1) {
      WatchKey var2 = (WatchKey)this.ll.remove(var1);
      if (var2 != null) {
         var2.cancel();
      }
   }

   @Override
   public void run() {
      try {
         try {
            HashMap var1 = new HashMap();

            while (true) {
               WatchKey var3 = this.lk.take();

               do {
                  Object var2;
                  if (var1.containsKey(var3)) {
                     var2 = (List)var1.get(var3);
                  } else {
                     var2 = new ArrayList();
                     var1.put(var3, var2);
                  }

                  for (WatchEvent var4 : var3.pollEvents()) {
                     Kind var6 = var4.kind();
                     if (var6 != StandardWatchEventKinds.OVERFLOW) {
                        String var7 = var4.context().toString();
                        if (!var2.contains(var7)) {
                           var2.add(var7);
                        }
                     }
                  }

                  if (!var3.reset()) {
                     break;
                  }

                  var3 = this.lk.poll(500L, TimeUnit.MILLISECONDS);
               } while (var3 != null);

               synchronized (fl.bQ()) {
                  boolean var24 = false;

                  for (Entry var28 : var1.entrySet()) {
                     var3 = (WatchKey)var28.getKey();
                     List var22 = (List)var28.getValue();
                     var24 = false;

                     for (Entry var9 : this.ll.entrySet()) {
                        fq var26;
                        if (var9.getValue() == var3 && (var26 = (fq)var9.getKey()) != null) {
                           var24 = true;

                           for (String var11 : var22) {
                              var26.X(var11);
                           }
                        }
                     }

                     if (!var24) {
                        var3.cancel();
                     }
                  }

                  Object var27 = null;
               }

               var1.clear();
            }
         } finally {
            this.lk.close();
         }
      } catch (InterruptedException var20) {
      } catch (IOException var21) {
         hc.error("File watcher service error", var21);
      }
   }
}
