package club.xuwuruoshui.array.dir01linear.stack;


public class MyStackArray <T>{

    private Object[] array;
    /**
     * 初始容量
     */
    private int capacity = 10;
    /**
     * 实际长度
     */
    private int size;

    public MyStackArray(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public MyStackArray() {
        array = new Object[capacity];
    }

    public void push(T data){
        if((size+1)>=capacity){
            throw new StackOverflowError("超出最大可存储空间,栈溢出");
        }
        array[size] = data;
        size++;
    }

    public void pop(){
        if((size-1)<0){
            throw new StackOverflowError("超出最大可存储空间,超出栈底了");
        }
        array[size] = null;
        size--;
    }

    public T get(int index){
        if(index<0 || index>=size){
            throw new StackOverflowError("元素获取超出范围，栈溢出");
        }
        return (T)array[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            if(i != size-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
