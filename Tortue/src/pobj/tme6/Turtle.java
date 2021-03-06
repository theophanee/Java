package pobj.tme6;

public class Turtle implements ITurtle{
	
	private int x,y;
	private int angle;
	private boolean is_up;
	
	public Turtle() {
		x=0;y=0;angle=0;
		is_up=false;
	}

	@Override
	public void move(int length) {
		// TODO Auto-generated method stub
		int oldX=x,oldY=y;
		x= oldX + (int)(length * Math.sin(angle * Math.PI / 180.));
		y=  oldY + (int)(length * Math.cos(angle * Math.PI / 180.));
		if(!is_up)
			draw(oldX,oldY,x,y);
	}

	@Override
	public void turn(int angle) {
		// TODO Auto-generated method stub
		this.angle=angle;
	}
	
	public void draw(int x1,int y1,int x2,int y2) {
		System.out.print(x1+" "+y1+" "+x2+" "+y2+"\n");
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

}
