import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

class Pair<T, U> {

    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket<K, V> {

    private int bits = 1;

    private int idx = 0;
    private K[] keyArr;
    private V[] valueArr;

    public <> Bucket<K, V>(int size) {
        keyArr = new K[size];
        valueArr = new V[size];
    }

    public int getBits() {
        return bits;
    }

    public int getIdx() {
        return idx;
    }

    public void put(K key, V value) {
        keyArr[idx] = key;
        valueArr[idx] = value;
    }
}

public class ExtensibleHashST<K, V> {

    private int i = 0;
    private long n = 0;
    private final int bucketSize;
    private ArrayList<Bucket<K, V>> directory = new ArrayList<>();


    private int hash(K key) {
        return key.hashCode() & ((1 << i) - 1);
    }

    public ExtensibleHashST() {
        bucketSize = 4;
        directory.add(new Bucket(bucketSize));
    }

    public ExtensibleHashST(int size) {
        bucketSize = size;
        directory.add(new Bucket(bucketSize));
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public long size() {
        return n;
    }

    public V get(K key) {

    }

    public void put(K key, V value) {
        int h = hash(key);
        if(directory.get(h).getIdx() < bucketSize) {

        }
    }

    public Iterable<K> keys() {

    }

    public void summaryInfo() {

    }

    public void detailInfo() {

    }
}
