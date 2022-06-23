//import com.codestates.coplit.Solution;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static void input(){
        N = scan.nextInt();
    }
    static void pro(){
        String s = Integer.toBinaryString(N);
        int cnt = 0;
        for (int i = 0 ; i < s.length(); i++) if(s.charAt(i) == '1') cnt++;
        
        System.out.println(cnt);

    }
    public static void main(String[] args) {
        input();
        pro();
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