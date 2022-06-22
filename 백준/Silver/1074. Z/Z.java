//import com.codestates.coplit.Solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int size, cnt = 0;
    static void pro(){
        int N = scan.nextInt();
        int r = scan.nextInt();//행
        int c = scan.nextInt();//열
        size = (int) Math.pow(2,N);
        find(size, r, c);
        System.out.println(cnt);
    }
    static void find(int size,int row, int col){
        if(size == 1)
            return;

        if(row < size/2 && col < size/2) {
            find(size/2, row, col);
        }
        else if(row < size/2 && col >= size/2) {
            cnt += size * size / 4;
            find(size/2, row, col - size/2);
        }
        else if(row >= size/2 && col < size/2) {
            cnt += (size * size / 4) * 2;
            find(size/2, row - size/2, col);
        }
        else {
            cnt += (size * size / 4) * 3;
            find(size/2, row - size/2, col - size/2);
        }
    }
    public static void main(String[] args) {
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