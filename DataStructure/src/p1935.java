import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1935 {
    public static double cal(double a, double b, Character s) {
        switch (s) {
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '/':
                return a / b;
            case '-':
                return a - b;
        }
        return 0.0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String expression = br.readLine();
        Map<Character, Double> num = new HashMap<>();
        char al = 'A';
        for (int i = 0; i < N; i++) {
            Double temp = Double.parseDouble(br.readLine());
            num.put(al, temp);
            al++;
        }
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if ('A' <= expression.charAt(i) && expression.charAt(i) <= 'Z') {
                stack.push(num.get(expression.charAt(i)));
            } else {
                if (!stack.isEmpty()) {
                    double temp1 = stack.pop();
                    double temp2 = stack.pop();
                    stack.push(cal(temp2, temp1, expression.charAt(i)));
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
/**
 * 스택을 써야할 것 같은 느낌이 왔다.
 * 스택 2개를 놓고, 하나에서 pop 한걸 다른 스택에 push
 * 두 스택 전부 peek() 상황애서 정수면 그 때 계산
 * => 하려다가 15퍼에서 자꾸 멈춤
 * 스택 1개로 줄이니까 됨 ㅂㄷㅂㄷ
 */
