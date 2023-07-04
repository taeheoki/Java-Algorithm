package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * BOJ 1181 - 단어 정렬
 */
class Word implements Comparable<Word> {
    int length;
    String word;

    public Word(int length, String word) {
        this.length = length;
        this.word = word;
    }

    @Override
    public int compareTo(Word o) {
        if (this.length == o.length)
            return this.word.compareTo(o.word);
        return this.length - o.length;
    }
}
public class Pro1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Word> words = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            words.add(new Word(tmp.length(), tmp));
        }
        words.stream().forEach(s -> System.out.println(s.word));
    }
}
