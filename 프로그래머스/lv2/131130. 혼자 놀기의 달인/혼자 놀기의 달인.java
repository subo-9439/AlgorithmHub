import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] isVisited = new boolean[cards.length+1];
        ArrayList<Integer> ansList = new ArrayList<>();
        int idx = -1;
        
        while (true) {
            idx = -1;
            for (int i = 0; i < cards.length; i++) {
                if (!isVisited[i]) 
                    idx = i;
            }
            if (idx == -1) break;
            Set<Integer> group = new HashSet<>();
            while (true){
                isVisited[idx] = true;
                if (group.contains(cards[idx])) {
                    break;
                }
                else {
                    group.add(cards[idx]);
                    isVisited[cards[idx]] = true;
                    idx = cards[idx]-1;
                }
            }
            ansList.add(group.size());
        }
        int num1 = 0, num2 = 0;
        int num1_idx = 0;
        for (int i = 0; i < ansList.size(); i++){
            if (ansList.get(i) > num1){
                num1 = ansList.get(i);
                num1_idx = i;
            }
        }
        for (int i = 0; i < ansList.size(); i++) {
            if (ansList.get(i) >= num2 && num1_idx != i) {
                num2 = ansList.get(i);
            }
        }
        return num1*num2;
    }
}