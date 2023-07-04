package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * BOJ 2374 - 같은 수로 만들기
 */
public class Pro2374 {
    static int n;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long res = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            max = Math.max(max, tmp);
            if (stack.isEmpty())
                stack.add(tmp);
            else {
                if (tmp > stack.peek()) {
                    res += tmp - stack.pop();
                    stack.add(tmp);
                } else if (tmp < stack.peek()) {
                    stack.pop();
                    stack.add(tmp);
                }
            }
        }
        while (!stack.isEmpty()) {
            res += max - stack.pop();
        }
        System.out.println(res);
    }
}
