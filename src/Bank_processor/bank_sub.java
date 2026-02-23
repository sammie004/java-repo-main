package Bank_processor;

enum Status{ACTIVE,SUSPENDED}
class bank_sub {
    private int accountNumber;
    private String userName;
    private double balance;
    private Status status;

    public bank_sub(int accountNumber, String userName, double balance, Status status) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.balance = balance;
        this.status = status;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getUserName() { return userName; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) {this.balance = balance;}

    public Status getStatus() { return status; }

    @Override
    public String toString() {
        return "{ \n Account number: "+accountNumber+"| "+" user name"+userName+"| "+" balance"+balance+"| "+" status"+status+"\n"+" }";
    }
}
