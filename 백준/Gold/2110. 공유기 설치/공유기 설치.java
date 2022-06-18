import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, C;
    static int[] home;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        home = new int[N+1];

        for(int i = 1; i <= N; i++) {
            home[i] = scan.nextInt();
        }
    }

    static boolean determination(int D){
        //D 만큼의 거리 차이를 둔다면 C 개만큼의 공유기를 설치할 수 있는가?

        //제일 왼쪽 집부터 가능한 많이 설치해야한다.
        //D만큼의 거리를 두면서 최대한 설치한 개수와 c를 비교하자.

        //첫번째 집에 하나를 설치하니까 cnt = 1;
        int cnt = 1, last = home[1];

        //2번집부터 N번집까지 확인을한다.
        for (int i = 2; i <= N; i++) {
            //i번집과 그전 집의 차이가 D보다 작으면 설치를 할 수 없다.
            if(home[i] - last < D) continue;
            //설치했으므로 last를 갱신시켜주고 cnt++해준다.
            last = home[i];
            cnt++;
        }
        //C개 이상 설치했을 때만 돌려준다.
        return cnt >= C;
    }
    static void pro() {
        //determination을 빠르게 하기 위해서 정렬해야한다.
        Arrays.sort(home,1, N+1);

        int L = 1, R = 1000000000, ans = 0;
        //[L...R] 범위 안에 정답이 존재한다.
        //이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자

        while(L <= R) {
            int mid = (L+R)/2;
            if(determination(mid)){
                ans = mid;
                L = mid +1;
            } else {
                R = mid -1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}