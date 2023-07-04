package src.week_01.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3 {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.empty())
                        System.out.println("-1");
                    else
                        System.out.println(stack.pop());
                    break;
                case "size":
                    if (!stack.empty())
                        System.out.println(stack.size());
                    else
                        System.out.println("0");
                    break;
                case "empty":
                    if (stack.empty())
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "top":
                    if (stack.empty())
                        System.out.println("-1");
                    else
                        System.out.println(stack.peek());
                    break;
            }
        }
    }
}
