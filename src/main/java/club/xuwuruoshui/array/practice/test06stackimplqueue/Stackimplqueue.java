package club.xuwuruoshui.array.practice.test06stackimplqueue;

import java.util.Stack;

public class Stackimplqueue {
    private Stack<Integer> en = new Stack<>();
    private Stack<Integer> de = new Stack<>();

    public void enQueue(Integer element){
        en.push(element);
    }

    public Integer deQueue(){
        if(de.isEmpty() && en.isEmpty()){
            throw new IndexOutOfBoundsException("取完了");
        }

        if(!de.isEmpty()){
            return de.pop();
        }

        while (!en.isEmpty()){
            de.push(en.pop());
        }
        return de.pop();
    }
}
