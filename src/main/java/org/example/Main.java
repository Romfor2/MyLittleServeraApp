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
        Permission permission = new Permission("read", "Users", "Description text");
        System.out.println(permission.format());
        System.out.println(permission.matches(".+", "user"));
        Role role = new Role("Administrator", "описание роли");
        System.out.println(role.format());
        role.addPermission(permission);
        System.out.println(role.hasPermission(permission.name(), permission.resource()));
        System.out.println(role.format());
    }
}
