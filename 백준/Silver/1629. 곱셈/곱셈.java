import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static long A,B,C;
    static void input(){
        A = scan.nextLong();
        B = scan.nextLong();
        C = scan.nextLong();
    }
    static void pro(){
        //A를 B번 곱하고 C로 나누어라
        System.out.println(pow(A,B));
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    public static long pow(long A, long exponent){
        //지수가 1이 될 때까지 반복한다.
        if (exponent == 1) return A % C;

        //지수의 절반에 해당하는 값으로 temp를 정한다.
        long temp = pow(A,exponent / 2);
        //A ^ 3 * A ^ 3 * A

        //홀수는 한번 더 곱해준다
        if (exponent % 2 == 1) return (temp * temp % C) * A % C;
        return temp * temp % C;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}