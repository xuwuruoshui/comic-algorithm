package club.xuwuruoshui.array.practice.dir05maxadjacentdifferenceofarray;

import java.util.Arrays;

public class MaxAdjacentDifferenceOfArray {
    public static void main(String[] args) {
        int arr[] = {2,6,3,4,5,10,9};
        //System.out.println(method1(arr));
        //System.out.println(method2(arr));
        System.out.println(method3(arr));
    }

    /**
     * 桶排序
     * @param arr
     * @return
     */
    public static int method3(int arr[]){

        // 1. 获取元素最大、最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        int d = max-min;

        // 特殊情况，所有元素都相同
        if(d==0){
            return 0;
        }

        // 2.初始化桶
        int bucketNum = arr.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        // 3.遍历原始数组，确定每个桶的最大值和最小值
        for (int i = 0; i < buckets.length; i++) {

            // 确定数组元素所属的桶下标
            int index = ((arr[i]-min)*(bucketNum-1)/d);
            if(buckets[index].getMin()==null || buckets[index].getMin()>arr[i]){
                buckets[index].setMin(arr[i]);
            }

            if(buckets[index].getMax()==null || buckets[index].getMax()<arr[i]){
                buckets[index].setMax(arr[i]);
            }
        }

        // 4.遍历桶,找到最大差值.
        int leftMax = buckets[0].getMax();
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if(buckets[i].getMin()==null){
                continue;
            }
            // 右边最小的减左间最大的
            if(buckets[i].getMin() - leftMax > maxDistance){
                maxDistance = buckets[i].getMin() - leftMax;
            }
            leftMax=buckets[i].getMax();
        }

        return maxDistance;
    }

    /**
     * 计数排序
     * @param arr
     * @return
     */
    public static int method2(int arr[]){

        // 1. 获取元素最大、最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        // 2. 计算临时数组、偏移量
        int arrTemp[] = new int[max-min+1];
        int offset = min;
        for (int i = 0; i < arr.length; i++) {
                arrTemp[arr[i]-min]++;
        }

        // 3.计算间隔为0的最大个数，再加1
        int result = 0;
        int temp = 0;
        for (int i = 0; i < arrTemp.length; i++) {
            if(arrTemp[i]==0){
                temp++;
            }else {
                result = temp>result?temp:result;
                temp=0;
            }
        }
        return result+1;
    }

    /**
     * 暴力算法
     * @return
     */
    public static int method1(int arr[]){
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(max<(arr[i+1]-arr[i])){
                max = (arr[i+1]-arr[i]);
            }
        }
        return max;
    }
}
