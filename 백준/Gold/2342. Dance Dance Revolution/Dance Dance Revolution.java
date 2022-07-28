import java.io.*;
import java.util.Arrays;

public class Main {

	static int[] nums;
	static int[][][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1 2 2 4 0  //8
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dp = new int[nums.length-1][5][5];//[스테이지][왼쪽 발 5개의 이동할 위치][오른쪽 발 5개의 이동할 위치]
		System.out.println(dfs(0, 0, 0));


	}

	public static int dfs(int stage, int left, int right){
		if (stage == dp.length) return 0; //종료
		if (dp[stage][left][right] != 0) return dp[stage][left][right]; //값이 있다면 그 값을 리턴

		int moveFromLeft = dfs(stage+1, nums[stage],right) + move(left, nums[stage]);// 왼쪽발위치에서 nums[stage]로 이동
		int moveFromRight = dfs(stage+1, left, nums[stage]) + move(right,nums[stage]);// 오른쪽발위치에서 nums[stage]로 이동
		dp[stage][left][right] = Math.min(moveFromLeft,moveFromRight);
		return dp[stage][left][right];

	}
	public static int move(int from, int to){
		if (from == 0) return 2;					//중앙에서 다른지점 -> 2
		else if (Math.abs(from-to) == 2) return 4;		//반대방향 -> 4
		else if (from == to) return 1; 			//같은지점 -> 1
		else return 3;						//인접한지점 -> 3

//		else if (Math.abs(from-to) == 1) return 3; 		//이렇게는 안된다 인접한지점이라고 1차이가 나는게 아니기 때문이다.
//		else return 3;									// 바보짓했네 ㅠ
	}

}