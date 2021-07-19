package club.xuwuruoshui.array.dir01linear.queue;

/**
 * 循环队列
 *
 * @param <T>
 */
public class MyQueue<T> {
    private Object[] array;
    /**
     * 队头
     */
    public int head;
    /**
     * 队尾
     */
    public int tail;
    /**
     * 容量
     */
    private int capacity = 10;
    /**
     * 真实长度
     */
    private int size;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public MyQueue() {
        array = new Object[capacity];
    }


    /**
     * 插入队列
     * @param element 入队元素
     */
    public void enQueue(T element) {
        if(size==capacity){
            throw new IndexOutOfBoundsException("队列已满");
        }
        array[tail] = element;
        size++;
        tail = (tail+1)%array.length;
    }

    /**
     * 出队列
     *
     * @return 出队元素
     */
    public T deQueue() {
        if ((size-1)<0) {
            throw new IndexOutOfBoundsException("队列已空");
        }
        T t = (T) array[head];
        head = (head + 1) % array.length;
        size--;
        return t;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int temp = tail;
        if(size==capacity){
            if(temp-1<0){
                temp = size-1;
            }
        }
        for (int i = head; i != temp;  i = (i + 1) % array.length) {
            stringBuilder.append(array[i]);
            if ((i + 1) % array.length != temp) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
