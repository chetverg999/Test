
import java.util.Scanner;
import java.lang.Math;

public class OtrezkiMaximum {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int[] a = new int[100000];
        int[] b = new int[320];
        int m, n, i, j = -1, L, R, p, k, q, z = 0;
        String s = "";

        n = keyboard.nextInt();
        k = (int) Math.sqrt(n);
        for (i = 0; i < n; ++i) {
            a[i] = keyboard.nextInt();
            if (i % k == 0) {
                j++;
                b[j] = i;
            } else if (a[i] > a[b[j]])
                b[j] = i;
        }
        m = keyboard.nextInt();
        while (m > 0) {
            m--;
            L = keyboard.nextInt();
            R = keyboard.nextInt();
            L--;
            R--;
            p = L / k;
            q = R / k;
            if (p == q) {
                if (L <= b[p] && R >= b[p]) {
                    z = a[b[p]];
                    s = s  + String.valueOf(z) + " ";
                } else {
                    z = a[L];
                    for (i = L + 1; i <= R; i++)
                        if (a[i] > z) {
                            z = a[i];
                            s = s + String.valueOf(z) + " ";
                        }
                }
            } else {
                if (L <= b[p]) {
                    z = a[b[p]];
                    s = s + String.valueOf(z) + " ";
                } else {
                    z = a[L];
                    for (i = L + 1; i < (p + 1) * k; i++)
                        if (a[i] > z) {
                            s = s + String.valueOf(z) + " ";
                            z = a[i];
                        }
                }
                for (j = p + 1; j < q; j++)
                    if (a[b[j]] > z) {
                        z = a[b[j]];
                        s = s + String.valueOf(z) + " ";
                    }
                if (R >= b[q]) {
                    if (a[b[q]] > z) {
                        z = a[b[q]];
                        s = s + String.valueOf(z) + " ";
                    } else
                        for (i = q * k; i <= R; i++)
                            if (a[i] > z) {
                                z = a[i];
                                s = s + String.valueOf(z) + " ";
                            }
                }
            }
        }
        System.out.println(s);
    }
}
