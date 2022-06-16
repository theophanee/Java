package pobj.micros.fs;

public class FileStream implements IStream{

	
	private IFileNode n;
	private int pos;

	public FileStream(IFileNode n) {
		this.n=n;
		pos=0;
	}
	@Override
	public int read() {
		// TODO Auto-generated method stub
		return n.read(pos++);
	}

	@Override
	public void write(int c) {
		// TODO Auto-generated method stub
		n.write(pos++, c);
	}

	@Override
	public void seek(int pos) {
		// TODO Auto-generated method stub
		this.pos=pos;
	}

	@Override
	public int tell() {
		// TODO Auto-generated method stub
		return pos;
	}

}
