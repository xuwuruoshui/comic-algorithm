package club.xuwuruoshui.array.dir01linear.link;

public class MyLinkList <T>{

    /**
     * 头指针
     */
    private Node<T> head;
    /**
     * 尾指针
     */
    private Node<T> last;
    /**
     * 链表实际长度
     */
    private int size;
    /**
     * 是否更新Node下标
     */
    private boolean flag = false;
    private Node[] array;


    /**
     * 链表插入元素
     * @param data  插入数据
     * @param index 插入位置
     */
    public void insert(T data, int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node<T> insertNode = new Node<>(data);

        if(size==0){
            // 空链表
            head = insertNode;
            last = insertNode;
        }else if (index == 0){
            // 插入头部
            insertNode.next = head;
            head = insertNode;
        }else if(size == index){
            // 插入尾部
            last.next = insertNode;
            last = insertNode;
        }else {
            // 插入中间,获取插入位置的前一个Node
            Node<T> preNode = get(index-1);
            insertNode.next  = preNode.next;
            preNode.next = insertNode;
        }
        size++;
        flag = false;
    }

    /**
     * 查找元素
     * @param index 索引
     * @return Node节点
     */
    public Node<T> get(int index){

        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("查找位置超出链表长度");
        }

        if(flag){
            return array[index];
        }
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 添加元素
     * @param data 元素数据
     */
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        last.next = newNode;
        last = newNode;
        size++;
        if(flag){
            newNode.position = size-1;
        }
    }

    /**
     * 链表删除元素
     * @param index 下标
     * @return
     */
    public Node<T> remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }

        Node<T> removeNode = null;

        if(index==0){
            // 删除头节点
            removeNode = head;
            head = head.next;
        }else if(index == size-1){
            // 删除尾节点
            removeNode = last;
            Node<T> prNode = get(index - 1);
            prNode.next = null;
            last = prNode;
        }else {
            // 删除中间节点
            Node<T> prNode = get(index - 1);
            removeNode = prNode.next;
            prNode.next = prNode.next.next;
        }
        size--;
        flag = false;
        return removeNode;
    }

    /**
     * 手将元素添加到数组中,可以使查询效率变为O(1)
     */
    public void setPosition(){
        array = new Node[size];
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
             temp.position = i;
             array[i] = temp;
             temp = temp.next;
        }
        flag = true;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(temp.data);
             if(i!=size-1){
                 stringBuilder.append(",");
             }
            temp = temp.next;
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
