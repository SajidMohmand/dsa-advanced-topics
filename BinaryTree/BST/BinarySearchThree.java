package BinaryTree.BST;

import java.util.ArrayList;

public class BinarySearchThree {


    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }


    public static Node insert(Node root, int data){

        if (root == null){
            root = new Node(data);
            return root;
        }


        if (root.data > data){
            root.left = insert(root.left,data);
        }
        else{
            root.right = insert(root.right,data);
        }
        return root;
    }
    public static boolean searchInBST(Node root, int key){

        if (root == null) return false;

        if (root.data > key){
            return searchInBST(root.left, key);
        }else if(root.data == key){
            return true;
        }else{
            return searchInBST(root.right,key);
        }

    }

    public static Node delete(Node root,int key){

        if (root.data > key){
            root.left = delete(root.left,key);
        }else if(root.data < key){
            root.right  = delete(root.right,key);
        }else{
            // its where root.data == key
//            case - 1
            if (root.left == null && root.right == null){
                return null;
            }

//            case - 2
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }

//            case - 3
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;
    }
    static Node inOrderSuccessor(Node root){
        if (root.left != null){
            root = root.left;
        }
        return root;
    }

//    problem:1 range print
//    time complexity =  O(n)
    static void printInRange1(Node root,int x,int y){
        if (root == null){
            return;
        }
        printInRange1(root.left,x,y);
        if (root.data >= x && root.data <= y){
            System.out.print(root.data+" ");
        }
        printInRange1(root.right,x,y);
    }

//    Time complexity = O(H + K) where H is height and K is no. of printed Node
    public static void printInRange2(Node root,int x,int y){

        if (root == null) return;
        if (root.data >= x && root.data <= y){
            printInRange2(root.left,x,y);
            System.out.print(root.data+" ");
            printInRange2(root.right,x,y);
        }
        else if(root.data >= y){
            printInRange2(root.left,x,y);
        }else {
            printInRange2(root.right,x,y);
        }
    }
    public static void inOrderTraversal(Node root){

        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }





    //    problem:2 print root to leaf all paths
    static void rootToLeaf(Node root, ArrayList<Integer> path){

        if (root == null) return;
        path.add(root.data);
        if (root.left == null && root.right == null){
            printPath(path);
        }else{
            rootToLeaf(root.left,path);
            rootToLeaf(root.right,path);
        }
        path.removeLast();
    }
    static void printPath(ArrayList<Integer> path){
        for (Integer i: path){
            System.out.print(i+" ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
//        int[] arr ={5,1,3,4,2,7};
        int[] arr ={8,5,3,1,4,6,10,11,14};

        Node root = null;

        for (int i: arr){
            root = insert(root,i);
        }
//        inOrderTraversal(root);

//        System.out.println(searchInBST(root,4));
//        inOrderTraversal(root);
//        System.out.println();
//        delete(root,3);
//        inOrderTraversal(root);

//        printInRange1(root,2,5);
//        printInRange2(root,2,5);
        rootToLeaf(root,new ArrayList<>());

    }
}
