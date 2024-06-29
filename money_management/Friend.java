package java_learn.money_management;

import java.util.UUID;

public class Friend {
    private String id;
    private String name;
    private String phone;

    public Friend(String name, String phone) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public String getFriendId() {
        return id;
    }

    public String getFriendName() {
        return name;
    }

    // @Override
    // public String toString() {
    // return "{" +
    // "id:'" + id + '\'' +
    // ", name:'" + name + '\'' +
    // ", phone:'" + phone + '\'' +
    // '}';
    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ConsoleColors.CYAN).append("Friend Details:\n").append(ConsoleColors.RESET);
        sb.append(ConsoleColors.YELLOW).append(String.format("%-40s %-20s %-15s\n", "ID", "Name", "Phone"))
                .append(ConsoleColors.RESET);
        sb.append(ConsoleColors.YELLOW).append("==============================================================\n")
                .append(ConsoleColors.RESET);
        sb.append(String.format("%-40s %-20s %-15s\n",
                ConsoleColors.CYAN + id + ConsoleColors.RESET,
                ConsoleColors.GREEN + name + ConsoleColors.RESET,
                ConsoleColors.YELLOW + phone + ConsoleColors.RESET));
        return sb.toString();
    }
}