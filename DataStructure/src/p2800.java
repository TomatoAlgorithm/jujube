import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2800 {
    static Map<Integer, Integer> bracket = new HashMap<>(); // 괄호 index 집합
    static Set<String> answer = new TreeSet<>(); // return 할 값
    public static void nonBracket(int index, String str, List<Integer> keySet) {
        if (index == bracket.size()) {
            answer.add(str.replaceAll(" ",""));
            return;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(keySet.get(index), ' ');
        sb.setCharAt(bracket.get(keySet.get(index)), ' ');
        nonBracket(index + 1, sb.toString(), keySet);
        nonBracket(index + 1, str, keySet);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        Stack<Integer> stack = new Stack<>(); // 괄호 체크를 위한 스택
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(') {
                stack.push(i);
                bracket.put(i, 0); // 시작 인덱스 저장
            } else if (command.charAt(i) == ')') {
                bracket.put(stack.pop(), i); // 끝 인덱스 저장
            }
        }
        // map 에 괄호 순서대로 정렬
        List<Integer> keySet = new ArrayList<>(bracket.keySet());
        Collections.sort(keySet);

        nonBracket(0, command, keySet);
        answer.remove(command);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
/**
 * 스택에 시작하는 괄호 인덱스 넣고,
 * 나머지 괄호 나오면 pop 해서 map 에 넣어줌 => 괄호 위치 파악
 * 재귀를 안 쓰려고 했는데 그러면 풀 수 없다는걸 알게 됨
 * 결국 재귀를 썼다.
 */