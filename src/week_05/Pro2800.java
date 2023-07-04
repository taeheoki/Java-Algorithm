package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 백준 2800번 괄호 제거
 */
public class Pro2800 {
    static String data;
    static ArrayList<int[]> brackets;
    static Set<String> set = new TreeSet<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        data = br.readLine();
        brackets = new ArrayList();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c == '(') {
                s.push(i);
            } else if (c == ')') {
                brackets.add(new int[] {s.pop(), i});
            }
        }
        check = new boolean[data.length()];
        rec_func(0, data.toCharArray());
        set.stream().forEach(System.out::println);
    }

    private static void rec_func(int depth, char[] str) {
        if (depth == brackets.size()) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if (!check[i])
                    sb.append(str[i]);
                else
                    flag = true;
            }
            if (flag)
                set.add(sb.toString());
        } else {
            rec_func(depth + 1, str);

            int[] bracket = brackets.get(depth);
            check[bracket[0]] = true;
            check[bracket[1]] = true;
            rec_func(depth + 1, str);
            check[bracket[0]] = false;
            check[bracket[1]] = false;
        }
    }
}
