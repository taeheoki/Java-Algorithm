package src.week_16;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 프로그래머스 - 큰 수 만들기
 */
public class Pro큰수만들기 {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
//        System.out.println(solution("1231234", 3));
//        System.out.println(solution("4177252841", 4));
//        System.out.println(solution("9929191", 5));
    }
    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            while (k > 0 && !stack.isEmpty() && number.charAt(i) > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        char[] result = new char[number.length() - k];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);



//        Stack<Character> stack = new Stack<>();
//        stack.push(number.charAt(0));
//        for (int i = 1; i < number.length(); i++) {
//            while (k > 0 && !stack.isEmpty() && number.charAt(i) > stack.peek()) {
//                stack.pop();
//                k--;
//            }
//            stack.push(number.charAt(i));
//        }
//        while (k > 0) {
//            stack.pop();
//            k--;
//        }
//        String ans = "";
//        while (!stack.isEmpty()) {
//            ans = stack.pop() + ans;
//        }
//        return ans;
    }
}
