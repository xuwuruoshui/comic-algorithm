package club.xuwuruoshui.array.practice.test06stackimplqueue;

public class Test {
    public static void main(String[] args) {
        Stackimplqueue stackimplqueue = new Stackimplqueue();
        stackimplqueue.enQueue(1);
        stackimplqueue.enQueue(2);
        stackimplqueue.enQueue(3);
        System.out.println(stackimplqueue.deQueue());
        System.out.println(stackimplqueue.deQueue());
        System.out.println(stackimplqueue.deQueue());
        stackimplqueue.enQueue(4);
        stackimplqueue.enQueue(5);
        System.out.println(stackimplqueue.deQueue());
        System.out.println(stackimplqueue.deQueue());
    }
}
