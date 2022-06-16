package exam;

public class Neuron extends AbstractNode{

	private INode[] nodes;
	private double[] weights;
	public Neuron(INode[] n , double[] w) {
		if(w.length!=n.length || w.length==0 || n.length==0 )
			throw new IllegalArgumentException();
		nodes = n;
		weights = w;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		double res =0.;
		for(int i=0;i<nodes.length;i++)
			res += nodes[i].getValue()*weights[i];
		setValue(Math.max(res, 0.));
	}

}
