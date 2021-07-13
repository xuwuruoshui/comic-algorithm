package club.xuwuruoshui.array.dir01linear.link;

public class Node<T> {
    private Node head;
    private Node last;
    private T data;
    private int size;

    public Node(T data) {
        this.data = data;
    }

    /**
     * 链表插入元素
     * @param data
     * @param index
     * @throws Exception
     */
    public void insert(T data, int index) throws Exception{
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node node = new Node(data);
        if(size==0){

        }
    }
}
