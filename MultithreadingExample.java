import java.util.Scanner;

class SharedResource {
    boolean printMultiplication = true; // Flag to control execution order
}

class MultiplicationTable extends Thread {
    private final SharedResource resource;

    public MultiplicationTable(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        synchronized (resource) {
            for (int i = 1; i <= 10; i++) {
                while (!resource.printMultiplication) { // Wait if it's not this thread's turn
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(i + " x 5 = " + (5 * i));
                resource.printMultiplication = false; // Switch turn to PrimeNumbers
                resource.notify(); // Notify the waiting thread
                try {
                    Thread.sleep(500); // Simulating processing delay
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

class PrimeNumbers extends Thread {
    private final SharedResource resource;
    private int N;

    public PrimeNumbers(SharedResource resource, int N) {
        this.resource = resource;
        this.N = N;
    }

    public void run() {
        synchronized (resource) {
            int count = 0, num = 2;
            while (count < N) {
                while (resource.printMultiplication) { // Wait if it's not this thread's turn
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (isPrime(num)) {
                    System.out.println("Prime: " + num);
                    count++;
                    resource.printMultiplication = true; // Switch turn to MultiplicationTable
                    resource.notify(); // Notify the waiting thread
                    try {
                        Thread.sleep(300); // Simulating processing delay
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                num++;
            }
        }
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

        SharedResource resource = new SharedResource();

        MultiplicationTable tableThread = new MultiplicationTable(resource);
        PrimeNumbers primeThread = new PrimeNumbers(resource, N);

        tableThread.start();
        primeThread.start();

        // Wait for both threads to finish
        try {
            tableThread.join();
            primeThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Multithreading demonstration completed.");
        scanner.close();
    }
}
