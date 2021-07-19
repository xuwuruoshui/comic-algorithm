package club.xuwuruoshui.array.dir02tree.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

public class MyBinaryTreeTest {
    public static void main(String[] args) {


        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3,2,9,null,null,10,null,null,8,null,4));

        MyBinaryTree<Integer> binaryTree = new MyBinaryTree<>();
        TreeNode<Integer> nodeTree = binaryTree.createBinaryTree(linkedList);

        //binaryTree.preOrderTravel(nodeTree);
        //binaryTree.inOrderTravel(nodeTree);
        binaryTree.postOrderTravel(nodeTree);

    }
}
