import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1158 {
    public static String josephus(int N, int K) {
        StringBuilder answer = new StringBuilder("<");
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= K; i++) queue.add(i); // 1 ~ K 까지 넣어줌

        while (!queue.isEmpty()) {
            for (int i = 0; i < N-1; i++) {
                Integer temp = queue.poll();
                queue.add(temp);
            }
            if (queue.size() == 1) answer.append(queue.poll()).append(">");
            else answer.append(queue.poll()).append(", ");
        }
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int K = Integer.parseInt(str.split(" ")[0]);
        int N = Integer.parseInt(str.split(" ")[1]);
        System.out.println(josephus(N,K));
    }
}
/**
 * 1. queue 에 N-1 만큼 빼고 그대로 다시 넣어준다.
 * 2. poll 한걸 출력 문자열에 넣는다.
 */