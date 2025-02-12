import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static int N,M;
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++) {
            set.add(scan.next());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(scan.next())) { // 🔥 set2를 만들 필요 없이 직접 확인
                count++;
            }
        }

        System.out.println(count);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
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
        
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}