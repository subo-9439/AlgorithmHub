import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        ArrayList<Integer> list =
                Arrays.stream(rocks).boxed().collect(Collectors.toCollection(ArrayList::new));
        list.add(0,0);
        list.add(distance);
        int L = 1, R = 100000000;
        while (L <= R){
            int mid = (L+R)/2;
            if(isTrue(mid, list, list.size() - n -1)){
                answer = mid;
                L = mid + 1;
            }else {
                R = mid -1;
            }
        }
        return answer;
    }
    public boolean isTrue(int mid,ArrayList<Integer> list,int n){
        int min = Integer.MAX_VALUE;
        int temp = list.get(0);
        int cnt = 0;
        for (int i = 1; i < list.size(); i++){
            if(list.get(i) - temp  < mid) continue;
            temp = list.get(i);
            cnt++;
        }
        return cnt >= n;
    }
}