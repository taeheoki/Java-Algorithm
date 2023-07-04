package src.workshop;

import java.util.*;
public class MyInsertionSort
{
    public static void main(String[] args)
    {
        int[] arr = generateDescArray(1000000);//내림차순 숫자 배열// 최악의경우
        long beforeTime = System.currentTimeMillis();
        insertionSort(arr);//오름차순 정렬하기
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("worst case");
        System.out.println(secDiffTime);
        int[] arrRan = generateRandomArray(1000000, 1, 100000);//랜덤숫자 생성
        beforeTime = System.currentTimeMillis();
        insertionSort(arrRan);//오름차순 정렬하기
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("random case");
        System.out.println(secDiffTime);
    }
    public static void insertionSort(int[] arr)
    {
        int n = arr.length;
        for (int r = 1; r < n; r++) {
            int rval = arr[r];//백업
            int l = r - 1;
            while (l >= 0 && arr[l] > rval)//작은 대상을 찾을때까정 반복
            {
                arr[l + 1] = arr[l];//크면 오른쪽으로 한칸 이동
                l = l - 1;//다음 대상 인덱스로 이동
            }
            arr[l + 1] = rval;//나보다 작은 녀석의 오른쪽에 정착하기
        }
    }
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }
        return arr;
    }
    public static int[] generateDescArray(int size)
    {
        int[] arr = new int[size];
        for(int i = 0; i < size; ++i)
        {
            arr[i] = size-i;
        }
        return arr;
    }
}
