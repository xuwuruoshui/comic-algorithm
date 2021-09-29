package club.xuwuruoshui.array.practice.test11findmissingint;

/**
 * 数组内, 只有一个数字出现次数为奇数次, 其他出现次数为偶数次。找出出现奇数次的数字
 */
public class FindMissingInt1 {

    private static int[] arr = new int[]{3,2,3,2,6,7,6};

    public static void main(String[] args) {

        int result = method();
        System.out.println(result);
    }

    private static int method() {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result=result^arr[i];
        }
        return result;
    }
}
