import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int n, m, vertex_cnt, edge_cnt;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    // dfs만 static 메서드로 유지
    static void dfs(int x) {
        vertex_cnt++;
        edge_cnt += adj[x].size();
        visit[x] = true;
        for (int y : adj[x]) {
            if (visit[y]) continue;
            dfs(y);
        }
    }

    public static void main(String[] args) {
        class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            String next() {
                while (st == null || !st.hasMoreElements()) {
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

        FastReader scan = new FastReader();

        Runnable input = () -> {
            n = scan.nextInt();
            m = scan.nextInt();
            adj = new ArrayList[n + 1];
            visit = new boolean[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            for (int i = 1; i <= m; i++) {
                int x = scan.nextInt(), y = scan.nextInt();
                adj[x].add(y);
                adj[y].add(x);
            }
        };

        // pro는 람다로 정의
        java.util.function.IntConsumer pro = (tt) -> {
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (visit[i]) continue;
                vertex_cnt = 0;
                edge_cnt = 0;
                dfs(i);
                if (edge_cnt == (vertex_cnt - 1) * 2) ans++;
            }

            sb.append("Case ").append(tt).append(": ");
            if (ans == 0) {
                sb.append("No trees.\n");
            } else if (ans == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(ans).append(" trees.\n");
            }
        };

        for (int tt = 1;; tt++) {
            input.run();
            if (n == 0 && m == 0) break;
            pro.accept(tt);
        }
        System.out.print(sb);
    }
}