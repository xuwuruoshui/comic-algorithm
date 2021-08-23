package club.xuwuruoshui.array.dir02tree.priorityqueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue);
    }
}
