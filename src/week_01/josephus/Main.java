package src.week_01.josephus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int rm = 0;
        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        int K = Integer.parseInt(st.nextToken());
        System.out.print("<");
        for (int i = 0; i < N - 1; i++) {
            rm = (rm + (K - 1)) % arr.size();
            System.out.print(arr.remove(rm) + ", ");
        }
        System.out.println(arr.remove(0) + ">");
    }
}
