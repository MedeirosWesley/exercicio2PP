import java.io.DataInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Leitor extends Thread{

	private Livro livro = null;
	private DataInputStream in;
	
	public Leitor(Livro livro) {
		this.livro = livro;
		in = new DataInputStream(livro.getIn());
		this.start();
		synchronized (this.livro) {
			try {
				this.livro.wait();
			}
			catch (InterruptedException e) {
				System.out.println("Interrompido");
			}
		}
	}
	
	public void ler() throws IOException {
		synchronized(this.livro) {
			try {
				this.livro.notifyAll();
				this.livro.wait();
				System.out.println(this.in.readChar());
			}
			catch (InterruptedException e) {
				System.out.println("Interrompido");
			}

		}
	}
	
	public void run() {
		while(true) {
			try {
				ler();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
