class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] map = new int[(n + w - 1)/w][w];
        
        int val = 0;
        int xIdx = 0, yIdx = 0;
        boolean flag = false;

        for (int i = 0; i < map.length; i++){
            for(int j = 0; j < w; j++) {
                val++;
                
                if(i % 2 == 0){
                    map[i][j] = val;                    
                }else {
                    map[i][w-j-1] = val; 
                }
                if(val == num){
                    xIdx = i;
                    yIdx = (i % 2 == 0) ? j : (w - j - 1);
                    
                }
                if(val == n) {
                    flag = true; 
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        if(map[map.length-1][yIdx] == 0) answer = map.length - xIdx-1;
        else answer = map.length - xIdx;
        return answer;
    }
}