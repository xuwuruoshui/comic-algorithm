package club.xuwuruoshui.array.dir01linear.stack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStackArray<String> stack = new MyStackArray<>(10);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.get(2));
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
