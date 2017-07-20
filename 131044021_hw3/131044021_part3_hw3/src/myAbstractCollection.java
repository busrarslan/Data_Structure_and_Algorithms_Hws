//yararlanilan kaynaklar
//http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util// /AbstractCollection.java#AbstractCollection.addAll%28java.util.Collection%29
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class myAbstractCollection<E> extends AbstractCollection<E>
{
    protected myAbstractCollection() {
    }
    //extends edilen Abstract Collection classinin implement etmesi gereken methodlar

    /**
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        Iterator<? extends E> e = c.iterator();
        while (e.hasNext()) {
            if (add(e.next()))
                modified = true;
        }
        return modified;
    }

    /**
     *
     * @param adder
     */
    void appendAnything(myAbstractCollection adder)
    {
        if(adder instanceof myAbstractCollection) {

            this.addAll(adder);
        }
    }




}
