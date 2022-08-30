import java.io.IOException;
import java.util.Scanner;

public class Usuario2 extends Thread{
	
	private Mensagem mensagem = null;
	Scanner scanner = new Scanner(System.in);
	
	public Usuario2(Mensagem mensagem) {
		this.mensagem = mensagem;
		this.start();
	}
	
	public void ler() throws  IOException {
		synchronized(this.mensagem) {
			try {
				mensagem.wait();
				System.out.println("\nUsuário 2 recebeu: " + mensagem.getIn().readUTF());
				System.out.print("Usuario 2: ");
				String msg = scanner.nextLine();
				mensagem.getOut().writeUTF(msg);
				mensagem.getOut().flush();
				this.mensagem.notifyAll();
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
