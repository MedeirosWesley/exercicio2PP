import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
//////////////////////////////////////////////////////////////////////////
//EXERCICIO 1
//////////////////////////////////////////////////////////////////////////
//        long start = System.currentTimeMillis()/1000;
//        boolean isPrime = true;
//        for(int i=1; i<=99999; i++){
//            for(int n=2; n<= i/2; n++){
//                if(i % n == 0) {
//                    isPrime = false;
//                }
//            }
////            if(isPrime) System.out.println(i);
//            isPrime = true;
//        }
//        long end = System.currentTimeMillis()/1000;
//        System.out.println("\n//////////////////////////////\n" + (end - start) + " segundos");
//
//
//
//        start = System.currentTimeMillis();
//        int i=0,t=0;
//        for(; i<=99999; i+=1000, t++){
//            Prime prime = new Prime(i,t);
//            prime.start();
//        }
//        end = System.currentTimeMillis();
//        System.out.println("\n//////////////////////////////\n" + (end - start) + " milisegundos");

//////////////////////////////////////////////////////////////////////////
//EXERCICIO 6
//////////////////////////////////////////////////////////////////////////
//        Livro livro = new Livro();
//
//        new Leitor(livro);
//        new Escritor(livro).start();
//////////////////////////////////////////////////////////////////////////
//EXERCICIO 5
//////////////////////////////////////////////////////////////////////////
        Mensagem mensagem = new Mensagem();

        new Usuario2(mensagem);
        new Usuario1(mensagem).start();
    }
}
