import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> mainContainer = new LinkedList<>();
        Stack<Integer> subContainer = new Stack<>();
        for (int i = 1; i <= order.length; i++){
            mainContainer.add(i);
        }
        int idx = 0;
        boolean flag = true;
        while (flag) {

            if (!mainContainer.isEmpty() && mainContainer.peek() == order[idx]){
                mainContainer.poll();
                idx++;
            }else if(!subContainer.empty() && subContainer.peek() == order[idx]){
                idx++;
                subContainer.pop();
            }else {
                if (mainContainer.size()!=0){
                    subContainer.add(mainContainer.poll());
                }else {
                    break;
                }
            }

        }
        answer = idx;
        return answer;
    }
}