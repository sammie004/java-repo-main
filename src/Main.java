//public class Main {
//    public static void main(String[] args) {
//        Student s = new Student();
//        s.setName("Sam");
//        s.setId(1);
//        s.getRole();
//        s.notify("Welcome!");
//        s.performAction("Request result");
//
//        Lecturer l = new Lecturer();
//        l.setName("Dr. L");
//        l.setId(2);
//        l.getRole();
//        l.notify("Welcome!");
//        l.performAction("Approve result");
//
//        HOD h = new HOD();
//        h.setName("Prof. H");
//        h.setId(3);
//        h.getRole();
//        h.notify("Welcome!");
//        h.performAction("Finalize result");
//    }
//}

public class Main{
    public static void main(String[]args){
        var new_user = new practice();
        try{
            new_user.setUsername(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() );
        }
        new_user.setPassword("tunji");
        String total_val = new_user.getUsername();
        System.out.println(total_val);
    }
}