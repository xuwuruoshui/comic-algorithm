package club.xuwuruoshui.array.dir03sort.countsort;

import java.util.Arrays;

/**
 * 单纯的数字排序,比如两个99分,如果是两个人的分数,排序后就不知道谁是谁了，原来的位置也没了.
 * 改进后如下
 */
public class CountSortPlus {
    public static void main(String[] args) {
        int array[] = {95,94,91,98,99,90,99,93,91,92};
        int sortedArray[] = countSort(array);

        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        // 1. 得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max = array[i];
            }

            if(array[i]<min){
                min = array[i];
            }
        }
        int d = max-min;

        // 2.创建统计数组并统计对应元素的个数.min为最小元素，在数组开头位置.
        int countArray[] = new int[d+1];
        for (int i = 0; i < countArray.length; i++) {
            countArray[array[i]-min]++;
        }

        // 3.统计数组做变形，后面元素等于前面的元素之和(从第二个元素开始)
        // 意在按顺序粗略排出大致的顺序，countArray的值就是排名(小的排第一)
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] +=countArray[i-1];
        }

        // 4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组

        int[] sortedArray = new int[array.length];
        // 原数组反向遍历
        for (int i = array.length-1; i >= 0; i--) {
            //-1是因为数组从0开始
            sortedArray[countArray[array[i]-min]-1] = array[i];
            // 相同值的元素下次遍历,排名就靠前
            countArray[array[i]-min]--;
        }

        return sortedArray;
    }
}
