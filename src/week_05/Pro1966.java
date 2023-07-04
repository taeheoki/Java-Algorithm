package src.week_05;

import javax.print.Doc;
import java.io.*;
import java.util.*;

/**
 * 백준 2346번 풍선 터뜨리기
 */
class Elem {
    int index;
    int offset;

    public Elem(int index, int offset) {
        this.index = index;
        this.offset = offset;
    }
}

public class Pro1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Elem> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++)
            deque.offer(new Elem(i + 1, Integer.parseInt(st.nextToken())));
        while (true) {
            Elem data = deque.pop();
            sb.append(data.index + " ");
            if (deque.isEmpty())
                break;
            if (data.offset > 0) {
                for (int i = 0; i < data.offset - 1; i++) {
                    Elem tmp = deque.pollFirst();
                    deque.addLast(tmp);
                }
            } else {
                for (int i = 0; i < -data.offset; i++) {
                    Elem tmp = deque.pollLast();
                    deque.addFirst(tmp);
                }
            }
        }
        System.out.println(sb);
    }
}
