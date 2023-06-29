import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9012 {
    public static boolean isVPS(String str) {
        Stack<String> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') stack.add("(");
            else {
                if (stack.empty()) return false;
                else stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (isVPS(str)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
/**
 * List 로 하면 시간초과 나서 Stack 으로 구현
 */