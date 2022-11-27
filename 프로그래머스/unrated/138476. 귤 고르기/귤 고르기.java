import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int tg: tangerine) {
            map.put(tg, map.getOrDefault(tg,0)+1);
        }
        List<Map.Entry<Integer, Integer>> entryList =new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));

        for (Map.Entry<Integer,Integer> entry : entryList) {
            answer++;
            k -= entry.getValue();
            if (k<=0) break;
        }
        return answer;
    }
}