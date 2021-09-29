package club.xuwuruoshui.array.practice.test11findmissingint;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组内, 只有两个数字出现次数为奇数次, 其他出现次数为偶数次。找出出现奇数次的两个数字
 */
public class FindMissingInt2 {
    private static int[] arr = new int[]{3,2,3,2,6,7,6,1};

    public static void main(String[] args) {

        // 1. 对所有数进行异或
        int result = method(arr);
        String str = Integer.toBinaryString(result);
        String[] s1 = str.split("");
        // 从后遍历获取等于1的位置。等于1的位置是两个奇数次的元素互不相同造成的
        int target = 0;
        for (int i = s1.length-1; i >=0; i--) {
            if(s1[i].equals("1")){
                break;
            }
            target++;
        }

        // 2. 创建两个数组分治
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            String s2[] = Integer.toBinaryString(arr[i]).split("");
            int value = 0;
            if(s2.length-1-target>0){
                value = Integer.valueOf(s2[s2.length-1-target]);
            }

            if(1 == value){
                list1.add(arr[i]);
            }else {
                list2.add(arr[i]);
            }
        }

        System.out.println(method1(list1));
        System.out.println(method1(list2));
    }

    private static int method(int arr[]) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result=result^arr[i];
        }
        return result;
    }

    private static int method1(List<Integer> list) {

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result^list.get(i);
        }
        return result;
    }
}
