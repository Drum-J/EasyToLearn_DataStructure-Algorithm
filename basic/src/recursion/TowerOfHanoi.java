package recursion;

public class TowerOfHanoi {
    public static void move(int n, String from, String to, String temp) {
        if (n == 0) return;

        move(n - 1, from, temp, to);
        System.out.println("원반 " + n + "를 " + from + "에서 " + to + "로 이동");
        move(n - 1, temp, to, from);
    }
}
