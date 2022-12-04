import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantBaskets = new HashMap<>();
        for (int i = 0; i < want.length; i++ ) {
            wantBaskets.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length-10; i++) {
            HashMap<String, Integer> discountBaskets = new HashMap<>();
            boolean flag = true;
            for (int j = i; j < i + 10; j++) {
                discountBaskets.put(discount[j], discountBaskets.getOrDefault(discount[j],0) + 1);
            }

            for (String wantItem : wantBaskets.keySet()) {
                if (!discountBaskets.containsKey(wantItem)){
                    flag = false;
                    break;
                }
                if (!discountBaskets.get(wantItem).equals(wantBaskets.get(wantItem))) {
                    flag = false;
                    break;
                }

            }

            if (flag){
                answer++;
            }

        }

        return answer;
    }

}