package src.week_13;

import java.util.Stack;

/**
 * 프로그래머스 - 올바른 괄호
 * 문제 이해: 괄호가 제대로 짝과 순서를 이루는지 확인한다.
 *          자료구조 문제
 */
public class Pro올바른괄호 {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
    static boolean solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push('(');
            else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
