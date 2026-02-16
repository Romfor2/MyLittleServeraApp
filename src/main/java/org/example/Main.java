package org.example;

public class Main {
    static void main() {
        String name = "roby";
        String fullname = "dolly rob";
        String email = "roby777@dorry.net";
        User user = User.create(name, fullname, email);
        System.out.println(user.format());
        //User user1 = User.create("r", fullname, email);
        //User user2 = User.create("#", fullname, email);
        //User user3 = User.create(name, fullname, "email");
    }
}
