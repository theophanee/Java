package pobj.tme6;

public class CommandTurn implements ICommand{

	private int angle;
	public CommandTurn(int angle) {
		this.angle=angle;
	}
	@Override
	public void execute(IColorTurtle turtle) {
		// TODO Auto-generated method stub
		turtle.turn(angle);
	}

}
