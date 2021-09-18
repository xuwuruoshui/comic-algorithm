package club.xuwuruoshui.array.test;


public class HelloWorld {
    public static void main(String[] args)  {
        int i = 2;
        int j = 3;
        System.out.println("i="+i+","+"j="+j);

        // 交换
        int temp = i;
        i=j;
        j=temp;
        System.out.println("i="+i+","+"j="+j);

        // 无法通过编译
        //int i = 5;
    }
}
