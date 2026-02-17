package org.example;

public class PermanentAssignment extends AbstractRoleAssignment
{
    boolean revoked = false;

    PermanentAssignment(User user, Role role, AssignmentMetadata metadata) {
        super(user, role, metadata);
    }

    @Override
    public boolean isActive()
    {
        return !revoked;
    }
    @Override
    public String assignmentType()
    {
        return "PERMANENT";
    }
    void revoke()
    {
        revoked = true;
    }
    boolean isRevoked()
    {
        return revoked;
    }
}
