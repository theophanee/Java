package pobj.tme6;

public class ColorTurtleAdapter implements IColorTurtle{

	private ITurtle it;
	public ColorTurtleAdapter(ITurtle it) {
		this.it=it;
	}
	@Override
	public void move(int length) {
		// TODO Auto-generated method stub
		it.move(length);
	}

	@Override
	public void turn(int angle) {
		// TODO Auto-generated method stub
		it.turn(angle);
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		it.up();
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		it.down();
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

}
