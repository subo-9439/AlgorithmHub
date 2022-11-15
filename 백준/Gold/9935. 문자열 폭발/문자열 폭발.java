import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static String str,bomb;

    static void input() {
        str = scan.next();
        bomb = scan.next();
    }
    static void pro() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= bomb.length()) {
                boolean flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    char ch1 = sb.charAt(sb.length() - bomb.length() + j) ;
                    char ch2 = bomb.charAt(j);
                    if (ch1 != ch2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.delete(sb.length()-bomb.length(),sb.length());
                }
            }
        }
        if (sb.length() == 0) {
            System.out.println("FRULA");
        }else {
            System.out.println(sb);
        }
    }
    public static void main(String[] args) {
        input();
        pro();
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
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}