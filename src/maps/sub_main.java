package maps;

import java.time.LocalDate;

abstract class user{
    String username;
    String password;

    public user(String username,String password){
        this.username = username;

        this.password = password;
    }
   abstract  void displayRole();
}

class attendee extends user{
    LocalDate date = LocalDate.now();
    int random_number = (int)(Math.random() * 5);
    public attendee(String username, String password) {
        super(username, password);
    }

    @Override
    void displayRole() {
        System.out.println("This user is an attendee");
    }

    void allowedActions(String action){
        switch (action.toLowerCase()){
            case "buy ticket":
                System.out.println("Ticket purchased successfully on " + date);
                break;

            case "view available events":
                System.out.println("There are a total of " + random_number + " "+"events");
                break;



            default:
                throw new IllegalArgumentException("You dont have the rights to do that");
        }
    }


}

class organizer extends user{
    LocalDate date = LocalDate.now();
    int randmon_number = (int)(Math.random() * 10);

    public organizer(String username, String password) {
        super(username, password);
    }

    @Override
    void displayRole() {
        System.out.println("This user is an organizer");
    }

    void allowedActions(String allow){
        switch (allow.toLowerCase()){
            case "Create an event":
                System.out.println("Event created successfully on " + date);
                break;

            case "View attendees":
                System.out.println("There are a total of "+randmon_number+" "+"attendees");
                break;


            default:
                throw new IllegalArgumentException("You dont have the permission to do that");
        }

    }
}