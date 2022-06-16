package pobj.tme6;

public class Color {

	private int r,g,b;
	
	public static final Color BLACK = new Color(0,0,0);
	public static final Color RED = new Color(255,0,0);
	public static final Color BLUE = new Color(0,0,255);
	public static final Color WHITE = new Color(255,255,255);
	public static final Color CYAN = new Color(0,255,255);

	public Color(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public static Color rgb(int r, int g, int b) {
		return new Color(r,g,b);
	}
	
	public int getR() { return r; }
	public int getG() { return g; }
	public int getB() { return b; }
	
	@Override
	public String toString() {
		return String.format("0x%02x%02x%02xff", r, g, b);
	}
}
