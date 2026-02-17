package org.example;

record User(String username, String fullName, String email)
{
    static User create(String username, String fullName, String email)
    {
        if (!username.matches("[A-Za-z0-9_]+"))
            throw new IllegalArgumentException("имя должено содержать только латинские буквы, цифры и подчёркивание");
        if (!username.matches("\\w{3,20}"))
            throw new IllegalArgumentException("имя должено быть от 3 до 20 символов");
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}"))
            throw new IllegalArgumentException("почта должена соответствовать базовому формату email");
        return new User(username, fullName, email);
    }
    String format()
    {
        return this.username + " (" + this.fullName + ") <" + this.email + '>';
    }
}
