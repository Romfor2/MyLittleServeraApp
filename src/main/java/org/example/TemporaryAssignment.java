package org.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TemporaryAssignment extends AbstractRoleAssignment
{
    String expiresAt;
    boolean autoRenew;

    TemporaryAssignment(User user, Role role, AssignmentMetadata metadata, String expiresAt) {
        super(user, role, metadata);
        this.expiresAt = expiresAt;
    }

    @Override
    public boolean isActive() {
        return this.autoRenew || this.expiresAt.compareTo(Long.toString(System.currentTimeMillis())) > 0;
    }
    @Override
    public String assignmentType()
    {
        return "TEMPORARY";
    }
    void extend(String newExpirationDate)
    {
        this.expiresAt = newExpirationDate;
    }
    boolean isExpired()
    {
        return !this.isActive();
    }
    String getTimeRemaining()
    {
        return this.isActive() ? String.valueOf(Long.parseLong(this.expiresAt) - System.currentTimeMillis()) : "0";
    }
    @Override
    String summary()
    {
        return  "[PERMANENT] " + this.role.name + " assigned to " + this.user.username() + " by " + this.metadata.assignedBy() + " at "+ this.metadata.assignedAt() + "\n" +
                "Reason: " + this.metadata.reason() + "\n" +
                "Status: " + this.isActive() + "\n" +
                "Date expired: " + LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(this.expiresAt)), ZoneId.systemDefault());
    }
}
