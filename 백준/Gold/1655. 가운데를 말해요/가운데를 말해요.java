import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] map;
    static void input() {
        N = scan.nextInt();
        map = new int[N+1];
        for (int i = 1; i <= N; i++) {
            map[i] = scan.nextInt();
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> abHeap = new PriorityQueue<>((o1,o2)->o2-o1);       //작은값부터 중간값전까지
        PriorityQueue<Integer> bcHeap = new PriorityQueue<>((o1,o2)->o1-o2);       //중간값부터 끝에값까지
        input();
        for (int i = 1; i <= N; i++) {
            if (bcHeap.isEmpty()) {
                bcHeap.add(map[i]);
            }else if (abHeap.isEmpty()) {
                if (bcHeap.peek() < map[i]) {       //bc의 최소값이 항상 더큰값이 들어가게끔
                    abHeap.add(bcHeap.poll());
                    bcHeap.add(map[i]);
                }else {
                    abHeap.add(map[i]);
                }
            }else {
                if (abHeap.size() == bcHeap.size()){
                    if (map[i] < bcHeap.peek() && map[i] > abHeap.peek()){
                        abHeap.add(map[i]);
                    }else if (map[i] > bcHeap.peek()) {
                        bcHeap.add(map[i]);
                    }else {
                        abHeap.add(map[i]);
                    }
                }else {
                    if (abHeap.size() > bcHeap.size()){
                        if(abHeap.peek() > map[i]) {
                            bcHeap.add(abHeap.poll());
                            abHeap.add(map[i]);
                        }else {
                            bcHeap.add(map[i]);
                        }
                    }else {
                        if (bcHeap.peek() < map[i]) {
                            abHeap.add(bcHeap.poll());
                            bcHeap.add(map[i]);
                        }else {
                            abHeap.add(map[i]);
                        }
                    }
                }
            }
            sayMid(abHeap,bcHeap);
        }
        System.out.println(sb);

    }
    static void sayMid(PriorityQueue<Integer> small,PriorityQueue<Integer> big){
        if (small.size() < big.size()) {
            sb.append(big.peek()).append('\n');
        } else if (small.size() > big.size()) {
            sb.append(small.peek()).append('\n');
        }else {
            sb.append(small.peek()).append('\n');
        }
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}