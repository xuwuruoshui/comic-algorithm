package club.xuwuruoshui.array.dir01linear.queue;

public class MyQueueTest {
    public static void main(String[] args) {

        MyQueue<String> queue = new MyQueue<>(8);
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        queue.enQueue("e");
        queue.enQueue("f");
        queue.enQueue("g");
        queue.enQueue("h");
        //queue.enQueue("j");
        System.out.println(queue);
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        //queue.deQueue();
        System.out.println(queue);
    }
}
