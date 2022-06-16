package pobj.tme6;

public class CommandSetColor implements ICommand {

	private Color color;
	public CommandSetColor(Color color) {
		this.color=color;
	}
	@Override
	public void execute(IColorTurtle turtle) {
		// TODO Auto-generated method stub
		turtle.setColor(color);
	}

}
