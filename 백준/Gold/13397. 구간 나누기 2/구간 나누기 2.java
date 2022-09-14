import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N,M;
    static int max_num,min_num;
    static int[] arr;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
            if (arr[i] > max_num) {
                max_num = arr[i];
            }
            if (arr[i] < min_num){
                min_num = arr[i];
            }
        }
    }

    static void pro(){
        //구간 나누기 구간은 M개가 나와야한다.
        int ans = Integer.MAX_VALUE;
        int L = min_num,R = max_num;
        while (L<=R){
            int mid = (L+R)/2;
            if (determinant(mid)){
                R = mid-1;
                ans = mid;        //a중에서 최솟값 찾기
            }else {
                L = mid+1;
            }
        }


        System.out.println(ans);
    }
    static boolean determinant(int diff){//a.각 구간별 정렬후 (최댓값 - 최솟값)의 최댓값 찾기
        int max = 0, min = 10000;
        int cnt = 0;
        for (int i = 0 ; i < N; i++){
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
            if (max-min <= diff) continue;
            max = arr[i];
            min = arr[i];
            cnt++;
            if (cnt >= M )return false;
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

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreTokens()){
                try {
                    st= new StringTokenizer(br.readLine());
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