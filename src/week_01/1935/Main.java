package week_01;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String data = br.readLine();
        double[] dArr = new double[N];
        for (int i = 0; i < N; i++)
            dArr[i] = Double.parseDouble(br.readLine());
        Stack<Double> stack = new Stack<>();

        double res = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) >= 'A' && data.charAt(i) <= 'Z') {
                stack.push(dArr[data.charAt(i) - 'A']);
            } else {
                if (!stack.isEmpty()) {
                    double first = stack.pop();
                    double second = stack.pop();
                    switch (data.charAt(i)) {
                        case '+':
                            res = second + first;
                            stack.push(res);
                            break;
                        case '-':
                            res = second - first;
                            stack.push(res);
                            break;
                        case '*':
                            res = second * first;
                            stack.push(res);
                            break;
                        case '/':
                            res = second / first;
                            stack.push(res);
                            break;
                    }
                }
            }
        }
        System.out.printf("%.2f\n", stack.pop());
    }
}
