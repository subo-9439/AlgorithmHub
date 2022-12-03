import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 배열의 크기가 두배인 배열을 준비한다.
* 그리고 순환이 될 수 있도록 값을 넣어준다.
* set에 값을 더한 값들을 넣어주면 끝
* */
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] newElements = new int[elements.length * 2];

        for (int i = 0 ; i < elements.length; i++) {
            newElements[i] = newElements[i + elements.length]  = elements[i];
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(newElements, j , j+i).sum());
            }
        }
        return set.size();
    }

}