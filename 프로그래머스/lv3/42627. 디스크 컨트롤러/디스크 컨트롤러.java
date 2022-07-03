import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int idx = 0;
        int now = 0;
        int count = 0;
        int total = 0;
        while (count < jobs.length){
            while (idx < jobs.length && jobs[idx][0] <= now){
                pq.add(new Process(jobs[idx][0],jobs[idx++][1]));
            }
            if (pq.isEmpty()){
                now++;//now = jobs[idx][0];
            }else {
                Process pro = pq.poll();
                total += pro.requiredTime +now - pro.waitTime;
                now += pro.requiredTime;
                count++;
            }

        }
        return answer = total/ jobs.length;
    }
    public class Process implements Comparable<Process>{
        int waitTime;
        int requiredTime;
        public Process(int waitTime, int requiredTime){
            this.waitTime = waitTime;
            this.requiredTime = requiredTime;
        }


        @Override
        public int compareTo(Process o) {
            return this.requiredTime - o.requiredTime;
        }
    }
}