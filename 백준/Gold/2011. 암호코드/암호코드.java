import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int[] dp;
    static String encode;
    static int N,MOD = 1000000;
    static void input(){
        encode = scan.nextLine();
        N = encode.length();
        dp = new int[N];
    }
    static void pro(){
        if(N == 0|| encode.charAt(0) == '0'){
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        if(N == 1){
            System.out.println(1);
            return;
        }
        for (int i = 1; i < N; i++){
            if(encode.charAt(i) != '0') dp[i] = dp[i-1];
            if (check(encode.charAt(i-1),encode.charAt(i))){
                if(i>=2) dp[i] += dp[i-2];
                else dp[i] +=  1;
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[N-1]);

    }
    static boolean check(char A, char B) {  // 'AB' 라는 두 자리 숫자가 하나의 수로 해독이 가능한가?
        if (A == '0') return false;
        if (A == '1') return true;
        if (A >= '3') return false;
        return B <= '6';
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
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

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
