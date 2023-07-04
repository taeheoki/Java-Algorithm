package src.codingtest_2;

import java.util.Arrays;
import java.util.Stack;

public class ProFirst {
    static int res;
    static int[] visit;
    static Stack<Integer> back = new Stack<>();
    static Stack<Integer> front = new Stack<>();

    public static void main(String[] args) {
//        System.out.println(solution("1 2 3 4 B B 42 B F F"));
//        System.out.println(solution("1 10 B B 20 1 F B B"));
//        System.out.println(solution("1 2 3 B B F F B B F F"));
        System.out.println(solution("99 1 2 B F 1 B"));
    }
    public static int solution(String s) {
        visit = new int[100];
        String[] split = s.split(" ");
        int cur_page = Integer.parseInt(split[0]);
        visit[cur_page]++;
        for (int i = 1; i < split.length; i++) {
            if (split[i].equals("B")) {
                if (back.isEmpty()) {
                    continue;
                }
                front.push(cur_page);
                cur_page = back.pop();
                visit[cur_page]++;
            } else if (split[i].equals("F")) {
                if (front.isEmpty()) {
                    continue;
                }
                back.push(cur_page);
                cur_page = front.pop();
                visit[cur_page]++;
            } else {
                int tmp = Integer.parseInt(split[i]);
                back.push(cur_page);
                cur_page = tmp;
                front.clear();
                visit[cur_page]++;
            }
        }
        return Arrays.stream(visit).max().getAsInt();
    }
}
