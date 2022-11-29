import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> set1 = new HashSet<>();
        HashMap<Integer,Integer> set2 = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            set2.put(topping[i],set2.getOrDefault(topping[i],0)+1);
        }
        int cnt = 0;
        for (Integer key: set2.keySet()){
            cnt ++;
        }
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