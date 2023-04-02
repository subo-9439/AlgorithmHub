import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int N, M, K, X;
    static ArrayList<Integer>[] nodes;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();//최단거리가 K인 도시
        X = scan.nextInt();//X부터 시작해서
        nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            nodes[from].add(to);
        }
        bfs(X,K);
        if (ans.isEmpty()) {
            System.out.println(-1);
        }else {
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                sb.append(ans.get(i)).append("\n");
            }
            System.out.println(sb.toString());
        }
    }
    static void bfs(int start, int leftDist){
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(start,0));

        while (!queue.isEmpty()) {
            Info from = queue.poll();
            if (from.dist == K) {
//                sb.append(from.nodeIdx).append("\n");
                ans.add(from.nodeIdx);
                continue;
            }
            for (int to : nodes[from.nodeIdx]){
                if (visited[to]) continue;
                visited[to] = true;
                queue.add(new Info(to,from.dist+1));
            }
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        private FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static class Info {
        int nodeIdx;
        int dist;
        Info(int nodeIdx, int dist){
            this.nodeIdx = nodeIdx;
            this.dist = dist;
        }
    }
}