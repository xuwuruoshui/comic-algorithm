package club.xuwuruoshui.array.dir03sort.countsort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int array[] = {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int sortedArray[] = countSort(array);
            System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        // 1、获取最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max){
                max = array[i];
            }
        }

        // 2、根据数列最大值确定统计数组的长度
        int countArray[] = new int[max+1];

        // 3、遍历数组，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }

        // 4、遍历统计数组，输出结果
        int sortedArray[] = new int[array.length];
        int index=0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j=0;j<countArray[i];j++){
                sortedArray[index++] = i;
            }
        }

        return sortedArray;
    }
}
