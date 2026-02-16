package org.example;

record Permission(String name, String resource, String description)
{
    Permission(String name, String resource, String description)
    {
        this.name = name.replaceAll("\\s+", "").toUpperCase();
        this.resource = resource.toLowerCase();
        if (description.isEmpty())
            throw new IllegalArgumentException("разрешение не может быть пустым");
        this.description = description;
    }
    String format()
    {
        return this.name + " on " + resource + ": " + this.description;
    }
    boolean matches(String namePattern, String resourcePatten)
    {
        return name.matches(namePattern) && resourcePatten.matches(resourcePatten);
    }
}
