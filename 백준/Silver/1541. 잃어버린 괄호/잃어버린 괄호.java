import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static FastReader scan = new FastReader();
    public static void main(String[] args) {
        String s = scan.nextLine();
        int[] nums = Arrays.stream(s.split("[+-]")).mapToInt(Integer::parseInt).toArray();
        String[] operators = Arrays.stream(s.replaceAll("[0-9]", "").split("")).toArray(String[]::new);
        int ans = nums[0];
        boolean minusFlag = false;
        for (int i = 1; i < nums.length; i++) {
            if (operators[i-1].equals("-")){
                minusFlag = true;
            }
            if (minusFlag){
                ans -= nums[i];
            }else {
                ans += nums[i];
            }
 
        }
        System.out.println(ans);

    }


    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st==null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str = "";
            try {
                str  = br.readLine();
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