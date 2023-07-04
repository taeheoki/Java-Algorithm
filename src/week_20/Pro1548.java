package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * BOJ 1548 - 부분 삼각 수열
 */
public class Pro1548 {
    static int N;
    static ArrayList<Integer> arr1 = new ArrayList<>();
    static ArrayList<Integer> arr2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr1);
        pro();
    }

    private static void pro() {
        // 정렬된 상태에서 앞에 두개와 마지막을 비교하였을 때 참이되면 나머지 두 조건은 자동으로 참이된다.
        int res = 2;
        if (N < 3) {
            res = N;
        } else {
            int right = 1;
            for (int left = 0; left < N; left++) {
                while (right + 1 < N) {
                    right++;
                    if (arr1.get(left) + arr1.get(left + 1) <= arr1.get(right)) {
                        right--;
                        break;
                    }
                }
                res = Math.max(res, right - left + 1);
            }
        }
        System.out.println(res);
    }

}
