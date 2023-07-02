import java.io.*;
import java.util.*;

/** 큐 2 **/
public class p18258 {
    static StringBuilder sb = new StringBuilder();
    public static void queue(String command, Deque<Integer> q) {
        String[] com = command.split(" ");

        if (com.length > 1) q.add(Integer.parseInt(com[1]));
        else if (command.equals("pop")) {
            if (q.size() == 0) sb.append(-1).append("\n");
            else sb.append(q.pollFirst()).append("\n");
        } else if (command.equals("size")) sb.append(q.size()).append("\n");
        else if (command.equals("empty")) {
            if (q.isEmpty()) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        } else if (command.equals("front")) {
            if (q.size() == 0) sb.append(-1).append("\n");
            else sb.append(q.peek()).append("\n");
        } else {
            if (q.size() == 0) sb.append(-1).append("\n");
            else sb.append(q.peekLast()).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            queue(command, q);
        }
        System.out.println(sb);
    }
}

/**
 * 시간초과 해결
 *
 * 1. queue -> dequeue
 *    사유: back() method 가 없음
 * 2. println -> StringBuilder
 *    사유: println 을 각 명령어 마다 해서 느림
 */