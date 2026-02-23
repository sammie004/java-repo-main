package read_write;



import java.io.*;
import java.util.*;

public class read {
    private static final String FILE_NAME = "Users.txt";
    private static sub_read user;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> emails = new HashSet<>();
        List<sub_read> users = new ArrayList<>();

        // Load users from file
        loadUsersFromFile(users, emails);

        System.out.println("=========== WELCOME ==============");
        System.out.println("Are you an attendee or an organizer?");
        String roleOption = scanner.nextLine().toLowerCase();

        while (true) {
            System.out.println("Do you want to Login or Register? (Type 'exit' to quit)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            switch (choice) {
                case "register":
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
                        String confirm = scanner.nextLine();
                        if (!password.equals(confirm)) {
                            System.out.println("Passwords do not match! Try again.");
                        } else {
                            break;
                        }
                    }

                    sub_read newUser;
                    if (roleOption.equals("attendee")) {
                        newUser = new attendees(username, email, password);
                    } else {
                        newUser = new organizers(username, email, password);
                    }

                    users.add(newUser);
                    emails.add(email);
                    saveUserToFile(newUser);
                    System.out.println("User registered successfully!");
                    break;

                case "login":
                    System.out.print("Enter your email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    boolean found = false;
                    for (sub_read u : users) {
                        if (u.email.equals(loginEmail)) {
                            found = true;
                            if (u.password.equals(loginPassword)) {
                                System.out.println("Login successful! Welcome " + u.username);
                                u.getRole();
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

    // Load users from file
    private static void loadUsersFromFile(List<sub_read> users, Set<String> emails) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;
                String username = parts[0];
                String email = parts[1];
                String password = parts[2];
                String role = parts[3];

                emails.add(email);
                if (role.equalsIgnoreCase("attendee")) {
                    users.add(new attendees(username, email, password));
                } else {
                    users.add(new organizers(username, email, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save a single user to file
    private static void saveUserToFile(sub_read user){        read.user = user;
        String role = user.getRole();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(user.username + "," + user.email + "," + user.password + "," + role );
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
