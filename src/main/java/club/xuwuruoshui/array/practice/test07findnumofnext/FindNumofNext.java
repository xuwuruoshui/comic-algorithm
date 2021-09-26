package club.xuwuruoshui.array.practice.test07findnumofnext;

import java.util.Arrays;

/**
 *寻找全排列的下一个数
 * 思路：
 * 1. 找到逆序区的前一位元素.
 * 2. 从后遍历元素，找到比该元素大的元素，然后交换。由于是逆序区从后遍历，保证了比该元素大的元素一定是逆序区中最小的.
 * 3. 最后将逆序区元素逆转，变为顺序排列。
 */
public class FindNumofNext {
    public static void main(String[] args) {
        int num[] = {1,2,3,5,4};
        // 打印12345 之后的0个全排列整数
        for (int i = 0; i < 10; i++) {
            num = findNearestNumber(num);
            outputNumbers(num);
        }
    }

    public static int[] findNearestNumber(int[] numbers){
        // 1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);
        // 如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回null
        if(index==0){
            return null;
        }

        // 2. 把逆序区域的前一位和逆序区中刚刚大于它的数字交换位置
        // 复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers,numbers.length);
        exchangeHead(numbersCopy, index);

        // 3. 把原来大的逆序区域转为顺序
        reverse(numbersCopy,index);
        return numbersCopy;
    }

    /**
     * 确认逆序区位置
     * @param numbers
     * @return
     */
    public static int findTransferPoint(int[] numbers){
        for (int i=numbers.length-1;i>0;i--){
            if(numbers[i]>numbers[i-1]){
                return i;
            }
        }
        return 0;
    }


    /**
     * 交换逆序区前一位，和逆序区内比该位大的最小的一位
     * @param numbers
     * @param index
     * @return
     */
    private static int[] exchangeHead(int[] numbers,int index){
        int head = numbers[index-1];
        for (int i=numbers.length-1;i>0;i--){
            if(head<numbers[i]){
                numbers[index-1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }


    /**
     * 逆序排列
     * @param num
     * @param index
     * @return
     */
    private static int[] reverse(int[] num,int index){
        for(int i=index,j=num.length-1;i<j;i++,j--){
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    public static void outputNumbers(int[] numbers){
        for (int number : numbers) {
            System.out.print(number);
        }
        System.out.println();
    }


}
