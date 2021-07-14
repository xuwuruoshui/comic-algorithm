package club.xuwuruoshui.array.dir01linear.link;

/**
 * 链表节点
 * @param <T>
 */
public class Node<T> {
    public Node<T> next;
    public T data;
    public int position;

    public Node(T data) {
        this.data = data;
    }

}
