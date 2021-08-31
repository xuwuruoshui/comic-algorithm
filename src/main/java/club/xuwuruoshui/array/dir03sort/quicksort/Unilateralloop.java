package club.xuwuruoshui.array.dir03sort.quicksort;


import java.awt.event.ItemEvent;

public class Unilateralloop {

    public static void quickSort(int arr[],int startIndex,int endIndex){
        if(startIndex>endIndex){
            return;
        }

        int referenceIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, referenceIndex-1);
        quickSort(arr, referenceIndex+1, endIndex);
    }

    /**
     * 单边
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition(int arr[],int startIndex,int endIndex){
        int referenceValue = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex+1; i < arr.length; i++) {
            if(arr[i]<referenceValue){
                mark++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = referenceValue;
        return mark;
    }

}
