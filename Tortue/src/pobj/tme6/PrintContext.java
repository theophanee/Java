package pobj.tme6;

public class PrintContext implements IContext{

	@Override
	public void drawLine(int x1, int y1, int x2, int y2, Color color) {
		// TODO Auto-generated method stub
		System.out.print(x1+" "+y1+" "+x2+" "+y2+" "+color+"\n");
	}

}
