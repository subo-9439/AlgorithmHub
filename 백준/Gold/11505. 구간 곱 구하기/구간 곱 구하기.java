import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static long[] tree;
    static int MOD = 1000000007;
    public static void main(String[] args) {
        int N = scan.nextInt();
        int M = scan.nextInt();
        int K = scan.nextInt();
        
        int treeHeight = 0;
        int temp = N;
        while (temp > 0) {
            treeHeight++;
            temp/=2;
        }
        int treeSize = (int)Math.pow(2, treeHeight+1);
        int leafNodeLeftIndex = treeSize/2 - 1;
        tree = new long[treeSize+1];

        //곱셉은 1로 초기화
        for (int i = 0; i < tree.length; i++) {
            if(leafNodeLeftIndex+1 <= i && i <= leafNodeLeftIndex + N) {
                tree[i] = scan.nextLong();
                continue;
            }
            tree[i] = 1;
        }
        setTree(treeSize-1);

        for (int i = 0 ; i < M+K; i++){
            int a = scan.nextInt();
            int s = scan.nextInt();
            long e = scan.nextLong();
            if(a == 1){
                s = s+ leafNodeLeftIndex;
                changeVal(s, e);
            }else if(a == 2){
                s = s + leafNodeLeftIndex;
                e = e + leafNodeLeftIndex;
                getMul(s,(int)e);
            }else{
                return;
            }

        }

        scan.close();
    }

    static void getMul(int start, int end){
        long mul = 1;
        while (start <= end) {
            if(start % 2 == 1){
                mul = mul * tree[start] % MOD;
                start++;
            }

            if(end % 2 == 0){
                mul = mul * tree[end] % MOD;
                end--;
            }

            start/=2;
            end/=2;
        }
        System.out.println(mul);
    }

    static void changeVal(int index, long e) {
        tree[index] = e;
        while (index > 1) {
            index/=2;
            tree[index] = tree[index*2] % MOD * tree[index*2 + 1] % MOD;
        }
    }

    static void setTree(int index){
        while (index > 1) {
            tree[index/2] = tree[index/2] * tree[index] % MOD;
            index--;
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