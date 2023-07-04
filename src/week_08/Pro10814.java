package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 10814 - 나이순 정렬
 */
public class Pro10814 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Elem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Elem(i + 1, Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(elem -> sb.append(elem.age).append(" ").append(elem.name).append("\n"));
        System.out.println(sb);
    }

    private static class Elem implements Comparable<Elem> {
        int index;
        int age;
        String name;

        public Elem(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Elem o) {
            if (this.age == o.age)
                return this.index - o.index;
            return this.age - o.age;
        }
    }
}
