package src.week_01.stack;

import java.util.Scanner;

public class Main_1 {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            switch (str) {
                case "push":
                    push(scanner.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int i) {
        stack[size] = i;
        size++;
    }

    public static int pop() {
        int res;

        if (size == 0) {
            return -1;
        } else {
            res = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (size == 0) {
            return -1;
        } else {
            return stack[size - 1];
        }
    }
}
