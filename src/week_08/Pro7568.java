package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Pro7568 - 덩치
 */
public class Pro7568 {
    static int N;
    static Elem[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Elem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Elem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (isNotDungchi(arr[i], arr[j]))
                    rank++;
            }
            System.out.println(rank);
        }
    }

    private static boolean isNotDungchi(Elem a, Elem b) {
        boolean flag = false;
        if (a.weight < b.weight && a.height < b.height)
            flag = true;
        return flag;
    }

    private static class Elem {
        int weight;
        int height;

        public Elem(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}