package lamda;

import java.util.*;

public class lamda_main {
    public static void main(String[] args) {

        List<Transaction> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============Welcome=================");
        System.out.println("How many transactions do you want to enter? ");
        int number = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < number; i++) {
            System.out.println("Enter client name:");
            String client = scanner.nextLine();

            System.out.println("Enter transaction amount:");
            int amount = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter transaction status (SUCCESS or FAILED):");
            String statusInput = scanner.next().toUpperCase();
            Status status = Status.valueOf(statusInput);

            list.add(new Transaction(i + 1, client, amount, status));
            scanner.nextLine(); // Clear newline
        }

        System.out.println("\n--- Successful Transactions ---");
        list.stream()
                .filter(x -> x.getStatus() == Status.SUCCESS)
                .forEach(System.out::println);

        int totalSuccessfulAmount = list.stream()
                .filter(x -> x.getStatus() == Status.SUCCESS)
                .mapToInt(Transaction::getAmount)
                .sum();

        System.out.println("\nTotal amount of SUCCESS transactions: " + totalSuccessfulAmount);

        list.stream()
                .filter(x -> x.getStatus() == Status.SUCCESS)
                .max(Comparator.comparingInt(Transaction::getAmount))
                .ifPresent(max -> System.out.println("Largest SUCCESS transaction: " + max));
    }
}