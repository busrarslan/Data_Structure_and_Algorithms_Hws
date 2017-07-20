import java.util.LinkedList;

/**
 * Created by syucer on 4/24/2017.
 */
public class HashTableChaining<K, V> implements HashMap<K, V> {
    /** The table */
   // private HashTableOpen<Entry<K, V>>[] table;
    //Do not forget you can use more class and methods to do this homework,
    // this project gives you an initial classes an methods to see easily
    //....
    //.... other class members

    /** The table */
    private LinkedList< Entry < K, V >>[] table;

    /** The capacity */
    private static final int CAPACITY = 101;

    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    private int numKeys=0;
    private int numDeletes;
    private final Entry < K, V > DELETED =
            new Entry < K, V > (null, null);

    public HashTableChaining(){
        table = new LinkedList[CAPACITY];
    }

    public int getNumKeys() {
        return numKeys;
    }

    private static class Entry < K, V > {

        private K key;
        private V value;


        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.

        // Search the list at table[index] to find the key.
        for (Entry < K, V > nextItem : table[index]) {
            if (nextItem.key.equals(key))
                return nextItem.value;
        }

        // assert: key is not in the table.
        return null;

    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList < Entry < K, V >> ();
        }

        // Search the list at table[index] to find the key.


        // assert: key is not in the table, add new item.
        table[index].addFirst(new Entry < K, V > (key, value));
        numKeys++;
        //if (numKeys > (LOAD_THRESHOLD * table.length))
           // rehash();
        return table[index].get(0).value;
    }

  /*  private void rehash() {
        // Save a reference to oldTable.
        LinkedList < Entry<K, V> > [] oldTable = table;
        // Double capacity of this table.
        table = new LinkedList[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
                // Insert entry in expanded table
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }*/


    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList < Entry < K, V >> ();
        }

        // Search the list at table[index] to find the key.
        for (Entry < K, V > nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.key.equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.value;
                table[index].remove(nextItem);
                return oldVal;
            }
        }
        return null;
    }

    @Override
    public int size() {
            return getNumKeys();
    }

    @Override
    public boolean isEmpty() {
            return getNumKeys() == 0;
    }
}
