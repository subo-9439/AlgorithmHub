import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    static int R,C,N;
    static char[][] map;
    static int[] height;
    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        map = new char[R][C];
        for (int r = 0; r < R; r++) map[r] = scan.nextLine().toCharArray();
        N = scan.nextInt();
        height = new int[N];
        for (int n = 0; n < N; n++) height[n] = R - scan.nextInt();
    }
    static void pro() {
        boolean isBroken = false;
        int row = 0,col =0;
        for (int n = 0; n < N; n++) {
            if (n%2 == 0) {//왼쪽공격
                for (int c = 0; c < C; c++) {
                    if (map[height[n]][c] == 'x'){
                        map[height[n]][c] = '.';
                        isBroken = true;
                        row = height[n];
                        col= c;
                        break;
                    }
                }
            }else {     //오른쪽 공격
                for (int c = C-1; c>=0; c--) {
                    if (map[height[n]][c] == 'x') {
                        map[height[n]][c] = '.';
                        isBroken = true;
                        row = height[n];
                        col= c;
//                        System.out.println("여기는 다른거"+ row +" |" + col);
//                        System.out.println(isBroken);
                        break;
                    }
                }
            }
            if (isBroken) {
                separateMineral(row,col);
            }
        }
        printAnswer();
    }

    private static void printAnswer() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }

    static void separateMineral(int brokenRow, int brokenCol) {
//        System.out.println("brokenRow = " + brokenRow + " brokenCol = " + brokenCol);
        for (int k = 0; k < 4; k++) {
            int nRow = brokenRow + dir[k][0];
            int nCol = brokenCol + dir[k][1];

            if (nRow < 0 || nCol <0 || nRow >= R || nCol >= C) continue;
            if (map[nRow][nCol] == '.') continue;
//            System.out.println("nRow = " + nRow +" nCol = " + nCol);
            doSeparate(nRow, nCol);
        }
    }
    static void doSeparate(int row, int col) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        boolean isChanged = true;
        queue.add(row);//x
        queue.add(col);//y
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == '.') continue;
                if (nx == R-1) {
                    isChanged = false;
                }
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }

        if (isChanged) {
//            System.out.println("row = "+ row + "col = " + col);
            changeCluster(row,col,visited);
        }
    }

    static void changeCluster(int row ,int col, boolean[][] visited) {
        boolean[] visitedCol = new boolean[C];
        int min = 100;
        for (int r = R-1; r >= 0; r--){
            for (int c = 0; c < C; c++) {
                if (!visited[r][c] || map[r][c] == '.') continue;
                if (visitedCol[c]) continue;
                visitedCol[c] = true;
                min = Math.min(countRow(r, c),min);
//                System.out.println("r = "+r+"| c = "+c +min);
            }
        }
        for (int r = R-1; r >= 0; r--) {
            for (int c = 0; c < C; c++) {
                if (visited[r][c]) {
                    map[r+min][c] = map[r][c];
                    map[r][c] = '.';
                }
            }
        }
    }
    static int countRow(int r, int c) {
        for (int row = r+1; row <= R; row++) {
            if (row == R || map[row][c] == 'x') {
                return row - r - 1;
            }
        }
        return R-r-1;
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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
        String nextLine() {
            String str ="";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}