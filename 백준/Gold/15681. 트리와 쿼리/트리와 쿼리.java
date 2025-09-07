import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N, R, Q;
    static ArrayList<Integer>[] g;
    static int[] parent;
    static int[] dp;           // 서브트리 크기
    static int[] order;        // 방문 순서(전위 비슷), 역순으로 dp 누적

    public static void main(String[] args) {
        input();
        buildParentAndOrderIterative(R);
        computeSubtreeSizes();
        answerQueries();
    }

    static void input() {
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
    }

    // 재귀 없이 스택으로 부모와 방문순서를 만든다.
    static void buildParentAndOrderIterative(int root) {
        parent = new int[N + 1];
        order  = new int[N];  // 정확히 N개의 정점을 한 번씩 담는다

        Arrays.fill(parent, 0);
        int idx = 0;

        ArrayDeque<Integer> st = new ArrayDeque<>();
        parent[root] = -1;    // 루트 표시
        st.push(root);

        while (!st.isEmpty()) {
            int cur = st.pop();
            order[idx++] = cur;

            for (int nxt : g[cur]) {
                if (nxt == parent[cur]) continue;
                parent[nxt] = cur;
                st.push(nxt);
            }
        }
    }

    // order를 역순으로 돌며 후위 누적으로 dp 계산
    static void computeSubtreeSizes() {
        dp = new int[N + 1];
        Arrays.fill(dp, 1); // 자기 자신 카운트

        for (int i = N - 1; i >= 0; i--) {
            int v = order[i];
            int p = parent[v];
            if (p != -1) dp[p] += dp[v];
        }
    }

    static void answerQueries() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int u = scan.nextInt();
            sb.append(dp[u]).append('\n');
        }
        System.out.print(sb);
    }

    // 빠른 입력
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { throw new RuntimeException(e); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}
