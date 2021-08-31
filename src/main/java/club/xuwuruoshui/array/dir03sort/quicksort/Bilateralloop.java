package club.xuwuruoshui.array.dir03sort.quicksort;

/**
 * 双边循环
 */
public class Bilateralloop {
    /**
     * @param array
     * @param startIndex 初始索引
     * @param endIndex 结尾索引
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        // 获取参照元素位置
        int referenceIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, referenceIndex - 1);
        quickSort(array, referenceIndex + 1, endIndex);

    }


    /**
     * 双边
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition(int[] array, int startIndex, int endIndex) {

        // 默认取第一个元素为参照元素
        int referenceValue = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // right处的元素大于参照元素,right-1,继续遍历;right处的元素小于参照元素,停止right遍历,开始left遍历.
            while (array[right] > referenceValue && right>left) {
                right--;
            }

            // left处元素小于参照元素,left+1,继续遍历;right处的元素大于参照元素,停止left遍历,交换当前元素和right元素。
            // 开始遍历right
            while (array[left] <= referenceValue && left<right) {
                left++;
            }

            if (array[left]>array[right]) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }

        // 将参考元素与(left、right)重合元素调换，
        array[startIndex] = array[left];
        array[left] = referenceValue;

        //返回重合元素
        return left;
    }
}
