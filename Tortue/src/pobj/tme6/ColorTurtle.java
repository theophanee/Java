package pobj.tme6;

public class ColorTurtle extends Turtle implements IColorTurtle {

	private Color color;
	public ColorTurtle() {
		super();
		color = Color.WHITE;
	}
	
	@Override
	public void draw(int x1,int y1,int x2,int y2) {
		System.out.print(x1+" "+y1+" "+x2+" "+y2+" "+color+"\n");
	}
	
	
	
	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

}
