import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static long[] tree;
    public static void main(String[] args) {
        int N = scan.nextInt();
        int M = scan.nextInt();
        int treeHeight = 0;
        int temp = N;
        while (temp > 0) {
            treeHeight++;
            temp/=2;
        }
        int treeSize = (int)Math.pow(2, treeHeight+1);
        tree = new long[treeSize+1];
        int leftLeafNodeIdx = treeSize / 2 - 1;
        for(int i = 0; i < tree.length; i++){
            if(leftLeafNodeIdx +1 <= i && i <= leftLeafNodeIdx + N){
                tree[i] = scan.nextLong();
            }else{
                tree[i] = Long.MAX_VALUE;
            }
        }
        setTree(treeSize-1);

        for (int i = 0; i < M; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            start = start + leftLeafNodeIdx;
            end = end + leftLeafNodeIdx;
            System.out.println(getMin(start,end));
        }
        scan.close();
    }

    static long getMin(int start, int end) {
        long MIN = Long.MAX_VALUE;
        while (start <= end) {
            if(start % 2 == 1) {
                MIN = Math.min(MIN, tree[start]);
                start++;
            }
            start /= 2;
            if(end % 2 == 0) {
                MIN = Math.min(MIN, tree[end]);
                end--;
            }
            end /= 2;
        }
        return MIN;
    }

    static void setTree(int idx) {
        while (idx != 1) {
            if(tree[idx/2] > tree[idx]) {
                tree[idx/2] = tree[idx];
            }
            idx--;  
        }
    }

    static class FastReader{
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        void close() {
            try {
                if (br != null) br.close(); // br이 null이 아닐 때만 닫기
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}