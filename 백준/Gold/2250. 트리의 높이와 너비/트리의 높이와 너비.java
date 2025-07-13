import java.io.*;
import java.util.*;

public class Main {
    static int N, root;
    static int[] leftChild, rightChild;
    static boolean[] isChild;
    static int[] levelMin, levelMax;
    static int curCol = 0, maxLevel = 0;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        N = fr.nextInt();

        leftChild = new int[N + 1];
        rightChild = new int[N + 1];
        isChild = new boolean[N + 1];
        levelMin = new int[N + 1];
        levelMax = new int[N + 1];

        Arrays.fill(levelMin, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            int num = fr.nextInt();
            int l = fr.nextInt();
            int r = fr.nextInt();
            leftChild[num] = l;
            rightChild[num] = r;
            if (l != -1) isChild[l] = true;
            if (r != -1) isChild[r] = true;
        }

        // 루트 찾기: 자식으로 한 번도 등장하지 않은 노드
        for (int i = 1; i <= N; i++) {
            if (!isChild[i]) {
                root = i;
                break;
            }
        }

        // 중위 순회하며 열 번호 부여
        inorder(root, 1);

        // 레벨별 최대 너비 계산
        int ansLevel = 1;
        int ansWidth = levelMax[1] - levelMin[1] + 1;
        for (int i = 2; i <= maxLevel; i++) {
            if (levelMin[i] == Integer.MAX_VALUE) continue; // 방문하지 않은 레벨 무시
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

        inorder(leftChild[node], depth + 1);

        curCol++;
        levelMin[depth] = Math.min(levelMin[depth], curCol);
        levelMax[depth] = Math.max(levelMax[depth], curCol);
        maxLevel = Math.max(maxLevel, depth);

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
