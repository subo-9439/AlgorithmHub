import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//풀이실패 답지확인
public class Main {
    static ArrayList<ArrayList<Pair>> strings; // 각 인덱스에서 지울 수 있는 부분 문자열
    static int[] dp;
    static class  Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        
    }
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        String S = scan.next();
        dp = new int[S.length()+1];
        strings = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            strings.add(new ArrayList<>());
        }

        //부분 문자열을 하나씩 확인하며
        int M = scan.nextInt();
        for (int i = 0; i < M; i++) {
            //부분 문자열 입력받기
            String subStr = scan.next();
            int score = scan.nextInt();
            if (subStr.length() >= score) continue;//길이당 1점인데 점수가 그것보다 낮으면 최대점수가 될 수 없음.

            int index = 0; //각 인덱스의 위치에서 삭제가 가능한지 확인
            while (index < S.length()) {
                int pos = S.indexOf(subStr, index); //가장 가까운 매칭 위치 찾기
                if (pos == -1) break;
                // 문자열이 매칭되었다면 그 위치에 (문자열 길이, 점수) 기록
                strings.get(pos).add(new Pair(subStr.length(), score));
                index = pos + 1;
            }
        }
        
        // 다이나믹 프로그래밍 수행
        for (int i = 0; i < S.length(); i++) { //각 인덱스마다
            dp[i+1] = Math.max(dp[i+1], dp[i]+1);   //한문자 지우는경우와 비교
            for (int j = 0; j < strings.get(i).size(); j++) {// 지울 수 있는 부분 문자열들 확인
                int length = strings.get(i).get(j).first; // 부분 문자열의 길ㅇ
                int score = strings.get(i).get(j).second; // 점수
                dp[i + length] = Math.max(dp[i + length], dp[i] + score);
            }
        }
        System.out.println(dp[S.length()]);
    }   
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader (){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
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