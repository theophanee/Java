package pobj.tme6;

public class ContextTurtle implements IColorTurtle {

	private int x,y;
	private int angle;
	private boolean is_up;
	private IContext c;
	private Color color;
	
	public ContextTurtle(IContext c) {
		this.c=c;
		x=0;y=0;angle=0;
		is_up=false;
		color=Color.WHITE;
	}

	@Override
	public void move(int length) {
		// TODO Auto-generated method stub
		int oldX=x,oldY=y;
		x= oldX + (int)(length * Math.sin(angle * Math.PI / 180.));
		y=  oldY + (int)(length * Math.cos(angle * Math.PI / 180.));
		if(!is_up)
			c.drawLine(oldX,oldY,x,y,color);
	}

	@Override
	public void turn(int angle) {
		// TODO Auto-generated method stub
		this.angle=angle;
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		is_up=true;
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		is_up=false;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	

}
