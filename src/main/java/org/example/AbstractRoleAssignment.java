package org.example;

import java.util.UUID;

public abstract class AbstractRoleAssignment implements RoleAssignment
{
    String assignmentId;
    User user;
    Role role;
    AssignmentMetadata metadata;
    AbstractRoleAssignment(User user, Role role, AssignmentMetadata metadata)
    {
        this.assignmentId = UUID.randomUUID().toString();
        this.user = user;
        this.role = role;
        this.metadata = metadata;
    }

    boolean equals(AbstractRoleAssignment x)
    {
        return this.assignmentId.equals(x.assignmentId);
    }
    public int hashCode()
    {
        return Integer.parseInt(this.assignmentId);
    }
    String summary()
    {
        return  "[PERMANENT] " + this.role.name + " assigned to " + this.user.username() + " by " + this.metadata.assignedBy() + " at "+ this.metadata.assignedAt() + "\n" +
                "Reason: " + this.metadata.reason() + "\n" +
                "Status: " + this.isActive();
    }

    public abstract boolean isActive();
    public abstract String assignmentType();
    public String assignmentId()
    {
        return this.assignmentId;
    }
    public User user()
    {
        return this.user;
    }
    public Role role()
    {
        return this.role;
    }
    public AssignmentMetadata metadata()
    {
        return this.metadata;
    }
}
