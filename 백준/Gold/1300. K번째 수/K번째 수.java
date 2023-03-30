import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N,K;
    public static void main(String[] args) {
        //N^2배열에서 오름차순으로 정렬했을 때 K번째 수찾기
        //K번 째의 수, arr[K]는 항상 K보다 작거나 같다. 여기서부터 arr[K] = x라고 명칭하겠다.
        //즉 이진 탐색으로 x의 범위를 좁혀나가면서 찾아야 한다.
        //그러면 x의 범위를 어떻게 단정 지어야할까?

        // 1행의 수들은 항상 1 * 1,2,3,4
        // 2행의 수들은 항상 2 * 1,2,3,4다.
        // 만약 x가 5라고 가정하고, 5보다 같거나 작은 수를 찾으면 각 행을 나눈 갯수를 카운트하면 된다.
        //  N = 3인 배열에서 x = 5
        // 5/1 = 5, 그러나 1행의 최대 원소는 3개이므로 3
        // 5/2 = 2,
        // 5/3 = 1 N^2인 배열에서 x인 5같거나 작은 수는 총 8개가 된다.
        //즉 8은 K인 7보다 크므로 다시 이분탐색을 실시해야한다.
        //여기까지 이분탐색으로 수를 찾는 것이다.

        //여기서 더 나아가 x의 범위를 더 좁힐 수 있다.
        //arr[K]의 값인 x는 사실 K라는 수보다 무조건적으로 작거나 같을 수밖에 없다.
        N = scan.nextInt();
        K = scan.nextInt();

        long left = 1;
        long right = K;
        long ans = 0;
        while (left <= right) {
            long mid = (left+right)/2;
            int cnt = count(mid);
            if (cnt < K) {
                left = mid + 1;
            }else {
                ans = mid;
                right = mid-1;
            }
        }
        System.out.println(ans);

    }
    static int count(long x){
        int cnt = 0;
        for (int r = 1; r <= N; r++) {
            long mock = x/r;
            if (mock == 0) break;
            if (mock > N) {
                cnt += N;
            }else {
                cnt += mock;
            }
        }
        return cnt;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
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