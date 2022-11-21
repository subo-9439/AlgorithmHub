import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        //5 16 8 4 2
        int idxCnt = 0;
        while (k > 1) {
            list.add(k);
            idxCnt++;
            if (k%2==0){
                k/=2;
            }else {
                k = k*3 +1;
            }
        }
        list.add(1);
        //5 16 8 4 2 1

        double[] dp = new double[idxCnt+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + (list.get(i-1)+list.get(i))/2.0;
//            System.out.println(dp[i]);
        }

        answer = new double[ranges.length];
        for (int i = 0; i < answer.length; i++) {
            if (idxCnt+ranges[i][1] < ranges[i][0]){
                answer[i] = -1;

            }else {
                double start = dp[ranges[i][0]];
                double end = dp[idxCnt+ranges[i][1]];
                answer[i] = end-start;
            }
        }
        return answer;
    }
}
