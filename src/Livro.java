import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Livro {

	private PipedOutputStream out;
	private PipedInputStream in;
	
	public Livro() throws IOException {
		this.out = new PipedOutputStream();
		this.in = new PipedInputStream(out);
	}

	public PipedInputStream getIn() {
		return in;
	}
	public PipedOutputStream getOut() {
		return out;
	}

}
