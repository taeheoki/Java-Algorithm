package src.week_34;

import java.util.Stack;

/**
 * 프로그래머스 - 괄호 회전하기
 */
public class Pro76502 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String back = s.substring(0, i);
            String front = s.substring(i);
            if (isCorrect(front + back))
                answer++;
        }
        return answer;
    }

    private static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '{' || tmp == '[' || tmp == '(')
                stack.push(tmp);
            else {
                if (stack.isEmpty())
                    return false;
                if (tmp == '}' && stack.peek() == '{')
                    stack.pop();
                else if (tmp == ']' && stack.peek() == '[')
                    stack.pop();
                else if (tmp == ')' && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
