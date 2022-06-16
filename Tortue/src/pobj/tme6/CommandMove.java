package pobj.tme6;

public class CommandMove implements ICommand{

	private int len;
	public CommandMove(int len) {
		this.len=len;
	}
	@Override
	public void execute(IColorTurtle turtle) {
		// TODO Auto-generated method stub
		turtle.move(len);
	}

}
