package pobj.micros.fs;

public class FileNode extends Node implements IFileNode {

	private int size;
	private byte[] data;
	
	public FileNode(String name,int size) {
		super(name);this.size=size;
		data=new byte[size];
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public FileNode copy() {
		FileNode res = new FileNode(getName(),size());
		for(int i=0;i<size();i++)
			res.write(i, this.read(i));
		return res;
	}

	@Override
	public int read(int pos) {
		// TODO Auto-generated method stub
		if(pos>=0 && pos<size())
			return data[pos];
		return 255;
	}

	@Override
	public void write(int pos, int c) {
		// TODO Auto-generated method stub
		if(pos>=0 && pos<size())
			data[pos]=(byte)c;
	}

}
