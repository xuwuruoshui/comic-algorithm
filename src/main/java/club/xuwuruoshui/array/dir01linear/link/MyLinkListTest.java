package club.xuwuruoshui.array.dir01linear.link;

public class MyLinkListTest {
    public static void main(String[] args) {
        MyLinkList<Integer> myLinkList = new MyLinkList<>();
        // 空插
        myLinkList.insert(1,0);
        // 尾插
        myLinkList.insert(2,1);
        // 头插
        myLinkList.insert(3,0);
        // 中间插入
        myLinkList.insert(4,1);
        System.out.println(myLinkList);
        System.out.println(myLinkList.get(2).data);
        /*myLinkList.setPosition();
        System.out.println(myLinkList.get(2).data);*/

        myLinkList.add(10);
        System.out.println(myLinkList);
        myLinkList.setPosition();
        //System.out.println(myLinkList.get(4).data);

        myLinkList.remove(0);
        System.out.println(myLinkList);
        myLinkList.remove(3);
        System.out.println(myLinkList);
        myLinkList.remove(1);
        System.out.println(myLinkList);
    }
}
