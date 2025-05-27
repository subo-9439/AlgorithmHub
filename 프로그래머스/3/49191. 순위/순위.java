class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];

        // 1. 초기화: 승리 정보를 기반으로 그래프 채우기
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;  // 이김
            graph[loser][winner] = -1; // 짐
        }

        // 2. 플로이드-워셜로 간접 승/패 관계 채우기
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        // 3. 각 선수별로 정확한 순위를 알 수 있는지 체크
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
