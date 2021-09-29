package club.xuwuruoshui.array.practice.test11findmissingint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 乱序数组, 长度为9, 数组内的值为1-10中的9个, 找出缺少的那一个数
 */
public class FindMissingInt {

    //缺少的数为4,
    private static int[] arr = new int[]{1,3,2,7,5,8,6,10,9};

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(arr));
        System.out.println(method1(arr));
        //System.out.println(method2(arr));
        //System.out.println(method3(arr));
    }

    // 1. 加一个Hash表存1-10,有就
    public static int method1(int arr[]){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i+1,i+1);
        }

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.remove(arr[i]);
            }
        }
        if(!map.isEmpty()){
            return map.keySet().iterator().next();
        }
        return 0;
    }

    // 2. 先排序，再遍历判断是否一一对应
    public static int method2(int arr[]){
        // 1. 先排序
        Arrays.sort(arr);

        // 2. 遍历
        for (int i = 0; i < 10; i++) {
            if(arr[i]!=i+1){
                return i+1;
            }
        }

        return 0;
    }

    // 3. 直接把1-10加起来，减去数组和
    public static int method3(int arr[]){
        int total = 0;
        for (int i = 1; i <= 10; i++) {
            total+=i;
        }

        int arrTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            arrTotal+=arr[i];
        }
        return total-arrTotal;
    }
}
