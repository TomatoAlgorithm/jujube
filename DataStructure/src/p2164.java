import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/** 카드2 **/
public class p2164 {
    public static void card(int N) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.add(i);
        while (!queue.isEmpty()) {
            queue.poll();
            Integer temp = queue.poll();
            queue.add(temp);
            if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) System.out.println(N);
        else card(N);
    }
}
/**
 * queue 로 풀자!
 * N 이 1 일 때, null 값 출력해서
 * card() 호출 전 예외 처리
 */