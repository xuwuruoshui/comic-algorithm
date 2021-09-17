package club.xuwuruoshui.array.practice.dir04integerpowerof2;

public class Integerpowerof2 {
    public static void main(String[] args) {
        int a = 1024;
        int b = 866;
        System.out.println(integerpowerof2(a));
        System.out.println(integerpowerof2(b));

        Object flag = false;
        if(!(Boolean)flag){
            System.out.println("1");
        }
    }

    /**
     * 2的整数次幂
     * @param value
     * @return
     */
    public static  boolean integerpowerof2(int value){
        return (value&(value-1))==0;
    }
}
