// 22113637 김민우
import java.util.*;

class Bucket<K, V> implements Comparable<Bucket<K, V>> {
    public int bucketNumber;
    public int bucketSize;
    public int bucketBit;

    public HashMap<K, V> data = new HashMap<>();

    public Bucket(int bucketNumber, int bucketSize, int bucketBit) {
        this.bucketNumber = bucketNumber;
        this.bucketSize = bucketSize;
        this.bucketBit = bucketBit;
    }

    @Override
    public int compareTo(Bucket<K, V> o) {
        if(bucketNumber > o.bucketNumber) return 1;
        else if(bucketNumber == o.bucketNumber) return 0;
        else return -1;
    }
}

public class ExtensibleHashST<K, V> {

    int i = 0;
    int N = 0;
    int bucketSize;
    int bucketNumber = 0;
    ArrayList<Bucket<K, V>> directory = new ArrayList<>();

    public ExtensibleHashST() {
        bucketSize = 4;
        Bucket<K, V> initialBucket = new Bucket<>(bucketNumber++, bucketSize, 0);
        directory.add(initialBucket);
    }

    public ExtensibleHashST(int size) {
        bucketSize = size;
        Bucket<K, V> initialBucket = new Bucket<>(bucketNumber++, bucketSize, 0);
        directory.add(initialBucket);
    }

    public boolean contains(K key) { return get(key) != null; }
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    private int hash(K key) {
        return key.hashCode() & ((1 << i) - 1);
    }

    public V get(K key) {
        int hashIndex = hash(key);

        Bucket<K, V> bucket = directory.get(hashIndex);
        HashMap<K, V> data = bucket.data;

        return data.get(key);
    }

    public void put(K key, V value) {
        int hashIndex = hash(key);

        Bucket<K, V> bucket = directory.get(hashIndex);
        HashMap<K, V> data = bucket.data;

        V beforeValue = get(key);
        if(beforeValue == null) {
            N++;
        }
        data.put(key, value);

        while(data.size() > bucketSize) {
            if(i == bucket.bucketBit) {
                Bucket<K, V> newBucket = null;

                for(int j = 0; j < Math.pow(2, i); j++) {
                    if(j != hashIndex) {
                        Bucket<K, V> bucketTemp = directory.get(j);
                        directory.add(bucketTemp);
                    }
                    else {
                        newBucket = new Bucket<>(bucketNumber++, bucketSize, i+1);
                        bucket.bucketBit++;

                        directory.add(newBucket);
                    }
                }

                i++;

                Iterator<K> it = data.keySet().iterator();
                ArrayList<K> removeKeys = new ArrayList<>();
                while(it.hasNext()) {
                    K keyX = it.next();
                    int hashData = hash(keyX);

                    int mask = 1 << (bucket.bucketBit-1);
                    if((hashData & mask) != 0) {
                        removeKeys.add(keyX);
                    }
                }

                Iterator<K> it2 = removeKeys.iterator();
                while(it2.hasNext()) {
                    K keyX = it2.next();
                    V valueX = data.get(keyX);

                    data.remove(keyX);
                    newBucket.data.put(keyX, valueX);
                }
            }
            else {
                Bucket<K, V> newBucket = new Bucket<>(bucketNumber++, bucketSize, bucket.bucketBit+1);
                bucket.bucketBit++;

                for(int j = 0; j < directory.size(); j++) {
                    if(directory.get(j) == bucket) {
                        int mask = 1 << (bucket.bucketBit-1);

                        if((j & mask) != 0)
                            directory.set(j, newBucket);
                    }
                }

                Iterator<K> it = data.keySet().iterator();
                ArrayList<K> removeKeys = new ArrayList<>();
                while(it.hasNext()) {
                    K keyX = it.next();
                    int hashData = hash(keyX);

                    int mask = 1 << (bucket.bucketBit-1);
                    if((hashData & mask) != 0) {
                        removeKeys.add(keyX);
                    }
                }

                Iterator<K> it2 = removeKeys.iterator();
                while(it2.hasNext()) {
                    K keyX = it2.next();
                    V valueX = data.get(keyX);

                    data.remove(keyX);
                    newBucket.data.put(keyX, valueX);
                }
            }
        }
    }

    public Iterable<K> keys() {
        HashSet<K> keys = new HashSet<>();

        for(int j = 0; j < directory.size(); j++) {
            Bucket<K, V> bucket = directory.get(j);

            Iterator<K> it = bucket.data.keySet().iterator();
            while(it.hasNext()) {
                K key = it.next();
                keys.add(key);
            }
        }

        return keys;
    }

    public void summaryInfo() {
        System.out.println(
                "Global i = " + i + "비트, " +
                        "(key, value) 쌍의 수 = " + N + ", " +
                        "버킷의 수 = " + bucketNumber
        );
    }

    public void detailInfo() {
        summaryInfo();

        TreeSet<Bucket<K, V>> buckets = new TreeSet<>();

        for(int j = 0; j < directory.size(); j++) {
            buckets.add(directory.get(j));
            int bucketNumberTemp = directory.get(j).bucketNumber;
            System.out.println(
                    "Directory[" + j + "] -> " +
                            "Bucket " + bucketNumberTemp
            );
        }
        System.out.println();

        Iterator<Bucket<K, V>> it = buckets.iterator();
        while(it.hasNext()) {
            Bucket<K, V> bucket = it.next();
            System.out.println(
                    "Bucket " + bucket.bucketNumber + ": " +
                            "size = " + bucket.data.size() + ", " +
                            "nbits = " + bucket.bucketBit + "비트"
            );

            Iterator<K> it2 = bucket.data.keySet().iterator();
            while(it2.hasNext()) {
                K key = it2.next();
                V value = get(key);

                System.out.println("    " + key + " : " + value);
            }
        }
    }
}
