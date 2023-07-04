package src.week_15;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 프로그래머스 - 방금그곡
 * 문제 이해:
 */
public class Pro방금그곡 {

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("ABC", new String[]{"13:00,13:05,WORLD,ABCDEF", "00:00,00:05,HELLO,ABCDEF"}));
    }

    public static String solution(String m, String[] musicinfos) {
        PriorityQueue<Music> pq = new PriorityQueue<>();
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st1 = new StringTokenizer(musicinfos[i], ",");
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), ":");
            int HH = Integer.parseInt(st2.nextToken());
            int MM = Integer.parseInt(st2.nextToken());
            int start = HH * 60 + MM;
            st2 = new StringTokenizer(st1.nextToken(), ":");
            int HH2 = Integer.parseInt(st2.nextToken());
            int MM2 = Integer.parseInt(st2.nextToken());
            int end = HH2 * 60 + MM2;
            int time = end - start;
            pq.add(new Music(time, st1.nextToken(), subtitution(st1.nextToken())));
        }
        String ans = findTitle(subtitution(m), pq);
        return ans;
    }

    private static String findTitle(String m, PriorityQueue<Music> pq) {
        while (!pq.isEmpty()) {
            Music music = pq.poll();
            char start = m.charAt(0);
            int pos = music.info.indexOf(start);
            while (pos != -1) {
                for (int i = 0; i < m.length() && pos + i <= music.time; i++) {
                    if (music.info.charAt((pos + i) % music.info.length()) != m.charAt(i))
                        break;
                    if (i == m.length() - 1) {
                        return music.title;
                    }
                }
                pos = music.info.indexOf(start, pos + 1);
            }
        }
        return "(None)";
    }

    private static String subtitution(String str) {
        return str.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    private static class Music implements Comparable<Music> {
        int time;
        String title;
        String info;

        public Music(int time, String title, String info) {
            this.time = time;
            this.title = title;
            this.info = info;
        }

        @Override
        public int compareTo(Music o) {
            return o.time - this.time;
        }
    }
}
