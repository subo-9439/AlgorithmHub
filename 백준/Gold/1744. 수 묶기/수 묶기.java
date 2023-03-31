import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;

    public static void main(String[] args) {
        // 0, 1, 1보다 큰 양수, 음수로 나눠서 담는다.
        // 양수는 큰수부터 두개씩 뽑도록하고
        // 음수는 작은 수부터 두개씩 뽑도록 해야한다.
        // 나머지 하나 남은 음수는 0이 있을 때 곱해주도록한다.
        // 1은 곱해봐야 수가 더 커지지 않으므로 더하는 용도로만 써야한다.
        N = scan.nextInt();
        PriorityQueue<Integer> plusPq = new PriorityQueue(Comparator.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue();
        int oneCnt = 0;
        int zeroCnt = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            if (num < 0) {
                minusPq.add(num);
            } else if (num == 1) {
                oneCnt++;
            } else  if (num > 1) {
                plusPq.add(num);
            } else {
                zeroCnt++;
            }
        }
        while (plusPq.size() > 1)  {
            int num1 = plusPq.poll();
            int num2 = plusPq.poll();
            ans += num1 * num2;
        }
        while (minusPq.size() > 1) {
            int num1 = minusPq.poll();
            int num2 = minusPq.poll();
            ans += num1 * num2;
        }
        ans += plusPq.size() == 1? plusPq.poll() : 0;
        ans += minusPq.size() == 1? (zeroCnt>0? 0 : minusPq.poll()): 0;
        ans += oneCnt;
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