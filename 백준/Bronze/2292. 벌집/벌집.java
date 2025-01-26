import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        long num = scan.nextLong();
        long sum = 1;
        long step = 1;
        while (true) {
            sum += 6 * step;
            step++;
            if(num <= sum){
                break;
            }

        }
        if(num== 1){
            System.out.println(1);
        }else{
            System.out.println(step);

        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next(){
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public long nextLong(){
            return Long.parseLong(next());
        }
    }
}
