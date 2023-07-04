package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 17609 - 회문
 * 문제 이해: 글자가 주어졌을 때, 회문(0)인지, 유사 회문(1)인지, 아니면 이것도 저것도 아닌지(2) 판별하라
 * 시간 복잡도: O(T * 3 * N) -> O(T * N)
 */
public class Pro17609 {
    static StringBuilder sb = new StringBuilder();
    static int T, tmp, flag;
    static String data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            data = br.readLine();
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        int left = 0;
        int right = data.length() - 1;
        flag = 0;
        int tmp = 2;
        while (left <= right) {
            if (flag == 2)
                break;
            // 같을 때,
            if (data.charAt(left) == data.charAt(right)) {
                left++;
                right--;
            } else { // 다를 때
                flag++;
                // 둘 중 어느 하나를 옮겨도 만족할 때
                if (data.charAt(left + 1) == data.charAt(right) && data.charAt(left) == data.charAt(right - 1)) {
                    if (data.charAt(left + 1) ==  data.charAt(right - 2) && data.charAt(left + 2) ==  data.charAt(right - 1))
                        tmp = rec_func(left + 1, right, data, flag);
                    if (data.charAt(left + 1) ==  data.charAt(right - 2))
                        right--;
                    else if ((data.charAt(left + 2) ==  data.charAt(right - 1)))
                        left++;
                    else {
                        if (left == right - 1) {
                            left++;
                            right--;
                            continue;
                        }
                        flag = 2;
                    }
                }
                // 왼쪽을 지워야 할 때
                else if (data.charAt(left + 1) == data.charAt(right))
                    left++;
                    // 오른쪽을 지워야 할 때
                else if (data.charAt(left) == data.charAt(right - 1))
                    right--;
                else
                    flag = 2;
            }
        }
        flag = Math.min(flag, tmp);
        sb.append(flag).append("\n");
    }

    private static int rec_func(int left, int right, String data, int tmp_flag) {
        while (left <= right) {
            if (tmp_flag == 2)
                break;
            // 같을 때,
            if (data.charAt(left) == data.charAt(right)) {
                left++;
                right--;
            } else { // 다를 때
                tmp_flag++;
                // 둘 중 어느 하나를 옮겨도 만족할 때
                if (data.charAt(left + 1) == data.charAt(right) && data.charAt(left) == data.charAt(right - 1)) {
                    if (data.charAt(left + 1) ==  data.charAt(right - 2))
                        right--;
                    else if ((data.charAt(left + 2) ==  data.charAt(right - 1)))
                        left++;
                    else {
                        if (left == right - 1) {
                            left++;
                            right--;
                            continue;
                        }
                        tmp_flag = 2;
                    }
                }
                // 왼쪽을 지워야 할 때
                else if (data.charAt(left + 1) == data.charAt(right))
                    left++;
                    // 오른쪽을 지워야 할 때
                else if (data.charAt(left) == data.charAt(right - 1))
                    right--;
                else
                    tmp_flag = 2;
            }
        }
        return tmp_flag;
    }
}


