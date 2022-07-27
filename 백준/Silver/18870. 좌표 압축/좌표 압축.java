import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static int[] arr;
    static void input(){
        N = scan.nextInt();
        arr = new int[N];

        for (int i = 0 ; i < N; i++){
            arr[i] = scan.nextInt();
        }

    }
    static void pro(){
        Map<Integer,Integer> map = new HashMap();
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int cnt = 0;
        for (int i = 0; i< temp.length; i++){
            if (map.containsKey(temp[i])){
                cnt--;
            }
            map.put(temp[i],cnt++); // 해당값은 i번째다
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
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
            while (st == null || !st.hasMoreTokens()){
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