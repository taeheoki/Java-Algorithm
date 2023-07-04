package src.week_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 기능 개발
 * 문제 이해: 프로그래머스 팀에서 기능 개선 작업을 수행하고 있다. 이 때 각 기능에 대한 개발속도는
 *          모두 다르기 때문에 앞에 있는 기능이 먼저 개발될 수 있다. 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포된다.
 *          progresses와 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지 return하라.
 */
public class Pro기능개발 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer[]> que = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            que.add(new Integer[]{progresses[i], speeds[i]});
        }
        int time = 0;
        while (!que.isEmpty()) {
            time++;
            int cnt = 0;
            while (!que.isEmpty() && que.peek()[0] + que.peek()[1] * time >= 100) {
                que.poll();
                cnt++;
            }
            if (cnt > 0)
                arr.add(cnt);
        }

        return arr.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
