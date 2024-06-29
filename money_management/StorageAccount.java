package java_learn.money_management;

import java.util.ArrayList;
import java.util.List;

public class StorageAccount {
    static List<Account> accounts = new ArrayList<>();
    static List<Friend> friends = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void getAllAccounts() {
        for (Account ac : accounts) {
            System.out.println(ac);
        }
    }

    public void addFriend(Friend friend) {
        Friend findFriend = StorageAccount.findFriendByPhoneNumber(friend.getPhoneNumber());
        if (findFriend == null) {
            Account account = new Account(friend.getFriendId(), new Transaction[0]);
            friends.add(friend);
            this.addAccount(account);
        } else {
            System.out.println("Friend Account Exist With Same Phone: " + findFriend);
        }
    }

    public void getAllFriends() {
        for (Friend fr : friends) {
            System.out.println(fr);
        }
    }

    public static void addTransaction(String phone, Transaction transaction) {
        Friend findFriend = StorageAccount.findFriendByPhoneNumber(phone);
        Account findAccount = StorageAccount.findAccountByFriendId(findFriend.getFriendId());
        findAccount.addTransaction(transaction);
    }

    public static Friend findFriendByPhoneNumber(String phoneNumber) {
        for (Friend friend : friends) {
            if (friend.getPhoneNumber().equals(phoneNumber)) {
                return friend;
            }
        }
        return null;
    }

    public static Friend findFriendById(String id) {
        for (Friend friend : friends) {
            if (friend.getFriendId().equals(id)) {
                return friend;
            }
        }
        return null;
    }

    public static Account findAccountByFriendId(String friendId) {
        for (Account account : accounts) {
            System.out.println(account);
            if (account.getAccountfriendId().equals(friendId)) {
                return account;
            }
        }
        return null;
    }

    public void getTotalPendingBalance() {
        for (Account account : accounts) {
            double total = 0;
            double liya = 0;
            double diya = 0;
            String message = "";
            String friendId = account.getAccountfriendId();
            String friendName = this.findFriendById(friendId).getFriendName();
            for (Transaction acT : account.getTransactions()) {
                if (acT.getType().equals("DIYA")) {
                    diya += acT.getAmount();
                } else if (acT.getType().equals("LIYA")) {
                    liya += acT.getAmount();
                }
            }
            if (diya > liya) {
                message = "Paisa return lena hai!!";
                total = diya - liya;
            } else if (diya < liya) {
                message = "Paisa return dena hai!!";
                total = liya - diya;
            }
            System.out.println(ConsoleColors.YELLOW + "Friend Name: " + friendName
                    + " Total Amount: " + total
                    + " Message: " + message + ConsoleColors.RESET);
        }
    }
}
