package hash_and_bst;

public class HashTable<K, V> {
    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ": " + value + "}";
        }
    }

    private HashNode<K, V>[] buckets; // |X| |X| |X| |X| |X| = these are buckets and X is a pointer to chain
    private int _tableSize = 11; // default number of buckets
    private int _length = 0; // number of el. in a bucket ( let's call it a chain)
    private float _loadFactor = 0.75F;
    private float _loadStart = 0.65F;
    private float _loadEnd = 0.85F;

    public HashTable() {
        buckets = new HashNode[_tableSize];
    }

    public HashTable(int M) {
        _tableSize = (int) (M * _loadFactor);
        buckets = new HashNode[_tableSize];
    }

    private int hash(K key) {
        return ((key.hashCode() & 0x7FFFFFFF) % _tableSize);
    }

    public void put(K key, V value) {
        HashNode<K, V> node = new HashNode<>(key, value);
        int index = hash(key);
        if (buckets[index] != null) {
            node.next = buckets[index];
        }
        buckets[index] = node;
        _length++;
        if ((_length / _tableSize) > _loadEnd) resize();
    }

    private void resize() {
        int _newTableSize = (int) (_length / _loadStart);
        HashNode<K, V>[] newBuckets = new HashNode[_newTableSize];
        for (int i = 0; i < _tableSize; i++) {
            while (buckets[i] != null) {
                HashNode<K, V> node = new HashNode<>(buckets[i].key, buckets[i].value);
                int index = hash(node.key);
                if (newBuckets[index] != null) {
                    node.next = newBuckets[index];
                }
                buckets[index] = node;
                buckets[i] = buckets[i].next;
            }
        }
        buckets = newBuckets;
        _tableSize = _newTableSize;
    }

    public V get(K key) {
        int keyIndex = hash(key);
        while (buckets[keyIndex] != null) {
            if (buckets[keyIndex].key.equals(key)) return buckets[keyIndex].value;
            buckets[keyIndex] = buckets[keyIndex].next;
        }
        return null;
    }

    public V remove(K key) {
        int keyIndex = hash(key);
        HashNode<K, V> head = buckets[keyIndex];
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null){
            return null;
        }
        _length--;
        if(prev != null){
            prev.next = head.next;
        } else {
            buckets[keyIndex] = head.next;
        }

        return head.value;
    }

    public boolean contains(V value) {
        return getKey(value) != null;
    }

    public K getKey(V value) {
        for (int i = 0; i < _tableSize; i++) {
            while (buckets[i] != null) {
                if (buckets[i].value.equals(value)) {
                    System.out.println("I found: "+buckets[i].value);
                    return buckets[i].key;
                }
                buckets[i] = buckets[i].next;
            }
        }
        return null;
    }
}
