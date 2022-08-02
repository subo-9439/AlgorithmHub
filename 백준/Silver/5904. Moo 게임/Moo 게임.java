import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static char ans;
    public static void main(String[] args) {
        N = scan.nextInt();
        moo(N);
        System.out.println(ans);
    }
    static void moo(int num) {
        int side = 0;
        int mid = 3;
        while (num > 2*side+mid){
            side = (2 * side + mid);
            mid++;
        }
        if (side+1 == num){
            ans = 'm';
        }else if(side+1< num && num < side+mid+1){
            ans = 'o';
        }else {
            moo(num-side-mid);
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st==null || !st.hasMoreTokens()){
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