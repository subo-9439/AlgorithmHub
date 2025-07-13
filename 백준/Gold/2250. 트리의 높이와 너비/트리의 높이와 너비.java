import java.io.*;
import java.util.*;

public class Main {
    static int N, root;
    static int[] leftChild, rightChild, isChild;
    static int[] levelMin, levelMax;
    static int curCol = 0, maxLevel = 0;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        N = fr.nextInt();

        leftChild = new int[N + 1];
        rightChild = new int[N + 1];
        isChild = new int[N + 1];
        levelMin = new int[N + 1];
        levelMax = new int[N + 1];

        Arrays.fill(levelMin, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            int num = fr.nextInt();
            int l = fr.nextInt();
            int r = fr.nextInt();
            leftChild[num] = l;
            rightChild[num] = r;
            if (l != -1) isChild[l] = 1;
            if (r != -1) isChild[r] = 1;
        }

        // 루트 노드 찾기
        for (int i = 1; i <= N; i++) {
            if (isChild[i] == 0) {
                root = i;
                break;
            }
        }

        inorder(root, 1);

        int ansLevel = 1, ansWidth = 1;
        for (int i = 1; i <= maxLevel; i++) {
            int width = levelMax[i] - levelMin[i] + 1;
            if (width > ansWidth) {
                ansWidth = width;
                ansLevel = i;
            }
        }

        System.out.println(ansLevel + " " + ansWidth);
    }

    static void inorder(int node, int depth) {
        if (node == -1) return;

        // 왼쪽 자식 방문
        inorder(leftChild[node], depth + 1);

        // 현재 노드 처리
        curCol++;
        levelMin[depth] = Math.min(levelMin[depth], curCol);
        levelMax[depth] = Math.max(levelMax[depth], curCol);
        maxLevel = Math.max(maxLevel, depth);

        // 오른쪽 자식 방문
        inorder(rightChild[node], depth + 1);
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
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
