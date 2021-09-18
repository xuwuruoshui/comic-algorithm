package club.xuwuruoshui.array.practice.test01linkedListExistCircle;

import club.xuwuruoshui.array.dir01linear.link.Node;


/**
 * 判断链表是否闭环
 */
public class LinkedListExistCircle {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(5);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(7);
        Node<Integer> node4 = new Node<>(2);
        Node<Integer> node5 = new Node<>(6);
        Node<Integer> node6 = new Node<>(1);
        Node<Integer> node7 = new Node<>(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;

        //System.out.println(isCircle(node1));
        //System.out.println(circleLength(node1));
        System.out.println(entryNode(node1).data);
    }

    /**
     * 是否闭环
     * @param head
     * @return
     */
    private static boolean isCircle(Node<Integer> head) {
        Node p1 = head;
        Node p2 = head;

        while (p1!=null && p2!=null){
            p1 = p1.next;
            p2 = p2.next.next;

            if(p1==p2){
                return true;
            }
        }
        return false;
    }


    /**
     * 闭环长度
     * @return
     */
    private static int circleLength(Node<Integer> head){
        Node p1 = head;
        Node p2 = head;

        while (p1!=null && p2!=null){
            p1 = p1.next;
            p2 = p2.next.next;

            if(p1==p2){
                break;
            }
        }

        int count = 1;
        p1 = p1.next;
        while (p1!=p2){
            count++;
            p1 = p1.next;
        }
        return count;
    }

    private static Node<Integer> entryNode(Node<Integer> head){
        Node p1 = head;
        Node p2 = head;

        while (p1!=null && p2!=null){
            p1 = p1.next;
            p2 = p2.next.next;

            if(p1==p2){
                break;
            }
        }

        // 重置p1
        p1 = head;

        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
