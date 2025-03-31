import java.util.*;

class Solution {
    static final int INF = 120;

    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        int[][] dp = new int[itemCount + 1][m];

        for (int i = 0; i <= itemCount; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= itemCount; i++) {
            int aTrace = info[i - 1][0]; // A가 훔칠 때 남기는 흔적
            int bTrace = info[i - 1][1]; // B가 훔칠 때 남기는 흔적

            for (int b = 0; b < m; b++) {
                if (dp[i - 1][b] == INF) continue;

                // 1. A 도둑이 훔치는 경우 → A 흔적 증가, B 흔적 그대로
                int newATrace = dp[i - 1][b] + aTrace;
                dp[i][b] = Math.min(dp[i][b], newATrace);

                // 2. B 도둑이 훔치는 경우 → A 흔적 그대로, B 흔적 증가
                int newB = b + bTrace;
                if (newB < m) {
                    int sameA = dp[i - 1][b];
                    dp[i][newB] = Math.min(dp[i][newB], sameA);
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
