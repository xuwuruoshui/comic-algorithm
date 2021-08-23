package club.xuwuruoshui.array.dir02tree.binaryheap;

public class MyBinaryHeap{

    /**
     * 上浮
     * @param array 待调整的堆
     */
    public static void upAdjust(int array[]){

        // 要上浮的元素,最后插入的一位
        int target = array.length - 1;
        // 目标元素的父元素
        int targetParent = (target - 1) / 2;

        while (targetParent>=0 && array[targetParent]>array[target]){
            int temp = array[target];
            array[target] = array[targetParent];
            array[targetParent] = temp;
            target = targetParent;
            targetParent = (target - 1)>=0?(target-1)/2:-1;
        }

    }

    /**
     * 构建堆
     * @param array
     */
    public static void buildHeap(int array[]){
        // 从最后的非叶子节点元素开始
        for (int target = (array.length-2)/2; target >= 0; target--) {
            downAdjust(array,target);
        }
    }

    /**
     * 下沉
     * @param array 数组
     * @param target 目标父树
     */
    private static void downAdjust(int array[],int target) {
        int leftChild = target * 2 + 1;
        int rightChild = target * 2 + 2;

        // 获取子节点最小的元素
        int changeChild;
        if(rightChild>=array.length){
            changeChild = leftChild;
        }else {
            changeChild = array[leftChild]>array[rightChild]?rightChild:leftChild;
        }

        while (changeChild<=array.length-1 && array[target]>array[changeChild]){
            int temp = array[target];
            array[target] = array[changeChild];
            array[changeChild] = temp;

            target = changeChild;

            leftChild = target * 2 + 1;
            rightChild = target * 2 + 2;

            // 获取子节点最小的元素
            if(rightChild>=array.length){
                changeChild = leftChild;
            }else {
                changeChild = array[leftChild]>array[rightChild]?rightChild:leftChild;
            }
        }

    }
}
