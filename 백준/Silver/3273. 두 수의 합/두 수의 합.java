import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int n, x;
    static int[] arr;
    static void input(){
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        x = scan.nextInt();
    }
    static void pro(){
        Arrays.sort(arr);
        int cnt = 0;
        int R = arr.length-1;
        for (int L = 0; L < R; L++){
            while (R >= 0){
                int sum = arr[L] + arr[R];
                if(sum == x)  cnt++;
                else if(sum < x) break;
                R--;
            }
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

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null ||!st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}