class Solution{
    public int solution(int[][] board, int[][] skill){
        int answer = 0;
        int[][] map = new int[1003][1003];
        for(int i = 0; i < skill.length; i++){
            int type = skill[i][0] == 1? -1: 1;
            int startX = skill[i][1];
            int startY = skill[i][2];
            int endX = skill[i][3];
            int endY = skill[i][4];
            int degree = type * skill[i][5];

            map[startX][startY] += degree;
            map[startX][endY+1] -= degree;
            map[endX+1][startY] -= degree;
            map[endX+1][endY+1] += degree;
        }
        for(int i = 1; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] += map[i-1][j];
            }
        }
        for(int i = 0; i < map.length; i++){
            for(int j = 1; j < map[0].length; j++){
                map[i][j] += map[i][j-1];
            }
        }
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] + map[i][j] >=1) answer++;
            }
        }
        return answer;
    }
}