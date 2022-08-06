import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static char[][] map = new char[5][9];
    static boolean[] visited = new boolean[13];

    static ArrayList<Node> list = new ArrayList<Node>();
    static int[][][] p = {
            {{0,4},{1,3},{2,2},{3,1}},
            {{3,1},{3,3},{3,5},{3,7}},
            {{0,4},{1,5},{2,6},{3,7}},
            {{1,1},{1,3},{1,5},{1,7}},
            {{1,1},{2,2},{3,3},{4,4}},
            {{4,4},{3,5},{2,6},{1,7}}
    };
    static int size;
    static boolean ok;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++){
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++){
                map[i][j] = temp[j];
                if (temp[j] == 'x'){
                    list.add(new Node(i,j));
                }else if (temp[j]!='.'){
                    visited[temp[j] -'@'] = true;
                }
            }
        }
        size = list.size();
        dfs(0,0);
    }
    static void dfs(int cnt, int idx) {
        if (ok) return;
        
        if(cnt == size && check()){
            ok = true;
            for (int i =0 ; i < 5; i++){
                System.out.println(map[i]);
            }
            return;
        }
        for (int j = 1; j <= 12; j++){
            if (visited[j]) continue;
            Node cur = list.get(idx);
            visited[j] = true;
            map[cur.x][cur.y] = (char)(j+64);
            dfs(cnt+1,idx+1);
            visited[j] = false;
            map[cur.x][cur.y] = 'x';
        }
    }
        
        
    static boolean check() {
        for (int a = 0; a < 6; a++) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += (map[p[a][i][0]][p[a][i][1]] -'A'+1);
            }
            if(sum != 26) return false;
        }
        return true;
    }
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
}