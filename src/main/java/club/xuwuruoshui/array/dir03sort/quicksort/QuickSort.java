package club.xuwuruoshui.array.dir03sort.quicksort;

import java.util.Arrays;

/**
 * 快速排序，分治法
 */
public class QuickSort {

    public static void main(String[] args) {
        //int array[] = {5, 8, 6, 3, 9, 2, 1, 7};
        int array[] = {4, 4, 6, 5, 2, 3, 8, 1};

        // 双边
        //Bilateralloop.quickSort(array, 0, array.length - 1);

        // 单边
        //Unilateralloop.quickSort(array, 0, array.length - 1);

        // 栈回溯,单边
        StackTraceback.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
