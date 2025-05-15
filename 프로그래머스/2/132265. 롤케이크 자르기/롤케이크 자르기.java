import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> set1 = new HashSet<>();
        HashMap<Integer,Integer> set2 = new HashMap<>();
        // 각 토핑의 수를 세기
        for (int i = 0; i < topping.length; i++) {
            set2.put(topping[i],set2.getOrDefault(topping[i],0)+1);
        }
        
        //오른쪽 조각 토핑개수세기
        int cnt = set2.size();
        for (int i = 0; i < topping.length; i++) {
            set1.add(topping[i]);
            if (set2.get(topping[i]) !=0 ){
                if (set2.get(topping[i])-1 == 0) cnt--;
                
                set2.put(topping[i], set2.get(topping[i]) - 1);
            }
            
            if (set1.size() == cnt){
                answer++;
            }
        }
        return answer;
    }
}