import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    public static void main(String[] args) {
        int n = scan.nextInt();
        Mdata[] arr = new Mdata[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Mdata(scan.nextInt(), i);
        }
        Arrays.sort(arr);
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i].index - i > max) max = arr[i].index - i;
        }
        System.out.println(max+1);
    }
    private static class Mdata implements Comparable<Mdata> {
        int value;
        int index;
        public Mdata(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Mdata o) {
            return this.value - o.value;
        }
    }

    private static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreTokens()) {
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine() {
            String str = "";
            try{
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
