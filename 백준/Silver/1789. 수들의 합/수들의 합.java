import java.io.IOException;
import java.util.Scanner;


public class Main{
	public static int Search_N(long S) { //객체 생성 없이 메소드 사용 가능!
		int N = 0; //서로 다른 N개의 자연수 개수. cnt. 
		long sum = 0L; //N의 합. N의 범위가 int 형 범위를 벗어나므로 long으로 선언.
		int i = 0; //최대 N의 개수를 구해야 하므로 제일 작은 1부터 시작.
		while(true) {
			sum += ++i;
			
			if (sum > S) {
				return N;
			}
			N++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long inp = sc.nextLong(); 
		//서로 다른 자연수 N개가 필요.
		//즉 최적의 판단은 가장 작은 수 부터 더해나가면 된다.
		System.out.println(Search_N(inp));
    }
}