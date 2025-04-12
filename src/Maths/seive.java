package Maths;

public class seive {

    public static void main(String[] args) {
        int n = 40;
        boolean[] isPrime = new boolean[n + 1];

        // Initialize all entries to true
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Implementing the sieve
      for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Print all prime numbers
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
