package org.example;

record AssignmentMetadata(String assignedBy, String assignedAt, String reason)
{
    static AssignmentMetadata now(String assignedBy, String reason)
    {
        return new AssignmentMetadata(assignedBy, Long.toString(System.currentTimeMillis()), reason);
    }
    String format()
    {
        return this.assignedBy + ' ' + this.assignedAt + ' ' + this.reason;
    }
}
