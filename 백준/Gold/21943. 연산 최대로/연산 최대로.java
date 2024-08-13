import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,max;
    static int[] arr;
    public static void main(String[] args) {
        N = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
        int P = scan.nextInt();
        int Q = scan.nextInt();
        // 6
        // 1 2 4 5 7 8
        // 4 1 => 곱셈개수+1 만큼 그룹으로 나눠서 생각
        // ㅁ * ㅁ 
        int[] group = new int[Q+1];
        dfs(0, group);
        System.out.println(max);
    }

    static void dfs(int idx, int[] group) {
        if(idx == N) {
            int ans = Arrays.stream(group).reduce(1, (x,y) -> x * y);
            max = Math.max(max, ans);
            return;
        }

        for(int i = 0; i < group.length; i++){
            group[i] += arr[idx];
            dfs(idx+1, group);
            group[i] -= arr[idx];
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
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
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