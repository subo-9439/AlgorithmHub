import java.util.ArrayList;
import java.util.Collections;
//못품 ㅠ
class Solution {
    char[] alphabet = {'A','E','I','O','U'};
    ArrayList<String> list = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;
        permutation(0,"");
        Collections.sort(list);

        return list.indexOf(word) +1;
    }

    public void permutation(int idx, String str) {
        if (idx >= 5) return;
        for (int i = 0; i < alphabet.length; i++){
            list.add(str+alphabet[i]);
            permutation(idx+1,str+alphabet[i]);
        }
    }
}