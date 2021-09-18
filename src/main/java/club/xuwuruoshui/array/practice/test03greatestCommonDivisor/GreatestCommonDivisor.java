package club.xuwuruoshui.array.practice.test03greatestCommonDivisor;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
//        Integer greatestCommonDivisor = getGreatestCommonDivisor(34, 45);
//        System.out.println(greatestCommonDivisor);

//        Integer getGreatestCommonDivisor1 = getGreatestCommonDivisor1(30, 45);
//        System.out.println(getGreatestCommonDivisor1);

        Integer getGreatestCommonDivisor3 = getGreatestCommonDivisor3(25, 45);
        System.out.println(getGreatestCommonDivisor3);
    }


    public static Integer getGreatestCommonDivisor3(int a, int b) {
        if (a == b) {
            return a;
        }

        // 奇偶判断,&1==0为偶数,&1!=0为奇数

        if ((a & 1) == 0 && (b & 1) == 0) {
            // 提一个2的倍数出来，最后再乘上
            return getGreatestCommonDivisor3(a>>1,b>>1)<<1;
        }else if((a&1)!=0&&(b&1)==0){// 奇数和偶数之间的最大公约数,一定是没有2的倍数存在
            return getGreatestCommonDivisor3(a,b>>1);
        }else if((a&1)==0&&(b&1)!=0){
            return getGreatestCommonDivisor3(a>>1,b);
        }else {// 更相减损术用一次
            int max = a>b?a:b;
            int min = a<b?a:b;
            return getGreatestCommonDivisor3(max - min, min);
        }
    }

    /**
     * 更相减损术
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatestCommonDivisor2(int a, int b) {

        if (a == b) {
            return a;
        }

        int max = a > b ? a : b;
        int min = a < b ? a : b;

        return getGreatestCommonDivisor2(max - min, min);
    }


    /**
     * 辗转相除法
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatestCommonDivisor1(int a, int b) {
        int max = a > b ? a : b;
        int min = a < b ? a : b;

        int result = 0;
        if (max % min != 0) {
            result = getGreatestCommonDivisor(min, max % min);
        }
        return result;
    }

    /**
     * 暴力法
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatestCommonDivisor(int a, int b) {

        int big = a > b ? a : b;
        int small = a < b ? a : b;

        if (big % small == 0) {
            return small;
        }

        for (int i = small / 2; i > 1; i--) {
            if (small % i == 0 && big % i == 0) {
                return i;
            }
        }

        return 1;
    }
}
