/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:20-09-2023
 * Program:Finding if the number given is perfect square or not using binary search.
 */
import java.util.Scanner;
public class PerfectSquare {
    static boolean isPerfectSquare(int n)
    {
        if (n <= 1) {
            return true;
        }
        long l = 1, r = n;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square == n) {
                return true;
            }
            else if (square < n) {
                l = mid + 1;
            }
            // If the square is larger than n, search the
            // l half
            else {
                r = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the Number:");
        int n = in.nextInt();

        if (isPerfectSquare(n)) {
            System.out.println(n + " is a perfect square.");
        }
        else {
            System.out.println(
                    n + " is not a perfect square.");
        }
    }
}


