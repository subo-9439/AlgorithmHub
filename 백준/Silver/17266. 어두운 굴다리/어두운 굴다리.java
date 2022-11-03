import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[] streetLight;
    static void input() {
        N = scan.nextInt();
        int cnt = scan.nextInt();
        streetLight = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            streetLight[i] = scan.nextInt();
        }
    }
    static void pro() {
        int L = 1, R = 100000;
        int ans = 0;
        while (L<=R) {
            int mid = (L+R)/2;
            if (canLight(mid)){
                R = mid -1;
                ans = mid;
            }else {
                L = mid+1;
            }
        }
        System.out.println(ans);
    }
    static boolean canLight(int height) {
        for (int i = 0; i < streetLight.length; i++){
            if (i == 0) {
                if (streetLight[i] - height > 0) return false;
            }
            if (i == streetLight.length-1) {
                if (N - streetLight[i] > height) return false;
            }
            else if (streetLight[i] + height < streetLight[i+1] - height) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
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