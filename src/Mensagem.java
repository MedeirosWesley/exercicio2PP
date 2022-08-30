import java.io.*;

public class Mensagem {

	private DataOutputStream out;
	private DataInputStream in;
	
	public Mensagem() throws IOException {
		PipedOutputStream out = new PipedOutputStream();
		PipedInputStream in = new PipedInputStream(out);

		this.out = new DataOutputStream(out);
		this.in = new DataInputStream(in);
	}

	public DataInputStream getIn() {
		return in;
	}

	public DataOutputStream getOut() {
		return out;
	}
	
	
}
