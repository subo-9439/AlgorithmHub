import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        N = scan.nextInt();
        arr = new int[N];
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(scan.nextInt());
        }

        boolean flag = false;
        while (!pq.isEmpty()){
            int a = pq.poll();
            int b = 0;
            if (pq.isEmpty()){
                break;
            }else {
                b = pq.poll();
            }
            int c = a+b;
            ans += c;
            pq.add(c);
        }

        System.out.println(ans);

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
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