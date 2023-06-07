import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    public static void main(String[] args) {
        int t = scan.nextInt();
//        2 5 10 갯수 세기
        int[] nums = new int[10];
        int cnt = 0;
        for (int i = 5; i <= t; i+=5) {
            if(i%5==0){
                int a = i;
                while (a >= 5) {
                    cnt ++;
                    a /= 5;
                    if(a%5 != 0) break;
                }
            }
        }
        System.out.println(cnt);
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null) {
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