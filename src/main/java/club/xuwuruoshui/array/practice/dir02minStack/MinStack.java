package club.xuwuruoshui.array.practice.dir02minStack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    /**
     * 入栈
     */
    public void push(Integer data){
        stack.push(data);
        // 最小栈中无数据就直接添加 或者  出现比最小栈中还要小的元素
        if(minStack.size()==0 || minStack.peek()>data){
            minStack.push(data);
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){

        if(stack.isEmpty()){
            throw new IndexOutOfBoundsException("栈中已无数据!!!");
        }
        // 最小栈不能空，并且两个栈中的元素相同
        if(!minStack.isEmpty() && stack.pop().equals(minStack.peek())){
            minStack.pop();
        }

        return 0;
    }

    /**
     * 获取最小栈
     * @return
     */
    public int getMin(){
        if(minStack.isEmpty()){
            throw new IndexOutOfBoundsException("最小栈中已无数据!!!");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(9);
        minStack.push(7);
        minStack.push(3);
        minStack.push(8);
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
