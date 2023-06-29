import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p10828 {
    public static void conductCommand(String command, List<Integer> stack) {
        String[] com = command.split(" ");

        if (com.length > 1) { // push 일 때
            stack.add(Integer.parseInt(com[1]));
        } else if (command.equals("pop")) {
            if (stack.size() == 0) System.out.println("-1"); // 아무것도 없으면 -1
            else { // 출력하고 없애버림
                System.out.println(stack.get(stack.size()-1));
                stack.remove(stack.size()-1);
            }
        } else if (command.equals("size")) {
            System.out.println(stack.size());
        } else if (command.equals("empty")) {
            int result = stack.size() == 0 ? 1 : 0;
            System.out.println(result);
        } else { // top
            if (stack.size() == 0) System.out.println("-1");
            else System.out.println(stack.get(stack.size()-1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            conductCommand(command, stack);
        }
    }
}