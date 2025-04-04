import java.util.*;

class Solution {
    static final int INF = 120;

    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        // dp[i][j] : i개의 물건을 훔쳤을 때,
        //            B 도둑의 흔적이 j라면,
        //            A 도둑의 누적 흔적 최소값을 의미함
        int[][] dp = new int[itemCount + 1][m]; 

        for (int i = 0; i <= itemCount; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= itemCount; i++) {
            int aTrace = info[i - 1][0]; // A가 훔칠 때 남기는 흔적
            int bTrace = info[i - 1][1]; // B가 훔칠 때 남기는 흔적
            
            for (int j = 0; j < m; j++) {
                if(dp[i-1][j] == INF) continue;
                dp[i][j] = Math.min(dp[i-1][j] + aTrace, dp[i][j]);
                
                int newB = j + bTrace;
                if(newB < m) {
                    dp[i][newB] = Math.min(dp[i-1][j], dp[i][newB]);
                }
            }
            
        }

        int minATrace = INF;
        for (int b = 0; b < m; b++) {
            minATrace = Math.min(minATrace, dp[itemCount][b]);
        }

        return (minATrace >= n) ? -1 : minATrace;
    }
}
