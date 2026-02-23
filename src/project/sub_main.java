package project;

import com.sun.security.jgss.GSSUtil;

abstract class users{
    protected String username;
    protected String email;
    protected String password;


    public users(String username,String email,String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
    abstract void getRole();

    abstract void performActions(String action);
}

class Attendee extends users{

    public Attendee(String username, String email, String password) {
        super(username, email, password);
    }

    @Override
    void getRole() {
        System.out.println("This user is an attendee");
    }



    @Override
    void performActions(String action) {
        switch (action.toLowerCase()){
            case"view event":
                System.out.println("Viewing event now");


            case "book ticket":
                System.out.println("Booking ticket");


            default:
                throw new IllegalArgumentException("You cant do this!");
        }
    }
}

class Organizers extends users{

    public Organizers(String username, String email, String password) {
        super(username, email, password);
    }

    @Override
    void getRole() {

    }


    @Override
    void performActions(String action) {

    }
}