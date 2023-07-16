package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 5430 - AC
 */
public class Pro5430 {
    static StringBuilder sb = new StringBuilder();
    static int T, n;
    static String p;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for (int i = 0; i < n; i++)
                arr.add(Integer.parseInt(st.nextToken()));
            pro();
            arr.clear();
        }
        System.out.println(sb);
    }

    private static void pro() {
        boolean order = false;
        boolean isError = false;
        for (int i = 0; i < p.length(); i++) {
            char pivot = p.charAt(i);
            if (pivot == 'R') {
                if (order)
                    order = false;
                else
                    order = true;
            } else if (pivot == 'D') {
                if (arr.isEmpty()) {
                    isError = true;
                    break;
                }
                if (order)
                    arr.remove(arr.size() - 1);
                else
                    arr.remove(0);
            }
        }
        if (isError)
            sb.append("error").append('\n');
        else {
            sb.append("[");
            if (!order) {
                for (int i = 0; i < arr.size(); i++) {
                    sb.append(arr.get(i));
                    if (i != arr.size() - 1)
                        sb.append(",");
                }
            } else {
                for (int i = arr.size() - 1; i >= 0; i--) {
                    sb.append(arr.get(i));
                    if (i != 0)
                        sb.append(",");
                }
            }
            sb.append("]\n");
        }
    }
}
