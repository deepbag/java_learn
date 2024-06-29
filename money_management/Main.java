package java_learn.money_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StorageAccount storageAccount = new StorageAccount();
        Scanner scan = new Scanner(System.in);
        System.out.println(ConsoleColors.PURPLE + "Hi, Welcome to money management!!" + ConsoleColors.RESET);

        while (true) {
            System.out.println(ConsoleColors.CYAN + "1. Add Friend" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "2. Add Transaction [DIYA LIYA]" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "3. List of Friends" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "4. List of Accounts" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "5. Pending Balance" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "0. Exit" + ConsoleColors.RESET);

            String input = scan.nextLine();
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scan.nextLine();
                    Friend friend = new Friend(name, phone);
                    storageAccount.addFriend(friend);
                    break;
                case 2:
                    System.out.print("Enter Phone: ");
                    String friendphone = scan.nextLine();
                    System.out.print("Enter Amount: ");
                    int amount = Integer.parseInt(scan.nextLine());
                    System.out.print("Enter Transaction Type: ");
                    String type = scan.nextLine().toUpperCase();
                    Transaction transaction = new Transaction(amount, type);
                    StorageAccount.addTransaction(friendphone, transaction);
                    break;
                case 3:
                    storageAccount.getAllFriends();
                    break;
                case 4:
                    storageAccount.getAllAccounts();
                    break;
                case 5:
                    storageAccount.getTotalPendingBalance();
                    break;
                case 0:
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    scan.close();
                    System.exit(0);
                    break;
            }
        }

    }
}
