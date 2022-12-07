class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (long idx = left; idx <= right; idx++){
            int quotient = (int) (idx/n);
            int remainder = (int) (idx%n);
            answer[(int) (idx - left)] = Math.max(quotient,remainder) + 1;
        }
        return answer;
    }
}