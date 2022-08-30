import java.io.IOException;
import java.util.Scanner;


public class Usuario1 extends Thread{

	private final Mensagem mensagem;
	Scanner scanner = new Scanner(System.in);
	
	public Usuario1(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public void escrever() throws IOException {
		synchronized (this.mensagem) {
			System.out.print("Usuario 1: ");
			String msg = scanner.nextLine();
			this.mensagem.getOut().writeUTF(msg);
			this.mensagem.getOut().flush();
			this.mensagem.notify();
			try {
				this.mensagem.wait();
			}
			catch (InterruptedException e) {
				System.out.println("Interrompido");
			}
			System.out.println("Usuario 1 recebeu: " + this.mensagem.getIn().readUTF());
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
