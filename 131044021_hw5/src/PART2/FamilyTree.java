package PART2;


import PART1.BinaryTree;


public class FamilyTree<E> extends BinaryTree<E> {

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


        //parse
        ebuIbn= pParentNickname.split("-");
        // If tree is empty, then the new member becomes the root
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
                    while(root.left.right!=null){
                         root.left.right=root.left.right.right;
                    }
                    root.left.right=newMember;
                    z=1;
                }
            }
            else{
                while(temp.left.data.equals(pParent)){
                    if(temp.left== null){
                        root.left= newMember;
                        z=1;
                    }
                }
                if(z==0){
                    while(temp.right.data.equals(pParent)){
                        if(temp.left== null){
                            root.left= newMember;
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
                }
            } else {
                while(temp.left!=null && y==0) {
                    if (temp.left.data.equals(ebuIbn[1])) {
                        if (temp.left.left.data.equals(pParent)) {
                            if (temp.left.left.left == null) {
                                root.left.left.left = newMember;
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

}





