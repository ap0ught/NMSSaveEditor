package com.formdev.flatlaf.util;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class SoftCache<K, V> implements Map<K, V> {
   // $VF: renamed from: map java.util.Map
   private final Map<K, SoftCache.CacheReference<K, V>> field_1;
   private final ReferenceQueue<V> queue = new ReferenceQueue<>();

   public SoftCache() {
      this.field_1 = new HashMap<>();
   }

   public SoftCache(int initialCapacity) {
      this.field_1 = new HashMap<>(initialCapacity);
   }

   @Override
   public int size() {
      this.expungeStaleEntries();
      return this.field_1.size();
   }

   @Override
   public boolean isEmpty() {
      this.expungeStaleEntries();
      return this.field_1.isEmpty();
   }

   @Override
   public boolean containsKey(Object key) {
      this.expungeStaleEntries();
      return this.field_1.containsKey(key);
   }

   @Override
   public boolean containsValue(Object value) {
      throw new UnsupportedOperationException();
   }

   // $VF: renamed from: get (java.lang.Object) java.lang.Object
   @Override
   public V get(Object key) {
      this.expungeStaleEntries();
      return this.getRef(this.field_1.get(key));
   }

   // $VF: renamed from: put (java.lang.Object, java.lang.Object) java.lang.Object
   @Override
   public V put(K key, V value) {
      this.expungeStaleEntries();
      return this.getRef(this.field_1.put(key, new SoftCache.CacheReference<>(key, value, this.queue)));
   }

   @Override
   public V remove(Object key) {
      this.expungeStaleEntries();
      return this.getRef(this.field_1.remove(key));
   }

   private V getRef(SoftCache.CacheReference<K, V> ref) {
      return ref != null ? ref.get() : null;
   }

   @Override
   public void putAll(Map<? extends K, ? extends V> m) {
      this.expungeStaleEntries();

      for (Entry<? extends K, ? extends V> e : m.entrySet()) {
         this.put((K)e.getKey(), (V)e.getValue());
      }
   }

   @Override
   public void clear() {
      this.field_1.clear();
      this.expungeStaleEntries();
   }

   @Override
   public Set<K> keySet() {
      this.expungeStaleEntries();
      return this.field_1.keySet();
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
   public void forEach(BiConsumer<? super K, ? super V> action) {
      throw new UnsupportedOperationException();
   }

   @Override
   public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
      throw new UnsupportedOperationException();
   }

   private void expungeStaleEntries() {
      Reference<? extends V> reference;
      while ((reference = this.queue.poll()) != null) {
         this.field_1.remove(((SoftCache.CacheReference)reference).field_2);
      }
   }

   private static class CacheReference<K, V> extends SoftReference<V> {
      // $VF: renamed from: key java.lang.Object
      final K field_2;

      CacheReference(K key, V value, ReferenceQueue<? super V> queue) {
         super(value, queue);
         this.field_2 = key;
      }
   }
}
