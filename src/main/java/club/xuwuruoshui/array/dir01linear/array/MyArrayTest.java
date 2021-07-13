package club.xuwuruoshui.array.dir01linear.array;

public class MyArrayTest {
    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(2);
        myArrayList.add(null);
        myArrayList.add(3);
        myArrayList.insert(5,1);
        for (int i = 0; i < 4; i++) {
            myArrayList.add(3);
        }
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());

        myArrayList.add(3);
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());

        myArrayList.remove(2);
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());

        myArrayList.trimeToSize();
        System.out.println(myArrayList);
    }
}
