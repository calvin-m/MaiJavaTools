package MaiJavaTools.DataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache<K, V> {
    int capacity;
    LinkedList<K> history;
    HashMap<K, V> storage;
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.history = new LinkedList<K>();
        this.storage = new HashMap<K, V>(this.capacity);
    }

    public V get(K key) {
        if(this.storage.containsKey(key)){
            updateLastAccessed(key);
            return this.storage.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if(storage.size() == this.capacity){
            //K k = this.history.removeLast();
            K k = this.history.iterator().next();
            this.storage.remove(k);
        }
        this.storage.put(key, value);
        updateLastAccessed(key);
    }

    private void updateLastAccessed(K key){
        this.history.remove(key);
        this.history.addFirst(key);
    }
}
