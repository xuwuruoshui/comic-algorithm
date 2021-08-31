package club.xuwuruoshui.array.dir03sort.quicksort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 通过栈回溯
 */
public class StackTraceback {


    public static void quickSort(int arr[],int startIndex,int endIndex){

        Stack<Map<String,Integer>> quickSortStack = new Stack<>();
        Map<String, Integer> root = new HashMap<>();
        root.put("startIndex",startIndex);
        root.put("endIndex",endIndex);
        quickSortStack.push(root);

        while (!quickSortStack.isEmpty()){
            Map<String, Integer> parent = quickSortStack.pop();
            int referenceIndex = partition(arr, parent.get("startIndex"), parent.get("endIndex"));

            if(parent.get("startIndex")<referenceIndex-1){
                Map<String, Integer> lefChild = new HashMap<>();
                lefChild.put("startIndex",parent.get("startIndex"));
                lefChild.put("endIndex",referenceIndex-1);
                quickSortStack.push(lefChild);
            }

            if(parent.get("endIndex")>referenceIndex+1){
                Map<String, Integer> rightChild = new HashMap<>();
                rightChild.put("startIndex",referenceIndex+1);
                rightChild.put("endIndex",parent.get("endIndex"));
                quickSortStack.push(rightChild);
            }
        }
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
