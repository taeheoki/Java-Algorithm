package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1541 - 잃어버린 괄호
 */
public class Pro1541 {
    static Stack<Integer> arr = new Stack<>();
    static Stack<Integer> arr2 = new Stack<>();
    static Stack<Character> operation = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        StringTokenizer st = new StringTokenizer(data, "+-");
        while (st.hasMoreTokens())
            arr.push(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < data.length(); i++) {
            char tmp = data.charAt(i);
            if (tmp == '+' || tmp == '-')
                operation.push(tmp);
        }
        pro();
    }

    private static void pro() {
        while (!operation.isEmpty()) {
            char oper = operation.pop();
            if (oper == '+') {
                int tmp = arr.pop() + arr.pop();
                arr.push(tmp);
            } else {
                arr2.push(arr.pop());
            }
        }
        int plus = arr.stream().mapToInt(s -> s).sum();
        int minus = arr2.stream().mapToInt(s -> s).sum();
        System.out.println(plus - minus);
    }
}
