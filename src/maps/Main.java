package maps;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================WELCOME=====================");
        System.out.println("Are you an attendee or organizer");
        String role = scanner.nextLine().toLowerCase();

        switch (role) {
            case "attendee":
                while (true) {
                    System.out.println("What would you like to do? \nLogin\nRegister\n(Type done to exit the program)");
                    String choice = scanner.nextLine().toLowerCase();

                    if (choice.equals("done")) {
                        System.out.println("Thank you for using the system. Goodbye!");
                        break;
                    }

                    if (choice.equals("register")) {
                        System.out.print("Enter your username: ");
                        String name = scanner.nextLine();

                        if (users.containsKey(name)) {
                            System.out.println("A user with this username already exists");
                            continue;
                        }

                        String password;
                        while (true) {
                            System.out.print("Enter your password: ");
                            password = scanner.nextLine();

                            System.out.print("Confirm your password: ");
                            String confirm = scanner.nextLine();

                            if (password.equals(confirm)) {
                                users.put(name, password);
                                System.out.println("User registered successfully!");
                                break;
                            } else {
                                System.out.println("Passwords do not match. Try again.");
                            }
                        }
                    }

                    else if (choice.equals("login")) {
                        System.out.print("Enter your username: ");
                        String name = scanner.nextLine();

                        int tryCount = 0;
                        while (true) {
                            System.out.print("Enter your password: ");
                            String password = scanner.nextLine();

                            if (users.containsKey(name) && users.get(name).equals(password)) {
                                System.out.println("Login successful!");
                                attendee loggedInUser = new attendee(name, password);

                                // Loop for attendee actions
                                while (true) {
                                    System.out.println("What would you like to do? \nOptions: buy ticket, view available events\n(Type exit to logout)");
                                    String task = scanner.nextLine().toLowerCase();

                                    if (task.equals("exit")) {
                                        System.out.println("Logging out...");
                                        break;
                                    }

                                    try {
                                        loggedInUser.allowedActions(task);
                                    } catch (IllegalArgumentException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }

                                break; // Exit password loop after successful login
                            } else {
                                tryCount++;
                                System.out.println("Invalid password. Try again!");
                                if (tryCount >= 5) {
                                    System.out.println("You have been blocked. Try again later.");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid option. Type 'login', 'register', or 'done'.");
                    }
                }
                break;

            default:
                System.out.println("Role not recognized. Please restart the program.");
        }
    }
}
