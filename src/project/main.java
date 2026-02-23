package project;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> emails = new HashSet<>();
        List<users> user_info = new ArrayList<>();

        System.out.println("Are you an organizer or an attendee");
        String option = scanner.nextLine();

        switch (option.toLowerCase()){
            case "attendee":
                while (true) {
                    System.out.println("Do you want to Login or Register? (Type 'exit' to quit)");
                    String choice = scanner.nextLine().toLowerCase();

                    if (choice.equals("exit")) {
                        System.out.println("Goodbye!");
                        break;
                    }

                    switch (choice) {
                        case "register":
                            System.out.println("========== Register ==========");
                            System.out.print("Enter username: ");
                            String username = scanner.nextLine();

                            System.out.print("Enter email: ");
                            String email = scanner.nextLine();
                            if (emails.contains(email)) {
                                System.out.println("This email already exists!");
                                break;
                            }

                            String password;
                            while (true) {
                                System.out.print("Enter password: ");
                                password = scanner.nextLine();

                                System.out.print("Confirm password: ");
                                String confirm_pass = scanner.nextLine();

                                if (!password.equals(confirm_pass)) {
                                    System.out.println("Passwords do not match. Try again.");
                                } else {
                                    break;
                                }
                            }

                            // Register user
                            user_info.add(new Attendee(username, email, password));
                            emails.add(email);
                            System.out.println("User registered successfully!");
                            break;

                        case "login":
                            System.out.println("========== Login ==========");
                            System.out.print("Enter email: ");
                            String loginEmail = scanner.nextLine();

                            System.out.print("Enter password: ");
                            String loginPassword = scanner.nextLine();

                            boolean found = false;
                            for (users u : user_info) {
                                if (u.email.equals(loginEmail)) {
                                    found = true;
                                    if (u.password.equals(loginPassword)) {
                                        System.out.println("Login successful! Welcome " + u.username);
                                        u.getRole();

                                        // === Action loop after login ===
                                        boolean loggedIn = true;
                                        while (loggedIn) {
                                            System.out.println("What do you want to do? (type 'logout' to exit)");
                                            String action = scanner.nextLine();

                                            if (action.equalsIgnoreCase("logout")) {
                                                loggedIn = false;
                                                System.out.println("You have logged out!");
                                                break;
                                            }

                                            try {
                                                u.performActions(action); // Role-specific action
                                            } catch (IllegalArgumentException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        // === End of action loop ===

                                    } else {
                                        System.out.println("Incorrect password!");
                                    }
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("User not found!");
                            }
                            break;

                        default:
                            System.out.println("Invalid choice. Type 'login' or 'register'.");
                    }
                }
        }
    }
}
