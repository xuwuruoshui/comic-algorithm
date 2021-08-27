package club.xuwuruoshui.array.dir03sort.bubblesort;
import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {

        // 遍历的边界
        int sortBorder = array.length-1;
        // 最后一次交换的位置
        int lastestIndex = 0;
        int count = 0;

        for (int i=0;i<array.length-1;i++){
            // 是否交换过元素
            boolean isChange = false;

            for (int j = 0; j < sortBorder; j++) {
                count++;
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isChange = true;
                    // 更新最后一次交换的位置
                    lastestIndex = j;
                }
            }
            if(!isChange){
                break;
            }
            sortBorder = lastestIndex;
        }
        System.out.println(count);
    }
}
