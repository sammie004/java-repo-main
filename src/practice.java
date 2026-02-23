//public abstract class practice{
//    private int id;
//    private String name;
//
//    public void notify(String message){
//        System.out.println(message);
//    }
//
//    abstract void getRole();
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//}
//
//
//class Student extends practice implements Actionable{
//
//    @Override
//    void getRole() {
//        System.out.println("Role: Student");
//    }
//
//    @Override
//    public void notify(String message) {
//        System.out.println("Student logged in");
//    }
//
//    @Override
//    public void performAction(String action) {
//        System.out.println("Request result");
//    }
//}
//
//class Lecturer extends practice implements Actionable{
//
//    @Override
//    void getRole() {
//        System.out.println("Role: Lecturer");
//    }
//
//    @Override
//    public void notify(String message) {
//        System.out.println("Lecturer logged in");
//    }
//
//    @Override
//    public void performAction(String action) {
//        System.out.println();
//    }
//}
//
//class HOD extends practice implements Actionable{
//    @Override
//    public void notify(String message) {
//        System.out.println("HOD logged in");
//    }
//
//    @Override
//    void getRole() {
//        System.out.println("Role: HOD");
//    }
//
//    @Override
//    public void performAction(String action) {
//        System.out.println("");
//    }
//}
//
//
//interface Actionable{
//    default void performAction(String action) {
//
//    }
//}
//



public class practice{
    private  String username;
    private  String password;


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}