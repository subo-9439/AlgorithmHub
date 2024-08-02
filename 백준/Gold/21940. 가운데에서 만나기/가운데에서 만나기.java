import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드 워셜로 풀기
public class Main {
    static FastReader scan = new FastReader();
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N + 1][N + 1];

        // 1. 배열 최대값으로 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE / 2); // 수정: 오버플로우 방지 위해 / 2
        }

        // 2. 자기 자신에서 자기 자신으로 가는 비용 0으로 초기화
        for (int from = 1; from <= N; from++) {
            map[from][from] = 0;
        }

        // 3. 각 간선에 대해 정보를 입력받기
        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            map[from][to] = cost;
        }

        // 4. 플로이드 워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        // 5. 답 필터링
        K = scan.nextInt();
        ArrayList<Integer> friends = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            friends.add(scan.nextInt());
        }

        int max = Integer.MAX_VALUE;
        for (int to = 1; to <= N; to++) {
            int now = 0; // 왕복시간들 중 최대값
            for (int j = 0; j < K; j++) {
                int from = friends.get(j);
                if (map[from][to] >= Integer.MAX_VALUE / 2 || map[to][from] >= Integer.MAX_VALUE / 2) {
                    now = Integer.MAX_VALUE;
                    break;
                }
                now = Math.max(now, map[from][to] + map[to][from]);
            }

            // 왕복시간들 중 최대가 최소가 되는 값 찾기
            if (max > now) {
                result.clear();
                result.add(to);
                max = now;
            } else if (max == now) {
                result.add(to);
            }
        }
        for (int x : result) {
            System.out.printf("%d ", x);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
