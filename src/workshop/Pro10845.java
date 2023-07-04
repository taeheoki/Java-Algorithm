package src.workshop;

import java.io.*;
import java.util.*;

/**
 * 백준 10845번 큐
 */
public class Pro10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.peekFirst());
                    break;
                case "back":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.peekLast());
                    break;
            }
        }
    }
}
