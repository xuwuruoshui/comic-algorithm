package club.xuwuruoshui.array.practice.test09bigintadd;

import java.util.ArrayList;
import java.util.List;

public class BigIntAdd {
    public static void main(String[] args) {
        // -2的63--------2的63 -1
        long a = 9223372036854775807L;
        long b = 9223372036854775807L;

//        List<String> list = method1(a, b);
//        printValue(list);

        method2(a,b);

    }

    // 按9位数拆分，避免数组过长
    private static void method2(long a, long b) {
        int[] aArr = getIntArr(a);
        int[] bArr = getIntArr(b);

        int lengthA = aArr.length;
        int lengthB = bArr.length;
        int maxLength = Math.max(lengthA,lengthB)+1;
        String cArr[] = new String[maxLength];

        int carry = 0;
        int i = aArr.length-1;
        int j = bArr.length-1;
        int k = cArr.length;
        while (i>=0 || j>=0){

            int aTmp = i<0?0:aArr[i];
            int bTmp = j<0?0:bArr[j];

            int tmpResult = aTmp+bTmp+carry;
            int value=0;
            if(tmpResult<1000000000){
                carry = 0;
                value = tmpResult;
            }else {
                value = (aTmp+bTmp+carry)%1000000000;
                carry = (aTmp+bTmp+carry)/1000000000;
            }

            cArr[--k] = String.valueOf(value);
            i--;
            j--;
        }

        if(carry!=0){
            cArr[--k] = String.valueOf(carry);
        }
        for (int l = 0; l < cArr.length; l++) {
            if(cArr[l]==null){
                continue;
            }
            System.out.printf(cArr[l]);
        }
    }
    private static int[] getIntArr(long num){
        String numStr = String.valueOf(num);
        int arr[] = new int[numStr.length()%9==0?numStr.length()/9:(numStr.length()/9)+1];
        int index = numStr.length();
        for (int i = arr.length-1; i >=0; i--) {
            if(index-9<0){
                arr[i] =Integer.valueOf(numStr.substring(0,index));
                index = -1;
            }else {
                arr[i] =Integer.valueOf(numStr.substring(index-9,index));
                index-=9;
            }
        }
        return arr;
    }

    private static List<String> method1(long a, long b) {
        String aArr[] = String.valueOf(a).split("");
        String bArr[] = String.valueOf(b).split("");
        List<String> list = new ArrayList<>();

        int carry = 0;
        int i = aArr.length-1;
        int j = bArr.length-1;
        while (i>=0 || j>=0){

            int aTmp = i<0?0:Integer.valueOf(aArr[i]);
            int bTmp = j<0?0:Integer.valueOf(bArr[j]);

            int tmpResult = aTmp+bTmp+carry;
            int value=0;
            if(tmpResult<10){
                carry = 0;
                value = tmpResult;
            }else {
                value = (aTmp+bTmp+carry)%10;
                carry = (aTmp+bTmp+carry)/10;
            }

            list.add(String.valueOf(value));
            i--;
            j--;
        }

        if(carry!=0){
            list.add(String.valueOf(carry));
        }
        return list;
    }
    private static void printValue(List<String> list) {
        for (int k = list.size()-1; k >=0 ; k--) {
            System.out.printf(list.get(k));
        }
    }
}
