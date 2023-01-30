import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static int N,M,J;

    public static void main(String[] args) {
        N = scan.nextInt();//스크린길이
        M = scan.nextInt();//바구니크기
        J = scan.nextInt();//사과위치
        int left = 1;   //바구니왼쪽 시작점
        int right = M; // 바구니 크기만큼
        //|__|
        int moveDist = 0;

        for (int i = 0 ; i < J; i++) {
            int applePos = scan.nextInt();
            if (left <= applePos && applePos <= right) {
                continue;
            }else if(applePos > right) { // 오른쪽 바깥
                int curDist = applePos - right;
                moveDist += curDist;
                right += curDist;
                left += curDist;
            }else {//왼쪽 바깥
                int curDist = left - applePos;
                moveDist += curDist;
                left -= curDist;
                right -= curDist;
            }
        }
        System.out.println(moveDist);

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }


        String next(){
            while (st==null||!st.hasMoreTokens()){
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