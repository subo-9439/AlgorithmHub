class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long a = w;
        long b = h;
        answer = a*b - (a + b - euclid(a,b));
        return answer;
    }

    public long euclid(long a, long b){
        if(a%b == 0) return b;
        return euclid(b,a%b);
    }

}