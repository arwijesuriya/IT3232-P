import java.util.Scanner;

public class EC05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        int mid = (n + 1) / 2;
        
        for (int i = 1; i <= n; i++) {
            if (i < mid) {
                System.out.print((mid - i) + " ");
            } 
            else if (i == mid) {
                System.out.print(mid + " ");
            } 
            else {
                System.out.print((n - (i - mid)) + (i == n ? "" : " "));
            }
        }
    }
}
