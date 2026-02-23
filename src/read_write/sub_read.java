package read_write;

abstract class sub_read {
    protected String username;
    protected String email;
    protected String password;


    public sub_read(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    abstract String getRole();
    abstract void performActions(String action);
}


class attendees extends sub_read{

    public attendees(String username, String email, String password) {
        super(username, email, password);
    }

    @Override
    String getRole() {
        System.out.println("The logged in user is an attendee");
        return null;
    }

    @Override
    void performActions(String action) {
        switch (action.toLowerCase()){
            case "View event":
                System.out.println("Viewing events");

            case "egister for event":
                System.out.println("Registration completed succesfully");


            default:
                throw new IllegalArgumentException("You dont have the necessary permissions to do this");
        }
    }
}

class organizers extends sub_read{
    int min = 5;
    int max = 500;

    int total = (int) (Math.random() * 10);
    public organizers(String username, String email, String password) {
        super(username, email, password);
    }

    @Override
    String getRole() {
        System.out.println("The logged in user is an organizer");
        return null;
    }

    @Override
    void performActions(String action) {
        switch (action.toLowerCase()){
            case "create event":
                System.out.println("Event created successfully");

            case "view purchases":
                System.out.println("Total sales is" + total);

        }
    }
}
