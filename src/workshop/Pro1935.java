package src.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 1935번 후위 표기식2
 */
public class Pro1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ch = new int[N];
        Stack<Double> stack = new Stack<>();
        String data = br.readLine();
        for (int i = 0; i < N; i++)
            ch[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < data.length(); i++) {
            char tmp = data.charAt(i);
            if (tmp >= 'A' && tmp <= 'Z')
                stack.push((double) ch[tmp - 'A']);
            else {
                double first = stack.pop();
                double second = stack.pop();
                switch(tmp) {
                    case '+':
                        stack.push(second + first);
                        break;
                    case '-':
                        stack.push(second - first);
                        break;
                    case '*':
                        stack.push(second * first);
                        break;
                    case '/':
                        stack.push(second / first);
                        break;
                }
            }
        }
        for (int i = 0; i < data.length(); i++) {
            char tmp = data.charAt(i);
            // ...
        }
        System.out.printf("%.2f\n", stack.pop());
    }
}


