package list_practice.list;
import java.util.*;

public class maps {
    public static void main(String[]args){
        Scanner scanner = new  Scanner(System.in);
        Set<String> user = new HashSet<>();
        List<String> counted = new ArrayList<>();
        System.out.println("how many roles do you want to populate");
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <num ; i++) {
            System.out.println("Enter name "+(i+1));
            String name = scanner.nextLine();
            if(user.contains(name)){
                throw new IllegalArgumentException("role created already");
            }else {
                user.add(name);

                for (String User : user){
                    if(counted.contains(User)) continue;

                    int count = 0;
                    for(String u : user){
                        if(u.equals(User)) count ++;
                    }
                    System.out.println(User+" appeared" + count + "times");
                    counted.add(User);
                }

            }
        }
    }
}