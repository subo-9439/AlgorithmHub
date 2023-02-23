import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


class Info {
    int team;
    String goalTime;
    int temp= 0;
    Info(int team, String goalTime){
        this.team = team;
        this.goalTime = goalTime;
    }

    public int calculateWinningTime() {
        String[] sp = goalTime.split(":");
        int time = Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
        return time;
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static int N;
    static Queue<Info> infos = new LinkedList<>();

    public static void main(String[] args) {
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int teamNum = scan.nextInt();
            String goalTime = scan.next();
            infos.add(new Info(teamNum, goalTime));
        }
        int beforeTime = 0;
        int curWinningTeam = 0;
        int teamA = 0,totalA = 0;
        int teamB = 0,totalB = 0;
        while (!infos.isEmpty()) {
            Info info = infos.poll();
            int team = info.team;
            int goalTime = info.calculateWinningTime();
            if (curWinningTeam == 0) {
                if (team==1) {
                    teamA++;
                    curWinningTeam = 1;
                }
                else {
                    teamB++;
                    curWinningTeam = 2;
                }
                beforeTime = goalTime;
                continue;
            }
            //1 1:10
            //2 21:10
            if (team == 1){
                teamA++;
            }else {
                teamB++;
            }
            if (teamA==teamB){
                if (curWinningTeam==1) {
                    curWinningTeam=0;
                    totalA += goalTime- beforeTime;
                } else if (curWinningTeam==2) {
                    curWinningTeam=0;
                    totalB += goalTime-beforeTime;
                }
            }

        }
        if (curWinningTeam == 1){
            totalA+= 48*60 - beforeTime;
        } else if (curWinningTeam == 2) {
            totalB+= 48*60 - beforeTime;
        }
        System.out.printf(String.format("%02d:%02d%n",totalA/60,totalA%60));
        System.out.printf(String.format("%02d:%02d%n",totalB/60,totalB%60));
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}