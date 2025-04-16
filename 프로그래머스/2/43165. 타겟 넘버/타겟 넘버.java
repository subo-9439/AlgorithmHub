class Solution {
    static int[] arr;
    static int answer;
    public int solution(int[] numbers, int target) {
        arr = new int[numbers.length];
        makePermutation(0, numbers, target);
        return answer;
    }
    
    public void makePermutation(int idx, int[] numbers, int target){
        if (idx == numbers.length) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            if(sum == target) answer++;
            return ;
        }
        arr[idx] = numbers[idx];
        makePermutation(idx + 1, numbers, target);
        arr[idx] = -numbers[idx];
        makePermutation(idx + 1, numbers, target);
    }
}