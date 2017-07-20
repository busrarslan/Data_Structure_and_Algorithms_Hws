package PART3;


import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<E> extends BinaryTree<E> {

    ArrayList tempArr=new ArrayList();
    /**
     *
     */
    //no parameter constructor
    public FamilyTree()
    {
        root=null;
    }

    /**
     *
     * @param s
     */
    //Soru 1 )  one parameter constructor to build a person’s family
    public FamilyTree(String s)
    {
        root= new Node(s);
    }

    //Soru 2 ) three parameter add method
    /**
     *
     * @param pName
     * @param pParent
     * @param pParentNickname
     */
    public void add(String pName ,String pParent ,String pParentNickname)
    {
        String[] ebuIbn;
        Node<E> temp= root;
        Node<E> newMember = new Node(pName);
        Node<E> newParent = new Node(pParent);
        Node<E> newNickname = new Node(pParentNickname);


        for(int i=0; i< tempArr.size(); i++){
            if(tempArr.get(i).equals(pName))
                throw new RuntimeException("Bu kisi FamilyTree'de mevcuttur.Tekrar eklenemez.");
        }
        tempArr.add(pName);

        //parse
        ebuIbn= pParentNickname.split("-");

        if(search(pName) == true)
            throw new RuntimeException("Bu kisi FamilyTree'de mevcuttur.Tekrar eklenemez.");

        if(root == null) {
            root = newMember;
            return;
        }
        int z=0,y=0;
        if(ebuIbn[0].equals("ebu")) {

            if (temp.data.equals(pParent)) {
                if (root.left == null) {
                    root.left = newMember;
                    z=1;
                }
                else{
                    if(root.left.right==null) {
                        root.left.right = newMember;
                        z = 1;
                    }
                    if(z==0) {
                        while (root.left.right != null && z==0) {
                            if (root.left.right.right == null) {
                                root.left.right.right = newMember;
                                z = 1;
                            }
                        }
                    }
                }
            }
            else{
                if(temp.left.data.equals(pParent)){
                    if(temp.left== null){
                        root.left= newMember;
                        z=1;
                    }
                }
                if(z==0){
                    if(temp.left.right.left.data.equals(pParent)){
                            if(temp.left.right.left.left == null)
                                temp.left.right.left.left=newMember;
                            z=1;
                    }


                    if(temp.left.right.right.data.equals(pParent))
                    {
                       if(temp.left.right.right.left==null){
                           temp.left.right.right.left=newMember;
                           z=1;
                       }
                       else{
                           temp.left.right.right.left.right=newMember;
                           z=1;
                       }

                    }
                }

            }

        }
        else if(ebuIbn[0].equals("ibn")) {
            if (temp.data.equals(ebuIbn[1])) {
                if(temp.left.data.equals(pParent)) {
                    if (root.left.left == null) {
                        root.left.left = newMember;
                        y=1;
                    }
                    else if(root.left.left.right == null){
                        root.left.left.right=newMember;
                        y=1;
                    }
                }
            } else {
                while(temp.left!=null && y==0) {
                    if (temp.left.data.equals(ebuIbn[1])) {
                        if (temp.left.left.data.equals(pParent)) {
                            if (temp.left.left.left == null) {
                                root.left.left.left = newMember;
                                y = 1;
                            }
                            else if (temp.left.left.left.right == null){
                                root.left.left.left.right = newMember;
                                y = 1;
                            }
                        }
                        else if(temp.left.right.data.equals(pParent)){
                            if (temp.left.right.left == null) {
                                root.left.right.left = newMember;
                                y = 1;
                            }
                        }
                    }
                }
                if (y == 0) {
                    while(temp.right!=null) {
                        while (temp.right.data.equals(ebuIbn[1])) {
                            if (temp.right.left.data.equals(pParent)) {
                                if (temp.right.left.left == null) {
                                    root.right.left.left = newMember;
                                    y=1;
                                }
                            }
                        }
                    }
                }
            }
        }

        if(z==0 && y==0)
            throw new RuntimeException("Tree'ye yeni bir kişi eklenememiştir.");


    }

    /**
     *
     * @param val
     * @return
     */
    public boolean search(String val)
    {
        return search(root, val);
    }

    /**
     *
     * @param r
     * @param val
     * @return
     */
    private boolean search(Node r, String val)
    {
        if (r.data == val)
            return true;
        if (r.left != null)
            if (search(r.left, val) == true)
                return true;
        if (r.right != null)
            if (search(r.right, val))
                return true;
        return false;
    }
    /* Function to search for an element recursively */
    private Node<E> mySearch(String p, Node famTree)
    {
        Node result = null;
        if (famTree == null)
            return null;
        if (famTree.data.equals(p))
            return famTree;
        if (famTree.left != null)
            result = mySearch(p,famTree.left);
        if (famTree.right != null)
            result = mySearch(p,famTree.right);

        return result;

    }

}





