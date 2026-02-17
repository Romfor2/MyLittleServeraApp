package org.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

record AssignmentMetadata(String assignedBy, String assignedAt, String reason)
{
    static AssignmentMetadata now(String assignedBy, String reason)
    {
        return new AssignmentMetadata(assignedBy, Long.toString(System.currentTimeMillis()), reason);
    }
    String format()
    {
        return this.assignedBy + ' ' + LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(this.assignedAt)), ZoneId.systemDefault()) + ' ' + this.reason;
    }
}
