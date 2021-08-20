package club.xuwuruoshui.array.dir02tree.binarytree;

import club.xuwuruoshui.array.dir01linear.link.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBinaryTree<T> {


    /**
     * 构建二叉树
     * @param inputList 链表中取数据构建
     * @return
     */
    public TreeNode<T> createBinaryTree(LinkedList<T> inputList) {
        TreeNode<T> node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        T data = inputList.removeFirst();
        if (data != null) {
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
        if (node == null) {
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
    public void inOrderTravel(TreeNode<T> node) {

        if (node == null) {
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
    public void postOrderTravel(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrderTravel(node.leftChild);
        postOrderTravel(node.rightChild);
        System.out.println(node.data);
    }


    /**
     * 前序遍历。    遍历顺序: 根节点==>左子树==>右子树
     * @param node
     */
    public void preOrderTravelByStack(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.data);
                stack.push(node);
                node = node.leftChild;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }

    /**
     * 中序遍历。    遍历顺序: 左子树==>根节点==>右子树
     * @param node
     */
    public void inOrderTravelByStack(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }

            if (!stack.isEmpty()) {
                TreeNode<T> leftNode = stack.pop();
                System.out.println(leftNode.data);
                node = leftNode.rightChild;
            }
        }
    }

    /**
     * 后序遍历。    遍历顺序:  左子树==>右子树==>根节点
     * @param node
     */
    public void postOrderTravelByStack(TreeNode<T> node) {

        Stack<TreeNode<T>> stack = new Stack<>();
        // Map标记位
        HashMap<TreeNode<T> , Integer> map = new HashMap<>();
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }

            if (!stack.isEmpty()) {
                TreeNode<T> tempNode = stack.peek();
                if(map.containsKey(tempNode)){
                    map.put(tempNode,2);
                }else {
                    map.put(tempNode,1);
                }

                // 右子树为空的时候，或者右子树取过一次就出栈
                if(tempNode.rightChild==null || map.get(tempNode).equals(2)){
                    stack.pop();
                    System.out.println(tempNode.data);
                }else if(map.get(tempNode).equals(1)){
                    node = tempNode.rightChild;
                }
            }
        }
    }

    /**
     * 层序遍历
     * @param node
     */
    public void levelOrderTraversal(TreeNode<T> node){
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode<T> tempNode = queue.poll();
            System.out.println(tempNode.data);
            if(tempNode!=null && tempNode.leftChild!=null){
                queue.offer(tempNode.leftChild);
            }
            if(tempNode!=null && tempNode.rightChild!=null) {
                queue.offer(tempNode.rightChild);
            }
        }
    }
}
