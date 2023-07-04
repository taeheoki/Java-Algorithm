package src.week_16;

import java.util.*;

/**
 * 프로그래머스 - 주식가격
 */
public class Pro주식가격 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 0, 2})));
    }

    public static int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        int[] arr = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            arr[i] = prices.length - i - 1;
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] pop = stack.pop();
                arr[pop[0]] = i - pop[0];
            }
            stack.push(new int[]{i, prices[i]});
        }
        return arr;
    }
}
