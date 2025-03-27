import java.util.*;

class Solution {
    static ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
    // static boolean isVisited[];
    static int[] nums = new int[5];
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        dfs(0, 1, n);
        
        for(HashSet<Integer> set : list) {
            boolean flag = true;

            for (int i = 0; i < q.length; i++) {
                if(!flag) break;
                int ansCnt = ans[i];
                for (int j = 0; j < q[i].length; j++) {
                    if(!flag) break;
                    if(set.contains(q[i][j])){
                        ansCnt--;
                    }
                }
                

                if(ansCnt != 0) {
                    flag = false;
                    break;
                }
                  
            }
            if(flag) {
                answer++;
            }
            
        }
        return answer;
    }
    
    static void dfs(int ansIdx, int idx, int lastNum) {
        if(ansIdx == 5) {
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < 5; i++){
                set.add(nums[i]);
            }
            list.add(set);
            return;
        }
        for (int i = idx; i <= lastNum; i++) {
            nums[ansIdx] = i;
            dfs(ansIdx + 1, i+1, lastNum);
            nums[ansIdx] = 0;
        }
    }
}