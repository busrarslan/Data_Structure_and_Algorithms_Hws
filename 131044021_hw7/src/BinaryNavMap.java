/**
 * Created by syucer on 4/24/2017.
 */
//Busra Arslan
//131044021
//Description
//Map işleminde key ve value bilgileri tutulur.
//Burda aynı keylerden olamaz binary search yapısı da bu şekilde işlemektedir.
//put methodu yazılarak key ve value değerlerinin alınıp binary search methodlarına göre key'leri compare ederek
//ağaca ekleme yapıyor
//binary search treenin içerisinde normalde tek bir data tutulmaktadır.
//ama bizim hem key hem value değerimiz olduğu için binary search tree içinde iki data tuttum ve bunla
//ilgili değişiklik yaptım. KEY ve VALUE değerleri tuttum.

import java.util.*;

public class BinaryNavMap<K,V> extends AbstractMap<K,V>
        implements NavigableMap<K,V>, Cloneable, java.io.Serializable
{

    //implemantasyonunu gerceklestirilecegi data structure
    private BinarySearchTree<String> navMap=new BinarySearchTree<>();


    //inner class
    protected static class Entry < K, V > {

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

    //implement put function
    public V put(K key , V value)
    {
        navMap.add((String)key,(String)value);
        return value;

    }


    @Override
    public Set<Map.Entry<K, V>> entrySet() {


        return null;
    }

    /**
     * Returns a key-value mapping associated with the greatest key
     * strictly less than the given key, or {@code null} if there is
     * no such key.
     *
     * @param key the key
     * @return an entry with the greatest key less than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Map.Entry<K, V> lowerEntry(K key) {
        Map.Entry entry=new SimpleEntry("","");
        return lowerEntry(navMap,key,entry);

    }

    private Map.Entry lowerEntry(BinaryTree<String> t, K key,Map.Entry s) {
        if(t == null)
            return s;

        if(t.getKey().toString().compareTo(key.toString()) < 0 )
        {
            if(t.getKey().toString().compareTo(s.getKey().toString())>0)
                s.setValue(t.getKey());

            lowerEntry(t.getLeftSubtree(),key,s);
            lowerEntry(t.getRightSubtree(),key,s);
            return s;
        }
        else
        {
            lowerEntry(t.getLeftSubtree(),key,s);
            lowerEntry(t.getRightSubtree(),key,s);
            return s;
        }
    }

    /**
     * Returns the greatest key strictly less than the given key, or
     * {@code null} if there is no such key.
     *
     * @param key the key
     * @return the greatest key less than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K lowerKey(K key) {
        K s= (K) "";
        s=lowerKey(navMap,key,s);
        return s;
    }
    private K lowerKey(BinaryTree t,K key, K s)
    {
        if(t == null)
            return s;

        if(t.getKey().toString().compareTo(key.toString()) < 0 )
        {
            if(t.getKey().toString().compareTo(s.toString())>0)
                s= (K) t.getKey();

            s=lowerKey(t.getLeftSubtree(),key,s);
            s=lowerKey(t.getRightSubtree(),key,s);
            return s;
        }
        else
        {
            s=lowerKey(t.getLeftSubtree(),key,s);
            s=lowerKey(t.getRightSubtree(),key,s);
            return s;
        }
    }
    @Override
    public String toString() {
        return navMap.toString();
    }

    /**
     * Returns a key-value mapping associated with the greatest key
     * less than or equal to the given key, or {@code null} if there
     * is no such key.
     *
     * @param key the key
     * @return an entry with the greatest key less than or equal to
     * {@code key}, or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */

    @Override
    public Map.Entry<K, V> floorEntry(K key) {
        Map.Entry entry=new SimpleEntry("","");
        return floorEntry(navMap,key,entry);

    }

    private Map.Entry floorEntry(BinaryTree<String> t, K key,Map.Entry s) {
        if(t == null)
            return s;

        if(t.getKey().toString().compareTo(key.toString()) <= 0 )
        {
            if(t.getKey().toString().compareTo(s.getKey().toString())>0)
                s.setValue(t.getKey());

            floorEntry(t.getLeftSubtree(),key,s);
            floorEntry(t.getRightSubtree(),key,s);
            return s;
        }
        else
        {
            floorEntry(t.getLeftSubtree(),key,s);
            floorEntry(t.getRightSubtree(),key,s);
            return s;
        }
    }
    /**
     * Returns the greatest key less than or equal to the given key,
     * or {@code null} if there is no such key.
     *
     * @param key the key
     * @return the greatest key less than or equal to {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */

    @Override
    public K floorKey(K key) {
        K s= (K) "";
        s=floorKey(navMap,key,s);
        return s;
    }
    private K floorKey(BinaryTree t,K key, K s)
    {
        if(t == null)
            return s;

        if(t.getKey().toString().compareTo(key.toString()) <= 0 )
        {
            if(t.getKey().toString().compareTo(s.toString())>0)
                s= (K) t.getKey();

            s=floorKey(t.getLeftSubtree(),key,s);
            s=floorKey(t.getRightSubtree(),key,s);
            return s;
        }
        else
        {
            s=floorKey(t.getLeftSubtree(),key,s);
            s=floorKey(t.getRightSubtree(),key,s);
            return s;
        }
    }
    /**
     * Returns a key-value mapping associated with the least key
     * greater than or equal to the given key, or {@code null} if
     * there is no such key.
     *
     * @param key the key
     * @return an entry with the least key greater than or equal to
     * {@code key}, or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Map.Entry<K, V> ceilingEntry(K key) {

        Map.Entry entry=new SimpleEntry("zzzzzzzzzzz","");
        entry= ceilingEntry(navMap,key,entry);
        return new SimpleEntry("",entry.getValue());
    }
    private Map.Entry ceilingEntry(BinaryTree<String> t, K key,Map.Entry s) {
        if(t == null)
            return s;

        if(t.getKey().toString().compareTo(key.toString()) >= 0 )
        {
            if(t.getKey().toString().compareTo(s.getKey().toString())<0)
                s.setValue(t.getKey());

            ceilingEntry(t.getLeftSubtree(),key,s);
            ceilingEntry(t.getRightSubtree(),key,s);
            return s;
        }
        else
        {
            ceilingEntry(t.getLeftSubtree(),key,s);
            ceilingEntry(t.getRightSubtree(),key,s);
            return s;
        }
    }
    /**
     * Returns the least key greater than or equal to the given key,
     * or {@code null} if there is no such key.
     *
     * @param key the key
     * @return the least key greater than or equal to {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K ceilingKey(K key) {
        K s= (K) "zzzzzzzzzzzz"; //max string definiton
        s=ceilingKey(navMap,key,s);
        return s;
    }
    private K ceilingKey(BinaryTree t,K key, K s)
    {
        if(t == null)
            return s;

        if(t.getKey().toString().compareTo(key.toString()) > 0 )
        {
            if(t.getKey().toString().compareTo(s.toString())<0)
                s= (K) t.getKey();

            s=ceilingKey(t.getLeftSubtree(),key,s);
            s=ceilingKey(t.getRightSubtree(),key,s);
            return s;
        }
        else
        {
            s=ceilingKey(t.getLeftSubtree(),key,s);
            s=ceilingKey(t.getRightSubtree(),key,s);
            return s;
        }
    }

    /**
     * Returns a key-value mapping associated with the least key
     * strictly greater than the given key, or {@code null} if there
     * is no such key.
     *
     * @param key the key
     * @return an entry with the least key greater than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Map.Entry<K, V> higherEntry(K key) {

        Map.Entry entry=new SimpleEntry("zzzzzzzzzzz","");
        entry= higherEntry(navMap,key,entry);
        return new SimpleEntry("",entry.getValue());
    }
    private Map.Entry higherEntry(BinaryTree<String> t, K key,Map.Entry s) {
        if(t == null)
            return s;

        if(t.getKey().toString().compareTo(key.toString()) > 0 )
        {
            if(t.getKey().toString().compareTo(s.getKey().toString())<0)
                s.setValue(t.getKey());

            higherEntry(t.getLeftSubtree(),key,s);
            higherEntry(t.getRightSubtree(),key,s);
            return s;
        }
        else
        {
            higherEntry(t.getLeftSubtree(),key,s);
            higherEntry(t.getRightSubtree(),key,s);
            return s;
        }
    }
    /**
     * Returns the least key strictly greater than the given key, or
     * {@code null} if there is no such key.
     *
     * @param key the key
     * @return the least key greater than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K higherKey(K key) {
        K s= (K) "zzzzzzzzzzzz";
        s=higherKey(navMap,key,s);
        return s;
    }
    private K higherKey(BinaryTree t,K key, K s)
    {
        if(t == null)
            return s;

        if(t.getKey().toString().compareTo(key.toString()) > 0 )
        {
            if(t.getKey().toString().compareTo(s.toString())<0)
                s= (K) t.getKey();

            s=higherKey(t.getLeftSubtree(),key,s);
            s=higherKey(t.getRightSubtree(),key,s);
            return s;
        }
        else
        {
            s=higherKey(t.getLeftSubtree(),key,s);
            s=higherKey(t.getRightSubtree(),key,s);
            return s;
        }
    }
    /**
     * Returns a key-value mapping associated with the least
     * key in this map, or {@code null} if the map is empty.
     *
     * @return an entry with the least key,
     * or {@code null} if this map is empty
     */
    @Override
    public Map.Entry<K, V> firstEntry() {

        BinaryTree.Node temp =null;
        return getFirstEntry(navMap,temp);
    }

    private Map.Entry getFirstEntry(BinaryTree<String> navMap, BinaryTree.Node temp) {
        if(navMap.getLeftSubtree() !=null)
            return getFirstEntry(navMap.getLeftSubtree(),temp);
        else
        {
            temp =new BinaryTree.Node(navMap.getKey(),navMap.getValue());
        }
        Map.Entry s=new SimpleEntry(temp.key,temp.value);
        return s;


    }

    /**
     * Returns a key-value mapping associated with the greatest
     * key in this map, or {@code null} if the map is empty.
     *
     * @return an entry with the greatest key,
     * or {@code null} if this map is empty
     */
    @Override
    public Map.Entry<K, V> lastEntry() {

        BinaryTree.Node temp =null;
        return getLastEntry(navMap,temp);
    }
    private Map.Entry getLastEntry(BinaryTree<String> navMap, BinaryTree.Node temp) {
        if(navMap.getRightSubtree() !=null)
            return getFirstEntry(navMap.getRightSubtree(),temp);
        else
        {
            temp =new BinaryTree.Node(navMap.getKey(),navMap.getValue());
        }
        Map.Entry s=new SimpleEntry(temp.key,temp.value);
        return s;


    }

    /**
     * Removes and returns a key-value mapping associated with
     * the least key in this map, or {@code null} if the map is empty.
     *
     * @return the removed first entry of this map,
     * or {@code null} if this map is empty
     */


    @Override
    public Map.Entry<K, V> pollFirstEntry() {

        BinaryTree.Node temp =null;
        Map.Entry s= firstEntry();
        navMap.remove(s.getKey().toString());
        return s ;
    }


    /**
     * Removes and returns a key-value mapping associated with
     * the greatest key in this map, or {@code null} if the map is empty.
     *
     * @return the removed last entry of this map,
     * or {@code null} if this map is empty
     */
    @Override
    public Map.Entry<K, V> pollLastEntry() {


        BinaryTree.Node temp =null;
        Map.Entry s= lastEntry();
        navMap.remove(s.getKey().toString());
        return s ;
    }


    /**
     * Returns a reverse order view of the mappings contained in this map.
     * The descending map is backed by this map, so changes to the map are
     * reflected in the descending map, and vice-versa.  If either map is
     * modified while an iteration over a collection view of either map
     * is in progress (except through the iterator's own {@code remove}
     * operation), the results of the iteration are undefined.
     * <p>
     * <p>The returned map has an ordering equivalent to
     * <tt>{@link Collections#reverseOrder(Comparator) Collections.reverseOrder}(comparator())</tt>.
     * The expression {@code m.descendingMap().descendingMap()} returns a
     * view of {@code m} essentially equivalent to {@code m}.
     *
     * @return a reverse order view of this map
     */
    @Override
    public NavigableMap<K, V> descendingMap() {
        return null;
    }

    /**
     * Returns a {@link NavigableSet} view of the keys contained in this map.
     * The set's iterator returns the keys in ascending order.
     * The set is backed by the map, so changes to the map are reflected in
     * the set, and vice-versa.  If the map is modified while an iteration
     * over the set is in progress (except through the iterator's own {@code
     * remove} operation), the results of the iteration are undefined.  The
     * set supports element removal, which removes the corresponding mapping
     * from the map, via the {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll}, and {@code clear} operations.
     * It does not support the {@code add} or {@code addAll} operations.
     *
     * @return a navigable set view of the keys in this map
     */
    @Override
    public NavigableSet<K> navigableKeySet() {
        return null;
    }

    /**
     * Returns a reverse order {@link NavigableSet} view of the keys contained in this map.
     * The set's iterator returns the keys in descending order.
     * The set is backed by the map, so changes to the map are reflected in
     * the set, and vice-versa.  If the map is modified while an iteration
     * over the set is in progress (except through the iterator's own {@code
     * remove} operation), the results of the iteration are undefined.  The
     * set supports element removal, which removes the corresponding mapping
     * from the map, via the {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll}, and {@code clear} operations.
     * It does not support the {@code add} or {@code addAll} operations.
     *
     * @return a reverse order navigable set view of the keys in this map
     */
    @Override
    public NavigableSet<K> descendingKeySet() {
        return null;
    }

    /**
     * Returns a view of the portion of this map whose keys range from
     * {@code fromKey} to {@code toKey}.  If {@code fromKey} and
     * {@code toKey} are equal, the returned map is empty unless
     * {@code fromInclusive} and {@code toInclusive} are both true.  The
     * returned map is backed by this map, so changes in the returned map are
     * reflected in this map, and vice-versa.  The returned map supports all
     * optional map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside of its range, or to construct a
     * submap either of whose endpoints lie outside its range.
     *
     * @param fromKey       low endpoint of the keys in the returned map
     * @param fromInclusive {@code true} if the low endpoint
     *                      is to be included in the returned view
     * @param toKey         high endpoint of the keys in the returned map
     * @param toInclusive   {@code true} if the high endpoint
     *                      is to be included in the returned view
     * @return a view of the portion of this map whose keys range from
     * {@code fromKey} to {@code toKey}
     * @throws ClassCastException       if {@code fromKey} and {@code toKey}
     *                                  cannot be compared to one another using this map's comparator
     *                                  (or, if the map has no comparator, using natural ordering).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code fromKey} or {@code toKey}
     *                                  cannot be compared to keys currently in the map.
     * @throws NullPointerException     if {@code fromKey} or {@code toKey}
     *                                  is null and this map does not permit null keys
     * @throws IllegalArgumentException if {@code fromKey} is greater than
     *                                  {@code toKey}; or if this map itself has a restricted
     *                                  range, and {@code fromKey} or {@code toKey} lies
     *                                  outside the bounds of the range
     */
    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {

        NavigableMap m= new BinaryNavMap<K, V>();
        int fromChoose=0;
        int toChoose =0;
        if(fromInclusive ==true)
        {
            fromChoose=1;
        }
        if(toInclusive ==true)
        {
            toChoose=1;
        }
        m=subMap(m,navMap,fromKey,fromChoose,toKey,toChoose);
        return m;
    }
    public NavigableMap<K, V> subMap(NavigableMap m,BinaryTree t, K fromKey, int fromInclusive, K toKey, int toInclusive) {

        if(t == null)
            return m;

        if(t.getKey().toString().compareTo(fromKey.toString()) < fromInclusive && t.getKey().toString().compareTo(toKey.toString()) >toInclusive)
        {
            m.put(t.getKey(),t.getValue());
            subMap(m ,t.getLeftSubtree(),fromKey,fromInclusive,toKey,toInclusive);
            subMap(m ,t.getRightSubtree(),fromKey,fromInclusive,toKey,toInclusive);
            return m;
        }
        else
        {
            subMap(m ,t.getLeftSubtree(),fromKey,fromInclusive,toKey,toInclusive);
            subMap(m ,t.getRightSubtree(),fromKey,fromInclusive,toKey,toInclusive);
            return m;
        }

    }

    /**
     * Returns a view of the portion of this map whose keys are less than (or
     * equal to, if {@code inclusive} is true) {@code toKey}.  The returned
     * map is backed by this map, so changes in the returned map are reflected
     * in this map, and vice-versa.  The returned map supports all optional
     * map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param toKey     high endpoint of the keys in the returned map
     * @param inclusive {@code true} if the high endpoint
     *                  is to be included in the returned view
     * @return a view of the portion of this map whose keys are less than
     * (or equal to, if {@code inclusive} is true) {@code toKey}
     * @throws ClassCastException       if {@code toKey} is not compatible
     *                                  with this map's comparaçmöbor (or, if the map has no comparator,
     *                                  if {@code toKey} does not implement {@link Comparable}).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code toKey} cannot be compared to keys
     *                                  currently in the map.
     * @throws NullPointerException     if {@code toKey} is null
     *                                  and this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *                                  restricted range, and {@code toKey} lies outside the
     *                                  bounds of the range
     */
    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return null;
    }

    /**
     * Returns a view of the portion of this map whose keys are greater than (or
     * equal to, if {@code inclusive} is true) {@code fromKey}.  The returned
     * map is backed by this map, so changes in the returned map are reflected
     * in this map, and vice-versa.  The returned map supports all optional
     * map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param fromKey   low endpoint of the keys in the returned map
     * @param inclusive {@code true} if the low endpoint
     *                  is to be included in the returned view
     * @return a view of the portion of this map whose keys are greater than
     * (or equal to, if {@code inclusive} is true) {@code fromKey}
     * @throws ClassCastException       if {@code fromKey} is not compatible
     *                                  with this map's comparator (or, if the map has no comparator,
     *                                  if {@code fromKey} does not implement {@link Comparable}).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code fromKey} cannot be compared to keys
     *                                  currently in the map.
     * @throws NullPointerException     if {@code fromKey} is null
     *                                  and this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *                                  restricted range, and {@code fromKey} lies outside the
     *                                  bounds of the range
     */
    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return null;
    }

    /**
     * Returns the comparator used to order the keys in this map, or
     * {@code null} if this map uses the {@linkplain Comparable
     * natural ordering} of its keys.
     *
     * @return the comparator used to order the keys in this map,
     * or {@code null} if this map uses the natural ordering
     * of its keys
     */
    @Override
    public Comparator<? super K> comparator() {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code subMap(fromKey, true, toKey, false)}.
     *
     * @param fromKey
     * @param toKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code headMap(toKey, false)}.
     *
     * @param toKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code tailMap(fromKey, true)}.
     *
     * @param fromKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }

    /**
     * Returns the first (lowest) key currently in this map.
     *
     * @return the first (lowest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    @Override
    public K firstKey() {


        return firstEntry().getKey();
    }

    /**
     * Returns the last (highest) key currently in this map.
     *
     * @return the last (highest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    @Override
    public K lastKey() {

        return lastEntry().getKey();
    }

}