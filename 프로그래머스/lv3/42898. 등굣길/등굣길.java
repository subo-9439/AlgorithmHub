import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] map = new long[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        if(puddles[0].length > 0) {
            for(int[] puddle : puddles) {
                visited[puddle[1]][puddle[0]] = true;
            }    
        }
        for(int i = 1; i <= n; i++) {
            if(visited[i][1]) break;
            map[i][1] = 1;    
        }
        for(int i = 1; i <= m; i++) {
            if(visited[1][i]) break;
            map[1][i] = 1;
        }
        

        
        
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= m; j++) {
                if(visited[i][j]) continue;
                map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007 ;
                if (map[i][j] > 1000000007) {
                    map[i][j] %= 1000000007;
                }
            }
        }
 
        return (int)map[n][m];
    }
}

        
//         int[][] map = new int[m][n];
        
//         for (int i=0;i<m;i++) {
//             map[i][0]=1;
//         }
        
//         for (int i=0;i<n;i++) {
//             map[0][i]=1;
//         }
        
//         for (int[] arr: puddles) {
//             // arr은 (2,2)
//             map[arr[0]-1][arr[1]-1]=0;
            
//         }
        
//         for (int i=0;i<m;i++) {
//             for (int j=0;j<n;j++) {
//                 if (map[i][j]!=null) {
//                     map[i][j]=map[i-1][j]+map[i][j-1];
//                 }
                
//             }
//         }