package PART2;

import java.util.*;


public class KWLinkedList<E> {
    // Data Fields
    /** A reference to the head of the list. */
    private Node < E > head = null;
    /** A reference to the end of the list. */
    private Node < E > tail = null;

    /** The size of the list. */
    private int size = 0;

    /**
     *
     * @param item
     */
    public void addFirst(E item) {
        add(0, item);
    }

    /**
     *
     * @param item
     */
    public void addLast(E item) {
        add(size, item);
    }

    public E removeFirst()
    {
        if (size == 0)
            throw new NoSuchElementException();
        size--;
        E r = head.data;

        if (head.next != null)
            head.next.prev =null;
        else
            tail = null;

        head = head.next;
        return r;

    }

    /**
     *
     * @return
     */
    public E getFirst() {
        return head.data;
    }

    /**
     *
     * @return
     */
    public E getLast() {
        return tail.data;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     *
     * @return
     */
    public Iterator < E > iterator() {
        return new KWListIter(0);
    }

    /**
     *
     * @return
     */
    public ListIterator < E > listIterator() {
        return new KWListIter(0);
    }

    /**
     *
     * @param index
     * @return
     */
    public ListIterator < E > listIterator(int index) {
        return new KWListIter(index);
    }


    /**
     *
     * @param index
     * @param obj
     */
    public void add(int index, E obj) {
        listIterator(index).add(obj);
    }

    /**
     *
     * @param index
     * @return
     */
    public E get(int index) {
        return listIterator(index).next();
    }


    // Inner Classes
    /** A Node is the building block for a double-linked list. */
    private static class Node < E > {
        /** The data value. */
        private E data;

        /** The link to the next node. */
        private Node < E > next = null;

        /** The link to the previous node. */
        private Node < E > prev = null;

        /**
         * @param dataItem
         */
        private Node(E dataItem) {
            data = dataItem;
        }
    } //end class Node


    /** Inner class to implement the ListIterator interface. */
    private class KWListIter implements ListIterator < E > {
        /** A reference to the next item. */
        private Node < E > nextItem;

        /** A reference to the last item returned. */
        private Node < E > lastItemReturned;

        /** The index of the current item. */
        private int index = 0;

        /**
         *
         * @param i
         */
        public KWListIter(int i) {
            // Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            }
            else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /**
         *
         * @return
         */
        public boolean hasNext() {
            return nextItem != null;
        }

        /**
         *
         * @return
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /**
         *
         * @return
         */
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /**
         *
         * @return
         */
        public int nextIndex() {
            return index;
        }

        /**
         *
         * @return
         */
        public int previousIndex() {
            return index - 1;
        }

        /**
         *
         * @return
         */
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = tail;
            }
            else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        /**
         *
         * @param obj
         */
        public void add(E obj) {
            if (head == null) { // Add to an empty list.
                head = new Node < E > (obj);
                tail = head;
            }
            else if (nextItem == head) { // Insert at head.
                // Create a new node.
                Node < E > newNode = new Node < E > (obj);
                // Link it to the nextItem.
                newNode.next = nextItem;
                // Link nextItem to the new node.
                nextItem.prev = newNode;
                // The new node is now the head.
                head = newNode;
            }
            else if (nextItem == null) { // Insert at tail.
                // Create a new node.
                Node < E > newNode = new Node < E > (obj);
                // Link the tail to the new node.
                tail.next = newNode;
                // Link the new node to the tail.
                newNode.prev = tail;
                // The new node is the new tail.
                tail = newNode;
            }
            else { // Insert into the middle.
                // Create a new node.
                Node < E > newNode = new Node < E > (obj);
                // Link it to nextItem.prev.
                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;
                // Link it to the nextItem.
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            // Increase size and index and set lastItemReturned.
            size++;
            index++;
            lastItemReturned = null;
        } // End of method add.


        /**
         * remove()
         */
        public void remove() {
            if (lastItemReturned == null) {
                throw new IllegalStateException();
            }
            // Unlink this item from its next neighbor
            if (lastItemReturned.next != null) {
                lastItemReturned.next.prev = lastItemReturned.prev;
            }
            else { // Item is the tail
                tail = lastItemReturned.prev;
                if (tail != null) {
                    tail.next = null;
                }
                else { // list is now empty
                    head = null;
                }
            }
            // Unlink this item from its prev neighbor
            if (lastItemReturned.prev != null) {
                lastItemReturned.prev.next = lastItemReturned.next;
            }
            else { // Item is the head
                head = lastItemReturned.next;
                if (head != null) {
                    head.prev = null;
                }
                else {
                    tail = null;
                }
            }
            // Invalidate lastItemReturned
            lastItemReturned = null;
            // decrement both size and index
            size--;
            index--;
        }

        /**
         *
         * @param item
         */
        public void set(E item) {
            if (lastItemReturned == null) {
                throw new IllegalStateException();
            }
            lastItemReturned.data = item;
        }

        @Override
        public String toString() {
            return ("KWListIter{" +
                    "nextItem=" + head.data).replace('[',' ').replace(']', ' ');
        }
    } //end class KWListIter
}
