import java.util.*;

class Solution {
    static PriorityQueue<Server> pq = new PriorityQueue<>();// 증설된서버
    static PriorityQueue<Server> tempPq = new PriorityQueue<>();// 증설된서버
    
 
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 서버 증설횟수
        for (int i = 0; i < players.length; i++) {
            int requiredSeverCount = players[i]/m;
            if(pq.isEmpty()) { // 증설된서버가 없을경우
                answer += addSever(requiredSeverCount, i,  k);
            }
          
            while(requiredSeverCount > 0) {   
                if(!pq.isEmpty()) {
                    Server server = pq.poll(); 
                    if(server.canUseAtTime(i)) {
                        requiredSeverCount--;
                        tempPq.offer(server);

                    }
                } else {
                  
                    answer += addSever(requiredSeverCount, i, k);
                    requiredSeverCount = 0;
                }
            }
            while(!tempPq.isEmpty()) {
                pq.offer(tempPq.poll());
            }
        }
        return answer;
    }
               
    public int addSever(int requiredServerCount, int time, int k) {
        int count = 0;
        for(int i = 0; i < requiredServerCount; i++) {
            Server server = new Server(time, time + k);
            pq.offer(server);
            count++;
        }
        return count;
    }
               
               
               
    class Server implements Comparable<Server> {
        private int startTime;
        private int endTime;

        public Server(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return this.startTime;
        }
        
        public boolean canUseAtTime(int time) {
            if(time >= this.endTime) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(Server other) {
            return Integer.compare(this.startTime, other.startTime);
        }
        public String toString() {
            return "starTime" + startTime +" endTime" + endTime+ "     ";
        }
    }
}