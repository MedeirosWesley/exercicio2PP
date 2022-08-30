import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Random;

public class Escritor extends Thread{
	private Livro livro = null;
	private Random rand = new Random();

	private DataOutputStream out;
	
	public Escritor(Livro livro, PipedOutputStream os) {
		this.out = new DataOutputStream(os);
		this.livro = livro;
	}

	public void escrever() throws IOException {
		synchronized (this.livro) {
			char letra = (char) (rand.nextInt(26) + 'a');
			this.out.writeChar(letra);
			this.out.flush();
			this.livro.notifyAll();
			try {
				this.livro.wait();
			}
			catch (InterruptedException e) {
				System.out.println("Interrompido");
			}
			
		}
	}
	
	public void run() {
		while(true) {
			try {
				escrever();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
