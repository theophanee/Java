package exam;

public class TestNeuron {

	
	@Test
	public void testOK() {
		INode[] nodes = { new Input(2.) };
		double[] w = { 1. };
		Neuron n = new Neuron(nodes,w);
		n.update();
		assertEquals(n.getValue(),2.);
	}
}
