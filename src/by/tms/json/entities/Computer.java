package by.tms.json.entities;

import by.tms.json.entities.characteristicsofcomputer.ComputerComponent;
import by.tms.json.entities.characteristicsofcomputer.Size;
import by.tms.json.entities.characteristicsofcomputer.Type;

import java.util.List;
import java.util.Objects;

public class Computer {

    private List<ComputerComponent> components;
    private Type type;
    private Size size;

    public Computer() {
    }

    public Computer(List<ComputerComponent> components, Type type, Size size) {
        this.components = components;
        this.type = type;
        this.size = size;
    }

    public List<ComputerComponent> getComponents() {
        return components;
    }

    public void setComponents(List<ComputerComponent> components) {
        this.components = components;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(components, computer.components) && Objects.equals(type, computer.type) && Objects.equals(size, computer.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components, type, size);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "components=" + components +
                ", type=" + type +
                ", size=" + size +
                '}';
    }
}
