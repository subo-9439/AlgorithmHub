class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        //반지름이 d인 원 안에 점이 1사분면위에 몇개가 가능할까
        for (int x = 0; x <= d; x+=k){
            long xx = (long) Math.pow(x,2);
            long dd = (long) Math.pow(d,2);
            long yy = dd-xx;
            long y = (long) Math.sqrt(yy);
            answer+= y/k + 1;
        }
        return answer;
    }
}