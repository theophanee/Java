package exam;

import java.util.*;

public class NeuronBuilder {

	private Map<INode,Double> pred = new HashMap<>();
	public void addPred(INode n,double d) {
		pred.put(n, d);
	}
	public Neuron getResult() {
		INode[] n = new INode[pred.size()];
		double[] d = new double[pred.size()];
		int i =0;
		for(Map.Entry<INode,Double> e : pred.entrySet()) {
			n[i] = e.getKey();
			d[i] = e.getValue();
			i++;
		}
		return new Neuron(n,d);
	}
	public boolean isValid() {
		return pred.size()!=0;
	}
}
