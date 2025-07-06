import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Edge>[] adj;
    static boolean[] visited;
    static int farthestNode, maxDist;

    static class Edge {
        int to, cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static void dfs(int u, int dist) {
        visited[u] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = u;
        }

        for (Edge e : adj[u]) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.cost);
            }
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        N = fr.nextInt();

        if (N == 1) {
            System.out.println(0);
            return;
        }

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int p = fr.nextInt();
            int c = fr.nextInt();
            int w = fr.nextInt();
            adj[p].add(new Edge(c, w));
            adj[c].add(new Edge(p, w));
        }

        visited = new boolean[N + 1];
        maxDist = 0;
        dfs(1, 0); // 1에서 가장 먼 노드 찾기

        visited = new boolean[N + 1];
        maxDist = 0;
        dfs(farthestNode, 0); // farthestNode에서 다시 DFS

        System.out.println(maxDist);
    }
}
