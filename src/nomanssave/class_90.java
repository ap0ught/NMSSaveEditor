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

// $VF: renamed from: nomanssave.fm
class class_90 extends Thread {
   // $VF: renamed from: lk java.nio.file.WatchService
   final WatchService field_271 = FileSystems.getDefault().newWatchService();
   // $VF: renamed from: ll java.util.Map
   final Map field_272 = new WeakHashMap();

   class_90() {
      this.setDaemon(true);
      this.start();
   }

   // $VF: renamed from: a (nomanssave.fq, java.io.File) void
   void method_500(class_7 var1, File var2) {
      WatchKey var3 = var2.toPath()
         .register(this.field_271, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
      this.field_272.put(var1, var3);
   }

   // $VF: renamed from: b (nomanssave.fq) void
   void method_501(class_7 var1) {
      WatchKey var2 = (WatchKey)this.field_272.remove(var1);
      if (var2 != null) {
         var2.cancel();
      }
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      try {
         try {
            HashMap var1 = new HashMap();

            while (true) {
               WatchKey var3 = this.field_271.take();

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

                  var3 = this.field_271.poll(500L, TimeUnit.MILLISECONDS);
               } while (var3 != null);

               synchronized (class_91.method_504()) {
                  boolean var24 = false;

                  for (Entry var28 : var1.entrySet()) {
                     var3 = (WatchKey)var28.getKey();
                     List var22 = (List)var28.getValue();
                     var24 = false;

                     for (Entry var9 : this.field_272.entrySet()) {
                        class_7 var26;
                        if (var9.getValue() == var3 && (var26 = (class_7)var9.getKey()) != null) {
                           var24 = true;

                           for (String var11 : var22) {
                              var26.method_24(var11);
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
            this.field_271.close();
         }
      } catch (InterruptedException var20) {
      } catch (IOException var21) {
         class_37.error("File watcher service error", var21);
      }
   }
}
