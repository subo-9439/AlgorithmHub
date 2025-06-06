import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "push":
          stack.push(Integer.parseInt(st.nextToken()));
          break;

        case "pop":
          sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
          break;

        case "size":
          sb.append(stack.size()).append("\n");
          break;

        case "empty":
          sb.append(stack.isEmpty() ? 1 : 0).append("\n");
          break;

        case "top":
          sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
          break;
      }
    }

    System.out.print(sb);
  }
}
