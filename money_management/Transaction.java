package java_learn.money_management;

import java.util.UUID;

public class Transaction {
    private String id;
    private double amount;
    private String type;

    public Transaction(double amount, String type) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.type = type;
    }

    public String getTransactionId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    // @Override
    // public String toString() {
    //     return "{" +
    //             "id:'" + id + '\'' +
    //             ", amount:'" + amount + '\'' +
    //             ", type:'" + type + '\'' +
    //             '}';
    // }
}
