import java.util.*;

class Solution {
    static int[] arr = new int[200001];
    public int solution(int[][] scores) {
        Score whanHo = new Score(scores[0]);
        // 총점 기준 내림차순으로 인원수 계산
        Queue<Score> que = new LinkedList<>();
        
        for (int i = 1; i < scores.length; i++) {
            que.add(new Score(scores[i]));
        }
        int answer = 0;
        int rank = 1;
        int curCnt = 0;
        //인센티브 받는 사원들분포도 카운트하기
        while(!que.isEmpty()) {
            Score other = que.poll();
            if(other.canReceive()) arr[other.getTotal()]++;
        }

        for (int i = 200000; i >= 0; i--) {
            if(i == whanHo.getTotal()) {
                break;
            }
            curCnt += arr[i];
        }
        
        rank += curCnt;
        if(!whanHo.canReceive()) return -1;
        return rank;
 
    }
    
    public static class Score implements<Score>{
        int a;
        int b;
        static int maxA;
        static int maxB;        
        
        Score (int[] arr) {
            this.a = arr[0];
            this.b = arr[1];
            if(a > maxA) { // 사원들의 a,b가장큰점수 기록
                maxA = a;
            }
            if(b > maxB) {
                maxB = b;
            }
        }
        
        //둘다 작으면 못받음. 하나라도 크면 받음
        //하나라도 같거나 크면 받을 수 잇음.
        boolean canReceive() {
            return maxA <= this.a || maxB <= this.b;
        }
        
        int getTotal() {
            return this.a + this.b;
        }
        
        private int getDiff() {
            return Math.abs(this.a - this.b);
        }
        
        @Override
        public int comapreTo(Score other) {
            if(other.getTotal() == this.getTotal()) this.getDiff() - other.getDiff();
            return other.getTotal() - this.getTotal();
        }
    
    }
}
