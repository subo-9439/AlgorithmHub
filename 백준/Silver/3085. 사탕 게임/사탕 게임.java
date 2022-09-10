import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int N, max;
    static char[][] map;

    static void input(){

        N = scan.nextInt();
        map = new char[N][N];
        for (int i = 0; i < N; i++){
            map[i] = scan.nextLine().toCharArray();
        }
        for (int i = 0; i < N; i++){
            max = Math.max(max, changeCol(i));
            max = Math.max(max, changeRow(i));
        }
    }
    static void pro(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (j < N-1){
                    swap(i,j,i,j+1);//오른쪽
                    max = Math.max(max, changeCol(i));//col을 바꿨으므로 해당 row는 한번만  체크
                    max = Math.max(max, changeRow(j));//얘넨 두번
                    max = Math.max(max, changeRow(j+1));
                    swap(i,j,i,j+1);//원래대로
                }
                if (i < N-1){
                    swap(i,j,i+1,j);
                    max = Math.max(max, changeCol(i));
                    max = Math.max(max, changeCol(i+1));
                    max = Math.max(max, changeRow(j));
                    swap(i,j,i+1,j);
                }

            }
        }
        System.out.println(max);
    }
    static int changeCol(int x){
        int tmp = 1, res = 1;
        char ch = map[x][0];
        for(int i = 1; i < N; i++) {
            if(map[x][i] != ch) {
                ch = map[x][i];
                res = Math.max(res, tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(res,  tmp);
    }
    static int changeRow(int y){
        int tmp = 1, res = 1;
        char ch = map[0][y];
        for(int i = 1; i < N; i++) {
            if(map[i][y] != ch) {
                ch = map[i][y];
                res = Math.max(res, tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(res, tmp);
    }

    static void swap(int x1, int y1, int x2, int y2){
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
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
        String nextLine(){
            String str = "";
            try {
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