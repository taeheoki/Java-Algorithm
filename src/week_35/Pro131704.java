package src.week_35;

import java.util.Stack;

/**
 * 프로그래머스 - 택배상자
 */
public class Pro131704 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
        System.out.println(solution(new int[]{3, 2, 1, 4, 5}));
    }

    public static int solution(int[] order) {
        Stack<Integer> subContainer = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        int containerBelt = 1;
        for (int box : order) {
            if (containerBelt <= box) {
                while (containerBelt != box) {
                    subContainer.add(containerBelt);
                    containerBelt++;
                }
                stack.add(box);
                containerBelt++;
            } else {
                if (box == subContainer.peek()) {
                    stack.add(subContainer.pop());
                } else
                    break;
            }
        }
        return stack.size();
    }
}
