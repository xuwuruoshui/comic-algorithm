package club.xuwuruoshui.array.dir03sort.bubblesort;
import java.util.Arrays;


/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int array[] = {5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        //int count = 0;
        for (int i = 0; i < array.length-1; i++) {

            // 要切换的位置
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                //count++;
                if(array[index]>array[j]){
                    index = j;
                }
            }

            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;

        }
        //System.out.println(count);
    }
}
