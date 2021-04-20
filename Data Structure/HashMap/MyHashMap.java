import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K, V> implements Map61B<K, V>{
    private int size;
    private double loadFactor;
    private ArrayList<Entry>[] buckets;
    private Set<K> key_set;

    private class Entry {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this(16, 0.75);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, 0.75);
    }

    public MyHashMap(int initialSize, double loadFactor) {
        size = 0;
        this.loadFactor = loadFactor;
        buckets = (ArrayList<Entry>[]) new ArrayList[initialSize];
        key_set = new HashSet<>();
    }

    private int findBucket(K key, int numBuckets) {
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    private int hashFunction(K key) {
        return findBucket(key, buckets.length);
    }

    private void resize(int capacity) {
        ArrayList<Entry>[] temp = (ArrayList<Entry>[]) new ArrayList[capacity];
        for (K key : key_set) {
            int index = findBucket(key, capacity);
            if (temp[index] == null) {
                temp[index] = new ArrayList<>();
            }
            temp[index].add(getEntry(key));
        }
        buckets = temp;
    }

    @Override
    public void clear() {
        buckets = (ArrayList<Entry>[]) new ArrayList[16];
        size = 0;
        key_set = new HashSet<>();
    }

    @Override
    public boolean containsKey(K key) {
        return key_set.contains(key);
    }

    private Entry getEntry(K key) {
        int hashcode = hashFunction(key);
        if(buckets[hashcode] != null)
        {
            for(Entry n: buckets[hashcode])
                if(n != null && n.key.equals(key))
                    return n;
        }
        return null;   
    }

    @Override
    public V get(K key) {
        Entry n = getEntry(key);
        if(n != null)
            return n.value;
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        int hashCode = hashFunction(key);
        if(key_set.contains(key))
            getEntry(key).value = value;
        else
        {
            if(size / buckets.length > loadFactor)
                resize(buckets.length * 2);
            if(buckets[hashCode] == null)
                buckets[hashCode] = new ArrayList<>();
            buckets[hashCode].add(new Entry(key, value));
            size++;
            key_set.add(key);
        }
    }

    @Override
    public Set<K> keySet() {
        return key_set;
    }

    @Override
    public V remove(K key) {
        if(!key_set.contains(key))
            return null;
        V a = getEntry(key).value;
        buckets[hashFunction(key)].remove(getEntry(key));
        return a;
    }

    @Override
    public V remove(K key, V value) {
        if(!key_set.contains(key))
            return null;
        int hashCode = hashFunction(key);
        V a = getEntry(key).value;
        buckets[hashCode].remove(getEntry(key));
        return a;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        K temp = (K)obj;
        return temp.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        String s = this.toString();
        int hash = 0;
        for(int i = 0; i < s.length(); i++)
        {
            hash *= 128;
            hash += s.charAt(i);
        }
        return hash;
    }

    @Override
    public Iterator<K> iterator() {
        return key_set.iterator();
    }
}
