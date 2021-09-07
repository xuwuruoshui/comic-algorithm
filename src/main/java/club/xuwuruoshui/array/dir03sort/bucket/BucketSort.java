package club.xuwuruoshui.array.dir03sort.bucket;

import java.util.*;

/**
 * 桶排序
 */
public class BucketSort {

    public static void main(String[] args) {
        double array[] = {4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10};

        double sortedArray[] = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static double[] bucketSort(double[] array) {
        // 1.得到数列的最大值和最小值，并算出差值d
        double max = array[0];
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        double d = max-min;

        // 2.初始化桶
        int bucketNum = array.length;
        List<LinkedList<Double>> bucketList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            bucketList.add(new LinkedList<>());
        }

        // 3.遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            // 所在区间
            int num = (int)((array[i]-min)*(bucketNum-1)/(d-1));
            bucketList.get(num).add(array[i]);
        }

        // 4.对桶内部进行排序
        for (int i=0;i<bucketList.size();i++){
            // JDK自带归并排序
            Collections.sort(bucketList.get(i));
        }

        // 5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list: bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }

        return sortedArray;
    }
}
