import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이분탐색
//백준 2559 수열 실버 3
public class Main {
    static FastReader scan = new FastReader();
    static int N,K;
    static int[] nums;
    static int ans = Integer.MIN_VALUE;

    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = scan.nextInt();
        }
    }
//    static void pro(){
//        //정답이 최악일때 음수가 될 수있다.
//        for(int L = 0; L <= N-K; L++){
//            int sum = 0;
//            for (int R = L; R < L+K; R++) {
//                sum += nums[R];
//            }
//            ans = Math.max(ans,sum);
//        }
//        System.out.println(ans);
//    }
    static void pro(){
        int R = 0, sum = 0;
        for(int L = 0; L <= N-K; L++) {
            while (R < L+K){
                sum += nums[R++];
            }
            ans = Math.max(ans,sum);
            sum -= nums[L];
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
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