package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * BOJ 2870 - 수학숙제
 */
public class BOJ2870 {
    static int N;
    static PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.length() > o2.length())
            return 1;
        else if (o1.length() == o2.length())
            return o1.compareTo(o2);
        else
            return -1;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            boolean flag = false;
            String num = "";
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    flag = true;
                    if (num.length() == 1 && num.equals("0"))
                        num = "" + ch;
                    else
                        num = num + ch;
                } else if (flag) {
                    pq.add(num);
                    num = "";
                    flag = false;
                }
            }
            if (flag)
                pq.add(num);
        }

        while (!pq.isEmpty())
            System.out.println(pq.poll());
    }
}
