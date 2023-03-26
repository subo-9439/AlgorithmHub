import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;



public class Main {
    static FastReader scan = new FastReader();

    public static void main(String[] args) throws IOException {
        int N = scan.nextInt();
        int M = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        Deque<Node> deque = new ArrayDeque<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //사이즈가 M 인 윈도우 사이즈에서 계속해서 최솟값을 구하려면
        //윈도우 안에 들어 있는 최솟값과 현재의 값 중 비교해서 출력해야 한다.
        //즉 이 두 값을 제외한 나머지 값은 필요로 하지 않는다.
        for (int i = 0; i < N; i++) {
            int now = scan.nextInt();

            while (!deque.isEmpty() && deque.getLast().getValue() > now) {
                deque.removeLast();
            }
            deque.addLast(new Node(i,now));

            if (deque.getFirst().getIdx() <= i-M) {
                deque.removeFirst();
            }
//            bw.write(deque.getFirst().getValue()+ " ");
            sb.append(deque.getFirst().getValue()).append(" ");
        }
        System.out.println(sb.toString());
//        bw.flush();
//        bw.close();
    }

    static class Node{
        int idx;
        int value;

        public Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }

        public int getIdx() {
            return idx;
        }

        public int getValue() {
            return value;
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
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}