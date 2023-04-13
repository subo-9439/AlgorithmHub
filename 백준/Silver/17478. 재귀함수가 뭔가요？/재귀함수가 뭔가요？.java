import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static void input(){
        N = scan.nextInt();
    }
    static void pro(){
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(0);
        System.out.println(sb);
    }
    static void recursion(int n){
        sb.append("\n").append("____".repeat(n)).append("\"재귀함수가 뭔가요?\"\n");
        if(n!=N) {
            sb.append("____".repeat(n)).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
                    .append("____".repeat(n)).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
                    .append("____".repeat(n)).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        }else {
            sb.append("____".repeat(n)).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            sb.append("____".repeat(n)).append("라고 답변하였지.\n");
            return;
        }
        recursion(n+1);
        sb.append("____".repeat(n)).append("라고 답변하였지.\n");
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
            while (st==null || !st.hasMoreTokens()){
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