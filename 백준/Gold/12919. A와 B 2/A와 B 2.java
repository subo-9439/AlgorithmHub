import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static FastReader scan = new FastReader();
    static String S,T;
    static int ans, len;
    public static void main(String[] args) {
        S = scan.next();
        T = scan.next();
        len = S.length();
        StringBuilder sb = new StringBuilder(T);
        recur(sb);

        System.out.println(ans);
        
    }

    static void recur(StringBuilder str) {
        if (str.length() < len) {
            return;
        }
        if (str.toString().equals(S)){
            ans = 1;
            return;
        }

        if (str.charAt(str.length()-1) == 'A'){
            recur(new StringBuilder(str.substring(0, str.length() - 1)));
        }
        if (str.charAt(0) == 'B') {
            recur(new StringBuilder(str.substring(1,str.length())).reverse());
        }
        
    } 

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreTokens()) {
                try{
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