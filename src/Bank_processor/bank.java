package Bank_processor;

import java.util.*;

public class bank {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        List<bank_sub> accounts = new ArrayList<>();

        System.out.println("Enter number of clients:");
        int clients = input.nextInt();
        input.nextLine();
        for (int i = 0; i < clients; i++) {
            System.out.println("Enter client name:");
            String client = input.nextLine();
            System.out.println("Enter client account number (11 digits)");
            int account = input.nextInt();
            input.nextLine();
            System.out.println("Enter balance");
            double balance = input.nextDouble();
            input.nextLine();
            System.out.println("Enter account status (ACTIVE, SUSPENDED)");
            String statusinput = input.nextLine().toUpperCase();
            Status status = Status.valueOf(statusinput);
            System.out.println("client added successfully");

            accounts.add(new bank_sub(account, client, balance,status));
        }
        System.out.println("==============ALL ACTIVE ACCOUNTS=============");
        accounts.stream()
                .filter(x -> x.getStatus() == Status.ACTIVE)
                .forEach(System.out::println);


        System.out.println("============Accounts that interest has been applied to===============");
        accounts.stream()
                .filter(x -> x.getStatus() == Status.ACTIVE)
                .forEach(x ->{
                    x.setBalance(x.getBalance() * 1.50);
                    System.out.println(x.getBalance());
                });


        System.out.println("===============Richest Account===================");
        Optional<bank_sub> max = accounts.stream()
                .filter(x -> x.getStatus() == Status.ACTIVE)
                .max(Comparator.comparingDouble(x-> {
                    x.getAccountNumber();
                    System.out.println(x.getAccountNumber());
                    return x.getBalance();
                }));
    }
}
