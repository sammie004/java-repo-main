package lamda;

import java.time.Instant;
import java.util.Date;

enum Status {
    SUCCESS,
    FAILED
}

class Transaction {
    private Instant localDate = Instant.now();
    private Date date = Date.from(Instant.now());

    private int id;
    private String user;
    private int amount;
    private Status status;

    public Transaction(int id, String user, int amount, Status status) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.status = status;
    }

    public int getId() { return id; }
    public String getUser() { return user; }
    public int getAmount() { return amount; }
    public Status getStatus() { return status; }

    @Override
    public String toString() {
        return "Transaction id: " + id +
                " | User: " + user +
                " | Amount: " + amount +
                " | Status: " + status +
                "| date: " + date;
    }
}