package pobj.micros.fs;

import java.util.HashMap;
import java.util.*;

public class DirectoryNode extends Node implements IDirectoryNode{

	private Map<String,INode> dir;
	
	public DirectoryNode(String name) {
		super(name);
		dir = new HashMap<String,INode>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addChild(INode node) {
		// TODO Auto-generated method stub
		if(dir.containsKey(node.getName()))
				return false;
		dir.put(node.getName(), node);
		return true;
	}
	
	@Override 
	public DirectoryNode copy() {
		DirectoryNode res = new DirectoryNode(getName());
		for(Map.Entry<String,INode> e : dir.entrySet())
			res.addChild(e.getValue().copy());
		return res;
	}

	@Override
	public INode getChild(String name) {
		// TODO Auto-generated method stub
		return dir.get(name);
	}

	@Override
	public List<String> getChildren() {
		// TODO Auto-generated method stub
		List<String> res = new ArrayList<>();
		for(Map.Entry<String,INode> e : dir.entrySet())
			res.add(e.getKey());
		return res;
	}

}
