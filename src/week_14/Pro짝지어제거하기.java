package src.week_14;

import java.util.Stack;

/**
 * 프로그래머스 - 짝지어 제거하기
 */
public class Pro짝지어제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (stack.isEmpty())
                stack.push(tmp);
            else {
                char cmp = stack.peek();
                if (cmp == tmp)
                    stack.pop();
                else
                    stack.push(tmp);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
