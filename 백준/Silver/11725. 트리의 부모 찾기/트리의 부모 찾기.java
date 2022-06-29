import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N ;
    static boolean[] visited;
    static int[] ans;
    static ArrayList<Integer>[] arr;
    static void input(){
        N = scan.nextInt();
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        ans = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 1; i <= N-1; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }
    }
    static void dfs(int x){
        visited[x] = true;
        for (int y : arr[x]){
            if(visited[y]) continue;
            ans[y] = x;
            dfs(y);
        }
    }
    public static void main(String[] args) {
        input();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++){
            if(visited[i]) continue;
            dfs(i);
        }
        for (int i = 2; i <= N; i++){
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}