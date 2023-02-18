import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static long[] heights;
    public static void main(String[] args) {
        input();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            double curInclination = Integer.MIN_VALUE;
            for (int j = i + 1; j < N; j++) {
                double nextInclination = (heights[i] - heights[j]) / (double) (i - j);
                if (curInclination < nextInclination) {
                    curInclination = nextInclination;
                    count++;
                }
            }
            curInclination = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double nextInclination = (heights[i] - heights[j]) / (double)(i - j );
                if (curInclination > nextInclination) {
                    curInclination = nextInclination;
                    count++;
                }
            }
            max = Math.max(count,max);
        }
        System.out.println(max);
    }

    private static void input() {
        N = scan.nextInt();
        heights = new long[N];
        for (int i = 0; i < N; i++)
            heights[i] = scan.nextLong();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader (){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}