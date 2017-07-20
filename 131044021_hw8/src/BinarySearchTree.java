import java.io.*;

/** A class to represent a binary search tree.
 *  @author Koffman and Wolfgang
 */

public class BinarySearchTree < E
    extends Comparable < E >>
    extends BinaryTree < E >
    implements SearchTree < E > {
  // Data Fields
  /** Return value from the public add method. */
  protected boolean addReturn;

  /** Return value from the public delete method. */
  protected E deleteReturn;

  //Methods
  /** Starter method find.
      pre: The target object must implement
           the Comparable interface.
      @param target The Comparable object being sought
      @return The object, if found, otherwise null
   */
  public E find(E target) {
    return find(root, target);
  }

  /**
   *
   * @param localRoot
   * @param target
   * @return
   */
  private E find(Node < E > localRoot, E target) {
    if (localRoot == null)
      return null;

    // Compare the target with the data field at the root.
    int compResult = target.compareTo(localRoot.data);
    if (compResult == 0)
      return localRoot.data;
    else if (compResult < 0)
      return find(localRoot.left, target);
    else
      return find(localRoot.right, target);
  }

  /**
   *
   * @param item The item to be inserted
   * @return
   */
  public boolean add(E item) {
    root = add(root, item);
    return addReturn;
  }

  /**
   *
   * @param localRoot
   * @param item
   * @return
   */
  private Node < E > add(Node < E > localRoot, E item) {
    if (localRoot == null) {
      // item is not in the tree � insert it.
      addReturn = true;
      return new Node < E > (item);
    }
    else if (item.compareTo(localRoot.data) == 0) {
      // item is equal to localRoot.data
      addReturn = false;
      return localRoot;
    }
    else if (item.compareTo(localRoot.data) < 0) {
      // item is less than localRoot.data
      localRoot.left = add(localRoot.left, item);
      return localRoot;
    }
    else {
      // item is greater than localRoot.data
      localRoot.right = add(localRoot.right, item);
      return localRoot;
    }
  }

  /** Starter method delete.
      post: The object is not in the tree.
      @param target The object to be deleted
      @return The object deleted from the tree
              or null if the object was not in the tree
      @throws ClassCastException if target does not implement
              Comparable
   */
  public E delete(E target) {
    root = delete(root, target);
    return deleteReturn;
  }

  /**
   *
   * @param localRoot
   * @param item
   * @return
   */
  private Node < E > delete(Node < E > localRoot, E item) {
    if (localRoot == null) {
      // item is not in the tree.
      deleteReturn = null;
      return localRoot;
    }

    // Search for item to delete.
    int compResult = item.compareTo(localRoot.data);
    if (compResult < 0) {
      // item is smaller than localRoot.data.
      localRoot.left = delete(localRoot.left, item);
      return localRoot;
    }
    else if (compResult > 0) {
      // item is larger than localRoot.data.
      localRoot.right = delete(localRoot.right, item);
      return localRoot;
    }
    else {
      // item is at local root.
      deleteReturn = localRoot.data;
      if (localRoot.left == null) {
        // If there is no left child, return right child
        // which can also be null.
        return localRoot.right;
      }
      else if (localRoot.right == null) {
        // If there is no right child, return left child.
        return localRoot.left;
      }
      else {
        // Node being deleted has 2 children, replace the data
        // with inorder predecessor.
        if (localRoot.left.right == null) {
          // The left child has no right child.
          // Replace the data with the data in the
          // left child.
          localRoot.data = localRoot.left.data;
          // Replace the left child with its left child.
          localRoot.left = localRoot.left.left;
          return localRoot;
        }
        else {
          // Search for the inorder predecessor (ip) and
          // replace deleted node�s data with ip.
          localRoot.data = findLargestChild(localRoot.left);
          return localRoot;
        }
      }
    }
  }

  /**
   *
   * @param target Item to be removed
   * @return
   */
  public boolean remove(E target) {
    return delete(target) != null;
  }

  /** Determine if an item is in the tree
      @param target Item being sought in tree
      @return true If the item is in the tree, false otherwise
      @throws ClassCastException if target is not Comparable
   */
  public boolean contains(E target) {
    return find(target) != null;
  }

  /**** END EXERCISE ****/

  /** Find the node that is the
      inorder predecessor and replace it
      with its left child (if any).
      post: The inorder predecessor is removed from the tree.
      @param parent The parent of possible inorder
                    predecessor (ip)
      @return The data in the ip
   */
  private E findLargestChild(Node < E > parent) {
    // If the right child has no right child, it is
    // the inorder predecessor.
    if (parent.right.right == null) {
      E returnValue = parent.right.data;
      parent.right = parent.right.left;
      return returnValue;
    }
    else {
      return findLargestChild(parent.right);
    }
  }

}
