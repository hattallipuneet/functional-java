package stream.collectors;

public class Friend {

    private final int id;
    private final String name;
    private int age;

    public Friend(final String name, final int id, final int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
