package hash_and_bst;

public class HashTable<K, V> {
    private class HashNode<K, V> {
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

    private HashNode<K, V>[] chainArray; // or Object[]
    private int _capacity = 11; // default number of chains
    private int _length = 0;
    private float _loadFactor = 0.75F;

    public HashTable() {
        chainArray = new HashNode[_capacity];
    }

    public HashTable(int M) {
        _capacity = (int) (M * _loadFactor);
        chainArray = new HashNode[_capacity];
    }

    private int hash(K key) {
        return ((key.hashCode() & 0x7FFFFFFF) % _capacity);
    }

    public void put(K key, V value) {
        HashNode<K,V> node = new HashNode<>(key, value);
        int index = hash(key);
        if (chainArray[index] != null) {
            node.next = chainArray[index];
        }
        chainArray[index] = node;
        _length++;
    }

    public V get(K key) {
        return null;
    }

    public V remove(K key) {
        return null;
    }

    public boolean contains(V value) {
        return false;
    }

    public K getKey(V value) {
        return null;
    }
}
