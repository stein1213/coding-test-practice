import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 10815 숫자 카드
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }
        // 필요한 코드 작성
        HashSet<Integer> setN = new HashSet<>();
        for (int i = 0; i < N; i++) {
            setN.add(arr1[i]);
        }


        for (int i = 0; i < M; i++) {
            if (setN.contains(arr2[i])) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}