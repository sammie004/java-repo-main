package list_practice.list;
import java.util.*;
//public class jav{
//    public static void main(String[] args){
//        Set<String> name = new HashSet<>();
//        Scanner scanner = new Scanner(System.in);
//        boolean is_present = false;
//        System.out.println("How many names do you want to add to the list?");
//        int num = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < num; i++) {
//            System.out.println("Enter name"+(i+1));
//            String names = scanner.nextLine();
//            if(name.contains(names)){
//                is_present = true;
//            }
//            if (is_present == true){
//                throw new IllegalArgumentException("This name has been inserted already");
//            }else {
//                name.add(names);
//            }
//            System.out.println(name);
//        }
//    }
//}


public class jav {
    public static void main(String[] args){
//        List<String>name = new ArrayList<>();
//        name.add("Tunji");
//        name.add("Tunji");
//        name.add("Tunji");
//        name.add("Tunji");
//        name.add("Tunji");
//
//        System.out.println(name.get(0));
//        System.out.println(name.get(4));
//
//        for (String n : name) System.out.println(n);

//        Set<Integer> numbers = new HashSet<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(4);
//
//
//        System.out.println(numbers.toArray().length);
//
//        List<String>name = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("how many emails do you want to enter?");
//        int num = scanner.nextInt();
//        scanner.nextLine();
//
//        for (int i = 0; i <num ; i++) {
//            System.out.println("Enter email "+(i+1));
//            String email = scanner.nextLine();
//
//            name.add(email);
//        }
//        System.out.println(name);

//
//        Set<String>mail = new HashSet<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How many mails do you want to enter");
//        int num = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < num; i++) {
//            System.out.println("Enter email"+(i+1));
//            String email = scanner.nextLine();
//
//            mail.add(email);
//        }
//        System.out.println(mail);

//            Set<String>name = new HashSet<>();
//            Scanner scanner = new Scanner(System.in);
//            boolean is_present = false;
//        System.out.println("How mails do you want to pass ?");
//        int num = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < num ; i++) {
//            System.out.println("Enter email "+(i+1));
//            String mail = scanner.nextLine();
//            if(name.contains(mail)){
//                is_present = true;
//            }
//            if (is_present == true){
//                throw new IllegalArgumentException("This email already exists");
//            }
//            name.add(mail);
//
//        }

        List<Integer>num = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many mails do you want to enter?");
        int number = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter number " + (i+1));
            int val = scanner.nextInt();
            num.add(val);
            num.removeIf(n-> n%2 == 0);
            System.out.println(num);
        }

    }
}