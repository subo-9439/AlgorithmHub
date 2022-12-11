import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        double sum = 0;
        if (k >= enemy.length) return enemy.length;
        for (int i = 0; i < k; i++){
            pq.add(enemy[i]);
        }
        boolean flag = true;
        for (int i = k; i < enemy.length; i++) {
            answer = i;
            if (!pq.isEmpty() && enemy[i] > pq.peek()) {
                if (n-pq.peek() < 0 ){
                    flag = false;
                    break;
                }else {
                    n -= pq.poll();
                    pq.add(enemy[i]);
                }
            } else {
                if (n - enemy[i] < 0) {
                    flag = false;
                    break;
                }else {
                    n -= enemy[i];
                }
            }
        }
        answer = flag ? answer+1: answer;
        return answer;
    }
}