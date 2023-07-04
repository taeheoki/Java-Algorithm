package src.week_14;

/**
 * 프로그래머스 - 행렬의 곱셈
 */
public class Pro행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[1].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[1].length; j++) {
                for (int k = 0; k < arr1[1].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
