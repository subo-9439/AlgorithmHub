import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        nodes = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            nodes[from].add(to);
            nodes[to].add(from);
        }
        for (int i = 0 ; i < N; i++) {
            dfs(i, 1);
            if (flag) break;
        }
        if (flag){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static void dfs(int from,int depth){
        if (depth == 5 || flag) {
            flag = true;
            return;
        }
        visited[from] = true;
        for (Integer to : nodes[from]) {
            if (visited[to]) continue;
            dfs(to,depth+1);
        }
        visited[from] = false;
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
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
}