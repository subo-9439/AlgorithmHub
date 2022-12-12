import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//못품 ㅠ
class Point {
    long x;
    long y;
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
    long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
    public String[] solution(int[][] line) {
        String[] answer = {};
        Set<Point> map = new HashSet<>();

        for (int i = 0; i < line.length-1; i++){
            long x1 = line[i][0], y1 = line[i][1], c1 = line[i][2];
            for (int j = i+1; j < line.length; j++){
                long x2 = line[j][0], y2 = line[j][1], c2 = line[j][2];
                long x1y2_x2y1 = x1*y2 - x2*y1;
                long y1c2_c1y2 = y1*c2 - c1*y2;
                long c1x2_x1c2 = c1*x2 - x1*c2;
                if (x1y2_x2y1 == 0) continue;//평행
                if ( y1c2_c1y2 % x1y2_x2y1 != 0) continue;  //x 정수아님
                if ( c1x2_x1c2 % x1y2_x2y1 != 0) continue; //y 정수아님
                long xNum = y1c2_c1y2/x1y2_x2y1;
                long yNum = c1x2_x1c2/x1y2_x2y1;
                map.add(new Point(xNum, yNum));
                minX = Math.min(minX, xNum);
                minY = Math.min(minY, yNum);
                maxX = Math.max(maxX, xNum);
                maxY = Math.max(maxY, yNum);

            }
        }
        long h = maxY - minY+1;
        long w = maxX - minX+1;
        answer = new String[(int)h];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < w; i++) {
            sb.append(".");
        }
        Arrays.fill(answer, sb.toString());
        long nx, ny;
        for(Point p: map){
            ny= maxY-p.y;
            nx= p.x-minX;
            answer[(int)ny]= answer[(int)ny].substring(0, (int)nx)+"*"+answer[(int)ny].substring((int)nx+1);
        }

        return answer;
    }
}