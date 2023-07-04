package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1092 - 배
 */
public class Pro1092 {
    static int N, M;
    static Integer[] crains;
    static ArrayList<Integer> boxs = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crains = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crains[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxs.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(crains, Collections.reverseOrder());
        Collections.sort(boxs, Collections.reverseOrder());
        pro();
    }

    private static void pro() {
        int time = 0;

        if (crains[0] < boxs.get(0)) {
            System.out.println(-1);
            return;
        }

        while (!boxs.isEmpty()) {
            int index = 0;
            for (int i = 0; i < crains.length; ) {
                if (index == boxs.size())
                    break;
                if (boxs.get(index) <= crains[i]) {
                    boxs.remove(index);
                    i++;
                } else {
                    index++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
