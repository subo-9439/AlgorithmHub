import java.util.Arrays;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int a = arrayA[0];
        int b = arrayB[0];
        for (int i = 1; i < arrayA.length; i++){
            a = gcd(arrayA[i],a);
        }
        for (int i = 1; i < arrayB.length; i++){
            b = gcd(arrayB[i],b);
        }
        boolean canUseB= b != 1;
        boolean canUseA= a != 1;

        for (int i = 0; i < arrayA.length;i++){
            if (arrayA[i]%b==0){
                canUseB=false;
                break;
            }
        }

        for (int i = 0; i < arrayB.length;i++){
            if (arrayB[i]%a==0){
                canUseA=false;
                break;
            }
        }
        if (canUseA && !canUseB){
            return a;
        } else if (!canUseA && canUseB) {
            return b;
        }else if(canUseA && canUseB) {
            return Math.max(a,b);
        }else {
            return 0;
        }
    }

    public int gcd(int a, int b){
        if (b%a == 0){
            return a;
        }else {
            return gcd(b%a, a);
        }
    }
}