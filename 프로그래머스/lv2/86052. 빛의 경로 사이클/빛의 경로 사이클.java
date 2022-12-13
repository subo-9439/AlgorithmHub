import java.util.ArrayList;
//못품
//현재 좌표(r,c) 방향(d)을 통해
//다음 방향(d), 다음 좌표 구해주기
// 4방향 방문 체크를 통해 사이클
class Solution {
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}}; //아래 , 왼 ,위 , 오른
    int row, col;
    boolean[][][] isVisited;
    public int[] solution(String[] grid) {
        ArrayList<Integer> temp = new ArrayList<>();
        //각 그리드에 네방향 체크가 필요하다
        row = grid.length;
        col = grid[0].length();
        isVisited = new boolean[row][col][4]; //4방향 체크

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[r][c][d])
                        temp.add(move(grid, r, c, d));
                }
            }
        }
        return temp.stream().sorted().mapToInt(i->i).toArray();
    }

    private int move(String[] grid, int r, int c, int d) {
        int cnt = 0; // 이동거리
        while (true) {
            if (isVisited[r][c][d])
                break;

            cnt++;	// 거리증가
            isVisited[r][c][d] = true; // 방문처리
            if (grid[r].charAt(c) == 'L')
                d = (d+3)%4;
            if (grid[r].charAt(c) == 'R')
                d = (d+1)%4;

            r = (r + dir[d][0] + row) % row; //넘어가지 않게
            c = (c + dir[d][1] + col) % col;
        }
        //전부 방문한 곳 도착할 때 return
        return cnt;
    }
 
}