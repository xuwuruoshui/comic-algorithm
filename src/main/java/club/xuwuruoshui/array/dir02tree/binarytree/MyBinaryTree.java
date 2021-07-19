package club.xuwuruoshui.array.dir02tree.binarytree;

import java.util.LinkedList;

public class MyBinaryTree<T>{


    /**
     * 构建二叉树
     * @param inputList 链表中取数据构建
     * @return
     */
    public TreeNode<T> createBinaryTree(LinkedList<T> inputList){
        TreeNode<T> node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        T data = inputList.removeFirst();
        if(data!=null){
            node = new TreeNode<>(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }


    /**
     * 前序遍历。    遍历顺序: 根节点==>左子树==>右子树
     * @param node 要遍历的节点
     */
    public void preOrderTravel(TreeNode<T> node) {
        if(node == null){
            return;
        }

        System.out.println(node.data);
        preOrderTravel(node.leftChild);
        preOrderTravel(node.rightChild);
    }


    /**
     * 中序遍历。    遍历顺序: 左子树==>根节点==>右子树
     * @param node
     */
    public void inOrderTravel(TreeNode<T> node){

        if(node==null){
            return;
        }
        inOrderTravel(node.leftChild);
        System.out.println(node.data);
        inOrderTravel(node.rightChild);
    }


    /**
     * 后序遍历。    遍历顺序:  左子树==>右子树==>根节点
     * @param node
     */
    public void postOrderTravel(TreeNode<T> node){
        if(node==null){
            return;
        }
        postOrderTravel(node.leftChild);
        postOrderTravel(node.rightChild);
        System.out.println(node.data);
    }
}
