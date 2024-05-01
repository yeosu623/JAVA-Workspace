// 21911981 정수열
import java.util.*;

class Pair<T, U> {

    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket<K, V> implements Comparable<Bucket<K, V>> {
    public int bucketNum;

    public int size;
    public int bits;
    ArrayList<Pair<K, V>> data = new ArrayList<>();

    public Bucket(int bucketNum, int size, int bits) {
        this.bucketNum = bucketNum;
        this.size = size;
        this.bits = bits;
    }

    @Override
    public int compareTo(Bucket<K, V> o) {
        if(bucketNum < o.bucketNum) return -1;
        else if(bucketNum == o.bucketNum) return 0;
        else return 1;
    }
}
public class ExtensibleHashST<K, V> {

    private int i = 0;
    private int n = 0;
    private int bucketNum = 0;
    private int bucketSize;
    ArrayList<Bucket<K, V>> directory = new ArrayList<>();

    private int hash(K key) {
        return key.hashCode() & ((1 << i) - 1);
    }

    public ExtensibleHashST() {
        bucketSize = 4;
        directory.add(new Bucket<>(bucketNum++, bucketSize, 0));
    }

    public ExtensibleHashST(int size) {
        bucketSize = size;
        directory.add(new Bucket<>(bucketNum++, bucketSize, 0));
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
        int h = hash(key);
        Bucket<K, V> bucket = directory.get(h);

        for(Pair<K, V> data : bucket.data)
            if(data.first.equals(key))
                return data.second;

        return null;
    }

    public void put(K key, V value) {
        int h = hash(key);
        Bucket<K, V> bucket = directory.get(h);
        ArrayList<Pair<K,V>> dataArr = bucket.data;

        for(Pair<K, V> data : dataArr) {
            if(data.first.equals(key)) {
                data.second = value;
                return;
            }
        }
        dataArr.add(new Pair<>(key, value));
        n++;

        while(dataArr.size() > bucketSize) {

            if(bucket.bits < i) {
                ArrayList<Integer> connectedHash = new ArrayList<>();
                for(int idx = 0; idx < directory.size(); idx++) {
                    if(directory.get(idx) == bucket)
                        connectedHash.add(idx);
                }

                bucket.bits++;
                Bucket<K, V> newBucket = new Bucket<>(bucketNum++, bucketSize, bucket.bits);
                for(int idx : connectedHash) {
                    if( ((idx >> (bucket.bits - 1)) & 1) == 0) continue;
                    else directory.set(idx, newBucket);
                }

                ArrayList<Pair<K, V>> dataArrCopy = new ArrayList<>(dataArr);
                dataArr.clear();
                for(Pair<K, V> data : dataArrCopy) {
                    directory.get(hash(data.first)).data.add(new Pair<>(data.first, data.second));
                }
            }

            else {
                i++;

                int directorySize = directory.size();
                for(int idx = 0; idx < directorySize; idx++) {
                    Bucket<K, V> targetBucket = directory.get(idx);
                    if(targetBucket != bucket) directory.add(targetBucket);
                    else {
                        bucket.bits++;
                        Bucket<K, V> newBucket = new Bucket<>(bucketNum++, bucketSize, bucket.bits);
                        directory.add(newBucket);
                    }
                }

                ArrayList<Pair<K, V>> dataArrCopy = new ArrayList<>(dataArr);
                dataArr.clear();
                for(Pair<K, V> data : dataArrCopy) {
                    directory.get(hash(data.first)).data.add(new Pair<>(data.first, data.second));
                }
            }
        }
    }

    public Iterable<K> keys() {
        ArrayList<K> keys = new ArrayList<>();

        for(Bucket<K, V> bucket : directory)
            for(Pair<K, V> data : bucket.data)
                keys.add(data.first);

        return keys;
    }

    public void summaryInfo() {
        System.out.printf(
                "Global i = %d비트, (key, value) 쌍의 수 = %d, 버킷의 수 = %d\n",
                i, n, bucketNum
        );
    }

    public void detailInfo() {
        summaryInfo();

        TreeSet<Bucket<K, V>> bucketSet = new TreeSet<>();
        for(int idx = 0; idx < directory.size(); idx++) {
            System.out.printf(
                    "Directory[%d] -> Bucket %d\n",
                    idx, directory.get(idx).bucketNum
            );
            bucketSet.add(directory.get(idx));
        }
        System.out.println();

        for(Bucket<K, V> bucket : bucketSet) {
            System.out.printf(
                    "Bucket %d: size = %d, nbits = %d비트\n",
                    bucket.bucketNum, bucket.data.size(), bucket.bits
            );
            for(Pair<K, V> data : bucket.data) {
                System.out.println(
                        "\t" + data.first + " : " + data.second
                );
            }
        }
    }
}
