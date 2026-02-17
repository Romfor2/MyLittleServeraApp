package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Role {
    String id;
    String name;
    String description;
    Set<Permission> permissions;
    Role(String name, String description)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.permissions = new HashSet<>();
    }
    Role(String name, String description, Set<Permission> permissions)
    {
        this.id = String.valueOf(name.hashCode());
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }
    void addPermission(Permission permission)
    {
        this.permissions.add(permission);
    }
    void removePermission(Permission permission)
    {
        this.permissions.remove(permission);
    }
    boolean hasPermission(Permission permission)
    {
        return this.permissions.contains(permission);
    }
    boolean hasPermission(String permissionName, String resource)
    {
        for (Permission permission : this.permissions)
            if (permission.matches(permissionName, resource))
                return true;
        return false;
    }
    Set<Permission> getPermissions()
    {
        return Set.copyOf(this.permissions);
    }
    boolean equals(Role x)
    {
        return this.id.equals(x.id);
    }
    public int hashCode()
    {
        return Integer.parseInt(this.id);
    }
    public String toString()
    {
        return name + ": " + description;
    }
    String format()
    {
        String format = "Role: " + this.name + " [ID: " + id + "]\n" +
                this.description + "\n" +
                "Permissions (" + (long) this.permissions.size() + "):";
        for (Permission permission : this.permissions)
            format += "\n - " + permission.format();
        return format;
    }
}
