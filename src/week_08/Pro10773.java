package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * BOJ 10773 - 제로
 */
public class Pro10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }
        int sum = 0;
        for (int num : stack)
            sum += num;
        System.out.println(sum);
    }
}
