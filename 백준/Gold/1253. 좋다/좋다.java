import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] a;
    static void input(){
        N = sc.nextInt();
        a = new int[N+1];
        for(int i=1;i<=N;i++){
            a[i] = sc.nextInt();
        }
    }
    static void pro(){
        Arrays.sort(a,1,N+1);
        int L=1,R=N;
        int cnt=0;

        for(int target_idx=1;target_idx<=N;target_idx++){
            while (L < R){
                 if(L == target_idx) L++;
                 else if(R == target_idx) R--;
                 else {
                     if(a[target_idx]<a[L]+a[R])R--;
                     else if(a[target_idx]>a[L]+a[R]) L++;
                     else if(a[target_idx] == a[L]+a[R]) {
                         cnt++;
                         break;
                     }
                 }
            }
            L=1;R=N;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null || !st.hasMoreElements()){
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