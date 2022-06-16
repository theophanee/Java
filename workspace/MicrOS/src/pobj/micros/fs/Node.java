package pobj.micros.fs;

public class Node implements INode {

	private String name;
	public Node(String name) {
		this.name=name;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public INode copy() {
		// TODO Auto-generated method stub
		return new Node(getName());
	}

}
