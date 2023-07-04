import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class p10866 {
    public static void deque(String command, Deque<Integer> d) {
        String[] coms = command.split(" ");

        if (coms[0].equals("push_front")) {
            d.addFirst(Integer.parseInt(coms[1]));
        } else if (coms[0].equals("push_back")) {
            d.addLast(Integer.parseInt(coms[1]));
        } else if (command.equals("pop_front")) {
            if (d.isEmpty()) System.out.println("-1");
            else System.out.println(d.pollFirst());
        } else if (command.equals("pop_back")) {
            if (d.isEmpty()) System.out.println("-1");
            else System.out.println(d.pollLast());
        } else if (command.equals("size")) {
            System.out.println(d.size());
        } else if (command.equals("empty")) {
            if (d.isEmpty()) System.out.println(1);
            else System.out.println(0);
        } else if (command.equals("front")) {
            if (d.isEmpty()) System.out.println("-1");
            else System.out.println(d.peekFirst());
        } else if (command.equals("back")) {
            if (d.isEmpty()) System.out.println("-1");
            else System.out.println(d.peekLast());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            deque(command, d);
        }
    }
}

/**
 * 시간 제한이 0.5초인걸 보고 무조건 deque 를 써야겠다고 생각했다.
 */