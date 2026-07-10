interface Command {
    void execute();
}

class Light {
    public void turnOn() { System.out.println("Light is On"); }
    public void turnOff() { System.out.println("Light is Off"); }
}

class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light l) { this.light = l; }
    public void execute() { light.turnOn(); }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light l) { this.light = l; }
    public void execute() { light.turnOff(); }
}

class RemoteControl {
    private Command command;
    public void setCommand(Command c) { this.command = c; }
    public void pressButton() { command.execute(); }
}

public class CommandDemo {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl rc = new RemoteControl();
        rc.setCommand(new LightOnCommand(light));
        rc.pressButton();
    }
}