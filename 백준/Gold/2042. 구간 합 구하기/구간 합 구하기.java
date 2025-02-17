import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static long[] tree;
    public static void main(String[] args) {
        int N = scan.nextInt();
        int M = scan.nextInt();
        int K = scan.nextInt();
        int treeHeight = 0; //3
        int length = N; //5
        while (length != 0) {
            length /= 2;
            treeHeight++;
        } 
        int treeSize = (int) Math.pow(2,treeHeight + 1); //16
        int leftNodeStartIndex = treeSize / 2 - 1;
        tree =  new long[treeSize + 1];

        for (int i = leftNodeStartIndex +1; i <= leftNodeStartIndex + N; i++){
            tree[i] = scan.nextLong();
        }

        setTree(treeSize - 1);
        for (int i = 0; i < M + K; i++) {
            int a = scan.nextInt();
            int s = scan.nextInt();
            long e = scan.nextLong();
            if (a == 1) {
                changeVal(leftNodeStartIndex + s, e);
            }else if( a== 2) {
                s += leftNodeStartIndex;
                e += leftNodeStartIndex;
                System.out.println(getSum(s, (int) e));
            } else {
                return;
            }

        }
    }

    private static long getSum(int s, int e) {
        long partSum = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                partSum += tree[s];
                s++;
            }
            if (e % 2 == 0) {
                partSum += tree[e];
                e--;
            }

            s /= 2;
            e /= 2;
        }
        return partSum;
    }

    private static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] = tree[index] + diff;
            index = index / 2;
        }
    }

    private static void setTree(int i) {
        while (i != 1){
            tree[i / 2] += tree[i];
            i--;
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
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

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}