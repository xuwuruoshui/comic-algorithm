package club.xuwuruoshui.array.dir03sort.bubblesort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 * (方法为冒泡排序，第一次找出最大的，右边界缩小，第二次找出最小的，左边界缩小，
 * 第三次找出第2大的右边界缩小,第四次找出第2小的左边界缩小...)
 */
public class CocktailSort {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,7,8,1};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        // 记录遍历次数
        int count=0;

        int rightlastIndex = arr.length-1;
        int leftlastIndex = 0;
        // true左到右，false右到左
        boolean flag = true;

        int rightBorder = rightlastIndex;
        int leftBorder = leftlastIndex;

        while (rightlastIndex!=leftlastIndex){
            // 是否交换过位置
            boolean isChange = false;
            if(flag){
                for (int i = 0; i < rightBorder; i++) {
                    count++;
                    if (arr[i]>arr[i+1]) {
                        int temp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                        rightlastIndex=i;
                        isChange = true;
                    }
                }
                flag = false;
                rightBorder = rightlastIndex;
            }else {
                for (int i = rightBorder; i > leftBorder; i--) {
                    count++;
                    if(arr[i]<arr[i-1]){
                        int temp = arr[i];
                        arr[i] = arr[i-1];
                        arr[i-1] = temp;
                    }
                    leftlastIndex = i;
                    isChange = true;

                }
                flag = true;
                leftBorder = leftlastIndex;
            }
            if(!isChange){
                break;
            }
        }

        System.out.println(count);
    }

}
