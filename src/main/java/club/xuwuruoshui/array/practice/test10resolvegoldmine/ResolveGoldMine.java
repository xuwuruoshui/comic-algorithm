package club.xuwuruoshui.array.practice.test10resolvegoldmine;

public class ResolveGoldMine {

    public static int p[] = new int[]{3,4,3,5,5};
    public static int g[] = new int[]{200,300,350,400,500};

    public static void main(String[] args) {
        int w = 10;
        System.out.println(" 最优收益: "+getBestGoldMining(w,g.length));
    }

    /**
     * @param w 总人数
     * @param n 金矿个数
     * f(w,n)= max( f(w,n-1), f(w-p[n-1],n-1)+g(n-1) )
     * f(w,n-1) : 不按当前的方案挖。总人数w不变,接着下一个方案n-1,获得金矿为0。
     * f(w-p[n-1],n-1)+g(n-1) : 按当前的方案挖。总人数减去当前方案所需人数,接着下一个方案n-1,获取当前方案的金控。
     * @return
     */
    public static int getBestGoldMining(int w,int n){
        if(w==0 || n==0){
            return 0;
        }

        if(w<p[n-1]){
            return getBestGoldMining(w, n - 1);
        }
        return Math.max(getBestGoldMining(w,n-1),getBestGoldMining(w-p[n-1],n-1)+g[n-1]);
    }

}
