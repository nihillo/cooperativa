package view.command;

public abstract class Command {
	
	protected Object receiver;
	
	public Command(Object receiver) {
		this.receiver = receiver;
	}
	
	public abstract void execute();
}
