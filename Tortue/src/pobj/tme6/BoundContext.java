package pobj.tme6;

public class BoundContext implements IContext {

	private int maxX,minX,maxY,minY;
	@Override
	public void drawLine(int x1, int y1, int x2, int y2, Color color) {
		// TODO Auto-generated method stub
		if(x1>maxX)
			maxX=x1;
		if(x1<minX)
			minX=x1;
		if(x2>maxX)
			maxX=x2;
		if(x2<minX)
			minX=x2;
		if(y1>maxY)
			maxY=y1;
		if(y1<minY)
			minY=y1;
		if(y2>maxY)
			maxY=y2;
		if(y2<minY)
			minY=y2;
	}
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMinX() {
		return minX;
	}
	public void setMinX(int minX) {
		this.minX = minX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	public int getMinY() {
		return minY;
	}
	public void setMinY(int minY) {
		this.minY = minY;
	}

}
