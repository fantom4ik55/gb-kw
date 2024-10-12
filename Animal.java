import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private List<String> commands;

    public Animal(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getName() {
        return name;
    }
}
