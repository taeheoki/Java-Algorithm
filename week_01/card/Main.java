package week_01.card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> arr = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int i;
        for (i = 1; i < N + 1; i++) {
            arr.add(i);
        }
        for (i = 0; i < N -1; i++) {
            arr.poll();
            arr.offer(arr.poll());
        }
        System.out.println(arr.peek());
    }
}
