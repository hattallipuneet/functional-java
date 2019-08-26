package partitioning;

public class Student {

    private String name;

    private int totalMarks;

    public Student(final String name, final int totalMarks) {
        this.name = name;
        this.totalMarks = totalMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", totalMarks=" + totalMarks +
                '}';
    }
}
