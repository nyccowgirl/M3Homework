import java.util.Objects;

public class Computer implements Comparable<Computer> {
    private static final int DEFAULT_MEMORY = 128;

    private String name;
    private int memorySize;

    public Computer(String name, int memorySize) {
        this.name = name;
        this.memorySize = memorySize;
    }

    public Computer(String name) {
        this(name, DEFAULT_MEMORY);
    }

    public String getName() {
        return name;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\tMemory Size: " + Integer.toString(memorySize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return name.equalsIgnoreCase(computer.name) &&
                (memorySize == computer.memorySize);
    }

    @Override
    public int compareTo(Computer other) {
        int nameComparison = this.name.compareTo(other.name);

        if (nameComparison == 0) {
            if (this.memorySize < other.memorySize) {
                return -1;
            } else if (this.memorySize > other.memorySize) {
                return 1;
            } else { // this.memorySize == other.memorySize
                return 0;
            }
        } else { // names are different
            return nameComparison;
        }
    }
}
