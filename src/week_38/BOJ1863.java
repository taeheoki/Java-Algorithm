package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 1863 - 스카이라인 쉬운거
 */
public class BOJ1863 {
    static int n, res;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                int tmp = stack.peek();
                if (y < tmp) {
                    stack.pop();
                    res++;
                } else if (y == tmp)
                    stack.pop();
                else
                    break;
            }
            if (y != 0)
                stack.push(y);
        }
        res += stack.size();
        stack.clear();
        System.out.println(res);
    }
}
