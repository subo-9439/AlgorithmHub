class Solution {
    public long solution(long n) {
        long answer = 0;

        String str = Long.toString(n);
        int strLen = str.length();
        int[] arr = new int[10];
        
        for(int i = 0; i < strLen; i++) {
            arr[str.charAt(i)-'0']++;                 
        }
        String answerStr = "";
        for(int i = 9; i >= 0; i--){
            while(--arr[i] >= 0){
                answerStr += i;
            }
        }
        answer = Long.valueOf(answerStr);
        return answer;
    }
}