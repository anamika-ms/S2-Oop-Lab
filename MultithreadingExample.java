import java.util.Scanner;

class MultiplicationTable extends Thread {
    public void run() {
        System.out.println("Multiplication Table of 5:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class PrimeNumbers implements Runnable {
    private int N;

    public PrimeNumbers(int N) {
        this.N = N;
    }

    public void run() {
        int count = 0, num = 2;
        System.out.println("First " + N + " Prime Numbers:");
        while (count < N) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
            try {
                Thread.sleep(300); // Sleep for 300ms
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(); // Move to the next line after printing all primes
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

public class MultithreadingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of prime numbers to generate: ");
        int N = scanner.nextInt();

        MultiplicationTable tableThread = new MultiplicationTable();
        PrimeNumbers primeTask = new PrimeNumbers(N);
        Thread primeThread = new Thread(primeTask);

        // Start multiplication table thread first
        tableThread.start();

        // Wait for the multiplication table thread to finish
        try {
            tableThread.join(); // Ensures the multiplication table is completed first
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Start prime numbers thread after the table is done
        primeThread.start();

        // Wait for the prime numbers thread to finish
        try {
            primeThread.join(); // Ensures the prime numbers are printed after the table is done
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Multithreading demonstration completed.");
        scanner.close();
    }
}
