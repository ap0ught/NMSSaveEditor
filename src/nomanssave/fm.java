// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Iterator;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.nio.file.WatchKey;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.io.File;
import java.util.WeakHashMap;
import java.nio.file.FileSystems;
import java.util.Map;
import java.nio.file.WatchService;

class fm extends Thread
{
    final WatchService lk;
    final Map ll;
    
    fm() {
        this.lk = FileSystems.getDefault().newWatchService();
        this.ll = new WeakHashMap();
        this.setDaemon(true);
        this.start();
    }
    
    void a(final fq fq, final File file) {
        this.ll.put(fq, file.toPath().register(this.lk, (WatchEvent.Kind<?>[])new WatchEvent.Kind[] { (WatchEvent.Kind)StandardWatchEventKinds.ENTRY_CREATE, (WatchEvent.Kind)StandardWatchEventKinds.ENTRY_DELETE, (WatchEvent.Kind)StandardWatchEventKinds.ENTRY_MODIFY }));
    }
    
    void b(final fq fq) {
        final WatchKey watchKey = this.ll.remove(fq);
        if (watchKey != null) {
            watchKey.cancel();
        }
    }
    
    @Override
    public void run() {
        try {
            try {
                final HashMap hashMap = new HashMap();
                while (true) {
                    WatchKey watchKey = this.lk.take();
                    do {
                        Object o;
                        if (hashMap.containsKey(watchKey)) {
                            o = hashMap.get(watchKey);
                        }
                        else {
                            o = new ArrayList();
                            hashMap.put(watchKey, o);
                        }
                        for (final WatchEvent watchEvent : watchKey.pollEvents()) {
                            if (watchEvent.kind() == StandardWatchEventKinds.OVERFLOW) {
                                continue;
                            }
                            final String string = watchEvent.context().toString();
                            if (((List)o).contains(string)) {
                                continue;
                            }
                            ((List)o).add(string);
                        }
                        if (!watchKey.reset()) {
                            break;
                        }
                        watchKey = this.lk.poll(500L, TimeUnit.MILLISECONDS);
                    } while (watchKey != null);
                    synchronized (fl.lock) {
                        for (final Map.Entry<WatchKey, V> entry : hashMap.entrySet()) {
                            final WatchKey watchKey2 = entry.getKey();
                            final List list = (List)entry.getValue();
                            boolean b = false;
                            for (final Map.Entry<fq, V> entry2 : this.ll.entrySet()) {
                                final fq fq;
                                if (entry2.getValue() == watchKey2 && (fq = entry2.getKey()) != null) {
                                    b = true;
                                    final Iterator iterator4 = list.iterator();
                                    while (iterator4.hasNext()) {
                                        fq.X((String)iterator4.next());
                                    }
                                }
                            }
                            if (!b) {
                                watchKey2.cancel();
                            }
                        }
                        monitorexit(fl.lock);
                    }
                    hashMap.clear();
                }
            }
            finally {
                this.lk.close();
            }
        }
        catch (final InterruptedException ex) {}
        catch (final IOException ex2) {
            hc.error("File watcher service error", ex2);
        }
    }
}
