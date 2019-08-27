package steffan.deu.offer.CMB;

import java.util.Scanner;

public class KaoQin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(1 + n + n * (n - 1) / 2);
    }
}
