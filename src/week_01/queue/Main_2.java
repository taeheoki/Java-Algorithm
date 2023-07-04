package src.week_01.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front":
                    if (queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
