import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] numSum = new int[sequence.length];
        numSum[0] = sequence[0];
        for(int i = 1; i < numSum.length; i++) {
            numSum[i] = numSum[i-1] + sequence[i];
        }
        if(numSum[0] == k) {
            answer[0] = 0;
            answer[1] = 0;
        }
        int L = -1, R = 0;
        ArrayList<Node> answerList = new ArrayList<>();
        while (true) {
            int sum = 0;
            if (L == -1) {
                sum = numSum[R];
            }else {
                sum = numSum[R] - numSum[L];
            }

            if (sum > k) {
                if (L < numSum.length-1){
                    L++;
                }else {
                    break;
                }
            }else if(sum < k) {
                if(R < numSum.length-1){
                    R++;
                }else {
                    break;
                }
            }else {
//                answer[0] = L+1;
//                answer[1] = R;
                answerList.add(new Node(L+1,R));
//                System.out.println("L = " + (L+1) + " R= " + R);
                if (R < numSum.length-1){
                    R++;
                }else {
                    L++;
                }
            }
        }
        Collections.sort(answerList);
        if (answerList.isEmpty()){
            return answer;
        }else {
            answer[0] = answerList.get(0).L;
            answer[1] = answerList.get(0).R;
        }
        return answer;
    }

    static class Node implements Comparable<Node>{
        int L;
        int R;

        Node(int L, int R){
            this.L = L;
            this.R = R;
        }
        int getDist(){
            return this.R - this.L;
        }
        @Override
        public int compareTo(Node o) {
            return this.getDist() - o.getDist();
        }
    }
}