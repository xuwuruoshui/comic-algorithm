package club.xuwuruoshui.array.dir01linear.array;

public class MyArrayList <T>{

    private Object[] array;
    /**
     * 实际元素数量
     */
    private int size;
    /**
     * 初始长度
     */
    private int capacity = 10;


    public MyArrayList(int capacity) {
        this.array = new Object[capacity];
        this.capacity = capacity;
    }

    public MyArrayList() {
        this.array = new Object[capacity];
    }


    /**
     * 插入元素
     *
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insert(T element, int index) {

        // 插入位置不能超出范围.位置为空则直接添加.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("插入位置超出范围,capcity可以设置大一些");
        } else {
            // 数组末尾存在元素
            if (array[size] != null) {
                throw new IndexOutOfBoundsException("数组末尾已存在元素,要不调用replace替换");
            }
            // 将元素逐个向后移一位
            for (int i = size; i >= index; i--) {
                array[i + 1] = array[i];
            }
            // 腾出的位置留给插入进来的
            array[index] = element;
        }
        size++;
    }


    /**
     * 添加元素
     *
     * @param element
     * @return
     */
    public int add(Object element) {

        resize();

        int position = size;
        array[position] = element;
        size++;
        return position;
    }


    /**
     * 扩容
     */
    public void resize() {

        // 超过最大值就扩容
        if (size + 1 > capacity) {
            capacity = capacity + (capacity >> 1);
            Object newArray[] = new Object[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }


    /**
     * 删除指定元素
     *
     * @param value 要删除的元素
     * @return 删除元素的位置,-1为无删除的元素
     */
    public int remove(T value) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                index = i;
                break;
            }
        }

        removeIndex(index);
        size--;
        return index;
    }


    /**
     * 根据下标删除元素
     *
     * @param index 数组下标
     */
    public void removeIndex(int index) {
        if (index == -1) {
            return;
        }
        for (int i = index; i < array.length; i++) {
            if (i == array.length - 1) {
                array[i] = null;
                break;
            } else {
                array[i] = array[i + 1];
            }
        }
    }


    /**
     * 手动减容量
     */
    public void trimeToSize() {
        if(size<capacity){
            capacity = size;
            Object newArray[] = new Object[capacity];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    /**
     * 获取长度
     */
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        /*return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';*/
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i != array.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
