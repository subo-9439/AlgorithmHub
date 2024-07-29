import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M,cnt;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        //b를 하기위해서는 a를 먼저해야 하므로 b -> a 방향으로 간선 생성
        for(int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            arr[b].add(a);
        }
        int lastAssignment = scan.nextInt();
        System.out.println(recursion(lastAssignment));
    }
    static int recursion(int x){
        visited[x] = true;
        for(int num : arr[x]) {
            if(visited[num]) continue;
            cnt++;
            recursion(num);
        }
        return cnt;

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e) {
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