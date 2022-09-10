import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> realQueue1 = new LinkedList<>();
        Queue<Integer> realQueue2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0, goal = 0;
        int cnt = 0,len =queue1.length*3;
        int idx = 0;
        for (int i = 0; i < queue1.length; i++){
            realQueue1.add(queue1[i]);
            realQueue2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        goal = sum2+sum1;

        while (idx < len) {
            if (sum1 > goal / 2) {
                int temp = realQueue1.poll();
                realQueue2.add(temp);
                sum1 -= temp;
                sum2 += temp;
                cnt++;
                idx++;
            }

            if (sum2 > goal / 2) {
                int temp = realQueue2.poll();
                realQueue1.add(temp);
                sum1 += temp;
                sum2 -= temp;
                cnt++;
                idx++;
            }
            if (sum1 == sum2) {
                return cnt;
            }

        }

        return  -1;

    }
}