import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        N = scan.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2-o1));
        while (N-- > 0){
            int input = scan.nextInt();
            if (input == 0){
                if (pq.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(pq.poll()).append('\n');
            }else
                pq.add(input);
        }
        System.out.println(sb.toString());
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }


        String next(){
            while (st == null || !st.hasMoreTokens()) {
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