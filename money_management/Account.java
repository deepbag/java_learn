package money_management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Account {
    private String id;
    private String friendId;
    private List<Transaction> transaction;

    public Account(String friendId, Transaction[] transaction) {
        this.id = UUID.randomUUID().toString();
        this.friendId = friendId;
        this.transaction = new ArrayList<>(Arrays.asList(transaction));
    }

    public void addTransaction(Transaction transaction) {
        this.transaction.add(transaction);
    }

    public String getAccountfriendId() {
        return friendId;
    }


    public String getAccountId() {
        return id;
    }

    public List<Transaction> getTransactions() {
        return transaction;
    }

    // @Override
    // public String toString() {
    // return "{" +
    // "id:'" + id + '\'' +
    // ", friendId:'" + friendId + '\'' +
    // ", transactions:'" + transaction + '\'' +
    // '}';
    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ConsoleColors.CYAN).append("Account ID: ").append(id).append("\n");
        sb.append(ConsoleColors.CYAN).append("Friend ID: ").append(friendId).append("\n");
        sb.append(ConsoleColors.GREEN).append("Transactions:\n");
        sb.append(ConsoleColors.YELLOW).append(String.format("%-40s %-10s %-10s\n", "ID", "Amount", "Type"));
        sb.append(ConsoleColors.YELLOW).append("=========================================================\n");
        for (Transaction transaction : transaction) {
            sb.append(String.format("%-40s %-10.2f %-10s\n", transaction.getTransactionId(), transaction.getAmount(),
                    transaction.getType()));
        }
        return sb.toString();
    }
}
