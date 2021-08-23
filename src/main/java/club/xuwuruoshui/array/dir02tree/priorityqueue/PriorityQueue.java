package club.xuwuruoshui.array.dir02tree.priorityqueue;

import java.util.Arrays;

public class PriorityQueue{

    private int array[];
    private int size;
    public PriorityQueue(){
        array = new int[32];
    }


    /**
     * 入队
     * @param target 入队元素
     */
    public void enQueue(int target){
        if(size>array.length-1){
            // 扩容
            resize();
        }
        array[size++] = target;
        // 上浮
        upAdjust();
    }

    /**
     * 扩容
     */
    private void resize(){
        int newLenght = this.size*2;
        array = Arrays.copyOf(array, newLenght);
    }

    /**
     * 上浮优化
     */
    public void upAdjust(){
        int target = size-1;
        int targetParent = (target-1)/2;

        int temp = array[target];
        while (targetParent>=0 && temp>array[targetParent]){
            array[target] = array[targetParent];
            target = targetParent;
            targetParent = (targetParent-1)>=0?(targetParent-1)/2:-1;
        }
        array[target] = temp;

    }

    public int deQueue(){
        // 获取第一个元素
        int head = array[0];
        array[0] = array[--size];
        array[size] = 0;
        // TODO 去除最后一位

        // 下沉
        downAdjust();
        return head;
    }

    /**
     * 下沉
     */
    private void downAdjust() {
        int temp = array[0];


        // 下浮的第一个元素下标为1
        int target = 0;
        int changeChild = 1;
        int leftChild = target*2+1;
        int rightChild = target*2+2;

        if(rightChild>=size){
            changeChild = leftChild;
        }else {
            changeChild = array[leftChild]>array[rightChild]?leftChild:rightChild;
        }

        while (changeChild<=size-1 && temp<array[changeChild]){

            array[target] = array[changeChild];
            target = changeChild;

            leftChild = target*2+1;
            rightChild = target*2+2;
            if(rightChild>=size){
                changeChild = leftChild;
            }else {
                changeChild = array[leftChild]>array[rightChild]?leftChild:rightChild;
            }
        }
        array[target] = temp;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
