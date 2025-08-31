// 
// Decompiled by Procyon v0.6.0
// 

package com.formdev.flatlaf.util;

import java.lang.ref.SoftReference;
import java.lang.ref.Reference;
import java.util.function.BiFunction;
import java.util.function.BiConsumer;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;
import java.lang.ref.ReferenceQueue;
import java.util.Map;

public class SoftCache<K, V> implements Map<K, V>
{
    private final Map<K, CacheReference<K, V>> map;
    private final ReferenceQueue<V> queue;
    
    public SoftCache() {
        this.queue = new ReferenceQueue<V>();
        this.map = new HashMap<K, CacheReference<K, V>>();
    }
    
    public SoftCache(final int initialCapacity) {
        this.queue = new ReferenceQueue<V>();
        this.map = new HashMap<K, CacheReference<K, V>>(initialCapacity);
    }
    
    @Override
    public int size() {
        this.expungeStaleEntries();
        return this.map.size();
    }
    
    @Override
    public boolean isEmpty() {
        this.expungeStaleEntries();
        return this.map.isEmpty();
    }
    
    @Override
    public boolean containsKey(final Object key) {
        this.expungeStaleEntries();
        return this.map.containsKey(key);
    }
    
    @Override
    public boolean containsValue(final Object value) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public V get(final Object key) {
        this.expungeStaleEntries();
        return this.getRef(this.map.get(key));
    }
    
    @Override
    public V put(final K key, final V value) {
        this.expungeStaleEntries();
        return this.getRef(this.map.put(key, new CacheReference<K, V>(key, value, this.queue)));
    }
    
    @Override
    public V remove(final Object key) {
        this.expungeStaleEntries();
        return this.getRef(this.map.remove(key));
    }
    
    private V getRef(final CacheReference<K, V> ref) {
        return (ref != null) ? ref.get() : null;
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> m) {
        this.expungeStaleEntries();
        for (final Entry<? extends K, ? extends V> e : m.entrySet()) {
            this.put(e.getKey(), e.getValue());
        }
    }
    
    @Override
    public void clear() {
        this.map.clear();
        this.expungeStaleEntries();
    }
    
    @Override
    public Set<K> keySet() {
        this.expungeStaleEntries();
        return this.map.keySet();
    }
    
    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void forEach(final BiConsumer<? super K, ? super V> action) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> function) {
        throw new UnsupportedOperationException();
    }
    
    private void expungeStaleEntries() {
        Reference<? extends V> reference;
        while ((reference = this.queue.poll()) != null) {
            this.map.remove(((CacheReference)reference).key);
        }
    }
    
    private static class CacheReference<K, V> extends SoftReference<V>
    {
        final K key;
        
        CacheReference(final K key, final V value, final ReferenceQueue<? super V> queue) {
            super(value, queue);
            this.key = key;
        }
    }
}
