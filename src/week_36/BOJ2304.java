package src.week_36;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2304 - 창고 다각형
 */
public class BOJ2304 {
//    static int N, res = Integer.MAX_VALUE;
//    static int[][] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        arr = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            arr[i][0] = Integer.parseInt(st.nextToken());
//            arr[i][1] = Integer.parseInt(st.nextToken());
//        }
//        pro();
////        for (int[] ints : arr) {
////            System.out.println(ints[0] + " " + ints[1]);
////        }
//    }
//
//    private static void pro() {
//        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
//        int[] max = Arrays.stream(arr).max((a, b) -> a[1] - b[1]).get();
//        int xCmp = arr[0][0];
//        int yCmp = arr[0][1];
//        boolean flag = false;
//        int sum = 0;
//        int i = 1;
//        for (; i < N; i++) {
//            if (!flag) {
//                int x = arr[i][0];
//                int y = arr[i][1];
//                if (x > max[0] && y < max[1])
//                    break;
//                if (yCmp < y) {
//                    sum += (x - xCmp) * yCmp;
//                    xCmp = x;
//                    yCmp = y;
//                }
//                if (y == max[1])
//                    sum += y;
//            }
//        }
//    }

    static class Pillar implements Comparable<Pillar> {
        int position;
        int height;

        public Pillar(int position, int height) {
            this.position = position;
            this.height = height;
        }

        @Override
        public int compareTo(Pillar o) {
            return this.position - o.position;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int N = Integer.parseInt(br.readLine());

        ArrayList<Pillar> pillars = new ArrayList<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int position = Integer.parseInt(st.nextToken());
            int height  = Integer.parseInt(st.nextToken());

            pillars.add(new Pillar(position, height));
        }

        // 위치에 따라 정렬
        Collections.sort(pillars);

        // 가장 높은 기둥 찾기
        Pillar maxPillar = pillars.stream().max((p1, p2) -> p1.height - p2.height).get();

        // 왼쪽 면적 계산
        int totalArea=0;

        for (int i=0; i<pillars.indexOf(maxPillar); ) {
            Pillar curPillar=pillars.get(i);
            for(int j=i+1;j<=pillars.indexOf(maxPillar);j++){
                if(curPillar.height<=pillars.get(j).height){
                    totalArea+=curPillar.height*(pillars.get(j).position-curPillar.position);
                    i=j;
                    break;
                }
            }
        }

        // 오른쪽 면적 계산
        for (int i=N-1; i>pillars.indexOf(maxPillar); ) {
            Pillar curPillar=pillars.get(i);
            for(int j=i-1;j>=pillars.indexOf(maxPillar);j--){
                if(curPillar.height<=pillars.get(j).height){
                    totalArea+=curPillar.height*(curPillar.position-pillars.get(j).position);
                    i=j;
                    break;
                }
            }
        }

        // 가장 높은 기둥 면적 계산
        totalArea+=maxPillar.height;


        System.out.println(totalArea);
    }
}
