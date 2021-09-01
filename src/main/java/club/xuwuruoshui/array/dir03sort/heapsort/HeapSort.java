package club.xuwuruoshui.array.dir03sort.heapsort;

import java.util.Arrays;

/**
 * 二叉堆排序
 * 思路：1.构建最大堆   2.数组首尾交换，长度限制(不限制，排好的元素又会下沉，最终顺序出错)
 */
public class HeapSort {

    public static void main(String[] args) {
        int array[] = new int[]{1,3,2,6,5,7,8,9,10,0};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] array) {

        // 1. 无序数组构建为最大堆
        for (int i = (array.length-2)/2; i >= 0; i--) {
            downAdjust(array,i,array.length);
        }

        for (int i = array.length-1; i >=0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0,i);
        }

    }

    /**
     * 下沉
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int array[],int parentIndex,int length){

        int childIndex = parentIndex*2+1;
        int temp = array[parentIndex];

        // 直到子下标超过长度
        while (childIndex<length){

            // 右节点存在，且比左节点大，子节点则为右节点
            if(childIndex+1<length-1 && array[childIndex+1]>array[childIndex]){
                childIndex++;
            }

            // 下沉元素比子元素大
            if(array[childIndex]<temp)
                break;

            // 单次交换，到最后再交换下沉元素
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;

        }
        array[parentIndex] = temp;
    }

}
