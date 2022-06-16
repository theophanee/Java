package exam;

public abstract class AbstractNode implements INode {

	private double value;
	public AbstractNode() {
		value=0.;
	}
	public double getValue() { return value; }
	public void setValue(double v) {
		value = v;
	}
}
