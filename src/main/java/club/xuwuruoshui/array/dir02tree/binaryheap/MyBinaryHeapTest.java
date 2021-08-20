package club.xuwuruoshui.array.dir02tree.binaryheap;


import java.util.Arrays;

public class MyBinaryHeapTest {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        MyBinaryHeap.upAdjust(array);
        System.out.println(Arrays.toString(array)); // [0, 1, 2, 6, 3, 7, 8, 9, 10, 5]


        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        MyBinaryHeap.buildHeap(array);
        System.out.println(Arrays.toString(array));// [7, 6, 5, 10, 1, 2, 8, 9, 3]
    }
}
