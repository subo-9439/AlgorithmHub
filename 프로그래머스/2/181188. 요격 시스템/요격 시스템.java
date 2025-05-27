import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1] ); //오름차순
        int start = 0;
        for (int[] target : targets) {
            if(start <= target[0]) {
                answer++;
                start = target[1];
            }

        }
        return answer;
    }
}