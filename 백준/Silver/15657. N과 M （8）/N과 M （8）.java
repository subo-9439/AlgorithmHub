import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static Integer[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new Integer[N];
        ans = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        recursion(0,0);
        System.out.println(sb.toString());
    }

    private static void recursion(int ansIdx, int arrIdx) {
        if (ansIdx==M){
            for (int i = 0; i < M; i++){
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = arrIdx; i < N; i++) {
            if (ansIdx!=0 && ans[ansIdx-1] > arr[i]) {
                continue;
            }
            ans[ansIdx] = arr[i];
            recursion(ansIdx+1, i);
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st==null || !st.hasMoreTokens()){
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