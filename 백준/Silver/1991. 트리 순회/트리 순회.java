import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static ArrayList<Node>[] list = new ArrayList[26];

    public static void main(String[] args) {
        int N = scan.nextInt();
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int alp = scan.next().charAt(0) - 'A';
            char leftChar = scan.next().charAt(0);
            char rightChar = scan.next().charAt(0);

            int left = (leftChar == '.') ? -1 : leftChar - 'A';
            int right = (rightChar == '.') ? -1 : rightChar - 'A';

            list[alp].add(new Node(left, right));
        }
        preOrder(0); // A
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    static void preOrder(int now) {
        if (now == -1) return;
        System.out.print((char) (now + 'A'));
        preOrder(list[now].get(0).left);
        preOrder(list[now].get(0).right);
    }

    static void inOrder(int now) {
        if (now == -1) return;
        inOrder(list[now].get(0).left);
        System.out.print((char) (now + 'A'));
        inOrder(list[now].get(0).right);
    }

    static void postOrder(int now) {
        if (now == -1) return;
        postOrder(list[now].get(0).left);
        postOrder(list[now].get(0).right);
        System.out.print((char) (now + 'A'));
    }

    static class Node {
        int left, right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
