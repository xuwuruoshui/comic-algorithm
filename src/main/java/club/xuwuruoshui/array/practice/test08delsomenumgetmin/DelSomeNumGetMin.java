package club.xuwuruoshui.array.practice.test08delsomenumgetmin;

import java.util.Arrays;
import java.util.Stack;

/**
 * 删去k个数字后的最小值
 * 思路：
 * - 遇到逆序时，把大的哪一位置空.排好序后,k还大于0,倒序遍历置空
 * - 遇到逆序时，出栈，k-1,不是逆序就入栈. 排好序后,k还大于0,倒序遍历置空
 */
public class DelSomeNumGetMin {

    public static void main(String[] args) {
        int num = 35267234;

        System.out.println(Arrays.toString(replace(num, 6)));

        // 栈
        //System.out.println(replace1(num, 6));

    }


    // 栈
    private static Stack replace1(int num, int k) {

        Integer[] numArr = toIntArray(num);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numArr.length; i++) {
            if (k > 0) {
                if (i == 0) {
                    stack.push(numArr[i]);
                    continue;
                }
                while (!stack.isEmpty() && k > 0 && stack.peek() > numArr[i]) {
                    stack.pop();
                    k--;
                }
            }
            if (i != 0)
                stack.push(numArr[i]);
        }
        while (k != 0) {
            stack.pop();
            k--;
        }
        return stack;
    }

    // 数组形式置空
    private static Integer[] replace(int num, int k) {
        Integer[] numArr = toIntArray(num);
        while (k > 0) {
            boolean flag = false;
            for (int i = 0; i < numArr.length; i++) {
                if (k <= 0) {
                    break;
                }
                if (numArr[i] == null) {
                    continue;
                }
                int tmp = i + 1;
                while (tmp < numArr.length - 2 && numArr[tmp] == null) {
                    tmp++;
                }
                if (tmp < numArr.length - 1 && numArr[i] > numArr[tmp]) {
                    k--;
                    flag = true;
                    numArr[i] = null;
                }
            }

            for (int i = numArr.length - 1; i >= 0; i--) {
                if (!flag && k > 0) {
                    if (numArr[i] != null) {
                        numArr[i] = null;
                        k--;
                    }else {
                        break;
                    }
                }
            }
        }
        return numArr;
    }


    // int转int数组
    public static Integer[] toIntArray(int num) {
        String str = String.valueOf(num);
        String[] strArr = str.split("");
        Integer[] intArr = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.valueOf(strArr[i]);
        }
        return intArr;
    }
}
