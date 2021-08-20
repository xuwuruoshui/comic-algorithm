package club.xuwuruoshui.array.dir02tree.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

public class MyBinaryTreeTest {
    public static void main(String[] args) {


        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3,2,9,null,null,10,null,null,8,null,4));

        MyBinaryTree<Integer> binaryTree = new MyBinaryTree<>();
        TreeNode<Integer> nodeTree = binaryTree.createBinaryTree(linkedList);

        // 递归
        //binaryTree.preOrderTravel(nodeTree);
        //binaryTree.inOrderTravel(nodeTree);
        binaryTree.postOrderTravel(nodeTree);

        System.out.println("===============================");
        // 栈
        //binaryTree.preOrderTravelByStack(nodeTree);
        //binaryTree.inOrderTravelByStack(nodeTree);
        binaryTree.postOrderTravelByStack(nodeTree);
    }
}
